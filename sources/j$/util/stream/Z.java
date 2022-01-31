package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.C0125b;
import j$.util.function.Function;
import j$.util.function.n;
import j$.util.stream.R1;
import j$.util.stream.S1;
import java.util.Objects;

public final /* synthetic */ class Z implements n {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ Z f1763a = new Z();

    private /* synthetic */ Z() {
    }

    @Override // j$.util.function.BiFunction
    public BiFunction a(Function function) {
        Objects.requireNonNull(function);
        return new C0125b(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return new S1.f.a((R1.b) obj, (R1.b) obj2);
    }
}
