package defpackage;

import android.util.Pair;
import app.zophop.features.GeoFenceService;
import app.zophop.models.http_response.SummaryResponse;
import app.zophop.models.http_response.TripSummary;
import app.zophop.pubsub.eventbus.events.SummaryResponseEvent;
import defpackage.yj1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: w10  reason: default package */
/* compiled from: GeoFenceService */
public class w10 implements yj1.b<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SummaryResponse f3704a;
    public final /* synthetic */ SummaryResponseEvent b;
    public final /* synthetic */ GeoFenceService c;

    public w10(GeoFenceService geoFenceService, SummaryResponse summaryResponse, SummaryResponseEvent summaryResponseEvent) {
        this.c = geoFenceService;
        this.f3704a = summaryResponse;
        this.b = summaryResponseEvent;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                j10 i = ii1.i(jSONObject.getJSONObject(next));
                if (i.a() < 7200) {
                    hashMap.put(next, i.c().get(0));
                } else if (i.b().size() != 0) {
                    hashMap.put(next, i.b().get(0));
                }
            }
            HashMap hashMap2 = new HashMap();
            for (TripSummary tripSummary : this.f3704a.getTripSummary()) {
                String routeId = tripSummary.getRouteId();
                if (!hashMap2.containsKey(routeId)) {
                    hashMap2.put(routeId, tripSummary);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (hashMap.size() > 0) {
                for (String str2 : hashMap2.keySet()) {
                    if (hashMap.containsKey(str2)) {
                        arrayList.add(new Pair((TripSummary) hashMap2.get(str2), (i10) hashMap.get(str2)));
                    }
                }
                if (arrayList.size() > 0) {
                    GeoFenceService.f(this.c, this.f3704a.getStop(), this.b, pc1.e(arrayList, new ArrayList()));
                    return;
                }
                GeoFenceService geoFenceService = this.c;
                String id = this.f3704a.getStop().getId();
                int i2 = GeoFenceService.p;
                geoFenceService.g(id, "no eta");
                return;
            }
            GeoFenceService geoFenceService2 = this.c;
            String id2 = this.f3704a.getStop().getId();
            int i3 = GeoFenceService.p;
            geoFenceService2.g(id2, "no eta");
        } catch (JSONException unused) {
        }
    }
}
