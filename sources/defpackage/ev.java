package defpackage;

import app.zophop.alarm.SubscriberService;
import app.zophop.models.LiveRouteData;
import app.zophop.models.Route;
import app.zophop.models.StreamInfo;
import defpackage.mt0;
import defpackage.yj1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: ev  reason: default package */
/* compiled from: SubscriberService */
public class ev implements yj1.b<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Route f1032a;
    public final /* synthetic */ SubscriberService b;

    public ev(SubscriberService subscriberService, Route route) {
        this.b = subscriberService;
        this.f1032a = route;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            LiveRouteData liveRouteData = new LiveRouteData(this.f1032a);
            List<StreamInfo> L = ui1.L(jSONObject);
            ArrayList arrayList = new ArrayList();
            liveRouteData.clearStreams();
            Iterator it = ((ArrayList) L).iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                StreamInfo streamInfo = (StreamInfo) it.next();
                SubscriberService subscriberService = this.b;
                Route route = this.f1032a;
                int i = SubscriberService.q;
                Objects.requireNonNull(subscriberService);
                String nextStopId = streamInfo.getNextStopId();
                int i2 = 0;
                while (true) {
                    if (i2 >= route.getStopSequence().size()) {
                        i2 = -1;
                        break;
                    } else if (route.getStopSequence().get(i2).getId().equals(nextStopId)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                int i3 = i2 - 1;
                if (i3 >= 0) {
                    i2 = i3;
                }
                if (!vn.R0(streamInfo.getTimeStamp(), streamInfo.getOriginalEtaSec(), true) && i2 >= 0) {
                    z = true;
                }
                if (z) {
                    arrayList.add(streamInfo);
                    liveRouteData.addStreamInfo(streamInfo);
                }
            }
            if (arrayList.size() > 0) {
                liveRouteData.setFirebaseResponse(mt0.h.SUCCESS);
                if (this.f1032a.getStopSequence().indexOf(this.b.n) < liveRouteData.getFirstLiveStopPosition()) {
                    this.b.k("bus passed");
                    SubscriberService.f(this.b, "bus passed");
                    return;
                }
                this.b.k("bus exists");
                this.b.i(false);
                return;
            }
            SubscriberService subscriberService2 = this.b;
            int i4 = SubscriberService.q;
            subscriberService2.k("no streams");
            SubscriberService.f(this.b, "no streams");
        } catch (JSONException unused) {
        }
    }
}
