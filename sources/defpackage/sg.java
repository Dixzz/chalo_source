package defpackage;

/* renamed from: sg  reason: default package */
/* compiled from: DispatchQueue.kt */
public final class sg implements Runnable {
    public final /* synthetic */ tg f;
    public final /* synthetic */ m66 g;
    public final /* synthetic */ Runnable h;

    public sg(tg tgVar, m66 m66, Runnable runnable) {
        this.f = tgVar;
        this.g = m66;
        this.h = runnable;
    }

    public final void run() {
        this.f.c(this.h);
    }
}
