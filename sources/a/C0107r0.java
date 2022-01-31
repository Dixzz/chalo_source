package a;

import j$.util.function.E;
import java.util.function.LongPredicate;

/* renamed from: a.r0 */
public final /* synthetic */ class C0107r0 implements LongPredicate {

    /* renamed from: a */
    final /* synthetic */ E f82a;

    private /* synthetic */ C0107r0(E e) {
        this.f82a = e;
    }

    public static /* synthetic */ LongPredicate a(E e) {
        if (e == null) {
            return null;
        }
        return e instanceof C0106q0 ? ((C0106q0) e).f80a : new C0107r0(e);
    }

    public /* synthetic */ LongPredicate and(LongPredicate longPredicate) {
        return a(C0106q0.a(((C0106q0) this.f82a).f80a.and(a(C0106q0.a(longPredicate)))));
    }

    public /* synthetic */ LongPredicate negate() {
        return a(C0106q0.a(((C0106q0) this.f82a).f80a.negate()));
    }

    public /* synthetic */ LongPredicate or(LongPredicate longPredicate) {
        return a(C0106q0.a(((C0106q0) this.f82a).f80a.or(a(C0106q0.a(longPredicate)))));
    }

    public /* synthetic */ boolean test(long j) {
        return ((C0106q0) this.f82a).f80a.test(j);
    }
}
