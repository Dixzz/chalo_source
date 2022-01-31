package defpackage;

/* renamed from: yk1  reason: default package */
/* compiled from: Rect */
public final class yk1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f4062a;
    public final int b;
    public final int c;
    public final int d;

    public yk1(int i, int i2, int i3, int i4) {
        this.f4062a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public int a() {
        return this.d - this.b;
    }

    public int b() {
        return this.c - this.f4062a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof yk1)) {
            return false;
        }
        yk1 yk1 = (yk1) obj;
        if (this.f4062a == yk1.f4062a && this.b == yk1.b && this.c == yk1.c && this.d == yk1.d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f4062a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("[(");
        i0.append(this.f4062a);
        i0.append("; ");
        i0.append(this.b);
        i0.append(") - (");
        i0.append(this.c);
        i0.append("; ");
        return hj1.X(i0, this.d, ")]");
    }
}
