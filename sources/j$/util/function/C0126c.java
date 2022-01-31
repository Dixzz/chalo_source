package j$.util.function;

import java.util.Comparator;
import java.util.Objects;

/* renamed from: j$.util.function.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0126c implements n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparator f1667a;

    public /* synthetic */ C0126c(Comparator comparator) {
        this.f1667a = comparator;
    }

    @Override // j$.util.function.BiFunction
    public BiFunction a(Function function) {
        Objects.requireNonNull(function);
        return new C0125b(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return this.f1667a.compare(obj, obj2) <= 0 ? obj : obj2;
    }
}
