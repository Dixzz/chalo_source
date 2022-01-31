package defpackage;

import android.os.Looper;

/* renamed from: dd3  reason: default package */
public final class dd3 implements Runnable {
    public final /* synthetic */ cd3 f;

    public dd3(cd3 cd3) {
        this.f = cd3;
    }

    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f.f551a.d().b(this);
            return;
        }
        boolean d = this.f.d();
        this.f.c = 0;
        if (d) {
            this.f.c();
        }
    }
}
