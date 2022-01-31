package com.crashlytics.android.core;

import com.rabbitmq.client.StringRpcServer;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MetaDataStore {
    private static final String KEYDATA_SUFFIX = "keys";
    private static final String KEY_USER_EMAIL = "userEmail";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_USER_NAME = "userName";
    private static final String METADATA_EXT = ".meta";
    private static final String USERDATA_SUFFIX = "user";
    private static final Charset UTF_8 = Charset.forName(StringRpcServer.STRING_ENCODING);
    private final File filesDir;

    public MetaDataStore(File file) {
        this.filesDir = file;
    }

    private File getKeysFileForSession(String str) {
        return new File(this.filesDir, hj1.T(str, KEYDATA_SUFFIX, METADATA_EXT));
    }

    private File getUserDataFileForSession(String str) {
        return new File(this.filesDir, hj1.T(str, "user", METADATA_EXT));
    }

    private static Map<String, String> jsonToKeysData(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, valueOrNull(jSONObject, next));
        }
        return hashMap;
    }

    private static UserMetaData jsonToUserData(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new UserMetaData(valueOrNull(jSONObject, "userId"), valueOrNull(jSONObject, KEY_USER_NAME), valueOrNull(jSONObject, KEY_USER_EMAIL));
    }

    private static String keysDataToJson(Map<String, String> map) throws JSONException {
        return new JSONObject(map).toString();
    }

    private static String userDataToJson(UserMetaData userMetaData) throws JSONException {
        return new JSONObject(userMetaData) {
            /* class com.crashlytics.android.core.MetaDataStore.AnonymousClass1 */
            public final /* synthetic */ UserMetaData val$userData;

            {
                this.val$userData = r3;
                put("userId", r3.id);
                put(MetaDataStore.KEY_USER_NAME, r3.name);
                put(MetaDataStore.KEY_USER_EMAIL, r3.email);
            }
        }.toString();
    }

    private static String valueOrNull(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.optString(str, null);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0029 A[SYNTHETIC, Splitter:B:19:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x002f A[SYNTHETIC, Splitter:B:25:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.String> readKeyData(java.lang.String r3) {
        /*
            r2 = this;
            java.io.File r3 = r2.getKeysFileForSession(r3)
            boolean r0 = r3.exists()
            if (r0 != 0) goto L_0x000f
            java.util.Map r3 = java.util.Collections.emptyMap()
            return r3
        L_0x000f:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.lang.String r3 = defpackage.j06.n(r1)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            java.util.Map r3 = jsonToKeysData(r3)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1.close()     // Catch:{ IOException -> 0x0020 }
        L_0x0020:
            return r3
        L_0x0021:
            r3 = move-exception
            r0 = r1
            goto L_0x0027
        L_0x0024:
            r0 = r1
            goto L_0x002d
        L_0x0026:
            r3 = move-exception
        L_0x0027:
            if (r0 == 0) goto L_0x002c
            r0.close()     // Catch:{ IOException -> 0x002c }
        L_0x002c:
            throw r3
        L_0x002d:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            java.util.Map r3 = java.util.Collections.emptyMap()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.MetaDataStore.readKeyData(java.lang.String):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0027 A[SYNTHETIC, Splitter:B:19:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x002d A[SYNTHETIC, Splitter:B:25:0x002d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.crashlytics.android.core.UserMetaData readUserData(java.lang.String r3) {
        /*
            r2 = this;
            java.io.File r3 = r2.getUserDataFileForSession(r3)
            boolean r0 = r3.exists()
            if (r0 != 0) goto L_0x000d
            com.crashlytics.android.core.UserMetaData r3 = com.crashlytics.android.core.UserMetaData.EMPTY
            return r3
        L_0x000d:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002b, all -> 0x0024 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x002b, all -> 0x0024 }
            java.lang.String r3 = defpackage.j06.n(r1)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            com.crashlytics.android.core.UserMetaData r3 = jsonToUserData(r3)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r1.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            return r3
        L_0x001f:
            r3 = move-exception
            r0 = r1
            goto L_0x0025
        L_0x0022:
            r0 = r1
            goto L_0x002b
        L_0x0024:
            r3 = move-exception
        L_0x0025:
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            throw r3
        L_0x002b:
            if (r0 == 0) goto L_0x0030
            r0.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            com.crashlytics.android.core.UserMetaData r3 = com.crashlytics.android.core.UserMetaData.EMPTY
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.MetaDataStore.readUserData(java.lang.String):com.crashlytics.android.core.UserMetaData");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c A[SYNTHETIC, Splitter:B:13:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeKeyData(java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r4 = this;
            java.io.File r5 = r4.getKeysFileForSession(r5)
            r0 = 0
            java.lang.String r6 = keysDataToJson(r6)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            java.nio.charset.Charset r5 = com.crashlytics.android.core.MetaDataStore.UTF_8     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            r2.<init>(r3, r5)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            r1.write(r6)     // Catch:{ Exception -> 0x0027, all -> 0x0024 }
            r1.flush()     // Catch:{ Exception -> 0x0027, all -> 0x0024 }
            r1.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0035
        L_0x0024:
            r5 = move-exception
            r0 = r1
            goto L_0x002a
        L_0x0027:
            r0 = r1
            goto L_0x0030
        L_0x0029:
            r5 = move-exception
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            throw r5
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.close()
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.MetaDataStore.writeKeyData(java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c A[SYNTHETIC, Splitter:B:13:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeUserData(java.lang.String r5, com.crashlytics.android.core.UserMetaData r6) {
        /*
            r4 = this;
            java.io.File r5 = r4.getUserDataFileForSession(r5)
            r0 = 0
            java.lang.String r6 = userDataToJson(r6)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            java.nio.charset.Charset r5 = com.crashlytics.android.core.MetaDataStore.UTF_8     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            r2.<init>(r3, r5)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            r1.write(r6)     // Catch:{ Exception -> 0x0027, all -> 0x0024 }
            r1.flush()     // Catch:{ Exception -> 0x0027, all -> 0x0024 }
            r1.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0035
        L_0x0024:
            r5 = move-exception
            r0 = r1
            goto L_0x002a
        L_0x0027:
            r0 = r1
            goto L_0x0030
        L_0x0029:
            r5 = move-exception
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            throw r5
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.close()
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.MetaDataStore.writeUserData(java.lang.String, com.crashlytics.android.core.UserMetaData):void");
    }
}
