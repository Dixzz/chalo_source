package com.razorpay;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.freshchat.consumer.sdk.beans.User;
import com.razorpay.AnalyticsProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Lumberjack */
public final class J$_0_ {

    /* renamed from: a  reason: collision with root package name */
    private static String f677a = Build.MANUFACTURER;
    private static String b = Build.MODEL;
    private static String c = Build.DEVICE;
    private static String d;
    private static String e;
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static float i;
    private static int j;
    private static int k;
    private static JSONObject l;
    private static JSONObject m;
    private static boolean n = false;
    private static String o = "standalone";
    private static String p;
    private static ArrayList<JSONObject> q = new ArrayList<>();
    private static Map<String, Object> r;
    private static Map<String, Object> s;

    public static void a(String str, Object obj) {
        r.put(str, obj);
    }

    private static void b(JSONObject jSONObject) {
        if (!n) {
            q.add(jSONObject);
            return;
        }
        try {
            JSONObject c2 = c(jSONObject);
            synchronized (l) {
                l.getJSONArray(AnalyticsConstants.EVENTS).put(c2);
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, AnalyticsConstants.CRITICAL, e2.getMessage());
        }
    }

    private static JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        try {
            if (jSONObject.has(AnalyticsConstants.PROPERTIES)) {
                jSONObject2 = jSONObject.getJSONObject(AnalyticsConstants.PROPERTIES);
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("merchant_app_name", AnalyticsUtil.MERCHANT_APP_NAME);
            jSONObject2.put("merchant_app_version", AnalyticsUtil.MERCHANT_APP_VERSION);
            jSONObject2.put("merchant_app_build", AnalyticsUtil.MERCHANT_APP_BUILD);
            jSONObject2.put("platform", "mobile_sdk");
            jSONObject2.put("platform_version", p);
            jSONObject2.put(User.DEVICE_META_OS_NAME, "android");
            jSONObject2.put(User.DEVICE_META_OS_VERSION_NAME, Build.VERSION.RELEASE);
            jSONObject2.put("library", AnalyticsUtil.libraryType);
            for (Map.Entry<String, Object> entry : r.entrySet()) {
                try {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                } catch (Exception e2) {
                    AnalyticsUtil.reportError(e2, AnalyticsConstants.CRITICAL, "Error adding analytics property " + entry.getKey() + " to JSONObject");
                }
            }
            for (Map.Entry<String, Object> entry2 : s.entrySet()) {
                try {
                    jSONObject2.put(entry2.getKey(), entry2.getValue());
                } catch (Exception e3) {
                    AnalyticsUtil.reportError(e3, AnalyticsConstants.CRITICAL, "Error adding analytics property " + entry2.getKey() + " to JSONObject");
                }
            }
            jSONObject.put(AnalyticsConstants.PROPERTIES, jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void d(JSONObject jSONObject) {
        if (g__v_.a().isLumberJackEnabled().booleanValue()) {
            HashMap hashMap = new HashMap();
            hashMap.put("x-identifier", g__v_.a().getLumberjackSdkIdentifier());
            hashMap.put("Content-Type", "application/json");
            T__j$.a(g__v_.a().getLumberjackEndpoint(), jSONObject.toString(), hashMap, new O__Y_());
        }
    }

    private static JSONObject e(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(AnalyticsConstants.EVENTS);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2.has(AnalyticsConstants.PROPERTIES)) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(AnalyticsConstants.PROPERTIES);
                    if (jSONObject3.has("url")) {
                        String string = jSONObject3.getString("url");
                        if (string.startsWith("data:")) {
                            string = "Data present in url";
                        }
                        jSONObject3.put("url", string);
                    }
                    jSONObject2.put(AnalyticsConstants.PROPERTIES, jSONObject3);
                }
                jSONArray.put(i2, jSONObject2);
            }
            jSONObject.put(AnalyticsConstants.EVENTS, jSONArray);
        } catch (JSONException e2) {
            d__1_.a("Error in filtering payload", e2);
        }
        return jSONObject;
    }

    private static void f() {
        try {
            JSONObject jSONObject = l;
            if (jSONObject != null) {
                synchronized (jSONObject) {
                    l.put(AnalyticsConstants.EVENTS, new JSONArray());
                }
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, AnalyticsConstants.CRITICAL, e2.getMessage());
        }
    }

    private static void g() {
        Iterator<JSONObject> it = q.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        h();
    }

    private static void h() {
        q = new ArrayList<>();
    }

    public static void a(String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e2) {
                AnalyticsUtil.reportError(e2, AnalyticsConstants.CRITICAL, "Error adding analytics property " + entry.getKey() + " to JSONObject");
            }
        }
        a(str, jSONObject);
    }

    public static void d() {
        s = new HashMap();
    }

    public static void a(String str, JSONObject jSONObject) {
        try {
            JSONObject b2 = b(str);
            if (b2 == null) {
                b2 = new JSONObject();
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put("local_order_id", AnalyticsUtil.getLocalOrderId());
            jSONObject.put("local_payment_id", AnalyticsUtil.getLocalPaymentId());
            b2.put(AnalyticsConstants.PROPERTIES, jSONObject);
            b(b2);
        } catch (Exception unused) {
        }
    }

    public static void b(String str, Object obj) {
        s.put(str, obj);
    }

    private static JSONObject b(String str) {
        try {
            return new JSONObject("{event: '" + str + "',timestamp: '" + String.valueOf(System.currentTimeMillis() / 1000) + "'}");
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, AnalyticsConstants.CRITICAL, "Error in creating base for trackEvent");
            return null;
        }
    }

    private static String b(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, AnalyticsConstants.WARNING, e2.getMessage());
            return null;
        }
    }

    public static JSONObject e() {
        return m;
    }

    public static void a(String str) {
        a(str, new JSONObject());
    }

    public static void b() {
        d();
        c();
        f();
        h();
        n = false;
    }

    public static void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str2);
        a("Viewed " + str + " Page", (Map<String, Object>) hashMap);
    }

    public static void a() {
        synchronized (l) {
            JSONObject e2 = e(l);
            l = e2;
            e2.toString();
            d(l);
        }
        f();
    }

    private static boolean c(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getBoolean(str);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, AnalyticsConstants.WARNING, e2.getMessage());
            return false;
        }
    }

    public static void c() {
        r = new HashMap();
    }

    public static void a(Context context, String str, String str2) {
        o = str;
        p = str2;
        try {
            d = BaseUtils.getCellularNetworkType(context);
            e = BaseUtils.getCellularNetworkProviderName(context);
            int i2 = h__y_.f696a[BaseUtils.getDataNetworkType(context).ordinal()];
            if (i2 == 1) {
                h = true;
            } else if (i2 == 2) {
                f = true;
            } else if (i2 == 3) {
                g = true;
            }
            Display defaultDisplay = ((WindowManager) BaseUtils.getSystemService(context, "window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            i = displayMetrics.density;
            k = displayMetrics.heightPixels;
            j = displayMetrics.widthPixels;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AnalyticsConstants.KEY, g__v_.a().getLumberjackKey());
            jSONObject.put(AnalyticsConstants.EVENTS, new JSONArray());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("mode", AnalyticsUtil.getKeyType());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", BaseConfig.getAdvertisingId(context));
            jSONObject3.put("manufacturer", f677a);
            jSONObject3.put("model", b);
            jSONObject3.put("name", c);
            jSONObject3.put("type", "phone");
            jSONObject3.put("version", AnalyticsConstants.ANDROID + Build.VERSION.RELEASE);
            jSONObject3.put(f677a, Build.MANUFACTURER);
            jSONObject3.put(b, Build.MODEL);
            jSONObject3.put(AnalyticsConstants.DEVICE_SIZE, BaseUtils.getDisplayWidth(context) + "w X " + BaseUtils.getDisplayHeight(context) + "h");
            jSONObject3.put(AnalyticsConstants.DEVICE_RESOLUTION, BaseUtils.getDisplayResolution(context));
            jSONObject2.put(AnalyticsConstants.DEVICE, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("version", p);
            jSONObject4.put("type", o);
            jSONObject2.put(AnalyticsConstants.SDK, jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(AnalyticsConstants.BLUETOOTH, g);
            jSONObject5.put(AnalyticsConstants.CARRIER, e);
            jSONObject5.put(AnalyticsConstants.CELLULAR, f);
            jSONObject5.put(AnalyticsConstants.CELLULAR_NETWORK_TYPE, d);
            jSONObject5.put(AnalyticsConstants.WIFI, h);
            jSONObject5.put(AnalyticsConstants.CARRIER_NETWORK, BaseUtils.getCarrierOperatorName(context));
            jSONObject5.put(AnalyticsConstants.NETWORK_TYPE, BaseUtils.getNetworkType(context));
            jSONObject5.put(AnalyticsConstants.IP_ADDRESS, BaseUtils.ipAddress);
            jSONObject5.put(AnalyticsConstants.IS_ROMING, BaseUtils.isNetworkRoaming(context));
            Map<String, String> deviceAttributes = BaseUtils.getDeviceAttributes(context);
            jSONObject5.put(AnalyticsConstants.DEVICE_ID, deviceAttributes.get(AnalyticsConstants.DEVICE_ID));
            String str3 = f677a;
            jSONObject5.put(str3, deviceAttributes.get(str3));
            String str4 = b;
            jSONObject5.put(str4, deviceAttributes.get(str4));
            jSONObject2.put(AnalyticsConstants.NETWORK, jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(AnalyticsConstants.DENSITY, (double) i);
            jSONObject6.put("width", j);
            jSONObject6.put("height", k);
            jSONObject2.put(AnalyticsConstants.SCREEN, jSONObject6);
            jSONObject2.put(AnalyticsConstants.LOCALE, BaseUtils.getLocale());
            jSONObject2.put(AnalyticsConstants.TIMEZONE, AnalyticsUtil.returnUndefinedIfNull(TimeZone.getDefault().getID()));
            jSONObject2.put(AnalyticsConstants.USER_AGENT, AnalyticsUtil.returnUndefinedIfNull(System.getProperty("http.agent")));
            jSONObject2.put(AnalyticsConstants.WEBVIEW_USER_AGENT, BaseUtils.getWebViewUserAgent(context));
            m = jSONObject2;
            jSONObject.put(AnalyticsConstants.CONTEXT, jSONObject2);
            l = jSONObject;
            jSONObject.toString();
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, AnalyticsConstants.CRITICAL, "Error in creating BaseImportJSON");
            l = new JSONObject();
        }
        n = true;
        g();
        String a2 = I$_n_.a(context, "SavedEventsData", str2);
        if (a2 != null && a2.length() != 0) {
            try {
                d(new JSONObject(a2));
            } catch (Exception e3) {
                AnalyticsUtil.reportError(e3, "error", e3.getMessage());
            } finally {
                I$_n_.b(context, "SavedEventsData", null);
            }
        }
    }

    private static void a(JSONObject jSONObject, String str, AnalyticsProperty.Scope scope) {
        try {
            Object a2 = a(jSONObject, str);
            if (a2 == null) {
                return;
            }
            if (scope == AnalyticsProperty.Scope.PAYMENT) {
                a(str, a2);
            } else if (scope == AnalyticsProperty.Scope.ORDER) {
                b(str, a2);
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, AnalyticsConstants.WARNING, e2.getMessage());
        }
    }

    private static Object a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.get(str);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, AnalyticsConstants.WARNING, e2.getMessage());
            return null;
        }
    }

    public static void a(Context context) {
        synchronized (l) {
            String jSONObject = e(l).toString();
            String str = p;
            try {
                String randomString = BaseUtils.getRandomString();
                String a2 = new CryptLib().a(jSONObject, "c89TV2vbYJvvRkSSgx3dZZZu28EmcqCJ", randomString);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", a2);
                jSONObject2.put("iv", randomString);
                jSONObject2.put("sdk_version", str);
                I$_n_.b(context, "SavedEventsData", jSONObject2.toString());
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2, "error", "Unable to encrypt value");
                d__1_.a("Unable to encrypt value", e2);
            }
        }
    }

    public static void a(JSONObject jSONObject) {
        try {
            b(AnalyticsConstants.AMOUNT, Long.valueOf(Long.parseLong(b(jSONObject, AnalyticsConstants.AMOUNT))));
        } catch (Exception unused) {
        }
        try {
            AnalyticsProperty.Scope scope = AnalyticsProperty.Scope.ORDER;
            a(jSONObject, AnalyticsConstants.CONTACT, scope);
            a(jSONObject, "email", scope);
            a(jSONObject, AnalyticsConstants.ORDER_ID, scope);
            String b2 = b(jSONObject, "method");
            if (b2 != null) {
                if (jSONObject.has(AnalyticsConstants.TOKEN)) {
                    b2 = AnalyticsConstants.SAVED_CARD;
                }
                a("method", (Object) b2);
                boolean z = false;
                if (b2.equals(AnalyticsConstants.CARD)) {
                    String b3 = b(jSONObject, "card[number]");
                    if (!AnalyticsUtil.isNullOrEmpty(b3) && b3.length() >= 6) {
                        a(AnalyticsConstants.CARD_NUMBER, (Object) b3.substring(0, 6));
                    }
                } else if (b2.equals(AnalyticsConstants.SAVED_CARD)) {
                    boolean c2 = c(jSONObject, AnalyticsConstants.RAZORPAY_OTP);
                    StringBuilder sb = new StringBuilder();
                    if (!c2) {
                        z = true;
                    }
                    sb.append(z);
                    b(AnalyticsConstants.CHECKOUT_LOGIN, sb.toString());
                } else if (b2.equals(AnalyticsConstants.NETBANKING)) {
                    a(jSONObject, AnalyticsConstants.BANK, AnalyticsProperty.Scope.PAYMENT);
                } else if (b2.equals(AnalyticsConstants.WALLET)) {
                    a(jSONObject, AnalyticsConstants.WALLET, AnalyticsProperty.Scope.PAYMENT);
                } else if (b2.equals(AnalyticsConstants.UPI)) {
                    a(AnalyticsConstants.FLOW, (Object) b(jSONObject, "_[flow]"));
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
            AnalyticsUtil.reportError(e2, AnalyticsConstants.WARNING, e2.getMessage());
        }
    }
}
