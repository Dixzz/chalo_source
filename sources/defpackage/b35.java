package defpackage;

/* renamed from: b35  reason: default package */
/* compiled from: PlanarYUVLuminanceSource */
public final class b35 extends x25 {
    public final byte[] c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public b35(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.c = bArr;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        if (z) {
            int i7 = (i4 * i) + i3;
            int i8 = 0;
            while (i8 < i6) {
                int i9 = (i5 / 2) + i7;
                int i10 = (i7 + i5) - 1;
                int i11 = i7;
                while (i11 < i9) {
                    byte b = bArr[i11];
                    bArr[i11] = bArr[i10];
                    bArr[i10] = b;
                    i11++;
                    i10--;
                }
                i8++;
                i7 += this.d;
            }
        }
    }

    @Override // defpackage.x25
    public byte[] a() {
        int i = this.f3874a;
        int i2 = this.b;
        int i3 = this.d;
        if (i == i3 && i2 == this.e) {
            return this.c;
        }
        int i4 = i * i2;
        byte[] bArr = new byte[i4];
        int i5 = (this.g * i3) + this.f;
        if (i == i3) {
            System.arraycopy(this.c, i5, bArr, 0, i4);
            return bArr;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            System.arraycopy(this.c, i5, bArr, i6 * i, i);
            i5 += this.d;
        }
        return bArr;
    }

    @Override // defpackage.x25
    public byte[] b(int i, byte[] bArr) {
        if (i < 0 || i >= this.b) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i)));
        }
        int i2 = this.f3874a;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.c, ((i + this.g) * this.d) + this.f, bArr, 0, i2);
        return bArr;
    }
}
