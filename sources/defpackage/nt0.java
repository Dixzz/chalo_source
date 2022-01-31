package defpackage;

import android.os.Handler;
import app.zophop.models.Stop;
import java.util.Set;

/* renamed from: nt0  reason: default package */
/* compiled from: BusRouteFragment */
public class nt0 implements Runnable {
    public final /* synthetic */ Stop f;
    public final /* synthetic */ mt0 g;

    public nt0(mt0 mt0, Stop stop) {
        this.g = mt0;
        this.f = stop;
    }

    public void run() {
        mt0 mt0;
        Set<String> set;
        long j;
        Stop stop = this.f;
        if (stop != null && (set = (mt0 = this.g).w) != null) {
            boolean z = !mt0.y || set.contains(stop.getId());
            this.g.b(this.f, z);
            mt0 mt02 = this.g;
            Handler handler = mt02.o;
            Runnable runnable = mt02.M;
            if (z) {
                j = 5000;
            } else {
                j = (long) mt02.z;
            }
            handler.postDelayed(runnable, j);
            this.g.w.add(this.f.getId());
        }
    }
}
