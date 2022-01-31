package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.C0125b;
import j$.util.function.Function;
import j$.util.function.n;
import j$.util.stream.S1;
import java.util.Objects;

public final /* synthetic */ class P0 implements n {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ P0 f1725a = new P0();

    private /* synthetic */ P0() {
    }

    @Override // j$.util.function.BiFunction
    public BiFunction a(Function function) {
        Objects.requireNonNull(function);
        return new C0125b(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return new S1.f((R1) obj, (R1) obj2);
    }
}
