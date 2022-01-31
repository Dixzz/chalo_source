package app.zophop.models.mTicketing.cardRecharge;

import app.zophop.models.mTicketing.ProductBranding;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CardRechargeJsonParser.kt */
public final class CardRechargeJsonParser {
    public static final CardRechargeJsonParser INSTANCE = new CardRechargeJsonParser();

    private CardRechargeJsonParser() {
    }

    private final ProductBranding getBranding(JSONObject jSONObject) {
        return new ProductBranding(jSONObject.optBoolean("isVisible", false));
    }

    private final CardProperties getCardProperties(String str, String str2, String str3) {
        return new CardProperties(str, str2, str3);
    }

    private final CardRechargePaymentProperties getCardRechargePaymentProperties(String str, String str2, long j, CardRechargeInfo cardRechargeInfo) {
        return new CardRechargePaymentProperties(str, str2, j, cardRechargeInfo);
    }

    private final CardRechargeUIProperties getCardRechargeUIProperties(String str, ProductBranding productBranding, String str2) {
        return new CardRechargeUIProperties(str, productBranding, str2);
    }

    private final CardRechargeInfo getRechargeInfo(JSONObject jSONObject) {
        CardRechargeStatus cardRechargeStatus;
        String string = jSONObject.getString(CardRechargeJsonKeys.PAYMENT_STATUS);
        n86.d(string, "lRechargeInfoObject.getS…eJsonKeys.PAYMENT_STATUS)");
        String upperCase = string.toUpperCase();
        n86.d(upperCase, "(this as java.lang.String).toUpperCase()");
        CardRechargePaymentStatus valueOf = CardRechargePaymentStatus.valueOf(upperCase);
        if (jSONObject.has(CardRechargeJsonKeys.RECHARGE_STATUS)) {
            String string2 = jSONObject.getString(CardRechargeJsonKeys.RECHARGE_STATUS);
            n86.d(string2, "lRechargeInfoObject.getS…JsonKeys.RECHARGE_STATUS)");
            String upperCase2 = string2.toUpperCase();
            n86.d(upperCase2, "(this as java.lang.String).toUpperCase()");
            cardRechargeStatus = CardRechargeStatus.valueOf(upperCase2);
        } else {
            cardRechargeStatus = CardRechargeStatus.PENDING;
        }
        return new CardRechargeInfo(valueOf, cardRechargeStatus, jSONObject.getLong(CardRechargeJsonKeys.RECHARGE_AMOUNT));
    }

    private final boolean isCardObjectValid(JSONObject jSONObject) {
        return jSONObject.has("productType") && jSONObject.has("productSubType") && n86.a(jSONObject.getString("productType"), "cardRecharge") && n86.a(jSONObject.getString("productSubType"), "cardRecharge");
    }

    private final OnlineCardRecharge parseCardRechargeObject(JSONObject jSONObject) {
        String string = jSONObject.getString("city");
        n86.d(string, "lJsonObject.getString(CardRechargeJsonKeys.CITY)");
        String lowerCase = string.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        String string2 = jSONObject.getString("agency");
        String string3 = jSONObject.getString("transactionId");
        String string4 = jSONObject.getString(CardRechargeJsonKeys.CARD_NO);
        String string5 = jSONObject.getString("paymentMode");
        long j = jSONObject.getLong("bookingTime");
        String string6 = jSONObject.getString("productName");
        JSONObject jSONObject2 = jSONObject.getJSONObject(CardRechargeJsonKeys.RECHARGE_INFO);
        JSONObject jSONObject3 = jSONObject.getJSONObject("branding");
        String optString = jSONObject.optString(CardRechargeJsonKeys.RECHARGE_DELAY_COPY, "");
        n86.d(jSONObject2, "lRechargeInfoObject");
        CardRechargeInfo rechargeInfo = getRechargeInfo(jSONObject2);
        n86.d(jSONObject3, "lBrandingObject");
        ProductBranding branding = getBranding(jSONObject3);
        n86.d(string3, "lTransactionId");
        n86.d(string5, "lPaymentMode");
        CardRechargePaymentProperties cardRechargePaymentProperties = getCardRechargePaymentProperties(string3, string5, j, rechargeInfo);
        n86.d(string6, "lProductName");
        n86.d(optString, "lRechargeDelayCopy");
        CardRechargeUIProperties cardRechargeUIProperties = getCardRechargeUIProperties(string6, branding, optString);
        n86.d(string4, "lCardNo");
        n86.d(string2, "lAgency");
        return new OnlineCardRecharge(cardRechargePaymentProperties, cardRechargeUIProperties, getCardProperties(string4, lowerCase, string2));
    }

    public final List<OnlineCardRecharge> parseCardsArray(JSONArray jSONArray) {
        n86.e(jSONArray, "lJSONArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                n86.d(jSONObject, "lJSONArray.getJSONObject(i)");
                if (isCardObjectValid(jSONObject)) {
                    arrayList.add(parseCardRechargeObject(jSONObject));
                }
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }
}
