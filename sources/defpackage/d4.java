package defpackage;

/* renamed from: d4  reason: default package */
/* compiled from: GuidelineReference */
public class d4 extends i4 {
    public d4(n3 n3Var) {
        super(n3Var);
        n3Var.d.f();
        n3Var.e.f();
        this.f = ((q3) n3Var).i0;
    }

    @Override // defpackage.z3, defpackage.i4
    public void a(z3 z3Var) {
        b4 b4Var = this.h;
        if (b4Var.c && !b4Var.j) {
            this.h.c((int) ((((float) b4Var.l.get(0).g) * ((q3) this.b).e0) + 0.5f));
        }
    }

    @Override // defpackage.i4
    public void d() {
        n3 n3Var = this.b;
        q3 q3Var = (q3) n3Var;
        int i = q3Var.f0;
        int i2 = q3Var.g0;
        if (q3Var.i0 == 1) {
            if (i != -1) {
                this.h.l.add(n3Var.K.d.h);
                this.b.K.d.h.k.add(this.h);
                this.h.f = i;
            } else if (i2 != -1) {
                this.h.l.add(n3Var.K.d.i);
                this.b.K.d.i.k.add(this.h);
                this.h.f = -i2;
            } else {
                b4 b4Var = this.h;
                b4Var.b = true;
                b4Var.l.add(n3Var.K.d.i);
                this.b.K.d.i.k.add(this.h);
            }
            m(this.b.d.h);
            m(this.b.d.i);
            return;
        }
        if (i != -1) {
            this.h.l.add(n3Var.K.e.h);
            this.b.K.e.h.k.add(this.h);
            this.h.f = i;
        } else if (i2 != -1) {
            this.h.l.add(n3Var.K.e.i);
            this.b.K.e.i.k.add(this.h);
            this.h.f = -i2;
        } else {
            b4 b4Var2 = this.h;
            b4Var2.b = true;
            b4Var2.l.add(n3Var.K.e.i);
            this.b.K.e.i.k.add(this.h);
        }
        m(this.b.e.h);
        m(this.b.e.i);
    }

    @Override // defpackage.i4
    public void e() {
        n3 n3Var = this.b;
        if (((q3) n3Var).i0 == 1) {
            n3Var.P = this.h.g;
        } else {
            n3Var.Q = this.h.g;
        }
    }

    @Override // defpackage.i4
    public void f() {
        this.h.b();
    }

    @Override // defpackage.i4
    public boolean k() {
        return false;
    }

    public final void m(b4 b4Var) {
        this.h.k.add(b4Var);
        b4Var.l.add(this.h);
    }
}
