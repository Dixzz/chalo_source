package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: z65  reason: default package */
/* compiled from: RSS14Reader */
public final class z65 extends v65 {
    public static final int[] i = {1, 10, 34, 70, 126};
    public static final int[] j = {4, 20, 48, 81};
    public static final int[] k = {0, 161, 961, 2015, 2715};
    public static final int[] l = {0, 336, 1036, 1516};
    public static final int[] m = {8, 6, 4, 3, 1};
    public static final int[] n = {2, 4, 6, 8};
    public static final int[][] o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    public final List<y65> g = new ArrayList();
    public final List<y65> h = new ArrayList();

    public static void m(Collection<y65> collection, y65 y65) {
        if (y65 != null) {
            boolean z = false;
            Iterator<y65> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                y65 next = it.next();
                if (next.f3736a == y65.f3736a) {
                    next.d++;
                    z = true;
                    break;
                }
            }
            if (!z) {
                collection.add(y65);
            }
        }
    }

    @Override // defpackage.c35, defpackage.k65
    public void c() {
        this.g.clear();
        this.h.clear();
    }

    @Override // defpackage.k65
    public e35 d(int i2, e45 e45, Map<s25, ?> map) throws a35 {
        m(this.g, o(e45, false, i2, map));
        e45.j();
        m(this.h, o(e45, true, i2, map));
        e45.j();
        for (y65 y65 : this.g) {
            if (y65.d > 1) {
                for (y65 y652 : this.h) {
                    if (y652.d > 1) {
                        int i3 = ((y652.b * 16) + y65.b) % 79;
                        int i4 = (y65.c.f3893a * 9) + y652.c.f3893a;
                        if (i4 > 72) {
                            i4--;
                        }
                        if (i4 > 8) {
                            i4--;
                        }
                        if (i3 == i4) {
                            String valueOf = String.valueOf((((long) y65.f3736a) * 4537077) + ((long) y652.f3736a));
                            StringBuilder sb = new StringBuilder(14);
                            for (int length = 13 - valueOf.length(); length > 0; length--) {
                                sb.append('0');
                            }
                            sb.append(valueOf);
                            int i5 = 0;
                            for (int i6 = 0; i6 < 13; i6++) {
                                int charAt = sb.charAt(i6) - '0';
                                if ((i6 & 1) == 0) {
                                    charAt *= 3;
                                }
                                i5 += charAt;
                            }
                            int i7 = 10 - (i5 % 10);
                            if (i7 == 10) {
                                i7 = 0;
                            }
                            sb.append(i7);
                            g35[] g35Arr = y65.c.c;
                            g35[] g35Arr2 = y652.c.c;
                            return new e35(sb.toString(), null, new g35[]{g35Arr[0], g35Arr[1], g35Arr2[0], g35Arr2[1]}, o25.RSS_14);
                        }
                    }
                }
                continue;
            }
        }
        throw a35.h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009c, code lost:
        if (r4 < 4) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b2, code lost:
        if (r4 < 4) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b4, code lost:
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b6, code lost:
        r14 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b7, code lost:
        r15 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0136 A[LOOP:3: B:103:0x0134->B:104:0x0136, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0147 A[LOOP:4: B:106:0x0145->B:107:0x0147, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.w65 n(defpackage.e45 r18, defpackage.x65 r19, boolean r20) throws defpackage.a35 {
        /*
        // Method dump skipped, instructions count: 448
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z65.n(e45, x65, boolean):w65");
    }

    public final y65 o(e45 e45, boolean z, int i2, Map<s25, ?> map) {
        h35 h35;
        try {
            int[] p = p(e45, z);
            x65 q = q(e45, i2, z, p);
            if (map == null) {
                h35 = null;
            } else {
                h35 = (h35) map.get(s25.NEED_RESULT_POINT_CALLBACK);
            }
            if (h35 != null) {
                float f = ((float) (p[0] + p[1])) / 2.0f;
                if (z) {
                    f = ((float) (e45.g - 1)) - f;
                }
                h35.a(new g35(f, (float) i2));
            }
            w65 n2 = n(e45, q, true);
            w65 n3 = n(e45, q, false);
            return new y65((n2.f3736a * 1597) + n3.f3736a, (n3.b * 4) + n2.b, q);
        } catch (a35 unused) {
            return null;
        }
    }

    public final int[] p(e45 e45, boolean z) throws a35 {
        int[] iArr = this.f3611a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i2 = e45.g;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < i2) {
            z2 = !e45.e(i3);
            if (z == z2) {
                break;
            }
            i3++;
        }
        int i4 = i3;
        int i5 = 0;
        while (i3 < i2) {
            if (e45.e(i3) != z2) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 != 3) {
                    i5++;
                } else if (v65.k(iArr)) {
                    return new int[]{i4, i3};
                } else {
                    i4 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i5--;
                }
                iArr[i5] = 1;
                z2 = !z2;
            }
            i3++;
        }
        throw a35.h;
    }

    public final x65 q(e45 e45, int i2, boolean z, int[] iArr) throws a35 {
        int i3;
        int i4;
        boolean e = e45.e(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && e != e45.e(i5)) {
            i5--;
        }
        int i6 = i5 + 1;
        int[] iArr2 = this.f3611a;
        System.arraycopy(iArr2, 0, iArr2, 1, iArr2.length - 1);
        iArr2[0] = iArr[0] - i6;
        int l2 = v65.l(iArr2, o);
        int i7 = iArr[1];
        if (z) {
            int i8 = e45.g;
            i3 = (i8 - 1) - i7;
            i4 = (i8 - 1) - i6;
        } else {
            i3 = i7;
            i4 = i6;
        }
        return new x65(l2, new int[]{i6, iArr[1]}, i4, i3, i2);
    }
}
