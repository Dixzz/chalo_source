package a;

import j$.util.function.p;
import java.util.function.DoubleBinaryOperator;

public final /* synthetic */ class F implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleBinaryOperator f13a;

    private /* synthetic */ F(DoubleBinaryOperator doubleBinaryOperator) {
        this.f13a = doubleBinaryOperator;
    }

    public static /* synthetic */ p a(DoubleBinaryOperator doubleBinaryOperator) {
        if (doubleBinaryOperator == null) {
            return null;
        }
        return doubleBinaryOperator instanceof G ? ((G) doubleBinaryOperator).f15a : new F(doubleBinaryOperator);
    }

    @Override // j$.util.function.p
    public /* synthetic */ double applyAsDouble(double d, double d2) {
        return this.f13a.applyAsDouble(d, d2);
    }
}
