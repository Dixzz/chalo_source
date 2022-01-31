package defpackage;

/* renamed from: xk1  reason: default package */
/* compiled from: Point */
public final class xk1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3936a;
    public final int b;

    public xk1(int i, int i2) {
        this.f3936a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xk1)) {
            return false;
        }
        xk1 xk1 = (xk1) obj;
        if (this.f3936a == xk1.f3936a && this.b == xk1.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f3936a;
        int i2 = this.b;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("(");
        i0.append(this.f3936a);
        i0.append("; ");
        return hj1.X(i0, this.b, ")");
    }
}
