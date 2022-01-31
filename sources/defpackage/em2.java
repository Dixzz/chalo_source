package defpackage;

import java.io.IOException;

/* renamed from: em2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class em2<T> implements mm2<T> {

    /* renamed from: a  reason: collision with root package name */
    public final bm2 f993a;
    public final zm2<?, ?> b;
    public final boolean c;
    public final t93<?> d;

    public em2(zm2<?, ?> zm2, t93<?> t93, bm2 bm2) {
        this.b = zm2;
        this.c = t93.a(bm2);
        this.d = t93;
        this.f993a = bm2;
    }

    @Override // defpackage.mm2
    public final int a(T t) {
        int hashCode = this.b.j(t).hashCode();
        if (!this.c) {
            return hashCode;
        }
        this.d.b(t);
        throw null;
    }

    @Override // defpackage.mm2
    public final boolean b(T t, T t2) {
        if (!this.b.j(t).equals(this.b.j(t2))) {
            return false;
        }
        if (!this.c) {
            return true;
        }
        this.d.b(t);
        this.d.b(t2);
        throw null;
    }

    @Override // defpackage.mm2
    public final boolean c(T t) {
        this.d.b(t);
        throw null;
    }

    @Override // defpackage.mm2
    public final void d(T t) {
        this.b.m(t);
        this.d.d(t);
    }

    @Override // defpackage.mm2
    public final int f(T t) {
        zm2<?, ?> zm2 = this.b;
        int p = zm2.p(zm2.j(t));
        if (!this.c) {
            return p;
        }
        this.d.b(t);
        throw null;
    }

    @Override // defpackage.mm2
    public final void g(T t, byte[] bArr, int i, int i2, v83 v83) throws IOException {
        T t2 = t;
        if (t2.zzc == an2.f) {
            t2.zzc = an2.a();
        }
        throw null;
    }

    @Override // defpackage.mm2
    public final void h(T t, T t2) {
        zm2<?, ?> zm2 = this.b;
        Class<?> cls = om2.f2710a;
        zm2.i(t, zm2.o(zm2.j(t), zm2.j(t2)));
        if (this.c) {
            this.d.b(t2);
            throw null;
        }
    }

    @Override // defpackage.mm2
    public final void i(T t, o93 o93) throws IOException {
        this.d.b(t);
        throw null;
    }

    @Override // defpackage.mm2
    public final void j(T t, i93 i93, s93 s93) throws IOException {
        boolean z;
        zm2<?, ?> zm2 = this.b;
        t93<?> t93 = this.d;
        Object k = zm2.k(t);
        x93<?> c2 = t93.c(t);
        while (i93.v() != Integer.MAX_VALUE) {
            try {
                int i = i93.b;
                if (i != 11) {
                    if ((i & 7) == 2) {
                        Object f = t93.f(s93, this.f993a, i >>> 3);
                        if (f != null) {
                            t93.g(i93, f, s93, c2);
                        } else {
                            z = zm2.n(k, i93);
                        }
                    } else {
                        z = i93.w();
                    }
                    if (!z) {
                        return;
                    }
                } else {
                    int i2 = 0;
                    Object obj = null;
                    g93 g93 = null;
                    while (i93.v() != Integer.MAX_VALUE) {
                        int i3 = i93.b;
                        if (i3 == 16) {
                            i2 = i93.K();
                            obj = t93.f(s93, this.f993a, i2);
                        } else if (i3 == 26) {
                            if (obj != null) {
                                t93.g(i93, obj, s93, c2);
                            } else {
                                g93 = i93.J();
                            }
                        } else if (!i93.w()) {
                            break;
                        }
                    }
                    if (i93.b != 12) {
                        throw ma3.e();
                    } else if (g93 != null) {
                        if (obj != null) {
                            t93.h(g93, obj, s93, c2);
                        } else {
                            zm2.e(k, i2, g93);
                        }
                    }
                }
            } finally {
                zm2.l(t, k);
            }
        }
        zm2.l(t, k);
    }

    @Override // defpackage.mm2
    public final T zza() {
        return (T) ((ba3) this.f993a.m()).b();
    }
}
