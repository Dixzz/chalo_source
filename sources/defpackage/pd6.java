package defpackage;

import defpackage.m66;

/* renamed from: pd6  reason: default package */
/* compiled from: CoroutineContext.kt */
public final class pd6 implements m66.a, m66.b<pd6> {
    public static final pd6 f = new pd6();

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
        return this;
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
