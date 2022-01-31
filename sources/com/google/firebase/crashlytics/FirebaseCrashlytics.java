package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import java.util.Objects;

public class FirebaseCrashlytics {
    private static final int APP_EXCEPTION_CALLBACK_TIMEOUT_MS = 500;
    private static final String FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN = "clx";
    private static final String LEGACY_CRASH_ANALYTICS_ORIGIN = "crash";
    private final CrashlyticsCore core;

    private FirebaseCrashlytics(CrashlyticsCore crashlyticsCore) {
        this.core = crashlyticsCore;
    }

    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        Objects.requireNonNull(firebaseCrashlytics, "FirebaseCrashlytics component is not present.");
        return firebaseCrashlytics;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.firebase.crashlytics.CrashlyticsAnalyticsListener] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.crashlytics.FirebaseCrashlytics init(com.google.firebase.FirebaseApp r16, com.google.firebase.installations.FirebaseInstallationsApi r17, com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent r18, com.google.firebase.analytics.connector.AnalyticsConnector r19) {
        /*
        // Method dump skipped, instructions count: 196
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.FirebaseCrashlytics.init(com.google.firebase.FirebaseApp, com.google.firebase.installations.FirebaseInstallationsApi, com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent, com.google.firebase.analytics.connector.AnalyticsConnector):com.google.firebase.crashlytics.FirebaseCrashlytics");
    }

    private static AnalyticsConnector.AnalyticsConnectorHandle subscribeToAnalyticsEvents(AnalyticsConnector analyticsConnector, CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener("clx", crashlyticsAnalyticsListener);
        if (registerAnalyticsConnectorListener == null) {
            Logger.getLogger().d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener(LEGACY_CRASH_ANALYTICS_ORIGIN, crashlyticsAnalyticsListener);
            if (registerAnalyticsConnectorListener != null) {
                Logger.getLogger().w("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return registerAnalyticsConnectorListener;
    }

    public yi4<Boolean> checkForUnsentReports() {
        return this.core.checkForUnsentReports();
    }

    public void deleteUnsentReports() {
        this.core.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.core.didCrashOnPreviousExecution();
    }

    public void log(String str) {
        this.core.log(str);
    }

    public void recordException(Throwable th) {
        if (th == null) {
            Logger.getLogger().w("Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.core.logException(th);
        }
    }

    public void sendUnsentReports() {
        this.core.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(boolean z) {
        this.core.setCrashlyticsCollectionEnabled(Boolean.valueOf(z));
    }

    public void setCustomKey(String str, boolean z) {
        this.core.setCustomKey(str, Boolean.toString(z));
    }

    public void setUserId(String str) {
        this.core.setUserId(str);
    }

    public void setCrashlyticsCollectionEnabled(Boolean bool) {
        this.core.setCrashlyticsCollectionEnabled(bool);
    }

    public void setCustomKey(String str, double d) {
        this.core.setCustomKey(str, Double.toString(d));
    }

    public void setCustomKey(String str, float f) {
        this.core.setCustomKey(str, Float.toString(f));
    }

    public void setCustomKey(String str, int i) {
        this.core.setCustomKey(str, Integer.toString(i));
    }

    public void setCustomKey(String str, long j) {
        this.core.setCustomKey(str, Long.toString(j));
    }

    public void setCustomKey(String str, String str2) {
        this.core.setCustomKey(str, str2);
    }
}
