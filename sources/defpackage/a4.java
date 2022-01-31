package defpackage;

import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.n3;
import defpackage.x3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: a4  reason: default package */
/* compiled from: DependencyGraph */
public class a4 {

    /* renamed from: a  reason: collision with root package name */
    public o3 f107a;
    public boolean b = true;
    public boolean c = true;
    public o3 d;
    public ArrayList<i4> e = new ArrayList<>();
    public x3.b f;
    public x3.a g;
    public ArrayList<g4> h;

    public a4(o3 o3Var) {
        new ArrayList();
        this.f = null;
        this.g = new x3.a();
        this.h = new ArrayList<>();
        this.f107a = o3Var;
        this.d = o3Var;
    }

    public final void a(b4 b4Var, int i, int i2, b4 b4Var2, ArrayList<g4> arrayList, g4 g4Var) {
        i4 i4Var = b4Var.d;
        if (i4Var.c == null) {
            o3 o3Var = this.f107a;
            if (!(i4Var == o3Var.d || i4Var == o3Var.e)) {
                if (g4Var == null) {
                    g4Var = new g4(i4Var, i2);
                    arrayList.add(g4Var);
                }
                i4Var.c = g4Var;
                g4Var.b.add(i4Var);
                for (z3 z3Var : i4Var.h.k) {
                    if (z3Var instanceof b4) {
                        a((b4) z3Var, i, 0, b4Var2, arrayList, g4Var);
                    }
                }
                for (z3 z3Var2 : i4Var.i.k) {
                    if (z3Var2 instanceof b4) {
                        a((b4) z3Var2, i, 1, b4Var2, arrayList, g4Var);
                    }
                }
                if (i == 1 && (i4Var instanceof h4)) {
                    for (z3 z3Var3 : ((h4) i4Var).k.k) {
                        if (z3Var3 instanceof b4) {
                            a((b4) z3Var3, i, 2, b4Var2, arrayList, g4Var);
                        }
                    }
                }
                for (b4 b4Var3 : i4Var.h.l) {
                    a(b4Var3, i, 0, b4Var2, arrayList, g4Var);
                }
                for (b4 b4Var4 : i4Var.i.l) {
                    a(b4Var4, i, 1, b4Var2, arrayList, g4Var);
                }
                if (i == 1 && (i4Var instanceof h4)) {
                    for (b4 b4Var5 : ((h4) i4Var).k.l) {
                        a(b4Var5, i, 2, b4Var2, arrayList, g4Var);
                    }
                }
            }
        }
    }

