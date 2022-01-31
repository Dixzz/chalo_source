package defpackage;

import android.util.Pair;
import app.zophop.models.http_response.TripSummary;
import defpackage.i10;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;

/* renamed from: tc1  reason: default package */
/* compiled from: NearbyStopTripCard */
public class tc1 implements Comparator<Pair<TripSummary, i10>>, j$.util.Comparator {
    public tc1(rc1 rc1) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // j$.util.Comparator, java.util.Comparator
    public int compare(Pair<TripSummary, i10> pair, Pair<TripSummary, i10> pair2) {
        int i;
        int i2;
        Pair<TripSummary, i10> pair3 = pair;
        Pair<TripSummary, i10> pair4 = pair2;
        i10 i10 = (i10) pair3.second;
        if (i10.f1460a == Integer.MAX_VALUE && ((i10) pair4.second).f1460a == Integer.MAX_VALUE) {
            return ui1.h((TripSummary) pair3.first, (TripSummary) pair4.first);
        }
        i10.a aVar = i10.d;
        if (aVar == null || aVar.equals(i10.a.FIXED)) {
            i = ((i10) pair3.second).f1460a;
        } else {
            i = ((i10) pair3.second).e;
        }
        i10.a aVar2 = ((i10) pair4.second).d;
        if (aVar2 == null || aVar2.equals(i10.a.FIXED)) {
            i2 = ((i10) pair4.second).f1460a;
        } else {
            i2 = ((i10) pair4.second).e;
        }
        return i - i2;
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ Comparator<Pair<TripSummary, i10>> reversed() {
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
    public /* synthetic */ java.util.Comparator<Pair<TripSummary, i10>> thenComparing(java.util.Comparator<? super Pair<TripSummary, i10>> comparator) {
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
