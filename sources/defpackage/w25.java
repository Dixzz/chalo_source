package defpackage;

/* renamed from: w25  reason: default package */
/* compiled from: InvertedLuminanceSource */
public final class w25 extends x25 {
    public final x25 c;

    public w25(x25 x25) {
        super(x25.f3874a, x25.b);
        this.c = x25;
    }

    @Override // defpackage.x25
    public byte[] a() {
        byte[] a2 = this.c.a();
        int i = this.f3874a * this.b;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (255 - (a2[i2] & 255));
        }
        return bArr;
    }

    @Override // defpackage.x25
    public byte[] b(int i, byte[] bArr) {
        byte[] b = this.c.b(i, bArr);
        int i2 = this.f3874a;
        for (int i3 = 0; i3 < i2; i3++) {
            b[i3] = (byte) (255 - (b[i3] & 255));
        }
        return b;
    }

    @Override // defpackage.x25
    public x25 c() {
        return this.c;
    }

    @Override // defpackage.x25
    public boolean d() {
        return this.c.d();
    }

    @Override // defpackage.x25
    public x25 e() {
        return new w25(this.c.e());
    }
}
