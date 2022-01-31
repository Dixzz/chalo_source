package j$.util.function;

import java.util.Objects;

/* renamed from: j$.util.function.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0125b implements BiFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiFunction f1666a;
    public final /* synthetic */ Function b;

    public /* synthetic */ C0125b(BiFunction biFunction, Function function) {
        this.f1666a = biFunction;
        this.b = function;
    }

    @Override // j$.util.function.BiFunction
    public BiFunction a(Function function) {
        Objects.requireNonNull(function);
        return new C0125b(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return this.b.apply(this.f1666a.apply(obj, obj2));
    }
}
