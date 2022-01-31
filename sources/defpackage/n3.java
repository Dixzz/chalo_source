package defpackage;

import defpackage.m3;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: n3  reason: default package */
/* compiled from: ConstraintWidget */
public class n3 {
    public m3 A;
    public m3 B;
    public m3 C;
    public m3 D;
    public m3 E;
    public m3 F;
    public m3[] G;
    public ArrayList<m3> H;
    public boolean[] I;
    public a[] J;
    public n3 K;
    public int L;
    public int M;
    public float N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public float U;
    public float V;
    public Object W;
    public int X;
    public String Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2509a = false;
    public int a0;
    public y3 b;
    public float[] b0;
    public y3 c;
    public n3[] c0;
    public f4 d = new f4(this);
    public n3[] d0;
    public h4 e = new h4(this);
    public boolean[] f = {true, true};
    public int[] g = {0, 0, 0, 0};
    public int h = -1;
    public int i = -1;
    public int j = 0;
    public int k = 0;
    public int[] l = new int[2];
    public int m = 0;
    public int n = 0;
    public float o = 1.0f;
    public int p = 0;
    public int q = 0;
    public float r = 1.0f;
    public int s = -1;
    public float t = 1.0f;
    public int[] u = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float v = 0.0f;
    public boolean w = false;
    public boolean x;
    public m3 y;
    public m3 z;

    /* renamed from: n3$a */
    /* compiled from: ConstraintWidget */
    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public n3() {
        m3 m3Var = new m3(this, m3.a.LEFT);
        this.y = m3Var;
        m3 m3Var2 = new m3(this, m3.a.TOP);
        this.z = m3Var2;
        m3 m3Var3 = new m3(this, m3.a.RIGHT);
        this.A = m3Var3;
        m3 m3Var4 = new m3(this, m3.a.BOTTOM);
        this.B = m3Var4;
        m3 m3Var5 = new m3(this, m3.a.BASELINE);
        this.C = m3Var5;
        this.D = new m3(this, m3.a.CENTER_X);
        this.E = new m3(this, m3.a.CENTER_Y);
        m3 m3Var6 = new m3(this, m3.a.CENTER);
        this.F = m3Var6;
        this.G = new m3[]{m3Var, m3Var3, m3Var2, m3Var4, m3Var5, m3Var6};
        ArrayList<m3> arrayList = new ArrayList<>();
        this.H = arrayList;
        this.I = new boolean[2];
        a aVar = a.FIXED;
        this.J = new a[]{aVar, aVar};
        this.K = null;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.U = 0.5f;
        this.V = 0.5f;
        this.X = 0;
        this.Y = null;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = new float[]{-1.0f, -1.0f};
        this.c0 = new n3[]{null, null};
        this.d0 = new n3[]{null, null};
        arrayList.add(this.y);
        this.H.add(this.z);
        this.H.add(this.A);
        this.H.add(this.B);
        this.H.add(this.D);
        this.H.add(this.E);
        this.H.add(this.F);
        this.H.add(this.C);
    }

    public void A(int i2) {
        this.R = i2;
        this.w = i2 > 0;
    }

    public void B(int i2) {
        this.M = i2;
        int i3 = this.T;
        if (i2 < i3) {
            this.M = i3;
        }
    }

    public void C(a aVar) {
        this.J[0] = aVar;
    }

    public void D(int i2) {
        if (i2 < 0) {
            this.T = 0;
        } else {
            this.T = i2;
        }
    }

    public void E(int i2) {
        if (i2 < 0) {
            this.S = 0;
        } else {
            this.S = i2;
        }
    }

    public void F(a aVar) {
        this.J[1] = aVar;
    }

    public void G(int i2) {
        this.L = i2;
        int i3 = this.S;
        if (i2 < i3) {
            this.L = i3;
        }
    }

    public void H(boolean z2, boolean z3) {
        int i2;
        int i3;
        f4 f4Var = this.d;
        boolean z4 = z2 & f4Var.g;
        h4 h4Var = this.e;
        boolean z5 = z3 & h4Var.g;
        int i4 = f4Var.h.g;
        int i5 = h4Var.h.g;
        int i6 = f4Var.i.g;
        int i7 = h4Var.i.g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i7 = 0;
            i4 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (z4) {
            this.P = i4;
        }
        if (z5) {
            this.Q = i5;
        }
        if (this.X == 8) {
            this.L = 0;
            this.M = 0;
            return;
        }
        if (z4) {
            if (this.J[0] == a.FIXED && i9 < (i3 = this.L)) {
                i9 = i3;
            }
            this.L = i9;
            int i11 = this.S;
            if (i9 < i11) {
                this.L = i11;
            }
        }
        if (z5) {
            if (this.J[1] == a.FIXED && i10 < (i2 = this.M)) {
                i10 = i2;
            }
            this.M = i10;
            int i12 = this.T;
            if (i10 < i12) {
                this.M = i12;
            }
        }
    }

