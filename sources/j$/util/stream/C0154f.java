package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.C0125b;
import j$.util.function.Function;
import j$.util.function.n;
import j$.util.stream.R1;
import j$.util.stream.S1;
import java.util.Objects;

/* renamed from: j$.util.stream.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0154f implements n {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0154f f1784a = new C0154f();

    private /* synthetic */ C0154f() {
    }

    @Override // j$.util.function.BiFunction
    public BiFunction a(Function function) {
        Objects.requireNonNull(function);
        return new C0125b(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return new S1.f.b((R1.c) obj, (R1.c) obj2);
    }
}
