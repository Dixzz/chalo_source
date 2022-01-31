package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;

public class DataCollectionArbiter {
    private static final String FIREBASE_CRASHLYTICS_COLLECTION_ENABLED = "firebase_crashlytics_collection_enabled";
    private Boolean crashlyticsDataCollectionEnabled;
    public zi4<Void> dataCollectionEnabledTask = new zi4<>();
    private zi4<Void> dataCollectionExplicitlyApproved = new zi4<>();
    private final FirebaseApp firebaseApp;
    private boolean setInManifest = false;
    private final SharedPreferences sharedPreferences;
    private final Object taskLock;
    public boolean taskResolved = false;

    public DataCollectionArbiter(FirebaseApp firebaseApp2) {
        Object obj = new Object();
        this.taskLock = obj;
        Context applicationContext = firebaseApp2.getApplicationContext();
        this.firebaseApp = firebaseApp2;
        this.sharedPreferences = CommonUtils.getSharedPrefs(applicationContext);
        Boolean dataCollectionValueFromSharedPreferences = getDataCollectionValueFromSharedPreferences();
        this.crashlyticsDataCollectionEnabled = dataCollectionValueFromSharedPreferences == null ? getDataCollectionValueFromManifest(applicationContext) : dataCollectionValueFromSharedPreferences;
        synchronized (obj) {
            if (isAutomaticDataCollectionEnabled()) {
                this.dataCollectionEnabledTask.b(null);
                this.taskResolved = true;
            }
        }
    }

    private Boolean getDataCollectionValueFromManifest(Context context) {
        Boolean readCrashlyticsDataCollectionEnabledFromManifest = readCrashlyticsDataCollectionEnabledFromManifest(context);
        if (readCrashlyticsDataCollectionEnabledFromManifest == null) {
            this.setInManifest = false;
            return null;
        }
        this.setInManifest = true;
        return Boolean.valueOf(Boolean.TRUE.equals(readCrashlyticsDataCollectionEnabledFromManifest));
    }

    private Boolean getDataCollectionValueFromSharedPreferences() {
        if (!this.sharedPreferences.contains(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED)) {
            return null;
        }
        this.setInManifest = false;
        return Boolean.valueOf(this.sharedPreferences.getBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED, true));
    }

    private void logDataCollectionState(boolean z) {
        String str;
        String str2 = z ? "ENABLED" : "DISABLED";
        if (this.crashlyticsDataCollectionEnabled == null) {
            str = "global Firebase setting";
        } else {
            str = this.setInManifest ? "firebase_crashlytics_collection_enabled manifest flag" : "API";
        }
        Logger.getLogger().d(String.format("Crashlytics automatic data collection %s by %s.", str2, str));
    }

    private static Boolean readCrashlyticsDataCollectionEnabledFromManifest(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED)) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED));
        } catch (PackageManager.NameNotFoundException e) {
            Logger.getLogger().d("Unable to get PackageManager. Falling through", e);
            return null;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    private static void storeDataCollectionValueInSharedPreferences(SharedPreferences sharedPreferences2, Boolean bool) {
        SharedPreferences.Editor edit = sharedPreferences2.edit();
        if (bool != null) {
            edit.putBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED, bool.booleanValue());
        } else {
            edit.remove(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED);
        }
        edit.commit();
    }

    public void grantDataCollectionPermission(boolean z) {
        if (z) {
            this.dataCollectionExplicitlyApproved.b(null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public synchronized boolean isAutomaticDataCollectionEnabled() {
        boolean z;
        Boolean bool = this.crashlyticsDataCollectionEnabled;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = this.firebaseApp.isDataCollectionDefaultEnabled();
        }
        logDataCollectionState(z);
        return z;
    }

    public synchronized void setCrashlyticsDataCollectionEnabled(Boolean bool) {
        Boolean bool2;
        if (bool != null) {
            try {
                this.setInManifest = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            bool2 = bool;
        } else {
            bool2 = getDataCollectionValueFromManifest(this.firebaseApp.getApplicationContext());
        }
        this.crashlyticsDataCollectionEnabled = bool2;
        storeDataCollectionValueInSharedPreferences(this.sharedPreferences, bool);
        synchronized (this.taskLock) {
            if (isAutomaticDataCollectionEnabled()) {
                if (!this.taskResolved) {
                    this.dataCollectionEnabledTask.b(null);
                    this.taskResolved = true;
                }
            } else if (this.taskResolved) {
                this.dataCollectionEnabledTask = new zi4<>();
                this.taskResolved = false;
            }
        }
    }

    public yi4<Void> waitForAutomaticDataCollectionEnabled() {
        wj4<TResult> wj4;
        synchronized (this.taskLock) {
            wj4 = this.dataCollectionEnabledTask.f4178a;
        }
        return wj4;
    }

    public yi4<Void> waitForDataCollectionPermission() {
        return Utils.race(this.dataCollectionExplicitlyApproved.f4178a, waitForAutomaticDataCollectionEnabled());
    }
}
