package defpackage;

/* renamed from: yb3  reason: default package */
public abstract class yb3 extends xb3 {
    public boolean g;

    public yb3(ac3 ac3) {
        super(ac3);
    }

    public final boolean X() {
        return this.g;
    }

    public final void Z() {
        a0();
        this.g = true;
    }

    public abstract void a0();

    public final void g0() {
        if (!X()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
