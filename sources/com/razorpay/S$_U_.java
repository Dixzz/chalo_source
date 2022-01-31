package com.razorpay;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.JavascriptInterface;

/* compiled from: StorageBridge */
public final class S$_U_ {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f687a;
    private SharedPreferences.Editor b;

    public S$_U_(Context context) {
        this.f687a = context.getSharedPreferences("rzp_preferences_storage_bridge", 0);
        this.b = context.getSharedPreferences("rzp_preferences_storage_bridge", 0).edit();
    }

    @JavascriptInterface
    public final boolean getBoolean(String str) {
        try {
            return this.f687a.getBoolean(str, false);
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public final float getFloat(String str) {
        try {
            return this.f687a.getFloat(str, 0.0f);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @JavascriptInterface
    public final int getInt(String str) {
        try {
            return this.f687a.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    @JavascriptInterface
    public final String getString(String str) {
        try {
            return this.f687a.getString(str, null);
        } catch (Exception unused) {
            return null;
        }
    }

    @JavascriptInterface
    public final void setBoolean(String str, boolean z) {
        try {
            this.b.putBoolean(str, z);
            this.b.commit();
        } catch (Exception e) {
            d__1_.a("Error saving boolean", e);
        }
    }

    @JavascriptInterface
    public final void setFloat(String str, float f) {
        try {
            this.b.putFloat(str, f);
            this.b.commit();
        } catch (Exception e) {
            d__1_.a("Error saving float", e);
        }
    }

    @JavascriptInterface
    public final void setInt(String str, int i) {
        try {
            this.b.putInt(str, i);
            this.b.commit();
        } catch (Exception e) {
            d__1_.a("Error saving integer", e);
        }
    }

    @JavascriptInterface
    public final void setString(String str, String str2) {
        try {
            this.b.putString(str, str2);
            this.b.commit();
        } catch (Exception e) {
            d__1_.a("Error saving string", e);
        }
    }
}
