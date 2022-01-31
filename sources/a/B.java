package a;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.n;
import java.util.function.BinaryOperator;

public final /* synthetic */ class B implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BinaryOperator f5a;

    private /* synthetic */ B(BinaryOperator binaryOperator) {
        this.f5a = binaryOperator;
    }

    public static /* synthetic */ n b(BinaryOperator binaryOperator) {
        if (binaryOperator == null) {
            return null;
        }
        return binaryOperator instanceof C ? ((C) binaryOperator).f7a : new B(binaryOperator);
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ BiFunction a(Function function) {
        return C0122z.b(this.f5a.andThen(V.a(function)));
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.f5a.apply(obj, obj2);
    }
}
