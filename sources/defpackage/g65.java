package defpackage;

import java.util.Map;

/* renamed from: g65  reason: default package */
/* compiled from: ITFReader */
public final class g65 extends k65 {
    public static final int[] b = {6, 8, 10, 12, 14};
    public static final int[] c = {1, 1, 1, 1};
    public static final int[][] d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    public static final int[][] e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a  reason: collision with root package name */
    public int f1221a = -1;

    public static int i(int[] iArr) throws a35 {
        int[][] iArr2 = e;
        int length = iArr2.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = k65.f(iArr, iArr2[i2], 0.5f);
            if (f2 < f) {
                i = i2;
                f = f2;
            } else if (f2 == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw a35.h;
    }

    public static int[] j(e45 e45, int i, int[] iArr) throws a35 {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i2 = e45.g;
        int i3 = i;
        boolean z = false;
        int i4 = 0;
        while (i < i2) {
            if (e45.e(i) != z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (k65.f(iArr2, iArr, 0.5f) < 0.38f) {
                    return new int[]{i3, i};
                } else {
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i4 = i5;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            i++;
        }
        throw a35.h;
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.k65
    public e35 d(int i, e45 e45, Map<s25, ?> map) throws v25, a35 {
        int[] iArr;
        boolean z;
        int i2 = e45.g;
        int f = e45.f(0);
        if (f != i2) {
            int[] j = j(e45, f, c);
            this.f1221a = (j[1] - j[0]) / 4;
            k(e45, j[0]);
            int[][] iArr2 = d;
            e45.j();
            try {
                int i3 = e45.g;
                int f2 = e45.f(0);
                if (f2 != i3) {
                    try {
                        iArr = j(e45, f2, iArr2[0]);
                    } catch (a35 unused) {
                        iArr = j(e45, f2, iArr2[1]);
                    }
                    k(e45, iArr[0]);
                    int i4 = iArr[0];
                    int i5 = e45.g;
                    iArr[0] = i5 - iArr[1];
                    iArr[1] = i5 - i4;
                    e45.j();
                    StringBuilder sb = new StringBuilder(20);
                    int i6 = j[1];
                    int i7 = iArr[0];
                    int[] iArr3 = new int[10];
                    int[] iArr4 = new int[5];
                    int[] iArr5 = new int[5];
                    while (i6 < i7) {
                        k65.g(e45, i6, iArr3);
                        for (int i8 = 0; i8 < 5; i8++) {
                            int i9 = i8 * 2;
                            iArr4[i8] = iArr3[i9];
                            iArr5[i8] = iArr3[i9 + 1];
                        }
                        sb.append((char) (i(iArr4) + 48));
                        sb.append((char) (i(iArr5) + 48));
                        for (int i10 = 0; i10 < 10; i10++) {
                            i6 += iArr3[i10];
                        }
                    }
                    String sb2 = sb.toString();
                    int[] iArr6 = map != null ? (int[]) map.get(s25.ALLOWED_LENGTHS) : null;
                    if (iArr6 == null) {
                        iArr6 = b;
                    }
                    int length = sb2.length();
                    int length2 = iArr6.length;
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        if (i11 >= length2) {
                            z = false;
                            break;
                        }
                        int i13 = iArr6[i11];
                        if (length == i13) {
                            z = true;
                            break;
                        }
                        if (i13 > i12) {
                            i12 = i13;
                        }
                        i11++;
                    }
                    if (!z && length > i12) {
                        z = true;
                    }
                    if (z) {
                        float f3 = (float) i;
                        return new e35(sb2, null, new g35[]{new g35((float) j[1], f3), new g35((float) iArr[0], f3)}, o25.ITF);
                    }
                    throw v25.a();
                }
                throw a35.h;
            } catch (Throwable th) {
                e45.j();
                throw th;
            }
        } else {
            throw a35.h;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(defpackage.e45 r3, int r4) throws defpackage.a35 {
        /*
            r2 = this;
            int r0 = r2.f1221a
            int r0 = r0 * 10
            if (r0 >= r4) goto L_0x0007
            goto L_0x0008
        L_0x0007:
            r0 = r4
        L_0x0008:
            int r4 = r4 + -1
            if (r0 <= 0) goto L_0x0017
            if (r4 < 0) goto L_0x0017
            boolean r1 = r3.e(r4)
            if (r1 != 0) goto L_0x0017
            int r0 = r0 + -1
            goto L_0x0008
        L_0x0017:
            if (r0 != 0) goto L_0x001a
            return
        L_0x001a:
            a35 r3 = defpackage.a35.h
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g65.k(e45, int):void");
    }
}
