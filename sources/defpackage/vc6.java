package defpackage;

/* renamed from: vc6  reason: default package */
/* compiled from: JobSupport.kt */
public abstract class vc6 extends gb6 implements yb6, mc6 {
    public wc6 i;

    @Override // defpackage.mc6
    public boolean a() {
        return true;
    }

    @Override // defpackage.mc6
    public bd6 d() {
        return null;
    }

    @Override // defpackage.yb6
    public void h() {
        Object J;
        wc6 w = w();
        do {
            J = w.J();
            if (J instanceof vc6) {
                if (J != this) {
                    return;
                }
            } else if ((J instanceof mc6) && ((mc6) J).d() != null) {
                s();
                return;
            } else {
                return;
            }
        } while (!wc6.f.compareAndSet(w, J, xc6.g));
    }

    @Override // defpackage.uf6
    public String toString() {
        return getClass().getSimpleName() + '@' + hd3.l1(this) + "[job@" + hd3.l1(w()) + ']';
    }

    public final wc6 w() {
        wc6 wc6 = this.i;
        if (wc6 != null) {
            return wc6;
        }
        n86.l("job");
        throw null;
    }
}