    public final boolean b(o3 o3Var) {
        n3.a aVar;
        n3.a aVar2;
        int i;
        n3.a aVar3;
        int i2;
        n3.a aVar4;
        Iterator<n3> it = o3Var.e0.iterator();
        while (it.hasNext()) {
            n3 next = it.next();
            n3.a[] aVarArr = next.J;
            n3.a aVar5 = aVarArr[0];
            n3.a aVar6 = aVarArr[1];
            if (next.X == 8) {
                next.f2509a = true;
            } else {
                float f2 = next.o;
                if (f2 < 1.0f && aVar5 == n3.a.MATCH_CONSTRAINT) {
                    next.j = 2;
                }
                float f3 = next.r;
                if (f3 < 1.0f && aVar6 == n3.a.MATCH_CONSTRAINT) {
                    next.k = 2;
                }
                if (next.N > 0.0f) {
                    n3.a aVar7 = n3.a.MATCH_CONSTRAINT;
                    if (aVar5 == aVar7 && (aVar6 == n3.a.WRAP_CONTENT || aVar6 == n3.a.FIXED)) {
                        next.j = 3;
                    } else if (aVar6 == aVar7 && (aVar5 == n3.a.WRAP_CONTENT || aVar5 == n3.a.FIXED)) {
                        next.k = 3;
                    } else if (aVar5 == aVar7 && aVar6 == aVar7) {
                        if (next.j == 0) {
                            next.j = 3;
                        }
                        if (next.k == 0) {
                            next.k = 3;
                        }
                    }
                }
                n3.a aVar8 = n3.a.MATCH_CONSTRAINT;
                if (aVar5 == aVar8 && next.j == 1 && (next.y.d == null || next.A.d == null)) {
                    aVar5 = n3.a.WRAP_CONTENT;
                }
                if (aVar6 == aVar8 && next.k == 1 && (next.z.d == null || next.B.d == null)) {
                    aVar6 = n3.a.WRAP_CONTENT;
                }
                f4 f4Var = next.d;
                f4Var.d = aVar5;
                int i3 = next.j;
                f4Var.f1472a = i3;
                h4 h4Var = next.e;
                h4Var.d = aVar6;
                int i4 = next.k;
                h4Var.f1472a = i4;
                n3.a aVar9 = n3.a.MATCH_PARENT;
                if ((aVar5 == aVar9 || aVar5 == n3.a.FIXED || aVar5 == n3.a.WRAP_CONTENT) && (aVar6 == aVar9 || aVar6 == n3.a.FIXED || aVar6 == n3.a.WRAP_CONTENT)) {
                    int q = next.q();
                    if (aVar5 == aVar9) {
                        i = (o3Var.q() - next.y.e) - next.A.e;
                        aVar3 = n3.a.FIXED;
                    } else {
                        i = q;
                        aVar3 = aVar5;
                    }
                    int k = next.k();
                    if (aVar6 == aVar9) {
                        i2 = (o3Var.k() - next.z.e) - next.B.e;
                        aVar4 = n3.a.FIXED;
                    } else {
                        i2 = k;
                        aVar4 = aVar6;
                    }
                    f(next, aVar3, i, aVar4, i2);
                    next.d.e.c(next.q());
                    next.e.e.c(next.k());
                    next.f2509a = true;
                } else {
                    if (aVar5 == aVar8 && (aVar6 == (aVar2 = n3.a.WRAP_CONTENT) || aVar6 == n3.a.FIXED)) {
                        if (i3 == 3) {
                            if (aVar6 == aVar2) {
                                f(next, aVar2, 0, aVar2, 0);
                            }
                            int k2 = next.k();
                            n3.a aVar10 = n3.a.FIXED;
                            f(next, aVar10, (int) ((((float) k2) * next.N) + 0.5f), aVar10, k2);
                            next.d.e.c(next.q());
                            next.e.e.c(next.k());
                            next.f2509a = true;
                        } else if (i3 == 1) {
                            f(next, aVar2, 0, aVar6, 0);
                            next.d.e.m = next.q();
                        } else if (i3 == 2) {
                            n3.a[] aVarArr2 = o3Var.J;
                            n3.a aVar11 = aVarArr2[0];
                            n3.a aVar12 = n3.a.FIXED;
                            if (aVar11 == aVar12 || aVarArr2[0] == aVar9) {
                                f(next, aVar12, (int) ((f2 * ((float) o3Var.q())) + 0.5f), aVar6, next.k());
                                next.d.e.c(next.q());
                                next.e.e.c(next.k());
                                next.f2509a = true;
                            }
                        } else {
                            m3[] m3VarArr = next.G;
                            if (m3VarArr[0].d == null || m3VarArr[1].d == null) {
                                f(next, aVar2, 0, aVar6, 0);
                                next.d.e.c(next.q());
                                next.e.e.c(next.k());
                                next.f2509a = true;
                            }
                        }
                    }
                    if (aVar6 == aVar8 && (aVar5 == (aVar = n3.a.WRAP_CONTENT) || aVar5 == n3.a.FIXED)) {
                        if (i4 == 3) {
                            if (aVar5 == aVar) {
                                f(next, aVar, 0, aVar, 0);
                            }
                            int q2 = next.q();
                            float f4 = next.N;
                            if (next.O == -1) {
                                f4 = 1.0f / f4;
                            }
                            n3.a aVar13 = n3.a.FIXED;
                            f(next, aVar13, q2, aVar13, (int) ((((float) q2) * f4) + 0.5f));
                            next.d.e.c(next.q());
                            next.e.e.c(next.k());
                            next.f2509a = true;
                        } else if (i4 == 1) {
                            f(next, aVar5, 0, aVar, 0);
                            next.e.e.m = next.k();
                        } else if (i4 == 2) {
                            n3.a[] aVarArr3 = o3Var.J;
                            n3.a aVar14 = aVarArr3[1];
                            n3.a aVar15 = n3.a.FIXED;
                            if (aVar14 == aVar15 || aVarArr3[1] == aVar9) {
                                f(next, aVar5, next.q(), aVar15, (int) ((f3 * ((float) o3Var.k())) + 0.5f));
                                next.d.e.c(next.q());
                                next.e.e.c(next.k());
                                next.f2509a = true;
                            }
                        } else {
                            m3[] m3VarArr2 = next.G;
                            if (m3VarArr2[2].d == null || m3VarArr2[3].d == null) {
                                f(next, aVar, 0, aVar6, 0);
                                next.d.e.c(next.q());
                                next.e.e.c(next.k());
                                next.f2509a = true;
                            }
                        }
                    }
                    if (aVar5 == aVar8 && aVar6 == aVar8) {
                        if (i3 == 1 || i4 == 1) {
                            n3.a aVar16 = n3.a.WRAP_CONTENT;
                            f(next, aVar16, 0, aVar16, 0);
                            next.d.e.m = next.q();
                            next.e.e.m = next.k();
                        } else if (i4 == 2 && i3 == 2) {
                            n3.a[] aVarArr4 = o3Var.J;
                            n3.a aVar17 = aVarArr4[0];
                            n3.a aVar18 = n3.a.FIXED;
                            if ((aVar17 == aVar18 || aVarArr4[0] == aVar18) && (aVarArr4[1] == aVar18 || aVarArr4[1] == aVar18)) {
                                f(next, aVar18, (int) ((f2 * ((float) o3Var.q())) + 0.5f), aVar18, (int) ((f3 * ((float) o3Var.k())) + 0.5f));
                                next.d.e.c(next.q());
                                next.e.e.c(next.k());
                                next.f2509a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void c() {
        ArrayList<i4> arrayList = this.e;
        arrayList.clear();
        this.d.d.f();
        this.d.e.f();
        arrayList.add(this.d.d);
        arrayList.add(this.d.e);
        Iterator<n3> it = this.d.e0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            n3 next = it.next();
            if (next instanceof q3) {
                arrayList.add(new d4(next));
            } else {
                if (next.v()) {
                    if (next.b == null) {
                        next.b = new y3(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.b);
                } else {
                    arrayList.add(next.d);
                }
                if (next.w()) {
                    if (next.c == null) {
                        next.c = new y3(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.c);
                } else {
                    arrayList.add(next.e);
                }
                if (next instanceof s3) {
                    arrayList.add(new e4(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<i4> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<i4> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            i4 next2 = it3.next();
            if (next2.b != this.d) {
                next2.d();
            }
        }
        this.h.clear();
        g4.c = 0;
        e(this.f107a.d, 0, this.h);
        e(this.f107a.e, 1, this.h);
        this.b = false;
    }

    public final int d(o3 o3Var, int i) {
        float f2;
        a4 a4Var = this;
        o3 o3Var2 = o3Var;
        int size = a4Var.h.size();
        long j = 0;
        long j2 = 0;
        int i2 = 0;
        while (i2 < size) {
            g4 g4Var = a4Var.h.get(i2);
            i4 i4Var = g4Var.f1211a;
            if (i4Var instanceof y3) {
                if (((y3) i4Var).f != i) {
                    j = Math.max(j, j2);
                    i2++;
                    j2 = 0;
                    a4Var = this;
                    o3Var2 = o3Var;
                }
            } else if (i == 0) {
                if (!(i4Var instanceof f4)) {
                    j = Math.max(j, j2);
                    i2++;
                    j2 = 0;
                    a4Var = this;
                    o3Var2 = o3Var;
                }
            } else if (!(i4Var instanceof h4)) {
                j = Math.max(j, j2);
                i2++;
                j2 = 0;
                a4Var = this;
                o3Var2 = o3Var;
            }
            b4 b4Var = (i == 0 ? o3Var2.d : o3Var2.e).h;
            b4 b4Var2 = (i == 0 ? o3Var2.d : o3Var2.e).i;
            boolean contains = i4Var.h.l.contains(b4Var);
            boolean contains2 = g4Var.f1211a.i.l.contains(b4Var2);
            long j3 = g4Var.f1211a.j();
            if (!contains || !contains2) {
                if (contains) {
                    b4 b4Var3 = g4Var.f1211a.h;
                    j2 = Math.max(g4Var.b(b4Var3, (long) b4Var3.f), ((long) g4Var.f1211a.h.f) + j3);
                } else if (contains2) {
                    b4 b4Var4 = g4Var.f1211a.i;
                    j2 = Math.max(-g4Var.a(b4Var4, (long) b4Var4.f), ((long) (-g4Var.f1211a.i.f)) + j3);
                } else {
                    i4 i4Var2 = g4Var.f1211a;
                    j2 = (i4Var2.j() + ((long) i4Var2.h.f)) - ((long) g4Var.f1211a.i.f);
                }
                j = Math.max(j, j2);
                i2++;
                j2 = 0;
                a4Var = this;
                o3Var2 = o3Var;
            } else {
                long b2 = g4Var.b(g4Var.f1211a.h, j2);
                long a2 = g4Var.a(g4Var.f1211a.i, j2);
                long j4 = b2 - j3;
                i4 i4Var3 = g4Var.f1211a;
                int i3 = i4Var3.i.f;
                if (j4 >= ((long) (-i3))) {
                    j4 += (long) i3;
                }
                long j5 = (long) i4Var3.h.f;
                long j6 = ((-a2) - j3) - j5;
                if (j6 >= j5) {
                    j6 -= j5;
                }
                n3 n3Var = i4Var3.b;
                Objects.requireNonNull(n3Var);
                if (i == 0) {
                    f2 = n3Var.U;
                } else {
                    f2 = i == 1 ? n3Var.V : -1.0f;
                }
                float f3 = (float) (f2 > 0.0f ? (long) ((((float) j4) / (1.0f - f2)) + (((float) j6) / f2)) : 0);
                long a3 = ((long) ((f3 * f2) + 0.5f)) + j3 + ((long) hj1.a(1.0f, f2, f3, 0.5f));
                i4 i4Var4 = g4Var.f1211a;
                j2 = (((long) i4Var4.h.f) + a3) - ((long) i4Var4.i.f);
                j = Math.max(j, j2);
                i2++;
                j2 = 0;
                a4Var = this;
                o3Var2 = o3Var;
            }
        }
        return (int) j;
    }

    public final void e(i4 i4Var, int i, ArrayList<g4> arrayList) {
        for (z3 z3Var : i4Var.h.k) {
            if (z3Var instanceof b4) {
                a((b4) z3Var, i, 0, i4Var.i, arrayList, null);
            } else if (z3Var instanceof i4) {
                a(((i4) z3Var).h, i, 0, i4Var.i, arrayList, null);
            }
        }
        for (z3 z3Var2 : i4Var.i.k) {
            if (z3Var2 instanceof b4) {
                a((b4) z3Var2, i, 1, i4Var.h, arrayList, null);
            } else if (z3Var2 instanceof i4) {
                a(((i4) z3Var2).i, i, 1, i4Var.h, arrayList, null);
            }
        }
        if (i == 1) {
            for (z3 z3Var3 : ((h4) i4Var).k.k) {
                if (z3Var3 instanceof b4) {
                    a((b4) z3Var3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    public final void f(n3 n3Var, n3.a aVar, int i, n3.a aVar2, int i2) {
        x3.a aVar3 = this.g;
        aVar3.f3877a = aVar;
        aVar3.b = aVar2;
        aVar3.c = i;
        aVar3.d = i2;
        ((ConstraintLayout.b) this.f).a(n3Var, aVar3);
        n3Var.G(this.g.e);
        n3Var.B(this.g.f);
        x3.a aVar4 = this.g;
        n3Var.w = aVar4.h;
        n3Var.A(aVar4.g);
    }

    public void g() {
        c4 c4Var;
        Iterator<n3> it = this.f107a.e0.iterator();
        while (it.hasNext()) {
            n3 next = it.next();
            if (!next.f2509a) {
                n3.a[] aVarArr = next.J;
                boolean z = false;
                n3.a aVar = aVarArr[0];
                n3.a aVar2 = aVarArr[1];
                int i = next.j;
                int i2 = next.k;
                n3.a aVar3 = n3.a.WRAP_CONTENT;
                boolean z2 = aVar == aVar3 || (aVar == n3.a.MATCH_CONSTRAINT && i == 1);
                if (aVar2 == aVar3 || (aVar2 == n3.a.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                c4 c4Var2 = next.d.e;
                boolean z3 = c4Var2.j;
                c4 c4Var3 = next.e.e;
                boolean z4 = c4Var3.j;
                if (z3 && z4) {
                    n3.a aVar4 = n3.a.FIXED;
                    f(next, aVar4, c4Var2.g, aVar4, c4Var3.g);
                    next.f2509a = true;
                } else if (z3 && z) {
                    f(next, n3.a.FIXED, c4Var2.g, aVar3, c4Var3.g);
                    if (aVar2 == n3.a.MATCH_CONSTRAINT) {
                        next.e.e.m = next.k();
                    } else {
                        next.e.e.c(next.k());
                        next.f2509a = true;
                    }
                } else if (z4 && z2) {
                    f(next, aVar3, c4Var2.g, n3.a.FIXED, c4Var3.g);
                    if (aVar == n3.a.MATCH_CONSTRAINT) {
                        next.d.e.m = next.q();
                    } else {
                        next.d.e.c(next.q());
                        next.f2509a = true;
                    }
                }
                if (next.f2509a && (c4Var = next.e.l) != null) {
                    c4Var.c(next.R);
                }
            }
        }
    }
}
