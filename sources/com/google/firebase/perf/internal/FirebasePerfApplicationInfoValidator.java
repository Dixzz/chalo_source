package com.google.firebase.perf.internal;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.ApplicationInfo;

public class FirebasePerfApplicationInfoValidator extends PerfMetricValidator {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ApplicationInfo mApplicationInfo;

    public FirebasePerfApplicationInfoValidator(ApplicationInfo applicationInfo) {
        this.mApplicationInfo = applicationInfo;
    }

    private boolean isValidApplicationInfo() {
        ApplicationInfo applicationInfo = this.mApplicationInfo;
        if (applicationInfo == null) {
            logger.warn("ApplicationInfo is null", new Object[0]);
            return false;
        } else if (!applicationInfo.hasGoogleAppId()) {
            logger.warn("GoogleAppId is null", new Object[0]);
            return false;
        } else if (!this.mApplicationInfo.hasAppInstanceId()) {
            logger.warn("AppInstanceId is null", new Object[0]);
            return false;
        } else if (!this.mApplicationInfo.hasApplicationProcessState()) {
            logger.warn("ApplicationProcessState is null", new Object[0]);
            return false;
        } else if (!this.mApplicationInfo.hasAndroidAppInfo()) {
            return true;
        } else {
            if (!this.mApplicationInfo.getAndroidAppInfo().hasPackageName()) {
                logger.warn("AndroidAppInfo.packageName is null", new Object[0]);
                return false;
            } else if (this.mApplicationInfo.getAndroidAppInfo().hasSdkVersion()) {
                return true;
            } else {
                logger.warn("AndroidAppInfo.sdkVersion is null", new Object[0]);
                return false;
            }
        }
    }

    @Override // com.google.firebase.perf.internal.PerfMetricValidator
    public boolean isValidPerfMetric() {
        if (isValidApplicationInfo()) {
            return true;
        }
        logger.warn("ApplicationInfo is invalid", new Object[0]);
        return false;
    }
}
