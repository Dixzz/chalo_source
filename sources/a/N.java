package a;

import java.util.function.DoubleToIntFunction;

public final /* synthetic */ class N {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleToIntFunction f29a;

    private /* synthetic */ N(DoubleToIntFunction doubleToIntFunction) {
        this.f29a = doubleToIntFunction;
    }

    public static /* synthetic */ N b(DoubleToIntFunction doubleToIntFunction) {
        if (doubleToIntFunction == null) {
            return null;
        }
        return doubleToIntFunction instanceof O ? ((O) doubleToIntFunction).f31a : new N(doubleToIntFunction);
    }

    public int a(double d) {
        return this.f29a.applyAsInt(d);
    }
}
