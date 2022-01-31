package a;

import java.util.function.IntToDoubleFunction;

/* renamed from: a.e0 */
public final /* synthetic */ class C0082e0 {

    /* renamed from: a */
    final /* synthetic */ IntToDoubleFunction f58a;

    private /* synthetic */ C0082e0(IntToDoubleFunction intToDoubleFunction) {
        this.f58a = intToDoubleFunction;
    }

    public static /* synthetic */ C0082e0 b(IntToDoubleFunction intToDoubleFunction) {
        if (intToDoubleFunction == null) {
            return null;
        }
        return intToDoubleFunction instanceof C0084f0 ? ((C0084f0) intToDoubleFunction).f59a : new C0082e0(intToDoubleFunction);
    }

    public double a(int i) {
        return this.f58a.applyAsDouble(i);
    }
}
