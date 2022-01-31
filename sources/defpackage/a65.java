package defpackage;

import java.util.Map;

/* renamed from: a65  reason: default package */
/* compiled from: Code93Writer */
public class a65 extends l65 {
    public static int e(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            zArr[i] = iArr[i2] != 0;
            i2++;
            i = i3;
        }
        return 9;
    }

    public static int f(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }

    public static void g(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    @Override // defpackage.l65, defpackage.i35
    public f45 a(String str, o25 o25, int i, int i2, Map<u25, ?> map) throws j35 {
        if (o25 == o25.CODE_93) {
            return super.a(str, o25, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(o25)));
    }

    @Override // defpackage.l65
    public boolean[] c(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            g(z55.d[47], iArr);
            boolean[] zArr = new boolean[(((str.length() + 2 + 2) * 9) + 1)];
            e(zArr, 0, iArr);
            int i = 9;
            for (int i2 = 0; i2 < length; i2++) {
                g(z55.d["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i2))], iArr);
                e(zArr, i, iArr);
                i += 9;
            }
            int f = f(str, 20);
            int[] iArr2 = z55.d;
            g(iArr2[f], iArr);
            e(zArr, i, iArr);
            int i3 = i + 9;
            StringBuilder i0 = hj1.i0(str);
            i0.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(f));
            g(iArr2[f(i0.toString(), 15)], iArr);
            e(zArr, i3, iArr);
            int i4 = i3 + 9;
            g(iArr2[47], iArr);
            e(zArr, i4, iArr);
            zArr[i4 + 9] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }
}
