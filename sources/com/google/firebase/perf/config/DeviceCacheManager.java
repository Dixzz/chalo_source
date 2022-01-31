package com.google.firebase.perf.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.FirebaseApp;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;

public class DeviceCacheManager {
    private static final String PREFS_NAME = "FirebasePerfSharedPrefs";
    private static DeviceCacheManager instance;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private SharedPreferences sharedPref;

    private DeviceCacheManager() {
    }

    public static void clearInstance() {
        instance = null;
    }

    private Context getFirebaseApplicationContext() {
        try {
            FirebaseApp.getInstance();
            return FirebaseApp.getInstance().getApplicationContext();
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public static synchronized DeviceCacheManager getInstance() {
        DeviceCacheManager deviceCacheManager;
        synchronized (DeviceCacheManager.class) {
            if (instance == null) {
                instance = new DeviceCacheManager();
            }
            deviceCacheManager = instance;
        }
        return deviceCacheManager;
    }

    public void clear(String str) {
        if (str == null) {
            logger.debug("Key is null. Cannot clear nullable key", new Object[0]);
        } else {
            this.sharedPref.edit().remove(str).apply();
        }
    }

    public boolean containsKey(String str) {
        SharedPreferences sharedPreferences = this.sharedPref;
        return (sharedPreferences == null || str == null || !sharedPreferences.contains(str)) ? false : true;
    }

    public Optional<Boolean> getBoolean(String str) {
        if (str == null) {
            logger.debug("Key is null when getting boolean value on device cache.", new Object[0]);
            return Optional.empty();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.empty();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.empty();
        }
        try {
            return Optional.of(Boolean.valueOf(this.sharedPref.getBoolean(str, false)));
        } catch (ClassCastException e) {
            logger.debug(String.format("Key %s from sharedPreferences has type other than long: %s", str, e.getMessage()), new Object[0]);
            return Optional.empty();
        }
    }

    public Optional<Float> getFloat(String str) {
        if (str == null) {
            logger.debug("Key is null when getting float value on device cache.", new Object[0]);
            return Optional.empty();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.empty();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.empty();
        }
        try {
            return Optional.of(Float.valueOf(this.sharedPref.getFloat(str, 0.0f)));
        } catch (ClassCastException e) {
            logger.debug(String.format("Key %s from sharedPreferences has type other than float: %s", str, e.getMessage()), new Object[0]);
            return Optional.empty();
        }
    }

    public Optional<Long> getLong(String str) {
        if (str == null) {
            logger.debug("Key is null when getting long value on device cache.", new Object[0]);
            return Optional.empty();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.empty();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.empty();
        }
        try {
            return Optional.of(Long.valueOf(this.sharedPref.getLong(str, 0)));
        } catch (ClassCastException e) {
            logger.debug(String.format("Key %s from sharedPreferences has type other than long: %s", str, e.getMessage()), new Object[0]);
            return Optional.empty();
        }
    }

    public Optional<String> getString(String str) {
        if (str == null) {
            logger.debug("Key is null when getting String value on device cache.", new Object[0]);
            return Optional.empty();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.empty();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.empty();
        }
        try {
            return Optional.of(this.sharedPref.getString(str, ""));
        } catch (ClassCastException e) {
            logger.debug(String.format("Key %s from sharedPreferences has type other than String: %s", str, e.getMessage()), new Object[0]);
            return Optional.empty();
        }
    }

    public synchronized void setContext(Context context) {
        if (this.sharedPref == null && context != null) {
            this.sharedPref = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
        }
    }

    public boolean setValue(String str, boolean z) {
        if (str == null) {
            logger.debug("Key is null when setting boolean value on device cache.", new Object[0]);
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putBoolean(str, z).apply();
        return true;
    }

    public boolean setValue(String str, String str2) {
        if (str == null) {
            logger.debug("Key is null when setting String value on device cache.", new Object[0]);
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        if (str2 == null) {
            this.sharedPref.edit().remove(str).apply();
            return true;
        }
        this.sharedPref.edit().putString(str, str2).apply();
        return true;
    }

    public boolean setValue(String str, float f) {
        if (str == null) {
            logger.debug("Key is null when setting float value on device cache.", new Object[0]);
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putFloat(str, f).apply();
        return true;
    }

    public boolean setValue(String str, long j) {
        if (str == null) {
            logger.debug("Key is null when setting long value on device cache.", new Object[0]);
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putLong(str, j).apply();
        return true;
    }
}
