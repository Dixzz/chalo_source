package defpackage;

import android.text.TextUtils;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.ProductSubCategory;
import app.zophop.models.mTicketing.SuperPassProductConfigurationProperties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: t60  reason: default package */
/* compiled from: BookingHelper.kt */
public final class t60 {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final app.zophop.models.mTicketing.BookableSuperPassConfiguration a(app.zophop.models.mTicketing.superPass.SuperPassApplication r10) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t60.a(app.zophop.models.mTicketing.superPass.SuperPassApplication):app.zophop.models.mTicketing.BookableSuperPassConfiguration");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.Integer, app.zophop.models.mTicketing.BookableSuperPassConfiguration>> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Map<String, Map<Integer, BookableSuperPassConfiguration>> b(String str, Map<String, ? extends Map<Integer, BookableSuperPassConfiguration>> map) {
        n86.e(map, "lMasterBookableSuperPassConfigMap");
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                int intValue = ((Number) entry2.getKey()).intValue();
                BookableSuperPassConfiguration bookableSuperPassConfiguration = (BookableSuperPassConfiguration) entry2.getValue();
                if (ea6.g(str, bookableSuperPassConfiguration.getSelectedSubCategory() != null ? bookableSuperPassConfiguration.getSelectedSubCategory().getId() : null, false, 2)) {
                    linkedHashMap2.put(Integer.valueOf(intValue), bookableSuperPassConfiguration);
                }
            }
            if (!linkedHashMap2.isEmpty()) {
                linkedHashMap.put(str2, linkedHashMap2);
            }
        }
        return linkedHashMap;
    }

    public static final Map<String, Map<Integer, BookableSuperPassConfiguration>> c(ProductConfiguration productConfiguration) {
        ArrayList<ProductFareMapping> arrayList;
        ProductConfiguration productConfiguration2 = productConfiguration;
        n86.e(productConfiguration2, "lProductConfiguration");
        List<ProductCategory> productCategoryList = productConfiguration.getProductCategoryList();
        if (productCategoryList == null) {
            productCategoryList = new ArrayList<>();
        }
        Map<String, List<ProductFareMapping>> productFareMapping = productConfiguration.getProductFareMapping();
        HashMap hashMap = new HashMap();
        for (ProductCategory productCategory : productCategoryList) {
            String categoryId = productCategory.getCategoryId();
            List<ProductFareMapping> list = null;
            if (productFareMapping != null && productFareMapping.containsKey(categoryId)) {
                list = productFareMapping.get(categoryId);
            }
            n86.d(productCategory, "iProductCategory");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (list == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList();
                for (ProductFareMapping productFareMapping2 : list) {
                    if (productFareMapping2.isVisible()) {
                        arrayList.add(productFareMapping2);
                    }
                }
                hd3.U2(arrayList, new h60(315360000000L, productCategory));
            }
            if (list != null) {
                for (ProductFareMapping productFareMapping3 : arrayList) {
                    String subCategoryId = productFareMapping3.getSubCategoryId();
                    Map<String, ProductSubCategory> productSubcategoryMap = productConfiguration.getProductSubcategoryMap();
                    n86.d(productSubcategoryMap, "lProductConfiguration.productSubcategoryMap");
                    ProductSubCategory e = e(subCategoryId, productSubcategoryMap);
                    List<String> d = d(productCategory, productFareMapping3);
                    SuperPassProductConfigurationProperties superPassProductConfigPropertiesFromProductConfiguration = SuperPassProductConfigurationProperties.Companion.getSuperPassProductConfigPropertiesFromProductConfiguration(productConfiguration2);
                    String productId = productConfiguration.getProductId();
                    n86.d(productId, "lProductConfiguration.productId");
                    linkedHashMap.put(Integer.valueOf(productFareMapping3.getFareMappingId()), new BookableSuperPassConfiguration(productId, superPassProductConfigPropertiesFromProductConfiguration, productFareMapping3, productCategory, e, d));
                    productConfiguration2 = productConfiguration;
                }
            }
            hashMap.put(categoryId, linkedHashMap);
            productConfiguration2 = productConfiguration;
        }
        return hashMap;
    }

    public static final List<String> d(ProductCategory productCategory, ProductFareMapping productFareMapping) {
        List<String> proofsRequiredList = productFareMapping.getProofsRequiredList();
        if (!(proofsRequiredList == null || proofsRequiredList.isEmpty())) {
            List<String> proofsRequiredList2 = productFareMapping.getProofsRequiredList();
            n86.d(proofsRequiredList2, "lProductFareMapping.proofsRequiredList");
            return proofsRequiredList2;
        }
        List<String> categoryProofsList = productCategory.getCategoryProofsList();
        n86.d(categoryProofsList, "lProductCategory.categoryProofsList");
        return categoryProofsList;
    }

    public static final ProductSubCategory e(String str, Map<String, ProductSubCategory> map) {
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }
}
