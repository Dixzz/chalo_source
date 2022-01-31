package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/* renamed from: i93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class i93 {

    /* renamed from: a  reason: collision with root package name */
    public final h93 f1496a;
    public int b;
    public int c;
    public int d = 0;

    public i93(h93 h93) {
        Charset charset = ka3.f2038a;
        this.f1496a = h93;
        h93.b = this;
    }

    public static final void t(int i) throws IOException {
        if ((i & 3) != 0) {
            throw ma3.f();
        }
    }

    public static final void u(int i) throws IOException {
        if ((i & 7) != 0) {
            throw ma3.f();
        }
    }

    public final long A() throws IOException {
        p(0);
        return this.f1496a.f();
    }

    public final int B() throws IOException {
        p(0);
        return this.f1496a.e();
    }

    public final long C() throws IOException {
        p(1);
        return this.f1496a.i();
    }

    public final int D() throws IOException {
        p(5);
        return this.f1496a.h();
    }

    public final boolean E() throws IOException {
        p(0);
        return this.f1496a.d();
    }

    public final String F() throws IOException {
        p(2);
        h93 h93 = this.f1496a;
        int e = h93.e();
        if (e > 0) {
            int i = h93.d;
            int i2 = h93.f;
            if (e <= i - i2) {
                String str = new String(h93.c, i2, e, ka3.f2038a);
                h93.f += e;
                return str;
            }
        }
        if (e == 0) {
            return "";
        }
        if (e < 0) {
            throw ma3.b();
        }
        throw ma3.a();
    }

    public final String G() throws IOException {
        p(2);
        h93 h93 = this.f1496a;
        int e = h93.e();
        if (e > 0) {
            int i = h93.d;
            int i2 = h93.f;
            if (e <= i - i2) {
                String b2 = qn2.f2965a.b(h93.c, i2, e);
                h93.f += e;
                return b2;
            }
        }
        if (e == 0) {
            return "";
        }
        if (e <= 0) {
            throw ma3.b();
        }
        throw ma3.a();
    }

    public final <T> T H(mm2<T> mm2, s93 s93) throws IOException {
        p(2);
        return (T) q(mm2, s93);
    }

    public final <T> T I(mm2<T> mm2, s93 s93) throws IOException {
        p(3);
        return (T) r(mm2, s93);
    }

    public final g93 J() throws IOException {
        p(2);
        h93 h93 = this.f1496a;
        int e = h93.e();
        if (e > 0) {
            int i = h93.d;
            int i2 = h93.f;
            if (e <= i - i2) {
                g93 A = g93.A(h93.c, i2, e);
                h93.f += e;
                return A;
            }
        }
        if (e == 0) {
            return g93.g;
        }
        if (e > 0) {
            int i3 = h93.d;
            int i4 = h93.f;
            if (e <= i3 - i4) {
                int i5 = e + i4;
                h93.f = i5;
                byte[] copyOfRange = Arrays.copyOfRange(h93.c, i4, i5);
                g93 g93 = g93.g;
                return new e93(copyOfRange);
            }
        }
        if (e <= 0) {
            throw ma3.b();
        }
        throw ma3.a();
    }

    public final int K() throws IOException {
        p(0);
        return this.f1496a.e();
    }

    public final int L() throws IOException {
        p(0);
        return this.f1496a.e();
    }

    public final int M() throws IOException {
        p(5);
        return this.f1496a.h();
    }

    public final long N() throws IOException {
        p(1);
        return this.f1496a.i();
    }

    public final int O() throws IOException {
        p(0);
        return h93.n(this.f1496a.e());
    }

    public final long P() throws IOException {
        p(0);
        return h93.o(this.f1496a.f());
    }

    public final void Q(List<Double> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof p93) {
            p93 p93 = (p93) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    p93.d(Double.longBitsToDouble(this.f1496a.i()));
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else if (i == 2) {
                int e = this.f1496a.e();
                u(e);
                int i2 = this.f1496a.f + e;
                do {
                    p93.d(Double.longBitsToDouble(this.f1496a.i()));
                } while (this.f1496a.f < i2);
            } else {
                int i3 = ma3.f;
                throw new la3();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 1) {
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(this.f1496a.i())));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else if (i4 == 2) {
                int e2 = this.f1496a.e();
                u(e2);
                int i5 = this.f1496a.f + e2;
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(this.f1496a.i())));
                } while (this.f1496a.f < i5);
            } else {
                int i6 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void R(List<Float> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof z93) {
            z93 z93 = (z93) list;
            int i = this.b & 7;
            if (i == 2) {
                int e = this.f1496a.e();
                t(e);
                int i2 = this.f1496a.f + e;
                do {
                    z93.d(Float.intBitsToFloat(this.f1496a.h()));
                } while (this.f1496a.f < i2);
            } else if (i == 5) {
                do {
                    z93.d(Float.intBitsToFloat(this.f1496a.h()));
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else {
                int i3 = ma3.f;
                throw new la3();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 2) {
                int e2 = this.f1496a.e();
                t(e2);
                int i5 = this.f1496a.f + e2;
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(this.f1496a.h())));
                } while (this.f1496a.f < i5);
            } else if (i4 == 5) {
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(this.f1496a.h())));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else {
                int i6 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void S(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof rl2) {
            rl2 rl2 = (rl2) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    rl2.e(this.f1496a.f());
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else if (i == 2) {
                int e = this.f1496a.f + this.f1496a.e();
                do {
                    rl2.e(this.f1496a.f());
                } while (this.f1496a.f < e);
                s(e);
            } else {
                int i2 = ma3.f;
                throw new la3();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f1496a.f()));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else if (i3 == 2) {
                int e2 = this.f1496a.f + this.f1496a.e();
                do {
                    list.add(Long.valueOf(this.f1496a.f()));
                } while (this.f1496a.f < e2);
                s(e2);
            } else {
                int i4 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void a(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof rl2) {
            rl2 rl2 = (rl2) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    rl2.e(this.f1496a.f());
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else if (i == 2) {
                int e = this.f1496a.f + this.f1496a.e();
                do {
                    rl2.e(this.f1496a.f());
                } while (this.f1496a.f < e);
                s(e);
            } else {
                int i2 = ma3.f;
                throw new la3();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f1496a.f()));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else if (i3 == 2) {
                int e2 = this.f1496a.f + this.f1496a.e();
                do {
                    list.add(Long.valueOf(this.f1496a.f()));
                } while (this.f1496a.f < e2);
                s(e2);
            } else {
                int i4 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void b(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof fa3) {
            fa3 fa3 = (fa3) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    fa3.e(this.f1496a.e());
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else if (i == 2) {
                int e = this.f1496a.f + this.f1496a.e();
                do {
                    fa3.e(this.f1496a.e());
                } while (this.f1496a.f < e);
                s(e);
            } else {
                int i2 = ma3.f;
                throw new la3();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f1496a.e()));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else if (i3 == 2) {
                int e2 = this.f1496a.f + this.f1496a.e();
                do {
                    list.add(Integer.valueOf(this.f1496a.e()));
                } while (this.f1496a.f < e2);
                s(e2);
            } else {
                int i4 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void c(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof rl2) {
            rl2 rl2 = (rl2) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    rl2.e(this.f1496a.i());
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else if (i == 2) {
                int e = this.f1496a.e();
                u(e);
                int i2 = this.f1496a.f + e;
                do {
                    rl2.e(this.f1496a.i());
                } while (this.f1496a.f < i2);
            } else {
                int i3 = ma3.f;
                throw new la3();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 1) {
                do {
                    list.add(Long.valueOf(this.f1496a.i()));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else if (i4 == 2) {
                int e2 = this.f1496a.e();
                u(e2);
                int i5 = this.f1496a.f + e2;
                do {
                    list.add(Long.valueOf(this.f1496a.i()));
                } while (this.f1496a.f < i5);
            } else {
                int i6 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void d(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof fa3) {
            fa3 fa3 = (fa3) list;
            int i = this.b & 7;
            if (i == 2) {
                int e = this.f1496a.e();
                t(e);
                int i2 = this.f1496a.f + e;
                do {
                    fa3.e(this.f1496a.h());
                } while (this.f1496a.f < i2);
            } else if (i == 5) {
                do {
                    fa3.e(this.f1496a.h());
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else {
                int i3 = ma3.f;
                throw new la3();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 2) {
                int e2 = this.f1496a.e();
                t(e2);
                int i5 = this.f1496a.f + e2;
                do {
                    list.add(Integer.valueOf(this.f1496a.h()));
                } while (this.f1496a.f < i5);
            } else if (i4 == 5) {
                do {
                    list.add(Integer.valueOf(this.f1496a.h()));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else {
                int i6 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void e(List<Boolean> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof w83) {
            w83 w83 = (w83) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    w83.d(this.f1496a.d());
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else if (i == 2) {
                int e = this.f1496a.f + this.f1496a.e();
                do {
                    w83.d(this.f1496a.d());
                } while (this.f1496a.f < e);
                s(e);
            } else {
                int i2 = ma3.f;
                throw new la3();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f1496a.d()));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else if (i3 == 2) {
                int e2 = this.f1496a.f + this.f1496a.e();
                do {
                    list.add(Boolean.valueOf(this.f1496a.d()));
                } while (this.f1496a.f < e2);
                s(e2);
            } else {
                int i4 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void f(List<String> list, boolean z) throws IOException {
        int a2;
        int a3;
        if ((this.b & 7) != 2) {
            int i = ma3.f;
            throw new la3();
        } else if ((list instanceof nl2) && !z) {
            nl2 nl2 = (nl2) list;
            do {
                nl2.X(J());
                if (!this.f1496a.k()) {
                    a3 = this.f1496a.a();
                } else {
                    return;
                }
            } while (a3 == this.b);
            this.d = a3;
        } else {
            do {
                list.add(z ? G() : F());
                if (!this.f1496a.k()) {
                    a2 = this.f1496a.a();
                } else {
                    return;
                }
            } while (a2 == this.b);
            this.d = a2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void g(List<T> list, mm2<T> mm2, s93 s93) throws IOException {
        int a2;
        int i = this.b;
        if ((i & 7) == 2) {
            do {
                list.add(q(mm2, s93));
                if (!this.f1496a.k() && this.d == 0) {
                    a2 = this.f1496a.a();
                } else {
                    return;
                }
            } while (a2 == i);
            this.d = a2;
            return;
        }
        int i2 = ma3.f;
        throw new la3();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void h(List<T> list, mm2<T> mm2, s93 s93) throws IOException {
        int a2;
        int i = this.b;
        if ((i & 7) == 3) {
            do {
                list.add(r(mm2, s93));
                if (!this.f1496a.k() && this.d == 0) {
                    a2 = this.f1496a.a();
                } else {
                    return;
                }
            } while (a2 == i);
            this.d = a2;
            return;
        }
        int i2 = ma3.f;
        throw new la3();
    }

    public final void i(List<g93> list) throws IOException {
        int a2;
        if ((this.b & 7) == 2) {
            do {
                list.add(J());
                if (!this.f1496a.k()) {
                    a2 = this.f1496a.a();
                } else {
                    return;
                }
            } while (a2 == this.b);
            this.d = a2;
            return;
        }
        int i = ma3.f;
        throw new la3();
    }

    public final void j(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof fa3) {
            fa3 fa3 = (fa3) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    fa3.e(this.f1496a.e());
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else if (i == 2) {
                int e = this.f1496a.f + this.f1496a.e();
                do {
                    fa3.e(this.f1496a.e());
                } while (this.f1496a.f < e);
                s(e);
            } else {
                int i2 = ma3.f;
                throw new la3();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f1496a.e()));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else if (i3 == 2) {
                int e2 = this.f1496a.f + this.f1496a.e();
                do {
                    list.add(Integer.valueOf(this.f1496a.e()));
                } while (this.f1496a.f < e2);
                s(e2);
            } else {
                int i4 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void k(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof fa3) {
            fa3 fa3 = (fa3) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    fa3.e(this.f1496a.e());
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else if (i == 2) {
                int e = this.f1496a.f + this.f1496a.e();
                do {
                    fa3.e(this.f1496a.e());
                } while (this.f1496a.f < e);
                s(e);
            } else {
                int i2 = ma3.f;
                throw new la3();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f1496a.e()));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else if (i3 == 2) {
                int e2 = this.f1496a.f + this.f1496a.e();
                do {
                    list.add(Integer.valueOf(this.f1496a.e()));
                } while (this.f1496a.f < e2);
                s(e2);
            } else {
                int i4 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void l(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof fa3) {
            fa3 fa3 = (fa3) list;
            int i = this.b & 7;
            if (i == 2) {
                int e = this.f1496a.e();
                t(e);
                int i2 = this.f1496a.f + e;
                do {
                    fa3.e(this.f1496a.h());
                } while (this.f1496a.f < i2);
            } else if (i == 5) {
                do {
                    fa3.e(this.f1496a.h());
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else {
                int i3 = ma3.f;
                throw new la3();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 2) {
                int e2 = this.f1496a.e();
                t(e2);
                int i5 = this.f1496a.f + e2;
                do {
                    list.add(Integer.valueOf(this.f1496a.h()));
                } while (this.f1496a.f < i5);
            } else if (i4 == 5) {
                do {
                    list.add(Integer.valueOf(this.f1496a.h()));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else {
                int i6 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void m(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof rl2) {
            rl2 rl2 = (rl2) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    rl2.e(this.f1496a.i());
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else if (i == 2) {
                int e = this.f1496a.e();
                u(e);
                int i2 = this.f1496a.f + e;
                do {
                    rl2.e(this.f1496a.i());
                } while (this.f1496a.f < i2);
            } else {
                int i3 = ma3.f;
                throw new la3();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 1) {
                do {
                    list.add(Long.valueOf(this.f1496a.i()));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else if (i4 == 2) {
                int e2 = this.f1496a.e();
                u(e2);
                int i5 = this.f1496a.f + e2;
                do {
                    list.add(Long.valueOf(this.f1496a.i()));
                } while (this.f1496a.f < i5);
            } else {
                int i6 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void n(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof fa3) {
            fa3 fa3 = (fa3) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    fa3.e(h93.n(this.f1496a.e()));
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else if (i == 2) {
                int e = this.f1496a.f + this.f1496a.e();
                do {
                    fa3.e(h93.n(this.f1496a.e()));
                } while (this.f1496a.f < e);
                s(e);
            } else {
                int i2 = ma3.f;
                throw new la3();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(h93.n(this.f1496a.e())));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else if (i3 == 2) {
                int e2 = this.f1496a.f + this.f1496a.e();
                do {
                    list.add(Integer.valueOf(h93.n(this.f1496a.e())));
                } while (this.f1496a.f < e2);
                s(e2);
            } else {
                int i4 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void o(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof rl2) {
            rl2 rl2 = (rl2) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    rl2.e(h93.o(this.f1496a.f()));
                    if (!this.f1496a.k()) {
                        a3 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.b);
                this.d = a3;
            } else if (i == 2) {
                int e = this.f1496a.f + this.f1496a.e();
                do {
                    rl2.e(h93.o(this.f1496a.f()));
                } while (this.f1496a.f < e);
                s(e);
            } else {
                int i2 = ma3.f;
                throw new la3();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(h93.o(this.f1496a.f())));
                    if (!this.f1496a.k()) {
                        a2 = this.f1496a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.b);
                this.d = a2;
            } else if (i3 == 2) {
                int e2 = this.f1496a.f + this.f1496a.e();
                do {
                    list.add(Long.valueOf(h93.o(this.f1496a.f())));
                } while (this.f1496a.f < e2);
                s(e2);
            } else {
                int i4 = ma3.f;
                throw new la3();
            }
        }
    }

    public final void p(int i) throws IOException {
        if ((this.b & 7) != i) {
            int i2 = ma3.f;
            throw new la3();
        }
    }

    public final <T> T q(mm2<T> mm2, s93 s93) throws IOException {
        int e = this.f1496a.e();
        h93 h93 = this.f1496a;
        if (h93.f1350a < 100) {
            int j = h93.j(e);
            T zza = mm2.zza();
            this.f1496a.f1350a++;
            mm2.j(zza, this, s93);
            mm2.d(zza);
            this.f1496a.b(0);
            h93 h932 = this.f1496a;
            h932.f1350a--;
            h932.h = j;
            h932.p();
            return zza;
        }
        throw new ma3("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public final <T> T r(mm2<T> mm2, s93 s93) throws IOException {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            T zza = mm2.zza();
            mm2.j(zza, this, s93);
            mm2.d(zza);
            if (this.b == this.c) {
                return zza;
            }
            throw ma3.f();
        } finally {
            this.c = i;
        }
    }

    public final void s(int i) throws IOException {
        if (this.f1496a.f != i) {
            throw ma3.a();
        }
    }

    public final int v() throws IOException {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            i = this.f1496a.a();
            this.b = i;
        }
        if (i == 0 || i == this.c) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final boolean w() throws IOException {
        int i;
        if (this.f1496a.k() || (i = this.b) == this.c) {
            return false;
        }
        return this.f1496a.c(i);
    }

    public final double x() throws IOException {
        p(1);
        return Double.longBitsToDouble(this.f1496a.i());
    }

    public final float y() throws IOException {
        p(5);
        return Float.intBitsToFloat(this.f1496a.h());
    }

    public final long z() throws IOException {
        p(0);
        return this.f1496a.f();
    }
}
