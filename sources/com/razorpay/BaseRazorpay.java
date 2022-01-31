package com.razorpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.freshchat.consumer.sdk.beans.User;
import com.google.android.gms.common.Feature;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.rabbitmq.client.StringRpcServer;
import com.razorpay.AnalyticsProperty;
import defpackage.d42;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseRazorpay implements OnAppSelectedListener, PaymentCompleteInternalCallback, RzpInternalCallback {
    public static final int INVALID_OPTIONS = 3;
    public static final int NETWORK_ERROR = 2;
    public static final int PARSING_ERROR = 4;
    public static final int PAYMENT_CANCELED = 0;
    public static final int PAYMENT_ERROR = 5;
    public static final String RAZORPAY_ORDER_ID = "razorpay_order_id";
    public static final String RAZORPAY_PAYMENT_ID = "razorpay_payment_id";
    public static final String RAZORPAY_SIGNATURE = "razorpay_signature";
    public static final int TLS_ERROR = 6;
    private static String apiUrl = "https://api.razorpay.com/v1/";
    private static int callbackCount;
    public Activity activity;
    private HashSet<String> allUpiDeviceApps;
    public String apiKey;
    private JSONObject cardsFlowPayload = new JSONObject();
    private LinkedHashSet<String> configAppsPreferredOrder = new LinkedHashSet<>();
    private String credStatusUrl;
    public RzpPlugin extActiveRzpPluginInstance;
    private HashMap<String, ApplicationDetails> filteredUpiPackageToAppDetails;
    public boolean isExtRzpPluginActive = false;
    private boolean isWhiteListingEnabled;
    public boolean mShouldDisplayLogo = true;
    public ViewGroup magicView;
    private String merchPassedUPIPackageName;
    private ArrayList<String> merchantOtherUpiAppsOrder;
    private ArrayList<String> merchantPreferredUpiAppsOrder;
    private boolean ongoingPayment = false;
    private JSONObject otpGeneratePayload = new JSONObject();
    private JSONObject payload = new JSONObject();
    public PaymentResultListener paymentResultListener;
    public PaymentResultWithDataListener paymentResultWithDataListener;
    private String payment_id;
    private RazorpayWebChromeClient razorpayWebChromeClient;
    private RazorpayWebViewClient razorpayWebViewClient;
    private ArrayList<String> remainingApps;
    private String upiAppLaunchedPackageName;
    private HashSet<String> upiBlacklistedApps = new HashSet<>();
    private HashSet<String> upiWhiteListedApps = new HashSet<>();
    private String urlData;
    public boolean useBottomSheet = true;
    public WebView webview;

    public BaseRazorpay(Activity activity2, String str) {
        this.apiKey = str;
        initRazorpay(activity2);
    }

    public static /* synthetic */ int access$008() {
        int i = callbackCount;
        callbackCount = i + 1;
        return i;
    }

    private String appendPaymentAnalytics(String str) {
        StringBuilder k0 = hj1.k0(str, "<input type='hidden' name='_[checkout_id]' value='");
        k0.append(AnalyticsUtil.getLocalOrderId());
        k0.append("'>");
        StringBuilder k02 = hj1.k0(hj1.S(k0.toString(), "<input type='hidden' name='_[os]' value='android'>"), "<input type='hidden' name='_[package_name]' value='");
        k02.append(this.activity.getPackageName());
        k02.append("'>");
        StringBuilder k03 = hj1.k0(hj1.S(k02.toString(), "<input type='hidden' name='_[platform]' value='mobile_sdk'>"), "<input type='hidden' name='_[cellular_network_type]' value=");
        k03.append(BaseUtils.getCellularNetworkType(this.activity));
        k03.append(">");
        StringBuilder k04 = hj1.k0(k03.toString(), "<input type='hidden' name='_[data_network_type]' value='");
        k04.append(BaseUtils.getDataNetworkType(this.activity).getNetworkTypeName());
        k04.append("'>");
        StringBuilder k05 = hj1.k0(k04.toString(), "<input type='hidden' name='_[locale]' value='");
        k05.append(BaseUtils.getLocale());
        k05.append("'>");
        return hj1.a0(hj1.k0(hj1.S(k05.toString(), "<input type='hidden' name='_[library]' value='custom'>"), "<input type='hidden' name='_[library_version]' value='"), f$_G$.b, "'>");
    }

    public static long calculateEmi(long j, int i, double d) {
        double d2 = d / 1200.0d;
        double pow = Math.pow(d2 + 1.0d, (double) i);
        return Math.round(((((double) j) * d2) * pow) / (pow - 1.0d));
    }

    private void callApi(String str, String str2, final NativeOtpCallback nativeOtpCallback) {
        T__j$.a(str, str2, hj1.m0("content-type", "application/json"), new Callback() {
            /* class com.razorpay.BaseRazorpay.AnonymousClass15 */

            @Override // com.razorpay.Callback
            public void run(ResponseObject responseObject) {
                if (BaseRazorpay.this.isApiCallSuccessful(responseObject)) {
                    nativeOtpCallback.onResponse(responseObject.getResponseResult());
                } else {
                    nativeOtpCallback.onError(responseObject.getResponseCode(), responseObject.getResponseResult());
                }
            }
        });
    }

    public static boolean canShowUpiIntentMethod(Context context) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_SHOULD_SHOW_UPI_INTENT_METHOD);
        HashSet<String> filteredDeviceUpiAppsPackageSet = getFilteredDeviceUpiAppsPackageSet(context);
        return filteredDeviceUpiAppsPackageSet != null && !filteredDeviceUpiAppsPackageSet.isEmpty();
    }

    private void fetchPreferences(String str, final FetchPreferencesCallback fetchPreferencesCallback) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.FETCH_PREFERENCES_CALLED);
        String preferencesFromCache = getPreferencesFromCache();
        if (preferencesFromCache == null || (str != null && !preferencesFromCache.contains(str))) {
            String str2 = apiUrl + "preferences?key_id=" + this.apiKey;
            if (str != null) {
                str2 = hj1.T(str2, "&subscription_id=", str);
            }
            T__j$.a(str2, new Callback() {
                /* class com.razorpay.BaseRazorpay.AnonymousClass7 */

                @Override // com.razorpay.Callback
                public void run(ResponseObject responseObject) {
                    String responseResult = responseObject.getResponseResult();
                    if (responseResult == null || responseResult.isEmpty() || responseObject.getResponseCode() != 200) {
                        fetchPreferencesCallback.onError(responseResult);
                        AnalyticsUtil.trackEvent(AnalyticsEvent.FETCH_PREFERENCES_METHODS_CALL_FAIL);
                        return;
                    }
                    d__1_.a(BaseConstants.PAYMENT_PREFERENCES_CACHE_KEY, responseResult, TimeUnit.MINUTES.toMillis(15));
                    fetchPreferencesCallback.onResponse(responseResult);
                    AnalyticsUtil.trackEvent(AnalyticsEvent.FETCH_PREFERENCES_CALL_SUCCESS);
                }
            });
            return;
        }
        fetchPreferencesCallback.onResponse(preferencesFromCache);
    }

    private static ApplicationDetails getAppDetailsFromPackageName(Context context, String str) {
        return new ApplicationDetails(BaseUtils.getAppNameOfPackageName(str, context), BaseUtils.getBase64FromOtherAppsResource(context, str), str);
    }

    public static void getAppsWhichSupportUpi(final Context context, final RzpUpiSupportedAppsCallback rzpUpiSupportedAppsCallback) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_GET_APPS_SUPPORTING_UPI);
        final HashMap<String, String> allPluginsFromManifest = BaseUtils.getAllPluginsFromManifest(context);
        if (allPluginsFromManifest == null || allPluginsFromManifest.size() == 0) {
            rzpUpiSupportedAppsCallback.onReceiveUpiSupportedApps(getUPISupportedApps(context));
            return;
        }
        for (String str : allPluginsFromManifest.values()) {
            try {
                ((RzpPlugin) RzpPlugin.class.getClassLoader().loadClass(str).newInstance()).isRegistered(context, new RzpPluginRegisterCallback() {
                    /* class com.razorpay.BaseRazorpay.AnonymousClass1 */

                    @Override // com.razorpay.RzpPluginRegisterCallback
                    public final void onResponse(boolean z) {
                        BaseRazorpay.access$008();
                        if (BaseRazorpay.callbackCount == allPluginsFromManifest.size()) {
                            int unused = BaseRazorpay.callbackCount = 0;
                            rzpUpiSupportedAppsCallback.onReceiveUpiSupportedApps(BaseRazorpay.getUPISupportedApps(context));
                        }
                    }
                });
            } catch (Exception e) {
                AnalyticsUtil.reportError(e, AnalyticsConstants.CRITICAL, e.getLocalizedMessage());
            }
        }
    }

    private static HashSet<String> getFilteredDeviceUpiAppsPackageSet(Context context) {
        HashSet<String> hashSet = new HashSet<>();
        f$_G$.a().a(context);
        boolean b = f$_G$.a().b();
        HashSet<String> setOfPackageNamesSupportingUpi = BaseUtils.getSetOfPackageNamesSupportingUpi(context);
        if (b) {
            HashSet<String> c = f$_G$.a().c();
            if (c == null || c.isEmpty()) {
                return new HashSet<>();
            }
            Iterator<String> it = setOfPackageNamesSupportingUpi.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (c.contains(next)) {
                    hashSet.add(next);
                }
            }
        } else {
            HashSet<String> d = f$_G$.a().d();
            if (d != null && !d.isEmpty()) {
                Iterator<String> it2 = setOfPackageNamesSupportingUpi.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    if (!d.contains(next2)) {
                        hashSet.add(next2);
                    }
                }
            } else if (setOfPackageNamesSupportingUpi != null) {
                return setOfPackageNamesSupportingUpi;
            } else {
                return new HashSet<>();
            }
        }
        return hashSet;
    }

    private PaymentData getPaymentData(JSONObject jSONObject) {
        PaymentData paymentData = new PaymentData();
        try {
            paymentData.setData(jSONObject);
            if (jSONObject.has(RAZORPAY_PAYMENT_ID)) {
                paymentData.setPaymentId(jSONObject.getString(RAZORPAY_PAYMENT_ID));
            }
            if (jSONObject.has(RAZORPAY_ORDER_ID)) {
                paymentData.setOrderId(jSONObject.getString(RAZORPAY_ORDER_ID));
            }
            if (jSONObject.has(RAZORPAY_SIGNATURE)) {
                paymentData.setSignature(jSONObject.getString(RAZORPAY_SIGNATURE));
            }
        } catch (JSONException e) {
            AnalyticsUtil.reportError(e, "error", e.getMessage());
        }
        return paymentData;
    }

    /* access modifiers changed from: private */
    public static String getPaymentMethodsFromPreferences(String str) {
        try {
            return new JSONObject(str).getJSONObject("methods").toString();
        } catch (Exception e) {
            e.printStackTrace();
            AnalyticsUtil.reportError(e, "error", e.getMessage());
            return null;
        }
    }

    private static String getPaymentResult(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return null;
        }
        return extras.getString("RESULT");
    }

    private String getPreferencesFromCache() {
        if (!d__1_.a(BaseConstants.PAYMENT_PREFERENCES_CACHE_KEY)) {
            return d__1_.b(BaseConstants.PAYMENT_PREFERENCES_CACHE_KEY);
        }
        return null;
    }

    private static List<ApplicationDetails> getSchemaSupportedApps(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> listOfAppsWhichHandleDeepLink = BaseUtils.getListOfAppsWhichHandleDeepLink(context, str);
        if (listOfAppsWhichHandleDeepLink != null && listOfAppsWhichHandleDeepLink.size() > 0) {
            for (ResolveInfo resolveInfo : listOfAppsWhichHandleDeepLink) {
                try {
                    arrayList.add(getAppDetailsFromPackageName(context, resolveInfo.activityInfo.packageName));
                } catch (Exception e) {
                    e.printStackTrace();
                    AnalyticsUtil.reportError(e, AnalyticsConstants.CRITICAL, e.getMessage());
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static long getSubscriptionAmountFromPreferences(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("subscription");
            if (jSONObject != null) {
                return jSONObject.getLong(AnalyticsConstants.AMOUNT);
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            AnalyticsUtil.reportError(e, "error", e.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static List<ApplicationDetails> getUPISupportedApps(Context context) {
        HashSet<String> filteredDeviceUpiAppsPackageSet = getFilteredDeviceUpiAppsPackageSet(context);
        List<ResolveInfo> listOfAppsWhichHandleDeepLink = BaseUtils.getListOfAppsWhichHandleDeepLink(context, BaseConstants.UPI_URL_SCHEMA);
        ArrayList arrayList = new ArrayList();
        if (listOfAppsWhichHandleDeepLink != null && listOfAppsWhichHandleDeepLink.size() > 0) {
            for (ResolveInfo resolveInfo : listOfAppsWhichHandleDeepLink) {
                if (filteredDeviceUpiAppsPackageSet.contains(resolveInfo.activityInfo.packageName)) {
                    try {
                        arrayList.add(getAppDetailsFromPackageName(context, resolveInfo.activityInfo.packageName));
                    } catch (Exception e) {
                        e.printStackTrace();
                        AnalyticsUtil.reportError(e, "error", e.getMessage());
                    }
                }
            }
        }
        return arrayList;
    }

    private String getValueFromJsonArray(String str, JSONObject jSONObject) {
        if (!jSONObject.has(RAZORPAY_PAYMENT_ID) || !jSONObject.has("next")) {
            return null;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("next");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getJSONObject(i).getString("action").equalsIgnoreCase(str)) {
                    return jSONArray.getJSONObject(i).getString("url");
                }
            }
            return null;
        } catch (JSONException e) {
            AnalyticsUtil.reportError(e, "error", e.getMessage());
            return null;
        }
    }

    private void handlePayload(JSONObject jSONObject) {
        this.merchPassedUPIPackageName = null;
        this.mShouldDisplayLogo = true;
        if (jSONObject.has("method") && jSONObject.getString("method").equalsIgnoreCase(AnalyticsConstants.UPI) && jSONObject.has("_[flow]") && jSONObject.getString("_[flow]").equalsIgnoreCase(AnalyticsConstants.INTENT)) {
            initUpiIntent();
            if (jSONObject.has(AnalyticsConstants.UPI_APP_PACKAGE_NAME)) {
                String string = jSONObject.getString(AnalyticsConstants.UPI_APP_PACKAGE_NAME);
                this.merchPassedUPIPackageName = string;
                AnalyticsUtil.addProperty(AnalyticsConstants.UPI_APP_PACKAGE_NAME, new AnalyticsProperty(string, AnalyticsProperty.Scope.PAYMENT));
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_APP_PASSED);
            } else if (jSONObject.has("preferred_apps_order") || jSONObject.has("other_apps_order")) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_INTENT_APPS_PREFERENCE_PASSED);
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                if (jSONObject.has("preferred_apps_order")) {
                    jSONArray = jSONObject.getJSONArray("preferred_apps_order");
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_INTENT_APPS_PREFERRED_ORDER_PASSED);
                }
                if (jSONObject.has("other_apps_order")) {
                    jSONArray2 = jSONObject.getJSONArray("other_apps_order");
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_INTENT_APPS_OTHER_ORDER_PASSED);
                }
                setOrderOfUpiApps(jSONArray, jSONArray2);
            }
        }
        if (jSONObject.has("display_logo")) {
            this.mShouldDisplayLogo = jSONObject.getBoolean("display_logo");
        }
    }

    private void initRazorpay(Activity activity2) {
        AnalyticsUtil.libraryType = "CUSTOM";
        BaseConfig.getAdvertisingIdFromUtil(activity2);
        String str = f$_G$.b;
        try {
            if (!str.equalsIgnoreCase(I$_n_.a(activity2, "sdk_version"))) {
                I$_n_.b(activity2, BaseConfig.CONFIG_JSON, null);
                I$_n_.b(activity2, BaseConfig.CONFIG_VERSION, null);
                I$_n_.b(activity2, "sdk_version", str);
            }
        } catch (NullPointerException unused) {
            I$_n_.b(activity2, BaseConfig.CONFIG_JSON, null);
            I$_n_.b(activity2, BaseConfig.CONFIG_VERSION, null);
            I$_n_.b(activity2, "sdk_version", str);
        }
        f$_G$.a().a(activity2);
        BaseUtils.checkForLatestVersion(activity2, f$_G$.c);
        BaseUtils.setup();
        d__1_.f693a = activity2.getCacheDir();
        this.activity = activity2;
        String str2 = this.apiKey;
        if (str2 == null || str2.isEmpty()) {
            this.apiKey = BaseUtils.getKeyId(activity2);
        }
        String str3 = this.apiKey;
        if (str3 == null || str3.isEmpty()) {
            throw new RuntimeException(BaseConstants.KEY_MISSING_EXCEPTION);
        }
        activity2.getWindow().setSoftInputMode(16);
        if (activity2 instanceof PaymentResultListener) {
            this.paymentResultListener = (PaymentResultListener) activity2;
        } else if (activity2 instanceof PaymentResultWithDataListener) {
            this.paymentResultWithDataListener = (PaymentResultWithDataListener) activity2;
        }
        f$_G$.d = isMagicPresent();
        f$_G$.a(activity2, this.apiKey);
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_INIT_END);
    }

    private void initRemainingApps() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.filteredUpiPackageToAppDetails.keySet());
        this.remainingApps = new ArrayList<>();
        Iterator<String> it = this.configAppsPreferredOrder.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.filteredUpiPackageToAppDetails.containsKey(next)) {
                arrayList.remove(next);
                this.remainingApps.add(next);
            }
        }
        this.remainingApps.addAll(arrayList);
    }

    private void initUpiIntent() {
        f$_G$ a2 = f$_G$.a();
        this.allUpiDeviceApps = BaseUtils.getSetOfPackageNamesSupportingUpi(this.activity);
        boolean b = a2.b();
        this.isWhiteListingEnabled = b;
        if (b) {
            HashSet<String> c = a2.c();
            this.upiWhiteListedApps = c;
            if (c == null) {
                this.upiWhiteListedApps = new HashSet<>();
            }
        } else {
            HashSet<String> d = a2.d();
            this.upiBlacklistedApps = d;
            if (d == null) {
                this.upiBlacklistedApps = new HashSet<>();
            }
        }
        LinkedHashSet<String> e = a2.e();
        this.configAppsPreferredOrder = e;
        if (e == null) {
            this.configAppsPreferredOrder = new LinkedHashSet<>();
        }
        setFilteredUpiAppsPackageToAppDetails();
        initRemainingApps();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isApiCallSuccessful(ResponseObject responseObject) {
        try {
            JSONObject jSONObject = new JSONObject(responseObject.getResponseResult());
            if (responseObject.getResponseCode() < 400 && !jSONObject.has("error")) {
                return true;
            }
            return false;
        } catch (JSONException e) {
            AnalyticsUtil.reportError(e, "error", e.getMessage());
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isCredAppInstalled(android.content.Context r3) {
        /*
            java.lang.String r0 = "credpay://checkout"
            java.util.List r3 = getSchemaSupportedApps(r3, r0)
            java.util.Iterator r3 = r3.iterator()
        L_0x000a:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0030
            java.lang.Object r0 = r3.next()
            com.razorpay.ApplicationDetails r0 = (com.razorpay.ApplicationDetails) r0
            java.lang.String r1 = r0.getAppName()
            java.lang.String r2 = "cred"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 != 0) goto L_0x002e
            java.lang.String r0 = r0.getAppName()
            java.lang.String r1 = "cred qa"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x000a
        L_0x002e:
            r3 = 1
            return r3
        L_0x0030:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseRazorpay.isCredAppInstalled(android.content.Context):boolean");
    }

    private boolean isPluginSupportedApp(HashMap<String, String> hashMap, String str) {
        return str.equalsIgnoreCase(BaseConstants.GOOGLE_PAY_PKG) && hashMap.containsKey("com.razorpay.plugin.googlepay");
    }

    private final void markPaymentCancelled() {
        if (this.payment_id != null) {
            try {
                String constructBasicAuth = BaseUtils.constructBasicAuth(this.apiKey);
                HashMap hashMap = new HashMap();
                hashMap.put("Authorization", "Basic " + constructBasicAuth);
                T__j$.a(BaseConstants.RZP_PAYMENTS_ENDPOINT + this.payment_id + "/cancel?platform=android_sdk", hashMap, new Callback() {
                    /* class com.razorpay.BaseRazorpay.AnonymousClass4 */

                    @Override // com.razorpay.Callback
                    public void run(ResponseObject responseObject) {
                        responseObject.getResponseResult();
                    }
                });
                this.payment_id = null;
            } catch (Exception e) {
                e.getMessage();
                AnalyticsUtil.reportError(e, AnalyticsConstants.WARNING, e.getMessage());
            }
        }
    }

    private void navigateToApp(String str, String str2) {
        BaseUtils.startActivityForResult(str2, str, this.activity);
        HashMap hashMap = new HashMap();
        if (str2 == null) {
            str2 = AnalyticsConstants.NULL;
        }
        hashMap.put("url", str2);
        hashMap.put("custom_chooser", Boolean.TRUE);
        hashMap.put("package_name", str);
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_APP_LAUNCHED, hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void openNativeApplication(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.activity.startActivityForResult(intent, 20);
    }

    private void payWithCred() {
        HashMap m0 = hj1.m0("content-type", "application/json");
        this.webview.setVisibility(8);
        try {
            this.payload.put("key_id", this.apiKey);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", SettingsJsonConstants.APP_KEY);
            jSONObject.put(User.DEVICE_META_OS_NAME, "android");
            jSONObject.put(AnalyticsConstants.DEVICE, "mobile");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("agent", jSONObject);
            this.payload.put("_", jSONObject2);
            T__j$.a(hj1.a0(new StringBuilder(), apiUrl, "payments/create/ajax"), this.payload.toString(), m0, new Callback() {
                /* class com.razorpay.BaseRazorpay.AnonymousClass2 */

                @Override // com.razorpay.Callback
                public void run(ResponseObject responseObject) {
                    try {
                        JSONObject jSONObject = new JSONObject(responseObject.getResponseResult());
                        JSONObject jSONObject2 = new JSONObject(responseObject.getResponseResult());
                        if (responseObject.getResponseCode() >= 400) {
                            BaseRazorpay.this.onError(5, "{\"error\":{\"code\": \"BAD_REQUEST_ERROR\", \"description\": \"An error occured while fetching payment details\"}}");
                        } else if (jSONObject2.has("error")) {
                            BaseRazorpay baseRazorpay = BaseRazorpay.this;
                            baseRazorpay.onError(5, "{\"error\":{\"code\":3, \"description\": " + responseObject.toString() + "}}");
                        } else {
                            if (jSONObject.has("request")) {
                                JSONObject jSONObject3 = jSONObject.getJSONObject("request");
                                BaseRazorpay.this.credStatusUrl = jSONObject3.getString("url");
                            }
                            if (jSONObject.has("data")) {
                                I$_n_.b(BaseRazorpay.this.activity, BaseRazorpay.RAZORPAY_PAYMENT_ID, jSONObject.getString("payment_id"));
                                BaseRazorpay.this.openNativeApplication(jSONObject.getJSONObject("data").getString("intent_url"));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        AnalyticsUtil.reportError(e, AnalyticsConstants.CRITICAL, e.getMessage());
                    }
                }
            });
        } catch (JSONException e) {
            AnalyticsUtil.reportError(e, "error", e.getMessage());
        }
    }

    private void postSms(Intent intent) {
        String stringExtra = intent.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AnalyticsConstants.SENDER, BaseConstants.DEFAULT_SENDER);
            jSONObject.put("message", stringExtra);
            String jSONObject2 = jSONObject.toString();
            this.webview.loadUrl(String.format("javascript:OTPElf.elfBridge.setSms(%s)", jSONObject2));
            AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_OTP_POPULATION_JS);
        } catch (Exception e) {
            AnalyticsUtil.reportError(e, AnalyticsConstants.ERROR_EXCEPTION, e.getLocalizedMessage());
            d__1_.a("Exception", e);
        }
    }

    private void setFilteredUpiAppsPackageToAppDetails() {
        this.filteredUpiPackageToAppDetails = new HashMap<>();
        if (this.isWhiteListingEnabled) {
            Iterator<String> it = this.upiWhiteListedApps.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.allUpiDeviceApps.contains(next)) {
                    try {
                        this.filteredUpiPackageToAppDetails.put(next, getAppDetailsFromPackageName(this.activity, next));
                    } catch (Exception e) {
                        e.printStackTrace();
                        AnalyticsUtil.reportError(e, "error", e.getMessage());
                    }
                }
            }
            return;
        }
        Iterator<String> it2 = this.allUpiDeviceApps.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!this.upiBlacklistedApps.contains(next2)) {
                try {
                    this.filteredUpiPackageToAppDetails.put(next2, getAppDetailsFromPackageName(this.activity, next2));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                }
            }
        }
    }

    private void setOrderOfUpiApps(JSONArray jSONArray, JSONArray jSONArray2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    arrayList.add(jSONArray.getString(i));
                } catch (Exception e) {
                    e.printStackTrace();
                    AnalyticsUtil.reportError(e, "error", e.getMessage());
                }
            }
        }
        if (jSONArray2 != null) {
            int length2 = jSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                try {
                    arrayList2.add(jSONArray2.getString(i2));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                }
            }
        }
        initRemainingApps();
        this.merchantPreferredUpiAppsOrder = new ArrayList<>();
        this.merchantOtherUpiAppsOrder = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.filteredUpiPackageToAppDetails.containsKey(str)) {
                this.merchantPreferredUpiAppsOrder.add(str);
                this.remainingApps.remove(str);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (this.filteredUpiPackageToAppDetails.containsKey(str2)) {
                this.merchantOtherUpiAppsOrder.add(str2);
                this.remainingApps.remove(str2);
            }
        }
    }

    private void showCustomAppChooser(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url_data", str);
        bundle.putStringArrayList("merchant_preferred_upi_apps_order", this.merchantPreferredUpiAppsOrder);
        bundle.putStringArrayList("merchant_other_upi_apps_order", this.merchantOtherUpiAppsOrder);
        bundle.putStringArrayList("list_remaining_apps", this.remainingApps);
        bundle.putSerializable("upi_package_to_app_details", this.filteredUpiPackageToAppDetails);
        AppSelectorFragment appSelectorFragment = new AppSelectorFragment();
        appSelectorFragment.setAppSelectListener(this);
        appSelectorFragment.setArguments(bundle);
        this.activity.getFragmentManager().beginTransaction().add(16908290, appSelectorFragment, "AppSelectorFragment").addToBackStack("AppSelectorFragment").commitAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startPollingForStatus() {
        T__j$.a(this.credStatusUrl, new Callback() {
            /* class com.razorpay.BaseRazorpay.AnonymousClass9 */

            @Override // com.razorpay.Callback
            public void run(ResponseObject responseObject) {
                if (responseObject.getResponseCode() == 404) {
                    BaseRazorpay.this.onError(408, "{\"error\":{\"code\":408, \"description\": Payment Unsuccessful}}");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(responseObject.getResponseResult());
                    if (jSONObject.has(BaseRazorpay.RAZORPAY_PAYMENT_ID) && jSONObject.has(BaseRazorpay.RAZORPAY_ORDER_ID) && jSONObject.has(BaseRazorpay.RAZORPAY_SIGNATURE)) {
                        BaseRazorpay.this.oncomplete((BaseRazorpay) jSONObject);
                    } else if (jSONObject.has("status") && jSONObject.getString("status").equalsIgnoreCase("created")) {
                        new CountDownTimer(3000, 1000) {
                            /* class com.razorpay.BaseRazorpay.AnonymousClass9.AnonymousClass1 */

                            public void onFinish() {
                                BaseRazorpay.this.startPollingForStatus();
                            }

                            public void onTick(long j) {
                            }
                        }.start();
                    } else if (jSONObject.has("error")) {
                        BaseRazorpay.this.oncomplete((BaseRazorpay) jSONObject);
                    }
                } catch (JSONException e) {
                    AnalyticsUtil.reportError(e, AnalyticsConstants.CRITICAL, e.getLocalizedMessage());
                }
            }
        });
    }

    @JavascriptInterface
    public final void callNativeIntent(String str) {
        this.urlData = str;
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_NATIVE_INTENT_CALLED);
        try {
            if (!this.payload.has(AnalyticsConstants.UPI_APP_PACKAGE_NAME) || !this.payload.getString(AnalyticsConstants.UPI_APP_PACKAGE_NAME).equals(BaseConstants.GOOGLE_PAY_PKG)) {
                String str2 = this.merchPassedUPIPackageName;
                if (str2 == null || !this.allUpiDeviceApps.contains(str2)) {
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_CUSTOM_APP_CHOOSER_SHOWN);
                    showCustomAppChooser(str);
                    return;
                }
                BaseUtils.startActivityForResult(str, this.merchPassedUPIPackageName, this.activity);
                HashMap hashMap = new HashMap();
                if (str == null) {
                    str = AnalyticsConstants.NULL;
                }
                hashMap.put("url", str);
                hashMap.put("custom_chooser", Boolean.FALSE);
                hashMap.put("package_name", this.merchPassedUPIPackageName);
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_MERCHANT_PASSED_APP_LAUNCHED, hashMap);
                return;
            }
            openUpiApp(BaseConstants.GOOGLE_PAY_PKG, this.urlData);
        } catch (JSONException e) {
            e.printStackTrace();
            AnalyticsUtil.reportError(e, "error", e.getMessage());
        }
    }

    public void changeApiKey(String str) {
        d__1_.a(BaseConstants.PAYMENT_PREFERENCES_CACHE_KEY, "", -1);
        this.apiKey = str;
        initRazorpay(this.activity);
    }

    public void checkAndRestorePreviousSessionIfRetry(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(AnalyticsConstants.AMOUNT);
            if (string != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (I$_n_.a(this.activity).getBoolean("rzp_last_payment_status", false)) {
                    b_$A$.a((Context) this.activity, false);
                } else {
                    String string2 = I$_n_.a(this.activity).getString("rzp_last_payment_amount", null);
                    long j = I$_n_.a(this.activity).getLong("rzp_last_payment_timestamp", 0);
                    if (string2 != null && j != 0 && string.equalsIgnoreCase(string2) && currentTimeMillis - j < 600000) {
                        AnalyticsUtil.setLocalOrderId(I$_n_.a(this.activity).getString("rzp_last_payment_session_id", null));
                    }
                }
                I$_n_.b(this.activity).putString("rzp_last_payment_amount", string).apply();
                I$_n_.b(this.activity).putLong("rzp_last_payment_timestamp", currentTimeMillis).apply();
                Activity activity2 = this.activity;
                I$_n_.b(activity2).putString("rzp_last_payment_session_id", AnalyticsUtil.getLocalOrderId()).apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
            AnalyticsUtil.reportError(e, "error", e.getMessage());
        }
    }

    public void finish() {
        AnalyticsUtil.postData();
        AnalyticsUtil.refreshOrderSession();
        this.payment_id = null;
        this.ongoingPayment = false;
        this.webview.loadUrl("about:blank");
        r_$Z$.a();
    }

    public String getBankLogoUrl(String str) {
        return f$_G$.a().l() + str + "." + f$_G$.a().m();
    }

    public String getCardNetwork(String str) {
        return b_$A$.b(str);
    }

    public int getCardNetworkLength(String str) {
        return b_$A$.c(str);
    }

    public void getCardOtpData(final CardsFlowCallback cardsFlowCallback) {
        if (this.cardsFlowPayload.has(RAZORPAY_PAYMENT_ID)) {
            callApi(getValueFromJsonArray("otp_generate", this.cardsFlowPayload), null, new NativeOtpCallback() {
                /* class com.razorpay.BaseRazorpay.AnonymousClass12 */

                @Override // com.razorpay.NativeOtpCallback
                public void onError(int i, String str) {
                    BaseRazorpay.this.onError(i, str);
                }

                @Override // com.razorpay.NativeOtpCallback
                public void onResponse(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONArray jSONArray = jSONObject.getJSONArray("next");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            if (jSONArray.getJSONObject(i).getString("action").equalsIgnoreCase("otp_submit")) {
                                BaseRazorpay.this.otpGeneratePayload = jSONObject;
                                cardsFlowCallback.otpGenerateResponse(true);
                                return;
                            }
                        }
                        cardsFlowCallback.otpGenerateResponse(false);
                    } catch (JSONException e) {
                        AnalyticsUtil.reportError(e, "error", e.getMessage());
                        cardsFlowCallback.otpGenerateResponse(false);
                    }
                }
            });
        }
    }

    public void getCardsFlow(JSONObject jSONObject, final CardsFlowCallback cardsFlowCallback) {
        callApi(apiUrl + "payments/create/checkout/json?key_id=" + this.apiKey, jSONObject.toString(), new NativeOtpCallback() {
            /* class com.razorpay.BaseRazorpay.AnonymousClass11 */

            @Override // com.razorpay.NativeOtpCallback
            public void onError(int i, String str) {
                BaseRazorpay.this.onError(5, BaseUtils.makeErrorPayload("BAD_REQUEST_ERROR", "An error occurred while fetch Payment Details from API"));
            }

            @Override // com.razorpay.NativeOtpCallback
            public void onResponse(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONArray jSONArray = jSONObject.getJSONArray("next");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (jSONArray.getJSONObject(i).getString("action").equalsIgnoreCase("otp_generate")) {
                            BaseRazorpay.this.cardsFlowPayload = jSONObject;
                            cardsFlowCallback.isNativeOtpEnabled(true);
                            return;
                        }
                    }
                    cardsFlowCallback.isNativeOtpEnabled(false);
                } catch (JSONException e) {
                    AnalyticsUtil.reportError(e, "error", e.getMessage());
                    onError(4, BaseUtils.makeErrorPayload("JSON_PARSING_ERROR", "An error occurred while parsing the JSON payload"));
                }
            }
        });
    }

    public void getPaymentMethods(PaymentMethodsCallback paymentMethodsCallback) {
        getPaymentMethods(null, paymentMethodsCallback);
    }

    public void getSubscriptionAmount(String str, final SubscriptionAmountCallback subscriptionAmountCallback) {
        fetchPreferences(str, new FetchPreferencesCallback() {
            /* class com.razorpay.BaseRazorpay.AnonymousClass6 */

            @Override // com.razorpay.FetchPreferencesCallback
            public void onError(String str) {
                subscriptionAmountCallback.onError(str);
            }

            @Override // com.razorpay.FetchPreferencesCallback
            public void onResponse(String str) {
                subscriptionAmountCallback.onSubscriptionAmountReceived(BaseRazorpay.getSubscriptionAmountFromPreferences(str));
            }
        });
    }

    public String getWalletLogoUrl(String str) {
        return f$_G$.a().h() + str + "." + f$_G$.a().i();
    }

    public String getWalletSqLogoUrl(String str) {
        return f$_G$.a().j() + str + "." + f$_G$.a().k();
    }

    public boolean isMagicPresent() {
        return false;
    }

    public boolean isValidCardNumber(String str) {
        int length = str.length();
        int[] iArr = new int[length];
        for (int i = 0; i < str.length(); i++) {
            Character valueOf = Character.valueOf(str.charAt(i));
            StringBuilder sb = new StringBuilder();
            sb.append(valueOf);
            iArr[i] = Integer.parseInt(sb.toString());
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[(length - i3) - 1];
            if (i3 % 2 == 1) {
                i4 <<= 1;
            }
            if (i4 > 9) {
                i4 -= 9;
            }
            i2 += i4;
        }
        if (i2 % 10 == 0) {
            return true;
        }
        return false;
    }

    public void isValidVpa(String str, final ValidateVpaCallback validateVpaCallback) {
        if (str.isEmpty()) {
            validateVpaCallback.onFailure();
            return;
        }
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_VALIDATE_VPA_CALLED);
        String a0 = hj1.a0(new StringBuilder(), apiUrl, "payments/validate/account");
        HashMap m0 = hj1.m0("Content-Type", "application/x-www-form-urlencoded");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("entity", "vpa");
            jSONObject.put(FirebaseAnalytics.Param.VALUE, str);
            jSONObject.put("key_id", this.apiKey);
            T__j$.a(a0, BaseUtils.makeUrlEncodedPayload(jSONObject), m0, new Callback() {
                /* class com.razorpay.BaseRazorpay.AnonymousClass8 */

                @Override // com.razorpay.Callback
                public void run(ResponseObject responseObject) {
                    try {
                        validateVpaCallback.onResponse(new JSONObject(responseObject.getResponseResult()).getBoolean("success"));
                    } catch (JSONException e) {
                        validateVpaCallback.onFailure();
                        e.printStackTrace();
                        AnalyticsUtil.reportError(e, AnalyticsConstants.WARNING, e.getMessage());
                    }
                }
            });
        } catch (JSONException e) {
            validateVpaCallback.onFailure();
            e.printStackTrace();
            AnalyticsUtil.reportError(e, AnalyticsConstants.WARNING, e.getMessage());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.isExtRzpPluginActive) {
            this.extActiveRzpPluginInstance.onActivityResult(this.apiKey, i, i2, intent);
            this.activity.getFragmentManager().popBackStack();
        } else if (intent == null) {
            oncomplete("{error:{code: 'BAD_REQUEST_ERROR' , description : 'Payment processing cancelled by user'}}");
            this.activity.getFragmentManager().popBackStack();
        } else {
            this.activity.getFragmentManager().popBackStack();
            if (i == 1001) {
                if (i2 == -1) {
                    postSms(intent);
                } else {
                    AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_CONSENT_DECLINED);
                }
            } else if (i == 99) {
                HashMap hashMap = new HashMap();
                JSONObject jSONFromIntentData = BaseUtils.getJSONFromIntentData(intent);
                if (jSONFromIntentData.optString("Status").equalsIgnoreCase(AnalyticsConstants.FAILURE) || jSONFromIntentData.optString("Status").startsWith(AnalyticsConstants.FAIL)) {
                    onError(5, BaseUtils.getPaymentCancelledResponse(this.payment_id));
                    return;
                }
                WebView webView = this.webview;
                if (webView == null || webView.getUrl() == null || !this.webview.getUrl().contains(BaseConstants.RZP_URL)) {
                    hashMap.put(AnalyticsConstants.ACTIVITY_DESTROYED, Boolean.TRUE);
                    b_$A$.a(jSONFromIntentData, this.activity, this.apiKey, this);
                } else {
                    hashMap.put(AnalyticsConstants.ACTIVITY_DESTROYED, Boolean.FALSE);
                    try {
                        jSONFromIntentData.put("isWebviewVisible", this.webview.getVisibility() == 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                        AnalyticsUtil.reportError(e, "error", e.getMessage());
                    }
                    this.webview.loadUrl(String.format("javascript: appLaunched(%s)", this.upiAppLaunchedPackageName));
                    this.webview.loadUrl(String.format("javascript: pollStatus(%s)", jSONFromIntentData.toString()));
                }
                hashMap.put("result", jSONFromIntentData);
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_NATIVE_INTENT_ONACTIVITY_RESULT, hashMap);
            }
        }
    }

    public void onBackPressed() {
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_BACK_PRESSED_HARD);
        if (this.ongoingPayment) {
            trackBackPress();
            markPaymentCancelled();
        }
        finish();
    }

    public void onError(int i, String str) {
        PaymentResultListener paymentResultListener2 = this.paymentResultListener;
        if (paymentResultListener2 != null) {
            paymentResultListener2.onPaymentError(i, str);
            return;
        }
        PaymentResultWithDataListener paymentResultWithDataListener2 = this.paymentResultWithDataListener;
        if (paymentResultWithDataListener2 != null) {
            paymentResultWithDataListener2.onPaymentError(i, str, new PaymentData());
        }
    }

    public void onPageFinished(WebView webView, String str) {
    }

    public void onPageStarted(WebView webView, String str) {
    }

    @Override // com.razorpay.RzpInternalCallback
    public void onPaymentError(int i, String str) {
        HashMap m0 = hj1.m0("response", str);
        m0.put("code", Integer.valueOf(i));
        AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PLUGIN_INTERNAL_CALLBACK_ERROR, m0);
        try {
            oncomplete(new JSONObject(str).toString());
        } catch (Exception e) {
            AnalyticsUtil.reportError(e, AnalyticsConstants.CRITICAL, e.getLocalizedMessage());
            AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_PLUGIN_INTERNAL_CALLBACK_ERROR_EXCEPTION);
            oncomplete(str);
        }
    }

    @Override // com.razorpay.RzpInternalCallback
    public void onPaymentSuccess(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("provider") && jSONObject.get("provider").equals("GOOGLE_PAY")) {
                HashMap hashMap = new HashMap();
                WebView webView = this.webview;
                if (webView == null || webView.getUrl() == null || !this.webview.getUrl().contains(BaseConstants.RZP_URL)) {
                    hashMap.put(AnalyticsConstants.ACTIVITY_DESTROYED, Boolean.TRUE);
                    b_$A$.a(jSONObject, this.activity, this.apiKey, this);
                } else {
                    hashMap.put(AnalyticsConstants.ACTIVITY_DESTROYED, Boolean.FALSE);
                    try {
                        jSONObject.put("isWebviewVisible", this.webview.getVisibility() == 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                        AnalyticsUtil.reportError(e, "error", e.getMessage());
                    }
                    this.webview.loadUrl(String.format("javascript: pollStatus(%s)", jSONObject.toString()));
                }
                hashMap.put("result", jSONObject);
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_NATIVE_INTENT_ONACTIVITY_RESULT, hashMap);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
        }
    }

    public void onProgressChanged(WebView webView, int i) {
    }

    public abstract void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public void onSuccess(String str, PaymentData paymentData) {
        PaymentResultListener paymentResultListener2 = this.paymentResultListener;
        if (paymentResultListener2 != null) {
            paymentResultListener2.onPaymentSuccess(str);
            return;
        }
        PaymentResultWithDataListener paymentResultWithDataListener2 = this.paymentResultWithDataListener;
        if (paymentResultWithDataListener2 != null) {
            paymentResultWithDataListener2.onPaymentSuccess(str, paymentData);
        }
    }

    @Override // com.razorpay.OnAppSelectedListener
    public void onUpiAppLaunched(String str, String str2) {
        this.upiAppLaunchedPackageName = str;
    }

    @Override // com.razorpay.PaymentCompleteInternalCallback
    @JavascriptInterface
    public final void oncomplete(final String str) {
        this.activity.runOnUiThread(new Runnable() {
            /* class com.razorpay.BaseRazorpay.AnonymousClass3 */

            public void run() {
                I$_n_.b(BaseRazorpay.this.activity, BaseRazorpay.RAZORPAY_PAYMENT_ID, null);
                try {
                    BaseRazorpay.this.oncomplete((BaseRazorpay) new JSONObject(str));
                } catch (Exception e) {
                    BaseRazorpay.this.onError(4, e.getMessage());
                    AnalyticsUtil.reportError(e, "error", e.getMessage());
                }
                BaseRazorpay.this.finish();
            }
        });
    }

    public void openCheckout(JSONObject jSONObject, PaymentResultListener paymentResultListener2) {
        this.paymentResultListener = paymentResultListener2;
        openCheckout(jSONObject);
    }

    @Override // com.razorpay.OnAppSelectedListener
    public void openUpiApp(String str, String str2) {
        HashMap<String, String> allPluginsFromManifest = BaseUtils.getAllPluginsFromManifest(this.activity);
        if (allPluginsFromManifest == null || allPluginsFromManifest.size() == 0 || !isPluginSupportedApp(allPluginsFromManifest, str)) {
            navigateToApp(str, str2);
            return;
        }
        for (String str3 : allPluginsFromManifest.values()) {
            try {
                RzpPlugin rzpPlugin = (RzpPlugin) RzpPlugin.class.getClassLoader().loadClass(str3).newInstance();
                if (str.equalsIgnoreCase(BaseConstants.GOOGLE_PAY_PKG)) {
                    rzpPlugin.isRegistered(this.activity, new RzpPluginRegisterCallback() {
                        /* class com.razorpay.BaseRazorpay.AnonymousClass10 */

                        @Override // com.razorpay.RzpPluginRegisterCallback
                        public void onResponse(boolean z) {
                        }
                    });
                    try {
                        this.payload.put("_[app]", str);
                        this.payload.put("url_data", str2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        AnalyticsUtil.reportError(e, "error", e.getMessage());
                    }
                }
                if (rzpPlugin.doesHandlePayload(this.apiKey, this.payload, this.activity)) {
                    this.isExtRzpPluginActive = true;
                    this.extActiveRzpPluginInstance = rzpPlugin;
                    rzpPlugin.processPayment(this.apiKey, this.payload, this.activity, this);
                    return;
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NullPointerException e2) {
                navigateToApp(str, str2);
                e2.printStackTrace();
                AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                return;
            }
        }
    }

    public void otpResend(final CardsFlowCallback cardsFlowCallback) {
        callApi(getValueFromJsonArray("otp_resend", this.otpGeneratePayload), null, new NativeOtpCallback() {
            /* class com.razorpay.BaseRazorpay.AnonymousClass13 */

            @Override // com.razorpay.NativeOtpCallback
            public void onError(int i, String str) {
                BaseRazorpay.this.onError(i, str);
            }

            @Override // com.razorpay.NativeOtpCallback
            public void onResponse(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONArray jSONArray = jSONObject.getJSONArray("next");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (jSONArray.getJSONObject(i).getString("action").equalsIgnoreCase("otp_submit")) {
                            BaseRazorpay.this.otpGeneratePayload = jSONObject;
                            cardsFlowCallback.otpResendResponse(true);
                            return;
                        }
                    }
                    cardsFlowCallback.otpResendResponse(false);
                } catch (JSONException e) {
                    AnalyticsUtil.reportError(e, "error", e.getMessage());
                    cardsFlowCallback.otpGenerateResponse(false);
                }
            }
        });
    }

    public void otpSubmit(String str, final CardsFlowCallback cardsFlowCallback) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AnalyticsConstants.OTP, str);
            callApi(getValueFromJsonArray("otp_submit", this.otpGeneratePayload), jSONObject.toString(), new NativeOtpCallback() {
                /* class com.razorpay.BaseRazorpay.AnonymousClass14 */

                @Override // com.razorpay.NativeOtpCallback
                public void onError(int i, String str) {
                    BaseRazorpay.this.onError(i, str);
                }

                @Override // com.razorpay.NativeOtpCallback
                public void onResponse(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!jSONObject.has("next")) {
                            BaseRazorpay.this.oncomplete((BaseRazorpay) jSONObject);
                        } else {
                            cardsFlowCallback.onOtpSubmitError(true);
                        }
                    } catch (JSONException e) {
                        AnalyticsUtil.reportError(e, "error", e.getMessage());
                        cardsFlowCallback.onOtpSubmitError(true);
                    }
                }
            });
        } catch (JSONException e) {
            AnalyticsUtil.reportError(e, "error", e.getMessage());
        }
    }

    public void redirectToBankPage() {
        this.webview.loadUrl(getValueFromJsonArray("redirect", this.cardsFlowPayload));
    }

    public final void reset() {
        finish();
    }

    public final void setMagicView(ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.magicView = viewGroup;
            this.useBottomSheet = false;
            return;
        }
        throw new RuntimeException("Magic View cannot be null");
    }

    @JavascriptInterface
    public final void setPaymentID(String str) {
        this.payment_id = str;
        setPaymentIdInAddon(str);
        AnalyticsUtil.addProperty("payment_id", new AnalyticsProperty(str, AnalyticsProperty.Scope.PAYMENT));
        I$_n_.b(this.activity, RAZORPAY_PAYMENT_ID, str);
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_PAYMENT_ID_ATTACHED);
    }

    public abstract void setPaymentIdInAddon(String str);

    public abstract void setUpAddon(JSONObject jSONObject);

    public void setWebChromeClient(RazorpayWebChromeClient razorpayWebChromeClient2) {
        this.razorpayWebChromeClient = razorpayWebChromeClient2;
    }

    public void setWebView(WebView webView) {
        this.webview = webView;
        BaseUtils.setWebViewSettings(this.activity, webView, true);
        webView.clearFormData();
        webView.addJavascriptInterface(this, "CheckoutBridge");
    }

    public void setWebviewClient(RazorpayWebViewClient razorpayWebViewClient2) {
        this.razorpayWebViewClient = razorpayWebViewClient2;
    }

    public void setup(JSONObject jSONObject) {
        if (this.webview instanceof WebView) {
            AnalyticsUtil.setup(this.activity, this.apiKey, f$_G$.f694a, f$_G$.c, f$_G$.b);
            if (this.razorpayWebChromeClient == null) {
                this.razorpayWebChromeClient = new RazorpayWebChromeClient(this);
            }
            if (this.razorpayWebViewClient == null) {
                this.razorpayWebViewClient = new RazorpayWebViewClient(this);
            }
            this.webview.setWebViewClient(this.razorpayWebViewClient);
            this.webview.setWebChromeClient(this.razorpayWebChromeClient);
            this.payment_id = null;
            this.ongoingPayment = true;
            checkAndRestorePreviousSessionIfRetry(jSONObject);
            setUpAddon(jSONObject);
            return;
        }
        throw new Exception("WebView Inaccessible");
    }

    public void submit(JSONObject jSONObject, PaymentResultListener paymentResultListener2) {
        this.paymentResultListener = paymentResultListener2;
        submit(jSONObject);
    }

    public abstract void trackBackPress();

    public void validateFields(JSONObject jSONObject, ValidationListener validationListener) {
        Map<String, String> validateFields = Validation.validateFields(jSONObject);
        if (validateFields == null) {
            validationListener.onValidationSuccess();
        } else {
            validationListener.onValidationError(validateFields);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void oncomplete(JSONObject jSONObject) {
        try {
            if (jSONObject.has("error")) {
                int i = 5;
                AnalyticsProperty.Scope scope = AnalyticsProperty.Scope.PAYMENT;
                AnalyticsUtil.addProperty("payment_status", new AnalyticsProperty(AnalyticsConstants.FAIL, scope));
                AnalyticsUtil.addProperty("payload", new AnalyticsProperty(jSONObject.toString(), scope));
                if (jSONObject.has("sdk_error_code")) {
                    i = jSONObject.getInt("sdk_error_code");
                    jSONObject.remove("sdk_error_code");
                }
                AnalyticsUtil.addProperty("return code", new AnalyticsProperty(i, scope));
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_PAYMENT_COMPLETE);
                onError(i, jSONObject.toString());
            } else if (jSONObject.has(RAZORPAY_PAYMENT_ID)) {
                PaymentData paymentData = getPaymentData(jSONObject);
                String paymentId = paymentData.getPaymentId();
                AnalyticsProperty.Scope scope2 = AnalyticsProperty.Scope.PAYMENT;
                AnalyticsUtil.addProperty("payment_id", new AnalyticsProperty(paymentId, scope2));
                AnalyticsUtil.addProperty("payment_status", new AnalyticsProperty("success", scope2));
                AnalyticsUtil.addProperty("payload", new AnalyticsProperty(jSONObject.toString(), scope2));
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_PAYMENT_COMPLETE);
                b_$A$.a((Context) this.activity, true);
                onSuccess(paymentData.getPaymentId(), paymentData);
            } else {
                AnalyticsProperty.Scope scope3 = AnalyticsProperty.Scope.PAYMENT;
                AnalyticsUtil.addProperty("payment_status", new AnalyticsProperty(AnalyticsConstants.FAIL, scope3));
                AnalyticsUtil.addProperty("payload", new AnalyticsProperty(jSONObject.toString(), scope3));
                AnalyticsUtil.addProperty("return code", new AnalyticsProperty("4", scope3));
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_PAYMENT_COMPLETE);
                onError(4, "Post payment parsing error");
            }
        } catch (Exception e) {
            onError(4, e.getMessage());
            AnalyticsUtil.reportError(e, "error", e.getMessage());
        }
    }

    public void getPaymentMethods(JSONObject jSONObject, final PaymentMethodsCallback paymentMethodsCallback) {
        String str;
        if (jSONObject != null && jSONObject.has("subscription_id")) {
            try {
                str = jSONObject.getString("subscription_id");
            } catch (Exception e) {
                e.printStackTrace();
                AnalyticsUtil.reportError(e, "error", e.getMessage());
            }
            fetchPreferences(str, new FetchPreferencesCallback() {
                /* class com.razorpay.BaseRazorpay.AnonymousClass5 */

                @Override // com.razorpay.FetchPreferencesCallback
                public void onError(String str) {
                    paymentMethodsCallback.onError(str);
                }

                @Override // com.razorpay.FetchPreferencesCallback
                public void onResponse(String str) {
                    paymentMethodsCallback.onPaymentMethodsReceived(BaseRazorpay.getPaymentMethodsFromPreferences(str));
                }
            });
        }
        str = null;
        fetchPreferences(str, new FetchPreferencesCallback() {
            /* class com.razorpay.BaseRazorpay.AnonymousClass5 */

            @Override // com.razorpay.FetchPreferencesCallback
            public void onError(String str) {
                paymentMethodsCallback.onError(str);
            }

            @Override // com.razorpay.FetchPreferencesCallback
            public void onResponse(String str) {
                paymentMethodsCallback.onPaymentMethodsReceived(BaseRazorpay.getPaymentMethodsFromPreferences(str));
            }
        });
    }

    public void openCheckout(JSONObject jSONObject, PaymentResultWithDataListener paymentResultWithDataListener2) {
        this.paymentResultWithDataListener = paymentResultWithDataListener2;
        openCheckout(jSONObject);
    }

    public void submit(JSONObject jSONObject, PaymentResultWithDataListener paymentResultWithDataListener2) {
        this.paymentResultWithDataListener = paymentResultWithDataListener2;
        submit(jSONObject);
    }

    public void openCheckout(JSONObject jSONObject) {
        if (!BaseUtils.isDeviceHaveCorrectTlsVersion()) {
            AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_TLS_ERROR);
            onError(6, BaseConstants.TLS_ERROR_MESSAGE);
            return;
        }
        handlePayload(jSONObject);
        AnalyticsUtil.addFilteredPropertiesFromPayload(jSONObject);
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_SUBMIT_START);
        String a0 = hj1.a0(new StringBuilder("<input type='hidden' name='key_id' value='"), this.apiKey, "'>");
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!next.equals(AnalyticsConstants.UPI_APP_PACKAGE_NAME) && !next.equals("display_logo") && !next.equals("preferred_apps_order") && !next.equals("other_apps_order")) {
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String a2 = b_$A$.a(jSONObject2.getString(next2));
                        String a3 = b_$A$.a(String.format("%s[%s]", next, next2));
                        StringBuilder i0 = hj1.i0(a0);
                        i0.append(String.format("<input type='hidden' name='%s' value='%s'>", a3, a2));
                        a0 = i0.toString();
                    }
                } else {
                    String a4 = b_$A$.a(jSONObject.getString(next));
                    StringBuilder i02 = hj1.i0(a0);
                    i02.append(String.format("<input type='hidden' name='%s' value='%s'>", next, a4));
                    a0 = i02.toString();
                }
            }
        }
        String replace = "<html><head><title>Processing, Please Wait...</title><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/><meta http-equiv=\"pragma\" content=\"no-cache\"><meta http-equiv=\"cache-control\" content=\"no-cache\"><style><style> html, body { width: 100%; } #content { width: 88%; max-width: 520px; text-align: center; position: absolute; transform: translate(-50%, -50%); top: 50%; left: 50%; } #title { color: #528ff0; font-size: 22px; } #ldr { width: 100%; height: 1px; position: relative; background: #e1e1e1; } #lding { height: 3px; top: -1px; background: #528ff0; position: absolute; animation: spin 20s cubic-bezier(0,0.1,0,1) forwards; animation-delay: 10; } @-webkit-keyframes spin { 0% { width: 0; } 100% { width: 90%; } } @keyframes spin { 0% { width: 0; } 100% { width: 90%; } } #desc { font-size: 16px; color: #8a8a8a; } #content > div { margin-bottom: 20px; } form { display: none; } .hide { display: none; }</style></head><body onload=\"document.forms[0].submit()\"><div id=\"content\"> <div id=\"title\">Processing Payment</div> <div id=\"ldr\"> <div id=\"lding\"></div> </div> <div id=\"desc\">Please wait while we fetch your transaction details and process your payment</div> <img id=\"rzplogo\" style=\"width:160px;margin-top:80px\" src=\"data:image/png;base64,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\"/>{{form}}</div></body><script></script></html>".replace("{{form}}", hj1.c0(new StringBuilder("<form method='post' action='"), apiUrl, "checkout/embedded'>", appendPaymentAnalytics(a0), "</form>"));
        if (!this.mShouldDisplayLogo) {
            replace = replace.replace("<script></script>", "<script>document.getElementById('rzplogo').className = 'hide';</script>");
        }
        this.webview.loadDataWithBaseURL(BaseConstants.RZP_URL, replace, "text/html", StringRpcServer.STRING_ENCODING, null);
    }

    public void submit(JSONObject jSONObject) {
        if (!BaseUtils.isDeviceHaveCorrectTlsVersion()) {
            AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_TLS_ERROR);
            onError(6, BaseConstants.TLS_ERROR_MESSAGE);
            return;
        }
        this.payload = jSONObject;
        handlePayload(jSONObject);
        AnalyticsUtil.addFilteredPropertiesFromPayload(jSONObject);
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_SUBMIT_START);
        String a0 = hj1.a0(new StringBuilder("<input type='hidden' name='key_id' value='"), this.apiKey, "'>");
        if (jSONObject.has("provider") && jSONObject.getString("provider").equalsIgnoreCase("cred")) {
            if (!jSONObject.has("app_present") || !jSONObject.getBoolean("app_present")) {
                try {
                    jSONObject.remove("app_present");
                    jSONObject.put("app_present", 0);
                } catch (JSONException e) {
                    AnalyticsUtil.reportError(e, "error", e.getMessage());
                }
                a0 = hj1.S(a0, "<input type='hidden' name='_[agent]' value='{\n  \"os\":\"android\",\n  \"platform\":\"app\",\n  \"device\":\"mobile\"\n}'>");
            } else {
                payWithCred();
                return;
            }
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (next.equalsIgnoreCase("method") && f$_G$.a().n() && ((Build.VERSION.SDK_INT >= 29 || q5.a(this.activity, "android.permission.RECEIVE_SMS") != 0) && (obj.toString().equalsIgnoreCase(AnalyticsConstants.NETBANKING) || obj.toString().equalsIgnoreCase(AnalyticsConstants.CARD)))) {
                sd2 sd2 = new sd2(this.activity);
                d42.a builder = d42.builder();
                builder.f784a = new ud2(sd2, null);
                builder.c = new Feature[]{md2.c};
                sd2.doWrite(builder.a());
                IntentFilter intentFilter = new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
                this.activity.registerReceiver(new AutoReadOtpHelper(this.activity), intentFilter);
                AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_TASK);
            }
            if (!next.equals(AnalyticsConstants.UPI_APP_PACKAGE_NAME) && !next.equals("display_logo") && !next.equals("preferred_apps_order") && !next.equals("other_apps_order")) {
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String a2 = b_$A$.a(jSONObject2.getString(next2));
                        String a3 = b_$A$.a(String.format("%s[%s]", next, next2));
                        StringBuilder i0 = hj1.i0(a0);
                        i0.append(String.format("<input type='hidden' name='%s' value='%s'>", a3, a2));
                        a0 = i0.toString();
                    }
                } else {
                    String a4 = b_$A$.a(jSONObject.getString(next));
                    StringBuilder i02 = hj1.i0(a0);
                    i02.append(String.format("<input type='hidden' name='%s' value='%s'>", next, a4));
                    a0 = i02.toString();
                }
            }
        }
        String replace = "<html><head><title>Processing, Please Wait...</title><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/><meta http-equiv=\"pragma\" content=\"no-cache\"><meta http-equiv=\"cache-control\" content=\"no-cache\"><style><style> html, body { width: 100%; } #content { width: 88%; max-width: 520px; text-align: center; position: absolute; transform: translate(-50%, -50%); top: 50%; left: 50%; } #title { color: #528ff0; font-size: 22px; } #ldr { width: 100%; height: 1px; position: relative; background: #e1e1e1; } #lding { height: 3px; top: -1px; background: #528ff0; position: absolute; animation: spin 20s cubic-bezier(0,0.1,0,1) forwards; animation-delay: 10; } @-webkit-keyframes spin { 0% { width: 0; } 100% { width: 90%; } } @keyframes spin { 0% { width: 0; } 100% { width: 90%; } } #desc { font-size: 16px; color: #8a8a8a; } #content > div { margin-bottom: 20px; } form { display: none; } .hide { display: none; }</style></head><body onload=\"document.forms[0].submit()\"><div id=\"content\"> <div id=\"title\">Processing Payment</div> <div id=\"ldr\"> <div id=\"lding\"></div> </div> <div id=\"desc\">Please wait while we fetch your transaction details and process your payment</div> <img id=\"rzplogo\" style=\"width:160px;margin-top:80px\" src=\"data:image/png;base64,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\"/>{{form}}</div></body><script></script></html>".replace("{{form}}", hj1.c0(new StringBuilder("<form method='post' action='"), apiUrl, "payments/create/checkout'>", appendPaymentAnalytics(a0), "</form>"));
        if (!this.mShouldDisplayLogo) {
            replace = replace.replace("<script></script>", "<script>document.getElementById('rzplogo').className = 'hide';</script>");
        }
        this.webview.loadDataWithBaseURL(BaseConstants.RZP_URL, replace, "text/html", StringRpcServer.STRING_ENCODING, null);
    }

    @Deprecated
    public static List<ApplicationDetails> getAppsWhichSupportUpi(Context context) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_GET_APPS_SUPPORTING_UPI);
        return getUPISupportedApps(context);
    }

    public BaseRazorpay(Activity activity2) {
        initRazorpay(activity2);
    }
}
