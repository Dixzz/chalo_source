package defpackage;

/* renamed from: hz5  reason: default package */
/* compiled from: AsyncPoster */
public class hz5 implements Runnable {
    public final oz5 f = new oz5();
    public final jz5 g;

    public hz5(jz5 jz5) {
        this.g = jz5;
    }

    public void run() {
        nz5 b = this.f.b();
        if (b != null) {
            this.g.d(b);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
