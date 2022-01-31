package defpackage;

import java.lang.reflect.Array;

/* renamed from: o85  reason: default package */
/* compiled from: BarcodeMatrix */
public final class o85 {

    /* renamed from: a  reason: collision with root package name */
    public final p85[] f2664a;
    public int b;
    public final int c;
    public final int d;

    public o85(int i, int i2) {
        p85[] p85Arr = new p85[i];
        this.f2664a = p85Arr;
        int length = p85Arr.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f2664a[i3] = new p85(hj1.b(i2, 4, 17, 1));
        }
        this.d = i2 * 17;
        this.c = i;
        this.b = -1;
    }

    public p85 a() {
        return this.f2664a[this.b];
    }

    public byte[][] b(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = this.d * i;
        iArr[0] = this.c * i2;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        int i3 = this.c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i3 - i4) - 1;
            p85 p85 = this.f2664a[i4 / i2];
            int length = p85.f2780a.length * i;
            byte[] bArr2 = new byte[length];
            for (int i6 = 0; i6 < length; i6++) {
                bArr2[i6] = p85.f2780a[i6 / i];
            }
            bArr[i5] = bArr2;
        }
        return bArr;
    }
}
