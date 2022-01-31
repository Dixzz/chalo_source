package a;

import java.util.function.BiFunction;
import java.util.function.Function;

public final /* synthetic */ class A implements BiFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j$.util.function.BiFunction f3a;

    private /* synthetic */ A(j$.util.function.BiFunction biFunction) {
        this.f3a = biFunction;
    }

    public static /* synthetic */ BiFunction a(j$.util.function.BiFunction biFunction) {
        if (biFunction == null) {
            return null;
        }
        return biFunction instanceof C0122z ? ((C0122z) biFunction).f97a : new A(biFunction);
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return a(this.f3a.a(U.c(function)));
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.f3a.apply(obj, obj2);
    }
}
