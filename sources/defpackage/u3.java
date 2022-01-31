package defpackage;

import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.n3;
import defpackage.x3;

/* renamed from: u3  reason: default package */
/* compiled from: VirtualLayout */
public class u3 extends s3 {
    public int g0 = 0;
    public int h0 = 0;
    public int i0 = 0;
    public int j0 = 0;
    public int k0 = 0;
    public int l0 = 0;
    public boolean m0 = false;
    public int n0 = 0;
    public int o0 = 0;
    public x3.a p0 = new x3.a();
    public x3.b q0 = null;

    public void J(int i, int i2, int i3, int i4) {
    }

    public void K(n3 n3Var, n3.a aVar, int i, n3.a aVar2, int i2) {
        x3.b bVar;
        n3 n3Var2;
        while (true) {
            bVar = this.q0;
            if (bVar != null || (n3Var2 = this.K) == null) {
                x3.a aVar3 = this.p0;
                aVar3.f3877a = aVar;
                aVar3.b = aVar2;
                aVar3.c = i;
                aVar3.d = i2;
                ((ConstraintLayout.b) bVar).a(n3Var, aVar3);
                n3Var.G(this.p0.e);
                n3Var.B(this.p0.f);
                x3.a aVar4 = this.p0;
                n3Var.w = aVar4.h;
                n3Var.A(aVar4.g);
            } else {
                this.q0 = ((o3) n3Var2).h0;
            }
        }
        x3.a aVar32 = this.p0;
        aVar32.f3877a = aVar;
        aVar32.b = aVar2;
        aVar32.c = i;
        aVar32.d = i2;
        ((ConstraintLayout.b) bVar).a(n3Var, aVar32);
        n3Var.G(this.p0.e);
        n3Var.B(this.p0.f);
        x3.a aVar42 = this.p0;
        n3Var.w = aVar42.h;
        n3Var.A(aVar42.g);
    }

    @Override // defpackage.s3, defpackage.r3
    public void a(o3 o3Var) {
        for (int i = 0; i < this.f0; i++) {
            n3 n3Var = this.e0[i];
        }
    }
}
