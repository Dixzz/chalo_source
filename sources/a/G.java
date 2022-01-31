package a;

import j$.util.function.p;
import java.util.function.DoubleBinaryOperator;

public final /* synthetic */ class G implements DoubleBinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f15a;

    private /* synthetic */ G(p pVar) {
        this.f15a = pVar;
    }

    public static /* synthetic */ DoubleBinaryOperator a(p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar instanceof F ? ((F) pVar).f13a : new G(pVar);
    }

    public /* synthetic */ double applyAsDouble(double d, double d2) {
        return this.f15a.applyAsDouble(d, d2);
    }
}
