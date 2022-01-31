package defpackage;

import app.zophop.models.VehicleInfo;
import defpackage.xt;
import java.util.Map;
import java.util.Objects;

/* renamed from: et0  reason: default package */
/* compiled from: AllResultsFragment */
public class et0 implements Runnable {
    public final /* synthetic */ dt0 f;

    public et0(dt0 dt0) {
        this.f = dt0;
    }

    public void run() {
        dt0 dt0 = this.f;
        if (dt0.w != null) {
            Objects.requireNonNull(dt0);
            boolean z = false;
            for (Map.Entry<String, VehicleInfo> entry : dt0.A.entrySet()) {
                if (!dt0.t.containsKey(entry.getKey())) {
                    dt0.t.put(entry.getKey(), entry.getValue());
                    z = true;
                }
            }
            dt0.y *= 2;
            if (!dt0.u && dt0.A.size() != 0) {
                xt.t1 t1Var = xt.f3961a;
                t1Var.Z().g(dt0.A);
                t1Var.Z().e(dt0.v);
                Runnable a2 = t1Var.Z().a();
                if (a2 != null) {
                    a2.run();
                    dt0.u = true;
                }
            } else if (dt0.u && dt0.A.size() != 0 && z) {
                xt.t1 t1Var2 = xt.f3961a;
                t1Var2.Z().g(dt0.A);
                t1Var2.Z().f();
            }
            dt0 dt02 = this.f;
            dt02.w.postDelayed(dt02.x, (long) (dt02.y * 500));
        }
    }
}
