package com.razorpay;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.freshchat.consumer.sdk.beans.User;
import com.razorpay.AnalyticsProperty;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
public class AnalyticsUtil {
    public static String BUILD_TYPE = null;
    public static String KEY_TYPE = null;
    public static int MERCHANT_APP_BUILD = 0;
    public static CharSequence MERCHANT_APP_NAME = null;
    public static CharSequence MERCHANT_APP_NAMESPACE = null;
    public static CharSequence MERCHANT_APP_VERSION = null;
    private static boolean isAnalyticsInitialized = false;
    public static String libraryType = null;
    private static String localOrderId = null;
    private static String localPaymentId = null;
    private static String sdkType = "standealone";
    private static String sdkVersion;
    private static int sdkVersionCode;

    public static void addFilteredPropertiesFromPayload(JSONObject jSONObject) {
        J$_0_.a(jSONObject);
    }

    public static void addProperty(String str, AnalyticsProperty analyticsProperty) {
        AnalyticsProperty.Scope scope = analyticsProperty.scope;
        if (scope == AnalyticsProperty.Scope.PAYMENT) {
            J$_0_.a(str, analyticsProperty.value);
        } else if (scope == AnalyticsProperty.Scope.ORDER) {
            J$_0_.b(str, analyticsProperty.value);
        }
    }

