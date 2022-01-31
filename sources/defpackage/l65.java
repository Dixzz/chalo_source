package defpackage;

import java.util.Map;

/* renamed from: l65  reason: default package */
/* compiled from: OneDimensionalCodeWriter */
public abstract class l65 implements i35 {
    public static int b(boolean[] zArr, int i, int[] iArr, boolean z) {
        int i2 = 0;
        for (int i3 : iArr) {
            int i4 = 0;
            while (i4 < i3) {
                zArr[i] = z;
                i4++;
                i++;
            }
            i2 += i3;
            z = !z;
        }
        return i2;
    }

    @Override // defpackage.i35
    public f45 a(String str, o25 o25, int i, int i2, Map<u25, ?> map) throws j35 {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        } else {
            int d = d();
            if (map != null) {
                u25 u25 = u25.MARGIN;
                if (map.containsKey(u25)) {
                    d = Integer.parseInt(map.get(u25).toString());
                }
            }
            boolean[] c = c(str);
            int length = c.length;
            int i3 = d + length;
            int max = Math.max(i, i3);
            int max2 = Math.max(1, i2);
            int i4 = max / i3;
            int i5 = (max - (length * i4)) / 2;
            f45 f45 = new f45(max, max2);
            int i6 = 0;
            while (i6 < length) {
                if (c[i6]) {
                    f45.g(i5, 0, i4, max2);
                }
                i6++;
                i5 += i4;
            }
            return f45;
        }
    }

    public abstract boolean[] c(String str);

    public int d() {
        return 10;
    }
}
