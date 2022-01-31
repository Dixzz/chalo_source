package a;

import j$.util.function.BiFunction;
import j$.util.function.Function;

/* renamed from: a.z */
public final /* synthetic */ class C0122z implements BiFunction {

    /* renamed from: a */
    final /* synthetic */ java.util.function.BiFunction f97a;

    private /* synthetic */ C0122z(java.util.function.BiFunction biFunction) {
        this.f97a = biFunction;
    }

    public static /* synthetic */ BiFunction b(java.util.function.BiFunction biFunction) {
        if (biFunction == null) {
            return null;
        }
        return biFunction instanceof A ? ((A) biFunction).f3a : new C0122z(biFunction);
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ BiFunction a(Function function) {
        return b(this.f97a.andThen(V.a(function)));
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.f97a.apply(obj, obj2);
    }
}
