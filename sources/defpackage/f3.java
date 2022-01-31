package defpackage;

import defpackage.i3;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: f3  reason: default package */
/* compiled from: LinearSystem */
public class f3 {
    public static int o = 1000;
    public static boolean p = true;
    public static long q;
    public static long r;

    /* renamed from: a  reason: collision with root package name */
    public int f1066a;
    public a b;
    public int c;
    public int d;
    public d3[] e;
    public boolean f;
    public boolean[] g;
    public int h;
    public int i;
    public int j;
    public final e3 k;
    public i3[] l;
    public int m;
    public a n;

    /* renamed from: f3$a */
    /* compiled from: LinearSystem */
    public interface a {
        void a(i3 i3Var);

        i3 b(f3 f3Var, boolean[] zArr);

        void clear();
    }

    /* renamed from: f3$b */
    /* compiled from: LinearSystem */
    public class b extends d3 {
        public b(f3 f3Var, e3 e3Var) {
            this.d = new j3(this, e3Var);
        }
    }

    public f3() {
        this.f1066a = 0;
        this.c = 32;
        this.d = 32;
        this.e = null;
        this.f = false;
        this.g = new boolean[32];
        this.h = 1;
        this.i = 0;
        this.j = 32;
        this.l = new i3[o];
        this.m = 0;
        this.e = new d3[32];
        s();
        e3 e3Var = new e3();
        this.k = e3Var;
        this.b = new h3(e3Var);
        if (p) {
            this.n = new b(this, e3Var);
        } else {
            this.n = new d3(e3Var);
        }
    }

