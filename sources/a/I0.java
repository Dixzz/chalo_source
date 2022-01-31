package a;

import j$.util.function.ToDoubleFunction;

public final /* synthetic */ class I0 implements ToDoubleFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ java.util.function.ToDoubleFunction f20a;

    private /* synthetic */ I0(java.util.function.ToDoubleFunction toDoubleFunction) {
        this.f20a = toDoubleFunction;
    }

    public static /* synthetic */ ToDoubleFunction a(java.util.function.ToDoubleFunction toDoubleFunction) {
        if (toDoubleFunction == null) {
            return null;
        }
        return toDoubleFunction instanceof J0 ? ((J0) toDoubleFunction).f22a : new I0(toDoubleFunction);
    }

    @Override // j$.util.function.ToDoubleFunction
    public /* synthetic */ double applyAsDouble(Object obj) {
        return this.f20a.applyAsDouble(obj);
    }
}
