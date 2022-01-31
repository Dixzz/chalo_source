package defpackage;

/* renamed from: vt3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class vt3 extends wt3 {
    public final int j;
    public final int k;

    public vt3(byte[] bArr, int i, int i2) {
        super(bArr);
        qt3.y(i, i + i2, bArr.length);
        this.j = i;
        this.k = i2;
    }

    @Override // defpackage.wt3
    public final int A() {
        return this.j;
    }

    @Override // defpackage.qt3, defpackage.wt3
    public final byte b(int i) {
        int i2 = this.k;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.i[this.j + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(hj1.v(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(hj1.w(40, "Index > length: ", i, ", ", i2));
    }

    @Override // defpackage.qt3, defpackage.wt3
    public final int d() {
        return this.k;
    }

    @Override // defpackage.qt3, defpackage.wt3
    public final byte v(int i) {
        return this.i[this.j + i];
    }
}
