package defpackage;

import android.text.TextUtils;
import app.zophop.models.CardInfo;
import app.zophop.models.ScanPayBookingDetails;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.BasicProfileFields;
import app.zophop.models.mTicketing.BookingPass;
import app.zophop.models.mTicketing.BookingPassRouteInfo;
import app.zophop.models.mTicketing.BookingPassType;
import app.zophop.models.mTicketing.BookingTransaction;
import app.zophop.models.mTicketing.Gender;
import app.zophop.models.mTicketing.GroupTicket;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.MTicketConfiguration;
import app.zophop.models.mTicketing.MTicketPassengerInfo;
import app.zophop.models.mTicketing.MTicketTripReceipt;
import app.zophop.models.mTicketing.MagicPassPunchInfo;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.models.mTicketing.PassApplicationRejectionReasons;
import app.zophop.models.mTicketing.PassengerType;
import app.zophop.models.mTicketing.ProductBranding;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductDisplayProps;
import app.zophop.models.mTicketing.ProductDuration;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.ProductSubCategory;
import app.zophop.models.mTicketing.ProfileRejectionReason;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.models.mTicketing.ProofRejectionReason;
import app.zophop.models.mTicketing.ProofUploadDocumentPropsIdentifier;
import app.zophop.models.mTicketing.PunchInfo;
import app.zophop.models.mTicketing.RejectionStatus;
import app.zophop.models.mTicketing.RouteStopsInfo;
import app.zophop.models.mTicketing.SingleTicket;
import app.zophop.models.mTicketing.SubCategorySelectionDetails;
import app.zophop.models.mTicketing.TicketStatus;
import app.zophop.models.mTicketing.UserAgencyInfo;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.CardValidityCheckEvent;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import defpackage.ut;
import defpackage.xt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.Constants;
import server.zophop.logging.LoggingConstants;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: ov  reason: default package */
/* compiled from: MobileTicketingConverters */
public class ov {
    public static MPass D(String str, UserProfile userProfile) {
        String str2 = "magicPass";
        try {
            JSONObject jSONObject = new JSONObject(str);
            long j = jSONObject.getLong(SuperPassJsonKeys.PASS_START_DATE);
            int i = jSONObject.getInt(SuperPassJsonKeys.PASS_FARE);
            long optLong = jSONObject.optLong("bookingTime", ui1.Q());
            int optInt = jSONObject.optInt(SuperPassJsonKeys.NUM_OF_DAYS, 30);
            String optString = jSONObject.optString("reason", "Documents Invalid");
            String optString2 = jSONObject.optString("passengerType", PassengerType.GENERAL_PASSENGER.toString());
            String optString3 = jSONObject.optString("city", xt.f3961a.k().d().getName());
            String optString4 = jSONObject.optString("productId");
            Map<String, String> hashMap = new HashMap<>();
            if (jSONObject.has(SuperPassJsonKeys.PROOFS)) {
                hashMap = s(jSONObject.getString(SuperPassJsonKeys.PROOFS));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("specialFeatures");
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < optJSONArray.length()) {
                arrayList.add(optJSONArray.optString(i2, null));
                i2++;
                str2 = str2;
            }
            PassApplicationRejectionReasons u = u(jSONObject.optJSONObject(SuperPassJsonKeys.REJECTION_REASONS));
            PassApplicationActionRequired valueOf = PassApplicationActionRequired.valueOf(jSONObject.optString(SuperPassJsonKeys.ACTION_REQUIRED, CardValidityCheckEvent.VALIDITY_STATUS_INVALID).toUpperCase());
            MPass mPass = new MPass(userProfile, optString2, ui1.s(xt.f3961a.k().d()), (double) i, optInt);
            mPass.setStartingTime(j);
            mPass.setBookingTime(optLong);
            mPass.setDisplayProps(hashMap);
            mPass.setPassRejectionReason(optString);
            mPass.set_passApplicationRejectionReasons(u);
            mPass.set_passApplicationActionRequired(valueOf);
            mPass.setCity(optString3);
            mPass.setConfigId(optString4);
            if (jSONObject.has(SuperPassJsonKeys.VERIFICATION_FLAG)) {
                mPass.set_isVerificationRequired(jSONObject.getBoolean(SuperPassJsonKeys.VERIFICATION_FLAG));
            } else {
                mPass.set_isVerificationRequired(true);
            }
            mPass.setSpecialFeatures(arrayList);
            if ("superSaver".equalsIgnoreCase(jSONObject.optString("passType", str2))) {
                mPass.set_productType("superSaver");
            } else {
                mPass.set_productType(str2);
            }
            mPass.setStatus(jSONObject.getString("status"));
            return mPass;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r7v8. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    public static UserProfile H(String str) {
        UserProfile userProfile;
        JSONException e;
        Exception e2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("userId");
            String string2 = jSONObject.getString(SuperPassJsonKeys.FIRST_NAME);
            String string3 = jSONObject.getString(SuperPassJsonKeys.LAST_NAME);
            Gender fromString = Gender.fromString(jSONObject.getString(SuperPassJsonKeys.GENDER));
            String string4 = jSONObject.getString(SuperPassJsonKeys.DATE_OF_BIRTH);
            String optString = jSONObject.optString(SuperPassJsonKeys.MAIL_ID);
            String string5 = jSONObject.getString(SuperPassJsonKeys.MOBILE_NUMBER);
            String optString2 = jSONObject.optString(SuperPassJsonKeys.PROFILE_PHOTO, null);
            HashMap hashMap = new HashMap();
            if (jSONObject.has("agencies")) {
                JSONArray jSONArray = jSONObject.getJSONArray("agencies");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string6 = jSONObject2.getString("agency");
                    String string7 = jSONObject2.getString("passengerType");
                    String string8 = jSONObject2.getString("city");
                    Map hashMap2 = new HashMap();
                    Map hashMap3 = new HashMap();
                    if (jSONObject2.has(SuperPassJsonKeys.PROOFS)) {
                        hashMap2 = s(jSONObject2.getString(SuperPassJsonKeys.PROOFS));
                    }
                    hashMap.put(string6, new UserAgencyInfo(jSONObject2.has("addFields") ? s(jSONObject2.getString("addFields")) : hashMap3, hashMap2, UserAgencyInfo.STATUS.valueOf(jSONObject2.getString("status")), string6, string8, string7));
                }
            }
            userProfile = new UserProfile(string2, string3, fromString, string4, optString, string5, optString2, hashMap);
            try {
                userProfile.setUserId(string);
            } catch (JSONException e3) {
                e = e3;
            } catch (Exception e4) {
                e2 = e4;
                b00 b00 = b00.f358a;
                b00.a().b(e2);
                return userProfile;
            }
        } catch (JSONException e5) {
            e = e5;
            userProfile = null;
            e.printStackTrace();
            b00 b002 = b00.f358a;
            hj1.W0(e);
            return userProfile;
        } catch (Exception e6) {
            e2 = e6;
            userProfile = null;
            b00 b003 = b00.f358a;
            b00.a().b(e2);
            return userProfile;
        }
        return userProfile;
    }

