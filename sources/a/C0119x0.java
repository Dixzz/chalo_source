package a;

import j$.util.function.F;
import java.util.function.LongUnaryOperator;

/* renamed from: a.x0 */
public final /* synthetic */ class C0119x0 implements LongUnaryOperator {

    /* renamed from: a */
    final /* synthetic */ F f94a;

    private /* synthetic */ C0119x0(F f) {
        this.f94a = f;
    }

    public static /* synthetic */ LongUnaryOperator a(F f) {
        if (f == null) {
            return null;
        }
        return f instanceof C0117w0 ? ((C0117w0) f).f92a : new C0119x0(f);
    }

    public /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
        return a(this.f94a.a(C0117w0.c(longUnaryOperator)));
    }

    public /* synthetic */ long applyAsLong(long j) {
        return this.f94a.applyAsLong(j);
    }

    public /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
        return a(this.f94a.b(C0117w0.c(longUnaryOperator)));
    }
}
