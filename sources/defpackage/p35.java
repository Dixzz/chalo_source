package defpackage;

/* renamed from: p35  reason: default package */
/* compiled from: BinaryShiftToken */
public final class p35 extends v35 {
    public final short c;
    public final short d;

    public p35(v35 v35, int i, int i2) {
        super(v35);
        this.c = (short) i;
        this.d = (short) i2;
    }

    @Override // defpackage.v35
    public void a(e45 e45, byte[] bArr) {
        int i = 0;
        while (true) {
            short s = this.d;
            if (i < s) {
                if (i == 0 || (i == 31 && s <= 62)) {
                    e45.c(31, 5);
                    short s2 = this.d;
                    if (s2 > 62) {
                        e45.c(s2 - 31, 16);
                    } else if (i == 0) {
                        e45.c(Math.min((int) s2, 31), 5);
                    } else {
                        e45.c(s2 - 31, 5);
                    }
                }
                e45.c(bArr[this.c + i], 8);
                i++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.c);
        sb.append("::");
        sb.append((this.c + this.d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
