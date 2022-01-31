package defpackage;

import app.zophop.models.TransitMode;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;

/* renamed from: vi1  reason: default package */
/* compiled from: Utils */
public class vi1 implements Comparator<TransitMode>, j$.util.Comparator {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // j$.util.Comparator, java.util.Comparator
    public int compare(TransitMode transitMode, TransitMode transitMode2) {
        return new Integer(transitMode.getPriority()).compareTo(Integer.valueOf(transitMode2.getPriority()));
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ Comparator<TransitMode> reversed() {
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
    public /* synthetic */ java.util.Comparator<TransitMode> thenComparing(java.util.Comparator<? super TransitMode> comparator) {
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
