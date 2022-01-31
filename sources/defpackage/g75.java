package defpackage;

/* renamed from: g75  reason: default package */
/* compiled from: AI01393xDecoder */
public final class g75 extends k75 {
    public g75(e45 e45) {
        super(e45);
    }

    @Override // defpackage.m75
    public String a() throws a35, v25 {
        if (this.f2335a.g >= 48) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            int c = this.b.c(48, 2);
            sb.append("(393");
            sb.append(c);
            sb.append(')');
            int c2 = this.b.c(50, 10);
            if (c2 / 100 == 0) {
                sb.append('0');
            }
            if (c2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(c2);
            sb.append(this.b.b(60, null).b);
            return sb.toString();
        }
        throw a35.h;
    }
}
