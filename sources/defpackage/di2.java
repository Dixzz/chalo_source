package defpackage;

import defpackage.ug2;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: di2  reason: default package */
public final class di2<T> implements pi2<T> {

    /* renamed from: a  reason: collision with root package name */
    public final zh2 f840a;
    public final dj2<?, ?> b;
    public final boolean c;
    public final hg2<?> d;

    public di2(dj2<?, ?> dj2, hg2<?> hg2, zh2 zh2) {
        this.b = dj2;
        this.c = hg2.f(zh2);
        this.d = hg2;
        this.f840a = zh2;
    }

    @Override // defpackage.pi2
    public final void a(T t) {
        this.b.c(t);
        this.d.e(t);
    }

    @Override // defpackage.pi2
    public final boolean b(T t, T t2) {
        if (!this.b.i(t).equals(this.b.i(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.b(t).equals(this.d.b(t2));
        }
        return true;
    }

    @Override // defpackage.pi2
    public final int c(T t) {
        int hashCode = this.b.i(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.b(t).hashCode() : hashCode;
    }

    @Override // defpackage.pi2
    public final T d() {
        return (T) ((ug2.a) this.f840a.d()).i();
    }

    @Override // defpackage.pi2
    public final void f(T t, T t2) {
        dj2<?, ?> dj2 = this.b;
        Class<?> cls = ri2.f3084a;
        dj2.f(t, dj2.g(dj2.i(t), dj2.i(t2)));
        if (this.c) {
            ri2.e(this.d, t, t2);
        }
    }

    @Override // defpackage.pi2
    public final int g(T t) {
        dj2<?, ?> dj2 = this.b;
        int j = dj2.j(dj2.i(t)) + 0;
        if (!this.c) {
            return j;
        }
        lg2<?> b2 = this.d.b(t);
        int i = 0;
        for (int i2 = 0; i2 < b2.f2212a.e(); i2++) {
            i += lg2.k(b2.f2212a.c(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : b2.f2212a.f()) {
            i += lg2.k(entry);
        }
        return j + i;
    }

    @Override // defpackage.pi2
    public final void h(T t, xj2 xj2) throws IOException {
        Iterator<Map.Entry<?, Object>> c2 = this.d.b(t).c();
        while (c2.hasNext()) {
            Map.Entry<?, Object> next = c2.next();
            og2 og2 = (og2) next.getKey();
            if (og2.z() != wj2.MESSAGE || og2.G() || og2.v()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            ((dg2) xj2).c(og2.zzc(), next instanceof fh2 ? ((fh2) next).f.getValue().c() : next.getValue());
        }
        dj2<?, ?> dj2 = this.b;
        dj2.d(dj2.i(t), xj2);
    }

    @Override // defpackage.pi2
    public final void i(T t, byte[] bArr, int i, int i2, qf2 qf2) throws IOException {
        int i3;
        T t2 = t;
        ej2 ej2 = t2.zzjp;
        if (ej2 == ej2.f) {
            ej2 = ej2.e();
            t2.zzjp = ej2;
        }
        while (i < i2) {
            int L0 = gj1.L0(bArr, i, qf2);
            int i4 = qf2.f2938a;
            if (i4 != 11) {
                i = (i4 & 7) == 2 ? gj1.I0(i4, bArr, L0, i2, ej2, qf2) : gj1.G0(i4, bArr, L0, i2, qf2);
            } else {
                int i5 = 0;
                uf2 uf2 = null;
                while (true) {
                    if (L0 >= i2) {
                        i3 = L0;
                        break;
                    }
                    i3 = gj1.L0(bArr, L0, qf2);
                    int i6 = qf2.f2938a;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 != 2) {
                        if (i7 == 3 && i8 == 2) {
                            L0 = gj1.T1(bArr, i3, qf2);
                            uf2 = (uf2) qf2.c;
                        }
                    } else if (i8 == 0) {
                        L0 = gj1.L0(bArr, i3, qf2);
                        i5 = qf2.f2938a;
                    }
                    if (i6 == 12) {
                        break;
                    }
                    L0 = gj1.G0(i6, bArr, i3, i2, qf2);
                }
                if (uf2 != null) {
                    ej2.b((i5 << 3) | 2, uf2);
                }
                i = i3;
            }
        }
        if (i != i2) {
            throw ah2.c();
        }
    }

    @Override // defpackage.pi2
    public final boolean j(T t) {
        return this.d.b(t).b();
    }
}
