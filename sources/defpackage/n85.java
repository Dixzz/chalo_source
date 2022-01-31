package defpackage;

import java.util.Arrays;

/* renamed from: n85  reason: default package */
/* compiled from: Detector */
public final class n85 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f2523a = {0, 4, 1, 5};
    public static final int[] b = {6, 2, 7, 3};
    public static final int[] c = {8, 1, 1, 1, 1, 1, 1, 3};
    public static final int[] d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        if (r12 == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        r1 = r7.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        if (r1.hasNext() == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
        r2 = (defpackage.g35[]) r1.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
        if (r2[1] == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        r10 = (int) java.lang.Math.max((float) r10, r2[1].b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
        if (r2[3] == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
        r10 = java.lang.Math.max(r10, (int) r2[3].b);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<defpackage.g35[]> a(boolean r17, defpackage.f45 r18) {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n85.a(boolean, f45):java.util.List");
    }

    public static int[] b(f45 f45, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (f45.b(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        boolean z2 = z;
        int i6 = 0;
        int i7 = i;
        while (i < i3) {
            if (f45.b(i, i2) != z2) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                if (i6 != length - 1) {
                    i6++;
                } else if (d(iArr2, iArr, 0.8f) < 0.42f) {
                    return new int[]{i7, i};
                } else {
                    i7 += iArr2[0] + iArr2[1];
                    int i8 = i6 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i6] = 0;
                    i6 = i8;
                }
                iArr2[i6] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i6 != length - 1 || d(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    public static g35[] c(f45 f45, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        int i6;
        int i7;
        g35[] g35Arr = new g35[4];
        int[] iArr2 = new int[iArr.length];
        int i8 = i3;
        while (true) {
            if (i8 >= i) {
                z = false;
                break;
            }
            int[] b2 = b(f45, i4, i8, i2, false, iArr, iArr2);
            if (b2 != null) {
                int[] iArr3 = b2;
                int i9 = i8;
                while (true) {
                    if (i9 <= 0) {
                        i7 = i9;
                        break;
                    }
                    int i10 = i9 - 1;
                    int[] b3 = b(f45, i4, i10, i2, false, iArr, iArr2);
                    if (b3 == null) {
                        i7 = i10 + 1;
                        break;
                    }
                    iArr3 = b3;
                    i9 = i10;
                }
                float f = (float) i7;
                g35Arr[0] = new g35((float) iArr3[0], f);
                g35Arr[1] = new g35((float) iArr3[1], f);
                i8 = i7;
                z = true;
            } else {
                i8 += 5;
            }
        }
        int i11 = i8 + 1;
        if (z) {
            int[] iArr4 = {(int) g35Arr[0].f1210a, (int) g35Arr[1].f1210a};
            int i12 = i11;
            int i13 = 0;
            while (true) {
                if (i12 >= i) {
                    i5 = i13;
                    i6 = i12;
                    break;
                }
                i5 = i13;
                i6 = i12;
                int[] b4 = b(f45, iArr4[0], i12, i2, false, iArr, iArr2);
                if (b4 == null || Math.abs(iArr4[0] - b4[0]) >= 5 || Math.abs(iArr4[1] - b4[1]) >= 5) {
                    if (i5 > 25) {
                        break;
                    }
                    i13 = i5 + 1;
                } else {
                    iArr4 = b4;
                    i13 = 0;
                }
                i12 = i6 + 1;
            }
            i11 = i6 - (i5 + 1);
            float f2 = (float) i11;
            g35Arr[2] = new g35((float) iArr4[0], f2);
            g35Arr[3] = new g35((float) iArr4[1], f2);
        }
        if (i11 - i8 < 10) {
            Arrays.fill(g35Arr, (Object) null);
        }
        return g35Arr;
    }

    public static float d(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = ((float) iArr2[i4]) * f3;
            float f7 = (float) i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
