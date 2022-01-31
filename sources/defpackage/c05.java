package defpackage;

import defpackage.c15;
import defpackage.t05;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/* renamed from: c05  reason: default package */
/* compiled from: CodedInputStreamReader */
public final class c05 implements w15 {

    /* renamed from: a  reason: collision with root package name */
    public final b05 f500a;
    public int b;
    public int c;
    public int d = 0;

    public c05(b05 b05) {
        Charset charset = s05.f3160a;
        this.f500a = b05;
        b05.d = this;
    }

    @Override // defpackage.w15
    public void A(List<Float> list) throws IOException {
        int A;
        int A2;
        if (list instanceof o05) {
            o05 o05 = (o05) list;
            int i = this.b & 7;
            if (i == 2) {
                int B = this.f500a.B();
                W(B);
                int d2 = this.f500a.d() + B;
                do {
                    o05.d(this.f500a.q());
                } while (this.f500a.d() < d2);
            } else if (i == 5) {
                do {
                    o05.d(this.f500a.q());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 2) {
                int B2 = this.f500a.B();
                W(B2);
                int d3 = this.f500a.d() + B2;
                do {
                    list.add(Float.valueOf(this.f500a.q()));
                } while (this.f500a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.f500a.q()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public int B() throws IOException {
        V(0);
        return this.f500a.r();
    }

    @Override // defpackage.w15
    public boolean C() throws IOException {
        int i;
        if (this.f500a.e() || (i = this.b) == this.c) {
            return false;
        }
        return this.f500a.D(i);
    }

    @Override // defpackage.w15
    public int D() throws IOException {
        V(5);
        return this.f500a.u();
    }

    @Override // defpackage.w15
    public void E(List<a05> list) throws IOException {
        int A;
        if ((this.b & 7) == 2) {
            do {
                list.add(z());
                if (!this.f500a.e()) {
                    A = this.f500a.A();
                } else {
                    return;
                }
            } while (A == this.b);
            this.d = A;
            return;
        }
        throw t05.d();
    }

    @Override // defpackage.w15
    public void F(List<Double> list) throws IOException {
        int A;
        int A2;
        if (list instanceof f05) {
            f05 f05 = (f05) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    f05.d(this.f500a.m());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else if (i == 2) {
                int B = this.f500a.B();
                X(B);
                int d2 = this.f500a.d() + B;
                do {
                    f05.d(this.f500a.m());
                } while (this.f500a.d() < d2);
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.f500a.m()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else if (i2 == 2) {
                int B2 = this.f500a.B();
                X(B2);
                int d3 = this.f500a.d() + B2;
                do {
                    list.add(Double.valueOf(this.f500a.m()));
                } while (this.f500a.d() < d3);
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public long G() throws IOException {
        V(0);
        return this.f500a.s();
    }

    @Override // defpackage.w15
    public String H() throws IOException {
        V(2);
        return this.f500a.z();
    }

    @Override // defpackage.w15
    public void I(List<Long> list) throws IOException {
        int A;
        int A2;
        if (list instanceof a15) {
            a15 a15 = (a15) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    a15.d(this.f500a.p());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else if (i == 2) {
                int B = this.f500a.B();
                X(B);
                int d2 = this.f500a.d() + B;
                do {
                    a15.d(this.f500a.p());
                } while (this.f500a.d() < d2);
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f500a.p()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else if (i2 == 2) {
                int B2 = this.f500a.B();
                X(B2);
                int d3 = this.f500a.d() + B2;
                do {
                    list.add(Long.valueOf(this.f500a.p()));
                } while (this.f500a.d() < d3);
            } else {
                throw t05.d();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.w15
    public <T> void J(List<T> list, x15<T> x15, i05 i05) throws IOException {
        int A;
        int i = this.b;
        if ((i & 7) == 3) {
            do {
                list.add(R(x15, i05));
                if (!this.f500a.e() && this.d == 0) {
                    A = this.f500a.A();
                } else {
                    return;
                }
            } while (A == i);
            this.d = A;
            return;
        }
        throw t05.d();
    }

    @Override // defpackage.w15
    public <T> T K(Class<T> cls, i05 i05) throws IOException {
        V(2);
        return (T) S(t15.c.a(cls), i05);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.w15
    public <T> void L(List<T> list, x15<T> x15, i05 i05) throws IOException {
        int A;
        int i = this.b;
        if ((i & 7) == 2) {
            do {
                list.add(S(x15, i05));
                if (!this.f500a.e() && this.d == 0) {
                    A = this.f500a.A();
                } else {
                    return;
                }
            } while (A == i);
            this.d = A;
            return;
        }
        throw t05.d();
    }

    @Override // defpackage.w15
    public <T> T M(x15<T> x15, i05 i05) throws IOException {
        V(3);
        return (T) R(x15, i05);
    }

    @Override // defpackage.w15
    public <T> T N(Class<T> cls, i05 i05) throws IOException {
        V(3);
        return (T) R(t15.c.a(cls), i05);
    }

    @Override // defpackage.w15
    public <T> T O(x15<T> x15, i05 i05) throws IOException {
        V(2);
        return (T) S(x15, i05);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.w15
    public <K, V> void P(Map<K, V> map, c15.a<K, V> aVar, i05 i05) throws IOException {
        V(2);
        int j = this.f500a.j(this.f500a.B());
        Object obj = aVar.b;
        Object obj2 = aVar.d;
        while (true) {
            try {
                int w = w();
                if (w == Integer.MAX_VALUE || this.f500a.e()) {
                    map.put(obj, obj2);
                } else if (w == 1) {
                    obj = Q(aVar.f504a, null, null);
                } else if (w != 2) {
                    try {
                        if (!C()) {
                            throw new t05("Unable to parse map entry.");
                        }
                    } catch (t05.a unused) {
                        if (!C()) {
                            throw new t05("Unable to parse map entry.");
                        }
                    }
                } else {
                    obj2 = Q(aVar.c, aVar.d.getClass(), i05);
                }
            } finally {
                this.f500a.i(j);
            }
        }
        map.put(obj, obj2);
    }

    public final Object Q(l25 l25, Class<?> cls, i05 i05) throws IOException {
        switch (l25.ordinal()) {
            case 0:
                return Double.valueOf(readDouble());
            case 1:
                return Float.valueOf(readFloat());
            case 2:
                return Long.valueOf(G());
            case 3:
                return Long.valueOf(c());
            case 4:
                return Integer.valueOf(B());
            case 5:
                return Long.valueOf(d());
            case 6:
                return Integer.valueOf(h());
            case 7:
                return Boolean.valueOf(i());
            case 8:
                return H();
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return K(cls, i05);
            case 11:
                return z();
            case 12:
                return Integer.valueOf(l());
            case 13:
                return Integer.valueOf(q());
            case 14:
                return Integer.valueOf(D());
            case 15:
                return Long.valueOf(j());
            case 16:
                return Integer.valueOf(s());
            case 17:
                return Long.valueOf(t());
        }
    }

    public final <T> T R(x15<T> x15, i05 i05) throws IOException {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            T d2 = x15.d();
            x15.i(d2, this, i05);
            x15.e(d2);
            if (this.b == this.c) {
                return d2;
            }
            throw t05.g();
        } finally {
            this.c = i;
        }
    }

    public final <T> T S(x15<T> x15, i05 i05) throws IOException {
        int B = this.f500a.B();
        b05 b05 = this.f500a;
        if (b05.f362a < b05.b) {
            int j = b05.j(B);
            T d2 = x15.d();
            this.f500a.f362a++;
            x15.i(d2, this, i05);
            x15.e(d2);
            this.f500a.a(0);
            b05 b052 = this.f500a;
            b052.f362a--;
            b052.i(j);
            return d2;
        }
        throw new t05("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public void T(List<String> list, boolean z) throws IOException {
        int A;
        int A2;
        if ((this.b & 7) != 2) {
            throw t05.d();
        } else if (!(list instanceof y05) || z) {
            do {
                list.add(z ? H() : v());
                if (!this.f500a.e()) {
                    A = this.f500a.A();
                } else {
                    return;
                }
            } while (A == this.b);
            this.d = A;
        } else {
            y05 y05 = (y05) list;
            do {
                y05.K(z());
                if (!this.f500a.e()) {
                    A2 = this.f500a.A();
                } else {
                    return;
                }
            } while (A2 == this.b);
            this.d = A2;
        }
    }

    public final void U(int i) throws IOException {
        if (this.f500a.d() != i) {
            throw t05.h();
        }
    }

    public final void V(int i) throws IOException {
        if ((this.b & 7) != i) {
            throw t05.d();
        }
    }

    public final void W(int i) throws IOException {
        if ((i & 3) != 0) {
            throw t05.g();
        }
    }

    public final void X(int i) throws IOException {
        if ((i & 7) != 0) {
            throw t05.g();
        }
    }

    @Override // defpackage.w15
    public int a() {
        return this.b;
    }

    @Override // defpackage.w15
    public void b(List<Integer> list) throws IOException {
        int A;
        int A2;
        if (list instanceof r05) {
            r05 r05 = (r05) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    r05.d(this.f500a.w());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else if (i == 2) {
                int d2 = this.f500a.d() + this.f500a.B();
                do {
                    r05.d(this.f500a.w());
                } while (this.f500a.d() < d2);
                U(d2);
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f500a.w()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else if (i2 == 2) {
                int d3 = this.f500a.d() + this.f500a.B();
                do {
                    list.add(Integer.valueOf(this.f500a.w()));
                } while (this.f500a.d() < d3);
                U(d3);
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public long c() throws IOException {
        V(0);
        return this.f500a.C();
    }

    @Override // defpackage.w15
    public long d() throws IOException {
        V(1);
        return this.f500a.p();
    }

    @Override // defpackage.w15
    public void e(List<Integer> list) throws IOException {
        int A;
        int A2;
        if (list instanceof r05) {
            r05 r05 = (r05) list;
            int i = this.b & 7;
            if (i == 2) {
                int B = this.f500a.B();
                W(B);
                int d2 = this.f500a.d() + B;
                do {
                    r05.d(this.f500a.u());
                } while (this.f500a.d() < d2);
            } else if (i == 5) {
                do {
                    r05.d(this.f500a.u());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 2) {
                int B2 = this.f500a.B();
                W(B2);
                int d3 = this.f500a.d() + B2;
                do {
                    list.add(Integer.valueOf(this.f500a.u()));
                } while (this.f500a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f500a.u()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public void f(List<Long> list) throws IOException {
        int A;
        int A2;
        if (list instanceof a15) {
            a15 a15 = (a15) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    a15.d(this.f500a.x());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else if (i == 2) {
                int d2 = this.f500a.d() + this.f500a.B();
                do {
                    a15.d(this.f500a.x());
                } while (this.f500a.d() < d2);
                U(d2);
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f500a.x()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else if (i2 == 2) {
                int d3 = this.f500a.d() + this.f500a.B();
                do {
                    list.add(Long.valueOf(this.f500a.x()));
                } while (this.f500a.d() < d3);
                U(d3);
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public void g(List<Integer> list) throws IOException {
        int A;
        int A2;
        if (list instanceof r05) {
            r05 r05 = (r05) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    r05.d(this.f500a.B());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else if (i == 2) {
                int d2 = this.f500a.d() + this.f500a.B();
                do {
                    r05.d(this.f500a.B());
                } while (this.f500a.d() < d2);
                U(d2);
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f500a.B()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else if (i2 == 2) {
                int d3 = this.f500a.d() + this.f500a.B();
                do {
                    list.add(Integer.valueOf(this.f500a.B()));
                } while (this.f500a.d() < d3);
                U(d3);
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public int h() throws IOException {
        V(5);
        return this.f500a.o();
    }

    @Override // defpackage.w15
    public boolean i() throws IOException {
        V(0);
        return this.f500a.k();
    }

    @Override // defpackage.w15
    public long j() throws IOException {
        V(1);
        return this.f500a.v();
    }

    @Override // defpackage.w15
    public void k(List<Long> list) throws IOException {
        int A;
        int A2;
        if (list instanceof a15) {
            a15 a15 = (a15) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    a15.d(this.f500a.C());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else if (i == 2) {
                int d2 = this.f500a.d() + this.f500a.B();
                do {
                    a15.d(this.f500a.C());
                } while (this.f500a.d() < d2);
                U(d2);
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f500a.C()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else if (i2 == 2) {
                int d3 = this.f500a.d() + this.f500a.B();
                do {
                    list.add(Long.valueOf(this.f500a.C()));
                } while (this.f500a.d() < d3);
                U(d3);
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public int l() throws IOException {
        V(0);
        return this.f500a.B();
    }

    @Override // defpackage.w15
    public void m(List<Long> list) throws IOException {
        int A;
        int A2;
        if (list instanceof a15) {
            a15 a15 = (a15) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    a15.d(this.f500a.s());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else if (i == 2) {
                int d2 = this.f500a.d() + this.f500a.B();
                do {
                    a15.d(this.f500a.s());
                } while (this.f500a.d() < d2);
                U(d2);
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f500a.s()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else if (i2 == 2) {
                int d3 = this.f500a.d() + this.f500a.B();
                do {
                    list.add(Long.valueOf(this.f500a.s()));
                } while (this.f500a.d() < d3);
                U(d3);
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public void n(List<Long> list) throws IOException {
        int A;
        int A2;
        if (list instanceof a15) {
            a15 a15 = (a15) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    a15.d(this.f500a.v());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else if (i == 2) {
                int B = this.f500a.B();
                X(B);
                int d2 = this.f500a.d() + B;
                do {
                    a15.d(this.f500a.v());
                } while (this.f500a.d() < d2);
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f500a.v()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else if (i2 == 2) {
                int B2 = this.f500a.B();
                X(B2);
                int d3 = this.f500a.d() + B2;
                do {
                    list.add(Long.valueOf(this.f500a.v()));
                } while (this.f500a.d() < d3);
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public void o(List<Integer> list) throws IOException {
        int A;
        int A2;
        if (list instanceof r05) {
            r05 r05 = (r05) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    r05.d(this.f500a.r());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else if (i == 2) {
                int d2 = this.f500a.d() + this.f500a.B();
                do {
                    r05.d(this.f500a.r());
                } while (this.f500a.d() < d2);
                U(d2);
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f500a.r()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else if (i2 == 2) {
                int d3 = this.f500a.d() + this.f500a.B();
                do {
                    list.add(Integer.valueOf(this.f500a.r()));
                } while (this.f500a.d() < d3);
                U(d3);
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public void p(List<Integer> list) throws IOException {
        int A;
        int A2;
        if (list instanceof r05) {
            r05 r05 = (r05) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    r05.d(this.f500a.n());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else if (i == 2) {
                int d2 = this.f500a.d() + this.f500a.B();
                do {
                    r05.d(this.f500a.n());
                } while (this.f500a.d() < d2);
                U(d2);
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f500a.n()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else if (i2 == 2) {
                int d3 = this.f500a.d() + this.f500a.B();
                do {
                    list.add(Integer.valueOf(this.f500a.n()));
                } while (this.f500a.d() < d3);
                U(d3);
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public int q() throws IOException {
        V(0);
        return this.f500a.n();
    }

    @Override // defpackage.w15
    public void r(List<Integer> list) throws IOException {
        int A;
        int A2;
        if (list instanceof r05) {
            r05 r05 = (r05) list;
            int i = this.b & 7;
            if (i == 2) {
                int B = this.f500a.B();
                W(B);
                int d2 = this.f500a.d() + B;
                do {
                    r05.d(this.f500a.o());
                } while (this.f500a.d() < d2);
            } else if (i == 5) {
                do {
                    r05.d(this.f500a.o());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 2) {
                int B2 = this.f500a.B();
                W(B2);
                int d3 = this.f500a.d() + B2;
                do {
                    list.add(Integer.valueOf(this.f500a.o()));
                } while (this.f500a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f500a.o()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public double readDouble() throws IOException {
        V(1);
        return this.f500a.m();
    }

    @Override // defpackage.w15
    public float readFloat() throws IOException {
        V(5);
        return this.f500a.q();
    }

    @Override // defpackage.w15
    public int s() throws IOException {
        V(0);
        return this.f500a.w();
    }

    @Override // defpackage.w15
    public long t() throws IOException {
        V(0);
        return this.f500a.x();
    }

    @Override // defpackage.w15
    public void u(List<Boolean> list) throws IOException {
        int A;
        int A2;
        if (list instanceof xz4) {
            xz4 xz4 = (xz4) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    xz4.d(this.f500a.k());
                    if (!this.f500a.e()) {
                        A2 = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.d = A2;
            } else if (i == 2) {
                int d2 = this.f500a.d() + this.f500a.B();
                do {
                    xz4.d(this.f500a.k());
                } while (this.f500a.d() < d2);
                U(d2);
            } else {
                throw t05.d();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f500a.k()));
                    if (!this.f500a.e()) {
                        A = this.f500a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.d = A;
            } else if (i2 == 2) {
                int d3 = this.f500a.d() + this.f500a.B();
                do {
                    list.add(Boolean.valueOf(this.f500a.k()));
                } while (this.f500a.d() < d3);
                U(d3);
            } else {
                throw t05.d();
            }
        }
    }

    @Override // defpackage.w15
    public String v() throws IOException {
        V(2);
        return this.f500a.y();
    }

    @Override // defpackage.w15
    public int w() throws IOException {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f500a.A();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // defpackage.w15
    public void x(List<String> list) throws IOException {
        T(list, false);
    }

    @Override // defpackage.w15
    public void y(List<String> list) throws IOException {
        T(list, true);
    }

    @Override // defpackage.w15
    public a05 z() throws IOException {
        V(2);
        return this.f500a.l();
    }
}
