package defpackage;

/* renamed from: tq  reason: default package */
/* compiled from: DelayedWorkTracker */
public class tq implements Runnable {
    public final /* synthetic */ rs f;
    public final /* synthetic */ uq g;

    public tq(uq uqVar, rs rsVar) {
        this.g = uqVar;
        this.f = rsVar;
    }

    public void run() {
        tp.c().a(uq.d, String.format("Scheduling work %s", this.f.f3122a), new Throwable[0]);
        this.g.f3541a.a(this.f);
    }
}
