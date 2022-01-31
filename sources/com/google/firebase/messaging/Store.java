package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.razorpay.AnalyticsConstants;
import defpackage.q5;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class Store {
    public final Context context;
    public final SharedPreferences store;

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    public static class Token {
        private static final long REFRESH_PERIOD_MILLIS = TimeUnit.DAYS.toMillis(7);
        public final String appVersion;
        public final long timestamp;
        public final String token;

        private Token(String str, String str2, long j) {
            this.token = str;
            this.appVersion = str2;
            this.timestamp = j;
        }

        public static String encode(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AnalyticsConstants.TOKEN, str);
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, str2);
                jSONObject.put("timestamp", j);
                return jSONObject.toString();
            } catch (JSONException e) {
                String.valueOf(e).length();
                return null;
            }
        }

        public static Token parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new Token(str, null, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new Token(jSONObject.getString(AnalyticsConstants.TOKEN), jSONObject.getString(RemoteConfigConstants.RequestFieldKey.APP_VERSION), jSONObject.getLong("timestamp"));
            } catch (JSONException e) {
                String.valueOf(e).length();
                return null;
            }
        }

        public boolean needsRefresh(String str) {
            return System.currentTimeMillis() > this.timestamp + REFRESH_PERIOD_MILLIS || !str.equals(this.appVersion);
        }
    }

    public Store(Context context2) {
        this.context = context2;
        this.store = context2.getSharedPreferences("com.google.android.gms.appid", 0);
        checkForRestore("com.google.android.gms.appid-no-backup");
    }

    private void checkForRestore(String str) {
        Context context2 = this.context;
        Object obj = q5.f2896a;
        File file = new File(q5.c.c(context2), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    deleteAll();
                }
            } catch (IOException e) {
                if (Log.isLoggable(Constants.TAG, 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    if (valueOf.length() != 0) {
                        "Error creating file in no backup dir: ".concat(valueOf);
                    } else {
                        new String("Error creating file in no backup dir: ");
                    }
                }
            }
        }
    }

    private String createTokenKey(String str, String str2) {
        return hj1.c0(new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str2).length()), str, "|T|", str2, "|*");
    }

    public synchronized void deleteAll() {
        this.store.edit().clear().commit();
    }

    public synchronized void deleteToken(String str, String str2) {
        String createTokenKey = createTokenKey(str, str2);
        SharedPreferences.Editor edit = this.store.edit();
        edit.remove(createTokenKey);
        edit.commit();
    }

    public synchronized Token getToken(String str, String str2) {
        return Token.parse(this.store.getString(createTokenKey(str, str2), null));
    }

    public synchronized boolean isEmpty() {
        return this.store.getAll().isEmpty();
    }

    public synchronized void saveToken(String str, String str2, String str3, String str4) {
        String encode = Token.encode(str3, str4, System.currentTimeMillis());
        if (encode != null) {
            SharedPreferences.Editor edit = this.store.edit();
            edit.putString(createTokenKey(str, str2), encode);
            edit.commit();
        }
    }
}
