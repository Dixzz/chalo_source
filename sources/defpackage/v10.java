package defpackage;

import android.util.Pair;
import app.zophop.features.GeoFenceService;
import app.zophop.models.http_response.SummaryResponse;
import app.zophop.models.http_response.TripSummary;
import app.zophop.pubsub.eventbus.events.SummaryResponseEvent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: v10  reason: default package */
/* compiled from: GeoFenceService */
public class v10 implements ValueEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SummaryResponse f3582a;
    public final /* synthetic */ SummaryResponseEvent b;
    public final /* synthetic */ GeoFenceService c;

    public v10(GeoFenceService geoFenceService, SummaryResponse summaryResponse, SummaryResponseEvent summaryResponseEvent) {
        this.c = geoFenceService;
        this.f3582a = summaryResponse;
        this.b = summaryResponseEvent;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError databaseError) {
        GeoFenceService geoFenceService = this.c;
        String id = this.f3582a.getStop().getId();
        int i = GeoFenceService.p;
        geoFenceService.g(id, "databaseError");
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot != null) {
            Iterable<DataSnapshot> children = dataSnapshot.getChildren();
            HashMap hashMap = new HashMap();
            for (DataSnapshot dataSnapshot2 : children) {
                j10 e = ii1.e(dataSnapshot2);
                if (e.a() < 7200) {
                    hashMap.put(dataSnapshot2.getKey(), e.c().get(0));
                } else if (e.b().size() != 0) {
                    hashMap.put(dataSnapshot2.getKey(), e.b().get(0));
                }
            }
            HashMap hashMap2 = new HashMap();
            for (TripSummary tripSummary : this.f3582a.getTripSummary()) {
                String routeId = tripSummary.getRouteId();
                if (!hashMap2.containsKey(routeId)) {
                    hashMap2.put(routeId, tripSummary);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (hashMap.size() > 0) {
                for (String str : hashMap2.keySet()) {
                    if (hashMap.containsKey(str)) {
                        arrayList.add(new Pair((TripSummary) hashMap2.get(str), (i10) hashMap.get(str)));
                    }
                }
                if (arrayList.size() > 0) {
                    GeoFenceService.f(this.c, this.f3582a.getStop(), this.b, pc1.e(arrayList, new ArrayList()));
                    return;
                }
                GeoFenceService geoFenceService = this.c;
                String id = this.f3582a.getStop().getId();
                int i = GeoFenceService.p;
                geoFenceService.g(id, "no eta");
                return;
            }
            GeoFenceService geoFenceService2 = this.c;
            String id2 = this.f3582a.getStop().getId();
            int i2 = GeoFenceService.p;
            geoFenceService2.g(id2, "no eta");
            return;
        }
        GeoFenceService geoFenceService3 = this.c;
        String id3 = this.f3582a.getStop().getId();
        int i3 = GeoFenceService.p;
        geoFenceService3.g(id3, "no data snapshot");
    }
}
