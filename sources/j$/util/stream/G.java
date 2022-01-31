package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0125b;
import j$.util.function.Function;
import j$.util.function.n;
import java.util.Objects;

public final /* synthetic */ class G implements n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f1703a;

    public /* synthetic */ G(BiConsumer biConsumer) {
        this.f1703a = biConsumer;
    }

    @Override // j$.util.function.BiFunction
    public BiFunction a(Function function) {
        Objects.requireNonNull(function);
        return new C0125b(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        this.f1703a.accept(obj, obj2);
        return obj;
    }
}
