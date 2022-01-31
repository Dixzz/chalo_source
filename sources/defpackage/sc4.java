package defpackage;

/* renamed from: sc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class sc4 extends tc4 {
    public boolean b;

    public sc4(vb4 vb4) {
        super(vb4);
        this.f3331a.E++;
    }

    public void j() {
    }

    public final boolean k() {
        return this.b;
    }

    public final void l() {
        if (!k()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void n() {
        if (this.b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!p()) {
            this.f3331a.F.incrementAndGet();
            this.b = true;
        }
    }

    public final void o() {
        if (!this.b) {
            j();
            this.f3331a.F.incrementAndGet();
            this.b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean p();
}
