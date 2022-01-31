package defpackage;

import app.zophop.models.Stop;
import app.zophop.models.VehicleInfo;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ac1  reason: default package */
/* compiled from: ZophopInfoWindow */
public class ac1 implements Runnable {
    public final /* synthetic */ Stop f;
    public final /* synthetic */ int g;
    public final /* synthetic */ bc1 h;

    public ac1(bc1 bc1, Stop stop, int i) {
        this.h = bc1;
        this.f = stop;
        this.g = i;
    }

    public void run() {
        Stop stop = this.f;
        if (stop != null) {
            bc1 bc1 = this.h;
            bc1.k = true;
            int size = bc1.p.getFirebaseStreams().size();
            int i = this.g;
            List<VehicleInfo> z = x61.z(bc1.i.f3891a.get(stop.getId()));
            if (((ArrayList) z).size() > 0) {
                xt.t1 t1Var = xt.f3961a;
                t1Var.c().q(hj1.B(t1Var), bc1.h.getRouteId(), stop.getId(), z, size, i);
            }
            bc1 bc12 = this.h;
            bc12.v.postDelayed(bc12.u, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD);
        }
    }
}
