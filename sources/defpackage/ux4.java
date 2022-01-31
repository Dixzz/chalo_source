package defpackage;

/* renamed from: ux4  reason: default package */
public final class ux4 implements Runnable {
    public final /* synthetic */ ey4 f;
    public final /* synthetic */ vx4 g;

    public ux4(vx4 vx4, ey4 ey4) {
        this.g = vx4;
        this.f = ey4;
    }

    public final void run() {
        Exception exc;
        synchronized (this.g.b) {
            ox4 ox4 = this.g.c;
            if (ox4 != null) {
                ey4 ey4 = this.f;
                synchronized (ey4.f1045a) {
                    exc = ey4.e;
                }
                ox4.onFailure(exc);
            }
        }
    }
}
