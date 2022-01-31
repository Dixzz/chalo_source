package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0125b;
import j$.util.function.Function;
import j$.util.function.n;
import java.util.Objects;

/* renamed from: j$.util.stream.w  reason: case insensitive filesystem */
public final /* synthetic */ class C0221w implements n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f1834a;

    public /* synthetic */ C0221w(BiConsumer biConsumer) {
        this.f1834a = biConsumer;
    }

    @Override // j$.util.function.BiFunction
    public BiFunction a(Function function) {
        Objects.requireNonNull(function);
        return new C0125b(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        this.f1834a.accept(obj, obj2);
        return obj;
    }
}
