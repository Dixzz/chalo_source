package com.crashlytics.android.beta;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeviceTokenLoader implements f06<String> {
    private static final String BETA_APP_PACKAGE_NAME = "io.crash.air";
    private static final String DIRFACTOR_DEVICE_TOKEN_PREFIX = "assets/com.crashlytics.android.beta/dirfactor-device-token=";

    public String determineDeviceToken(ZipInputStream zipInputStream) throws IOException {
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        if (nextEntry == null) {
            return "";
        }
        String name = nextEntry.getName();
        return name.startsWith(DIRFACTOR_DEVICE_TOKEN_PREFIX) ? name.substring(59, name.length() - 1) : "";
    }

    public ZipInputStream getZipInputStreamOfApkFrom(Context context, String str) throws PackageManager.NameNotFoundException, FileNotFoundException {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(str, 0).sourceDir));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        if (r0 == null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        if (r0 == null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        if (r0 == null) goto L_0x0027;
     */
    @Override // defpackage.f06
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String load(android.content.Context r3) throws java.lang.Exception {
        /*
            r2 = this;
            java.lang.System.nanoTime()
            r0 = 0
            java.lang.String r1 = "io.crash.air"
            java.util.zip.ZipInputStream r0 = r2.getZipInputStreamOfApkFrom(r3, r1)     // Catch:{ NameNotFoundException -> 0x0024, FileNotFoundException -> 0x0021, IOException -> 0x001b, all -> 0x0014 }
            java.lang.String r3 = r2.determineDeviceToken(r0)     // Catch:{ NameNotFoundException -> 0x0024, FileNotFoundException -> 0x0021, IOException -> 0x001b, all -> 0x0014 }
            if (r0 == 0) goto L_0x0029
            r0.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x0029
        L_0x0014:
            r3 = move-exception
            if (r0 == 0) goto L_0x001a
            r0.close()     // Catch:{ IOException -> 0x001a }
        L_0x001a:
            throw r3
        L_0x001b:
            if (r0 == 0) goto L_0x0027
        L_0x001d:
            r0.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0027
        L_0x0021:
            if (r0 == 0) goto L_0x0027
            goto L_0x001d
        L_0x0024:
            if (r0 == 0) goto L_0x0027
            goto L_0x001d
        L_0x0027:
            java.lang.String r3 = ""
        L_0x0029:
            java.lang.System.nanoTime()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.beta.DeviceTokenLoader.load(android.content.Context):java.lang.String");
    }
}
