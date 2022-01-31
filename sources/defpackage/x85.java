package defpackage;

/* renamed from: x85  reason: default package */
/* compiled from: BitMatrixParser */
public final class x85 {

    /* renamed from: a  reason: collision with root package name */
    public final f45 f3902a;
    public g95 b;
    public d95 c;
    public boolean d;

    public x85(f45 f45) throws v25 {
        int i = f45.g;
        if (i < 21 || (i & 3) != 1) {
            throw v25.a();
        }
        this.f3902a = f45;
    }

    public final int a(int i, int i2, int i3) {
        return this.d ? this.f3902a.b(i2, i) : this.f3902a.b(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public void b() {
        int i = 0;
        while (i < this.f3902a.f) {
            int i2 = i + 1;
            int i3 = i2;
            while (true) {
                f45 f45 = this.f3902a;
                if (i3 >= f45.g) {
                    break;
                }
                if (f45.b(i, i3) != this.f3902a.b(i3, i)) {
                    this.f3902a.a(i3, i);
                    this.f3902a.a(i, i3);
                }
                i3++;
            }
            i = i2;
        }
    }

    public d95 c() throws v25 {
        d95 d95 = this.c;
        if (d95 != null) {
            return d95;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = a(i3, 8, i2);
        }
        int a2 = a(8, 7, a(8, 8, a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a2 = a(8, i4, a2);
        }
        int i5 = this.f3902a.g;
        int i6 = i5 - 7;
        for (int i7 = i5 - 1; i7 >= i6; i7--) {
            i = a(8, i7, i);
        }
        for (int i8 = i5 - 8; i8 < i5; i8++) {
            i = a(i8, 8, i);
        }
        d95 a3 = d95.a(a2, i);
        if (a3 == null) {
            a3 = d95.a(a2 ^ 21522, i ^ 21522);
        }
        this.c = a3;
        if (a3 != null) {
            return a3;
        }
        throw v25.a();
    }

    public g95 d() throws v25 {
        g95 g95 = this.b;
        if (g95 != null) {
            return g95;
        }
        int i = this.f3902a.g;
        int i2 = (i - 17) / 4;
        if (i2 <= 6) {
            return g95.d(i2);
        }
        int i3 = i - 11;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                i5 = a(i7, i6, i5);
            }
        }
        g95 b2 = g95.b(i5);
        if (b2 == null || b2.c() != i) {
            for (int i8 = 5; i8 >= 0; i8--) {
                for (int i9 = i - 9; i9 >= i3; i9--) {
                    i4 = a(i8, i9, i4);
                }
            }
            g95 b3 = g95.b(i4);
            if (b3 == null || b3.c() != i) {
                throw v25.a();
            }
            this.b = b3;
            return b3;
        }
        this.b = b2;
        return b2;
    }

    public void e() {
        if (this.c != null) {
            z85 z85 = z85.values()[this.c.b];
            f45 f45 = this.f3902a;
            z85.unmaskBitMatrix(f45, f45.g);
        }
    }
}
