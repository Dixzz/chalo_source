package defpackage;

/* renamed from: c93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class c93 extends e93 {
    public final int j;

    public c93(byte[] bArr, int i) {
        super(bArr);
        g93.E(0, i, bArr.length);
        this.j = i;
    }

    @Override // defpackage.e93
    public final int F() {
        return 0;
    }

    @Override // defpackage.g93, defpackage.e93
    public final byte b(int i) {
        int i2 = this.j;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.i[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(hj1.v(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(hj1.w(40, "Index > length: ", i, ", ", i2));
    }

    @Override // defpackage.g93, defpackage.e93
    public final byte d(int i) {
        return this.i[i];
    }

    @Override // defpackage.g93, defpackage.e93
    public final int e() {
        return this.j;
    }

    @Override // defpackage.g93, defpackage.e93
    public final void k(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.i, 0, bArr, 0, i3);
    }
}
