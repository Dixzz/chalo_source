package defpackage;

/* renamed from: kj1  reason: default package */
/* compiled from: CacheDispatcher */
public class kj1 implements Runnable {
    public final /* synthetic */ wj1 f;
    public final /* synthetic */ lj1 g;

    public kj1(lj1 lj1, wj1 wj1) {
        this.g = lj1;
        this.f = wj1;
    }

    public void run() {
        try {
            this.g.g.put(this.f);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
