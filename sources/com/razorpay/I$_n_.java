package com.razorpay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONObject;

/* compiled from: SharedPreferenceUtil */
public final class I$_n_ {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f675a;
    private static SharedPreferences.Editor b;

    public static SharedPreferences a(Context context) {
        if (f675a == null) {
            f675a = context.getSharedPreferences("rzp_preference_private", 0);
        }
        return f675a;
    }

    @SuppressLint({"CommitPrefEdits"})
    public static SharedPreferences.Editor b(Context context) {
        if (b == null) {
            b = a(context).edit();
        }
        return b;
    }

    public static String a(Context context, String str, String str2) {
        try {
            String a2 = a(context, str);
            if (a2 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(a2);
            CryptLib cryptLib = new CryptLib();
            if (!str2.equals(jSONObject.getString("sdk_version"))) {
                return null;
            }
            return cryptLib.b(jSONObject.getString("data"), "c89TV2vbYJvvRkSSgx3dZZZu28EmcqCJ", jSONObject.getString("iv"));
        } catch (Exception e) {
            AnalyticsUtil.reportError(e, "error", "Unable to decrypt value");
            d__1_.a("Unable to decrypt value", e);
            return null;
        }
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences.Editor b2 = b(context);
        b2.putString(str, str2);
        b2.commit();
    }

    public static String a(Context context, String str) {
        return a(context).getString(str, null);
    }
}
