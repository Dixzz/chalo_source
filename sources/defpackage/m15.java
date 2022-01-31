package defpackage;

import defpackage.m05;
import defpackage.q05;
import defpackage.v05;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: m15  reason: default package */
/* compiled from: MessageSetSchema */
public final class m15<T> implements x15<T> {

    /* renamed from: a  reason: collision with root package name */
    public final j15 f2308a;
    public final e25<?, ?> b;
    public final boolean c;
    public final j05<?> d;

    public m15(e25<?, ?> e25, j05<?> j05, j15 j15) {
        this.b = e25;
        this.c = j05.e(j15);
        this.d = j05;
        this.f2308a = j15;
    }

    @Override // defpackage.x15
    public void a(T t, T t2) {
        e25<?, ?> e25 = this.b;
        Class<?> cls = z15.f4109a;
        e25.o(t, e25.k(e25.g(t), e25.g(t2)));
        if (this.c) {
            z15.B(this.d, t, t2);
        }
    }

    @Override // defpackage.x15
    public boolean b(T t, T t2) {
        if (!this.b.g(t).equals(this.b.g(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.c(t).equals(this.d.c(t2));
        }
        return true;
    }

    @Override // defpackage.x15
    public int c(T t) {
        int hashCode = this.b.g(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.c(t).hashCode() : hashCode;
    }

    @Override // defpackage.x15
    public T d() {
        return (T) this.f2308a.newBuilderForType().buildPartial();
    }

    @Override // defpackage.x15
    public void e(T t) {
        this.b.j(t);
        this.d.f(t);
    }

    @Override // defpackage.x15
    public final boolean f(T t) {
        return this.d.c(t).j();
    }

    @Override // defpackage.x15
    public int g(T t) {
        e25<?, ?> e25 = this.b;
        int i = e25.i(e25.g(t)) + 0;
        if (!this.c) {
            return i;
        }
        m05<?> c2 = this.d.c(t);
        int i2 = 0;
        for (int i3 = 0; i3 < c2.f2304a.d(); i3++) {
            i2 += c2.h(c2.f2304a.c(i3));
        }
        for (Object obj : c2.f2304a.e()) {
            i2 += c2.h((Map.Entry) obj);
        }
        return i + i2;
    }

    @Override // defpackage.x15
    public void h(T t, n25 n25) throws IOException {
        Iterator<Map.Entry<?, Object>> l = this.d.c(t).l();
        while (l.hasNext()) {
            Map.Entry<?, Object> next = l.next();
            m05.a aVar = (m05.a) next.getKey();
            if (aVar.s() != m25.MESSAGE || aVar.b() || aVar.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof v05.b) {
                ((e05) n25).e(aVar.getNumber(), ((v05.b) next).f.getValue().b());
            } else {
                ((e05) n25).e(aVar.getNumber(), next.getValue());
            }
        }
        e25<?, ?> e25 = this.b;
        e25.r(e25.g(t), n25);
    }

    @Override // defpackage.x15
    public void i(T t, w15 w15, i05 i05) throws IOException {
        e25<UT, UB> e25 = (e25<UT, UB>) this.b;
        j05<ET> j05 = (j05<ET>) this.d;
        UB f = e25.f(t);
        m05<ET> d2 = j05.d(t);
        do {
            try {
                if (w15.w() == Integer.MAX_VALUE) {
                    break;
                }
            } finally {
                e25.n(t, f);
            }
        } while (k(w15, i05, j05, d2, e25, f));
    }

    @Override // defpackage.x15
    public void j(T t, byte[] bArr, int i, int i2, vz4 vz4) throws IOException {
        T t2 = t;
        f25 f25 = t2.unknownFields;
        if (f25 == f25.f) {
            f25 = f25.e();
            t2.unknownFields = f25;
        }
        m05<q05.d> a2 = t.a();
        q05.e eVar = null;
        while (i < i2) {
            int z0 = hd3.z0(bArr, i, vz4);
            int i3 = vz4.f3697a;
            if (i3 == 11) {
                int i4 = 0;
                a05 a05 = null;
                while (z0 < i2) {
                    z0 = hd3.z0(bArr, z0, vz4);
                    int i5 = vz4.f3697a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (eVar != null) {
                                z0 = hd3.k0(t15.c.a(eVar.c.getClass()), bArr, z0, i2, vz4);
                                a2.o(eVar.d, vz4.c);
                            } else if (i7 == 2) {
                                z0 = hd3.f0(bArr, z0, vz4);
                                a05 = (a05) vz4.c;
                            }
                        }
                    } else if (i7 == 0) {
                        z0 = hd3.z0(bArr, z0, vz4);
                        i4 = vz4.f3697a;
                        eVar = (q05.e) this.d.b(vz4.d, this.f2308a, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    z0 = hd3.S2(i5, bArr, z0, i2, vz4);
                }
                if (a05 != null) {
                    f25.f((i4 << 3) | 2, a05);
                }
                i = z0;
            } else if ((i3 & 7) == 2) {
                q05.e eVar2 = (q05.e) this.d.b(vz4.d, this.f2308a, i3 >>> 3);
                if (eVar2 != null) {
                    i = hd3.k0(t15.c.a(eVar2.c.getClass()), bArr, z0, i2, vz4);
                    a2.o(eVar2.d, vz4.c);
                } else {
                    i = hd3.x0(i3, bArr, z0, i2, f25, vz4);
                }
                eVar = eVar2;
            } else {
                i = hd3.S2(i3, bArr, z0, i2, vz4);
            }
        }
        if (i != i2) {
            throw t05.g();
        }
    }

    public final <UT, UB, ET extends m05.a<ET>> boolean k(w15 w15, i05 i05, j05<ET> j05, m05<ET> m05, e25<UT, UB> e25, UB ub) throws IOException {
        int a2 = w15.a();
        if (a2 == 11) {
            int i = 0;
            Object obj = null;
            a05 a05 = null;
            while (w15.w() != Integer.MAX_VALUE) {
                int a3 = w15.a();
                if (a3 == 16) {
                    i = w15.l();
                    obj = j05.b(i05, this.f2308a, i);
                } else if (a3 == 26) {
                    if (obj != null) {
                        j05.h(w15, obj, i05, m05);
                    } else {
                        a05 = w15.z();
                    }
                } else if (!w15.C()) {
                    break;
                }
            }
            if (w15.a() == 12) {
                if (a05 != null) {
                    if (obj != null) {
                        j05.i(a05, obj, i05, m05);
                    } else {
                        e25.d(ub, i, a05);
                    }
                }
                return true;
            }
            throw t05.a();
        } else if ((a2 & 7) != 2) {
            return w15.C();
        } else {
            Object b2 = j05.b(i05, this.f2308a, a2 >>> 3);
            if (b2 == null) {
                return e25.l(ub, w15);
            }
            j05.h(w15, b2, i05, m05);
            return true;
        }
    }
}
