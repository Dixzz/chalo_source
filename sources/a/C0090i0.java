package a;

import j$.util.function.A;
import java.util.function.IntUnaryOperator;

/* renamed from: a.i0 */
public final /* synthetic */ class C0090i0 implements A {

    /* renamed from: a */
    final /* synthetic */ IntUnaryOperator f64a;

    private /* synthetic */ C0090i0(IntUnaryOperator intUnaryOperator) {
        this.f64a = intUnaryOperator;
    }

    public static /* synthetic */ A b(IntUnaryOperator intUnaryOperator) {
        if (intUnaryOperator == null) {
            return null;
        }
        return intUnaryOperator instanceof C0092j0 ? ((C0092j0) intUnaryOperator).f66a : new C0090i0(intUnaryOperator);
    }

    public /* synthetic */ int a(int i) {
        return this.f64a.applyAsInt(i);
    }
}
