package com.google.firebase.perf.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Keep
public class RemoteConfigManager {
    private static final long FETCH_NEVER_HAPPENED_TIMESTAMP_MS = 0;
    private static final String FIREPERF_FRC_NAMESPACE_NAME = "fireperf";
    private static final long TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS = TimeUnit.HOURS.toMillis(12);
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final RemoteConfigManager sharedInstance = new RemoteConfigManager();
    private final ConcurrentHashMap<String, FirebaseRemoteConfigValue> allRcConfigMap;
    private final Executor executor;
    private FirebaseRemoteConfig firebaseRemoteConfig;
    private long firebaseRemoteConfigLastFetchTimestampMs;
    private Provider<RemoteConfigComponent> firebaseRemoteConfigProvider;

    private RemoteConfigManager() {
        this(new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue()), null);
    }

    public static RemoteConfigManager getInstance() {
        return sharedInstance;
    }

    private FirebaseRemoteConfigValue getRemoteConfigValue(String str) {
        triggerRemoteConfigFetchIfNecessary();
        if (!isFirebaseRemoteConfigAvailable() || !this.allRcConfigMap.containsKey(str)) {
            return null;
        }
        FirebaseRemoteConfigValue firebaseRemoteConfigValue = (FirebaseRemoteConfigValue) this.allRcConfigMap.get(str);
        if (firebaseRemoteConfigValue.getSource() != 2) {
            return null;
        }
        logger.debug(String.format("Fetched value: '%s' for key: '%s' from Firebase Remote Config.", firebaseRemoteConfigValue.asString(), str), new Object[0]);
        return firebaseRemoteConfigValue;
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    private boolean shouldFetchAndActivateRemoteConfigValues() {
        return getCurrentSystemTimeMillis() - this.firebaseRemoteConfigLastFetchTimestampMs > TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS;
    }

    private void triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch() {
        this.firebaseRemoteConfigLastFetchTimestampMs = getCurrentSystemTimeMillis();
        this.firebaseRemoteConfig.fetchAndActivate().g(this.executor, RemoteConfigManager$$Lambda$1.lambdaFactory$(this)).e(this.executor, RemoteConfigManager$$Lambda$2.lambdaFactory$(this));
    }

    private void triggerRemoteConfigFetchIfNecessary() {
        if (isFirebaseRemoteConfigAvailable()) {
            if (this.allRcConfigMap.isEmpty()) {
                syncConfigValues(this.firebaseRemoteConfig.getAll());
            }
            if (shouldFetchAndActivateRemoteConfigValues()) {
                triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch();
            }
        }
    }

    public Optional<Boolean> getBoolean(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config boolean value is null.", new Object[0]);
            return Optional.empty();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return Optional.of(Boolean.valueOf(remoteConfigValue.asBoolean()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug(String.format("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str), new Object[0]);
                }
            }
        }
        return Optional.empty();
    }

    public long getCurrentSystemTimeMillis() {
        return System.currentTimeMillis();
    }

    public Optional<Float> getFloat(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config float value is null.", new Object[0]);
            return Optional.empty();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return Optional.of(Float.valueOf(Double.valueOf(remoteConfigValue.asDouble()).floatValue()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug(String.format("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str), new Object[0]);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Long> getLong(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config long value is null.", new Object[0]);
            return Optional.empty();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return Optional.of(Long.valueOf(remoteConfigValue.asLong()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug(String.format("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str), new Object[0]);
                }
            }
        }
        return Optional.empty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T getRemoteConfigValueOrDefault(java.lang.String r8, T r9) {
        /*
        // Method dump skipped, instructions count: 132
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.RemoteConfigManager.getRemoteConfigValueOrDefault(java.lang.String, java.lang.Object):java.lang.Object");
    }

    public Optional<String> getString(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config String value is null.", new Object[0]);
            return Optional.empty();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            return Optional.of(remoteConfigValue.asString());
        }
        return Optional.empty();
    }

    public boolean isFirebaseRemoteConfigAvailable() {
        Provider<RemoteConfigComponent> provider;
        RemoteConfigComponent remoteConfigComponent;
        if (!(this.firebaseRemoteConfig != null || (provider = this.firebaseRemoteConfigProvider) == null || (remoteConfigComponent = provider.get()) == null)) {
            this.firebaseRemoteConfig = remoteConfigComponent.get(FIREPERF_FRC_NAMESPACE_NAME);
        }
        return this.firebaseRemoteConfig != null;
    }

    public boolean isFirebaseRemoteConfigMapEmpty() {
        return this.allRcConfigMap.isEmpty();
    }

    public boolean isLastFetchFailed() {
        FirebaseRemoteConfig firebaseRemoteConfig2 = this.firebaseRemoteConfig;
        if (firebaseRemoteConfig2 == null || firebaseRemoteConfig2.getInfo().getLastFetchStatus() == 1) {
            return true;
        }
        return false;
    }

    public void setFirebaseRemoteConfigProvider(Provider<RemoteConfigComponent> provider) {
        this.firebaseRemoteConfigProvider = provider;
    }

    public void syncConfigValues(Map<String, FirebaseRemoteConfigValue> map) {
        this.allRcConfigMap.putAll(map);
        for (String str : this.allRcConfigMap.keySet()) {
            if (!map.containsKey(str)) {
                this.allRcConfigMap.remove(str);
            }
        }
    }

    public RemoteConfigManager(Executor executor2, FirebaseRemoteConfig firebaseRemoteConfig2) {
        ConcurrentHashMap<String, FirebaseRemoteConfigValue> concurrentHashMap;
        this.firebaseRemoteConfigLastFetchTimestampMs = 0;
        this.executor = executor2;
        this.firebaseRemoteConfig = firebaseRemoteConfig2;
        if (firebaseRemoteConfig2 == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap = new ConcurrentHashMap<>(firebaseRemoteConfig2.getAll());
        }
        this.allRcConfigMap = concurrentHashMap;
    }
}
