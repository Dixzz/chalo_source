package com.razorpay;

import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class Validation {
    public static Map<String, String> validateAmount(JSONObject jSONObject) {
        String optString = jSONObject.optString(AnalyticsConstants.AMOUNT);
        if (optString.isEmpty() || optString.matches("^[1-9][0-9]*[0-9]{2}$")) {
            return null;
        }
        return hj1.n0("field", AnalyticsConstants.AMOUNT, "description", BaseConstants.VALIDATION_AMOUNT_ERROR);
    }

    public static Map<String, String> validateCardCvv(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        String optString = jSONObject.optString("card[cvv]");
        hashMap.put("field", "card[cvv]");
        if (optString.isEmpty()) {
            return null;
        }
        if (optString.length() == 1) {
            optString = "0" + optString;
        }
        if (optString.length() < 3 || optString.length() > 4) {
            hashMap.put("description", BaseConstants.VALIDATION_CARD_CVV_LENGTH);
            return hashMap;
        } else if (optString.matches("^[0-9]{3,4}$")) {
            return null;
        } else {
            hashMap.put("field", "cvv");
            hashMap.put("description", BaseConstants.VALIDATION_CARD_CVV_DIGITS);
            return hashMap;
        }
    }

    public static Map<String, String> validateCardExpiry(JSONObject jSONObject) {
        String optString = jSONObject.optString("card[expiry_month]");
        HashMap m0 = hj1.m0("field", "card[expiry_month]");
        if (!optString.isEmpty()) {
            if (optString.length() == 1) {
                optString = "0" + optString;
            }
            if (optString.length() > 2) {
                m0.put("description", BaseConstants.VALIDATION_CARD_VALIDITY_ERROR);
                return m0;
            } else if (!optString.matches("^(0[1-9]|1[0-2])$")) {
                m0.put("description", BaseConstants.VALIDATION_CARD_EXPIRTY_DIGITS);
                return m0;
            }
        }
        String optString2 = jSONObject.optString("card[expiry_year]");
        m0.put("field", "card[expiry_year]");
        if (optString2.isEmpty()) {
            return null;
        }
        if (optString2.length() == 1) {
            optString2 = "0" + optString2;
        }
        if (optString2.length() > 2) {
            m0.put("description", BaseConstants.VALIDATION_CARD_EXPIRY_YEAR);
            return m0;
        } else if (optString2.matches("^[1-9][0-9]$")) {
            return null;
        } else {
            m0.put("description", BaseConstants.VALIDATION_CARD_EXPIRTY_DIGITS);
            return m0;
        }
    }

    public static Map<String, String> validateCardInfo(Map<String, String> map, JSONObject jSONObject) {
        Map<String, String> validateCardName = validateCardName(jSONObject);
        if (validateCardName != null) {
            return validateCardName;
        }
        Map<String, String> validateCardNumber = validateCardNumber(jSONObject);
        if (validateCardNumber != null) {
            return validateCardNumber;
        }
        Map<String, String> validateCardExpiry = validateCardExpiry(jSONObject);
        if (validateCardExpiry != null) {
            return validateCardExpiry;
        }
        Map<String, String> validateCardCvv = validateCardCvv(jSONObject);
        if (validateCardCvv != null) {
            return validateCardCvv;
        }
        return null;
    }

    public static Map<String, String> validateCardName(JSONObject jSONObject) {
        String optString = jSONObject.optString("card[name]");
        HashMap m0 = hj1.m0("field", "card[name]");
        if (optString.isEmpty() || optString.matches("^[a-zA-Z. ]*$")) {
            return null;
        }
        m0.put("field", "name");
        m0.put("description", "");
        return m0;
    }

    public static Map<String, String> validateCardNumber(JSONObject jSONObject) {
        String optString = jSONObject.optString("card[number]");
        HashMap m0 = hj1.m0("field", AnalyticsConstants.CARD_NUMBER);
        if (optString.isEmpty()) {
            return null;
        }
        if (optString.length() < 13 || optString.length() > 19) {
            m0.put("description", BaseConstants.VALIDATION_CARD_LESS_DIGITS);
            return m0;
        } else if (optString.matches("^[0-9]*")) {
            return null;
        } else {
            m0.put("description", BaseConstants.VALIDATION_CARD_DIGITS_ONLY);
            return m0;
        }
    }

    public static Map<String, String> validateContact(JSONObject jSONObject) {
        String optString = jSONObject.optString(AnalyticsConstants.CONTACT);
        HashMap hashMap = new HashMap();
        if (optString.isEmpty()) {
            return null;
        }
        if (optString.length() < 10 || optString.length() > 15) {
            hashMap.put("field", AnalyticsConstants.CONTACT);
            hashMap.put("description", BaseConstants.VALIDATION_CONTACT_LENGTH_ERROR);
            return hashMap;
        } else if (optString.matches("^[0-9()\\+]?[0-9()\\- ]*$")) {
            return null;
        } else {
            hashMap.put("field", AnalyticsConstants.CONTACT);
            hashMap.put("description", BaseConstants.VALIDATION_CONTACT_PLUS_ERROR);
            return hashMap;
        }
    }

    private static Map<String, String> validateContactForCred(JSONObject jSONObject) {
        String optString = jSONObject.optString(AnalyticsConstants.CONTACT);
        HashMap hashMap = new HashMap();
        if (optString.isEmpty()) {
            hashMap.put("field", AnalyticsConstants.CONTACT);
            hashMap.put("description", BaseConstants.VALIDATION_CONTACT_MISSING);
            return hashMap;
        } else if (optString.length() < 10 || optString.length() > 15) {
            hashMap.put("field", AnalyticsConstants.CONTACT);
            hashMap.put("description", BaseConstants.VALIDATION_CONTACT_LENGTH_ERROR);
            return hashMap;
        } else if (optString.matches("^[0-9()\\+]?[0-9()\\- ]*$")) {
            return null;
        } else {
            hashMap.put("field", AnalyticsConstants.CONTACT);
            hashMap.put("description", BaseConstants.VALIDATION_CONTACT_PLUS_ERROR);
            return hashMap;
        }
    }

    public static Map<String, String> validateCurrency(JSONObject jSONObject) {
        String optString = jSONObject.optString("currency");
        if (optString.isEmpty() || optString.matches("^[A-Z]{3}$")) {
            return null;
        }
        return hj1.n0("field", "currency", "description", BaseConstants.VALIDATION_CURRENCY_ERROR);
    }

    public static Map<String, String> validateEmail(JSONObject jSONObject) {
        String optString = jSONObject.optString("email");
        HashMap hashMap = new HashMap();
        if (optString.isEmpty()) {
            return null;
        }
        if (optString.length() > 255) {
            hashMap.put("field", "email");
            hashMap.put("description", BaseConstants.VALIDATION_EMAIL_LENGTH);
            return hashMap;
        } else if (optString.matches("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+$")) {
            return null;
        } else {
            hashMap.put("field", "email");
            hashMap.put("description", BaseConstants.VALIDATION_EMAIL_FAILED);
            return hashMap;
        }
    }

    public static final Map<String, String> validateFields(JSONObject jSONObject) {
        new HashMap();
        Map<String, String> validateCurrency = validateCurrency(jSONObject);
        if (validateCurrency != null) {
            return validateCurrency;
        }
        Map<String, String> validateAmount = validateAmount(jSONObject);
        if (validateAmount != null) {
            return validateAmount;
        }
        Map<String, String> validateContact = validateContact(jSONObject);
        if (validateContact != null) {
            return validateContact;
        }
        Map<String, String> validateEmail = validateEmail(jSONObject);
        if (validateEmail != null) {
            return validateEmail;
        }
        Map<String, String> validatePaymentMethod = validatePaymentMethod(jSONObject);
        if (validatePaymentMethod != null) {
            return validatePaymentMethod;
        }
        return null;
    }

    public static Map<String, String> validatePaymentMethod(JSONObject jSONObject) {
        Map<String, String> validateCardInfo;
        String optString = jSONObject.optString("method");
        String optString2 = jSONObject.optString("provider");
        HashMap hashMap = new HashMap();
        if (optString.isEmpty()) {
            hashMap.put("field", "method");
            hashMap.put("description", BaseConstants.VALIDATION_METHOD_EMPTY);
            return hashMap;
        }
        Map<String, String> map = hashMap;
        if (optString.equalsIgnoreCase(SettingsJsonConstants.APP_KEY)) {
            map = hashMap;
            if (!optString2.isEmpty()) {
                map = hashMap;
                if (optString2.equalsIgnoreCase("cred")) {
                    Map<String, String> validateContactForCred = validateContactForCred(jSONObject);
                    map = validateContactForCred;
                    if (validateContactForCred != null) {
                        return validateContactForCred;
                    }
                }
            }
        }
        if (!optString.equals(AnalyticsConstants.CARD) || (validateCardInfo = validateCardInfo(map, jSONObject)) == null) {
            return null;
        }
        return validateCardInfo;
    }
}
