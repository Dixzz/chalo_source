package defpackage;

import app.zophop.models.CardInfo;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: vv  reason: default package */
/* compiled from: SuperPassConfigParser.kt */
public final class vv {
    public static final List<ProductCategory> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            boolean z = false;
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                n86.d(jSONObject, "categoryObject");
                ProductCategory productCategory = new ProductCategory();
                try {
                    String string = jSONObject.getString("id");
                    String string2 = jSONObject.getString("name");
                    int i3 = jSONObject.getInt(CardInfo.KEY_POS);
                    List<String> e = e(jSONObject.optJSONArray(SuperPassJsonKeys.PROOFS));
                    boolean optBoolean = jSONObject.optBoolean("verification", z);
                    boolean optBoolean2 = jSONObject.optBoolean("isActive", true);
                    String optString = jSONObject.optString("inactiveReason", new String());
                    boolean optBoolean3 = jSONObject.optBoolean(SuperPassJsonKeys.IS_RENEWABLE, z);
                    boolean optBoolean4 = jSONObject.optBoolean("isVisible", true);
                    String optString2 = jSONObject.optString("info");
                    String optString3 = jSONObject.optString("infoNote");
                    productCategory.set_categoryName(string2);
                    productCategory.setCategoryId(string);
                    productCategory.setCategoryActive(optBoolean2);
                    productCategory.setCategoryIsRenewable(optBoolean3);
                    productCategory.setCategoryProofsList(e);
                    productCategory.setCategoryInfo(optString2);
                    productCategory.setCategoryVerificationRequired(optBoolean);
                    productCategory.setInactiveReason(optString);
                    productCategory.set_catInfoNote(optString3);
                    productCategory.setIsVisible(optBoolean4);
                    productCategory.setPosition(i3);
                } catch (JSONException unused) {
                }
                arrayList.add(productCategory);
                if (i2 >= length) {
                    break;
                }
                z = false;
                i = i2;
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01e5 A[LOOP:1: B:6:0x0028->B:39:0x01e5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01f7 A[EDGE_INSN: B:46:0x01f7->B:41:0x01f7 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.util.List<app.zophop.models.mTicketing.ProductFareMapping>> b(org.json.JSONObject r29) {
        /*
        // Method dump skipped, instructions count: 520
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vv.b(org.json.JSONObject):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f A[Catch:{ JSONException -> 0x01e0 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030 A[Catch:{ JSONException -> 0x01e0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final app.zophop.models.mTicketing.ProductConfiguration c(org.json.JSONObject r30) {
        /*
        // Method dump skipped, instructions count: 489
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vv.c(org.json.JSONObject):app.zophop.models.mTicketing.ProductConfiguration");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a0 A[LOOP:0: B:6:0x0019->B:20:0x00a0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a7 A[EDGE_INSN: B:22:0x00a7->B:21:0x00a7 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, app.zophop.models.mTicketing.ProductSubCategory> d(org.json.JSONArray r23) {
        /*
        // Method dump skipped, instructions count: 168
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vv.d(org.json.JSONArray):java.util.Map");
    }

    public static final List<String> e(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            int length = jSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    arrayList.add(jSONArray.getString(i));
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        return arrayList;
    }
}
