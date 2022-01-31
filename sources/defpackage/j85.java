package defpackage;

/* renamed from: j85  reason: default package */
/* compiled from: PDF417ScanningDecoder */
public final class j85 {

    /* renamed from: a  reason: collision with root package name */
    public static final k85 f1891a = new k85();

    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.c85 a(defpackage.h85 r15) throws defpackage.a35 {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j85.a(h85):c85");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03ad A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x048d  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x03c4 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x024e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.i45 b(int[] r25, int r26, int[] r27) throws defpackage.v25, defpackage.r25 {
        /*
        // Method dump skipped, instructions count: 1272
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j85.b(int[], int, int[]):i45");
    }

    public static d85 c(f45 f45, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = i;
        int i9 = z ? -1 : 1;
        boolean z2 = z;
        int i10 = i3;
        int i11 = 0;
        loop0:
        while (true) {
            if (i11 >= 2) {
                break;
            }
            while (true) {
                if (z2) {
                    if (i10 < i8) {
                        continue;
                        break;
                    }
                } else if (i10 >= i2) {
                    continue;
                    break;
                }
                if (z2 != f45.b(i10, i4)) {
                    continue;
                    break;
                } else if (Math.abs(i3 - i10) > 2) {
                    i10 = i3;
                    break loop0;
                } else {
                    i10 += i9;
                }
            }
            i9 = -i9;
            z2 = !z2;
            i11++;
        }
        int[] iArr = new int[8];
        int i12 = z ? 1 : -1;
        boolean z3 = z;
        int i13 = i10;
        int i14 = 0;
        while (true) {
            if (z) {
                if (i13 >= i2) {
                    break;
                }
            } else if (i13 < i8) {
                break;
            }
            if (i14 >= 8) {
                break;
            } else if (f45.b(i13, i4) == z3) {
                iArr[i14] = iArr[i14] + 1;
                i13 += i12;
            } else {
                i14++;
                z3 = !z3;
            }
        }
        if (i14 != 8) {
            if (z) {
                i8 = i2;
            }
            if (!(i13 == i8 && i14 == 7)) {
                iArr = null;
            }
        }
        if (iArr == null) {
            return null;
        }
        int X2 = hd3.X2(iArr);
        if (z) {
            i7 = i10 + X2;
        } else {
            for (int i15 = 0; i15 < iArr.length / 2; i15++) {
                int i16 = iArr[i15];
                iArr[i15] = iArr[(iArr.length - 1) - i15];
                iArr[(iArr.length - 1) - i15] = i16;
            }
            i10 -= X2;
            i7 = i10;
        }
        if (!(i5 + -2 <= X2 && X2 <= i6 + 2)) {
            return null;
        }
        float[][] fArr = i85.f1491a;
        float X22 = (float) hd3.X2(iArr);
        int[] iArr2 = new int[8];
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < 17; i19++) {
            if (((float) (iArr[i17] + i18)) <= ((((float) i19) * X22) / 17.0f) + (X22 / 34.0f)) {
                i18 += iArr[i17];
                i17++;
            }
            iArr2[i17] = iArr2[i17] + 1;
        }
        long j = 0;
        for (int i20 = 0; i20 < 8; i20++) {
            for (int i21 = 0; i21 < iArr2[i20]; i21++) {
                j = (j << 1) | ((long) (i20 % 2 == 0 ? 1 : 0));
            }
        }
        int i22 = (int) j;
        if (w75.a(i22) == -1) {
            i22 = -1;
        }
        if (i22 == -1) {
            int X23 = hd3.X2(iArr);
            float[] fArr2 = new float[8];
            if (X23 > 1) {
                for (int i23 = 0; i23 < 8; i23++) {
                    fArr2[i23] = ((float) iArr[i23]) / ((float) X23);
                }
            }
            float f = Float.MAX_VALUE;
            int i24 = -1;
            int i25 = 0;
            while (true) {
                float[][] fArr3 = i85.f1491a;
                if (i25 >= fArr3.length) {
                    break;
                }
                float f2 = 0.0f;
                float[] fArr4 = fArr3[i25];
                for (int i26 = 0; i26 < 8; i26++) {
                    float f3 = fArr4[i26] - fArr2[i26];
                    f2 += f3 * f3;
                    if (f2 >= f) {
                        break;
                    }
                }
                if (f2 < f) {
                    i24 = w75.b[i25];
                    f = f2;
                }
                i25++;
            }
            i22 = i24;
        }
        int a2 = w75.a(i22);
        if (a2 == -1) {
            return null;
        }
        int[] iArr3 = new int[8];
        int i27 = i22;
        int i28 = 7;
        int i29 = 0;
        while (true) {
            int i30 = i27 & 1;
            if (i30 != i29) {
                i28--;
                if (i28 < 0) {
                    return new d85(i10, i7, ((((iArr3[0] - iArr3[2]) + iArr3[4]) - iArr3[6]) + 9) % 9, a2);
                }
                i29 = i30;
            }
            iArr3[i28] = iArr3[i28] + 1;
            i27 >>= 1;
        }
    }

    public static h85 d(f45 f45, c85 c85, g35 g35, boolean z, int i, int i2) {
        int i3;
        h85 h85 = new h85(c85, z);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int i6 = (int) g35.f1210a;
            int i7 = (int) g35.b;
            while (i7 <= c85.i && i7 >= c85.h) {
                d85 c = c(f45, 0, f45.f, z, i6, i7, i, i2);
                if (c != null) {
                    h85.b[i7 - h85.f1226a.h] = c;
                    if (z) {
                        i3 = c.f809a;
                    } else {
                        i3 = c.b;
                    }
                    i6 = i3;
                }
                i7 += i5;
            }
            i4++;
        }
        return h85;
    }

    public static boolean e(f85 f85, int i) {
        return i >= 0 && i <= f85.d + 1;
    }
}
