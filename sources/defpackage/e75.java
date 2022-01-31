package defpackage;

/* renamed from: e75  reason: default package */
/* compiled from: AI01320xDecoder */
public final class e75 extends i75 {
    public e75(e45 e45) {
        super(e45);
    }

    @Override // defpackage.l75
    public void d(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // defpackage.l75
    public int e(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
