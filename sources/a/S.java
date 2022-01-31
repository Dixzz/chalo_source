package a;

import j$.util.function.u;
import java.util.function.DoubleUnaryOperator;

public final /* synthetic */ class S implements u {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleUnaryOperator f38a;

    private /* synthetic */ S(DoubleUnaryOperator doubleUnaryOperator) {
        this.f38a = doubleUnaryOperator;
    }

    public static /* synthetic */ u b(DoubleUnaryOperator doubleUnaryOperator) {
        if (doubleUnaryOperator == null) {
            return null;
        }
        return doubleUnaryOperator instanceof T ? ((T) doubleUnaryOperator).f40a : new S(doubleUnaryOperator);
    }

    public /* synthetic */ double a(double d) {
        return this.f38a.applyAsDouble(d);
    }
}