    public static MPass I(String str, UserProfile userProfile) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            long j = jSONObject.getLong(SuperPassJsonKeys.PASS_START_DATE);
            int i = jSONObject.getInt(SuperPassJsonKeys.PASS_FARE);
            String optString = jSONObject.optString("productId");
            int optInt = jSONObject.optInt(SuperPassJsonKeys.NUM_OF_DAYS, 30);
            String optString2 = jSONObject.optString("passengerType", PassengerType.GENERAL_PASSENGER.toString());
            String optString3 = jSONObject.optString("city", xt.f3961a.k().d().getName());
            JSONArray optJSONArray = jSONObject.optJSONArray("specialFeatures");
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                arrayList.add(optJSONArray.optString(i2, null));
            }
            Map<String, String> hashMap = new HashMap<>();
            if (jSONObject.has(SuperPassJsonKeys.PROOFS)) {
                hashMap = s(jSONObject.getString(SuperPassJsonKeys.PROOFS));
            }
            MPass mPass = new MPass(userProfile, optString2, ui1.s(xt.f3961a.k().d()), (double) i, optInt);
            mPass.setStartingTime(j);
            mPass.setStatus("VERIFIED");
            mPass.setDisplayProps(hashMap);
            mPass.setCity(optString3);
            mPass.setConfigId(optString);
            mPass.setSpecialFeatures(arrayList);
            if ("superSaver".equalsIgnoreCase(jSONObject.optString("passType", "magicPass"))) {
                mPass.set_productType("superSaver");
            } else {
                mPass.set_productType("magicPass");
            }
            return mPass;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String f(MPass mPass) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            if (mPass.getUserProfile() != null) {
                jSONObject.put(SuperPassJsonKeys.USER_PROFILE, l(mPass.getUserProfile()));
            }
            JSONArray jSONArray = new JSONArray();
            if (mPass.getSpecialFeatures() != null) {
                for (int i = 0; i < mPass.getSpecialFeatures().size(); i++) {
                    jSONArray.put(mPass.getSpecialFeatures().get(i));
                }
            }
            if (!(mPass.getRouteStopsInfo() == null || mPass.getRouteStopsInfo().get_spf() == null)) {
                for (int i2 = 0; i2 < mPass.getRouteStopsInfo().get_spf().size(); i2++) {
                    jSONArray.put(mPass.getRouteStopsInfo().get_spf().get(i2));
                }
            }
            if (mPass.getRouteStopsInfo() != null) {
                jSONObject.put(LoggingConstants.ROUTE_ID, mPass.getRouteStopsInfo().getRouteId());
                jSONObject.put("routeName", mPass.getRouteStopsInfo().getRouteName());
                jSONObject.put("startStopId", mPass.getRouteStopsInfo().getStartStopId());
                jSONObject.put(Constants.START_STOP_NAME, mPass.getRouteStopsInfo().getStartStopName());
                jSONObject.put("endStopId", mPass.getRouteStopsInfo().getEndStopId());
                jSONObject.put(Constants.END_STOP_STOP_NAME, mPass.getRouteStopsInfo().getEndStopName());
            }
            jSONObject.put("specialFeatures", jSONArray);
            jSONObject.put(SuperPassJsonKeys.CONFIGURATION_ID, mPass.getConfigId());
            jSONObject.put(SuperPassJsonKeys.VERIFICATION_EXPIRY_TIME, mPass.getVerificationExpiryTime());
            jSONObject.put("passId", mPass.getBookingPassId());
            jSONObject.put("bookingTime", mPass.getBookingTime());
            jSONObject.put(SuperPassJsonKeys.EXPIRY_TIME, mPass.getExpiryTime());
            jSONObject.put(SuperPassJsonKeys.START_TIME, mPass.getStartingTime());
            jSONObject.put("city", mPass.getCity());
            jSONObject.put("id", mPass.getConfigId());
            jSONObject.put(SuperPassJsonKeys.ORDER_ID, mPass.getOrderId());
            jSONObject.put("reason", mPass.getPassRejectionReason());
            try {
                obj = new JSONObject(new Gson().toJson(mPass.get_passApplicationRejectionReasons()));
            } catch (JSONException e) {
                e.printStackTrace();
                obj = new JSONObject();
            }
            jSONObject.put(SuperPassJsonKeys.REJECTION_REASONS, obj);
            jSONObject.put(SuperPassJsonKeys.ACTION_REQUIRED, mPass.get_passApplicationActionRequired().toString());
            jSONObject.put(SuperPassJsonKeys.REFERENCE_ID, mPass.getReferenceId());
            jSONObject.put("status", mPass.getStatus());
            jSONObject.put("passengerType", mPass.getPassengerType());
            jSONObject.put("agency", mPass.getAgency());
            jSONObject.put("displayProps", g(mPass.getDisplayProps()));
            jSONObject.put(SuperPassJsonKeys.QR_CODE, mPass.getQrCode());
            jSONObject.put(SuperPassJsonKeys.NUM_OF_DAYS, mPass.getNoOfDays());
            jSONObject.put(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, mPass.get_productName());
            jSONObject.put(SuperPassJsonKeys.FARE, mPass.getFare());
            jSONObject.put("paymentMode", mPass.getPaymentMode());
            jSONObject.put("remainingTrips", mPass.get_remainingTrips());
            jSONObject.put("isExpired", mPass.isPassExpired());
            if (mPass.is_isVerificationRequired()) {
                jSONObject.put(SuperPassJsonKeys.VERIFICATION_FLAG, mPass.is_isVerificationRequired());
            }
            if (!TextUtils.isEmpty(mPass.getStatus())) {
                jSONObject.put("status", mPass.getStatus());
            }
            JSONArray jSONArray2 = new JSONArray();
            if (mPass.getPunches() != null) {
                for (int i3 = 0; i3 < mPass.getPunches().size(); i3++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(SuperPassJsonKeys.PUNCHING_TIME, mPass.getPunches().get(i3).getPunchingTime());
                    jSONArray2.put(i3, jSONObject2);
                }
            }
            if (mPass.get_productType() != null) {
                jSONObject.put("productType", mPass.get_productType());
            }
            if (mPass.get_grouping() != null) {
                jSONObject.put("grouping", i(mPass.get_grouping()));
            }
            if (mPass.get_remainingTrips() != -1) {
                jSONObject.put("remainingTrips", mPass.get_remainingTrips());
            }
            jSONObject.put("category", mPass.get_productCategory());
            jSONObject.put(SuperPassJsonKeys.PUNCHES, jSONArray2);
            jSONObject.put("deviceId", mPass.getDeviceId());
            jSONObject.put(SuperPassJsonKeys.NUM_OF_TRIPS, mPass.get_maxTrips());
            jSONObject.put(SuperPassJsonKeys.MAX_TRIPS_PER_DAY, mPass.get_maxTripsPerDay());
            jSONObject.put("catDisName", mPass.get_catDisName());
            jSONObject.put(SuperPassJsonKeys.MAX_PRICE_PER_TRIP, mPass.get_maxTripsPrice());
            jSONObject.toString();
            return jSONObject.toString();
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            hj1.W0(e2);
            return null;
        }
    }

    public static String g(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
            e.printStackTrace();
            return null;
        }
    }

    public static String i(ProductCategory productCategory) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", productCategory.getCategoryId());
            jSONObject.put("name", productCategory.get_categoryName());
            jSONObject.put("displayorder", productCategory.get_displayOrder());
            List<String> categoryProofsList = productCategory.getCategoryProofsList();
            JSONArray jSONArray = new JSONArray();
            if (categoryProofsList != null) {
                for (int i = 0; i < categoryProofsList.size(); i++) {
                    jSONArray.put(i, categoryProofsList.get(i));
                }
            }
            jSONObject.put(SuperPassJsonKeys.PROOFS, jSONArray);
            jSONObject.put("isActive", productCategory.isCategoryActive());
            jSONObject.put(SuperPassJsonKeys.IS_RENEWABLE, productCategory.isCategoryIsRenewable());
            jSONObject.put("documentsDesc", productCategory.getDocumentDescription());
            jSONObject.put("verification", productCategory.isCategoryVerificationRequired());
            jSONObject.put("info", productCategory.getCategoryInfo());
            jSONObject.put("maxIssueCount", productCategory.getCategoryMaxIssueCount());
            jSONObject.put("inactiveReason", productCategory.getInactiveReason());
            jSONObject.put(SuperPassJsonKeys.MAX_PRICE_PER_TRIP, productCategory.get_maxPricePerRide());
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.X0(e, b00.a());
        }
        return jSONObject.toString();
    }

    public static String l(UserProfile userProfile) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", userProfile.getUserId());
            jSONObject.put(SuperPassJsonKeys.FIRST_NAME, userProfile.getFirstName());
            jSONObject.put(SuperPassJsonKeys.LAST_NAME, userProfile.getLastName());
            jSONObject.put(SuperPassJsonKeys.GENDER, userProfile.getGender().toString());
            jSONObject.put(SuperPassJsonKeys.DATE_OF_BIRTH, userProfile.getDateOfBirth());
            if (!TextUtils.isEmpty(userProfile.getEmailId())) {
                jSONObject.put(SuperPassJsonKeys.MAIL_ID, userProfile.getEmailId());
            }
            jSONObject.put(SuperPassJsonKeys.MOBILE_NUMBER, userProfile.getPhone());
            jSONObject.put(SuperPassJsonKeys.PROFILE_PHOTO, userProfile.getProfilePhoto());
            JSONArray jSONArray = new JSONArray();
            for (UserAgencyInfo userAgencyInfo : userProfile.getAgencyInfo().values()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("status", userAgencyInfo.getStatus());
                jSONObject2.put(SuperPassJsonKeys.PROOFS, g(userAgencyInfo.getProofs()));
                jSONObject2.put("addFields", g(userAgencyInfo.getAgencyFields()));
                jSONObject2.put("passengerType", userAgencyInfo.getPassengerType());
                jSONObject2.put("city", userAgencyInfo.getCity());
                jSONObject2.put("agency", userAgencyInfo.getAgency());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("agencies", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }

    public static MPass r(String str) {
        MPass mPass;
        JSONException e;
        String str2;
        ProductCategory productCategory;
        ProductCategory productCategory2;
        PassApplicationRejectionReasons passApplicationRejectionReasons;
        long j;
        String str3;
        String str4;
        ArrayList arrayList;
        MPass mPass2;
        ProductFareMapping o0;
        List<ProductFareMapping> list;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("passId", null);
            String optString2 = jSONObject.optString(SuperPassJsonKeys.ORDER_ID, null);
            String optString3 = jSONObject.optString("productType", jSONObject.optString("passType"));
            String optString4 = jSONObject.optString(SuperPassJsonKeys.REFERENCE_ID, null);
            String optString5 = jSONObject.optString("catDisName", null);
            int optInt = jSONObject.optInt(SuperPassJsonKeys.MAX_PRICE_PER_TRIP, -1);
            String string = jSONObject.getString("passengerType");
            String optString6 = jSONObject.optString("grouping");
            String optString7 = jSONObject.optString("category");
            if (!TextUtils.isEmpty(optString6)) {
                str2 = SuperPassJsonKeys.VERIFICATION_FLAG;
                productCategory = v(new JSONObject(optString6));
            } else {
                str2 = SuperPassJsonKeys.VERIFICATION_FLAG;
                productCategory = null;
            }
            String optString8 = jSONObject.optString(SuperPassJsonKeys.USER_PROFILE, null);
            UserProfile H = optString8 != null ? H(optString8) : null;
            String optString9 = jSONObject.optString("productId", jSONObject.optString(SuperPassJsonKeys.CONFIGURATION_ID));
            if (!TextUtils.isEmpty(optString7) && productCategory == null) {
                productCategory = vn.l0(optString9, optString7);
            }
            if (productCategory == null && "superSaver".equals(optString3)) {
                productCategory = vn.l0(optString9, string);
            }
            String optString10 = jSONObject.optString("bookingTime", null);
            long j2 = 0;
            long parseLong = optString10 != null ? Long.parseLong(optString10) : 0;
            String string2 = jSONObject.getString(SuperPassJsonKeys.EXPIRY_TIME);
            long parseLong2 = Long.parseLong(jSONObject.optString(SuperPassJsonKeys.VERIFICATION_EXPIRY_TIME, "-1"));
            long parseLong3 = string2 != null ? Long.parseLong(string2) : 0;
            String string3 = jSONObject.getString(SuperPassJsonKeys.START_TIME);
            if (string3 != null) {
                j2 = Long.parseLong(string3);
            }
            long j3 = j2;
            String optString11 = jSONObject.optString("reason", "Documents Invalid");
            JSONObject optJSONObject = jSONObject.optJSONObject(SuperPassJsonKeys.REJECTION_REASONS);
            if (optJSONObject != null) {
                productCategory2 = productCategory;
                passApplicationRejectionReasons = (PassApplicationRejectionReasons) new Gson().fromJson(optJSONObject.toString(), PassApplicationRejectionReasons.class);
            } else {
                productCategory2 = productCategory;
                passApplicationRejectionReasons = null;
            }
            PassApplicationActionRequired valueOf = PassApplicationActionRequired.valueOf(jSONObject.optString(SuperPassJsonKeys.ACTION_REQUIRED, CardValidityCheckEvent.VALIDITY_STATUS_INVALID).toUpperCase());
            TicketStatus fromString = TicketStatus.fromString(jSONObject.optString("ticketStatus", null));
            String optString12 = jSONObject.optString("city", xt.f3961a.k().d().getName());
            int i = jSONObject.getInt(SuperPassJsonKeys.NUM_OF_DAYS);
            double d = jSONObject.getDouble(SuperPassJsonKeys.FARE);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (jSONObject.has(SuperPassJsonKeys.PUNCHES)) {
                JSONArray jSONArray = jSONObject.getJSONArray(SuperPassJsonKeys.PUNCHES);
                str4 = optString11;
                str3 = optString12;
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    arrayList2.add(new MagicPassPunchInfo(jSONArray.getJSONObject(i2).getLong(SuperPassJsonKeys.PUNCHING_TIME)));
                    i2++;
                    jSONArray = jSONArray;
                    j3 = j3;
                }
                j = j3;
            } else {
                j = j3;
                str4 = optString11;
                str3 = optString12;
            }
            if (jSONObject.has("specialFeatures")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("specialFeatures");
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    arrayList3.add(jSONArray2.getString(i3));
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("routeIds");
            ArrayList arrayList4 = new ArrayList();
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    arrayList4.add(optJSONArray.getString(i4));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("routeNames");
            ArrayList arrayList5 = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                    arrayList5.add(optJSONArray2.getString(i5));
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("startStopIds");
            ArrayList arrayList6 = new ArrayList();
            if (optJSONArray3 != null) {
                for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                    arrayList6.add(optJSONArray3.getString(i6));
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("startStopNames");
            ArrayList arrayList7 = new ArrayList();
            if (optJSONArray4 != null) {
                for (int i7 = 0; i7 < optJSONArray4.length(); i7++) {
                    arrayList7.add(optJSONArray4.getString(i7));
                }
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray("endStopIds");
            ArrayList arrayList8 = new ArrayList();
            if (optJSONArray5 != null) {
                arrayList = arrayList2;
                for (int i8 = 0; i8 < optJSONArray5.length(); i8++) {
                    arrayList8.add(optJSONArray5.getString(i8));
                }
            } else {
                arrayList = arrayList2;
            }
            JSONArray optJSONArray6 = jSONObject.optJSONArray("endStopNames");
            ArrayList arrayList9 = new ArrayList();
            if (optJSONArray6 != null) {
                for (int i9 = 0; i9 < optJSONArray6.length(); i9++) {
                    arrayList9.add(optJSONArray6.getString(i9));
                }
            }
            Map<String, String> hashMap = new HashMap<>();
            if (jSONObject.has("displayProps")) {
                hashMap = s(jSONObject.getString("displayProps"));
            }
            String optString13 = jSONObject.optString("agency", ui1.s(xt.f3961a.k().d()));
            int optInt2 = jSONObject.optInt("remainingTrips", -1);
            String string4 = jSONObject.has("status") ? jSONObject.getString("status") : null;
            String optString14 = jSONObject.optString(LoggingConstants.ROUTE_ID);
            String optString15 = jSONObject.optString("routeName");
            String optString16 = jSONObject.optString("startStopId");
            String optString17 = jSONObject.optString(Constants.START_STOP_NAME);
            String optString18 = jSONObject.optString("endStopId");
            String optString19 = jSONObject.optString(Constants.END_STOP_STOP_NAME);
            String optString20 = jSONObject.optString("paymentMode", null);
            String optString21 = jSONObject.optString(SuperPassJsonKeys.QR_CODE, SuperPassJsonKeys.QR_CODE);
            String optString22 = jSONObject.optString(SuperPassJsonKeys.TONE, null);
            boolean optBoolean = jSONObject.optBoolean("isExpired", false);
            String optString23 = jSONObject.optString("deviceId", null);
            MPass mPass3 = new MPass(H, string, optString13, d, i);
            try {
                ProductConfiguration m0 = vn.m0(optString9);
                o0 = (m0 == null || (list = m0.getProductFareMapping().get(string)) == null || list.size() <= 0) ? null : vn.o0(arrayList3, list, ui1.i(i));
                mPass2 = mPass3;
            } catch (JSONException e2) {
                e = e2;
                mPass2 = mPass3;
                mPass = mPass2;
                b00 b00 = b00.f358a;
                hj1.W0(e);
                return mPass;
            }
            try {
                mPass2.set_productName(jSONObject.optString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, o0 != null ? o0.getProductDisplayName() : null));
                if (!TextUtils.isEmpty(optString14)) {
                    mPass2.setRouteStopsInfo(new RouteStopsInfo(optString14, optString15, optString16, optString17, optString18, optString19));
                }
                if (arrayList4.size() > 0) {
                    mPass2.setRouteStopsInfo(new RouteStopsInfo((String) arrayList4.get(0), (String) arrayList5.get(0), null, (String) arrayList7.get(0), null, (String) arrayList9.get(0)));
                }
                int optInt3 = jSONObject.optInt(SuperPassJsonKeys.NUM_OF_TRIPS, -1);
                int optInt4 = jSONObject.optInt(SuperPassJsonKeys.MAX_TRIPS_PER_DAY, -1);
                mPass2.setTicketStatus(fromString);
                mPass2.setBookingTime(parseLong);
                mPass2.setExpiryTime(parseLong3);
                mPass2.setReferenceId(optString4);
                mPass2.setOrderId(optString2);
                mPass2.setStartingTime(j);
                mPass2.setBookingPassId(optString);
                mPass2.setDisplayProps(hashMap);
                mPass2.setConfigId(optString9);
                mPass2.setPunches(arrayList);
                mPass2.setQrCode(optString21);
                mPass2.setTone(optString22);
                mPass2.setStatus(string4);
                mPass2.setDisplayProps(hashMap);
                mPass2.setPaymentMode(optString20);
                mPass2.setCity(str3);
                mPass2.setPassExpired(optBoolean);
                mPass2.setPassRejectionReason(str4);
                mPass2.set_passApplicationRejectionReasons(passApplicationRejectionReasons);
                mPass2.set_passApplicationActionRequired(valueOf);
                mPass2.setVerificationExpiryTime(parseLong2);
                mPass2.setSpecialFeatures(arrayList3);
                mPass2.set_grouping(productCategory2);
                mPass2.set_productType(optString3);
                mPass2.set_productCategory(optString7);
                mPass2.set_remainingTrips(optInt2);
                mPass2.set_maxTrips(optInt3);
                mPass2.set_maxTripsPerDay(optInt4);
                mPass2.set_catDisName(optString5);
                mPass2.set_maxTripsPrice(optInt);
                if (jSONObject.has(str2)) {
                    mPass2.set_isVerificationRequired(jSONObject.getBoolean(str2));
                }
                mPass2.setDeviceId(optString23);
                return mPass2;
            } catch (JSONException e3) {
                e = e3;
                mPass = mPass2;
                b00 b002 = b00.f358a;
                hj1.W0(e);
                return mPass;
            }
        } catch (JSONException e4) {
            e = e4;
            mPass = null;
            b00 b0022 = b00.f358a;
            hj1.W0(e);
            return mPass;
        }
    }

    public static Map<String, String> s(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return hashMap;
        }
    }

    public static MTicketTripReceipt t(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("ticketId", "");
        Long valueOf = Long.valueOf(jSONObject.optLong(DigitalTripReceiptJsonKeys.KEY_ACTIVATION_TIME, -1));
        Long valueOf2 = Long.valueOf(jSONObject.optLong(DigitalTripReceiptJsonKeys.KEY_PUNCH_TIME, -1));
        String optString2 = jSONObject.optString(DigitalTripReceiptJsonKeys.KEY_CONDUCTOR_ID, "");
        return new MTicketTripReceipt(optString, valueOf.longValue(), valueOf2.longValue(), jSONObject.optString(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, ""), optString2);
    }

    public static PassApplicationRejectionReasons u(JSONObject jSONObject) {
        ArrayList arrayList;
        JSONArray jSONArray;
        JSONException e;
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("proofReasons");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("generalReasons");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("profileReasons");
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (optJSONArray != null) {
            int i = 0;
            while (i < optJSONArray.length()) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("proofId");
                    String upperCase = jSONObject2.optString("status", CardValidityCheckEvent.VALIDITY_STATUS_VALID).toUpperCase();
                    String optString2 = jSONObject2.optString(SuperPassJsonKeys.PROOF_URL);
                    ArrayList arrayList5 = new ArrayList();
                    JSONArray optJSONArray4 = jSONObject2.optJSONArray("reasons");
                    if (optJSONArray4 != null) {
                        jSONArray = optJSONArray;
                        arrayList = arrayList4;
                        for (int i2 = 0; i2 < optJSONArray4.length(); i2++) {
                            try {
                                arrayList5.add(optJSONArray4.optString(i2, ""));
                            } catch (JSONException e2) {
                                e = e2;
                                e.printStackTrace();
                                b00 b00 = b00.f358a;
                                b00.a().b(e);
                                i++;
                                arrayList4 = arrayList;
                                optJSONArray = jSONArray;
                            }
                        }
                    } else {
                        jSONArray = optJSONArray;
                        arrayList = arrayList4;
                    }
                    arrayList2.add(new ProofRejectionReason(RejectionStatus.valueOf(upperCase), optString, optString2, arrayList5));
                } catch (JSONException e3) {
                    e = e3;
                    jSONArray = optJSONArray;
                    arrayList = arrayList4;
                    e.printStackTrace();
                    b00 b002 = b00.f358a;
                    b00.a().b(e);
                    i++;
                    arrayList4 = arrayList;
                    optJSONArray = jSONArray;
                }
                i++;
                arrayList4 = arrayList;
                optJSONArray = jSONArray;
            }
        }
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                try {
                    JSONObject jSONObject3 = optJSONArray3.getJSONObject(i3);
                    String optString3 = jSONObject3.optString("id");
                    String upperCase2 = jSONObject3.optString("status", CardValidityCheckEvent.VALIDITY_STATUS_VALID).toUpperCase();
                    ArrayList arrayList6 = new ArrayList();
                    JSONArray optJSONArray5 = jSONObject3.optJSONArray("reasons");
                    if (optJSONArray5 != null) {
                        for (int i4 = 0; i4 < optJSONArray5.length(); i4++) {
                            arrayList6.add(optJSONArray5.optString(i4, ""));
                        }
                    }
                    arrayList3.add(new ProfileRejectionReason(RejectionStatus.valueOf(upperCase2), optString3, arrayList6));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    b00 b003 = b00.f358a;
                    b00.a().b(e4);
                }
            }
        }
        if (optJSONArray2 != null) {
            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                arrayList4.add(optJSONArray2.optString(i5, ""));
            }
        }
        return new PassApplicationRejectionReasons(arrayList2, arrayList3, arrayList4);
    }

    public static ProductCategory v(JSONObject jSONObject) {
        ProductCategory productCategory = new ProductCategory();
        try {
            String string = jSONObject.getString("id");
            String optString = jSONObject.optString("name");
            int optInt = jSONObject.optInt("displayorder", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray(SuperPassJsonKeys.PROOFS);
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
            }
            int optInt2 = jSONObject.optInt(CardInfo.KEY_POS, 0);
            boolean optBoolean = jSONObject.optBoolean("isActive", true);
            boolean optBoolean2 = jSONObject.optBoolean(SuperPassJsonKeys.IS_RENEWABLE, false);
            String optString2 = jSONObject.optString("documentsDesc");
            boolean optBoolean3 = jSONObject.optBoolean("verification");
            String optString3 = jSONObject.optString("info");
            int optInt3 = jSONObject.optInt("maxIssueCount", Integer.MAX_VALUE);
            String optString4 = jSONObject.optString("inactiveReason", null);
            int optInt4 = jSONObject.optInt(SuperPassJsonKeys.MAX_PRICE_PER_TRIP, -1);
            int optInt5 = jSONObject.optInt(SuperPassJsonKeys.MAX_TRIPS_PER_DAY, -1);
            String optString5 = jSONObject.optString("infoNote");
            boolean optBoolean4 = jSONObject.optBoolean("isVisible", true);
            productCategory.set_maxPricePerRide(optInt4);
            productCategory.set_categoryName(optString);
            productCategory.set_displayOrder(optInt);
            productCategory.setCategoryId(string);
            productCategory.setCategoryActive(optBoolean);
            productCategory.setDocumentDescription(optString2);
            productCategory.setCategoryIsRenewable(optBoolean2);
            productCategory.setCategoryProofsList(arrayList);
            productCategory.setCategoryInfo(optString3);
            productCategory.setCategoryMaxIssueCount(optInt3);
            productCategory.setCategoryVerificationRequired(optBoolean3);
            productCategory.setInactiveReason(optString4);
            productCategory.set_maxRidesPerDay(optInt5);
            productCategory.set_catInfoNote(optString5);
            productCategory.setIsVisible(optBoolean4);
            productCategory.setPosition(optInt2);
        } catch (JSONException unused) {
        }
        return productCategory;
    }

    public Map<String, Map<String, String>> A(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("documents");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                Iterator<String> keys2 = jSONObject3.keys();
                HashMap hashMap2 = new HashMap();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    hashMap2.put(next2, jSONObject3.getString(next2));
                }
                hashMap.put(next, hashMap2);
            }
        } catch (JSONException unused) {
        }
        return hashMap;
    }

    public final Map<String, ProductSubCategory> B(JSONArray jSONArray) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (jSONArray == null) {
            return linkedHashMap;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.optBoolean("isVisible", true)) {
                    String optString = jSONObject.optString("id", "");
                    linkedHashMap.put(optString, new ProductSubCategory(optString, jSONObject.optString("name", ""), "", jSONObject.optString("infoNote", ""), jSONObject.optString("info", ""), "", false, true, jSONObject.optBoolean("isActive", true), jSONObject.optString("inactiveReason", "")));
                }
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
        return linkedHashMap;
    }

    public Map<ProofUploadDocumentPropsIdentifier, ProofDocumentProps> C(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("documentProps");
            if (optJSONArray == null) {
                return hashMap;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                String d0 = vn.d0(jSONObject2, "city");
                String lowerCase = vn.d0(jSONObject2, "agency").toLowerCase();
                String d02 = vn.d0(jSONObject2, "documentid");
                ProofUploadDocumentPropsIdentifier proofUploadDocumentPropsIdentifier = new ProofUploadDocumentPropsIdentifier(d0, lowerCase, d02);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("info");
                String d03 = vn.d0(jSONObject3, "name");
                String d04 = vn.d0(jSONObject3, "longDesc");
                hashMap.put(proofUploadDocumentPropsIdentifier, new ProofDocumentProps(d02, d03, vn.d0(jSONObject3, "shortDesc"), d04, vn.d0(jSONObject3, "placeHolderUrl"), vn.d0(jSONObject3, "formUrl"), vn.d0(jSONObject3, "tutorialUrl")));
            }
            return hashMap;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ScanPayTicket E(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ticketId");
            String optString2 = jSONObject.optString("bookingId");
            double d = jSONObject.getDouble(SuperPassJsonKeys.FARE);
            double d2 = jSONObject.getDouble("discountedFare");
            boolean optBoolean = jSONObject.optBoolean("isExpired");
            String optString3 = jSONObject.optString("agency");
            xt.t1 t1Var = xt.f3961a;
            String optString4 = jSONObject.optString("city", t1Var.k().d().getName().toLowerCase());
            String optString5 = jSONObject.optString(SuperPassJsonKeys.QR_CODE);
            String optString6 = jSONObject.optString(SuperPassJsonKeys.TONE);
            jSONObject.optString(SuperPassJsonKeys.ORDER_ID);
            long optLong = jSONObject.optLong("bookingTime");
            long optLong2 = jSONObject.optLong(SuperPassJsonKeys.EXPIRY_TIME);
            String optString7 = jSONObject.optString("status");
            String string = new JSONObject(jSONObject.getString("bookingDetails")).getString("busInfo");
            ScanPayTicket scanPayTicket = new ScanPayTicket(optString, d, d2, t1Var.L().getUserId(), t1Var.n().a(), new ScanPayBookingDetails(string), optString3);
            scanPayTicket.set_transactionId(optString2);
            scanPayTicket.set_fare(d);
            scanPayTicket.set_qrCode(optString5);
            scanPayTicket.set_tone(optString6);
            scanPayTicket.set_status(optString7);
            scanPayTicket.set_cityName(optString4);
            scanPayTicket.set_discountedFare(d2);
            scanPayTicket.set_bookingTime(optLong);
            scanPayTicket.set_expirationTime(optLong2);
            scanPayTicket.set_isExpired(optBoolean);
            scanPayTicket.set_agencyName(optString3);
            scanPayTicket.set_bookingDetails(new ScanPayBookingDetails(string));
            return scanPayTicket;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public SingleTicket F(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new SingleTicket(jSONObject.getString("ticketId"), PassengerType.fromString(jSONObject.getString("passengerType")), jSONObject.getDouble(SuperPassJsonKeys.FARE));
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }

    public UserProfile G(String str, String str2) {
        JSONException e;
        Exception e2;
        Map<String, String> map;
        UserProfile userProfile = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(SuperPassJsonKeys.FIRST_NAME);
            String string2 = jSONObject.getString(SuperPassJsonKeys.LAST_NAME);
            Gender fromString = Gender.fromString(jSONObject.getString(SuperPassJsonKeys.GENDER));
            String string3 = jSONObject.getString("dob");
            HashMap hashMap = new HashMap();
            if (jSONObject.has(SuperPassJsonKeys.PROOFS)) {
                new HashMap();
                map = s(jSONObject.getString(SuperPassJsonKeys.PROOFS));
            } else {
                map = null;
            }
            UserAgencyInfo.STATUS valueOf = UserAgencyInfo.STATUS.valueOf("SUCCESS");
            String str3 = map != null ? map.get("PHOTOGRAPH") : null;
            hashMap.put(str2, new UserAgencyInfo(null, map, valueOf, str2, null, null));
            UserProfile userProfile2 = new UserProfile(string, string2, fromString, string3, null, null, str3, hashMap);
            try {
                userProfile2.setUserId(null);
                return userProfile2;
            } catch (JSONException e3) {
                e = e3;
                userProfile = userProfile2;
            } catch (Exception e4) {
                e2 = e4;
                userProfile = userProfile2;
                b00 b00 = b00.f358a;
                b00.a().b(e2);
                return userProfile;
            }
        } catch (JSONException e5) {
            e = e5;
            e.printStackTrace();
            b00 b002 = b00.f358a;
            hj1.W0(e);
            return userProfile;
        } catch (Exception e6) {
            e2 = e6;
            b00 b003 = b00.f358a;
            b00.a().b(e2);
            return userProfile;
        }
    }

    public String a(BookingPassRouteInfo bookingPassRouteInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            String routeId = bookingPassRouteInfo.getRouteId();
            String str = "";
            if (routeId == null) {
                routeId = str;
            }
            jSONObject.put(LoggingConstants.ROUTE_ID, routeId);
            String routeName = bookingPassRouteInfo.getRouteName();
            if (routeName != null) {
                str = routeName;
            }
            jSONObject.put("routeName", str);
            List<SPECIAL_FEATURE> specialFeatures = bookingPassRouteInfo.getSpecialFeatures();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < specialFeatures.size(); i++) {
                jSONArray.put(i, specialFeatures.get(i).name());
            }
            jSONObject.put("specialFeatures", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }

    public String b(BookingPass bookingPass) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("passId", bookingPass.getBookingPassId());
            jSONObject.put(SuperPassJsonKeys.USER_PROFILE, l(bookingPass.getUserProfile()));
            jSONObject.put("bookingTime", bookingPass.getBookingTime());
            jSONObject.put(SuperPassJsonKeys.EXPIRY_TIME, bookingPass.getExpiryTime());
            jSONObject.put(SuperPassJsonKeys.START_TIME, bookingPass.getStartingTime());
            jSONObject.put("passType", bookingPass.getBookingPassType());
            jSONObject.put("passengerType", bookingPass.getPassengerType());
            JSONArray jSONArray = new JSONArray();
            for (BookingPassRouteInfo bookingPassRouteInfo : bookingPass.getBookingPassRouteInfos()) {
                jSONArray.put(a(bookingPassRouteInfo));
            }
            jSONObject.put("routeInfo", jSONArray);
            jSONObject.put("ticketStatus", bookingPass.getTicketStatus().toString());
            jSONObject.put("agency", bookingPass.getAgency());
            jSONObject.put("displayProps", g(bookingPass.getDisplayProperties()));
            if (!(bookingPass.getStartStopName() == null || bookingPass.getEndStopName() == null || bookingPass.getStartStopId() == null || bookingPass.getEndStopId() == null)) {
                jSONObject.put(Constants.START_STOP_NAME, bookingPass.getStartStopName());
                jSONObject.put(Constants.END_STOP_STOP_NAME, bookingPass.getEndStopName());
                jSONObject.put("startStopId", bookingPass.getStartStopId());
                jSONObject.put("endStopId", bookingPass.getEndStopId());
            }
            jSONObject.put(SuperPassJsonKeys.NUM_OF_DAYS, bookingPass.getNoOfDays());
            jSONObject.put(SuperPassJsonKeys.FARE, bookingPass.getFare());
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < bookingPass.getPunches().size(); i++) {
                JSONObject jSONObject2 = new JSONObject();
                PunchInfo punchInfo = bookingPass.getPunches().get(i);
                jSONObject2.put(SuperPassJsonKeys.PUNCHING_TIME, punchInfo.getPunchingTime());
                jSONObject2.put("direction", punchInfo.getPunchDirection().name());
                jSONArray2.put(i, jSONObject2);
            }
            jSONObject.put(SuperPassJsonKeys.PUNCHES, jSONArray2);
            jSONObject.toString();
            return jSONObject.toString();
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }

    public String c(BookingTransaction bookingTransaction) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("transactionId", bookingTransaction.getTransactionId());
            GroupTicket groupTicket = bookingTransaction.getGroupTicket();
            BookingPass bookingPass = bookingTransaction.getBookingPass();
            MPass magicPass = bookingTransaction.getMagicPass();
            if (groupTicket != null) {
                jSONObject.put("groupTicket", d(groupTicket));
            } else if (bookingPass != null) {
                jSONObject.put("bookingPass", b(bookingPass));
            } else if (magicPass != null) {
                jSONObject.put("magicPass", f(magicPass));
            }
            jSONObject.put(SuperPassJsonKeys.FARE, bookingTransaction.getTotalFare());
            return jSONObject.toString();
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }

    public String d(GroupTicket groupTicket) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("transactionId", groupTicket.getTransactionId());
            jSONObject.put("groupId", groupTicket.getGroupId());
            jSONObject.put(SuperPassJsonKeys.MAIL_ID, groupTicket.getEmailId());
            jSONObject.put("bookingTime", groupTicket.getBookingTime());
            jSONObject.put(SuperPassJsonKeys.EXPIRY_TIME, groupTicket.getExpiryTime());
            jSONObject.put(SuperPassJsonKeys.PUNCHING_TIME, groupTicket.getPunchingTime());
            jSONObject.put("routeInfo", a(groupTicket.getRouteInfo()));
            jSONObject.put("agency", groupTicket.getAgency());
            jSONObject.put(Constants.START_STOP_NAME, groupTicket.getStartStopName());
            jSONObject.put("startStopId", groupTicket.getStartStopId());
            jSONObject.put(Constants.END_STOP_STOP_NAME, groupTicket.getEndStopName());
            jSONObject.put("endStopId", groupTicket.getEndStopId());
            List<SingleTicket> singleTickets = groupTicket.getSingleTickets();
            JSONArray jSONArray = new JSONArray();
            for (SingleTicket singleTicket : singleTickets) {
                jSONArray.put(new JSONObject(j(singleTicket)));
            }
            jSONObject.put("singleTicketsList", jSONArray);
            jSONObject.put(SuperPassJsonKeys.FARE, groupTicket.getFare());
            jSONObject.put("ticketStatus", groupTicket.getTicketStatus().toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }

    public String e(MTicket mTicket) {
        if (mTicket == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", mTicket.getUserId());
            jSONObject.put("ticketId", mTicket.getMTicketId());
            jSONObject.put("deviceId", mTicket.getDeviceId());
            jSONObject.put("city", mTicket.getCityName());
            jSONObject.put("agency", mTicket.getAgency());
            jSONObject.put("status", mTicket.getStatus());
            jSONObject.put(SuperPassJsonKeys.ORDER_ID, mTicket.getOrderId());
            if (mTicket.getUpTripRouteStopsInfo() != null) {
                jSONObject.put(LoggingConstants.ROUTE_ID, mTicket.getUpTripRouteStopsInfo().getRouteId());
                jSONObject.put("routeName", mTicket.getUpTripRouteStopsInfo().getRouteName());
                jSONObject.put("startStopId", mTicket.getUpTripRouteStopsInfo().getStartStopId());
                jSONObject.put(Constants.START_STOP_NAME, mTicket.getUpTripRouteStopsInfo().getStartStopName());
                jSONObject.put("endStopId", mTicket.getUpTripRouteStopsInfo().getEndStopId());
                jSONObject.put(Constants.END_STOP_STOP_NAME, mTicket.getUpTripRouteStopsInfo().getEndStopName());
                if (mTicket.getUpTripRouteStopsInfo().getSpecialFeatures() != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (SPECIAL_FEATURE special_feature : mTicket.getUpTripRouteStopsInfo().getSpecialFeatures()) {
                        jSONArray.put(special_feature.toString());
                    }
                    jSONObject.put("specialFeatures", jSONArray);
                }
                if (mTicket.getUpTripRouteStopsInfo().get_spf() != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : mTicket.getUpTripRouteStopsInfo().get_spf()) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("spf", jSONArray2);
                }
            }
            if (mTicket.get_userProfile() != null) {
                jSONObject.put("userDetails", l(mTicket.get_userProfile()));
            }
            jSONObject.put("bookingTime", mTicket.getBookingTime());
            jSONObject.put(SuperPassJsonKeys.EXPIRY_TIME, mTicket.getExpirationTime());
            jSONObject.put("isExpired", mTicket.isExpired());
            jSONObject.put("activatedAt", mTicket.getUpTripActivationTime());
            jSONObject.put("isActivated", mTicket.isUpTripActivated());
            jSONObject.put("punchedAt", mTicket.getUpTripPunchingTime());
            jSONObject.put(SuperPassJsonKeys.QR_CODE, mTicket.getQrCode());
            jSONObject.put("isFreeRide", mTicket.isFreeRide());
            JSONObject jSONObject2 = new JSONObject();
            for (String str2 : mTicket.getPassengerDetails().keySet()) {
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                MTicketPassengerInfo mTicketPassengerInfo = mTicket.getPassengerDetails().get(str2);
                if (mTicketPassengerInfo.get_addMap() != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    for (Map.Entry<String, Double> entry : mTicketPassengerInfo.get_addMap().entrySet()) {
                        jSONObject5.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject4.put("a", jSONObject5);
                }
                if (mTicketPassengerInfo.get_subMap() != null) {
                    JSONObject jSONObject6 = new JSONObject();
                    for (Map.Entry<String, Double> entry2 : mTicketPassengerInfo.get_subMap().entrySet()) {
                        jSONObject6.put(entry2.getKey(), entry2.getValue());
                    }
                    jSONObject4.put("s", jSONObject6);
                }
                if (mTicketPassengerInfo.get_subMap() != null || mTicketPassengerInfo.get_addMap() != null) {
                    jSONObject3.put("f_br", jSONObject4);
                }
                jSONObject3.put("c", mTicket.getPassengerDetails().get(str2).getPassengerCount());
                jSONObject3.put("f", mTicket.getPassengerDetails().get(str2).getFare());
                jSONObject3.put("ff", mTicket.getPassengerDetails().get(str2).get_totalFare());
                jSONObject3.put("d", mTicket.getPassengerDetails().get(str2).getDiscountPercentage());
                jSONObject3.put("roundingLogic", mTicket.getPassengerDetails().get(str2).getRoundingLogic());
                jSONObject2.put(str2, jSONObject3);
            }
            jSONObject.put("passengerDetails", jSONObject2);
            MTicketConfiguration mTicketConfiguration = mTicket.getMTicketConfiguration();
            if (mTicketConfiguration != null) {
                jSONObject.put(SuperPassJsonKeys.CONFIGURATION_ID, mTicketConfiguration.getId());
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }

    public JSONObject h(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
            return jSONObject;
        } catch (Exception e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
            e.printStackTrace();
            return null;
        }
    }

    public String j(SingleTicket singleTicket) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ticketId", singleTicket.getTicketId());
            jSONObject.put("passengerType", singleTicket.getPassengerType().toString());
            jSONObject.put(SuperPassJsonKeys.FARE, singleTicket.getFare());
            return jSONObject.toString();
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }

    public String k(ProfileRequestInfo profileRequestInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            BasicProfileFields fields = profileRequestInfo.getProfile().getFields();
            jSONObject.put(SuperPassJsonKeys.FIRST_NAME, fields.getFirstName());
            jSONObject.put(SuperPassJsonKeys.LAST_NAME, fields.getLastName());
            jSONObject.put(SuperPassJsonKeys.GENDER, fields.getGender().toString());
            jSONObject.put("dob", new SimpleDateFormat("yyyy-mm-dd").format(new SimpleDateFormat("dd/mm/yyyy").parse(fields.getDateOfBirth())));
            if (profileRequestInfo.hasAgencyInfo()) {
                jSONObject.put(SuperPassJsonKeys.PROOFS, h(profileRequestInfo.getAgencyInfo().getProofs()));
            }
            return jSONObject.toString();
        } catch (ParseException | JSONException e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
            e.printStackTrace();
            return null;
        }
    }

    public BookingPass m(String str) {
        BookingPass bookingPass;
        JSONException e;
        long j;
        long j2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "direction";
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("passId");
            UserProfile H = H(jSONObject.getString(SuperPassJsonKeys.USER_PROFILE));
            long parseLong = Long.parseLong(jSONObject.getString("bookingTime"));
            long parseLong2 = Long.parseLong(jSONObject.getString(SuperPassJsonKeys.EXPIRY_TIME));
            long parseLong3 = Long.parseLong(jSONObject.getString(SuperPassJsonKeys.START_TIME));
            BookingPassType fromString = BookingPassType.fromString(jSONObject.getString("passType"));
            String string2 = jSONObject.getString("passengerType");
            PassengerType.fromString(string2);
            if (jSONObject.has("routeName")) {
                JSONArray jSONArray = jSONObject.getJSONArray("routeName");
                j2 = parseLong;
                ArrayList arrayList = new ArrayList();
                j = parseLong3;
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } else {
                j = parseLong3;
                j2 = parseLong;
            }
            if (jSONObject.has("routeName")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(LoggingConstants.ROUTE_ID);
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList2.add(jSONArray2.getString(i2));
                }
            }
            TicketStatus fromString2 = TicketStatus.fromString(jSONObject.getString("ticketStatus"));
            String string3 = jSONObject.getString("agency");
            if (!jSONObject.has(Constants.START_STOP_NAME) || !jSONObject.has(Constants.END_STOP_STOP_NAME) || !jSONObject.has("startStopId") || !jSONObject.has("endStopId")) {
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
            } else {
                str2 = jSONObject.getString(Constants.START_STOP_NAME);
                str4 = jSONObject.getString("startStopId");
                str3 = jSONObject.getString(Constants.END_STOP_STOP_NAME);
                str5 = jSONObject.getString("endStopId");
            }
            int parseInt = Integer.parseInt(jSONObject.getString(SuperPassJsonKeys.NUM_OF_DAYS));
            double parseDouble = Double.parseDouble(jSONObject.getString(SuperPassJsonKeys.FARE));
            ArrayList arrayList3 = new ArrayList();
            int i3 = 0;
            for (JSONArray jSONArray3 = new JSONArray(jSONObject.getString("routeInfo")); i3 < jSONArray3.length(); jSONArray3 = jSONArray3) {
                try {
                    arrayList3.add(n(jSONArray3.getString(i3)));
                    i3++;
                } catch (JSONException e2) {
                    e = e2;
                    bookingPass = null;
                    b00 b00 = b00.f358a;
                    hj1.W0(e);
                    return bookingPass;
                }
            }
            ArrayList arrayList4 = new ArrayList();
            if (jSONObject.has(SuperPassJsonKeys.PUNCHES)) {
                JSONArray jSONArray4 = jSONObject.getJSONArray(SuperPassJsonKeys.PUNCHES);
                int i4 = 0;
                while (i4 < jSONArray4.length()) {
                    JSONObject jSONObject2 = jSONArray4.getJSONObject(i4);
                    long j3 = jSONObject2.getLong(SuperPassJsonKeys.PUNCHING_TIME);
                    PunchInfo.PunchDirection punchDirection = PunchInfo.PunchDirection.NEUTRAL;
                    if (jSONObject2.has(str6)) {
                        punchDirection = PunchInfo.PunchDirection.valueOf(jSONObject2.getString(str6));
                    }
                    arrayList4.add(new PunchInfo(j3, punchDirection));
                    i4++;
                    jSONArray4 = jSONArray4;
                    str5 = str5;
                    str6 = str6;
                }
            }
            Map<String, String> hashMap = new HashMap<>();
            if (jSONObject.has("displayProps")) {
                hashMap = s(jSONObject.getString("displayProps"));
            }
            bookingPass = new BookingPass(H, fromString, string2, string3, arrayList3, str2, str4, str3, str5, parseInt, parseDouble);
            try {
                bookingPass.setTicketStatus(fromString2);
                bookingPass.setBookingTime(j2);
                bookingPass.setExpiryTime(parseLong2);
                bookingPass.setStartingTime(j);
                bookingPass.setPassId(string);
                bookingPass.setDisplayProperties(hashMap);
                arrayList4.size();
                bookingPass.setPunches(arrayList4);
                return bookingPass;
            } catch (JSONException e3) {
                e = e3;
                b00 b002 = b00.f358a;
                hj1.W0(e);
                return bookingPass;
            }
        } catch (JSONException e4) {
            e = e4;
            bookingPass = null;
            b00 b0022 = b00.f358a;
            hj1.W0(e);
            return bookingPass;
        }
    }

    public BookingPassRouteInfo n(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(LoggingConstants.ROUTE_ID);
            String string2 = jSONObject.getString("routeName");
            JSONArray jSONArray = jSONObject.getJSONArray("specialFeatures");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(SPECIAL_FEATURE.valueOf(jSONArray.getString(i)));
            }
            return new BookingPassRouteInfo(string, string2, arrayList);
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }

    public GroupTicket o(String str) {
        GroupTicket groupTicket;
        JSONException e;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("transactionId");
            String string2 = jSONObject.getString("groupId");
            String string3 = jSONObject.getString(SuperPassJsonKeys.MAIL_ID);
            long parseLong = Long.parseLong(jSONObject.getString("bookingTime"));
            long parseLong2 = Long.parseLong(jSONObject.getString(SuperPassJsonKeys.EXPIRY_TIME));
            long parseLong3 = Long.parseLong(jSONObject.getString(SuperPassJsonKeys.PUNCHING_TIME));
            BookingPassRouteInfo n = n(jSONObject.getString("routeInfo"));
            String string4 = jSONObject.getString("agency");
            String string5 = jSONObject.getString(Constants.START_STOP_NAME);
            String string6 = jSONObject.getString("startStopId");
            String string7 = jSONObject.getString(Constants.END_STOP_STOP_NAME);
            String string8 = jSONObject.getString("endStopId");
            JSONArray jSONArray = jSONObject.getJSONArray("singleTicketsList");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(F(jSONArray.getJSONObject(i).toString()));
            }
            GroupTicket groupTicket2 = new GroupTicket(string3, n, string4, string5, string6, string7, string8, arrayList, Double.parseDouble(jSONObject.getString(SuperPassJsonKeys.FARE)));
            try {
                groupTicket2.setTransactionId(string);
                groupTicket2.setGroupId(string2);
                groupTicket2.setBookingTime(parseLong);
                groupTicket2.setExpiryTime(parseLong2);
                groupTicket2.setPunchingTime(parseLong3);
                groupTicket2.setTicketStatus(TicketStatus.fromString(jSONObject.getString("ticketStatus")));
                return groupTicket2;
            } catch (JSONException e2) {
                e = e2;
                groupTicket = groupTicket2;
                b00 b00 = b00.f358a;
                hj1.W0(e);
                return groupTicket;
            }
        } catch (JSONException e3) {
            e = e3;
            groupTicket = null;
            b00 b002 = b00.f358a;
            hj1.W0(e);
            return groupTicket;
        }
    }

    public String p(ScanPayTicket scanPayTicket, String str) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("lpVer", "v1");
            ut.a aVar = ut.f3552a;
            jSONObject2.put("appVer", 764);
            jSONObject2.put("ticketId", scanPayTicket.get_uuid());
            jSONObject2.put(SuperPassJsonKeys.FARE, scanPayTicket.get_fare());
            jSONObject2.put("userId", scanPayTicket.get_userId());
            jSONObject2.put("discountedFare", scanPayTicket.get_discountedFare());
            jSONObject2.put("deviceId", scanPayTicket.get_deviceId());
            jSONObject2.put(SuperPassJsonKeys.ORDER_ID, scanPayTicket.get_orderId());
            ScanPayBookingDetails scanPayBookingDetails = scanPayTicket.get_bookingDetails();
            try {
                jSONObject = new JSONObject();
                jSONObject.put("busInfo", scanPayBookingDetails.getBusInfo());
            } catch (JSONException unused) {
                jSONObject = null;
            }
            jSONObject2.put("bookingDetails", jSONObject);
            jSONObject2.put("version", str);
            return jSONObject2.toString();
        } catch (JSONException unused2) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ef A[SYNTHETIC, Splitter:B:33:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0302 A[Catch:{ JSONException -> 0x0307 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public app.zophop.models.mTicketing.MTicket q(java.lang.String r53) {
        /*
        // Method dump skipped, instructions count: 785
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ov.q(java.lang.String):app.zophop.models.mTicketing.MTicket");
    }

    public final ProductConfiguration w(JSONObject jSONObject) {
        ProductConfiguration productConfiguration;
        JSONException e;
        int i;
        JSONArray jSONArray;
        HashMap hashMap;
        int i2;
        String str;
        String str2;
        String str3 = "verification";
        String str4 = SuperPassJsonKeys.IS_RENEWABLE;
        String str5 = SuperPassJsonKeys.FARE_MAPPING_DESCRIPTION;
        String str6 = "inactiveReason";
        String str7 = SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME;
        String str8 = "isVisible";
        String str9 = "isActive";
        ProductConfiguration productConfiguration2 = new ProductConfiguration();
        try {
            if (SuperPassConstants.PRODUCT_TYPE_SUPER_PASS.equals(jSONObject.getString("productType"))) {
                return vv.c(jSONObject);
            }
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            b00.a().b(e2);
        }
        try {
            if ("cardRecharge".equals(jSONObject.getString("productType"))) {
                return kv.a(jSONObject);
            }
        } catch (JSONException e3) {
            b00 b002 = b00.f358a;
            b00.a().b(e3);
        }
        try {
            String string = jSONObject.getString("id");
            String string2 = jSONObject.getString("city");
            String optString = jSONObject.optString(str7);
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString("name");
            }
            String optString2 = jSONObject.optString(str5);
            String optString3 = jSONObject.optString("icon");
            String optString4 = jSONObject.optString(Constants.ScionAnalytics.PARAM_LABEL);
            String optString5 = jSONObject.optString("addInfo");
            int optInt = jSONObject.optInt("priority", Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
            String string3 = jSONObject.getString("productType");
            String optString6 = jSONObject.optString("productSubType", string3);
            String string4 = jSONObject.getString("agency");
            JSONObject optJSONObject = jSONObject.optJSONObject("branding");
            jSONObject.optString("fareType");
            jSONObject.getInt("totalPunches");
            long optLong = jSONObject.optLong("validity");
            long j = jSONObject.getLong(SuperPassJsonKeys.ACTIVE_DURATION);
            jSONObject.getLong("notificationDuration");
            JSONArray optJSONArray = jSONObject.optJSONArray("subCategory");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("subCategorySelection");
            JSONArray jSONArray2 = jSONObject.getJSONArray("categories");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("validDurations");
            JSONObject optJSONObject4 = jSONObject.optJSONObject("fareMapping");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("terms");
            try {
                boolean optBoolean = jSONObject.optBoolean(str9, true);
                String optString7 = jSONObject.optString(str6, null);
                boolean optBoolean2 = jSONObject.optBoolean(str8, true);
                boolean optBoolean3 = jSONObject.optBoolean("bHideCatSel", false);
                int optInt2 = jSONObject.optInt("minAppVer", -1);
                int optInt3 = jSONObject.optInt("maxAppVer", -1);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (optJSONArray2 != null) {
                    i = optInt3;
                    jSONArray = jSONArray2;
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        arrayList2.add(optJSONArray2.getString(i3));
                    }
                } else {
                    i = optInt3;
                    jSONArray = jSONArray2;
                }
                HashMap hashMap2 = new HashMap();
                if (optJSONObject4 != null) {
                    Iterator<String> keys = optJSONObject4.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        ArrayList arrayList3 = new ArrayList();
                        JSONArray jSONArray3 = optJSONObject4.getJSONArray(next);
                        int i4 = 0;
                        while (i4 < jSONArray3.length()) {
                            JSONObject jSONObject2 = jSONArray3.getJSONObject(i4);
                            int optInt4 = jSONObject2.optInt(SuperPassJsonKeys.FARE_MAPPING_ID, 0);
                            String optString8 = jSONObject2.optString("subCatId", null);
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray(SuperPassJsonKeys.PROOFS);
                            Boolean valueOf = jSONObject2.has(str4) ? Boolean.valueOf(jSONObject2.getBoolean(str4)) : null;
                            Boolean valueOf2 = jSONObject2.has(str3) ? Boolean.valueOf(jSONObject2.getBoolean(str3)) : null;
                            ArrayList arrayList4 = new ArrayList();
                            if (optJSONArray3 != null) {
                                hashMap = hashMap2;
                                i2 = i4;
                                for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                                    arrayList4.add(optJSONArray3.getString(i5));
                                }
                            } else {
                                hashMap = hashMap2;
                                i2 = i4;
                            }
                            boolean optBoolean4 = jSONObject2.optBoolean(str8, true);
                            long j2 = jSONObject2.getLong("durationId");
                            int optInt5 = jSONObject2.optInt(SuperPassJsonKeys.FARE);
                            int optInt6 = jSONObject2.optInt("discountedFare", -1);
                            Boolean valueOf3 = jSONObject2.has(str9) ? Boolean.valueOf(jSONObject2.getBoolean(str9)) : null;
                            String optString9 = jSONObject2.optString(str6, null);
                            String optString10 = jSONObject2.optString("dInfo");
                            String optString11 = jSONObject2.optString("info");
                            String optString12 = jSONObject2.optString(str5);
                            int optInt7 = jSONObject2.optInt("discountPercentage");
                            String optString13 = jSONObject2.optString(str7);
                            int optInt8 = jSONObject2.optInt(SuperPassJsonKeys.NUM_OF_TRIPS, -1);
                            int optInt9 = jSONObject2.optInt(SuperPassJsonKeys.MAX_TRIPS_PER_DAY, -1);
                            double optDouble = jSONObject2.optDouble(SuperPassJsonKeys.MAX_PRICE_PER_TRIP, -1.0d);
                            JSONArray optJSONArray4 = jSONObject2.optJSONArray("specialFeatures");
                            ArrayList arrayList5 = new ArrayList();
                            if (optJSONArray4 != null) {
                                str = optString10;
                                str2 = optString12;
                                for (int i6 = 0; i6 < optJSONArray4.length(); i6++) {
                                    arrayList5.add(optJSONArray4.getString(i6));
                                }
                            } else {
                                str = optString10;
                                str2 = optString12;
                            }
                            ProductFareMapping productFareMapping = new ProductFareMapping();
                            productFareMapping.setFareMappingId(optInt4);
                            productFareMapping.setSubCategoryId(optString8);
                            productFareMapping.setIsVisible(optBoolean4);
                            productFareMapping.setCategoryId(next);
                            productFareMapping.setMaxRides(optInt8);
                            productFareMapping.setMaxRidesPerDay(optInt9);
                            productFareMapping.setMaxPricePerRide(optDouble);
                            productFareMapping.setDurationId(j2);
                            productFareMapping.setFare(optInt5);
                            productFareMapping.setDurationInfo(optString11);
                            productFareMapping.setDesc(str2);
                            productFareMapping.setProductDisplayName(optString13);
                            productFareMapping.setAdditionalInfo(str);
                            productFareMapping.setDiscountFare(optInt6);
                            productFareMapping.setSpecialFeatures(arrayList5);
                            productFareMapping.setDiscountPercentage(optInt7);
                            productFareMapping.setIsActive(valueOf3);
                            productFareMapping.setInactiveReason(optString9);
                            productFareMapping.setProofsRequiredList(arrayList4);
                            productFareMapping.setIsRenewable(valueOf);
                            productFareMapping.setIsVerificationRequired(valueOf2);
                            arrayList3.add(productFareMapping);
                            i4 = i2 + 1;
                            arrayList3 = arrayList3;
                            jSONArray3 = jSONArray3;
                            optJSONArray = optJSONArray;
                            arrayList = arrayList;
                            optJSONObject3 = optJSONObject3;
                            str4 = str4;
                            str3 = str3;
                            hashMap2 = hashMap;
                            str8 = str8;
                            str9 = str9;
                            str6 = str6;
                            str5 = str5;
                            str7 = str7;
                        }
                        hashMap2.put(next, arrayList3);
                        hashMap2 = hashMap2;
                        keys = keys;
                        arrayList2 = arrayList2;
                        optJSONObject2 = optJSONObject2;
                        optJSONObject4 = optJSONObject4;
                        optJSONArray = optJSONArray;
                        arrayList = arrayList;
                        optJSONObject3 = optJSONObject3;
                        str4 = str4;
                        str3 = str3;
                        str8 = str8;
                        str9 = str9;
                        str6 = str6;
                        str5 = str5;
                        str7 = str7;
                    }
                }
                String str10 = str6;
                String str11 = str7;
                String str12 = str8;
                String str13 = str9;
                ArrayList arrayList6 = arrayList;
                JSONObject jSONObject3 = optJSONObject3;
                if (jSONObject3 != null) {
                    Iterator<String> keys2 = jSONObject3.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        JSONObject jSONObject4 = jSONObject3.getJSONObject(next2);
                        long parseLong = Long.parseLong(next2);
                        String string5 = jSONObject4.getString(str11);
                        boolean optBoolean5 = jSONObject4.optBoolean(str13, true);
                        boolean optBoolean6 = jSONObject4.optBoolean(str12, true);
                        String optString14 = jSONObject4.optString(str10, null);
                        ProductDuration productDuration = new ProductDuration(parseLong, string5);
                        productDuration.setIsActive(optBoolean5);
                        productDuration.setInactiveReason(optString14);
                        productDuration.setIsVisible(optBoolean6);
                        arrayList6.add(productDuration);
                        str11 = str11;
                        jSONObject3 = jSONObject3;
                        arrayList6 = arrayList6;
                        str13 = str13;
                        str12 = str12;
                        str10 = str10;
                    }
                }
                SubCategorySelectionDetails subCategorySelectionDetails = null;
                try {
                    Map<String, ProductSubCategory> B = B(optJSONArray);
                    if (optJSONObject2 != null) {
                        subCategorySelectionDetails = new SubCategorySelectionDetails(optJSONObject2.optString("heading", ""), optJSONObject2.optString("subHeading", ""));
                    }
                    ArrayList arrayList7 = new ArrayList();
                    int i7 = 0;
                    while (i7 < jSONArray.length()) {
                        arrayList7.add(v(jSONArray.getJSONObject(i7)));
                        i7++;
                        jSONArray = jSONArray;
                    }
                    if (optJSONObject != null) {
                        productConfiguration = productConfiguration2;
                        try {
                            productConfiguration.setBranding(new ProductBranding(optJSONObject.optBoolean(str12, false)));
                        } catch (JSONException e4) {
                            e = e4;
                            e.getMessage();
                            return productConfiguration;
                        }
                    } else {
                        productConfiguration = productConfiguration2;
                        productConfiguration.setBranding(new ProductBranding(true));
                    }
                    productConfiguration.setProductId(string);
                    productConfiguration.setProductCity(string2);
                    productConfiguration.setProductDesc(optString2);
                    productConfiguration.setProductPriority(optInt);
                    productConfiguration.setProductAdditionalInfo(optString5);
                    productConfiguration.setProductIcon(optString3);
                    productConfiguration.setProductLabel(optString4);
                    productConfiguration.setProductName(optString);
                    productConfiguration.setProductType(string3);
                    productConfiguration.setProductSubType(optString6);
                    productConfiguration.setProductAgency(string4);
                    productConfiguration.setProductDurationList(arrayList6);
                    productConfiguration.setProductActiveDuration(j);
                    productConfiguration.setProductValidity(optLong);
                    productConfiguration.setProductCategoryList(arrayList7);
                    productConfiguration.setProductSubcategoryMap(B);
                    productConfiguration.setSubCategorySelectionDetails(subCategorySelectionDetails);
                    productConfiguration.setProductFareMapping(hashMap2);
                    productConfiguration.setProductTerms(arrayList2);
                    productConfiguration.setIsActive(optBoolean);
                    productConfiguration.setinactiveReason(optString7);
                    productConfiguration.setIsVisible(optBoolean2);
                    productConfiguration.setShouldHideSubCategorySelection(optBoolean3);
                    productConfiguration.setMinAppVer(optInt2);
                    productConfiguration.setMaxAppVer(i);
                } catch (JSONException e5) {
                    e = e5;
                    productConfiguration = productConfiguration2;
                    e.getMessage();
                    return productConfiguration;
                }
            } catch (JSONException e6) {
                e = e6;
                productConfiguration = productConfiguration2;
                e.getMessage();
                return productConfiguration;
            }
        } catch (JSONException e7) {
            e = e7;
            productConfiguration = productConfiguration2;
            e.getMessage();
            return productConfiguration;
        }
        return productConfiguration;
    }

    public ProductConfiguration x(String str) {
        try {
            return w(new JSONObject(str));
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }

    public Map<String, String> y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("products");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                hashMap.put(jSONObject2.getString("id"), jSONObject2.toString());
            }
            return hashMap;
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }

    public List<ProductDisplayProps> z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("displayProps");
            for (int i = 0; i < jSONArray.length(); i++) {
                ProductDisplayProps productDisplayProps = new ProductDisplayProps();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("category");
                String string2 = jSONObject2.getString("displayname");
                int i2 = jSONObject2.getInt("displayorder");
                productDisplayProps.setProductCategoryId(string);
                productDisplayProps.setProductCategoryName(string2);
                productDisplayProps.setDisplayOrder(i2);
                arrayList.add(productDisplayProps);
            }
            return arrayList;
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
            return null;
        }
    }
}
