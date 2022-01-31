package a;

import j$.util.function.F;
import java.util.function.LongUnaryOperator;

/* renamed from: a.w0 */
public final /* synthetic */ class C0117w0 implements F {

    /* renamed from: a */
    final /* synthetic */ LongUnaryOperator f92a;

    private /* synthetic */ C0117w0(LongUnaryOperator longUnaryOperator) {
        this.f92a = longUnaryOperator;
    }

    public static /* synthetic */ F c(LongUnaryOperator longUnaryOperator) {
        if (longUnaryOperator == null) {
            return null;
        }
        return longUnaryOperator instanceof C0119x0 ? ((C0119x0) longUnaryOperator).f94a : new C0117w0(longUnaryOperator);
    }

    @Override // j$.util.function.F
    public /* synthetic */ F a(F f) {
        return c(this.f92a.andThen(C0119x0.a(f)));
    }

    @Override // j$.util.function.F
    public /* synthetic */ long applyAsLong(long j) {
        return this.f92a.applyAsLong(j);
    }

    @Override // j$.util.function.F
    public /* synthetic */ F b(F f) {
        return c(this.f92a.compose(C0119x0.a(f)));
    }
}
