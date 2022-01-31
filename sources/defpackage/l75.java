package defpackage;

/* renamed from: l75  reason: default package */
/* compiled from: AI01weightDecoder */
public abstract class l75 extends k75 {
    public l75(e45 e45) {
        super(e45);
    }

    public abstract void d(StringBuilder sb, int i);

    public abstract int e(int i);

    public final void f(StringBuilder sb, int i, int i2) {
        int d = v75.d(this.b.f3614a, i, i2);
        d(sb, d);
        int e = e(d);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (e / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(e);
    }
}
