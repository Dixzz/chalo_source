package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductSubCategory;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import server.zophop.queue.TaskKeys;

/* renamed from: ca1  reason: default package */
/* compiled from: PassSelectionViewModel.kt */
public final class ca1 extends zh {
    public final wh c;
    public String d;
    public String e;
    public final ProductConfiguration f;
    public ProductConfiguration g;
    public boolean h;
    public Map<String, ProductSubCategory> i;
    public Map<String, ? extends ProductCategory> j;
    public Map<String, ? extends Map<Integer, BookableSuperPassConfiguration>> k;
    public Map<String, ? extends Map<Integer, BookableSuperPassConfiguration>> l;
    public String m;
    public String n;
    public Integer o;

    /* renamed from: ca1$a */
    /* compiled from: PassSelectionViewModel.kt */
    public static final class a extends kg {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(mm mmVar, Bundle bundle) {
            super(mmVar, bundle);
            n86.e(mmVar, TaskKeys.OWNER);
        }

        @Override // defpackage.kg
        public <T extends zh> T d(String str, Class<T> cls, wh whVar) {
            n86.e(str, AnalyticsConstants.KEY);
            n86.e(cls, "modelClass");
            n86.e(whVar, "handle");
            return new ca1(whVar);
        }
    }

    public ca1(wh whVar) {
        List<ProductCategory> list;
        n86.e(whVar, "savedStateHandle");
        this.c = whVar;
        this.d = String.valueOf(whVar.f3779a.get("keyProductId"));
        if (whVar.f3779a.containsKey("keySrc") && !TextUtils.isEmpty((CharSequence) whVar.f3779a.get("keySrc"))) {
            this.e = String.valueOf(whVar.f3779a.get("keySrc"));
        }
        ProductConfiguration m0 = vn.m0(this.d);
        this.f = m0;
        Boolean bool = (Boolean) whVar.f3779a.get("keyIsProductConfigurationAvailable");
        boolean z = true;
        this.h = bool == null ? true : bool.booleanValue();
        z = m0 == null ? false : z;
        this.h = z;
        if (!z) {
            whVar.b("keyIsProductConfigurationAvailable", Boolean.FALSE);
            return;
        }
        whVar.b("keyIsProductConfigurationAvailable", Boolean.TRUE);
        n86.c(m0);
        n86.e(m0, "<set-?>");
        this.g = m0;
        this.k = t60.c(d());
        ProductConfiguration d2 = d();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (d2.getProductSubcategoryMap() != null) {
            Map<String, ProductSubCategory> productSubcategoryMap = d2.getProductSubcategoryMap();
            n86.d(productSubcategoryMap, "lProductConfiguration.productSubcategoryMap");
            for (Map.Entry<String, ProductSubCategory> entry : productSubcategoryMap.entrySet()) {
                String key = entry.getKey();
                ProductSubCategory value = entry.getValue();
                if (value.isVisible()) {
                    n86.d(key, "iSubCatId");
                    n86.d(value, "iSubCat");
                    linkedHashMap.put(key, value);
                }
            }
        }
        n86.e(linkedHashMap, "<set-?>");
        this.i = linkedHashMap;
        ProductConfiguration d3 = d();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        List<ProductCategory> productCategoryList = d3.getProductCategoryList();
        if (productCategoryList == null) {
            list = new ArrayList();
        } else {
            list = b96.a(productCategoryList);
            hd3.U2(list, g60.f);
        }
        for (ProductCategory productCategory : list) {
            if (productCategory.isVisible()) {
                String categoryId = productCategory.getCategoryId();
                n86.d(categoryId, "iProductCategory.categoryId");
                linkedHashMap2.put(categoryId, productCategory);
            }
        }
        n86.e(linkedHashMap2, "<set-?>");
        this.j = linkedHashMap2;
        Map<String, ? extends Map<Integer, BookableSuperPassConfiguration>> map = this.k;
        if (map != null) {
            Map<String, Map<Integer, BookableSuperPassConfiguration>> b = t60.b(null, map);
            n86.e(b, "<set-?>");
            this.l = b;
            return;
        }
        n86.l("masterBookablePassConfigMap");
        throw null;
    }

    @Override // defpackage.zh
    public void b() {
    }

    public final ProductConfiguration d() {
        ProductConfiguration productConfiguration = this.g;
        if (productConfiguration != null) {
            return productConfiguration;
        }
        n86.l("productConfiguration");
        throw null;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.Integer, app.zophop.models.mTicketing.BookableSuperPassConfiguration>>, java.util.Map<java.lang.String, java.util.Map<java.lang.Integer, app.zophop.models.mTicketing.BookableSuperPassConfiguration>> */
    public final Map<String, Map<Integer, BookableSuperPassConfiguration>> e() {
        Map map = this.l;
        if (map != null) {
            return map;
        }
        n86.l("relevantBookablePassConfigMap");
        throw null;
    }

    public final BookableSuperPassConfiguration f() {
        Map<Integer, BookableSuperPassConfiguration> map = e().get(this.m);
        if (map == null) {
            return null;
        }
        return map.get(this.o);
    }

    public final Map<String, ProductSubCategory> g() {
        Map<String, ProductSubCategory> map = this.i;
        if (map != null) {
            return map;
        }
        n86.l("visibleProductSubCategoryMap");
        throw null;
    }
}
