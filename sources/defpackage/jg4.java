package defpackage;

/* renamed from: jg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public abstract class jg4 extends tc4 implements uc4 {
    public final lg4 b;
    public boolean c;

    public jg4(lg4 lg4) {
        super(lg4.j);
        this.b = lg4;
        lg4.o++;
    }

    public rg4 j() {
        return this.b.N();
    }

    public final void k() {
        if (!this.c) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void l() {
        if (!this.c) {
            n();
            this.b.p++;
            this.c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean n();

    public h64 o() {
        return this.b.K();
    }

    public qb4 p() {
        return this.b.H();
    }
}
