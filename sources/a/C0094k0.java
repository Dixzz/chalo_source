package a;

import j$.util.function.B;
import java.util.function.LongBinaryOperator;

/* renamed from: a.k0 */
public final /* synthetic */ class C0094k0 implements B {

    /* renamed from: a */
    final /* synthetic */ LongBinaryOperator f68a;

    private /* synthetic */ C0094k0(LongBinaryOperator longBinaryOperator) {
        this.f68a = longBinaryOperator;
    }

    public static /* synthetic */ B a(LongBinaryOperator longBinaryOperator) {
        if (longBinaryOperator == null) {
            return null;
        }
        return longBinaryOperator instanceof C0096l0 ? ((C0096l0) longBinaryOperator).f70a : new C0094k0(longBinaryOperator);
    }

    @Override // j$.util.function.B
    public /* synthetic */ long applyAsLong(long j, long j2) {
        return this.f68a.applyAsLong(j, j2);
    }
}
