package defpackage;

/* renamed from: dh3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class dh3 extends eh3 {
    public final int j;
    public final int k;

    public dh3(byte[] bArr, int i, int i2) {
        super(bArr);
        xg3.s(i, i + i2, bArr.length);
        this.j = i;
        this.k = i2;
    }

    @Override // defpackage.eh3, defpackage.xg3
    public final int size() {
        return this.k;
    }

    @Override // defpackage.eh3, defpackage.xg3
    public final byte u(int i) {
        int i2 = this.k;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.i[this.j + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(hj1.v(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(hj1.w(40, "Index > length: ", i, ", ", i2));
    }

    @Override // defpackage.eh3, defpackage.xg3
    public final byte v(int i) {
        return this.i[this.j + i];
    }

    @Override // defpackage.eh3
    public final int y() {
        return this.j;
    }
}
