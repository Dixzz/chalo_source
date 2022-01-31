package defpackage;

import defpackage.n3;
import defpackage.x3;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: o3  reason: default package */
/* compiled from: ConstraintWidgetContainer */
public class o3 extends v3 {
    public x3 f0 = new x3(this);
    public a4 g0 = new a4(this);
    public x3.b h0 = null;
    public boolean i0 = false;
    public f3 j0 = new f3();
    public int k0;
    public int l0;
    public int m0 = 0;
    public int n0 = 0;
    public l3[] o0 = new l3[4];
    public l3[] p0 = new l3[4];
    public int q0 = 263;
    public boolean r0 = false;
    public boolean s0 = false;

    @Override // defpackage.n3
    public void H(boolean z, boolean z2) {
        super.H(z, z2);
        int size = this.e0.size();
        for (int i = 0; i < size; i++) {
            this.e0.get(i).H(z, z2);
        }
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01da  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.v3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J() {
        /*
        // Method dump skipped, instructions count: 570
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o3.J():void");
    }

    public void K(n3 n3Var, int i) {
        if (i == 0) {
            int i2 = this.m0 + 1;
            l3[] l3VarArr = this.p0;
            if (i2 >= l3VarArr.length) {
                this.p0 = (l3[]) Arrays.copyOf(l3VarArr, l3VarArr.length * 2);
            }
            l3[] l3VarArr2 = this.p0;
            int i3 = this.m0;
            l3VarArr2[i3] = new l3(n3Var, 0, this.i0);
            this.m0 = i3 + 1;
        } else if (i == 1) {
            int i4 = this.n0 + 1;
            l3[] l3VarArr3 = this.o0;
            if (i4 >= l3VarArr3.length) {
                this.o0 = (l3[]) Arrays.copyOf(l3VarArr3, l3VarArr3.length * 2);
            }
            l3[] l3VarArr4 = this.o0;
            int i5 = this.n0;
            l3VarArr4[i5] = new l3(n3Var, 1, this.i0);
            this.n0 = i5 + 1;
        }
    }

    public boolean L(f3 f3Var) {
        b(f3Var);
        int size = this.e0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            n3 n3Var = this.e0.get(i);
            boolean[] zArr = n3Var.I;
            zArr[0] = false;
            zArr[1] = false;
            if (n3Var instanceof k3) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                n3 n3Var2 = this.e0.get(i2);
                if (n3Var2 instanceof k3) {
                    k3 k3Var = (k3) n3Var2;
                    for (int i3 = 0; i3 < k3Var.f0; i3++) {
                        n3 n3Var3 = k3Var.e0[i3];
                        int i4 = k3Var.g0;
                        if (i4 == 0 || i4 == 1) {
                            n3Var3.I[0] = true;
                        } else if (i4 == 2 || i4 == 3) {
                            n3Var3.I[1] = true;
                        }
                    }
                }
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            n3 n3Var4 = this.e0.get(i5);
            Objects.requireNonNull(n3Var4);
            if ((n3Var4 instanceof u3) || (n3Var4 instanceof q3)) {
                n3Var4.b(f3Var);
            }
        }
        for (int i6 = 0; i6 < size; i6++) {
            n3 n3Var5 = this.e0.get(i6);
            if (n3Var5 instanceof o3) {
                n3.a[] aVarArr = n3Var5.J;
                n3.a aVar = aVarArr[0];
                n3.a aVar2 = aVarArr[1];
                n3.a aVar3 = n3.a.WRAP_CONTENT;
                if (aVar == aVar3) {
                    n3Var5.C(n3.a.FIXED);
                }
                if (aVar2 == aVar3) {
                    n3Var5.F(n3.a.FIXED);
                }
                n3Var5.b(f3Var);
                if (aVar == aVar3) {
                    n3Var5.C(aVar);
                }
                if (aVar2 == aVar3) {
                    n3Var5.F(aVar2);
                }
            } else {
                n3Var5.h = -1;
                n3Var5.i = -1;
                n3.a aVar4 = this.J[0];
                n3.a aVar5 = n3.a.WRAP_CONTENT;
                if (aVar4 != aVar5 && n3Var5.J[0] == n3.a.MATCH_PARENT) {
                    int i7 = n3Var5.y.e;
                    int q = q() - n3Var5.A.e;
                    m3 m3Var = n3Var5.y;
                    m3Var.g = f3Var.l(m3Var);
                    m3 m3Var2 = n3Var5.A;
                    m3Var2.g = f3Var.l(m3Var2);
                    f3Var.e(n3Var5.y.g, i7);
                    f3Var.e(n3Var5.A.g, q);
                    n3Var5.h = 2;
                    n3Var5.P = i7;
                    int i8 = q - i7;
                    n3Var5.L = i8;
                    int i9 = n3Var5.S;
                    if (i8 < i9) {
                        n3Var5.L = i9;
                    }
                }
                if (this.J[1] != aVar5 && n3Var5.J[1] == n3.a.MATCH_PARENT) {
                    int i10 = n3Var5.z.e;
                    int k = k() - n3Var5.B.e;
                    m3 m3Var3 = n3Var5.z;
                    m3Var3.g = f3Var.l(m3Var3);
                    m3 m3Var4 = n3Var5.B;
                    m3Var4.g = f3Var.l(m3Var4);
                    f3Var.e(n3Var5.z.g, i10);
                    f3Var.e(n3Var5.B.g, k);
                    if (n3Var5.R > 0 || n3Var5.X == 8) {
                        m3 m3Var5 = n3Var5.C;
                        m3Var5.g = f3Var.l(m3Var5);
                        f3Var.e(n3Var5.C.g, n3Var5.R + i10);
                    }
                    n3Var5.i = 2;
                    n3Var5.Q = i10;
                    int i11 = k - i10;
                    n3Var5.M = i11;
                    int i12 = n3Var5.T;
                    if (i11 < i12) {
                        n3Var5.M = i12;
                    }
                }
                if (!((n3Var5 instanceof u3) || (n3Var5 instanceof q3))) {
                    n3Var5.b(f3Var);
                }
            }
        }
        if (this.m0 > 0) {
            h.f(this, f3Var, 0);
        }
        if (this.n0 > 0) {
            h.f(this, f3Var, 1);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0144 A[EDGE_INSN: B:77:0x0144->B:62:0x0144 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean M(boolean r11, int r12) {
        /*
        // Method dump skipped, instructions count: 335
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o3.M(boolean, int):boolean");
    }

    public void N() {
        this.g0.b = true;
    }

    public void O(int i) {
        this.q0 = i;
        f3.p = t3.a(i, 256);
    }

    @Override // defpackage.n3, defpackage.v3
    public void x() {
        this.j0.t();
        this.k0 = 0;
        this.l0 = 0;
        super.x();
    }
}
