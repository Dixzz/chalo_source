package defpackage;

import defpackage.n3;

/* renamed from: k3  reason: default package */
/* compiled from: Barrier */
public class k3 extends s3 {
    public int g0 = 0;
    public boolean h0 = true;
    public int i0 = 0;

    @Override // defpackage.n3
    public void b(f3 f3Var) {
        Object[] objArr;
        boolean z;
        int i;
        int i2;
        int i3;
        m3[] m3VarArr = this.G;
        m3VarArr[0] = this.y;
        m3VarArr[2] = this.z;
        m3VarArr[1] = this.A;
        m3VarArr[3] = this.B;
        int i4 = 0;
        while (true) {
            objArr = this.G;
            if (i4 >= objArr.length) {
                break;
            }
            objArr[i4].g = f3Var.l(objArr[i4]);
            i4++;
        }
        int i5 = this.g0;
        if (i5 >= 0 && i5 < 4) {
            m3 m3Var = objArr[i5];
            int i6 = 0;
            while (true) {
                if (i6 >= this.f0) {
                    z = false;
                    break;
                }
                n3 n3Var = this.e0[i6];
                if ((this.h0 || n3Var.c()) && ((((i2 = this.g0) == 0 || i2 == 1) && n3Var.l() == n3.a.MATCH_CONSTRAINT && n3Var.y.d != null && n3Var.A.d != null) || (((i3 = this.g0) == 2 || i3 == 3) && n3Var.p() == n3.a.MATCH_CONSTRAINT && n3Var.z.d != null && n3Var.B.d != null))) {
                    z = true;
                } else {
                    i6++;
                }
            }
            z = true;
            boolean z2 = this.y.e() || this.A.e();
            boolean z3 = this.z.e() || this.B.e();
            boolean z4 = !z && (((i = this.g0) == 0 && z2) || ((i == 2 && z3) || ((i == 1 && z2) || (i == 3 && z3))));
            int i7 = 5;
            if (!z4) {
                i7 = 4;
            }
            for (int i8 = 0; i8 < this.f0; i8++) {
                n3 n3Var2 = this.e0[i8];
                if (this.h0 || n3Var2.c()) {
                    i3 l = f3Var.l(n3Var2.G[this.g0]);
                    m3[] m3VarArr2 = n3Var2.G;
                    int i9 = this.g0;
                    m3VarArr2[i9].g = l;
                    int i10 = (m3VarArr2[i9].d == null || m3VarArr2[i9].d.b != this) ? 0 : m3VarArr2[i9].e + 0;
                    if (i9 == 0 || i9 == 2) {
                        d3 m = f3Var.m();
                        i3 n = f3Var.n();
                        n.d = 0;
                        m.f(m3Var.g, l, n, this.i0 - i10);
                        f3Var.c(m);
                    } else {
                        d3 m2 = f3Var.m();
                        i3 n2 = f3Var.n();
                        n2.d = 0;
                        m2.e(m3Var.g, l, n2, this.i0 + i10);
                        f3Var.c(m2);
                    }
                    f3Var.d(m3Var.g, l, this.i0 + i10, i7);
                }
            }
            int i11 = this.g0;
            if (i11 == 0) {
                f3Var.d(this.A.g, this.y.g, 0, 8);
                f3Var.d(this.y.g, this.K.A.g, 0, 4);
                f3Var.d(this.y.g, this.K.y.g, 0, 0);
            } else if (i11 == 1) {
                f3Var.d(this.y.g, this.A.g, 0, 8);
                f3Var.d(this.y.g, this.K.y.g, 0, 4);
                f3Var.d(this.y.g, this.K.A.g, 0, 0);
            } else if (i11 == 2) {
                f3Var.d(this.B.g, this.z.g, 0, 8);
                f3Var.d(this.z.g, this.K.B.g, 0, 4);
                f3Var.d(this.z.g, this.K.z.g, 0, 0);
            } else if (i11 == 3) {
                f3Var.d(this.z.g, this.B.g, 0, 8);
                f3Var.d(this.z.g, this.K.z.g, 0, 4);
                f3Var.d(this.z.g, this.K.B.g, 0, 0);
            }
        }
    }

    @Override // defpackage.n3
    public boolean c() {
        return true;
    }

    @Override // defpackage.n3
    public String toString() {
        String a0 = hj1.a0(hj1.i0("[Barrier] "), this.Y, " {");
        for (int i = 0; i < this.f0; i++) {
            n3 n3Var = this.e0[i];
            if (i > 0) {
                a0 = hj1.S(a0, ", ");
            }
            StringBuilder i02 = hj1.i0(a0);
            i02.append(n3Var.Y);
            a0 = i02.toString();
        }
        return hj1.S(a0, "}");
    }
}
