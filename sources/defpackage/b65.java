package defpackage;

/* renamed from: b65  reason: default package */
/* compiled from: EAN13Reader */
public final class b65 extends r65 {
    public static final int[] j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    public final int[] i = new int[4];

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
            int k = r65.k(e45, iArr2, i3, r65.h);
            sb.append((char) ((k % 10) + 48));
            for (int i6 : iArr2) {
                i3 += i6;
            }
            if (k >= 10) {
                i4 |= 1 << (5 - i5);
            }
        }
        for (int i7 = 0; i7 < 10; i7++) {
            if (i4 == j[i7]) {
                sb.insert(0, (char) (i7 + 48));
                int[] iArr3 = r65.e;
                int i8 = r65.o(e45, i3, true, iArr3, new int[iArr3.length])[1];
                for (int i9 = 0; i9 < 6 && i8 < i2; i9++) {
                    sb.append((char) (r65.k(e45, iArr2, i8, r65.g) + 48));
                    for (int i10 : iArr2) {
                        i8 += i10;
                    }
                }
                return i8;
            }
        }
        throw a35.h;
    }

    @Override // defpackage.r65
    public o25 q() {
        return o25.EAN_13;
    }
}
