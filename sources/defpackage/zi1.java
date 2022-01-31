package defpackage;

import app.zophop.models.http_response.TripSummary;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;

/* renamed from: zi1  reason: default package */
/* compiled from: Utils */
public class zi1 implements Comparator<TripSummary>, j$.util.Comparator {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // j$.util.Comparator, java.util.Comparator
    public int compare(TripSummary tripSummary, TripSummary tripSummary2) {
        TripSummary tripSummary3 = tripSummary;
        TripSummary tripSummary4 = tripSummary2;
        if (!ui1.g0(tripSummary3) && ui1.g0(tripSummary4)) {
            return 1;
        }
        if (!ui1.g0(tripSummary3) || ui1.g0(tripSummary4)) {
            if (ui1.S(tripSummary3) && !ui1.S(tripSummary4)) {
                return 1;
            }
            if (ui1.S(tripSummary3) || !ui1.S(tripSummary4)) {
                return tripSummary3.getRouteName().compareTo(tripSummary4.getRouteName());
            }
        }
        return -1;
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ Comparator<TripSummary> reversed() {
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
    public /* synthetic */ java.util.Comparator<TripSummary> thenComparing(java.util.Comparator<? super TripSummary> comparator) {
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
