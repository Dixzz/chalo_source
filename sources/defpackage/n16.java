package defpackage;

import android.content.Context;

/* renamed from: n16  reason: default package */
/* compiled from: TimeBasedFileRollOverRunnable */
public class n16 implements Runnable {
    public final Context f;
    public final k16 g;

    public n16(Context context, k16 k16) {
        this.f = context;
        this.g = k16;
    }

    public void run() {
        try {
            j06.i(this.f);
            if (!this.g.rollFileOver()) {
                this.g.cancelTimeBasedFileRollOver();
            }
        } catch (Exception unused) {
            j06.i(this.f);
        }
    }
}
