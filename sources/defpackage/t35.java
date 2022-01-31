package defpackage;

/* renamed from: t35  reason: default package */
/* compiled from: SimpleToken */
public final class t35 extends v35 {
    public final short c;
    public final short d;

    public t35(v35 v35, int i, int i2) {
        super(v35);
        this.c = (short) i;
        this.d = (short) i2;
    }

    @Override // defpackage.v35
    public void a(e45 e45, byte[] bArr) {
        e45.c(this.c, this.d);
    }

    public String toString() {
        short s = this.c;
        short s2 = this.d;
        int i = (s & ((1 << s2) - 1)) | (1 << s2);
        return "<" + Integer.toBinaryString(i | (1 << this.d)).substring(1) + '>';
    }
}
