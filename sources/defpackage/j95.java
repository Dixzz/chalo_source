package defpackage;

/* renamed from: j95  reason: default package */
/* compiled from: Detector */
public class j95 {

    /* renamed from: a  reason: collision with root package name */
    public final f45 f1895a;
    public h35 b;

    public j95(f45 f45) {
        this.f1895a = f45;
    }

    public final float a(g35 g35, g35 g352) {
        float d = d((int) g35.f1210a, (int) g35.b, (int) g352.f1210a, (int) g352.b);
        float d2 = d((int) g352.f1210a, (int) g352.b, (int) g35.f1210a, (int) g35.b);
        if (Float.isNaN(d)) {
            return d2 / 7.0f;
        }
        return Float.isNaN(d2) ? d / 7.0f : (d + d2) / 14.0f;
    }

    public final h95 b(float f, int i, int i2, float f2) throws a35 {
        h95 c;
        h95 c2;
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f1895a.f - 1, i + i3) - max;
        float f3 = 3.0f * f;
        if (((float) min) >= f3) {
            int max2 = Math.max(0, i2 - i3);
            int min2 = Math.min(this.f1895a.g - 1, i2 + i3) - max2;
            if (((float) min2) >= f3) {
                i95 i95 = new i95(this.f1895a, max, max2, min, min2, f, this.b);
                int i4 = i95.c;
                int i5 = i95.f;
                int i6 = i95.e + i4;
                int i7 = (i5 / 2) + i95.d;
                int[] iArr = new int[3];
                for (int i8 = 0; i8 < i5; i8++) {
                    int i9 = ((i8 & 1) == 0 ? (i8 + 1) / 2 : -((i8 + 1) / 2)) + i7;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    int i10 = i4;
                    while (i10 < i6 && !i95.f1498a.b(i10, i9)) {
                        i10++;
                    }
                    int i11 = 0;
                    while (i10 < i6) {
                        if (!i95.f1498a.b(i10, i9)) {
                            if (i11 == 1) {
                                i11++;
                            }
                            iArr[i11] = iArr[i11] + 1;
                        } else if (i11 == 1) {
                            iArr[1] = iArr[1] + 1;
                        } else if (i11 != 2) {
                            i11++;
                            iArr[i11] = iArr[i11] + 1;
                        } else if (i95.b(iArr) && (c2 = i95.c(iArr, i9, i10)) != null) {
                            return c2;
                        } else {
                            iArr[0] = iArr[2];
                            iArr[1] = 1;
                            iArr[2] = 0;
                            i11 = 1;
                        }
                        i10++;
                    }
                    if (i95.b(iArr) && (c = i95.c(iArr, i9, i6)) != null) {
                        return c;
                    }
                }
                if (!i95.b.isEmpty()) {
                    return i95.b.get(0);
                }
                throw a35.h;
            }
            throw a35.h;
        }
        throw a35.h;
    }

    public final float c(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        j95 j95;
        boolean z2;
        int i10 = 1;
        boolean z3 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z3) {
            i7 = i;
            i8 = i2;
            i5 = i3;
            i6 = i4;
        } else {
            i8 = i;
            i7 = i2;
            i6 = i3;
            i5 = i4;
        }
        int abs = Math.abs(i6 - i8);
        int abs2 = Math.abs(i5 - i7);
        int i11 = (-abs) / 2;
        int i12 = -1;
        int i13 = i8 < i6 ? 1 : -1;
        if (i7 < i5) {
            i12 = 1;
        }
        int i14 = i6 + i13;
        int i15 = i8;
        int i16 = i7;
        int i17 = 0;
        while (true) {
            if (i15 == i14) {
                i9 = i14;
                break;
            }
            int i18 = z3 ? i16 : i15;
            int i19 = z3 ? i15 : i16;
            if (i17 == i10) {
                j95 = this;
                z = z3;
                i9 = i14;
                z2 = true;
            } else {
                j95 = this;
                z = z3;
                i9 = i14;
                z2 = false;
            }
            if (z2 == j95.f1895a.b(i18, i19)) {
                if (i17 == 2) {
                    return hd3.H0(i15, i16, i8, i7);
                }
                i17++;
            }
            i11 += abs2;
            if (i11 > 0) {
                if (i16 == i5) {
                    break;
                }
                i16 += i12;
                i11 -= abs;
            }
            i15 += i13;
            i14 = i9;
            z3 = z;
            i10 = 1;
        }
        if (i17 == 2) {
            return hd3.H0(i9, i5, i8, i7);
        }
        return Float.NaN;
    }

    public final float d(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float c = c(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        int i6 = 0;
        if (i5 < 0) {
            f = ((float) i) / ((float) (i - i5));
            i5 = 0;
        } else {
            int i7 = this.f1895a.f;
            if (i5 >= i7) {
                int i8 = i7 - 1;
                f = ((float) ((i7 - 1) - i)) / ((float) (i5 - i));
                i5 = i8;
            } else {
                f = 1.0f;
            }
        }
        float f3 = (float) i2;
        int i9 = (int) (f3 - (((float) (i4 - i2)) * f));
        if (i9 < 0) {
            f2 = f3 / ((float) (i2 - i9));
        } else {
            int i10 = this.f1895a.g;
            if (i9 >= i10) {
                f2 = ((float) ((i10 - 1) - i2)) / ((float) (i9 - i2));
                i6 = i10 - 1;
            } else {
                i6 = i9;
                f2 = 1.0f;
            }
        }
        return (c(i, i2, (int) ((((float) (i5 - i)) * f2) + ((float) i)), i6) + c) - 1.0f;
    }
}
