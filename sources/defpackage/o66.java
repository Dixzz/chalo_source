package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.m66;
import java.io.Serializable;

/* renamed from: o66  reason: default package */
/* compiled from: CoroutineContextImpl.kt */
public final class o66 implements m66, Serializable {
    public static final o66 f = new o66();

    @Override // defpackage.m66
    public <R> R fold(R r, w76<? super R, ? super m66.a, ? extends R> w76) {
        n86.e(w76, "operation");
        return r;
    }

    @Override // defpackage.m66
    public <E extends m66.a> E get(m66.b<E> bVar) {
        n86.e(bVar, AnalyticsConstants.KEY);
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // defpackage.m66
    public m66 minusKey(m66.b<?> bVar) {
        n86.e(bVar, AnalyticsConstants.KEY);
        return this;
    }

    @Override // defpackage.m66
    public m66 plus(m66 m66) {
        n86.e(m66, AnalyticsConstants.CONTEXT);
        return m66;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
