package defpackage;

import defpackage.bj0;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;

/* renamed from: hj0  reason: default package */
/* compiled from: FavoriteListAdapter */
public class hj0 implements Comparator<bj0.k>, j$.util.Comparator {
    public hj0(bj0 bj0) {
    }

    public final long a(bj0.k kVar) {
        if (kVar.f438a.equals(bj0.l.FAVORITE_ROUTE) || kVar.f438a.equals(bj0.l.FAVORITE_ITEM_STOP)) {
            return kVar.b.getTime();
        }
        if (kVar.f438a.equals(bj0.l.RECENT_TRIP)) {
            return kVar.e.getTimeStamp();
        }
        return kVar.d.b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // j$.util.Comparator, java.util.Comparator
    public int compare(bj0.k kVar, bj0.k kVar2) {
        int i = (a(kVar) > a(kVar2) ? 1 : (a(kVar) == a(kVar2) ? 0 : -1));
        if (i > 0) {
            return -1;
        }
        return i < 0 ? 1 : 0;
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ Comparator<bj0.k> reversed() {
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
    public /* synthetic */ java.util.Comparator<bj0.k> thenComparing(java.util.Comparator<? super bj0.k> comparator) {
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
