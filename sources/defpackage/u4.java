package defpackage;

import android.app.Activity;

/* renamed from: u4  reason: default package */
/* compiled from: ActivityCompat */
public class u4 implements Runnable {
    public final /* synthetic */ Activity f;

    public u4(Activity activity) {
        this.f = activity;
    }

    public void run() {
        if (!this.f.isFinishing() && !w4.b(this.f)) {
            this.f.recreate();
        }
    }
}
