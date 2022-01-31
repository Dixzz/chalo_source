package defpackage;

/* renamed from: u42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class u42 implements Runnable {
    public final /* synthetic */ v42 f;

    public /* synthetic */ u42(v42 v42) {
        this.f = v42;
    }

    public abstract void a();

    public final void run() {
        this.f.b.lock();
        try {
            if (!Thread.interrupted()) {
                a();
                this.f.b.unlock();
            }
        } catch (RuntimeException e) {
            h52 h52 = this.f.f3596a;
            h52.j.sendMessage(h52.j.obtainMessage(2, e));
        } finally {
            this.f.b.unlock();
        }
    }
}
