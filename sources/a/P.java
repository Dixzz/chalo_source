package a;

import j$.util.function.t;
import java.util.function.DoubleToLongFunction;

public final /* synthetic */ class P implements t {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleToLongFunction f33a;

    private /* synthetic */ P(DoubleToLongFunction doubleToLongFunction) {
        this.f33a = doubleToLongFunction;
    }

    public static /* synthetic */ t a(DoubleToLongFunction doubleToLongFunction) {
        if (doubleToLongFunction == null) {
            return null;
        }
        return doubleToLongFunction instanceof Q ? ((Q) doubleToLongFunction).f35a : new P(doubleToLongFunction);
    }

    @Override // j$.util.function.t
    public /* synthetic */ long applyAsLong(double d) {
        return this.f33a.applyAsLong(d);
    }
}
