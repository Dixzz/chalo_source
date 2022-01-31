package defpackage;

import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductFareMapping;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;

/* renamed from: h60  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class h60 implements Comparator, j$.util.Comparator {
    public final /* synthetic */ long f;
    public final /* synthetic */ ProductCategory g;

    public /* synthetic */ h60(long j, ProductCategory productCategory) {
        this.f = j;
        this.g = productCategory;
    }

    @Override // j$.util.Comparator, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        long j = this.f;
        ProductCategory productCategory = this.g;
        ProductFareMapping productFareMapping = (ProductFareMapping) obj;
        ProductFareMapping productFareMapping2 = (ProductFareMapping) obj2;
        n86.e(productCategory, "$lProductCategory");
        long durationId = productFareMapping.getDurationId();
        long durationId2 = productFareMapping2.getDurationId();
        if ((productFareMapping.getIsActive() != null && !productFareMapping.getIsActive().booleanValue()) || !productCategory.isCategoryActive()) {
            durationId += j;
        }
        if ((productFareMapping2.getIsActive() != null && !productFareMapping2.getIsActive().booleanValue()) || !productCategory.isCategoryActive()) {
            durationId2 += j;
        }
        int i = (durationId > durationId2 ? 1 : (durationId == durationId2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ Comparator reversed() {
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

    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
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
