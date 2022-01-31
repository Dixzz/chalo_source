package a;

import j$.util.function.r;
import java.util.function.DoubleFunction;

public final /* synthetic */ class J implements r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleFunction f21a;

    private /* synthetic */ J(DoubleFunction doubleFunction) {
        this.f21a = doubleFunction;
    }

    public static /* synthetic */ r a(DoubleFunction doubleFunction) {
        if (doubleFunction == null) {
            return null;
        }
        return doubleFunction instanceof K ? ((K) doubleFunction).f23a : new J(doubleFunction);
    }

    @Override // j$.util.function.r
    public /* synthetic */ Object apply(double d) {
        return this.f21a.apply(d);
    }
}
