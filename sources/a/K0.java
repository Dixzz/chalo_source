package a;

import j$.util.function.ToIntFunction;

public final /* synthetic */ class K0 implements ToIntFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ java.util.function.ToIntFunction f24a;

    private /* synthetic */ K0(java.util.function.ToIntFunction toIntFunction) {
        this.f24a = toIntFunction;
    }

    public static /* synthetic */ ToIntFunction a(java.util.function.ToIntFunction toIntFunction) {
        if (toIntFunction == null) {
            return null;
        }
        return toIntFunction instanceof L0 ? ((L0) toIntFunction).f26a : new K0(toIntFunction);
    }

    @Override // j$.util.function.ToIntFunction
    public /* synthetic */ int applyAsInt(Object obj) {
        return this.f24a.applyAsInt(obj);
    }
}
