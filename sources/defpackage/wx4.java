package defpackage;

/* renamed from: wx4  reason: default package */
public final class wx4 implements Runnable {
    public final /* synthetic */ ey4 f;
    public final /* synthetic */ xx4 g;

    public wx4(xx4 xx4, ey4 ey4) {
        this.g = xx4;
        this.f = ey4;
    }

    public final void run() {
        synchronized (this.g.b) {
            px4<? super ResultT> px4 = this.g.c;
            if (px4 != null) {
                px4.onSuccess((Object) this.f.e());
            }
        }
    }
}
