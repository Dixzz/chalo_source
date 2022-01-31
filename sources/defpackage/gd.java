package defpackage;

import defpackage.gc;
import defpackage.kc;
import defpackage.pc;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: gd  reason: default package */
/* compiled from: MessageSetSchema */
public final class gd<T> implements rd<T> {

    /* renamed from: a  reason: collision with root package name */
    public final dd f1240a;
    public final yd<?, ?> b;
    public final boolean c;
    public final dc<?> d;

    public gd(yd<?, ?> ydVar, dc<?> dcVar, dd ddVar) {
        this.b = ydVar;
        this.c = dcVar.e(ddVar);
        this.d = dcVar;
        this.f1240a = ddVar;
    }

    @Override // defpackage.rd
    public void a(T t, T t2) {
        yd<?, ?> ydVar = this.b;
        Class<?> cls = td.f3335a;
        ydVar.o(t, ydVar.k(ydVar.g(t), ydVar.g(t2)));
        if (this.c) {
            td.A(this.d, t, t2);
        }
    }

    @Override // defpackage.rd
    public boolean b(T t, T t2) {
        if (!this.b.g(t).equals(this.b.g(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.c(t).equals(this.d.c(t2));
        }
        return true;
    }

    @Override // defpackage.rd
    public int c(T t) {
        int hashCode = this.b.g(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.c(t).hashCode() : hashCode;
    }

    @Override // defpackage.rd
    public T d() {
        return (T) ((kc.a) this.f1240a.newBuilderForType()).c();
    }

    @Override // defpackage.rd
    public void e(T t) {
        this.b.j(t);
        this.d.f(t);
    }

    @Override // defpackage.rd
    public final boolean f(T t) {
        return this.d.c(t).i();
    }

    @Override // defpackage.rd
    public int g(T t) {
        yd<?, ?> ydVar = this.b;
        int i = ydVar.i(ydVar.g(t)) + 0;
        if (!this.c) {
            return i;
        }
        gc<?> c2 = this.d.c(t);
        int i2 = 0;
        for (int i3 = 0; i3 < c2.f1237a.d(); i3++) {
            i2 += c2.g(c2.f1237a.c(i3));
        }
        for (Object obj : c2.f1237a.e()) {
            i2 += c2.g((Map.Entry) obj);
        }
        return i + i2;
    }

    @Override // defpackage.rd
    public void h(T t, qd qdVar, cc ccVar) throws IOException {
        yd<UT, UB> ydVar = (yd<UT, UB>) this.b;
        dc<ET> dcVar = (dc<ET>) this.d;
        UB f = ydVar.f(t);
        gc<ET> d2 = dcVar.d(t);
        do {
            try {
                if (qdVar.w() == Integer.MAX_VALUE) {
                    break;
                }
            } finally {
                ydVar.n(t, f);
            }
        } while (j(qdVar, ccVar, dcVar, d2, ydVar, f));
    }

    @Override // defpackage.rd
    public void i(T t, he heVar) throws IOException {
        Iterator<Map.Entry<?, Object>> k = this.d.c(t).k();
        while (k.hasNext()) {
            Map.Entry<?, Object> next = k.next();
            gc.a aVar = (gc.a) next.getKey();
            if (aVar.s() != ge.MESSAGE || aVar.b() || aVar.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof pc.b) {
                ((yb) heVar).e(aVar.getNumber(), ((pc.b) next).f.getValue().b());
            } else {
                ((yb) heVar).e(aVar.getNumber(), next.getValue());
            }
        }
        yd<?, ?> ydVar = this.b;
        ydVar.r(ydVar.g(t), heVar);
    }

    public final <UT, UB, ET extends gc.a<ET>> boolean j(qd qdVar, cc ccVar, dc<ET> dcVar, gc<ET> gcVar, yd<UT, UB> ydVar, UB ub) throws IOException {
        int a2 = qdVar.a();
        if (a2 == 11) {
            int i = 0;
            Object obj = null;
            ub ubVar = null;
            while (qdVar.w() != Integer.MAX_VALUE) {
                int a3 = qdVar.a();
                if (a3 == 16) {
                    i = qdVar.l();
                    obj = dcVar.b(ccVar, this.f1240a, i);
                } else if (a3 == 26) {
                    if (obj != null) {
                        dcVar.h(qdVar, obj, ccVar, gcVar);
                    } else {
                        ubVar = qdVar.z();
                    }
                } else if (!qdVar.C()) {
                    break;
                }
            }
            if (qdVar.a() == 12) {
                if (ubVar != null) {
                    if (obj != null) {
                        dcVar.i(ubVar, obj, ccVar, gcVar);
                    } else {
                        ydVar.d(ub, i, ubVar);
                    }
                }
                return true;
            }
            throw nc.a();
        } else if ((a2 & 7) != 2) {
            return qdVar.C();
        } else {
            Object b2 = dcVar.b(ccVar, this.f1240a, a2 >>> 3);
            if (b2 == null) {
                return ydVar.l(ub, qdVar);
            }
            dcVar.h(qdVar, b2, ccVar, gcVar);
            return true;
        }
    }
}
