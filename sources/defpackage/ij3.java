package defpackage;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ij3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ij3<T> implements sj3<T> {

    /* renamed from: a  reason: collision with root package name */
    public final gj3 f1522a;
    public final gk3<?, ?> b;
    public final boolean c;
    public final kh3<?> d;

    public ij3(gk3<?, ?> gk3, kh3<?> kh3, gj3 gj3) {
        this.b = gk3;
        this.c = kh3.e(gj3);
        this.d = kh3;
        this.f1522a = gj3;
    }

    @Override // defpackage.sj3
    public final boolean b(T t, T t2) {
        if (!this.b.g(t).equals(this.b.g(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.c(t).equals(this.d.c(t2));
        }
        return true;
    }

    @Override // defpackage.sj3
    public final int c(T t) {
        int hashCode = this.b.g(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.c(t).hashCode() : hashCode;
    }

    @Override // defpackage.sj3
    public final void e(T t) {
        this.b.e(t);
        this.d.f(t);
    }

    @Override // defpackage.sj3
    public final void f(T t, T t2) {
        gk3<?, ?> gk3 = this.b;
        Class<?> cls = uj3.f3513a;
        gk3.c(t, gk3.d(gk3.g(t), gk3.g(t2)));
        if (this.c) {
            uj3.e(this.d, t, t2);
        }
    }

    @Override // defpackage.sj3
    public final boolean g(T t) {
        return this.d.c(t).a();
    }

    @Override // defpackage.sj3
    public final int h(T t) {
        gk3<?, ?> gk3 = this.b;
        int h = gk3.h(gk3.g(t)) + 0;
        if (!this.c) {
            return h;
        }
        ph3<?> c2 = this.d.c(t);
        int i = 0;
        for (int i2 = 0; i2 < c2.f2805a.f(); i2++) {
            i += ph3.l(c2.f2805a.d(i2));
        }
        for (Map.Entry<T, Object> entry : c2.f2805a.g()) {
            i += ph3.l(entry);
        }
        return h + i;
    }

    @Override // defpackage.sj3
    public final void i(T t, al3 al3) throws IOException {
        Iterator<Map.Entry<?, Object>> b2 = this.d.c(t).b();
        while (b2.hasNext()) {
            Map.Entry<?, Object> next = b2.next();
            rh3 rh3 = (rh3) next.getKey();
            if (rh3.B() != bl3.MESSAGE || rh3.H() || rh3.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof ii3) {
                ((jh3) al3).c(rh3.n(), ((ii3) next).f.getValue().a());
            } else {
                ((jh3) al3).c(rh3.n(), next.getValue());
            }
        }
        gk3<?, ?> gk3 = this.b;
        gk3.b(gk3.g(t), al3);
    }
}