    public final i3 a(i3.a aVar, String str) {
        i3 a2 = this.k.c.a();
        if (a2 == null) {
            a2 = new i3(aVar);
            a2.i = aVar;
        } else {
            a2.c();
            a2.i = aVar;
        }
        int i2 = this.m;
        int i3 = o;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            o = i4;
            this.l = (i3[]) Arrays.copyOf(this.l, i4);
        }
        i3[] i3VarArr = this.l;
        int i5 = this.m;
        this.m = i5 + 1;
        i3VarArr[i5] = a2;
        return a2;
    }

    public void b(i3 i3Var, i3 i3Var2, int i2, float f2, i3 i3Var3, i3 i3Var4, int i3, int i4) {
        d3 m2 = m();
        if (i3Var2 == i3Var3) {
            m2.d.i(i3Var, 1.0f);
            m2.d.i(i3Var4, 1.0f);
            m2.d.i(i3Var2, -2.0f);
        } else if (f2 == 0.5f) {
            m2.d.i(i3Var, 1.0f);
            m2.d.i(i3Var2, -1.0f);
            m2.d.i(i3Var3, -1.0f);
            m2.d.i(i3Var4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                m2.b = (float) ((-i2) + i3);
            }
        } else if (f2 <= 0.0f) {
            m2.d.i(i3Var, -1.0f);
            m2.d.i(i3Var2, 1.0f);
            m2.b = (float) i2;
        } else if (f2 >= 1.0f) {
            m2.d.i(i3Var4, -1.0f);
            m2.d.i(i3Var3, 1.0f);
            m2.b = (float) (-i3);
        } else {
            float f3 = 1.0f - f2;
            m2.d.i(i3Var, f3 * 1.0f);
            m2.d.i(i3Var2, f3 * -1.0f);
            m2.d.i(i3Var3, -1.0f * f2);
            m2.d.i(i3Var4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                m2.b = (((float) i3) * f2) + (((float) (-i2)) * f3);
            }
        }
        if (i4 != 8) {
            m2.c(this, i4);
        }
        c(m2);
    }

    public void c(d3 d3Var) {
        boolean z;
        boolean z2;
        boolean z3;
        i3 i2;
        boolean h2;
        boolean h3;
        boolean z4 = true;
        if (this.i + 1 >= this.j || this.h + 1 >= this.d) {
            p();
        }
        if (!d3Var.e) {
            if (this.e.length != 0) {
                boolean z5 = false;
                while (!z5) {
                    int a2 = d3Var.d.a();
                    for (int i3 = 0; i3 < a2; i3++) {
                        i3 b2 = d3Var.d.b(i3);
                        if (b2.c != -1 || b2.f) {
                            d3Var.c.add(b2);
                        }
                    }
                    if (d3Var.c.size() > 0) {
                        Iterator<i3> it = d3Var.c.iterator();
                        while (it.hasNext()) {
                            i3 next = it.next();
                            if (next.f) {
                                d3Var.k(next, true);
                            } else {
                                d3Var.l(this.e[next.c], true);
                            }
                        }
                        d3Var.c.clear();
                    } else {
                        z5 = true;
                    }
                }
            }
            if (!(d3Var.f781a == null && d3Var.b == 0.0f && d3Var.d.a() == 0)) {
                float f2 = d3Var.b;
                if (f2 < 0.0f) {
                    d3Var.b = f2 * -1.0f;
                    d3Var.d.c();
                }
                int a3 = d3Var.d.a();
                i3 i3Var = null;
                i3 i3Var2 = null;
                float f3 = 0.0f;
                boolean z6 = false;
                float f4 = 0.0f;
                boolean z7 = false;
                for (int i4 = 0; i4 < a3; i4++) {
                    float d2 = d3Var.d.d(i4);
                    i3 b3 = d3Var.d.b(i4);
                    if (b3.i == i3.a.UNRESTRICTED) {
                        if (i3Var == null) {
                            h3 = d3Var.h(b3);
                        } else if (f3 > d2) {
                            h3 = d3Var.h(b3);
                        } else if (!z6 && d3Var.h(b3)) {
                            i3Var = b3;
                            f3 = d2;
                            z6 = true;
                        }
                        z6 = h3;
                        i3Var = b3;
                        f3 = d2;
                    } else if (i3Var == null && d2 < 0.0f) {
                        if (i3Var2 == null) {
                            h2 = d3Var.h(b3);
                        } else if (f4 > d2) {
                            h2 = d3Var.h(b3);
                        } else if (!z7 && d3Var.h(b3)) {
                            i3Var2 = b3;
                            f4 = d2;
                            z7 = true;
                        }
                        z7 = h2;
                        i3Var2 = b3;
                        f4 = d2;
                    }
                }
                if (i3Var == null) {
                    i3Var = i3Var2;
                }
                if (i3Var == null) {
                    z2 = true;
                } else {
                    d3Var.j(i3Var);
                    z2 = false;
                }
                if (d3Var.d.a() == 0) {
                    d3Var.e = true;
                }
                if (z2) {
                    if (this.h + 1 >= this.d) {
                        p();
                    }
                    i3 a4 = a(i3.a.SLACK, null);
                    int i5 = this.f1066a + 1;
                    this.f1066a = i5;
                    this.h++;
                    a4.b = i5;
                    this.k.d[i5] = a4;
                    d3Var.f781a = a4;
                    i(d3Var);
                    d3 d3Var2 = (d3) this.n;
                    Objects.requireNonNull(d3Var2);
                    d3Var2.f781a = null;
                    d3Var2.d.clear();
                    for (int i6 = 0; i6 < d3Var.d.a(); i6++) {
                        d3Var2.d.e(d3Var.d.b(i6), d3Var.d.d(i6), true);
                    }
                    r(this.n);
                    if (a4.c == -1) {
                        if (d3Var.f781a == a4 && (i2 = d3Var.i(null, a4)) != null) {
                            d3Var.j(i2);
                        }
                        if (!d3Var.e) {
                            d3Var.f781a.e(d3Var);
                        }
                        this.i--;
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                i3 i3Var3 = d3Var.f781a;
                if (i3Var3 == null || (i3Var3.i != i3.a.UNRESTRICTED && d3Var.b < 0.0f)) {
                    z4 = false;
                }
                if (z4) {
                    z = z3;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            z = false;
        }
        if (!z) {
            i(d3Var);
        }
    }

    public d3 d(i3 i3Var, i3 i3Var2, int i2, int i3) {
        if (i3 == 8 && i3Var2.f && i3Var.c == -1) {
            i3Var.d(this, i3Var2.e + ((float) i2));
            return null;
        }
        d3 m2 = m();
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            m2.b = (float) i2;
        }
        if (!z) {
            m2.d.i(i3Var, -1.0f);
            m2.d.i(i3Var2, 1.0f);
        } else {
            m2.d.i(i3Var, 1.0f);
            m2.d.i(i3Var2, -1.0f);
        }
        if (i3 != 8) {
            m2.c(this, i3);
        }
        c(m2);
        return m2;
    }

    public void e(i3 i3Var, int i2) {
        int i3 = i3Var.c;
        if (i3 == -1) {
            i3Var.d(this, (float) i2);
        } else if (i3 != -1) {
            d3 d3Var = this.e[i3];
            if (d3Var.e) {
                d3Var.b = (float) i2;
            } else if (d3Var.d.a() == 0) {
                d3Var.e = true;
                d3Var.b = (float) i2;
            } else {
                d3 m2 = m();
                if (i2 < 0) {
                    m2.b = (float) (i2 * -1);
                    m2.d.i(i3Var, 1.0f);
                } else {
                    m2.b = (float) i2;
                    m2.d.i(i3Var, -1.0f);
                }
                c(m2);
            }
        } else {
            d3 m3 = m();
            m3.f781a = i3Var;
            float f2 = (float) i2;
            i3Var.e = f2;
            m3.b = f2;
            m3.e = true;
            c(m3);
        }
    }

    public void f(i3 i3Var, i3 i3Var2, int i2, int i3) {
        d3 m2 = m();
        i3 n2 = n();
        n2.d = 0;
        m2.e(i3Var, i3Var2, n2, i2);
        if (i3 != 8) {
            m2.d.i(k(i3, null), (float) ((int) (m2.d.f(n2) * -1.0f)));
        }
        c(m2);
    }

    public void g(i3 i3Var, i3 i3Var2, int i2, int i3) {
        d3 m2 = m();
        i3 n2 = n();
        n2.d = 0;
        m2.f(i3Var, i3Var2, n2, i2);
        if (i3 != 8) {
            m2.d.i(k(i3, null), (float) ((int) (m2.d.f(n2) * -1.0f)));
        }
        c(m2);
    }

    public void h(i3 i3Var, i3 i3Var2, i3 i3Var3, i3 i3Var4, float f2, int i2) {
        d3 m2 = m();
        m2.d(i3Var, i3Var2, i3Var3, i3Var4, f2);
        if (i2 != 8) {
            m2.c(this, i2);
        }
        c(m2);
    }

    public final void i(d3 d3Var) {
        if (p) {
            d3[] d3VarArr = this.e;
            int i2 = this.i;
            if (d3VarArr[i2] != null) {
                this.k.f917a.b(d3VarArr[i2]);
            }
        } else {
            d3[] d3VarArr2 = this.e;
            int i3 = this.i;
            if (d3VarArr2[i3] != null) {
                this.k.b.b(d3VarArr2[i3]);
            }
        }
        d3[] d3VarArr3 = this.e;
        int i4 = this.i;
        d3VarArr3[i4] = d3Var;
        i3 i3Var = d3Var.f781a;
        i3Var.c = i4;
        this.i = i4 + 1;
        i3Var.e(d3Var);
    }

    public final void j() {
        for (int i2 = 0; i2 < this.i; i2++) {
            d3 d3Var = this.e[i2];
            d3Var.f781a.e = d3Var.b;
        }
    }

    public i3 k(int i2, String str) {
        if (this.h + 1 >= this.d) {
            p();
        }
        i3 a2 = a(i3.a.ERROR, str);
        int i3 = this.f1066a + 1;
        this.f1066a = i3;
        this.h++;
        a2.b = i3;
        a2.d = i2;
        this.k.d[i3] = a2;
        this.b.a(a2);
        return a2;
    }

    public i3 l(Object obj) {
        i3 i3Var = null;
        if (obj == null) {
            return null;
        }
        if (this.h + 1 >= this.d) {
            p();
        }
        if (obj instanceof m3) {
            m3 m3Var = (m3) obj;
            i3Var = m3Var.g;
            if (i3Var == null) {
                m3Var.i();
                i3Var = m3Var.g;
            }
            int i2 = i3Var.b;
            if (i2 == -1 || i2 > this.f1066a || this.k.d[i2] == null) {
                if (i2 != -1) {
                    i3Var.c();
                }
                int i3 = this.f1066a + 1;
                this.f1066a = i3;
                this.h++;
                i3Var.b = i3;
                i3Var.i = i3.a.UNRESTRICTED;
                this.k.d[i3] = i3Var;
            }
        }
        return i3Var;
    }

    public d3 m() {
        d3 d3Var;
        if (p) {
            d3Var = this.k.f917a.a();
            if (d3Var == null) {
                d3Var = new b(this, this.k);
                r++;
            } else {
                d3Var.f781a = null;
                d3Var.d.clear();
                d3Var.b = 0.0f;
                d3Var.e = false;
            }
        } else {
            d3Var = this.k.b.a();
            if (d3Var == null) {
                d3Var = new d3(this.k);
                q++;
            } else {
                d3Var.f781a = null;
                d3Var.d.clear();
                d3Var.b = 0.0f;
                d3Var.e = false;
            }
        }
        i3.m++;
        return d3Var;
    }

    public i3 n() {
        if (this.h + 1 >= this.d) {
            p();
        }
        i3 a2 = a(i3.a.SLACK, null);
        int i2 = this.f1066a + 1;
        this.f1066a = i2;
        this.h++;
        a2.b = i2;
        this.k.d[i2] = a2;
        return a2;
    }

    public int o(Object obj) {
        i3 i3Var = ((m3) obj).g;
        if (i3Var != null) {
            return (int) (i3Var.e + 0.5f);
        }
        return 0;
    }

    public final void p() {
        int i2 = this.c * 2;
        this.c = i2;
        this.e = (d3[]) Arrays.copyOf(this.e, i2);
        e3 e3Var = this.k;
        e3Var.d = (i3[]) Arrays.copyOf(e3Var.d, this.c);
        int i3 = this.c;
        this.g = new boolean[i3];
        this.d = i3;
        this.j = i3;
    }

    public void q(a aVar) throws Exception {
        float f2;
        boolean z;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.i) {
                z = false;
                break;
            }
            d3[] d3VarArr = this.e;
            if (d3VarArr[i2].f781a.i != i3.a.UNRESTRICTED && d3VarArr[i2].b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                i3++;
                float f3 = Float.MAX_VALUE;
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = 0;
                while (i4 < this.i) {
                    d3 d3Var = this.e[i4];
                    if (d3Var.f781a.i != i3.a.UNRESTRICTED && !d3Var.e && d3Var.b < f2) {
                        int i8 = 1;
                        while (i8 < this.h) {
                            i3 i3Var = this.k.d[i8];
                            float f4 = d3Var.d.f(i3Var);
                            if (f4 > f2) {
                                for (int i9 = 0; i9 < 9; i9++) {
                                    float f5 = i3Var.g[i9] / f4;
                                    if ((f5 < f3 && i9 == i7) || i9 > i7) {
                                        i7 = i9;
                                        f3 = f5;
                                        i5 = i4;
                                        i6 = i8;
                                    }
                                }
                            }
                            i8++;
                            f2 = 0.0f;
                        }
                    }
                    i4++;
                    f2 = 0.0f;
                }
                if (i5 != -1) {
                    d3 d3Var2 = this.e[i5];
                    d3Var2.f781a.c = -1;
                    d3Var2.j(this.k.d[i6]);
                    i3 i3Var2 = d3Var2.f781a;
                    i3Var2.c = i5;
                    i3Var2.e(d3Var2);
                } else {
                    z2 = true;
                }
                if (i3 > this.h / 2) {
                    z2 = true;
                }
                f2 = 0.0f;
            }
        }
        r(aVar);
        j();
    }

    public final int r(a aVar) {
        for (int i2 = 0; i2 < this.h; i2++) {
            this.g[i2] = false;
        }
        boolean z = false;
        int i3 = 0;
        while (!z) {
            i3++;
            if (i3 >= this.h * 2) {
                return i3;
            }
            i3 i3Var = ((d3) aVar).f781a;
            if (i3Var != null) {
                this.g[i3Var.b] = true;
            }
            i3 b2 = aVar.b(this, this.g);
            if (b2 != null) {
                boolean[] zArr = this.g;
                int i4 = b2.b;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (b2 != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.i; i6++) {
                    d3 d3Var = this.e[i6];
                    if (d3Var.f781a.i != i3.a.UNRESTRICTED && !d3Var.e && d3Var.d.g(b2)) {
                        float f3 = d3Var.d.f(b2);
                        if (f3 < 0.0f) {
                            float f4 = (-d3Var.b) / f3;
                            if (f4 < f2) {
                                i5 = i6;
                                f2 = f4;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    d3 d3Var2 = this.e[i5];
                    d3Var2.f781a.c = -1;
                    d3Var2.j(b2);
                    i3 i3Var2 = d3Var2.f781a;
                    i3Var2.c = i5;
                    i3Var2.e(d3Var2);
                }
            } else {
                z = true;
            }
        }
        return i3;
    }

    public final void s() {
        int i2 = 0;
        if (p) {
            while (true) {
                d3[] d3VarArr = this.e;
                if (i2 < d3VarArr.length) {
                    d3 d3Var = d3VarArr[i2];
                    if (d3Var != null) {
                        this.k.f917a.b(d3Var);
                    }
                    this.e[i2] = null;
                    i2++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                d3[] d3VarArr2 = this.e;
                if (i2 < d3VarArr2.length) {
                    d3 d3Var2 = d3VarArr2[i2];
                    if (d3Var2 != null) {
                        this.k.b.b(d3Var2);
                    }
                    this.e[i2] = null;
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void t() {
        e3 e3Var;
        int i2 = 0;
        while (true) {
            e3Var = this.k;
            i3[] i3VarArr = e3Var.d;
            if (i2 >= i3VarArr.length) {
                break;
            }
            i3 i3Var = i3VarArr[i2];
            if (i3Var != null) {
                i3Var.c();
            }
            i2++;
        }
        g3<i3> g3Var = e3Var.c;
        i3[] i3VarArr2 = this.l;
        int i3 = this.m;
        Objects.requireNonNull(g3Var);
        if (i3 > i3VarArr2.length) {
            i3 = i3VarArr2.length;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            i3 i3Var2 = i3VarArr2[i4];
            int i5 = g3Var.b;
            Object[] objArr = g3Var.f1207a;
            if (i5 < objArr.length) {
                objArr[i5] = i3Var2;
                g3Var.b = i5 + 1;
            }
        }
        this.m = 0;
        Arrays.fill(this.k.d, (Object) null);
        this.f1066a = 0;
        this.b.clear();
        this.h = 1;
        for (int i6 = 0; i6 < this.i; i6++) {
            Objects.requireNonNull(this.e[i6]);
        }
        s();
        this.i = 0;
        if (p) {
            this.n = new b(this, this.k);
        } else {
            this.n = new d3(this.k);
        }
    }
}
