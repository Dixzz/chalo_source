package a;

import java.util.function.Function;

public final /* synthetic */ class V implements Function {

    /* renamed from: a */
    final /* synthetic */ j$.util.function.Function f44a;

    private /* synthetic */ V(j$.util.function.Function function) {
        this.f44a = function;
    }

    public static /* synthetic */ Function a(j$.util.function.Function function) {
        if (function == null) {
            return null;
        }
        return function instanceof U ? ((U) function).f42a : new V(function);
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return a(this.f44a.a(U.c(function)));
    }

    @Override // java.util.function.Function
    public /* synthetic */ Object apply(Object obj) {
        return this.f44a.apply(obj);
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        return a(this.f44a.b(U.c(function)));
    }
}
