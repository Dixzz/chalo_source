package defpackage;

/* renamed from: kj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class kj4 implements Runnable {
    public final /* synthetic */ yi4 f;
    public final /* synthetic */ lj4 g;

    public kj4(lj4 lj4, yi4 yi4) {
        this.g = lj4;
        this.f = yi4;
    }

    public final void run() {
        synchronized (this.g.b) {
            ti4<TResult> ti4 = this.g.c;
            if (ti4 != null) {
                ti4.onComplete(this.f);
            }
        }
    }
}
