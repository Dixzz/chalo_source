package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.m66;

/* renamed from: h66  reason: default package */
/* compiled from: CoroutineContextImpl.kt */
public abstract class h66 implements m66.a {
    private final m66.b<?> key;

    public h66(m66.b<?> bVar) {
        n86.e(bVar, AnalyticsConstants.KEY);
        this.key = bVar;
    }

    @Override // defpackage.m66
    public <R> R fold(R r, w76<? super R, ? super m66.a, ? extends R> w76) {
        n86.e(w76, "operation");
        return (R) m66.a.C0044a.a(this, r, w76);
    }

    @Override // defpackage.m66.a, defpackage.m66
    public <E extends m66.a> E get(m66.b<E> bVar) {
        n86.e(bVar, AnalyticsConstants.KEY);
        return (E) m66.a.C0044a.b(this, bVar);
    }

    @Override // defpackage.m66.a
    public m66.b<?> getKey() {
        return this.key;
    }

    @Override // defpackage.m66
    public m66 minusKey(m66.b<?> bVar) {
        n86.e(bVar, AnalyticsConstants.KEY);
        return m66.a.C0044a.c(this, bVar);
    }

    @Override // defpackage.m66
    public m66 plus(m66 m66) {
        n86.e(m66, AnalyticsConstants.CONTEXT);
        return m66.a.C0044a.d(this, m66);
    }
}
