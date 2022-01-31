package a;

import j$.util.function.ToLongFunction;

public final /* synthetic */ class M0 implements ToLongFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ java.util.function.ToLongFunction f28a;

    private /* synthetic */ M0(java.util.function.ToLongFunction toLongFunction) {
        this.f28a = toLongFunction;
    }

    public static /* synthetic */ ToLongFunction a(java.util.function.ToLongFunction toLongFunction) {
        if (toLongFunction == null) {
            return null;
        }
        return toLongFunction instanceof N0 ? ((N0) toLongFunction).f30a : new M0(toLongFunction);
    }

    @Override // j$.util.function.ToLongFunction
    public /* synthetic */ long applyAsLong(Object obj) {
        return this.f28a.applyAsLong(obj);
    }
}
