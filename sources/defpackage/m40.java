package defpackage;

import app.zophop.models.Route;
import app.zophop.models.TimeInterval;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;

/* renamed from: m40  reason: default package */
/* compiled from: RouteFeature */
public class m40 implements Comparator<Route.RouteTiming>, j$.util.Comparator {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // j$.util.Comparator, java.util.Comparator
    public int compare(Route.RouteTiming routeTiming, Route.RouteTiming routeTiming2) {
        int i;
        int i2;
        Route.RouteTiming routeTiming3 = routeTiming;
        Route.RouteTiming routeTiming4 = routeTiming2;
        if (routeTiming3._isFrequency) {
            i = ((TimeInterval) routeTiming3._frequencyTuple.first).getLow();
        } else {
            i = routeTiming3._startTime;
        }
        if (routeTiming4._isFrequency) {
            i2 = ((TimeInterval) routeTiming4._frequencyTuple.first).getLow();
        } else {
            i2 = routeTiming4._startTime;
        }
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ Comparator<Route.RouteTiming> reversed() {
        return Comparator.CC.$default$reversed(this);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return Comparator.CC.$default$thenComparing(this, function);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, function, comparator);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ java.util.Comparator<Route.RouteTiming> thenComparing(java.util.Comparator<? super Route.RouteTiming> comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
    }
}
