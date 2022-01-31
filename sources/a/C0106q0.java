package a;

import j$.util.function.E;
import java.util.function.LongPredicate;

/* renamed from: a.q0 */
public final /* synthetic */ class C0106q0 implements E {

    /* renamed from: a */
    final /* synthetic */ LongPredicate f80a;

    private /* synthetic */ C0106q0(LongPredicate longPredicate) {
        this.f80a = longPredicate;
    }

    public static /* synthetic */ E a(LongPredicate longPredicate) {
        if (longPredicate == null) {
            return null;
        }
        return longPredicate instanceof C0107r0 ? ((C0107r0) longPredicate).f82a : new C0106q0(longPredicate);
    }

    public /* synthetic */ boolean b(long j) {
        return this.f80a.test(j);
    }
}
