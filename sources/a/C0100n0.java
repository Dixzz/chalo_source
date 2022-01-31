package a;

import j$.util.function.C;
import java.util.function.LongConsumer;

/* renamed from: a.n0 */
public final /* synthetic */ class C0100n0 implements LongConsumer {

    /* renamed from: a */
    final /* synthetic */ C f74a;

    private /* synthetic */ C0100n0(C c) {
        this.f74a = c;
    }

    public static /* synthetic */ LongConsumer a(C c) {
        if (c == null) {
            return null;
        }
        return c instanceof C0098m0 ? ((C0098m0) c).f72a : new C0100n0(c);
    }

    public /* synthetic */ void accept(long j) {
        this.f74a.accept(j);
    }

    public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a(this.f74a.g(C0098m0.b(longConsumer)));
    }
}
