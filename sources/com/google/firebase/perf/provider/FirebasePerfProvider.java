package com.google.firebase.perf.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;

@Keep
public class FirebasePerfProvider extends ContentProvider {
    private static final Timer APP_START_TIME = new Clock().getTime();
    public static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.google.firebase.firebaseperfprovider";
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private static void checkContentProviderAuthority(ProviderInfo providerInfo) {
        gj1.l(providerInfo, "FirebasePerfProvider ProviderInfo cannot be null.");
        if (EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

    public static Timer getAppStartTime() {
        return APP_START_TIME;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        checkContentProviderAuthority(providerInfo);
        super.attachInfo(context, providerInfo);
        ConfigResolver instance = ConfigResolver.getInstance();
        instance.setContentProviderContext(getContext());
        if (instance.isPerformanceMonitoringEnabled()) {
            AppStateMonitor.getInstance().registerActivityLifecycleCallbacks(getContext());
            AppStartTrace instance2 = AppStartTrace.getInstance();
            instance2.registerActivityLifecycleCallbacks(getContext());
            this.mHandler.post(new AppStartTrace.StartFromBackgroundRunnable(instance2));
        }
        SessionManager.getInstance().updatePerfSession(ApplicationProcessState.FOREGROUND);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
