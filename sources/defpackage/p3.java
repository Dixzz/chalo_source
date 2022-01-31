package defpackage;

import defpackage.n3;
import java.util.ArrayList;

/* renamed from: p3  reason: default package */
/* compiled from: Flow */
public class p3 extends u3 {
    public float A0 = 0.5f;
    public float B0 = 0.5f;
    public float C0 = 0.5f;
    public int D0 = 0;
    public int E0 = 0;
    public int F0 = 2;
    public int G0 = 2;
    public int H0 = 0;
    public int I0 = -1;
    public int J0 = 0;
    public ArrayList<a> K0 = new ArrayList<>();
    public n3[] L0 = null;
    public n3[] M0 = null;
    public int[] N0 = null;
    public n3[] O0;
    public int P0 = 0;
    public int r0 = -1;
    public int s0 = -1;
    public int t0 = -1;
    public int u0 = -1;
    public int v0 = -1;
    public int w0 = -1;
    public float x0 = 0.5f;
    public float y0 = 0.5f;
    public float z0 = 0.5f;

    /* renamed from: p3$a */
    /* compiled from: Flow */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2762a = 0;
        public n3 b = null;
        public int c = 0;
        public m3 d;
        public m3 e;
        public m3 f;
        public m3 g;
        public int h = 0;
        public int i = 0;
        public int j = 0;
        public int k = 0;
        public int l = 0;
        public int m = 0;
        public int n = 0;
        public int o = 0;
        public int p = 0;
        public int q = 0;

        public a(int i2, m3 m3Var, m3 m3Var2, m3 m3Var3, m3 m3Var4, int i3) {
            this.f2762a = i2;
            this.d = m3Var;
            this.e = m3Var2;
            this.f = m3Var3;
            this.g = m3Var4;
            this.h = p3.this.k0;
            this.i = p3.this.g0;
            this.j = p3.this.l0;
            this.k = p3.this.h0;
            this.q = i3;
        }

