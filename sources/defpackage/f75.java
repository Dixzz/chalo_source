package defpackage;

/* renamed from: f75  reason: default package */
/* compiled from: AI01392xDecoder */
public final class f75 extends k75 {
    public f75(e45 e45) {
        super(e45);
    }

    @Override // defpackage.m75
    public String a() throws a35, v25 {
        if (this.f2335a.g >= 48) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            int c = this.b.c(48, 2);
            sb.append("(392");
            sb.append(c);
            sb.append(')');
            sb.append(this.b.b(50, null).b);
            return sb.toString();
        }
        throw a35.h;
    }
}
