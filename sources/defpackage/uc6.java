package defpackage;

/* renamed from: uc6  reason: default package */
/* compiled from: JobSupport.kt */
public class uc6 extends wc6 implements cb6 {
    public final boolean g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public uc6(rc6 rc6) {
        super(true);
        boolean z = true;
        M(rc6);
        wa6 I = I();
        xa6 xa6 = I instanceof xa6 ? (xa6) I : null;
        if (xa6 != null) {
            wc6 w = xa6.w();
            while (true) {
                if (w.F()) {
                    break;
                }
                wa6 I2 = w.I();
                xa6 xa62 = I2 instanceof xa6 ? (xa6) I2 : null;
                if (xa62 == null) {
                    break;
                }
                w = xa62.w();
            }
            this.g = z;
        }
        z = false;
        this.g = z;
    }

    @Override // defpackage.wc6
    public boolean F() {
        return this.g;
    }

    @Override // defpackage.wc6
    public boolean G() {
        return true;
    }
}
