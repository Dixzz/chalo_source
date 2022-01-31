package a;

import java.util.function.ToIntFunction;

public final /* synthetic */ class L0 implements ToIntFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j$.util.function.ToIntFunction f26a;

    private /* synthetic */ L0(j$.util.function.ToIntFunction toIntFunction) {
        this.f26a = toIntFunction;
    }

    public static /* synthetic */ ToIntFunction a(j$.util.function.ToIntFunction toIntFunction) {
        if (toIntFunction == null) {
            return null;
        }
        return toIntFunction instanceof K0 ? ((K0) toIntFunction).f24a : new L0(toIntFunction);
    }

    @Override // java.util.function.ToIntFunction
    public /* synthetic */ int applyAsInt(Object obj) {
        return this.f26a.applyAsInt(obj);
    }
}
