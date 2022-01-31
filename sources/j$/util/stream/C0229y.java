package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.C0125b;
import j$.util.function.Function;
import j$.util.function.n;
import j$.util.stream.R1;
import j$.util.stream.S1;
import java.util.Objects;

/* renamed from: j$.util.stream.y  reason: case insensitive filesystem */
public final /* synthetic */ class C0229y implements n {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0229y f1841a = new C0229y();

    private /* synthetic */ C0229y() {
    }

    @Override // j$.util.function.BiFunction
    public BiFunction a(Function function) {
        Objects.requireNonNull(function);
        return new C0125b(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return new S1.f.c((R1.d) obj, (R1.d) obj2);
    }
}
