package a;

import j$.util.function.r;
import java.util.function.DoubleFunction;

public final /* synthetic */ class K implements DoubleFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f23a;

    private /* synthetic */ K(r rVar) {
        this.f23a = rVar;
    }

    public static /* synthetic */ DoubleFunction a(r rVar) {
        if (rVar == null) {
            return null;
        }
        return rVar instanceof J ? ((J) rVar).f21a : new K(rVar);
    }

    @Override // java.util.function.DoubleFunction
    public /* synthetic */ Object apply(double d) {
        return this.f23a.apply(d);
    }
}
