package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.razorpay.AnalyticsConstants;
import defpackage.q5;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public class Store {
    public final Context context;
    public final SharedPreferences store;
    private final Map<String, Long> subtypeCreationTimes = new n2();

    /* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
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

        public static String getTokenOrNull(Token token2) {
            if (token2 == null) {
                return null;
            }
            return token2.token;
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
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
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

    public static String createSubtypeInfoKey(String str, String str2) {
        return hj1.a0(new StringBuilder(String.valueOf(str).length() + 6), str, "|S|cre");
    }

    private String createTokenKey(String str, String str2, String str3) {
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        hj1.V0(sb, str, "|T|", str2, "|");
        sb.append(str3);
        return sb.toString();
    }

    private long getCreationTimeFromSharedPreferences(String str) {
        String string = this.store.getString(createSubtypeInfoKey(str, "cre"), null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private long writeCreationTimeToSharedPreferences(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.store.contains(createSubtypeInfoKey(str, "cre"))) {
            return getCreationTimeFromSharedPreferences(str);
        }
        SharedPreferences.Editor edit = this.store.edit();
        edit.putString(createSubtypeInfoKey(str, "cre"), String.valueOf(currentTimeMillis));
        edit.commit();
        return currentTimeMillis;
    }

    public synchronized void deleteAll() {
        this.subtypeCreationTimes.clear();
        this.store.edit().clear().commit();
    }

    public synchronized void deleteToken(String str, String str2, String str3) {
        String createTokenKey = createTokenKey(str, str2, str3);
        SharedPreferences.Editor edit = this.store.edit();
        edit.remove(createTokenKey);
        edit.commit();
    }

    public synchronized long getCreationTime(String str) {
        Long l = this.subtypeCreationTimes.get(str);
        if (l != null) {
            return l.longValue();
        }
        return getCreationTimeFromSharedPreferences(str);
    }

    public synchronized Token getToken(String str, String str2, String str3) {
        return Token.parse(this.store.getString(createTokenKey(str, str2, str3), null));
    }

    public synchronized boolean isEmpty() {
        return this.store.getAll().isEmpty();
    }

    public synchronized void saveToken(String str, String str2, String str3, String str4, String str5) {
        String encode = Token.encode(str4, str5, System.currentTimeMillis());
        if (encode != null) {
            SharedPreferences.Editor edit = this.store.edit();
            edit.putString(createTokenKey(str, str2, str3), encode);
            edit.commit();
        }
    }

    public synchronized long setCreationTime(String str) {
        long writeCreationTimeToSharedPreferences;
        writeCreationTimeToSharedPreferences = writeCreationTimeToSharedPreferences(str);
        this.subtypeCreationTimes.put(str, Long.valueOf(writeCreationTimeToSharedPreferences));
        return writeCreationTimeToSharedPreferences;
    }
}
