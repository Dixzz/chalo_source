package defpackage;

import app.zophop.alarm.SubscriberService;
import app.zophop.models.LiveRouteData;
import app.zophop.models.Route;
import app.zophop.models.StreamInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import defpackage.mt0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: dv  reason: default package */
/* compiled from: SubscriberService */
public class dv implements ValueEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Route f891a;
    public final /* synthetic */ SubscriberService b;

    public dv(SubscriberService subscriberService, Route route) {
        this.b = subscriberService;
        this.f891a = route;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError databaseError) {
        SubscriberService subscriberService = this.b;
        int i = SubscriberService.q;
        subscriberService.k("DatabaseError-Streams");
        this.b.i(false);
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot dataSnapshot) {
        LiveRouteData liveRouteData = new LiveRouteData(this.f891a);
        List<StreamInfo> M = ui1.M(dataSnapshot);
        ArrayList arrayList = new ArrayList();
        liveRouteData.clearStreams();
        Iterator it = ((ArrayList) M).iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            StreamInfo streamInfo = (StreamInfo) it.next();
            String nextStopId = streamInfo.getNextStopId();
            int i = 0;
            while (true) {
                if (i >= this.f891a.getStopSequence().size()) {
                    i = -1;
                    break;
                } else if (this.f891a.getStopSequence().get(i).getId().equals(nextStopId)) {
                    break;
                } else {
                    i++;
                }
            }
            int i2 = i - 1;
            if (i2 >= 0) {
                i = i2;
            }
            if (!vn.R0(streamInfo.getTimeStamp(), streamInfo.getOriginalEtaSec(), true) && i >= 0) {
                z = true;
            }
            if (z) {
                arrayList.add(streamInfo);
                liveRouteData.addStreamInfo(streamInfo);
            }
        }
        if (arrayList.size() > 0) {
            liveRouteData.setFirebaseResponse(mt0.h.SUCCESS);
            if (this.f891a.getStopSequence().indexOf(this.b.n) < liveRouteData.getFirstLiveStopPosition()) {
                this.b.k("bus passed");
                SubscriberService.f(this.b, "bus passed");
                return;
            }
            this.b.k("bus exists");
            this.b.i(false);
            return;
        }
        SubscriberService subscriberService = this.b;
        int i3 = SubscriberService.q;
        subscriberService.k("no streams");
        SubscriberService.f(this.b, "no streams");
    }
}