        public void a(n3 n3Var) {
            int i2 = 0;
            if (this.f2762a == 0) {
                int M = p3.this.M(n3Var, this.q);
                if (n3Var.l() == n3.a.MATCH_CONSTRAINT) {
                    this.p++;
                    M = 0;
                }
                p3 p3Var = p3.this;
                int i3 = p3Var.D0;
                if (n3Var.X != 8) {
                    i2 = i3;
                }
                this.l = M + i2 + this.l;
                int L = p3Var.L(n3Var, this.q);
                if (this.b == null || this.c < L) {
                    this.b = n3Var;
                    this.c = L;
                    this.m = L;
                }
            } else {
                int M2 = p3.this.M(n3Var, this.q);
                int L2 = p3.this.L(n3Var, this.q);
                if (n3Var.p() == n3.a.MATCH_CONSTRAINT) {
                    this.p++;
                    L2 = 0;
                }
                int i4 = p3.this.E0;
                if (n3Var.X != 8) {
                    i2 = i4;
                }
                this.m = L2 + i2 + this.m;
                if (this.b == null || this.c < M2) {
                    this.b = n3Var;
                    this.c = M2;
                    this.l = M2;
                }
            }
            this.o++;
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(boolean r17, int r18, boolean r19) {
            /*
            // Method dump skipped, instructions count: 708
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.p3.a.b(boolean, int, boolean):void");
        }

        public int c() {
            if (this.f2762a == 1) {
                return this.m - p3.this.E0;
            }
            return this.m;
        }

        public int d() {
            if (this.f2762a == 0) {
                return this.l - p3.this.D0;
            }
            return this.l;
        }

        public void e(int i2) {
            int i3 = this.p;
            if (i3 != 0) {
                int i4 = this.o;
                int i5 = i2 / i3;
                for (int i6 = 0; i6 < i4; i6++) {
                    int i7 = this.n;
                    int i8 = i7 + i6;
                    p3 p3Var = p3.this;
                    if (i8 >= p3Var.P0) {
                        break;
                    }
                    n3 n3Var = p3Var.O0[i7 + i6];
                    if (this.f2762a == 0) {
                        if (n3Var != null && n3Var.l() == n3.a.MATCH_CONSTRAINT && n3Var.j == 0) {
                            p3.this.K(n3Var, n3.a.FIXED, i5, n3Var.p(), n3Var.k());
                        }
                    } else if (n3Var != null && n3Var.p() == n3.a.MATCH_CONSTRAINT && n3Var.k == 0) {
                        p3.this.K(n3Var, n3Var.l(), n3Var.q(), n3.a.FIXED, i5);
                    }
                }
                this.l = 0;
                this.m = 0;
                this.b = null;
                this.c = 0;
                int i9 = this.o;
                for (int i10 = 0; i10 < i9; i10++) {
                    int i11 = this.n + i10;
                    p3 p3Var2 = p3.this;
                    if (i11 < p3Var2.P0) {
                        n3 n3Var2 = p3Var2.O0[i11];
                        if (this.f2762a == 0) {
                            int q2 = n3Var2.q();
                            p3 p3Var3 = p3.this;
                            int i12 = p3Var3.D0;
                            if (n3Var2.X == 8) {
                                i12 = 0;
                            }
                            this.l = q2 + i12 + this.l;
                            int L = p3Var3.L(n3Var2, this.q);
                            if (this.b == null || this.c < L) {
                                this.b = n3Var2;
                                this.c = L;
                                this.m = L;
                            }
                        } else {
                            int M = p3Var2.M(n3Var2, this.q);
                            int L2 = p3.this.L(n3Var2, this.q);
                            int i13 = p3.this.E0;
                            if (n3Var2.X == 8) {
                                i13 = 0;
                            }
                            this.m = L2 + i13 + this.m;
                            if (this.b == null || this.c < M) {
                                this.b = n3Var2;
                                this.c = M;
                                this.l = M;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public void f(int i2, m3 m3Var, m3 m3Var2, m3 m3Var3, m3 m3Var4, int i3, int i4, int i5, int i6, int i7) {
            this.f2762a = i2;
            this.d = m3Var;
            this.e = m3Var2;
            this.f = m3Var3;
            this.g = m3Var4;
            this.h = i3;
            this.i = i4;
            this.j = i5;
            this.k = i6;
            this.q = i7;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:176:0x029b, code lost:
        r3 = r2;
        r4 = r3;
        r7 = r0;
        r6 = r5;
        r0 = r34;
        r5 = r1;
        r1 = r35;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x05ec  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x05ee  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x05fc  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x05fe  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0618  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x061a  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x02b1 A[SYNTHETIC] */
    @Override // defpackage.u3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(int r34, int r35, int r36, int r37) {
        /*
        // Method dump skipped, instructions count: 1566
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p3.J(int, int, int, int):void");
    }

    public final int L(n3 n3Var, int i) {
        if (n3Var == null) {
            return 0;
        }
        if (n3Var.p() == n3.a.MATCH_CONSTRAINT) {
            int i2 = n3Var.k;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (n3Var.r * ((float) i));
                if (i3 != n3Var.k()) {
                    K(n3Var, n3Var.l(), n3Var.q(), n3.a.FIXED, i3);
                }
                return i3;
            } else if (i2 == 1) {
                return n3Var.k();
            } else {
                if (i2 == 3) {
                    return (int) ((((float) n3Var.q()) * n3Var.N) + 0.5f);
                }
            }
        }
        return n3Var.k();
    }

    public final int M(n3 n3Var, int i) {
        if (n3Var == null) {
            return 0;
        }
        if (n3Var.l() == n3.a.MATCH_CONSTRAINT) {
            int i2 = n3Var.j;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (n3Var.o * ((float) i));
                if (i3 != n3Var.q()) {
                    K(n3Var, n3.a.FIXED, i3, n3Var.p(), n3Var.k());
                }
                return i3;
            } else if (i2 == 1) {
                return n3Var.q();
            } else {
                if (i2 == 3) {
                    return (int) ((((float) n3Var.k()) * n3Var.N) + 0.5f);
                }
            }
        }
        return n3Var.q();
    }

    @Override // defpackage.n3
    public void b(f3 f3Var) {
        n3 n3Var;
        super.b(f3Var);
        n3 n3Var2 = this.K;
        boolean z = n3Var2 != null ? ((o3) n3Var2).i0 : false;
        int i = this.H0;
        if (i != 0) {
            if (i == 1) {
                int size = this.K0.size();
                int i2 = 0;
                while (i2 < size) {
                    this.K0.get(i2).b(z, i2, i2 == size + -1);
                    i2++;
                }
            } else if (!(i != 2 || this.N0 == null || this.M0 == null || this.L0 == null)) {
                for (int i3 = 0; i3 < this.P0; i3++) {
                    this.O0[i3].y();
                }
                int[] iArr = this.N0;
                int i4 = iArr[0];
                int i5 = iArr[1];
                n3 n3Var3 = null;
                for (int i6 = 0; i6 < i4; i6++) {
                    n3 n3Var4 = this.M0[z ? (i4 - i6) - 1 : i6];
                    if (!(n3Var4 == null || n3Var4.X == 8)) {
                        if (i6 == 0) {
                            n3Var4.f(n3Var4.y, this.y, this.k0);
                            n3Var4.Z = this.r0;
                            n3Var4.U = this.x0;
                        }
                        if (i6 == i4 - 1) {
                            n3Var4.f(n3Var4.A, this.A, this.l0);
                        }
                        if (i6 > 0) {
                            n3Var4.f(n3Var4.y, n3Var3.A, this.D0);
                            n3Var3.f(n3Var3.A, n3Var4.y, 0);
                        }
                        n3Var3 = n3Var4;
                    }
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    n3 n3Var5 = this.L0[i7];
                    if (!(n3Var5 == null || n3Var5.X == 8)) {
                        if (i7 == 0) {
                            n3Var5.f(n3Var5.z, this.z, this.g0);
                            n3Var5.a0 = this.s0;
                            n3Var5.V = this.y0;
                        }
                        if (i7 == i5 - 1) {
                            n3Var5.f(n3Var5.B, this.B, this.h0);
                        }
                        if (i7 > 0) {
                            n3Var5.f(n3Var5.z, n3Var3.B, this.E0);
                            n3Var3.f(n3Var3.B, n3Var5.z, 0);
                        }
                        n3Var3 = n3Var5;
                    }
                }
                for (int i8 = 0; i8 < i4; i8++) {
                    for (int i9 = 0; i9 < i5; i9++) {
                        int i10 = (i9 * i4) + i8;
                        if (this.J0 == 1) {
                            i10 = (i8 * i5) + i9;
                        }
                        n3[] n3VarArr = this.O0;
                        if (!(i10 >= n3VarArr.length || (n3Var = n3VarArr[i10]) == null || n3Var.X == 8)) {
                            n3 n3Var6 = this.M0[i8];
                            n3 n3Var7 = this.L0[i9];
                            if (n3Var != n3Var6) {
                                n3Var.f(n3Var.y, n3Var6.y, 0);
                                n3Var.f(n3Var.A, n3Var6.A, 0);
                            }
                            if (n3Var != n3Var7) {
                                n3Var.f(n3Var.z, n3Var7.z, 0);
                                n3Var.f(n3Var.B, n3Var7.B, 0);
                            }
                        }
                    }
                }
            }
        } else if (this.K0.size() > 0) {
            this.K0.get(0).b(z, 0, true);
        }
        this.m0 = false;
    }
}
