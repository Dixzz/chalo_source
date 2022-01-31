package defpackage;

import app.zophop.models.Stop;
import java.util.Objects;

/* renamed from: vw0  reason: default package */
/* compiled from: TripFragment */
public class vw0 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ Stop g;
    public final /* synthetic */ tw0 h;

    public vw0(tw0 tw0, String str, Stop stop) {
        this.h = tw0;
        this.f = str;
        this.g = stop;
    }

    public void run() {
        tw0 tw0 = this.h;
        String str = this.f;
        Stop stop = this.g;
        int i = tw0.z;
        Objects.requireNonNull(tw0);
        if (stop != null) {
            xt.f3961a.N().e(stop, str, new uw0(tw0, stop));
        }
        tw0 tw02 = this.h;
        tw02.o.postDelayed(tw02.q, 5000);
    }
}
