package defpackage;

import java.util.ArrayList;

/* renamed from: vf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class vf4 implements Runnable {
    public final /* synthetic */ lg4 f;
    public final /* synthetic */ Runnable g;

    public vf4(lg4 lg4, Runnable runnable) {
        this.f = lg4;
        this.g = runnable;
    }

    public final void run() {
        this.f.R();
        lg4 lg4 = this.f;
        Runnable runnable = this.g;
        lg4.U();
        if (lg4.n == null) {
            lg4.n = new ArrayList();
        }
        lg4.n.add(runnable);
        this.f.Q();
    }
}
