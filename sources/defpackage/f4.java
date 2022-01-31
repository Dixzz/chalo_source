package defpackage;

import defpackage.b4;
import defpackage.i4;
import defpackage.m3;
import defpackage.n3;

/* renamed from: f4  reason: default package */
/* compiled from: HorizontalWidgetRun */
public class f4 extends i4 {
    public static int[] k = new int[2];

    public f4(n3 n3Var) {
        super(n3Var);
        this.h.e = b4.a.LEFT;
        this.i.e = b4.a.RIGHT;
        this.f = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0282, code lost:
        if (r15 != 1) goto L_0x02e4;
     */
    @Override // defpackage.z3, defpackage.i4
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(defpackage.z3 r18) {
        /*
        // Method dump skipped, instructions count: 1026
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f4.a(z3):void");
    }

    @Override // defpackage.i4
    public void d() {
        n3 n3Var;
        n3 n3Var2;
        n3 n3Var3;
        n3 n3Var4 = this.b;
        if (n3Var4.f2509a) {
            this.e.c(n3Var4.q());
        }
        if (!this.e.j) {
            n3.a l = this.b.l();
            this.d = l;
            if (l != n3.a.MATCH_CONSTRAINT) {
                n3.a aVar = n3.a.MATCH_PARENT;
                if (l == aVar && (((n3Var3 = this.b.K) != null && n3Var3.l() == n3.a.FIXED) || n3Var3.l() == aVar)) {
                    int q = (n3Var3.q() - this.b.y.c()) - this.b.A.c();
                    b(this.h, n3Var3.d.h, this.b.y.c());
                    b(this.i, n3Var3.d.i, -this.b.A.c());
                    this.e.c(q);
                    return;
                } else if (this.d == n3.a.FIXED) {
                    this.e.c(this.b.q());
                }
            }
        } else {
            n3.a aVar2 = this.d;
            n3.a aVar3 = n3.a.MATCH_PARENT;
            if (aVar2 == aVar3 && (((n3Var2 = this.b.K) != null && n3Var2.l() == n3.a.FIXED) || n3Var2.l() == aVar3)) {
                b(this.h, n3Var2.d.h, this.b.y.c());
                b(this.i, n3Var2.d.i, -this.b.A.c());
                return;
            }
        }
        c4 c4Var = this.e;
        if (c4Var.j) {
            n3 n3Var5 = this.b;
            if (n3Var5.f2509a) {
                m3[] m3VarArr = n3Var5.G;
                if (m3VarArr[0].d == null || m3VarArr[1].d == null) {
                    if (m3VarArr[0].d != null) {
                        b4 h = h(m3VarArr[0]);
                        if (h != null) {
                            b4 b4Var = this.h;
                            int c = this.b.G[0].c();
                            b4Var.l.add(h);
                            b4Var.f = c;
                            h.k.add(b4Var);
                            b(this.i, this.h, this.e.g);
                            return;
                        }
                        return;
                    } else if (m3VarArr[1].d != null) {
                        b4 h2 = h(m3VarArr[1]);
                        if (h2 != null) {
                            b4 b4Var2 = this.i;
                            b4Var2.l.add(h2);
                            b4Var2.f = -this.b.G[1].c();
                            h2.k.add(b4Var2);
                            b(this.h, this.i, -this.e.g);
                            return;
                        }
                        return;
                    } else if (!(n3Var5 instanceof r3) && n3Var5.K != null && n3Var5.h(m3.a.CENTER).d == null) {
                        n3 n3Var6 = this.b;
                        b(this.h, n3Var6.K.d.h, n3Var6.r());
                        b(this.i, this.h, this.e.g);
                        return;
                    } else {
                        return;
                    }
                } else if (n3Var5.v()) {
                    this.h.f = this.b.G[0].c();
                    this.i.f = -this.b.G[1].c();
                    return;
                } else {
                    b4 h3 = h(this.b.G[0]);
                    if (h3 != null) {
                        b4 b4Var3 = this.h;
                        int c2 = this.b.G[0].c();
                        b4Var3.l.add(h3);
                        b4Var3.f = c2;
                        h3.k.add(b4Var3);
                    }
                    b4 h4 = h(this.b.G[1]);
                    if (h4 != null) {
                        b4 b4Var4 = this.i;
                        b4Var4.l.add(h4);
                        b4Var4.f = -this.b.G[1].c();
                        h4.k.add(b4Var4);
                    }
                    this.h.b = true;
                    this.i.b = true;
                    return;
                }
            }
        }
        if (this.d == n3.a.MATCH_CONSTRAINT) {
            n3 n3Var7 = this.b;
            int i = n3Var7.j;
            if (i == 2) {
                n3 n3Var8 = n3Var7.K;
                if (n3Var8 != null) {
                    c4 c4Var2 = n3Var8.e.e;
                    c4Var.l.add(c4Var2);
                    c4Var2.k.add(this.e);
                    c4 c4Var3 = this.e;
                    c4Var3.b = true;
                    c4Var3.k.add(this.h);
                    this.e.k.add(this.i);
                }
            } else if (i == 3) {
                if (n3Var7.k == 3) {
                    this.h.f374a = this;
                    this.i.f374a = this;
                    h4 h4Var = n3Var7.e;
                    h4Var.h.f374a = this;
                    h4Var.i.f374a = this;
                    c4Var.f374a = this;
                    if (n3Var7.w()) {
                        this.e.l.add(this.b.e.e);
                        this.b.e.e.k.add(this.e);
                        h4 h4Var2 = this.b.e;
                        h4Var2.e.f374a = this;
                        this.e.l.add(h4Var2.h);
                        this.e.l.add(this.b.e.i);
                        this.b.e.h.k.add(this.e);
                        this.b.e.i.k.add(this.e);
                    } else if (this.b.v()) {
                        this.b.e.e.l.add(this.e);
                        this.e.k.add(this.b.e.e);
                    } else {
                        this.b.e.e.l.add(this.e);
                    }
                } else {
                    c4 c4Var4 = n3Var7.e.e;
                    c4Var.l.add(c4Var4);
                    c4Var4.k.add(this.e);
                    this.b.e.h.k.add(this.e);
                    this.b.e.i.k.add(this.e);
                    c4 c4Var5 = this.e;
                    c4Var5.b = true;
                    c4Var5.k.add(this.h);
                    this.e.k.add(this.i);
                    this.h.l.add(this.e);
                    this.i.l.add(this.e);
                }
            }
        }
        n3 n3Var9 = this.b;
        m3[] m3VarArr2 = n3Var9.G;
        if (m3VarArr2[0].d == null || m3VarArr2[1].d == null) {
            if (m3VarArr2[0].d != null) {
                b4 h5 = h(m3VarArr2[0]);
                if (h5 != null) {
                    b4 b4Var5 = this.h;
                    int c3 = this.b.G[0].c();
                    b4Var5.l.add(h5);
                    b4Var5.f = c3;
                    h5.k.add(b4Var5);
                    c(this.i, this.h, 1, this.e);
                }
            } else if (m3VarArr2[1].d != null) {
                b4 h6 = h(m3VarArr2[1]);
                if (h6 != null) {
                    b4 b4Var6 = this.i;
                    b4Var6.l.add(h6);
                    b4Var6.f = -this.b.G[1].c();
                    h6.k.add(b4Var6);
                    c(this.h, this.i, -1, this.e);
                }
            } else if (!(n3Var9 instanceof r3) && (n3Var = n3Var9.K) != null) {
                b(this.h, n3Var.d.h, n3Var9.r());
                c(this.i, this.h, 1, this.e);
            }
        } else if (n3Var9.v()) {
            this.h.f = this.b.G[0].c();
            this.i.f = -this.b.G[1].c();
        } else {
            b4 h7 = h(this.b.G[0]);
            b4 h8 = h(this.b.G[1]);
            h7.k.add(this);
            if (h7.j) {
                a(this);
            }
            h8.k.add(this);
            if (h8.j) {
                a(this);
            }
            this.j = i4.a.CENTER;
        }
    }

    @Override // defpackage.i4
    public void e() {
        b4 b4Var = this.h;
        if (b4Var.j) {
            this.b.P = b4Var.g;
        }
    }

    @Override // defpackage.i4
    public void f() {
        this.c = null;
        this.h.b();
        this.i.b();
        this.e.b();
        this.g = false;
    }

    @Override // defpackage.i4
    public boolean k() {
        if (this.d != n3.a.MATCH_CONSTRAINT || this.b.j == 0) {
            return true;
        }
        return false;
    }

    public final void m(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((((float) i7) * f) + 0.5f);
            int i9 = (int) ((((float) i6) / f) + 0.5f);
            if (i8 <= i6 && i7 <= i7) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i6 <= i6 && i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((((float) i7) * f) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((((float) i6) * f) + 0.5f);
        }
    }

    public void n() {
        this.g = false;
        this.h.b();
        this.h.j = false;
        this.i.b();
        this.i.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("HorizontalRun ");
        i0.append(this.b.Y);
        return i0.toString();
    }
}
