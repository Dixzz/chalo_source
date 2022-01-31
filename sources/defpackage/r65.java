package defpackage;

import java.util.Arrays;
import java.util.Map;

/* renamed from: r65  reason: default package */
/* compiled from: UPCEANReader */
public abstract class r65 extends k65 {
    public static final int[] d = {1, 1, 1};
    public static final int[] e = {1, 1, 1, 1, 1};
    public static final int[] f = {1, 1, 1, 1, 1, 1};
    public static final int[][] g;
    public static final int[][] h;

    /* renamed from: a  reason: collision with root package name */
    public final StringBuilder f3049a = new StringBuilder(20);
    public final q65 b = new q65();
    public final f65 c = new f65();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        g = iArr;
        int[][] iArr2 = new int[20][];
        h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = g[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            h[i] = iArr4;
        }
    }

    public static boolean j(CharSequence charSequence) throws v25 {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return r(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    public static int k(e45 e45, int[] iArr, int i, int[][] iArr2) throws a35 {
        k65.g(e45, i, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float f3 = k65.f(iArr, iArr2[i3], 0.7f);
            if (f3 < f2) {
                i2 = i3;
                f2 = f3;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw a35.h;
    }

    public static int[] o(e45 e45, int i, boolean z, int[] iArr, int[] iArr2) throws a35 {
        int i2 = e45.g;
        int g2 = z ? e45.g(i) : e45.f(i);
        int length = iArr.length;
        boolean z2 = z;
        int i3 = 0;
        int i4 = g2;
        while (g2 < i2) {
            if (e45.e(g2) != z2) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (k65.f(iArr2, iArr, 0.7f) < 0.48f) {
                    return new int[]{i4, g2};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    int i5 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i3] = 0;
                    i3 = i5;
                }
                iArr2[i3] = 1;
                z2 = !z2;
            }
            g2++;
        }
        throw a35.h;
    }

    public static int[] p(e45 e45) throws a35 {
        int[] iArr = d;
        int[] iArr2 = new int[iArr.length];
        int[] iArr3 = null;
        boolean z = false;
        int i = 0;
        while (!z) {
            Arrays.fill(iArr2, 0, iArr.length, 0);
            iArr3 = o(e45, i, false, iArr, iArr2);
            int i2 = iArr3[0];
            int i3 = iArr3[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                z = e45.i(i4, i2, false);
            }
            i = i3;
        }
        return iArr3;
    }

    public static int r(CharSequence charSequence) throws v25 {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw v25.a();
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int charAt2 = charSequence.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw v25.a();
            }
            i3 += charAt2;
        }
        return (1000 - i3) % 10;
    }

    @Override // defpackage.k65
    public e35 d(int i, e45 e45, Map<s25, ?> map) throws a35, r25, v25 {
        return n(i, e45, p(e45), map);
    }

    public boolean i(String str) throws v25 {
        return j(str);
    }

    public int[] l(e45 e45, int i) throws a35 {
        int[] iArr = d;
        return o(e45, i, false, iArr, new int[iArr.length]);
    }

    public abstract int m(e45 e45, int[] iArr, StringBuilder sb) throws a35;

    public e35 n(int i, e45 e45, int[] iArr, Map<s25, ?> map) throws a35, r25, v25 {
        h35 h35;
        int i2;
        int[] iArr2;
        boolean z;
        String str = null;
        if (map == null) {
            h35 = null;
        } else {
            h35 = (h35) map.get(s25.NEED_RESULT_POINT_CALLBACK);
        }
        if (h35 != null) {
            h35.a(new g35(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i));
        }
        StringBuilder sb = this.f3049a;
        sb.setLength(0);
        int m = m(e45, iArr, sb);
        if (h35 != null) {
            h35.a(new g35((float) m, (float) i));
        }
        int[] l = l(e45, m);
        if (h35 != null) {
            h35.a(new g35(((float) (l[0] + l[1])) / 2.0f, (float) i));
        }
        int i3 = l[1];
        int i4 = (i3 - l[0]) + i3;
        if (i4 >= e45.g || !e45.i(i3, i4, false)) {
            throw a35.h;
        }
        String sb2 = sb.toString();
        if (sb2.length() < 8) {
            throw v25.a();
        } else if (i(sb2)) {
            o25 q = q();
            float f2 = (float) i;
            e35 e35 = new e35(sb2, null, new g35[]{new g35(((float) (iArr[1] + iArr[0])) / 2.0f, f2), new g35(((float) (l[1] + l[0])) / 2.0f, f2)}, q);
            try {
                e35 a2 = this.b.a(i, e45, l[1]);
                e35.b(f35.UPC_EAN_EXTENSION, a2.f921a);
                e35.a(a2.e);
                g35[] g35Arr = a2.c;
                g35[] g35Arr2 = e35.c;
                if (g35Arr2 == null) {
                    e35.c = g35Arr;
                } else if (g35Arr != null && g35Arr.length > 0) {
                    g35[] g35Arr3 = new g35[(g35Arr2.length + g35Arr.length)];
                    System.arraycopy(g35Arr2, 0, g35Arr3, 0, g35Arr2.length);
                    System.arraycopy(g35Arr, 0, g35Arr3, g35Arr2.length, g35Arr.length);
                    e35.c = g35Arr3;
                }
                i2 = a2.f921a.length();
            } catch (d35 unused) {
                i2 = 0;
            }
            if (map == null) {
                iArr2 = null;
            } else {
                iArr2 = (int[]) map.get(s25.ALLOWED_EAN_EXTENSIONS);
            }
            if (iArr2 != null) {
                int length = iArr2.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        z = false;
                        break;
                    } else if (i2 == iArr2[i5]) {
                        z = true;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (!z) {
                    throw a35.h;
                }
            }
            if (q == o25.EAN_13 || q == o25.UPC_A) {
                f65 f65 = this.c;
                f65.b();
                int parseInt = Integer.parseInt(sb2.substring(0, 3));
                int size = f65.f1095a.size();
                int i6 = 0;
                while (true) {
                    if (i6 < size) {
                        int[] iArr3 = f65.f1095a.get(i6);
                        int i7 = iArr3[0];
                        if (parseInt < i7) {
                            break;
                        }
                        if (iArr3.length != 1) {
                            i7 = iArr3[1];
                        }
                        if (parseInt <= i7) {
                            str = f65.b.get(i6);
                            break;
                        }
                        i6++;
                    } else {
                        break;
                    }
                }
                if (str != null) {
                    e35.b(f35.POSSIBLE_COUNTRY, str);
                }
            }
            return e35;
        } else {
            throw r25.a();
        }
    }

    public abstract o25 q();
}
