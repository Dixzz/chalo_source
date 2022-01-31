package defpackage;

import android.content.Intent;

/* renamed from: kt4  reason: default package */
public final /* synthetic */ class kt4 implements Runnable {
    public final lt4 f;
    public final Intent g;

    public kt4(lt4 lt4, Intent intent) {
        this.f = lt4;
        this.g = intent;
    }

    public final void run() {
        lt4 lt4 = this.f;
        lt4.b.a(lt4.c, this.g);
    }
}
