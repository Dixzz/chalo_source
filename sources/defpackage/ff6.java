package defpackage;

import defpackage.m66;

/* renamed from: ff6  reason: default package */
/* compiled from: SafeCollector.kt */
public final class ff6 implements m66.a {
    public static final a g = new a(null);
    public final Throwable f;

    /* renamed from: ff6$a */
    /* compiled from: SafeCollector.kt */
    public static final class a implements m66.b<ff6> {
        public a(j86 j86) {
        }
    }

    public ff6(Throwable th) {
        this.f = th;
    }

    @Override // defpackage.m66
    public <R> R fold(R r, w76<? super R, ? super m66.a, ? extends R> w76) {
        return (R) m66.a.C0044a.a(this, r, w76);
    }

    @Override // defpackage.m66.a, defpackage.m66
    public <E extends m66.a> E get(m66.b<E> bVar) {
        return (E) m66.a.C0044a.b(this, bVar);
    }

    @Override // defpackage.m66.a
    public m66.b<?> getKey() {
        return g;
    }

    @Override // defpackage.m66
    public m66 minusKey(m66.b<?> bVar) {
        return m66.a.C0044a.c(this, bVar);
    }

    @Override // defpackage.m66
    public m66 plus(m66 m66) {
        return m66.a.C0044a.d(this, m66);
    }
}
