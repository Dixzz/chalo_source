package a;

import java.util.function.ToLongFunction;

public final /* synthetic */ class N0 implements ToLongFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j$.util.function.ToLongFunction f30a;

    private /* synthetic */ N0(j$.util.function.ToLongFunction toLongFunction) {
        this.f30a = toLongFunction;
    }

    public static /* synthetic */ ToLongFunction a(j$.util.function.ToLongFunction toLongFunction) {
        if (toLongFunction == null) {
            return null;
        }
        return toLongFunction instanceof M0 ? ((M0) toLongFunction).f28a : new N0(toLongFunction);
    }

    @Override // java.util.function.ToLongFunction
    public /* synthetic */ long applyAsLong(Object obj) {
        return this.f30a.applyAsLong(obj);
    }
}
