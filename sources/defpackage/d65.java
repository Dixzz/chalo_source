package defpackage;

/* renamed from: d65  reason: default package */
/* compiled from: EAN8Reader */
public final class d65 extends r65 {
    public final int[] i = new int[4];

    @Override // defpackage.r65
    public int m(e45 e45, int[] iArr, StringBuilder sb) throws a35 {
        int[][] iArr2 = r65.g;
        int[] iArr3 = this.i;
        iArr3[0] = 0;
        iArr3[1] = 0;
        iArr3[2] = 0;
        iArr3[3] = 0;
        int i2 = e45.g;
        int i3 = iArr[1];
        for (int i4 = 0; i4 < 4 && i3 < i2; i4++) {
            sb.append((char) (r65.k(e45, iArr3, i3, iArr2) + 48));
            for (int i5 : iArr3) {
                i3 += i5;
            }
        }
        int[] iArr4 = r65.e;
        int i6 = r65.o(e45, i3, true, iArr4, new int[iArr4.length])[1];
        for (int i7 = 0; i7 < 4 && i6 < i2; i7++) {
            sb.append((char) (r65.k(e45, iArr3, i6, iArr2) + 48));
            for (int i8 : iArr3) {
                i6 += i8;
            }
        }
        return i6;
    }

    @Override // defpackage.r65
    public o25 q() {
        return o25.EAN_8;
    }
}
