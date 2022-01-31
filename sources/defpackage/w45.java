package defpackage;

/* renamed from: w45  reason: default package */
/* compiled from: BitMatrixParser */
public final class w45 {

    /* renamed from: a  reason: collision with root package name */
    public final f45 f3728a;
    public final f45 b;
    public final a55 c;

    public w45(f45 f45) throws v25 {
        int i;
        int i2 = f45.g;
        if (i2 < 8 || i2 > 144 || (i2 & 1) != 0) {
            throw v25.a();
        }
        int i3 = f45.f;
        a55[] a55Arr = a55.h;
        if ((i2 & 1) == 0 && (i3 & 1) == 0) {
            a55[] a55Arr2 = a55.h;
            for (a55 a55 : a55Arr2) {
                int i4 = a55.b;
                if (i4 == i2 && (i = a55.c) == i3) {
                    this.c = a55;
                    if (f45.g == i4) {
                        int i5 = a55.d;
                        int i6 = a55.e;
                        int i7 = i4 / i5;
                        int i8 = i / i6;
                        f45 f452 = new f45(i8 * i6, i7 * i5);
                        for (int i9 = 0; i9 < i7; i9++) {
                            int i10 = i9 * i5;
                            for (int i11 = 0; i11 < i8; i11++) {
                                int i12 = i11 * i6;
                                for (int i13 = 0; i13 < i5; i13++) {
                                    int i14 = ((i5 + 2) * i9) + 1 + i13;
                                    int i15 = i10 + i13;
                                    for (int i16 = 0; i16 < i6; i16++) {
                                        if (f45.b(((i6 + 2) * i11) + 1 + i16, i14)) {
                                            f452.f(i12 + i16, i15);
                                        }
                                    }
                                }
                            }
                        }
                        this.f3728a = f452;
                        this.b = new f45(f452.f, f452.g);
                        return;
                    }
                    throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
                }
            }
            throw v25.a();
        }
        throw v25.a();
    }

    public final boolean a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.b.f(i2, i);
        return this.f3728a.b(i2, i);
    }

    public final int b(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (a(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (a(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (a(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (a(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return a(i, i2, i3, i4) ? i15 | 1 : i15;
    }
}
