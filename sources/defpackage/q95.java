package defpackage;

import java.util.Arrays;

/* renamed from: q95  reason: default package */
/* compiled from: MatrixUtil */
public final class q95 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[][] f2916a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    public static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    public static final int[][] c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    public static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static void a(e45 e45, c95 c95, g95 g95, int i, o95 o95) throws j35 {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        for (byte[] bArr : o95.f2668a) {
            Arrays.fill(bArr, (byte) -1);
        }
        int length = f2916a[0].length;
        d(0, 0, o95);
        d(o95.b - length, 0, o95);
        d(0, o95.b - length, o95);
        c(0, 7, o95);
        c(o95.b - 8, 7, o95);
        c(0, o95.b - 8, o95);
        e(7, 0, o95);
        e((o95.c - 7) - 1, 0, o95);
        e(7, o95.c - 7, o95);
        if (o95.a(8, o95.c - 8) != 0) {
            o95.b(8, o95.c - 8, 1);
            int i6 = g95.f1228a;
            int i7 = 5;
            if (i6 >= 2) {
                int[] iArr = c[i6 - 1];
                int length2 = iArr.length;
                int i8 = 0;
                while (i8 < length2) {
                    int i9 = iArr[i8];
                    if (i9 >= 0) {
                        int length3 = iArr.length;
                        int i10 = 0;
                        while (i10 < length3) {
                            int i11 = iArr[i10];
                            if (i11 >= 0 && g(o95.a(i11, i9))) {
                                int i12 = i11 - 2;
                                int i13 = i9 - 2;
                                int i14 = 0;
                                while (i14 < i7) {
                                    int[] iArr2 = b[i14];
                                    int i15 = 0;
                                    while (i15 < i7) {
                                        o95.b(i12 + i15, i13 + i14, iArr2[i15]);
                                        i15++;
                                        i7 = 5;
                                    }
                                    i14++;
                                    i7 = 5;
                                }
                            }
                            i10++;
                            i7 = 5;
                        }
                    }
                    i8++;
                    i7 = 5;
                }
            }
            int i16 = 8;
            while (i16 < o95.b - 8) {
                int i17 = i16 + 1;
                int i18 = i17 % 2;
                if (g(o95.a(i16, 6))) {
                    o95.b(i16, 6, i18);
                }
                if (g(o95.a(6, i16))) {
                    o95.b(6, i16, i18);
                }
                i16 = i17;
            }
            e45 e452 = new e45();
            if (i >= 0 && i < 8) {
                int bits = (c95.getBits() << 3) | i;
                e452.c(bits, 5);
                e452.c(b(bits, 1335), 10);
                e45 e453 = new e45();
                e453.c(21522, 15);
                if (e452.g == e453.g) {
                    int i19 = 0;
                    while (true) {
                        int[] iArr3 = e452.f;
                        if (i19 >= iArr3.length) {
                            break;
                        }
                        iArr3[i19] = iArr3[i19] ^ e453.f[i19];
                        i19++;
                    }
                    if (e452.g == 15) {
                        int i20 = 0;
                        while (true) {
                            int i21 = e452.g;
                            if (i20 >= i21) {
                                break;
                            }
                            boolean e = e452.e((i21 - 1) - i20);
                            int[] iArr4 = d[i20];
                            o95.c(iArr4[0], iArr4[1], e);
                            if (i20 < 8) {
                                o95.c((o95.b - i20) - 1, 8, e);
                            } else {
                                o95.c(8, (i20 - 8) + (o95.c - 7), e);
                            }
                            i20++;
                        }
                        int i22 = g95.f1228a;
                        if (i22 >= 7) {
                            e45 e454 = new e45();
                            e454.c(i22, 6);
                            e454.c(b(g95.f1228a, 7973), 12);
                            if (e454.g == 18) {
                                int i23 = 17;
                                for (int i24 = 0; i24 < 6; i24++) {
                                    for (int i25 = 0; i25 < 3; i25++) {
                                        boolean e2 = e454.e(i23);
                                        i23--;
                                        o95.c(i24, (o95.c - 11) + i25, e2);
                                        o95.c((o95.c - 11) + i25, i24, e2);
                                    }
                                }
                            } else {
                                throw new j35("should not happen but we got: " + e454.g);
                            }
                        }
                        int i26 = o95.b - 1;
                        int i27 = o95.c - 1;
                        int i28 = 0;
                        int i29 = -1;
                        while (i26 > 0) {
                            if (i26 == 6) {
                                i26--;
                            }
                            while (i27 >= 0 && i27 < o95.c) {
                                for (int i30 = 0; i30 < 2; i30++) {
                                    int i31 = i26 - i30;
                                    if (g(o95.a(i31, i27))) {
                                        if (i28 < e45.g) {
                                            z = e45.e(i28);
                                            i28++;
                                        } else {
                                            z = false;
                                        }
                                        if (i != -1) {
                                            switch (i) {
                                                case 0:
                                                    i3 = i27 + i31;
                                                    i2 = i3 & 1;
                                                    break;
                                                case 1:
                                                    i3 = i27;
                                                    i2 = i3 & 1;
                                                    break;
                                                case 2:
                                                    i2 = i31 % 3;
                                                    break;
                                                case 3:
                                                    i2 = (i27 + i31) % 3;
                                                    break;
                                                case 4:
                                                    i3 = (i31 / 3) + (i27 / 2);
                                                    i2 = i3 & 1;
                                                    break;
                                                case 5:
                                                    int i32 = i27 * i31;
                                                    i2 = (i32 % 3) + (i32 & 1);
                                                    break;
                                                case 6:
                                                    int i33 = i27 * i31;
                                                    i4 = i33 & 1;
                                                    i5 = i33 % 3;
                                                    i3 = i5 + i4;
                                                    i2 = i3 & 1;
                                                    break;
                                                case 7:
                                                    i5 = (i27 * i31) % 3;
                                                    i4 = (i27 + i31) & 1;
                                                    i3 = i5 + i4;
                                                    i2 = i3 & 1;
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i)));
                                            }
                                            if (i2 == 0) {
                                                z = !z;
                                            }
                                        }
                                        o95.c(i31, i27, z);
                                    }
                                }
                                i27 += i29;
                            }
                            i29 = -i29;
                            i27 += i29;
                            i26 -= 2;
                        }
                        if (i28 != e45.g) {
                            throw new j35("Not all bits consumed: " + i28 + '/' + e45.g);
                        }
                        return;
                    }
                    throw new j35("should not happen but we got: " + e452.g);
                }
                throw new IllegalArgumentException("Sizes don't match");
            }
            throw new j35("Invalid mask pattern");
        }
        throw new j35();
    }

    public static int b(int i, int i2) {
        if (i2 != 0) {
            int f = f(i2);
            int i3 = i << (f - 1);
            while (f(i3) >= f) {
                i3 ^= i2 << (f(i3) - f);
            }
            return i3;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    public static void c(int i, int i2, o95 o95) throws j35 {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (g(o95.a(i4, i2))) {
                o95.b(i4, i2, 0);
            } else {
                throw new j35();
            }
        }
    }

    public static void d(int i, int i2, o95 o95) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = f2916a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                o95.b(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    public static void e(int i, int i2, o95 o95) throws j35 {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (g(o95.f2668a[i4][i])) {
                o95.f2668a[i4][i] = (byte) 0;
            } else {
                throw new j35();
            }
        }
    }

    public static int f(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    public static boolean g(int i) {
        return i == -1;
    }
}
