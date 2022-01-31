package defpackage;

/* renamed from: h75  reason: default package */
/* compiled from: AI013x0x1xDecoder */
public final class h75 extends l75 {
    public final String c;
    public final String d;

    public h75(e45 e45, String str, String str2) {
        super(e45);
        this.c = str2;
        this.d = str;
    }

    @Override // defpackage.m75
    public String a() throws a35 {
        if (this.f2335a.g == 84) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            f(sb, 48, 20);
            int d2 = v75.d(this.b.f3614a, 68, 16);
            if (d2 != 38400) {
                sb.append('(');
                sb.append(this.c);
                sb.append(')');
                int i = d2 % 32;
                int i2 = d2 / 32;
                int i3 = (i2 % 12) + 1;
                int i4 = i2 / 12;
                if (i4 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i4);
                if (i3 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i3);
                if (i / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i);
            }
            return sb.toString();
        }
        throw a35.h;
    }

    @Override // defpackage.l75
    public void d(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.d);
        sb.append(i / 100000);
        sb.append(')');
    }

    @Override // defpackage.l75
    public int e(int i) {
        return i % 100000;
    }
}
