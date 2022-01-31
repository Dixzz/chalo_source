package defpackage;

import android.content.ComponentName;

/* renamed from: nf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class nf4 implements Runnable {
    public final /* synthetic */ ComponentName f;
    public final /* synthetic */ lf4 g;

    public nf4(lf4 lf4, ComponentName componentName) {
        this.g = lf4;
        this.f = componentName;
    }

    public final void run() {
        re4.w(this.g.c, this.f);
    }
}
