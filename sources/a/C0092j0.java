package a;

import j$.util.function.A;
import java.util.function.IntUnaryOperator;

/* renamed from: a.j0 */
public final /* synthetic */ class C0092j0 implements IntUnaryOperator {

    /* renamed from: a */
    final /* synthetic */ A f66a;

    private /* synthetic */ C0092j0(A a2) {
        this.f66a = a2;
    }

    public static /* synthetic */ IntUnaryOperator a(A a2) {
        if (a2 == null) {
            return null;
        }
        return a2 instanceof C0090i0 ? ((C0090i0) a2).f64a : new C0092j0(a2);
    }

    public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
        return a(C0090i0.b(((C0090i0) this.f66a).f64a.andThen(a(C0090i0.b(intUnaryOperator)))));
    }

    public /* synthetic */ int applyAsInt(int i) {
        return ((C0090i0) this.f66a).f64a.applyAsInt(i);
    }

    public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
        return a(C0090i0.b(((C0090i0) this.f66a).f64a.compose(a(C0090i0.b(intUnaryOperator)))));
    }
}
