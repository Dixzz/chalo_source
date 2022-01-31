package defpackage;

/* renamed from: l45  reason: default package */
/* compiled from: HybridBinarizer */
public final class l45 extends p25 {
    public static final byte[] e = new byte[0];
    public byte[] b = e;
    public final int[] c = new int[32];
    public f45 d;

    public l45(x25 x25) {
        super(x25);
    }

    public static int a(int[] iArr) throws a35 {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] > i) {
                i = iArr[i4];
                i3 = i4;
            }
            if (iArr[i4] > i2) {
                i2 = iArr[i4];
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 - i3;
            int i9 = iArr[i7] * i8 * i8;
            if (i9 > i6) {
                i5 = i7;
                i6 = i9;
            }
        }
        if (i3 <= i5) {
            i3 = i5;
            i5 = i3;
        }
        if (i3 - i5 > length / 16) {
            int i10 = i3 - 1;
            int i11 = i10;
            int i12 = -1;
            while (i10 > i5) {
                int i13 = i10 - i5;
                int i14 = (i2 - iArr[i10]) * (i3 - i10) * i13 * i13;
                if (i14 > i12) {
                    i11 = i10;
                    i12 = i14;
                }
                i10--;
            }
            return i11 << 3;
        }
        throw a35.h;
    }

    public final void b(int i) {
        if (this.b.length < i) {
            this.b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.c[i2] = 0;
        }
    }
}
