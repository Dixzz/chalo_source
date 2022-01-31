package defpackage;

import defpackage.m3;
import defpackage.n3;

/* renamed from: q3  reason: default package */
/* compiled from: Guideline */
public class q3 extends n3 {
    public float e0 = -1.0f;
    public int f0 = -1;
    public int g0 = -1;
    public m3 h0 = this.z;
    public int i0;

    public q3() {
        this.i0 = 0;
        this.H.clear();
        this.H.add(this.h0);
        int length = this.G.length;
        for (int i = 0; i < length; i++) {
            this.G[i] = this.h0;
        }
    }

    @Override // defpackage.n3
    public void I(f3 f3Var) {
        if (this.K != null) {
            int o = f3Var.o(this.h0);
            if (this.i0 == 1) {
                this.P = o;
                this.Q = 0;
                B(this.K.k());
                G(0);
                return;
            }
            this.P = 0;
            this.Q = o;
            G(this.K.q());
            B(0);
        }
    }

    public void J(int i) {
        if (this.i0 != i) {
            this.i0 = i;
            this.H.clear();
            if (this.i0 == 1) {
                this.h0 = this.y;
            } else {
                this.h0 = this.z;
            }
            this.H.add(this.h0);
            int length = this.G.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.G[i2] = this.h0;
            }
        }
    }

    @Override // defpackage.n3
    public void b(f3 f3Var) {
        o3 o3Var = (o3) this.K;
        if (o3Var != null) {
            m3 h = o3Var.h(m3.a.LEFT);
            m3 h2 = o3Var.h(m3.a.RIGHT);
            n3 n3Var = this.K;
            boolean z = true;
            boolean z2 = n3Var != null && n3Var.J[0] == n3.a.WRAP_CONTENT;
            if (this.i0 == 0) {
                h = o3Var.h(m3.a.TOP);
                h2 = o3Var.h(m3.a.BOTTOM);
                n3 n3Var2 = this.K;
                if (n3Var2 == null || n3Var2.J[1] != n3.a.WRAP_CONTENT) {
                    z = false;
                }
                z2 = z;
            }
            if (this.f0 != -1) {
                i3 l = f3Var.l(this.h0);
                f3Var.d(l, f3Var.l(h), this.f0, 8);
                if (z2) {
                    f3Var.f(f3Var.l(h2), l, 0, 5);
                }
            } else if (this.g0 != -1) {
                i3 l2 = f3Var.l(this.h0);
                i3 l3 = f3Var.l(h2);
                f3Var.d(l2, l3, -this.g0, 8);
                if (z2) {
                    f3Var.f(l2, f3Var.l(h), 0, 5);
                    f3Var.f(l3, l2, 0, 5);
                }
            } else if (this.e0 != -1.0f) {
                i3 l4 = f3Var.l(this.h0);
                i3 l5 = f3Var.l(h2);
                float f = this.e0;
                d3 m = f3Var.m();
                m.d.i(l4, -1.0f);
                m.d.i(l5, f);
                f3Var.c(m);
            }
        }
    }

    @Override // defpackage.n3
    public boolean c() {
        return true;
    }

    @Override // defpackage.n3
    public m3 h(m3.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.i0 == 1) {
                    return this.h0;
                }
                break;
            case 2:
            case 4:
                if (this.i0 == 0) {
                    return this.h0;
                }
                break;
        }
        throw new AssertionError(aVar.name());
    }
}
