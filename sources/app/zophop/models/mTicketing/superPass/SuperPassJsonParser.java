package app.zophop.models.mTicketing.superPass;

import app.zophop.models.mTicketing.FareBreakupComponent;
import app.zophop.models.mTicketing.FareInfo;
import app.zophop.models.mTicketing.Gender;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.models.mTicketing.PassApplicationRejectionReasons;
import app.zophop.models.mTicketing.ProductBranding;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPassProperties;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPassRepurchaseProperties;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPassTransactionDetails;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPassUIProperties;
import app.zophop.pubsub.eventbus.events.CardValidityCheckEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SuperPassJsonParser.kt */
public final class SuperPassJsonParser {
    public static final SuperPassJsonParser INSTANCE = new SuperPassJsonParser();

    private SuperPassJsonParser() {
    }

    private final List<FareBreakupComponent> getFareBreakupListFromJson(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int i = 0;
        int length = jSONArray.length();
        if (length > 0) {
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("name");
                n86.d(string, "lFareBreakupComponentObj…ConfigConstants.KEY_NAME)");
                String string2 = jSONObject.getString(FirebaseAnalytics.Param.VALUE);
                n86.d(string2, "lFareBreakupComponentObj…onfigConstants.KEY_VALUE)");
                arrayList.add(new FareBreakupComponent(string, string2));
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    private final boolean isProductTypeAndSubTypeValid(JSONObject jSONObject) {
        return (jSONObject != null && jSONObject.has("productType")) && jSONObject.has("productSubType") && n86.a(jSONObject.get("productType"), SuperPassConstants.PRODUCT_TYPE_SUPER_PASS) && (n86.a(jSONObject.get("productSubType"), "magicPass") || n86.a(jSONObject.get("productSubType"), SuperPassConstants.SUBTYPE_RIDE_PASS));
    }

    private final CashPaymentPendingTransactionDetails parseCashPaymentPendingTransactionDetails(JSONObject jSONObject) {
        if (!n86.a(jSONObject.optString("paymentMode"), SuperPassPaymentConstants.PAYMENT_MODE_CASH)) {
            return null;
        }
        double d = jSONObject.getDouble(SuperPassJsonKeys.PASS_FARE);
        String string = jSONObject.getString(SuperPassJsonKeys.REFERENCE_ID);
        n86.d(string, "lReferenceId");
        return new CashPaymentPendingTransactionDetails(d, string);
    }

    private final FareInfo parseFareInfo(JSONObject jSONObject) {
        return new FareInfo(jSONObject.getDouble("payableAmount"), jSONObject.getDouble("actualFare"), jSONObject.optBoolean("isDiscountApplicable", false), jSONObject.optDouble("discountedFare", -1.0d), getFareBreakupListFromJson(jSONObject.optJSONArray("fareBreakup")));
    }

    private final MagicSuperPass parseMagicSuperPass(JSONObject jSONObject) {
        SuperPassProperties parseSuperPassProperties = parseSuperPassProperties(jSONObject);
        return new MagicSuperPass(parseSuperPassProperties, parseSuperPassValidationProperties(jSONObject, parseSuperPassProperties.getPassId()), parseSuperPassUIProperties(jSONObject), parseSuperPassRepurchaseProperties(jSONObject), parseSuperPassTransactionDetails(jSONObject));
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x00f2 A[EDGE_INSN: B:102:0x00f2->B:50:0x00f2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x018e A[EDGE_INSN: B:104:0x018e->B:92:0x018e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d9 A[LOOP:0: B:8:0x003c->B:48:0x00d9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0181 A[LOOP:2: B:54:0x00fb->B:90:0x0181, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final app.zophop.models.mTicketing.PassApplicationRejectionReasons parsePassApplicationRejectionReasons(org.json.JSONObject r22) {
        /*
        // Method dump skipped, instructions count: 442
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.models.mTicketing.superPass.SuperPassJsonParser.parsePassApplicationRejectionReasons(org.json.JSONObject):app.zophop.models.mTicketing.PassApplicationRejectionReasons");
    }

    private final PendingSuperPass parsePendingSuperPass(JSONObject jSONObject) {
        return new PendingSuperPass(parsePendingSuperPassProperties(jSONObject), parsePendingSuperPassUIProperties(jSONObject), parsePendingSuperPassRepurchaseProperties(jSONObject), parsePendingSuperPassTransactionDetails(jSONObject));
    }

    private final PendingSuperPassProperties parsePendingSuperPassProperties(JSONObject jSONObject) {
        SuperPassStatus superPassStatus;
        String string = jSONObject.getString("passId");
        String string2 = jSONObject.getString("productType");
        SuperPassSubType.Companion companion = SuperPassSubType.Companion;
        String string3 = jSONObject.getString("productSubType");
        n86.d(string3, "jsonObject.getString(Sup…sonKeys.PRODUCT_SUB_TYPE)");
        SuperPassSubType fromString = companion.fromString(string3);
        String string4 = jSONObject.getString("city");
        n86.d(string4, "jsonObject.getString(SuperPassJsonKeys.CITY)");
        String lowerCase = string4.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        String string5 = jSONObject.getString("agency");
        if (n86.a(jSONObject.getString("status"), "FAILED")) {
            superPassStatus = SuperPassStatus.PAYMENT_FAILED;
        } else {
            superPassStatus = SuperPassStatus.PAYMENT_PROCESSING;
        }
        n86.d(string, "lPassId");
        n86.d(string2, "lPassType");
        n86.d(string5, "lAgency");
        return new PendingSuperPassProperties(string, string2, fromString, lowerCase, string5, superPassStatus);
    }

    private final PendingSuperPassRepurchaseProperties parsePendingSuperPassRepurchaseProperties(JSONObject jSONObject) {
        String string = jSONObject.getString(SuperPassJsonKeys.CONFIGURATION_ID);
        String string2 = jSONObject.getString(SuperPassJsonKeys.CATEGORY_ID);
        int i = jSONObject.getInt(SuperPassJsonKeys.FARE_MAPPING_ID);
        long j = jSONObject.getLong(SuperPassJsonKeys.START_TIME);
        long j2 = jSONObject.getLong(SuperPassJsonKeys.VERIFICATION_EXPIRY_TIME);
        boolean z = jSONObject.getBoolean(SuperPassJsonKeys.VERIFICATION_FLAG);
        n86.d(string, "lConfigId");
        n86.d(string2, "lCategoryId");
        return new PendingSuperPassRepurchaseProperties(string, string2, i, j, j2, z);
    }

    private final PendingSuperPassTransactionDetails parsePendingSuperPassTransactionDetails(JSONObject jSONObject) {
        String string = jSONObject.getString("transactionId");
        String string2 = jSONObject.getString("paymentMode");
        String optString = jSONObject.optString(SuperPassJsonKeys.ORDER_ID);
        n86.d(string2, "lPaymentMode");
        n86.d(string, "lTransactionId");
        return new PendingSuperPassTransactionDetails(string2, string, optString);
    }

    private final PendingSuperPassUIProperties parsePendingSuperPassUIProperties(JSONObject jSONObject) {
        int i = jSONObject.getInt(SuperPassJsonKeys.NUM_OF_DAYS);
        List list = (List) new Gson().fromJson(jSONObject.getString("specialFeatures"), new SuperPassJsonParser$parsePendingSuperPassUIProperties$lListType$1().getType());
        JSONObject jSONObject2 = jSONObject.getJSONObject(SuperPassJsonKeys.USER_PROFILE);
        n86.d(jSONObject2, "jsonObject.getJSONObject…assJsonKeys.USER_PROFILE)");
        SuperPassUserDetails parseSuperPassUserDetails = parseSuperPassUserDetails(jSONObject2);
        JSONObject jSONObject3 = jSONObject.getJSONObject(SuperPassJsonKeys.PROOFS);
        n86.d(jSONObject3, "jsonObject.getJSONObject(SuperPassJsonKeys.PROOFS)");
        Map<String, SuperPassProofProperties> parseSuperPassProofs = parseSuperPassProofs(jSONObject3);
        long j = jSONObject.getLong("bookingTime");
        JSONObject jSONObject4 = jSONObject.getJSONObject(SuperPassJsonKeys.KEY_FARE_INFO);
        n86.d(jSONObject4, "jsonObject.getJSONObject…ssJsonKeys.KEY_FARE_INFO)");
        FareInfo parseFareInfo = parseFareInfo(jSONObject4);
        double optDouble = jSONObject.optDouble(SuperPassJsonKeys.MAX_PRICE_PER_TRIP, -1.0d);
        String string = jSONObject.getString("productName");
        String string2 = jSONObject.getString(SuperPassJsonKeys.CATEGORY_NAME);
        ProductBranding productBranding = new ProductBranding(jSONObject.getJSONObject("branding").getBoolean("isVisible"));
        String string3 = jSONObject.getString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME);
        String optString = jSONObject.optString(SuperPassJsonKeys.FARE_MAPPING_DESCRIPTION);
        n86.d(list, "lSpecialFeatures");
        n86.d(string, "lPassName");
        n86.d(string2, "lCategoryName");
        n86.d(string3, "lFareMappingDisplayName");
        return new PendingSuperPassUIProperties(i, list, parseSuperPassUserDetails, parseSuperPassProofs, j, parseFareInfo, string, string2, productBranding, string3, optDouble, optString);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object parseRideBasedSuperPass(org.json.JSONObject r8, defpackage.k66<? super app.zophop.models.mTicketing.superPass.RideBasedSuperPass> r9) {
        /*
        // Method dump skipped, instructions count: 113
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.models.mTicketing.superPass.SuperPassJsonParser.parseRideBasedSuperPass(org.json.JSONObject, k66):java.lang.Object");
    }

    private final RideBasedSuperPassUIProperties parseRideBasedSuperPassUIProperties(JSONObject jSONObject) {
        int i = jSONObject.getInt(SuperPassJsonKeys.NUM_OF_DAYS);
        List list = (List) new Gson().fromJson(jSONObject.getString("specialFeatures"), new SuperPassJsonParser$parseRideBasedSuperPassUIProperties$lListType$1().getType());
        JSONObject jSONObject2 = jSONObject.getJSONObject(SuperPassJsonKeys.USER_PROFILE);
        n86.d(jSONObject2, "jsonObject.getJSONObject…assJsonKeys.USER_PROFILE)");
        SuperPassUserDetails parseSuperPassUserDetails = parseSuperPassUserDetails(jSONObject2);
        JSONObject jSONObject3 = jSONObject.getJSONObject(SuperPassJsonKeys.PROOFS);
        n86.d(jSONObject3, "jsonObject.getJSONObject(SuperPassJsonKeys.PROOFS)");
        Map<String, SuperPassProofProperties> parseSuperPassProofs = parseSuperPassProofs(jSONObject3);
        long j = jSONObject.getLong("bookingTime");
        JSONObject jSONObject4 = jSONObject.getJSONObject(SuperPassJsonKeys.KEY_FARE_INFO);
        n86.d(jSONObject4, "jsonObject.getJSONObject…ssJsonKeys.KEY_FARE_INFO)");
        FareInfo parseFareInfo = parseFareInfo(jSONObject4);
        double d = jSONObject.getDouble(SuperPassJsonKeys.MAX_PRICE_PER_TRIP);
        String string = jSONObject.getString("productName");
        String string2 = jSONObject.getString(SuperPassJsonKeys.CATEGORY_NAME);
        ProductBranding productBranding = new ProductBranding(jSONObject.getJSONObject("branding").getBoolean("isVisible"));
        String string3 = jSONObject.getString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME);
        String optString = jSONObject.optString(SuperPassJsonKeys.FARE_MAPPING_DESCRIPTION, "");
        n86.d(list, "lSpecialFeatures");
        n86.d(string, "lPassName");
        n86.d(string2, "lCategoryName");
        n86.d(string3, "lFareMappingDisplayName");
        n86.d(optString, "lFareMappingDescription");
        return new RideBasedSuperPassUIProperties(i, list, parseSuperPassUserDetails, parseSuperPassProofs, j, parseFareInfo, d, string, string2, productBranding, string3, optString);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object parseRideBasedSuperPassValidationProperties(org.json.JSONObject r35, java.lang.String r36, defpackage.k66<? super app.zophop.models.mTicketing.superPass.RideBasedSuperPassValidationProperties> r37) {
        /*
        // Method dump skipped, instructions count: 861
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.models.mTicketing.superPass.SuperPassJsonParser.parseRideBasedSuperPassValidationProperties(org.json.JSONObject, java.lang.String, k66):java.lang.Object");
    }

    private final SuperPassApplication parseSuperPassApplication(JSONObject jSONObject) {
        String string = jSONObject.getString("city");
        n86.d(string, "jsonObject.getString(SuperPassJsonKeys.CITY)");
        String lowerCase = string.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        String string2 = jSONObject.getString("agency");
        String string3 = jSONObject.getString(SuperPassJsonKeys.CONFIGURATION_ID);
        String string4 = jSONObject.getString(SuperPassJsonKeys.CATEGORY_ID);
        int i = jSONObject.getInt(SuperPassJsonKeys.FARE_MAPPING_ID);
        String string5 = jSONObject.getString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME);
        String string6 = jSONObject.getString("productName");
        long j = jSONObject.getLong(SuperPassJsonKeys.PASS_START_DATE);
        long j2 = jSONObject.getLong(SuperPassJsonKeys.VERIFICATION_EXPIRY_TIME);
        JSONObject jSONObject2 = jSONObject.getJSONObject(SuperPassJsonKeys.USER_PROFILE);
        n86.d(jSONObject2, "jsonObject.getJSONObject…assJsonKeys.USER_PROFILE)");
        SuperPassUserDetails parseSuperPassUserDetails = parseSuperPassUserDetails(jSONObject2);
        String string7 = jSONObject.getString("status");
        n86.d(string7, "jsonObject.getString(SuperPassJsonKeys.STATUS)");
        String upperCase = string7.toUpperCase();
        n86.d(upperCase, "(this as java.lang.String).toUpperCase()");
        SuperPassApplicationStatus valueOf = SuperPassApplicationStatus.valueOf(upperCase);
        JSONObject jSONObject3 = jSONObject.getJSONObject(SuperPassJsonKeys.PROOFS);
        n86.d(jSONObject3, "jsonObject.getJSONObject(SuperPassJsonKeys.PROOFS)");
        Map<String, SuperPassProofProperties> parseSuperPassProofs = parseSuperPassProofs(jSONObject3);
        PassApplicationRejectionReasons parsePassApplicationRejectionReasons = parsePassApplicationRejectionReasons(jSONObject.optJSONObject(SuperPassJsonKeys.REJECTION_REASONS));
        String optString = jSONObject.optString(SuperPassJsonKeys.ACTION_REQUIRED, CardValidityCheckEvent.VALIDITY_STATUS_INVALID);
        n86.d(optString, "jsonObject.optString(\n  …  \"INVALID\"\n            )");
        PassApplicationActionRequired valueOf2 = PassApplicationActionRequired.valueOf(optString);
        CashPaymentPendingTransactionDetails parseCashPaymentPendingTransactionDetails = parseCashPaymentPendingTransactionDetails(jSONObject);
        n86.d(string2, "lAgency");
        n86.d(string3, "lConfigId");
        n86.d(string4, "lCategoryId");
        n86.d(string5, "lFareMappingDisplayName");
        n86.d(string6, "lPassName");
        return new SuperPassApplication(lowerCase, string2, string3, string4, i, string5, string6, j, j2, parseSuperPassUserDetails, valueOf, parseSuperPassProofs, parseCashPaymentPendingTransactionDetails, parsePassApplicationRejectionReasons, valueOf2);
    }

    private final Map<String, SuperPassProofProperties> parseSuperPassProofs(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        n86.d(keys, "jsonObject.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            String string = jSONObject2.getString(SuperPassJsonKeys.PROOF_NAME);
            String string2 = jSONObject2.getString(SuperPassJsonKeys.PROOF_URL);
            n86.d(string, "lProofName");
            n86.d(string2, "lProofUrl");
            hashMap.put(next, new SuperPassProofProperties(string, string2));
        }
        return hashMap;
    }

    private final SuperPassProperties parseSuperPassProperties(JSONObject jSONObject) {
        String string = jSONObject.getString("passId");
        String string2 = jSONObject.getString("productType");
        SuperPassSubType.Companion companion = SuperPassSubType.Companion;
        String string3 = jSONObject.getString("productSubType");
        n86.d(string3, "jsonObject.getString(Sup…sonKeys.PRODUCT_SUB_TYPE)");
        SuperPassSubType fromString = companion.fromString(string3);
        String string4 = jSONObject.getString("city");
        n86.d(string4, "jsonObject.getString(SuperPassJsonKeys.CITY)");
        String lowerCase = string4.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        String string5 = jSONObject.getString("agency");
        String string6 = jSONObject.getString(SuperPassJsonKeys.QR_CODE);
        String string7 = jSONObject.has(SuperPassJsonKeys.TONE) ? jSONObject.getString(SuperPassJsonKeys.TONE) : null;
        n86.d(string, "lPassId");
        n86.d(string2, "lPassType");
        n86.d(string5, "lAgency");
        n86.d(string6, "lQrCode");
        return new SuperPassProperties(string, string2, fromString, lowerCase, string5, string6, string7);
    }

    private final SuperPassRepurchaseProperties parseSuperPassRepurchaseProperties(JSONObject jSONObject) {
        String string = jSONObject.getString(SuperPassJsonKeys.CONFIGURATION_ID);
        String string2 = jSONObject.getString(SuperPassJsonKeys.CATEGORY_ID);
        int i = jSONObject.getInt(SuperPassJsonKeys.FARE_MAPPING_ID);
        long j = jSONObject.getLong(SuperPassJsonKeys.VERIFICATION_EXPIRY_TIME);
        boolean z = jSONObject.getBoolean(SuperPassJsonKeys.VERIFICATION_FLAG);
        boolean z2 = jSONObject.getBoolean(SuperPassJsonKeys.IS_RENEWABLE);
        n86.d(string, "lConfigId");
        n86.d(string2, "lCategoryId");
        return new SuperPassRepurchaseProperties(string, string2, i, j, z, z2);
    }

    private final SuperPassTransactionDetails parseSuperPassTransactionDetails(JSONObject jSONObject) {
        String string = jSONObject.getString("transactionId");
        String string2 = jSONObject.getString("paymentMode");
        n86.d(string, "lTransactionId");
        n86.d(string2, "lPaymentMode");
        return new SuperPassTransactionDetails(string, string2);
    }

    private final SuperPassUIProperties parseSuperPassUIProperties(JSONObject jSONObject) {
        int i = jSONObject.getInt(SuperPassJsonKeys.NUM_OF_DAYS);
        List list = (List) new Gson().fromJson(jSONObject.getString("specialFeatures"), new SuperPassJsonParser$parseSuperPassUIProperties$lListType$1().getType());
        JSONObject jSONObject2 = jSONObject.getJSONObject(SuperPassJsonKeys.USER_PROFILE);
        n86.d(jSONObject2, "jsonObject.getJSONObject…assJsonKeys.USER_PROFILE)");
        SuperPassUserDetails parseSuperPassUserDetails = parseSuperPassUserDetails(jSONObject2);
        JSONObject jSONObject3 = jSONObject.getJSONObject(SuperPassJsonKeys.PROOFS);
        n86.d(jSONObject3, "jsonObject.getJSONObject(SuperPassJsonKeys.PROOFS)");
        Map<String, SuperPassProofProperties> parseSuperPassProofs = parseSuperPassProofs(jSONObject3);
        long j = jSONObject.getLong("bookingTime");
        JSONObject jSONObject4 = jSONObject.getJSONObject(SuperPassJsonKeys.KEY_FARE_INFO);
        n86.d(jSONObject4, "jsonObject.getJSONObject…ssJsonKeys.KEY_FARE_INFO)");
        FareInfo parseFareInfo = parseFareInfo(jSONObject4);
        String string = jSONObject.getString("productName");
        String string2 = jSONObject.getString(SuperPassJsonKeys.CATEGORY_NAME);
        ProductBranding productBranding = new ProductBranding(jSONObject.getJSONObject("branding").getBoolean("isVisible"));
        String string3 = jSONObject.getString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME);
        n86.d(list, "lSpecialFeatures");
        n86.d(string, "lPassName");
        n86.d(string2, "lCategoryName");
        n86.d(string3, "lFareMappingDisplayName");
        return new SuperPassUIProperties(i, list, parseSuperPassUserDetails, parseSuperPassProofs, j, parseFareInfo, string, string2, productBranding, string3);
    }

    private final SuperPassUserDetails parseSuperPassUserDetails(JSONObject jSONObject) {
        String string = jSONObject.getString("userId");
        String string2 = jSONObject.getString(SuperPassJsonKeys.MOBILE_NUMBER);
        String str = jSONObject.getString(SuperPassJsonKeys.FIRST_NAME) + ' ' + ((Object) jSONObject.getString(SuperPassJsonKeys.LAST_NAME));
        Gender fromString = Gender.Companion.fromString(jSONObject.getString(SuperPassJsonKeys.GENDER));
        String string3 = jSONObject.getString(SuperPassJsonKeys.DATE_OF_BIRTH);
        String string4 = jSONObject.getString(SuperPassJsonKeys.MAIL_ID);
        String optString = jSONObject.optString(SuperPassJsonKeys.PROFILE_PHOTO, "");
        n86.d(string, "lUserId");
        n86.d(string2, "lMobileNumber");
        n86.d(string3, "lDateOfBirth");
        n86.d(string4, "lMailId");
        n86.d(optString, "lProfilePhoto");
        return new SuperPassUserDetails(string, string2, str, fromString, string3, string4, optString);
    }

    private final SuperPassValidationProperties parseSuperPassValidationProperties(JSONObject jSONObject, String str) {
        long j;
        String string = jSONObject.getString("status");
        n86.d(string, "jsonObject.getString(SuperPassJsonKeys.STATUS)");
        SuperPassStatus valueOf = SuperPassStatus.valueOf(string);
        long j2 = jSONObject.getLong(SuperPassJsonKeys.START_TIME);
        long j3 = jSONObject.getLong(SuperPassJsonKeys.EXPIRY_TIME);
        long j4 = jSONObject.getLong(SuperPassJsonKeys.ACTIVE_DURATION);
        JSONArray jSONArray = jSONObject.getJSONArray(SuperPassJsonKeys.PUNCHES);
        int length = jSONArray.length();
        long j5 = -1;
        if (length > 0) {
            int i = 0;
            j = -1;
            while (true) {
                int i2 = i + 1;
                long j6 = jSONArray.getJSONObject(i).getLong(SuperPassJsonKeys.PUNCHING_TIME);
                if (j6 > j) {
                    j = j6;
                }
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        } else {
            j = -1;
        }
        String optString = xt.f3961a.d0().h.optString(str, null);
        if (optString != null) {
            j5 = Long.parseLong(optString);
        }
        return new SuperPassValidationProperties(valueOf, j2, j3, j4, new SuperPassRideDetails(j5, j));
    }

    public final List<SuperPassApplication> parsePassApplicationsArray(JSONArray jSONArray) {
        n86.e(jSONArray, "lSuperPassApplications");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                n86.d(jSONObject, "lSuperPassApplications.getJSONObject(i)");
                if (isProductTypeAndSubTypeValid(jSONObject)) {
                    arrayList.add(parseSuperPassApplication(jSONObject));
                }
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b9  */
    public final java.lang.Object parsePassesArray(org.json.JSONArray r12, defpackage.k66<? super defpackage.m56<? extends java.util.List<app.zophop.models.mTicketing.superPass.MagicSuperPass>, ? extends java.util.List<app.zophop.models.mTicketing.superPass.RideBasedSuperPass>>> r13) {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.models.mTicketing.superPass.SuperPassJsonParser.parsePassesArray(org.json.JSONArray, k66):java.lang.Object");
    }

    public final List<PendingSuperPass> parseRecentTransactionsArray(JSONArray jSONArray) {
        n86.e(jSONArray, "lRecentTransactionArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                n86.d(jSONObject, "lRecentTransactionArray.getJSONObject(i)");
                if (isProductTypeAndSubTypeValid(jSONObject)) {
                    arrayList.add(parsePendingSuperPass(jSONObject));
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
