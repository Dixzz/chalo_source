package a;

import j$.util.function.C;
import java.util.function.LongConsumer;

/* renamed from: a.m0 */
public final /* synthetic */ class C0098m0 implements C {

    /* renamed from: a */
    final /* synthetic */ LongConsumer f72a;

    private /* synthetic */ C0098m0(LongConsumer longConsumer) {
        this.f72a = longConsumer;
    }

    public static /* synthetic */ C b(LongConsumer longConsumer) {
        if (longConsumer == null) {
            return null;
        }
        return longConsumer instanceof C0100n0 ? ((C0100n0) longConsumer).f74a : new C0098m0(longConsumer);
    }

    @Override // j$.util.function.C
    public /* synthetic */ void accept(long j) {
        this.f72a.accept(j);
    }

    @Override // j$.util.function.C
    public /* synthetic */ C g(C c) {
        return b(this.f72a.andThen(C0100n0.a(c)));
    }
}
