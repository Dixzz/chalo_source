package defpackage;

import defpackage.mt;
import java.util.Objects;

/* renamed from: ot  reason: default package */
/* compiled from: SettableFuture */
public final class ot<V> extends mt<V> {
    public boolean j(V v) {
        if (v == null) {
            v = (V) mt.l;
        }
        if (!mt.k.b(this, null, v)) {
            return false;
        }
        mt.b(this);
        return true;
    }

    public boolean k(Throwable th) {
        Objects.requireNonNull(th);
        if (!mt.k.b(this, null, new mt.d(th))) {
            return false;
        }
        mt.b(this);
        return true;
    }

    public boolean l(gy4<? extends V> gy4) {
        mt.g gVar;
        mt.d dVar;
        Objects.requireNonNull(gy4);
        Object obj = this.f;
        if (obj == null) {
            if (gy4.isDone()) {
                if (!mt.k.b(this, null, mt.f(gy4))) {
                    return false;
                }
                mt.b(this);
            } else {
                gVar = new mt.g(this, gy4);
                if (mt.k.b(this, null, gVar)) {
                    try {
                        gy4.c(gVar, nt.INSTANCE);
                    } catch (Throwable unused) {
                        dVar = mt.d.b;
                    }
                } else {
                    obj = this.f;
                }
            }
            return true;
        }
        if (!(obj instanceof mt.c)) {
            return false;
        }
        gy4.cancel(((mt.c) obj).f2433a);
        return false;
        mt.k.b(this, gVar, dVar);
        return true;
    }
}
