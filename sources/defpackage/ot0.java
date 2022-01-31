package defpackage;

import app.zophop.models.Stop;
import app.zophop.models.VehicleInfo;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: ot0  reason: default package */
/* compiled from: BusRouteFragment */
public class ot0 implements Runnable {
    public final /* synthetic */ Stop f;
    public final /* synthetic */ int g;
    public final /* synthetic */ mt0 h;

    public ot0(mt0 mt0, Stop stop, int i) {
        this.h = mt0;
        this.f = stop;
        this.g = i;
    }

    public void run() {
        Stop stop = this.f;
        if (stop != null) {
            mt0 mt0 = this.h;
            mt0.B = true;
            dk0 dk0 = mt0.h;
            int i = mt0.D;
            int i2 = this.g;
            Objects.requireNonNull(dk0);
            try {
                if (dk0.k.f3891a.get(stop.getId()) != null) {
                    xt.t1 t1Var = xt.f3961a;
                    String lowerCase = t1Var.k().d().getName().toLowerCase();
                    List<VehicleInfo> z = x61.z(dk0.k.f3891a.get(stop.getId()));
                    if (((ArrayList) z).size() > 0) {
                        t1Var.c().q(lowerCase, dk0.u.getRouteId(), stop.getId(), z, i, i2);
                    }
                }
            } catch (Exception e) {
                e.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
            mt0 mt02 = this.h;
            mt02.o.postDelayed(mt02.N, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD);
        }
    }
}
