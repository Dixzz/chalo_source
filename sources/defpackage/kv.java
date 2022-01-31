package defpackage;

import app.zophop.models.mTicketing.CardRechargeFareInfo;
import app.zophop.models.mTicketing.ProductBranding;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: kv  reason: default package */
/* compiled from: CardRechargeConfigParser.kt */
public final class kv {
    public static final ProductConfiguration a(JSONObject jSONObject) {
        boolean z;
        ProductBranding productBranding;
        int i;
        int length;
        int length2;
        n86.e(jSONObject, "lProductConfigObject");
        ProductConfiguration productConfiguration = new ProductConfiguration();
        try {
            String string = jSONObject.getString("productSubType");
            n86.d(string, "lProductConfigObject.get…nts.KEY_PRODUCT_SUB_TYPE)");
            if (!n86.a(string, "cardRecharge")) {
                return productConfiguration;
            }
            String string2 = jSONObject.getString("id");
            n86.d(string2, "lProductConfigObject.get…Constants.KEY_PRODUCT_ID)");
            String string3 = jSONObject.getString("city");
            n86.d(string3, "lProductConfigObject.get…nstants.KEY_PRODUCT_CITY)");
            String optString = jSONObject.optString("name");
            String string4 = jSONObject.getString("productType");
            n86.d(string4, "lProductConfigObject.get…nstants.KEY_PRODUCT_TYPE)");
            String string5 = jSONObject.getString("agency");
            n86.d(string5, "lProductConfigObject.get…tants.KEY_PRODUCT_AGENCY)");
            JSONObject jSONObject2 = jSONObject.getJSONObject(SuperPassJsonKeys.KEY_FARE_INFO);
            String optString2 = jSONObject.optString(CardRechargeJsonKeys.RECHARGE_DELAY_COPY, "");
            boolean optBoolean = jSONObject.optBoolean("isActive", true);
            boolean optBoolean2 = jSONObject.optBoolean("isVisible", true);
            int optInt = jSONObject.optInt("minAppVer", -1);
            int optInt2 = jSONObject.optInt("maxAppVer", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject("branding");
            JSONArray optJSONArray = jSONObject.optJSONArray("terms");
            n86.d(jSONObject2, "lFareInfoObject");
            long optLong = jSONObject2.optLong("minAmount", 0);
            long optLong2 = jSONObject2.optLong("multiplesAllowed", 1);
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("suggestedAmounts");
            if (optJSONArray2 == null || (length2 = optJSONArray2.length()) <= 0) {
                z = optBoolean;
            } else {
                int i2 = 0;
                while (true) {
                    z = optBoolean;
                    int i3 = i2 + 1;
                    arrayList.add(Long.valueOf(optJSONArray2.getLong(i2)));
                    if (i3 >= length2) {
                        break;
                    }
                    i2 = i3;
                    optBoolean = z;
                }
            }
            CardRechargeFareInfo cardRechargeFareInfo = new CardRechargeFareInfo(optLong, optLong2, arrayList);
            if (optJSONObject != null) {
                i = 0;
                productBranding = new ProductBranding(optJSONObject.optBoolean("isVisible", false));
            } else {
                i = 0;
                productBranding = new ProductBranding(true);
            }
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                while (true) {
                    int i4 = i + 1;
                    String string6 = optJSONArray.getString(i);
                    n86.d(string6, "lTermsArray.getString(j)");
                    arrayList2.add(string6);
                    if (i4 >= length) {
                        break;
                    }
                    i = i4;
                }
            }
            productConfiguration.setBranding(productBranding);
            productConfiguration.setProductId(string2);
            productConfiguration.setProductCity(string3);
            productConfiguration.setProductName(optString);
            productConfiguration.setProductType(string4);
            productConfiguration.setProductSubType(string);
            productConfiguration.setProductAgency(string5);
            productConfiguration.setProductTerms(arrayList2);
            productConfiguration.setCardRechargeFareInfo(cardRechargeFareInfo);
            productConfiguration.setRechargeDelayCopy(optString2);
            productConfiguration.setIsActive(z);
            productConfiguration.setIsVisible(optBoolean2);
            productConfiguration.setMinAppVer(optInt);
            productConfiguration.setMaxAppVer(optInt2);
            return productConfiguration;
        } catch (JSONException e) {
            n86.c(e.getMessage());
        }
    }
}
