package defpackage;

/* renamed from: c72  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class c72 implements Runnable {
    public final /* synthetic */ f72 f;

    public c72(f72 f72) {
        this.f = f72;
    }

    public final void run() {
        this.f.r.lock();
        try {
            f72.p(this.f);
        } finally {
            this.f.r.unlock();
        }
    }
}