    public void I(f3 f3Var) {
        int i2;
        int i3;
        int o2 = f3Var.o(this.y);
        int o3 = f3Var.o(this.z);
        int o4 = f3Var.o(this.A);
        int o5 = f3Var.o(this.B);
        f4 f4Var = this.d;
        b4 b4Var = f4Var.h;
        if (b4Var.j) {
            b4 b4Var2 = f4Var.i;
            if (b4Var2.j) {
                o2 = b4Var.g;
                o4 = b4Var2.g;
            }
        }
        h4 h4Var = this.e;
        b4 b4Var3 = h4Var.h;
        if (b4Var3.j) {
            b4 b4Var4 = h4Var.i;
            if (b4Var4.j) {
                o3 = b4Var3.g;
                o5 = b4Var4.g;
            }
        }
        int i4 = o5 - o3;
        if (o4 - o2 < 0 || i4 < 0 || o2 == Integer.MIN_VALUE || o2 == Integer.MAX_VALUE || o3 == Integer.MIN_VALUE || o3 == Integer.MAX_VALUE || o4 == Integer.MIN_VALUE || o4 == Integer.MAX_VALUE || o5 == Integer.MIN_VALUE || o5 == Integer.MAX_VALUE) {
            o5 = 0;
            o2 = 0;
            o3 = 0;
            o4 = 0;
        }
        int i5 = o4 - o2;
        int i6 = o5 - o3;
        this.P = o2;
        this.Q = o3;
        if (this.X == 8) {
            this.L = 0;
            this.M = 0;
            return;
        }
        a[] aVarArr = this.J;
        a aVar = aVarArr[0];
        a aVar2 = a.FIXED;
        if (aVar == aVar2 && i5 < (i3 = this.L)) {
            i5 = i3;
        }
        if (aVarArr[1] == aVar2 && i6 < (i2 = this.M)) {
            i6 = i2;
        }
        this.L = i5;
        this.M = i6;
        int i7 = this.T;
        if (i6 < i7) {
            this.M = i7;
        }
        int i8 = this.S;
        if (i5 < i8) {
            this.L = i8;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:188:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x046c  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x046f  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0526  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0557  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0561  */
    /* JADX WARNING: Removed duplicated region for block: B:302:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(defpackage.f3 r47) {
        /*
        // Method dump skipped, instructions count: 1523
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n3.b(f3):void");
    }

    public boolean c() {
        return this.X != 8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:146:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0297  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x02dd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x03a4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x03c9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:285:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:289:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x019c A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(defpackage.f3 r31, boolean r32, boolean r33, boolean r34, boolean r35, defpackage.i3 r36, defpackage.i3 r37, defpackage.n3.a r38, boolean r39, defpackage.m3 r40, defpackage.m3 r41, int r42, int r43, int r44, int r45, float r46, boolean r47, boolean r48, boolean r49, boolean r50, int r51, int r52, int r53, int r54, float r55, boolean r56) {
        /*
        // Method dump skipped, instructions count: 1030
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n3.d(f3, boolean, boolean, boolean, boolean, i3, i3, n3$a, boolean, m3, m3, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public void e(m3.a aVar, n3 n3Var, m3.a aVar2, int i2) {
        m3.a aVar3;
        m3.a aVar4;
        boolean z2;
        m3.a aVar5 = m3.a.CENTER;
        if (aVar != aVar5) {
            m3.a aVar6 = m3.a.CENTER_X;
            if (aVar == aVar6 && (aVar2 == (aVar4 = m3.a.LEFT) || aVar2 == m3.a.RIGHT)) {
                m3 h2 = h(aVar4);
                m3 h3 = n3Var.h(aVar2);
                m3 h4 = h(m3.a.RIGHT);
                h2.a(h3, 0);
                h4.a(h3, 0);
                h(aVar6).a(h3, 0);
                return;
            }
            m3.a aVar7 = m3.a.CENTER_Y;
            if (aVar == aVar7 && (aVar2 == (aVar3 = m3.a.TOP) || aVar2 == m3.a.BOTTOM)) {
                m3 h5 = n3Var.h(aVar2);
                h(aVar3).a(h5, 0);
                h(m3.a.BOTTOM).a(h5, 0);
                h(aVar7).a(h5, 0);
            } else if (aVar == aVar6 && aVar2 == aVar6) {
                m3.a aVar8 = m3.a.LEFT;
                h(aVar8).a(n3Var.h(aVar8), 0);
                m3.a aVar9 = m3.a.RIGHT;
                h(aVar9).a(n3Var.h(aVar9), 0);
                h(aVar6).a(n3Var.h(aVar2), 0);
            } else if (aVar == aVar7 && aVar2 == aVar7) {
                m3.a aVar10 = m3.a.TOP;
                h(aVar10).a(n3Var.h(aVar10), 0);
                m3.a aVar11 = m3.a.BOTTOM;
                h(aVar11).a(n3Var.h(aVar11), 0);
                h(aVar7).a(n3Var.h(aVar2), 0);
            } else {
                m3 h6 = h(aVar);
                m3 h7 = n3Var.h(aVar2);
                if (h6.g(h7)) {
                    m3.a aVar12 = m3.a.BASELINE;
                    if (aVar == aVar12) {
                        m3 h8 = h(m3.a.TOP);
                        m3 h9 = h(m3.a.BOTTOM);
                        if (h8 != null) {
                            h8.h();
                        }
                        if (h9 != null) {
                            h9.h();
                        }
                        i2 = 0;
                    } else if (aVar == m3.a.TOP || aVar == m3.a.BOTTOM) {
                        m3 h10 = h(aVar12);
                        if (h10 != null) {
                            h10.h();
                        }
                        m3 h11 = h(aVar5);
                        if (h11.d != h7) {
                            h11.h();
                        }
                        m3 d2 = h(aVar).d();
                        m3 h12 = h(aVar7);
                        if (h12.f()) {
                            d2.h();
                            h12.h();
                        }
                    } else if (aVar == m3.a.LEFT || aVar == m3.a.RIGHT) {
                        m3 h13 = h(aVar5);
                        if (h13.d != h7) {
                            h13.h();
                        }
                        m3 d3 = h(aVar).d();
                        m3 h14 = h(aVar6);
                        if (h14.f()) {
                            d3.h();
                            h14.h();
                        }
                    }
                    h6.a(h7, i2);
                }
            }
        } else if (aVar2 == aVar5) {
            m3.a aVar13 = m3.a.LEFT;
            m3 h15 = h(aVar13);
            m3.a aVar14 = m3.a.RIGHT;
            m3 h16 = h(aVar14);
            m3.a aVar15 = m3.a.TOP;
            m3 h17 = h(aVar15);
            m3.a aVar16 = m3.a.BOTTOM;
            m3 h18 = h(aVar16);
            boolean z3 = true;
            if ((h15 == null || !h15.f()) && (h16 == null || !h16.f())) {
                e(aVar13, n3Var, aVar13, 0);
                e(aVar14, n3Var, aVar14, 0);
                z2 = true;
            } else {
                z2 = false;
            }
            if ((h17 == null || !h17.f()) && (h18 == null || !h18.f())) {
                e(aVar15, n3Var, aVar15, 0);
                e(aVar16, n3Var, aVar16, 0);
            } else {
                z3 = false;
            }
            if (z2 && z3) {
                h(aVar5).a(n3Var.h(aVar5), 0);
            } else if (z2) {
                m3.a aVar17 = m3.a.CENTER_X;
                h(aVar17).a(n3Var.h(aVar17), 0);
            } else if (z3) {
                m3.a aVar18 = m3.a.CENTER_Y;
                h(aVar18).a(n3Var.h(aVar18), 0);
            }
        } else {
            m3.a aVar19 = m3.a.LEFT;
            if (aVar2 == aVar19 || aVar2 == m3.a.RIGHT) {
                e(aVar19, n3Var, aVar2, 0);
                e(m3.a.RIGHT, n3Var, aVar2, 0);
                h(aVar5).a(n3Var.h(aVar2), 0);
                return;
            }
            m3.a aVar20 = m3.a.TOP;
            if (aVar2 == aVar20 || aVar2 == m3.a.BOTTOM) {
                e(aVar20, n3Var, aVar2, 0);
                e(m3.a.BOTTOM, n3Var, aVar2, 0);
                h(aVar5).a(n3Var.h(aVar2), 0);
            }
        }
    }

    public void f(m3 m3Var, m3 m3Var2, int i2) {
        if (m3Var.b == this) {
            e(m3Var.c, m3Var2.b, m3Var2.c, i2);
        }
    }

    public void g(f3 f3Var) {
        f3Var.l(this.y);
        f3Var.l(this.z);
        f3Var.l(this.A);
        f3Var.l(this.B);
        if (this.R > 0) {
            f3Var.l(this.C);
        }
    }

    public m3 h(m3.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.y;
            case 2:
                return this.z;
            case 3:
                return this.A;
            case 4:
                return this.B;
            case 5:
                return this.C;
            case 6:
                return this.F;
            case 7:
                return this.D;
            case 8:
                return this.E;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public int i() {
        return s() + this.M;
    }

    public a j(int i2) {
        if (i2 == 0) {
            return l();
        }
        if (i2 == 1) {
            return p();
        }
        return null;
    }

    public int k() {
        if (this.X == 8) {
            return 0;
        }
        return this.M;
    }

    public a l() {
        return this.J[0];
    }

    public n3 m(int i2) {
        m3 m3Var;
        m3 m3Var2;
        if (i2 == 0) {
            m3 m3Var3 = this.A;
            m3 m3Var4 = m3Var3.d;
            if (m3Var4 == null || m3Var4.d != m3Var3) {
                return null;
            }
            return m3Var4.b;
        } else if (i2 == 1 && (m3Var2 = (m3Var = this.B).d) != null && m3Var2.d == m3Var) {
            return m3Var2.b;
        } else {
            return null;
        }
    }

    public n3 n(int i2) {
        m3 m3Var;
        m3 m3Var2;
        if (i2 == 0) {
            m3 m3Var3 = this.y;
            m3 m3Var4 = m3Var3.d;
            if (m3Var4 == null || m3Var4.d != m3Var3) {
                return null;
            }
            return m3Var4.b;
        } else if (i2 == 1 && (m3Var2 = (m3Var = this.z).d) != null && m3Var2.d == m3Var) {
            return m3Var2.b;
        } else {
            return null;
        }
    }

    public int o() {
        return r() + this.L;
    }

    public a p() {
        return this.J[1];
    }

    public int q() {
        if (this.X == 8) {
            return 0;
        }
        return this.L;
    }

    public int r() {
        n3 n3Var = this.K;
        if (n3Var == null || !(n3Var instanceof o3)) {
            return this.P;
        }
        return ((o3) n3Var).k0 + this.P;
    }

    public int s() {
        n3 n3Var = this.K;
        if (n3Var == null || !(n3Var instanceof o3)) {
            return this.Q;
        }
        return ((o3) n3Var).l0 + this.Q;
    }

    public void t(m3.a aVar, n3 n3Var, m3.a aVar2, int i2, int i3) {
        h(aVar).b(n3Var.h(aVar2), i2, i3, true);
    }

    public String toString() {
        String str = "";
        StringBuilder i0 = hj1.i0(str);
        if (this.Y != null) {
            str = hj1.a0(hj1.i0("id: "), this.Y, " ");
        }
        i0.append(str);
        i0.append("(");
        i0.append(this.P);
        i0.append(", ");
        i0.append(this.Q);
        i0.append(") - (");
        i0.append(this.L);
        i0.append(" x ");
        return hj1.X(i0, this.M, ")");
    }

    public final boolean u(int i2) {
        int i3 = i2 * 2;
        m3[] m3VarArr = this.G;
        if (!(m3VarArr[i3].d == null || m3VarArr[i3].d.d == m3VarArr[i3])) {
            int i4 = i3 + 1;
            return m3VarArr[i4].d != null && m3VarArr[i4].d.d == m3VarArr[i4];
        }
    }

    public boolean v() {
        m3 m3Var = this.y;
        m3 m3Var2 = m3Var.d;
        if (m3Var2 != null && m3Var2.d == m3Var) {
            return true;
        }
        m3 m3Var3 = this.A;
        m3 m3Var4 = m3Var3.d;
        return m3Var4 != null && m3Var4.d == m3Var3;
    }

    public boolean w() {
        m3 m3Var = this.z;
        m3 m3Var2 = m3Var.d;
        if (m3Var2 != null && m3Var2.d == m3Var) {
            return true;
        }
        m3 m3Var3 = this.B;
        m3 m3Var4 = m3Var3.d;
        return m3Var4 != null && m3Var4.d == m3Var3;
    }

    public void x() {
        this.y.h();
        this.z.h();
        this.A.h();
        this.B.h();
        this.C.h();
        this.D.h();
        this.E.h();
        this.F.h();
        this.K = null;
        this.v = 0.0f;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0.5f;
        this.V = 0.5f;
        a[] aVarArr = this.J;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.W = null;
        this.X = 0;
        this.Z = 0;
        this.a0 = 0;
        float[] fArr = this.b0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.h = -1;
        this.i = -1;
        int[] iArr = this.u;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.j = 0;
        this.k = 0;
        this.o = 1.0f;
        this.r = 1.0f;
        this.n = Integer.MAX_VALUE;
        this.q = Integer.MAX_VALUE;
        this.m = 0;
        this.p = 0;
        this.s = -1;
        this.t = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        boolean[] zArr2 = this.I;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void y() {
        n3 n3Var = this.K;
        if (n3Var != null && (n3Var instanceof o3)) {
            Objects.requireNonNull((o3) n3Var);
        }
        int size = this.H.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.H.get(i2).h();
        }
    }

    public void z(e3 e3Var) {
        this.y.i();
        this.z.i();
        this.A.i();
        this.B.i();
        this.C.i();
        this.F.i();
        this.D.i();
        this.E.i();
    }
}