    public static JSONObject getAnalyticsDataForCheckout(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "mobile_sdk");
            jSONObject.put("platform_version", sdkVersion);
            jSONObject.put(User.DEVICE_META_OS_NAME, "android");
            jSONObject.put(User.DEVICE_META_OS_VERSION_NAME, Build.VERSION.RELEASE);
            if (context.getResources().getBoolean(R.bool.isTablet)) {
                jSONObject.put(AnalyticsConstants.DEVICE, "tablet");
            } else {
                jSONObject.put(AnalyticsConstants.DEVICE, "mobile");
            }
        } catch (Exception e) {
            reportError(e, AnalyticsConstants.CRITICAL, e.getMessage());
        }
        return jSONObject;
    }

    public static String getAppDetail() {
        if (!isAnalyticsInitialized) {
            return null;
        }
        return ((Object) MERCHANT_APP_NAME) + "-" + ((Object) MERCHANT_APP_VERSION) + "-" + MERCHANT_APP_BUILD;
    }

    public static String getBuildType() {
        return BUILD_TYPE;
    }

    public static Map<String, Object> getErrorProperties(String str, String str2) {
        return hj1.n0("error_level", str, "error_message", str2);
    }

    public static JSONObject getExtraAnalyticsPayload() {
        return J$_0_.e();
    }

    public static String getKeyType() {
        return KEY_TYPE;
    }

    public static String getLocalOrderId() {
        if (localOrderId == null) {
            localOrderId = getUniqueId();
        }
        return localOrderId;
    }

    public static String getLocalPaymentId() {
        if (localPaymentId == null) {
            localPaymentId = getUniqueId();
        }
        return localPaymentId;
    }

    public static Map<String, Object> getPageLoadEndProperties(String str, long j) {
        HashMap m0 = hj1.m0("url", str);
        m0.put(AnalyticsConstants.PAGE_LOAD_TIME, Double.valueOf(((double) j) / 1.0E9d));
        return m0;
    }

    public static Map<String, Object> getPageLoadStartProperties(String str) {
        return hj1.m0("url", str);
    }

    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static String getUniqueId() {
        return tobase62((System.currentTimeMillis() - 1388534400000L) * 1000000) + tobase62((long) Math.floor(Math.random() * 1.4776336E7d));
    }

    private static void init(Context context, String str) {
        if (context == null) {
            throw new RuntimeException("Context not set");
        } else if (str != null) {
            J$_0_.a(context, sdkType, sdkVersion);
            J$_0_.b(AnalyticsConstants.MERCHANT_KEY, str);
            J$_0_.b(AnalyticsConstants.MERCHANT_PACKAGE, context.getPackageName());
            r_$Z$.a(context);
            isAnalyticsInitialized = true;
        } else {
            throw new RuntimeException("Merchant key not set");
        }
    }

    public static boolean isCheckoutUrl(String str) {
        return str.indexOf(g__v_.a().getCheckoutEndpoint()) == 0;
    }

    public static boolean isNullOrEmpty(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence) || TextUtils.getTrimmedLength(charSequence) == 0;
    }

    public static void postData() {
        if (isAnalyticsInitialized) {
            J$_0_.a();
        }
    }

    public static void refreshOrderSession() {
        localOrderId = getUniqueId();
        localPaymentId = getUniqueId();
        J$_0_.d();
        J$_0_.c();
    }

    public static void refreshPaymentSession() {
        localPaymentId = getUniqueId();
        J$_0_.c();
    }

    public static void reportError(Exception exc, String str, String str2) {
        trackEvent(AnalyticsEvent.ERROR_LOGGED, getErrorProperties(str, str2));
        exc.printStackTrace();
    }

    public static void reportUncaughtException(Throwable th) {
        trackEvent(AnalyticsEvent.ERROR_LOGGED, getErrorProperties(AnalyticsConstants.UNCAUGHT, getStackTrace(th)));
    }

    public static void reset() {
        isAnalyticsInitialized = false;
        localPaymentId = null;
        localOrderId = null;
        J$_0_.b();
    }

    public static CharSequence returnUndefinedIfNull(CharSequence charSequence) {
        return isNullOrEmpty(charSequence) ? "undefined" : charSequence;
    }

    public static void saveEventsToPreferences(Context context) {
        J$_0_.a(context);
    }

    public static void setAppDetails(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            MERCHANT_APP_NAME = returnUndefinedIfNull(packageInfo.applicationInfo.loadLabel(packageManager));
            MERCHANT_APP_VERSION = returnUndefinedIfNull(packageInfo.versionName);
            MERCHANT_APP_NAMESPACE = returnUndefinedIfNull(packageInfo.packageName);
            MERCHANT_APP_BUILD = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            reportError(e, AnalyticsConstants.CRITICAL, e.getMessage());
        }
        BUILD_TYPE = BaseUtils.getAppBuildType(context);
        KEY_TYPE = getKeyType(str);
    }

    public static void setLocalOrderId(String str) {
        localOrderId = str;
    }

    public static void setup(Context context, String str, String str2, int i, String str3) {
        sdkType = str2;
        sdkVersionCode = i;
        sdkVersion = str3;
        setAppDetails(context, str);
        init(context, str);
    }

    public static String tobase62(long j) {
        String str = "";
        String[] split = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".split(str);
        while (j > 0) {
            str = String.valueOf(split[(int) (j % 62)]) + str;
            j = (long) Math.floor((double) (j / 62));
        }
        return str;
    }

    public static void trackEvent(AnalyticsEvent analyticsEvent) {
        J$_0_.a(analyticsEvent.getEventName());
    }

    public static void trackPage(String str, String str2) {
        J$_0_.a(str, str2);
    }

    public static void trackPageLoadEnd(String str, long j) {
        trackEvent(isCheckoutUrl(str) ? AnalyticsEvent.CHECKOUT_PAGE_LOAD_FINISH : AnalyticsEvent.PAGE_LOAD_FINISH, getPageLoadEndProperties(str, j));
    }

    public static void trackPageLoadStart(String str) {
        trackEvent(isCheckoutUrl(str) ? AnalyticsEvent.CHECKOUT_PAGE_LOAD_START : AnalyticsEvent.PAGE_LOAD_START, getPageLoadStartProperties(str));
    }

    public static String getKeyType(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        String substring = str.substring(0, 8);
        if (substring.equals("rzp_live")) {
            return "live";
        }
        if (substring.equals("rzp_test")) {
            return "test";
        }
        return null;
    }

    public static void trackEvent(AnalyticsEvent analyticsEvent, Map<String, Object> map) {
        J$_0_.a(analyticsEvent.getEventName(), map);
    }

    public static void reportError(AbstractMethodError abstractMethodError, String str, String str2) {
        trackEvent(AnalyticsEvent.ERROR_LOGGED, getErrorProperties(str, str2));
        abstractMethodError.printStackTrace();
    }

    public static void trackEvent(AnalyticsEvent analyticsEvent, JSONObject jSONObject) {
        J$_0_.a(analyticsEvent.getEventName(), jSONObject);
    }
}
