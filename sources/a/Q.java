package a;

import j$.util.function.t;
import java.util.function.DoubleToLongFunction;

public final /* synthetic */ class Q implements DoubleToLongFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f35a;

    private /* synthetic */ Q(t tVar) {
        this.f35a = tVar;
    }

    public static /* synthetic */ DoubleToLongFunction a(t tVar) {
        if (tVar == null) {
            return null;
        }
        return tVar instanceof P ? ((P) tVar).f33a : new Q(tVar);
    }

    public /* synthetic */ long applyAsLong(double d) {
        return this.f35a.applyAsLong(d);
    }
}
