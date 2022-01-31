package defpackage;

/* renamed from: x25  reason: default package */
/* compiled from: LuminanceSource */
public abstract class x25 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3874a;
    public final int b;

    public x25(int i, int i2) {
        this.f3874a = i;
        this.b = i2;
    }

    public abstract byte[] a();

    public abstract byte[] b(int i, byte[] bArr);

    public x25 c() {
        return new w25(this);
    }

    public boolean d() {
        return false;
    }

    public x25 e() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i = this.f3874a;
        byte[] bArr = new byte[i];
        StringBuilder sb = new StringBuilder((i + 1) * this.b);
        for (int i2 = 0; i2 < this.b; i2++) {
            bArr = b(i2, bArr);
            for (int i3 = 0; i3 < this.f3874a; i3++) {
                int i4 = bArr[i3] & 255;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
