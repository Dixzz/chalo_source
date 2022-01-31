package j$.util;

import a.I0;
import a.K0;
import a.M0;
import a.U;
import j$.util.Comparator;
import j$.util.function.ToDoubleFunction;
import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public final /* synthetic */ class c implements Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToDoubleFunction f1649a;

    public /* synthetic */ c(ToDoubleFunction toDoubleFunction) {
        this.f1649a = toDoubleFunction;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ToDoubleFunction toDoubleFunction = this.f1649a;
        return Double.compare(toDoubleFunction.applyAsDouble(obj), toDoubleFunction.applyAsDouble(obj2));
    }

    @Override // java.util.Comparator
    public /* synthetic */ Comparator reversed() {
        return Comparator.CC.$default$reversed(this);
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return Comparator.CC.$default$thenComparing(this, U.c(function));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(java.util.function.ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, I0.a(toDoubleFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, K0.a(toIntFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, M0.a(toLongFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, U.c(function), comparator);
    }
}
