package defpackage;

import defpackage.b4;

/* renamed from: c4  reason: default package */
/* compiled from: DimensionDependency */
public class c4 extends b4 {
    public int m;

    public c4(i4 i4Var) {
        super(i4Var);
        if (i4Var instanceof f4) {
            this.e = b4.a.HORIZONTAL_DIMENSION;
        } else {
            this.e = b4.a.VERTICAL_DIMENSION;
        }
    }

    @Override // defpackage.b4
    public void c(int i) {
        if (!this.j) {
            this.j = true;
            this.g = i;
            for (z3 z3Var : this.k) {
                z3Var.a(z3Var);
            }
        }
    }
}
