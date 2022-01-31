package defpackage;

import com.razorpay.AnalyticsConstants;

/* renamed from: m66  reason: default package */
/* compiled from: CoroutineContext.kt */
public interface m66 {

    /* renamed from: m66$a */
    /* compiled from: CoroutineContext.kt */
    public interface a extends m66 {

        /* renamed from: m66$a$a  reason: collision with other inner class name */
        /* compiled from: CoroutineContext.kt */
        public static final class C0044a {
            public static <R> R a(a aVar, R r, w76<? super R, ? super a, ? extends R> w76) {
                n86.e(w76, "operation");
                return (R) w76.invoke(r, aVar);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: m66$a */
            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends a> E b(a aVar, b<E> bVar) {
                n86.e(bVar, AnalyticsConstants.KEY);
                if (n86.a(aVar.getKey(), bVar)) {
                    return aVar;
                }
                return null;
            }

            public static m66 c(a aVar, b<?> bVar) {
                n86.e(bVar, AnalyticsConstants.KEY);
                return n86.a(aVar.getKey(), bVar) ? o66.f : aVar;
            }

            public static m66 d(a aVar, m66 m66) {
                n86.e(m66, AnalyticsConstants.CONTEXT);
                n86.e(m66, AnalyticsConstants.CONTEXT);
                return m66 == o66.f ? aVar : (m66) m66.fold(aVar, n66.f);
            }
        }

        @Override // defpackage.m66
        <E extends a> E get(b<E> bVar);

        b<?> getKey();
    }

    /* renamed from: m66$b */
    /* compiled from: CoroutineContext.kt */
    public interface b<E extends a> {
    }

    <R> R fold(R r, w76<? super R, ? super a, ? extends R> w76);

    <E extends a> E get(b<E> bVar);

    m66 minusKey(b<?> bVar);

    m66 plus(m66 m66);
}
