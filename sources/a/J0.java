package a;

import java.util.function.ToDoubleFunction;

public final /* synthetic */ class J0 implements ToDoubleFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j$.util.function.ToDoubleFunction f22a;

    private /* synthetic */ J0(j$.util.function.ToDoubleFunction toDoubleFunction) {
        this.f22a = toDoubleFunction;
    }

    public static /* synthetic */ ToDoubleFunction a(j$.util.function.ToDoubleFunction toDoubleFunction) {
        if (toDoubleFunction == null) {
            return null;
        }
        return toDoubleFunction instanceof I0 ? ((I0) toDoubleFunction).f20a : new J0(toDoubleFunction);
    }

    @Override // java.util.function.ToDoubleFunction
    public /* synthetic */ double applyAsDouble(Object obj) {
        return this.f22a.applyAsDouble(obj);
    }
}
