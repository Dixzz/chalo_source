package defpackage;

/* renamed from: qq  reason: default package */
/* compiled from: WorkerWrapper */
public class qq implements Runnable {
    public final /* synthetic */ ot f;
    public final /* synthetic */ sq g;

    public qq(sq sqVar, ot otVar) {
        this.g = sqVar;
        this.f = otVar;
    }

    public void run() {
        try {
            tp.c().a(sq.y, String.format("Starting work for %s", this.g.j.c), new Throwable[0]);
            sq sqVar = this.g;
            sqVar.w = sqVar.k.d();
            this.f.l(this.g.w);
        } catch (Throwable th) {
            this.f.k(th);
        }
    }
}
