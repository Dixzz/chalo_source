package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

public class InstallerPackageNameProvider {
    private static final String NO_INSTALLER_PACKAGE_NAME = "";
    private String installerPackageName;

    private static String loadInstallerPackageName(Context context) {
        String installerPackageName2 = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName2 == null ? "" : installerPackageName2;
    }

    public synchronized String getInstallerPackageName(Context context) {
        if (this.installerPackageName == null) {
            this.installerPackageName = loadInstallerPackageName(context);
        }
        return "".equals(this.installerPackageName) ? null : this.installerPackageName;
    }
}
