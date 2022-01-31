package defpackage;

/* renamed from: z53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class z53 implements Runnable {
    public final /* synthetic */ b63 f;
    public final /* synthetic */ a63 g;

    public z53(a63 a63, b63 b63) {
        this.g = a63;
        this.f = b63;
    }

    public final void run() {
        synchronized (this.g.f.g) {
            if (!this.g.f.g.isEmpty()) {
                this.f.a(this.g.f.g.get(0), new Object[0]);
            }
        }
    }
}
