package defpackage;

/* renamed from: sx4  reason: default package */
public final class sx4 implements Runnable {
    public final /* synthetic */ ey4 f;
    public final /* synthetic */ tx4 g;

    public sx4(tx4 tx4, ey4 ey4) {
        this.g = tx4;
        this.f = ey4;
    }

    public final void run() {
        synchronized (this.g.b) {
            nx4<ResultT> nx4 = this.g.c;
            if (nx4 != null) {
                nx4.a(this.f);
            }
        }
    }
}
