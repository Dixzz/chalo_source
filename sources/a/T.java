package a;

import j$.util.function.u;
import java.util.function.DoubleUnaryOperator;

public final /* synthetic */ class T implements DoubleUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f40a;

    private /* synthetic */ T(u uVar) {
        this.f40a = uVar;
    }

    public static /* synthetic */ DoubleUnaryOperator a(u uVar) {
        if (uVar == null) {
            return null;
        }
        return uVar instanceof S ? ((S) uVar).f38a : new T(uVar);
    }

    public /* synthetic */ DoubleUnaryOperator andThen(DoubleUnaryOperator doubleUnaryOperator) {
        return a(S.b(((S) this.f40a).f38a.andThen(a(S.b(doubleUnaryOperator)))));
    }

    public /* synthetic */ double applyAsDouble(double d) {
        return ((S) this.f40a).f38a.applyAsDouble(d);
    }

    public /* synthetic */ DoubleUnaryOperator compose(DoubleUnaryOperator doubleUnaryOperator) {
        return a(S.b(((S) this.f40a).f38a.compose(a(S.b(doubleUnaryOperator)))));
    }
}
