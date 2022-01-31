package com.crashlytics.android.beta;

import java.util.HashMap;
import java.util.Map;

public class CheckForUpdatesRequest extends g06 {
    public static final String BETA_SOURCE = "3";
    public static final String BUILD_VERSION = "build_version";
    public static final String DISPLAY_VERSION = "display_version";
    public static final String HEADER_BETA_TOKEN = "X-CRASHLYTICS-BETA-TOKEN";
    public static final String INSTANCE = "instance";
    public static final String SDK_ANDROID_DIR_TOKEN_TYPE = "3";
    public static final String SOURCE = "source";
    private final CheckForUpdatesResponseTransform responseTransform;

    public CheckForUpdatesRequest(c06 c06, String str, String str2, r16 r16, CheckForUpdatesResponseTransform checkForUpdatesResponseTransform) {
        super(c06, str, str2, r16, p16.GET);
        this.responseTransform = checkForUpdatesResponseTransform;
    }

    private q16 applyHeadersTo(q16 q16, String str, String str2) {
        q16.h().setRequestProperty("Accept", "application/json");
        q16.h().setRequestProperty("User-Agent", "Crashlytics Android SDK/" + this.kit.getVersion());
        q16.h().setRequestProperty("X-CRASHLYTICS-DEVELOPER-TOKEN", g06.CLS_ANDROID_SDK_DEVELOPER_TOKEN);
        q16.h().setRequestProperty("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        q16.h().setRequestProperty("X-CRASHLYTICS-API-CLIENT-VERSION", this.kit.getVersion());
        q16.h().setRequestProperty(g06.HEADER_API_KEY, str);
        q16.h().setRequestProperty(HEADER_BETA_TOKEN, createBetaTokenHeaderValueFor(str2));
        return q16;
    }

    public static String createBetaTokenHeaderValueFor(String str) {
        return hj1.S("3:", str);
    }

    private Map<String, String> getQueryParamsFor(BuildProperties buildProperties) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", buildProperties.versionCode);
        hashMap.put("display_version", buildProperties.versionName);
        hashMap.put("instance", buildProperties.buildId);
        hashMap.put("source", "3");
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        getUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r2 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        r1.k("X-REQUEST-ID");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.crashlytics.android.beta.CheckForUpdatesResponse invoke(java.lang.String r4, java.lang.String r5, com.crashlytics.android.beta.BuildProperties r6) {
        /*
            r3 = this;
            java.lang.String r0 = "X-REQUEST-ID"
            r1 = 0
            java.util.Map r6 = r3.getQueryParamsFor(r6)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            q16 r2 = r3.getHttpRequest(r6)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            q16 r2 = r3.applyHeadersTo(r2, r4, r5)     // Catch:{ Exception -> 0x004f }
            r3.getUrl()     // Catch:{ Exception -> 0x004f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
            r4.<init>()     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = "Checking for updates query params are: "
            r4.append(r5)     // Catch:{ Exception -> 0x004f }
            r4.append(r6)     // Catch:{ Exception -> 0x004f }
            r4.toString()     // Catch:{ Exception -> 0x004f }
            int r4 = r2.e()     // Catch:{ Exception -> 0x004f }
            r5 = 200(0xc8, float:2.8E-43)
            if (r5 != r4) goto L_0x002c
            r4 = 1
            goto L_0x002d
        L_0x002c:
            r4 = 0
        L_0x002d:
            if (r4 == 0) goto L_0x0042
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = r2.b()     // Catch:{ Exception -> 0x004f }
            r4.<init>(r5)     // Catch:{ Exception -> 0x004f }
            com.crashlytics.android.beta.CheckForUpdatesResponseTransform r5 = r3.responseTransform     // Catch:{ Exception -> 0x004f }
            com.crashlytics.android.beta.CheckForUpdatesResponse r4 = r5.fromJson(r4)     // Catch:{ Exception -> 0x004f }
            r2.k(r0)
            return r4
        L_0x0042:
            r2.e()
        L_0x0045:
            r2.k(r0)
            goto L_0x0055
        L_0x0049:
            r4 = move-exception
            r1 = r2
            goto L_0x0056
        L_0x004c:
            r4 = move-exception
            goto L_0x0056
        L_0x004e:
            r2 = r1
        L_0x004f:
            r3.getUrl()     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0055
            goto L_0x0045
        L_0x0055:
            return r1
        L_0x0056:
            if (r1 == 0) goto L_0x005b
            r1.k(r0)
        L_0x005b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.beta.CheckForUpdatesRequest.invoke(java.lang.String, java.lang.String, com.crashlytics.android.beta.BuildProperties):com.crashlytics.android.beta.CheckForUpdatesResponse");
    }
}
