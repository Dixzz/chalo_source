package defpackage;

/* renamed from: t65  reason: default package */
/* compiled from: UPCEReader */
public final class t65 extends r65 {
    public static final int[] j = {1, 1, 1, 1, 1, 1};
    public static final int[][] k = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    public final int[] i = new int[4];

    public static String s(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    @Override // defpackage.r65
    public boolean i(String str) throws v25 {
        return r65.j(s(str));
    }

    @Override // defpackage.r65
    public int[] l(e45 e45, int i2) throws a35 {
        int[] iArr = j;
        return r65.o(e45, i2, true, iArr, new int[iArr.length]);
    }

    @Override // defpackage.r65
    public int m(e45 e45, int[] iArr, StringBuilder sb) throws a35 {
        int[] iArr2 = this.i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = e45.g;
        int i3 = iArr[1];
        int i4 = 0;
        for (int i5 = 0; i5 < 6 && i3 < i2; i5++) {
            int k2 = r65.k(e45, iArr2, i3, r65.h);
            sb.append((char) ((k2 % 10) + 48));
            for (int i6 : iArr2) {
                i3 += i6;
            }
            if (k2 >= 10) {
                i4 |= 1 << (5 - i5);
            }
        }
        for (int i7 = 0; i7 <= 1; i7++) {
            for (int i8 = 0; i8 < 10; i8++) {
                if (i4 == k[i7][i8]) {
                    sb.insert(0, (char) (i7 + 48));
                    sb.append((char) (i8 + 48));
                    return i3;
                }
            }
        }
        throw a35.h;
    }

    @Override // defpackage.r65
    public o25 q() {
        return o25.UPC_E;
    }
}
