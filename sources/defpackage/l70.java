package defpackage;

import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.products.CategorySelectionActivity;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;

/* renamed from: l70  reason: default package */
/* compiled from: CategorySelectionActivity */
public class l70 implements Comparator<ProductFareMapping>, j$.util.Comparator {
    public final /* synthetic */ Long f;

    public l70(CategorySelectionActivity categorySelectionActivity, Long l) {
        this.f = l;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // j$.util.Comparator, java.util.Comparator
    public int compare(ProductFareMapping productFareMapping, ProductFareMapping productFareMapping2) {
        ProductFareMapping productFareMapping3 = productFareMapping;
        ProductFareMapping productFareMapping4 = productFareMapping2;
        Long valueOf = Long.valueOf(productFareMapping3.getDurationId());
        Long valueOf2 = Long.valueOf(productFareMapping4.getDurationId());
        if (!productFareMapping3.getLegacyIsActive().booleanValue() || !productFareMapping3.getProductDuration().getIsActive()) {
            valueOf = Long.valueOf(this.f.longValue() + valueOf.longValue());
        }
        if (!productFareMapping4.getLegacyIsActive().booleanValue() || !productFareMapping4.getProductDuration().getIsActive()) {
            valueOf2 = Long.valueOf(this.f.longValue() + valueOf2.longValue());
        }
        return valueOf.compareTo(valueOf2);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ Comparator<ProductFareMapping> reversed() {
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
    public /* synthetic */ java.util.Comparator<ProductFareMapping> thenComparing(java.util.Comparator<? super ProductFareMapping> comparator) {
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
