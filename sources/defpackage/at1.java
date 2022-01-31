package defpackage;

/* renamed from: at1  reason: default package */
/* compiled from: SimpleTarget */
public abstract class at1<Z> extends vs1<Z> {
    public final int g;
    public final int h;

    public at1(int i, int i2) {
        this.g = i;
        this.h = i2;
    }

    @Override // defpackage.ct1
    public void a(bt1 bt1) {
    }

    @Override // defpackage.ct1
    public final void i(bt1 bt1) {
        if (rt1.i(this.g, this.h)) {
            ((ts1) bt1).d(this.g, this.h);
            return;
        }
        StringBuilder i0 = hj1.i0("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        i0.append(this.g);
        i0.append(" and height: ");
        throw new IllegalArgumentException(hj1.X(i0, this.h, ", either provide dimensions in the constructor or call override()"));
    }
}
