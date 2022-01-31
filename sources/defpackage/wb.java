package defpackage;

import defpackage.nc;
import defpackage.wc;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/* renamed from: wb  reason: default package */
/* compiled from: CodedInputStreamReader */
public final class wb implements qd {

    /* renamed from: a  reason: collision with root package name */
    public final vb f3754a;
    public int b;
    public int c;
    public int d = 0;

    public wb(vb vbVar) {
        Charset charset = mc.f2352a;
        this.f3754a = vbVar;
        vbVar.d = this;
    }

    @Override // defpackage.qd
    public void A(List<Float> list) throws IOException {
        int x;
        int x2;
        if (list instanceof ic) {
            ic icVar = (ic) list;
            int i = this.b & 7;
            if (i == 2) {
                int y = this.f3754a.y();
                V(y);
                int d2 = this.f3754a.d() + y;
                do {
                    icVar.d(this.f3754a.o());
                } while (this.f3754a.d() < d2);
            } else if (i == 5) {
                do {
                    icVar.d(this.f3754a.o());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 2) {
                int y2 = this.f3754a.y();
                V(y2);
                int d3 = this.f3754a.d() + y2;
                do {
                    list.add(Float.valueOf(this.f3754a.o()));
                } while (this.f3754a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.f3754a.o()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public int B() throws IOException {
        U(0);
        return this.f3754a.p();
    }

    @Override // defpackage.qd
    public boolean C() throws IOException {
        int i;
        if (this.f3754a.e() || (i = this.b) == this.c) {
            return false;
        }
        return this.f3754a.A(i);
    }

    @Override // defpackage.qd
    public int D() throws IOException {
        U(5);
        return this.f3754a.r();
    }

    @Override // defpackage.qd
    public void E(List<ub> list) throws IOException {
        int x;
        if ((this.b & 7) == 2) {
            do {
                list.add(z());
                if (!this.f3754a.e()) {
                    x = this.f3754a.x();
                } else {
                    return;
                }
            } while (x == this.b);
            this.d = x;
            return;
        }
        throw nc.c();
    }

    @Override // defpackage.qd
    public void F(List<Double> list) throws IOException {
        int x;
        int x2;
        if (list instanceof zb) {
            zb zbVar = (zb) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    zbVar.d(this.f3754a.k());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else if (i == 2) {
                int y = this.f3754a.y();
                W(y);
                int d2 = this.f3754a.d() + y;
                do {
                    zbVar.d(this.f3754a.k());
                } while (this.f3754a.d() < d2);
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.f3754a.k()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else if (i2 == 2) {
                int y2 = this.f3754a.y();
                W(y2);
                int d3 = this.f3754a.d() + y2;
                do {
                    list.add(Double.valueOf(this.f3754a.k()));
                } while (this.f3754a.d() < d3);
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public long G() throws IOException {
        U(0);
        return this.f3754a.q();
    }

    @Override // defpackage.qd
    public String H() throws IOException {
        U(2);
        return this.f3754a.w();
    }

    @Override // defpackage.qd
    public void I(List<Long> list) throws IOException {
        int x;
        int x2;
        if (list instanceof uc) {
            uc ucVar = (uc) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    ucVar.d(this.f3754a.n());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else if (i == 2) {
                int y = this.f3754a.y();
                W(y);
                int d2 = this.f3754a.d() + y;
                do {
                    ucVar.d(this.f3754a.n());
                } while (this.f3754a.d() < d2);
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f3754a.n()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else if (i2 == 2) {
                int y2 = this.f3754a.y();
                W(y2);
                int d3 = this.f3754a.d() + y2;
                do {
                    list.add(Long.valueOf(this.f3754a.n()));
                } while (this.f3754a.d() < d3);
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public <T> T J(rd<T> rdVar, cc ccVar) throws IOException {
        U(2);
        return (T) Q(rdVar, ccVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.qd
    public <K, V> void K(Map<K, V> map, wc.a<K, V> aVar, cc ccVar) throws IOException {
        U(2);
        int h = this.f3754a.h(this.f3754a.y());
        Object obj = aVar.b;
        Object obj2 = aVar.d;
        while (true) {
            try {
                int w = w();
                if (w == Integer.MAX_VALUE || this.f3754a.e()) {
                    map.put(obj, obj2);
                } else if (w == 1) {
                    obj = O(aVar.f3759a, null, null);
                } else if (w != 2) {
                    try {
                        if (!C()) {
                            throw new nc("Unable to parse map entry.");
                        }
                    } catch (nc.a unused) {
                        if (!C()) {
                            throw new nc("Unable to parse map entry.");
                        }
                    }
                } else {
                    obj2 = O(aVar.c, aVar.d.getClass(), ccVar);
                }
            } finally {
                this.f3754a.g(h);
            }
        }
        map.put(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.qd
    public <T> void L(List<T> list, rd<T> rdVar, cc ccVar) throws IOException {
        int x;
        int i = this.b;
        if ((i & 7) == 3) {
            do {
                list.add(P(rdVar, ccVar));
                if (!this.f3754a.e() && this.d == 0) {
                    x = this.f3754a.x();
                } else {
                    return;
                }
            } while (x == i);
            this.d = x;
            return;
        }
        throw nc.c();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.qd
    public <T> void M(List<T> list, rd<T> rdVar, cc ccVar) throws IOException {
        int x;
        int i = this.b;
        if ((i & 7) == 2) {
            do {
                list.add(Q(rdVar, ccVar));
                if (!this.f3754a.e() && this.d == 0) {
                    x = this.f3754a.x();
                } else {
                    return;
                }
            } while (x == i);
            this.d = x;
            return;
        }
        throw nc.c();
    }

    @Override // defpackage.qd
    public <T> T N(rd<T> rdVar, cc ccVar) throws IOException {
        U(3);
        return (T) P(rdVar, ccVar);
    }

    public final Object O(fe feVar, Class<?> cls, cc ccVar) throws IOException {
        switch (feVar.ordinal()) {
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
                return R(cls, ccVar);
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

    public final <T> T P(rd<T> rdVar, cc ccVar) throws IOException {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            T d2 = rdVar.d();
            rdVar.h(d2, this, ccVar);
            rdVar.e(d2);
            if (this.b == this.c) {
                return d2;
            }
            throw nc.f();
        } finally {
            this.c = i;
        }
    }

    public final <T> T Q(rd<T> rdVar, cc ccVar) throws IOException {
        int y = this.f3754a.y();
        vb vbVar = this.f3754a;
        if (vbVar.f3626a < vbVar.b) {
            int h = vbVar.h(y);
            T d2 = rdVar.d();
            this.f3754a.f3626a++;
            rdVar.h(d2, this, ccVar);
            rdVar.e(d2);
            this.f3754a.a(0);
            vb vbVar2 = this.f3754a;
            vbVar2.f3626a--;
            vbVar2.g(h);
            return d2;
        }
        throw new nc("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public <T> T R(Class<T> cls, cc ccVar) throws IOException {
        U(2);
        return (T) Q(nd.c.a(cls), ccVar);
    }

    public void S(List<String> list, boolean z) throws IOException {
        int x;
        int x2;
        if ((this.b & 7) != 2) {
            throw nc.c();
        } else if (!(list instanceof sc) || z) {
            do {
                list.add(z ? H() : v());
                if (!this.f3754a.e()) {
                    x = this.f3754a.x();
                } else {
                    return;
                }
            } while (x == this.b);
            this.d = x;
        } else {
            sc scVar = (sc) list;
            do {
                scVar.Z(z());
                if (!this.f3754a.e()) {
                    x2 = this.f3754a.x();
                } else {
                    return;
                }
            } while (x2 == this.b);
            this.d = x2;
        }
    }

    public final void T(int i) throws IOException {
        if (this.f3754a.d() != i) {
            throw nc.g();
        }
    }

    public final void U(int i) throws IOException {
        if ((this.b & 7) != i) {
            throw nc.c();
        }
    }

    public final void V(int i) throws IOException {
        if ((i & 3) != 0) {
            throw nc.f();
        }
    }

    public final void W(int i) throws IOException {
        if ((i & 7) != 0) {
            throw nc.f();
        }
    }

    @Override // defpackage.qd
    public int a() {
        return this.b;
    }

    @Override // defpackage.qd
    public void b(List<Integer> list) throws IOException {
        int x;
        int x2;
        if (list instanceof lc) {
            lc lcVar = (lc) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    lcVar.d(this.f3754a.t());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else if (i == 2) {
                int d2 = this.f3754a.d() + this.f3754a.y();
                do {
                    lcVar.d(this.f3754a.t());
                } while (this.f3754a.d() < d2);
                T(d2);
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3754a.t()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else if (i2 == 2) {
                int d3 = this.f3754a.d() + this.f3754a.y();
                do {
                    list.add(Integer.valueOf(this.f3754a.t()));
                } while (this.f3754a.d() < d3);
                T(d3);
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public long c() throws IOException {
        U(0);
        return this.f3754a.z();
    }

    @Override // defpackage.qd
    public long d() throws IOException {
        U(1);
        return this.f3754a.n();
    }

    @Override // defpackage.qd
    public void e(List<Integer> list) throws IOException {
        int x;
        int x2;
        if (list instanceof lc) {
            lc lcVar = (lc) list;
            int i = this.b & 7;
            if (i == 2) {
                int y = this.f3754a.y();
                V(y);
                int d2 = this.f3754a.d() + y;
                do {
                    lcVar.d(this.f3754a.r());
                } while (this.f3754a.d() < d2);
            } else if (i == 5) {
                do {
                    lcVar.d(this.f3754a.r());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 2) {
                int y2 = this.f3754a.y();
                V(y2);
                int d3 = this.f3754a.d() + y2;
                do {
                    list.add(Integer.valueOf(this.f3754a.r()));
                } while (this.f3754a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f3754a.r()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public void f(List<Long> list) throws IOException {
        int x;
        int x2;
        if (list instanceof uc) {
            uc ucVar = (uc) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    ucVar.d(this.f3754a.u());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else if (i == 2) {
                int d2 = this.f3754a.d() + this.f3754a.y();
                do {
                    ucVar.d(this.f3754a.u());
                } while (this.f3754a.d() < d2);
                T(d2);
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f3754a.u()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else if (i2 == 2) {
                int d3 = this.f3754a.d() + this.f3754a.y();
                do {
                    list.add(Long.valueOf(this.f3754a.u()));
                } while (this.f3754a.d() < d3);
                T(d3);
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public void g(List<Integer> list) throws IOException {
        int x;
        int x2;
        if (list instanceof lc) {
            lc lcVar = (lc) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    lcVar.d(this.f3754a.y());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else if (i == 2) {
                int d2 = this.f3754a.d() + this.f3754a.y();
                do {
                    lcVar.d(this.f3754a.y());
                } while (this.f3754a.d() < d2);
                T(d2);
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3754a.y()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else if (i2 == 2) {
                int d3 = this.f3754a.d() + this.f3754a.y();
                do {
                    list.add(Integer.valueOf(this.f3754a.y()));
                } while (this.f3754a.d() < d3);
                T(d3);
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public int h() throws IOException {
        U(5);
        return this.f3754a.m();
    }

    @Override // defpackage.qd
    public boolean i() throws IOException {
        U(0);
        return this.f3754a.i();
    }

    @Override // defpackage.qd
    public long j() throws IOException {
        U(1);
        return this.f3754a.s();
    }

    @Override // defpackage.qd
    public void k(List<Long> list) throws IOException {
        int x;
        int x2;
        if (list instanceof uc) {
            uc ucVar = (uc) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    ucVar.d(this.f3754a.z());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else if (i == 2) {
                int d2 = this.f3754a.d() + this.f3754a.y();
                do {
                    ucVar.d(this.f3754a.z());
                } while (this.f3754a.d() < d2);
                T(d2);
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f3754a.z()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else if (i2 == 2) {
                int d3 = this.f3754a.d() + this.f3754a.y();
                do {
                    list.add(Long.valueOf(this.f3754a.z()));
                } while (this.f3754a.d() < d3);
                T(d3);
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public int l() throws IOException {
        U(0);
        return this.f3754a.y();
    }

    @Override // defpackage.qd
    public void m(List<Long> list) throws IOException {
        int x;
        int x2;
        if (list instanceof uc) {
            uc ucVar = (uc) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    ucVar.d(this.f3754a.q());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else if (i == 2) {
                int d2 = this.f3754a.d() + this.f3754a.y();
                do {
                    ucVar.d(this.f3754a.q());
                } while (this.f3754a.d() < d2);
                T(d2);
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f3754a.q()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else if (i2 == 2) {
                int d3 = this.f3754a.d() + this.f3754a.y();
                do {
                    list.add(Long.valueOf(this.f3754a.q()));
                } while (this.f3754a.d() < d3);
                T(d3);
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public void n(List<Long> list) throws IOException {
        int x;
        int x2;
        if (list instanceof uc) {
            uc ucVar = (uc) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    ucVar.d(this.f3754a.s());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else if (i == 2) {
                int y = this.f3754a.y();
                W(y);
                int d2 = this.f3754a.d() + y;
                do {
                    ucVar.d(this.f3754a.s());
                } while (this.f3754a.d() < d2);
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f3754a.s()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else if (i2 == 2) {
                int y2 = this.f3754a.y();
                W(y2);
                int d3 = this.f3754a.d() + y2;
                do {
                    list.add(Long.valueOf(this.f3754a.s()));
                } while (this.f3754a.d() < d3);
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public void o(List<Integer> list) throws IOException {
        int x;
        int x2;
        if (list instanceof lc) {
            lc lcVar = (lc) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    lcVar.d(this.f3754a.p());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else if (i == 2) {
                int d2 = this.f3754a.d() + this.f3754a.y();
                do {
                    lcVar.d(this.f3754a.p());
                } while (this.f3754a.d() < d2);
                T(d2);
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3754a.p()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else if (i2 == 2) {
                int d3 = this.f3754a.d() + this.f3754a.y();
                do {
                    list.add(Integer.valueOf(this.f3754a.p()));
                } while (this.f3754a.d() < d3);
                T(d3);
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public void p(List<Integer> list) throws IOException {
        int x;
        int x2;
        if (list instanceof lc) {
            lc lcVar = (lc) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    lcVar.d(this.f3754a.l());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else if (i == 2) {
                int d2 = this.f3754a.d() + this.f3754a.y();
                do {
                    lcVar.d(this.f3754a.l());
                } while (this.f3754a.d() < d2);
                T(d2);
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3754a.l()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else if (i2 == 2) {
                int d3 = this.f3754a.d() + this.f3754a.y();
                do {
                    list.add(Integer.valueOf(this.f3754a.l()));
                } while (this.f3754a.d() < d3);
                T(d3);
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public int q() throws IOException {
        U(0);
        return this.f3754a.l();
    }

    @Override // defpackage.qd
    public void r(List<Integer> list) throws IOException {
        int x;
        int x2;
        if (list instanceof lc) {
            lc lcVar = (lc) list;
            int i = this.b & 7;
            if (i == 2) {
                int y = this.f3754a.y();
                V(y);
                int d2 = this.f3754a.d() + y;
                do {
                    lcVar.d(this.f3754a.m());
                } while (this.f3754a.d() < d2);
            } else if (i == 5) {
                do {
                    lcVar.d(this.f3754a.m());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 2) {
                int y2 = this.f3754a.y();
                V(y2);
                int d3 = this.f3754a.d() + y2;
                do {
                    list.add(Integer.valueOf(this.f3754a.m()));
                } while (this.f3754a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f3754a.m()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public double readDouble() throws IOException {
        U(1);
        return this.f3754a.k();
    }

    @Override // defpackage.qd
    public float readFloat() throws IOException {
        U(5);
        return this.f3754a.o();
    }

    @Override // defpackage.qd
    public int s() throws IOException {
        U(0);
        return this.f3754a.t();
    }

    @Override // defpackage.qd
    public long t() throws IOException {
        U(0);
        return this.f3754a.u();
    }

    @Override // defpackage.qd
    public void u(List<Boolean> list) throws IOException {
        int x;
        int x2;
        if (list instanceof rb) {
            rb rbVar = (rb) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    rbVar.d(this.f3754a.i());
                    if (!this.f3754a.e()) {
                        x2 = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x2 == this.b);
                this.d = x2;
            } else if (i == 2) {
                int d2 = this.f3754a.d() + this.f3754a.y();
                do {
                    rbVar.d(this.f3754a.i());
                } while (this.f3754a.d() < d2);
                T(d2);
            } else {
                throw nc.c();
            }
        } else {
            int i2 = this.b & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f3754a.i()));
                    if (!this.f3754a.e()) {
                        x = this.f3754a.x();
                    } else {
                        return;
                    }
                } while (x == this.b);
                this.d = x;
            } else if (i2 == 2) {
                int d3 = this.f3754a.d() + this.f3754a.y();
                do {
                    list.add(Boolean.valueOf(this.f3754a.i()));
                } while (this.f3754a.d() < d3);
                T(d3);
            } else {
                throw nc.c();
            }
        }
    }

    @Override // defpackage.qd
    public String v() throws IOException {
        U(2);
        return this.f3754a.v();
    }

    @Override // defpackage.qd
    public int w() throws IOException {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f3754a.x();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // defpackage.qd
    public void x(List<String> list) throws IOException {
        S(list, false);
    }

    @Override // defpackage.qd
    public void y(List<String> list) throws IOException {
        S(list, true);
    }

    @Override // defpackage.qd
    public ub z() throws IOException {
        U(2);
        return this.f3754a.j();
    }
}
