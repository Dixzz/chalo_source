package defpackage;

/* renamed from: q35  reason: default package */
/* compiled from: Encoder */
public final class q35 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f2893a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static void a(f45 f45, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                f45.f(i5, i4);
                f45.f(i5, i6);
                f45.f(i4, i5);
                f45.f(i6, i5);
                i5++;
            }
        }
        int i7 = i - i2;
        f45.f(i7, i7);
        int i8 = i7 + 1;
        f45.f(i8, i7);
        f45.f(i7, i8);
        int i9 = i + i2;
        f45.f(i9, i7);
        f45.f(i9, i8);
        f45.f(i9, i9 - 1);
    }

    public static e45 b(e45 e45, int i, int i2) {
        p45 p45;
        int i3 = e45.g / i2;
        if (i2 == 4) {
            p45 = p45.k;
        } else if (i2 == 6) {
            p45 = p45.j;
        } else if (i2 == 8) {
            p45 = p45.n;
        } else if (i2 == 10) {
            p45 = p45.i;
        } else if (i2 == 12) {
            p45 = p45.h;
        } else {
            throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
        }
        s45 s45 = new s45(p45);
        int i4 = i / i2;
        int[] iArr = new int[i4];
        int i5 = e45.g / i2;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                i7 |= e45.e((i6 * i2) + i8) ? 1 << ((i2 - i8) - 1) : 0;
            }
            iArr[i6] = i7;
        }
        s45.a(iArr, i4 - i3);
        e45 e452 = new e45();
        e452.c(0, i % i2);
        for (int i9 = 0; i9 < i4; i9++) {
            e452.c(iArr[i9], i2);
        }
        return e452;
    }

    public static e45 c(e45 e45, int i) {
        e45 e452 = new e45();
        int i2 = e45.g;
        int i3 = (1 << i) - 2;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                int i7 = i4 + i6;
                if (i7 >= i2 || e45.e(i7)) {
                    i5 |= 1 << ((i - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                e452.c(i8, i);
            } else if (i8 == 0) {
                e452.c(i5 | 1, i);
            } else {
                e452.c(i5, i);
                i4 += i;
            }
            i4--;
            i4 += i;
        }
        return e452;
    }
}
