package defpackage;

import app.zophop.products.ProductSelectionActivity;
import app.zophop.ui.adapters.ProductInfo;
import com.google.firebase.appindexing.Indexable;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;
import java.util.Map;

/* renamed from: r70  reason: default package */
/* compiled from: ProductSelectionActivity */
public class r70 implements Comparator<Map.Entry<String, ProductInfo>>, j$.util.Comparator {
    public r70(ProductSelectionActivity productSelectionActivity) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // j$.util.Comparator, java.util.Comparator
    public int compare(Map.Entry<String, ProductInfo> entry, Map.Entry<String, ProductInfo> entry2) {
        Map.Entry<String, ProductInfo> entry3 = entry;
        Map.Entry<String, ProductInfo> entry4 = entry2;
        int i = entry3.getValue().m;
        int i2 = entry4.getValue().m;
        if (!entry3.getValue().r) {
            i += Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
        }
        if (!entry4.getValue().r) {
            i2 += Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
        }
        return Integer.compare(i, i2);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ Comparator<Map.Entry<String, ProductInfo>> reversed() {
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
    public /* synthetic */ java.util.Comparator<Map.Entry<String, ProductInfo>> thenComparing(java.util.Comparator<? super Map.Entry<String, ProductInfo>> comparator) {
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
