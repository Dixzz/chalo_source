package defpackage;

import defpackage.b4;
import defpackage.i4;
import defpackage.m3;
import defpackage.n3;

/* renamed from: h4  reason: default package */
/* compiled from: VerticalWidgetRun */
public class h4 extends i4 {
    public b4 k;
    public c4 l = null;

    public h4(n3 n3Var) {
        super(n3Var);
        b4 b4Var = new b4(this);
        this.k = b4Var;
        this.h.e = b4.a.TOP;
        this.i.e = b4.a.BOTTOM;
        b4Var.e = b4.a.BASELINE;
        this.f = 1;
    }

    @Override // defpackage.z3, defpackage.i4
    public void a(z3 z3Var) {
        int i;
        float f;
        float f2;
        float f3;
        int ordinal = this.j.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            c4 c4Var = this.e;
            if (c4Var.c && !c4Var.j && this.d == n3.a.MATCH_CONSTRAINT) {
                n3 n3Var = this.b;
                int i2 = n3Var.k;
                if (i2 == 2) {
                    n3 n3Var2 = n3Var.K;
                    if (n3Var2 != null) {
                        c4 c4Var2 = n3Var2.e.e;
                        if (c4Var2.j) {
                            c4Var.c((int) ((((float) c4Var2.g) * n3Var.r) + 0.5f));
                        }
                    }
                } else if (i2 == 3) {
                    c4 c4Var3 = n3Var.d.e;
                    if (c4Var3.j) {
                        int i3 = n3Var.O;
                        if (i3 == -1) {
                            f3 = (float) c4Var3.g;
                            f2 = n3Var.N;
                        } else if (i3 == 0) {
                            f = ((float) c4Var3.g) * n3Var.N;
                            i = (int) (f + 0.5f);
                            c4Var.c(i);
                        } else if (i3 != 1) {
                            i = 0;
                            c4Var.c(i);
                        } else {
                            f3 = (float) c4Var3.g;
                            f2 = n3Var.N;
                        }
                        f = f3 / f2;
                        i = (int) (f + 0.5f);
                        c4Var.c(i);
                    }
                }
            }
            b4 b4Var = this.h;
            if (b4Var.c) {
                b4 b4Var2 = this.i;
                if (b4Var2.c) {
                    if (!b4Var.j || !b4Var2.j || !this.e.j) {
                        if (!this.e.j && this.d == n3.a.MATCH_CONSTRAINT) {
                            n3 n3Var3 = this.b;
                            if (n3Var3.j == 0 && !n3Var3.w()) {
                                int i4 = this.h.l.get(0).g;
                                b4 b4Var3 = this.h;
                                int i5 = i4 + b4Var3.f;
                                int i6 = this.i.l.get(0).g + this.i.f;
                                b4Var3.c(i5);
                                this.i.c(i6);
                                this.e.c(i6 - i5);
                                return;
                            }
                        }
                        if (!this.e.j && this.d == n3.a.MATCH_CONSTRAINT && this.f1472a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                            int i7 = (this.i.l.get(0).g + this.i.f) - (this.h.l.get(0).g + this.h.f);
                            c4 c4Var4 = this.e;
                            int i8 = c4Var4.m;
                            if (i7 < i8) {
                                c4Var4.c(i7);
                            } else {
                                c4Var4.c(i8);
                            }
                        }
                        if (this.e.j && this.h.l.size() > 0 && this.i.l.size() > 0) {
                            b4 b4Var4 = this.h.l.get(0);
                            b4 b4Var5 = this.i.l.get(0);
                            int i9 = b4Var4.g;
                            b4 b4Var6 = this.h;
                            int i10 = b4Var6.f + i9;
                            int i11 = b4Var5.g;
                            int i12 = this.i.f + i11;
                            float f4 = this.b.V;
                            if (b4Var4 == b4Var5) {
                                f4 = 0.5f;
                            } else {
                                i9 = i10;
                                i11 = i12;
                            }
                            b4Var6.c((int) ((((float) ((i11 - i9) - this.e.g)) * f4) + ((float) i9) + 0.5f));
                            this.i.c(this.h.g + this.e.g);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        n3 n3Var4 = this.b;
        l(n3Var4.z, n3Var4.B, 1);
    }

    @Override // defpackage.i4
    public void d() {
        n3 n3Var;
        n3 n3Var2;
        n3 n3Var3;
        n3 n3Var4 = this.b;
        if (n3Var4.f2509a) {
            this.e.c(n3Var4.k());
        }
        if (!this.e.j) {
            this.d = this.b.p();
            if (this.b.w) {
                this.l = new w3(this);
            }
            n3.a aVar = this.d;
            if (aVar != n3.a.MATCH_CONSTRAINT) {
                if (aVar == n3.a.MATCH_PARENT && (n3Var3 = this.b.K) != null && n3Var3.p() == n3.a.FIXED) {
                    int k2 = (n3Var3.k() - this.b.z.c()) - this.b.B.c();
                    b(this.h, n3Var3.e.h, this.b.z.c());
                    b(this.i, n3Var3.e.i, -this.b.B.c());
                    this.e.c(k2);
                    return;
                } else if (this.d == n3.a.FIXED) {
                    this.e.c(this.b.k());
                }
            }
        } else if (this.d == n3.a.MATCH_PARENT && (n3Var2 = this.b.K) != null && n3Var2.p() == n3.a.FIXED) {
            b(this.h, n3Var2.e.h, this.b.z.c());
            b(this.i, n3Var2.e.i, -this.b.B.c());
            return;
        }
        c4 c4Var = this.e;
        boolean z = c4Var.j;
        if (z) {
            n3 n3Var5 = this.b;
            if (n3Var5.f2509a) {
                m3[] m3VarArr = n3Var5.G;
                if (m3VarArr[2].d != null && m3VarArr[3].d != null) {
                    if (n3Var5.w()) {
                        this.h.f = this.b.G[2].c();
                        this.i.f = -this.b.G[3].c();
                    } else {
                        b4 h = h(this.b.G[2]);
                        if (h != null) {
                            b4 b4Var = this.h;
                            int c = this.b.G[2].c();
                            b4Var.l.add(h);
                            b4Var.f = c;
                            h.k.add(b4Var);
                        }
                        b4 h2 = h(this.b.G[3]);
                        if (h2 != null) {
                            b4 b4Var2 = this.i;
                            b4Var2.l.add(h2);
                            b4Var2.f = -this.b.G[3].c();
                            h2.k.add(b4Var2);
                        }
                        this.h.b = true;
                        this.i.b = true;
                    }
                    n3 n3Var6 = this.b;
                    if (n3Var6.w) {
                        b(this.k, this.h, n3Var6.R);
                        return;
                    }
                    return;
                } else if (m3VarArr[2].d != null) {
                    b4 h3 = h(m3VarArr[2]);
                    if (h3 != null) {
                        b4 b4Var3 = this.h;
                        int c2 = this.b.G[2].c();
                        b4Var3.l.add(h3);
                        b4Var3.f = c2;
                        h3.k.add(b4Var3);
                        b(this.i, this.h, this.e.g);
                        n3 n3Var7 = this.b;
                        if (n3Var7.w) {
                            b(this.k, this.h, n3Var7.R);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (m3VarArr[3].d != null) {
                    b4 h4 = h(m3VarArr[3]);
                    if (h4 != null) {
                        b4 b4Var4 = this.i;
                        b4Var4.l.add(h4);
                        b4Var4.f = -this.b.G[3].c();
                        h4.k.add(b4Var4);
                        b(this.h, this.i, -this.e.g);
                    }
                    n3 n3Var8 = this.b;
                    if (n3Var8.w) {
                        b(this.k, this.h, n3Var8.R);
                        return;
                    }
                    return;
                } else if (m3VarArr[4].d != null) {
                    b4 h5 = h(m3VarArr[4]);
                    if (h5 != null) {
                        b4 b4Var5 = this.k;
                        b4Var5.l.add(h5);
                        b4Var5.f = 0;
                        h5.k.add(b4Var5);
                        b(this.h, this.k, -this.b.R);
                        b(this.i, this.h, this.e.g);
                        return;
                    }
                    return;
                } else if (!(n3Var5 instanceof r3) && n3Var5.K != null && n3Var5.h(m3.a.CENTER).d == null) {
                    n3 n3Var9 = this.b;
                    b(this.h, n3Var9.K.e.h, n3Var9.s());
                    b(this.i, this.h, this.e.g);
                    n3 n3Var10 = this.b;
                    if (n3Var10.w) {
                        b(this.k, this.h, n3Var10.R);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        if (z || this.d != n3.a.MATCH_CONSTRAINT) {
            c4Var.k.add(this);
            if (c4Var.j) {
                a(this);
            }
        } else {
            n3 n3Var11 = this.b;
            int i = n3Var11.k;
            if (i == 2) {
                n3 n3Var12 = n3Var11.K;
                if (n3Var12 != null) {
                    c4 c4Var2 = n3Var12.e.e;
                    c4Var.l.add(c4Var2);
                    c4Var2.k.add(this.e);
                    c4 c4Var3 = this.e;
                    c4Var3.b = true;
                    c4Var3.k.add(this.h);
                    this.e.k.add(this.i);
                }
            } else if (i == 3 && !n3Var11.w()) {
                n3 n3Var13 = this.b;
                if (n3Var13.j != 3) {
                    c4 c4Var4 = n3Var13.d.e;
                    this.e.l.add(c4Var4);
                    c4Var4.k.add(this.e);
                    c4 c4Var5 = this.e;
                    c4Var5.b = true;
                    c4Var5.k.add(this.h);
                    this.e.k.add(this.i);
                }
            }
        }
        n3 n3Var14 = this.b;
        m3[] m3VarArr2 = n3Var14.G;
        if (m3VarArr2[2].d != null && m3VarArr2[3].d != null) {
            if (n3Var14.w()) {
                this.h.f = this.b.G[2].c();
                this.i.f = -this.b.G[3].c();
            } else {
                b4 h6 = h(this.b.G[2]);
                b4 h7 = h(this.b.G[3]);
                h6.k.add(this);
                if (h6.j) {
                    a(this);
                }
                h7.k.add(this);
                if (h7.j) {
                    a(this);
                }
                this.j = i4.a.CENTER;
            }
            if (this.b.w) {
                c(this.k, this.h, 1, this.l);
            }
        } else if (m3VarArr2[2].d != null) {
            b4 h8 = h(m3VarArr2[2]);
            if (h8 != null) {
                b4 b4Var6 = this.h;
                int c3 = this.b.G[2].c();
                b4Var6.l.add(h8);
                b4Var6.f = c3;
                h8.k.add(b4Var6);
                c(this.i, this.h, 1, this.e);
                if (this.b.w) {
                    c(this.k, this.h, 1, this.l);
                }
                n3.a aVar2 = this.d;
                n3.a aVar3 = n3.a.MATCH_CONSTRAINT;
                if (aVar2 == aVar3) {
                    n3 n3Var15 = this.b;
                    if (n3Var15.N > 0.0f) {
                        f4 f4Var = n3Var15.d;
                        if (f4Var.d == aVar3) {
                            f4Var.e.k.add(this.e);
                            this.e.l.add(this.b.d.e);
                            this.e.f374a = this;
                        }
                    }
                }
            }
        } else if (m3VarArr2[3].d != null) {
            b4 h9 = h(m3VarArr2[3]);
            if (h9 != null) {
                b4 b4Var7 = this.i;
                b4Var7.l.add(h9);
                b4Var7.f = -this.b.G[3].c();
                h9.k.add(b4Var7);
                c(this.h, this.i, -1, this.e);
                if (this.b.w) {
                    c(this.k, this.h, 1, this.l);
                }
            }
        } else if (m3VarArr2[4].d != null) {
            b4 h10 = h(m3VarArr2[4]);
            if (h10 != null) {
                b4 b4Var8 = this.k;
                b4Var8.l.add(h10);
                b4Var8.f = 0;
                h10.k.add(b4Var8);
                c(this.h, this.k, -1, this.l);
                c(this.i, this.h, 1, this.e);
            }
        } else if (!(n3Var14 instanceof r3) && (n3Var = n3Var14.K) != null) {
            b(this.h, n3Var.e.h, n3Var14.s());
            c(this.i, this.h, 1, this.e);
            if (this.b.w) {
                c(this.k, this.h, 1, this.l);
            }
            n3.a aVar4 = this.d;
            n3.a aVar5 = n3.a.MATCH_CONSTRAINT;
            if (aVar4 == aVar5) {
                n3 n3Var16 = this.b;
                if (n3Var16.N > 0.0f) {
                    f4 f4Var2 = n3Var16.d;
                    if (f4Var2.d == aVar5) {
                        f4Var2.e.k.add(this.e);
                        this.e.l.add(this.b.d.e);
                        this.e.f374a = this;
                    }
                }
            }
        }
        if (this.e.l.size() == 0) {
            this.e.c = true;
        }
    }

    @Override // defpackage.i4
    public void e() {
        b4 b4Var = this.h;
        if (b4Var.j) {
            this.b.Q = b4Var.g;
        }
    }

    @Override // defpackage.i4
    public void f() {
        this.c = null;
        this.h.b();
        this.i.b();
        this.k.b();
        this.e.b();
        this.g = false;
    }

    @Override // defpackage.i4
    public boolean k() {
        if (this.d != n3.a.MATCH_CONSTRAINT || this.b.k == 0) {
            return true;
        }
        return false;
    }

    public void m() {
        this.g = false;
        this.h.b();
        this.h.j = false;
        this.i.b();
        this.i.j = false;
        this.k.b();
        this.k.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("VerticalRun ");
        i0.append(this.b.Y);
        return i0.toString();
    }
}
