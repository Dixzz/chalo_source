package defpackage;

import app.zophop.models.VehicleInfo;
import defpackage.xt;
import java.util.Map;
import java.util.Objects;

/* renamed from: sw0  reason: default package */
/* compiled from: StopBasedTripPlannerResultFragment */
public class sw0 implements Runnable {
    public final /* synthetic */ rw0 f;

    public sw0(rw0 rw0) {
        this.f = rw0;
    }

    public void run() {
        rw0 rw0 = this.f;
        if (rw0.y != null) {
            Objects.requireNonNull(rw0);
            boolean z = false;
            for (Map.Entry<String, VehicleInfo> entry : rw0.C.entrySet()) {
                if (!rw0.v.containsKey(entry.getKey())) {
                    rw0.v.put(entry.getKey(), entry.getValue());
                    z = true;
                }
            }
            rw0.A *= 2;
            if (!rw0.w && rw0.C.size() != 0) {
                xt.t1 t1Var = xt.f3961a;
                t1Var.Z().g(rw0.C);
                t1Var.Z().e(rw0.x);
                Runnable a2 = t1Var.Z().a();
                if (a2 != null) {
                    a2.run();
                    rw0.w = true;
                }
            } else if (rw0.w && rw0.C.size() != 0 && z) {
                xt.t1 t1Var2 = xt.f3961a;
                t1Var2.Z().g(rw0.C);
                t1Var2.Z().f();
            }
            rw0 rw02 = this.f;
            rw02.y.postDelayed(rw02.z, (long) (rw02.A * 500));
        }
    }
}
