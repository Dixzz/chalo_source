package defpackage;

/* renamed from: bc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class bc4 extends a94 {
    public boolean b;

    public bc4(vb4 vb4) {
        super(vb4);
        this.f3331a.E++;
    }

    public final void s() {
        if (!this.b) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void t() {
        if (this.b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!u()) {
            this.f3331a.F.incrementAndGet();
            this.b = true;
        }
    }

    public abstract boolean u();
}
