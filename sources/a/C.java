package a;

import j$.util.function.n;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public final /* synthetic */ class C implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f7a;

    private /* synthetic */ C(n nVar) {
        this.f7a = nVar;
    }

    public static /* synthetic */ BinaryOperator a(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar instanceof B ? ((B) nVar).f5a : new C(nVar);
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return A.a(this.f7a.a(U.c(function)));
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.f7a.apply(obj, obj2);
    }
}
