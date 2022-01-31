package defpackage;

import defpackage.g95;

/* renamed from: p95  reason: default package */
/* compiled from: Encoder */
public final class p95 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f2785a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    public static g95 a(int i, c95 c95) throws j35 {
        for (int i2 = 1; i2 <= 40; i2++) {
            g95 d = g95.d(i2);
            if (c(i, d, c95)) {
                return d;
            }
        }
        throw new j35("Data too big");
    }

    public static int b(int i) {
        int[] iArr = f2785a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    public static boolean c(int i, g95 g95, c95 c95) {
        int i2 = g95.d;
        g95.b bVar = g95.c[c95.ordinal()];
        return i2 - (bVar.a() * bVar.f1230a) >= (i + 7) / 8;
    }
}
