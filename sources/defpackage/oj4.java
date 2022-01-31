package defpackage;

/* renamed from: oj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class oj4 implements Runnable {
    public final /* synthetic */ yi4 f;
    public final /* synthetic */ pj4 g;

    public oj4(pj4 pj4, yi4 yi4) {
        this.g = pj4;
        this.f = yi4;
    }

    public final void run() {
        synchronized (this.g.b) {
            vi4<? super TResult> vi4 = this.g.c;
            if (vi4 != null) {
                vi4.onSuccess((Object) this.f.m());
            }
        }
    }
}
