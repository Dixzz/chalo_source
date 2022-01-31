package defpackage;

/* renamed from: u55  reason: default package */
/* compiled from: CodaBarWriter */
public final class u55 extends l65 {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f3456a;
    public static final char[] b = {'T', 'N', '*', 'E'};
    public static final char[] c = {'/', ':', '+', '.'};
    public static final char d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f3456a = cArr;
        d = cArr[0];
    }

    @Override // defpackage.l65
    public boolean[] c(String str) {
        int i;
        char c2 = d;
        if (str.length() < 2) {
            str = c2 + str + c2;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f3456a;
            boolean i2 = t55.i(cArr, upperCase);
            boolean i3 = t55.i(cArr, upperCase2);
            char[] cArr2 = b;
            boolean i4 = t55.i(cArr2, upperCase);
            boolean i5 = t55.i(cArr2, upperCase2);
            if (i2) {
                if (!i3) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (i4) {
                if (!i5) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (i3 || i5) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
            } else {
                str = c2 + str + c2;
            }
        }
        int i6 = 20;
        for (int i7 = 1; i7 < str.length() - 1; i7++) {
            if (Character.isDigit(str.charAt(i7)) || str.charAt(i7) == '-' || str.charAt(i7) == '$') {
                i6 += 9;
            } else if (t55.i(c, str.charAt(i7))) {
                i6 += 10;
            } else {
                throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i7) + '\'');
            }
        }
        boolean[] zArr = new boolean[((str.length() - 1) + i6)];
        int i8 = 0;
        for (int i9 = 0; i9 < str.length(); i9++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i9));
            if (i9 == 0 || i9 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i10 = 0;
            while (true) {
                char[] cArr3 = t55.d;
                if (i10 >= cArr3.length) {
                    i = 0;
                    break;
                } else if (upperCase3 == cArr3[i10]) {
                    i = t55.e[i10];
                    break;
                } else {
                    i10++;
                }
            }
            int i11 = 0;
            boolean z = true;
            while (true) {
                int i12 = 0;
                while (i11 < 7) {
                    zArr[i8] = z;
                    i8++;
                    if (((i >> (6 - i11)) & 1) == 0 || i12 == 1) {
                        z = !z;
                        i11++;
                    } else {
                        i12++;
                    }
                }
                break;
            }
            if (i9 < str.length() - 1) {
                zArr[i8] = false;
                i8++;
            }
        }
        return zArr;
    }
}
