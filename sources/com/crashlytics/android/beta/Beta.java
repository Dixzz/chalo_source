package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import defpackage.c26;
import defpackage.o06;
import java.util.Map;

public class Beta extends c06<Boolean> {
    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String CRASHLYTICS_BUILD_PROPERTIES = "crashlytics-build.properties";
    public static final String NO_DEVICE_TOKEN = "";
    public static final String TAG = "Beta";
    private final e06<String> deviceTokenCache = new e06<>();
    private final DeviceTokenLoader deviceTokenLoader = new DeviceTokenLoader();
    private UpdatesController updatesController;

    private String getBetaDeviceToken(Context context, String str) {
        String str2 = null;
        try {
            String a2 = this.deviceTokenCache.a(context, this.deviceTokenLoader);
            if (!"".equals(a2)) {
                str2 = a2;
            }
        } catch (Exception unused) {
        }
        TextUtils.isEmpty(str2);
        return str2;
    }

    private z16 getBetaSettingsData() {
        if (c26.b.f510a.a() != null) {
        }
        return null;
    }

    public static Beta getInstance() {
        xz5.a(Beta.class);
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026 A[SYNTHETIC, Splitter:B:15:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.crashlytics.android.beta.BuildProperties loadBuildProperties(android.content.Context r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ Exception -> 0x002a, all -> 0x0020 }
            java.lang.String r1 = "crashlytics-build.properties"
            java.io.InputStream r4 = r4.open(r1)     // Catch:{ Exception -> 0x002a, all -> 0x0020 }
            if (r4 == 0) goto L_0x001a
            com.crashlytics.android.beta.BuildProperties r0 = com.crashlytics.android.beta.BuildProperties.fromPropertiesStream(r4)     // Catch:{ Exception -> 0x0016, all -> 0x0014 }
            java.lang.String r1 = r0.packageName     // Catch:{ Exception -> 0x0016, all -> 0x0014 }
            goto L_0x001a
        L_0x0014:
            r0 = move-exception
            goto L_0x0024
        L_0x0016:
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x002b
        L_0x001a:
            if (r4 == 0) goto L_0x0031
            r4.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0031
        L_0x0020:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
        L_0x0024:
            if (r4 == 0) goto L_0x0029
            r4.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            throw r0
        L_0x002a:
            r4 = r0
        L_0x002b:
            if (r0 == 0) goto L_0x0030
            r0.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            r0 = r4
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.beta.Beta.loadBuildProperties(android.content.Context):com.crashlytics.android.beta.BuildProperties");
    }

    public boolean canCheckForUpdates(z16 z16, BuildProperties buildProperties) {
        return (z16 == null || TextUtils.isEmpty(null) || buildProperties == null) ? false : true;
    }

    @TargetApi(14)
    public UpdatesController createUpdatesController(int i, Application application) {
        if (i < 14) {
            return new ImmediateCheckForUpdatesController();
        }
        getFabric();
        throw null;
    }

    public Map<o06.a, String> getDeviceIdentifiers() {
        getIdManager();
        throw null;
    }

    @Override // defpackage.c06
    public String getIdentifier() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String getOverridenSpiEndpoint() {
        return j06.g(getContext(), "com.crashlytics.ApiEndpoint");
    }

    @Override // defpackage.c06
    public String getVersion() {
        return "1.2.2.142";
    }

    @Override // defpackage.c06
    @TargetApi(14)
    public boolean onPreExecute() {
        this.updatesController = createUpdatesController(Build.VERSION.SDK_INT, (Application) getContext().getApplicationContext());
        return true;
    }

    @Override // defpackage.c06
    public Boolean doInBackground() {
        getContext();
        getIdManager();
        throw null;
    }
}
