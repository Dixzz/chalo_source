package a;

import j$.util.function.Function;

public final /* synthetic */ class U implements Function {

    /* renamed from: a */
    final /* synthetic */ java.util.function.Function f42a;

    private /* synthetic */ U(java.util.function.Function function) {
        this.f42a = function;
    }

    public static /* synthetic */ Function c(java.util.function.Function function) {
        if (function == null) {
            return null;
        }
        return function instanceof V ? ((V) function).f44a : new U(function);
    }

    @Override // j$.util.function.Function
    public /* synthetic */ Function a(Function function) {
        return c(this.f42a.andThen(V.a(function)));
    }

    @Override // j$.util.function.Function
    public /* synthetic */ Object apply(Object obj) {
        return this.f42a.apply(obj);
    }

    @Override // j$.util.function.Function
    public /* synthetic */ Function b(Function function) {
        return c(this.f42a.compose(V.a(function)));
    }
}
