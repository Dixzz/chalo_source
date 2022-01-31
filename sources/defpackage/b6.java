package defpackage;

import android.graphics.Insets;

/* renamed from: b6  reason: default package */
/* compiled from: Insets */
public final class b6 {
    public static final b6 e = new b6(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f386a;
    public final int b;
    public final int c;
    public final int d;

    public b6(int i, int i2, int i3, int i4) {
        this.f386a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static b6 a(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return e;
        }
        return new b6(i, i2, i3, i4);
    }

    public static b6 b(Insets insets) {
        return a(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets c() {
        return Insets.of(this.f386a, this.b, this.c, this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b6.class != obj.getClass()) {
            return false;
        }
        b6 b6Var = (b6) obj;
        return this.d == b6Var.d && this.f386a == b6Var.f386a && this.c == b6Var.c && this.b == b6Var.b;
    }

    public int hashCode() {
        return (((((this.f386a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Insets{left=");
        i0.append(this.f386a);
        i0.append(", top=");
        i0.append(this.b);
        i0.append(", right=");
        i0.append(this.c);
        i0.append(", bottom=");
        return hj1.W(i0, this.d, '}');
    }
}
