package defpackage;

import defpackage.b4;

/* renamed from: e4  reason: default package */
/* compiled from: HelperReferences */
public class e4 extends i4 {
    public e4(n3 n3Var) {
        super(n3Var);
    }

    @Override // defpackage.z3, defpackage.i4
    public void a(z3 z3Var) {
        k3 k3Var = (k3) this.b;
        int i = k3Var.g0;
        int i2 = 0;
        int i3 = -1;
        for (b4 b4Var : this.h.l) {
            int i4 = b4Var.g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (i == 0 || i == 2) {
            this.h.c(i3 + k3Var.i0);
        } else {
            this.h.c(i2 + k3Var.i0);
        }
    }

    @Override // defpackage.i4
    public void d() {
        n3 n3Var = this.b;
        if (n3Var instanceof k3) {
            b4 b4Var = this.h;
            b4Var.b = true;
            k3 k3Var = (k3) n3Var;
            int i = k3Var.g0;
            boolean z = k3Var.h0;
            int i2 = 0;
            if (i == 0) {
                b4Var.e = b4.a.LEFT;
                while (i2 < k3Var.f0) {
                    n3 n3Var2 = k3Var.e0[i2];
                    if (z || n3Var2.X != 8) {
                        b4 b4Var2 = n3Var2.d.h;
                        b4Var2.k.add(this.h);
                        this.h.l.add(b4Var2);
                    }
                    i2++;
                }
                m(this.b.d.h);
                m(this.b.d.i);
            } else if (i == 1) {
                b4Var.e = b4.a.RIGHT;
                while (i2 < k3Var.f0) {
                    n3 n3Var3 = k3Var.e0[i2];
                    if (z || n3Var3.X != 8) {
                        b4 b4Var3 = n3Var3.d.i;
                        b4Var3.k.add(this.h);
                        this.h.l.add(b4Var3);
                    }
                    i2++;
                }
                m(this.b.d.h);
                m(this.b.d.i);
            } else if (i == 2) {
                b4Var.e = b4.a.TOP;
                while (i2 < k3Var.f0) {
                    n3 n3Var4 = k3Var.e0[i2];
                    if (z || n3Var4.X != 8) {
                        b4 b4Var4 = n3Var4.e.h;
                        b4Var4.k.add(this.h);
                        this.h.l.add(b4Var4);
                    }
                    i2++;
                }
                m(this.b.e.h);
                m(this.b.e.i);
            } else if (i == 3) {
                b4Var.e = b4.a.BOTTOM;
                while (i2 < k3Var.f0) {
                    n3 n3Var5 = k3Var.e0[i2];
                    if (z || n3Var5.X != 8) {
                        b4 b4Var5 = n3Var5.e.i;
                        b4Var5.k.add(this.h);
                        this.h.l.add(b4Var5);
                    }
                    i2++;
                }
                m(this.b.e.h);
                m(this.b.e.i);
            }
        }
    }

    @Override // defpackage.i4
    public void e() {
        n3 n3Var = this.b;
        if (n3Var instanceof k3) {
            int i = ((k3) n3Var).g0;
            if (i == 0 || i == 1) {
                n3Var.P = this.h.g;
            } else {
                n3Var.Q = this.h.g;
            }
        }
    }

    @Override // defpackage.i4
    public void f() {
        this.c = null;
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
