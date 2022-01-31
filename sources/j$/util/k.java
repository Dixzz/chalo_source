package j$.util;

import a.I0;
import a.K0;
import a.M0;
import a.U;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;

/* access modifiers changed from: package-private */
public enum k implements Comparator<Comparable<Object>>, Comparator {
    INSTANCE;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // j$.util.Comparator, java.util.Comparator
    public int compare(Comparable<Object> comparable, Comparable<Object> comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // j$.util.Comparator, java.util.Comparator
    public Comparator<Comparable<Object>> reversed() {
        return Collections.reverseOrder();
    }

    @Override // j$.util.Comparator
    public /* synthetic */ Comparator thenComparing(Function function) {
        return Comparator.CC.$default$thenComparing(this, function);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, function, comparator);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ java.util.Comparator<Comparable<Object>> thenComparing(java.util.Comparator<? super Comparable<Object>> comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator<Comparable<Object>> thenComparing(java.util.function.Function function) {
        return Comparator.CC.$default$thenComparing(this, U.c(function));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.function.ToDoubleFunction] */
    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator<Comparable<Object>> thenComparingDouble(java.util.function.ToDoubleFunction<? super Comparable<Object>> toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, I0.a(toDoubleFunction));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.function.ToIntFunction] */
    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator<Comparable<Object>> thenComparingInt(java.util.function.ToIntFunction<? super Comparable<Object>> toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, K0.a(toIntFunction));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.function.ToLongFunction] */
    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator<Comparable<Object>> thenComparingLong(java.util.function.ToLongFunction<? super Comparable<Object>> toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, M0.a(toLongFunction));
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator<Comparable<Object>> thenComparing(java.util.function.Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, U.c(function), comparator);
    }
}
