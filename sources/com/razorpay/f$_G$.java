package com.razorpay;

import android.content.Context;
import android.net.Uri;
import com.freshchat.consumer.sdk.beans.User;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Config */
public final class f$_G$ extends BaseConfig {

    /* renamed from: a  reason: collision with root package name */
    public static String f694a = "customui";
    public static String b = "3.9.4";
    public static int c = 30;
    public static boolean d = true;
    private static f$_G$ e = null;
    private static String f = "EPl0bxz9OvsD5IylM1M28Mv2n3v9XBsr";
    private static String g = "3.0.7";
    private boolean h;
    private HashSet<String> i;
    private HashSet<String> j;
    private LinkedHashSet<String> k;
    private JSONObject l;
    private JSONObject m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;

    private f$_G$() {
    }

    public static f$_G$ a() {
        if (e == null) {
            f$_G$ f__g_ = new f$_G$();
            e = f__g_;
            g__v_.a(f__g_);
        }
        return e;
    }

    public final boolean b() {
        return this.h;
    }

    public final HashSet<String> c() {
        return this.j;
    }

    public final HashSet<String> d() {
        return this.i;
    }

    public final LinkedHashSet<String> e() {
        return this.k;
    }

    public final JSONObject f() {
        return this.l;
    }

    public final JSONObject g() {
        return this.m;
    }

    public final String h() {
        return this.n;
    }

    public final String i() {
        return this.o;
    }

    public final String j() {
        return this.p;
    }

    public final String k() {
        return this.q;
    }

    public final String l() {
        return this.r;
    }

    public final String m() {
        return this.s;
    }

    public final boolean n() {
        return this.t;
    }

    @Override // com.razorpay.BaseConfig
    public final void setConfig(JSONObject jSONObject) {
        try {
            boolean booleanValue = ((Boolean) BaseUtils.getJsonValue("upi.isWhiteListingEnabled", jSONObject, Boolean.TRUE)).booleanValue();
            this.h = booleanValue;
            if (booleanValue) {
                JSONArray jSONArray = (JSONArray) BaseUtils.getJsonValue("upi.whiteListedApps", jSONObject, new String[0]);
                this.j = new HashSet<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.j.add(jSONArray.getString(i2));
                }
                this.i = new HashSet<>();
            } else {
                JSONArray jSONArray2 = (JSONArray) BaseUtils.getJsonValue("upi.blackListedApps", jSONObject, new String[0]);
                this.i = new HashSet<>();
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    this.i.add(jSONArray2.getString(i3));
                }
                this.j = new HashSet<>();
            }
            JSONArray jSONArray3 = (JSONArray) BaseUtils.getJsonValue("upi.upiAppsPreferredOrder", jSONObject, new String[0]);
            this.k = new LinkedHashSet<>();
            for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                this.k.add(jSONArray3.getString(i4));
            }
            this.l = (JSONObject) BaseUtils.getJsonValue("static_rules.identify_network", jSONObject, new JSONObject());
            this.m = (JSONObject) BaseUtils.getJsonValue("static_rules.network_card_length", jSONObject, new JSONObject());
            this.r = (String) BaseUtils.getJsonValue("static_rules.logos.bank.base_url", jSONObject, (Object) null);
            this.s = (String) BaseUtils.getJsonValue("static_rules.logos.bank.extension", jSONObject, (Object) null);
            this.r = (String) BaseUtils.getJsonValue("static_rules.logos.bank.base_url", jSONObject, (Object) null);
            this.s = (String) BaseUtils.getJsonValue("static_rules.logos.bank.extension", jSONObject, (Object) null);
            this.n = (String) BaseUtils.getJsonValue("static_rules.logos.wallet.base_url", jSONObject, (Object) null);
            this.o = (String) BaseUtils.getJsonValue("static_rules.logos.wallet.extension", jSONObject, (Object) null);
            this.p = (String) BaseUtils.getJsonValue("static_rules.logos.wallet_sq.base_url", jSONObject, (Object) null);
            this.q = (String) BaseUtils.getJsonValue("static_rules.logos.wallet_sq.extension", jSONObject, (Object) null);
            try {
                this.t = ((Boolean) BaseUtils.getJsonValue("one_time_otp.enabled", jSONObject, Boolean.FALSE)).booleanValue();
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2, AnalyticsConstants.WARNING, e2.getLocalizedMessage());
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            AnalyticsUtil.reportError(e3, AnalyticsConstants.CRITICAL, e3.getLocalizedMessage());
            e3.printStackTrace();
        }
        super.setConfig(jSONObject);
    }

    private static String b(Context context) {
        String baseCurrentConfigVersion = BaseConfig.getBaseCurrentConfigVersion(context);
        return baseCurrentConfigVersion == null ? g : baseCurrentConfigVersion;
    }

    public static void a(Context context, String str) {
        if (a().isConfigEnabled()) {
            HashMap hashMap = new HashMap();
            hashMap.put("AuthKey", f);
            hashMap.put("Content-type", "application/json");
            hashMap.put("CurrentSettingVersion", b(context));
            Uri.Builder buildUpon = Uri.parse(a().getConfigEndpoint()).buildUpon();
            Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("tenant", "android_" + f694a).appendQueryParameter("sdk_version", b).appendQueryParameter("sdk_type", f694a).appendQueryParameter("magic_enabled", String.valueOf(d)).appendQueryParameter(User.DEVICE_META_SDK_VERSION_CODE, String.valueOf(c)).appendQueryParameter(User.DEVICE_META_APP_VERSION_NAME, BuildConfig.VERSION_NAME).appendQueryParameter("version", BaseConfig.getCurrentConfigVersionTag(b(context)));
            BaseConfig.getFetchConfigBuilder(appendQueryParameter, context, str);
            BaseConfig.fetchConfig(appendQueryParameter.build().toString(), hashMap, context);
        }
    }

    public final void a(Context context) {
        setConfig(BaseConfig.getConfig(context, R.raw.rzp_config));
    }
}
