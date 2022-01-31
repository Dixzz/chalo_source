package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoteConfigComponent {
    public static final String ACTIVATE_FILE_NAME = "activate";
    public static final long CONNECTION_TIMEOUT_IN_SECONDS = 60;
    public static final String DEFAULTS_FILE_NAME = "defaults";
    private static final cb2 DEFAULT_CLOCK = db2.f817a;
    public static final String DEFAULT_NAMESPACE = "firebase";
    private static final Random DEFAULT_RANDOM = new Random();
    public static final String FETCH_FILE_NAME = "fetch";
    private static final String FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX = "frc";
    private static final String PREFERENCES_FILE_NAME = "settings";
    private final AnalyticsConnector analyticsConnector;
    private final String appId;
    private final Context context;
    private Map<String, String> customHeaders;
    private final ExecutorService executorService;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Map<String, FirebaseRemoteConfig> frcNamespaceInstances;

    public RemoteConfigComponent(Context context2, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, AnalyticsConnector analyticsConnector2) {
        this(context2, Executors.newCachedThreadPool(), firebaseApp2, firebaseInstallationsApi, firebaseABTesting, analyticsConnector2, true);
    }

    private ConfigCacheClient getCacheClient(String str, String str2) {
        return ConfigCacheClient.getInstance(Executors.newCachedThreadPool(), ConfigStorageClient.getInstance(this.context, String.format("%s_%s_%s_%s.json", "frc", this.appId, str, str2)));
    }

    private ConfigGetParameterHandler getGetHandler(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new ConfigGetParameterHandler(this.executorService, configCacheClient, configCacheClient2);
    }

    public static ConfigMetadataClient getMetadataClient(Context context2, String str, String str2) {
        return new ConfigMetadataClient(context2.getSharedPreferences(String.format("%s_%s_%s_%s", "frc", str, str2, "settings"), 0));
    }

    private static Personalization getPersonalization(FirebaseApp firebaseApp2, String str, AnalyticsConnector analyticsConnector2) {
        if (!isPrimaryApp(firebaseApp2) || !str.equals("firebase") || analyticsConnector2 == null) {
            return null;
        }
        return new Personalization(analyticsConnector2);
    }

    private static boolean isAbtSupported(FirebaseApp firebaseApp2, String str) {
        return str.equals("firebase") && isPrimaryApp(firebaseApp2);
    }

    private static boolean isPrimaryApp(FirebaseApp firebaseApp2) {
        return firebaseApp2.getName().equals(FirebaseApp.DEFAULT_APP_NAME);
    }

    public synchronized FirebaseRemoteConfig get(String str) {
        ConfigCacheClient cacheClient;
        ConfigCacheClient cacheClient2;
        ConfigCacheClient cacheClient3;
        ConfigMetadataClient metadataClient;
        ConfigGetParameterHandler getHandler;
        cacheClient = getCacheClient(str, FETCH_FILE_NAME);
        cacheClient2 = getCacheClient(str, ACTIVATE_FILE_NAME);
        cacheClient3 = getCacheClient(str, DEFAULTS_FILE_NAME);
        metadataClient = getMetadataClient(this.context, this.appId, str);
        getHandler = getGetHandler(cacheClient2, cacheClient3);
        Personalization personalization = getPersonalization(this.firebaseApp, str, this.analyticsConnector);
        if (personalization != null) {
            getHandler.addListener(RemoteConfigComponent$$Lambda$4.lambdaFactory$(personalization));
        }
        return get(this.firebaseApp, str, this.firebaseInstallations, this.firebaseAbt, this.executorService, cacheClient, cacheClient2, cacheClient3, getFetchHandler(str, cacheClient, metadataClient), getHandler, metadataClient);
    }

    public FirebaseRemoteConfig getDefault() {
        return get("firebase");
    }

    public synchronized ConfigFetchHandler getFetchHandler(String str, ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHandler(this.firebaseInstallations, isPrimaryApp(this.firebaseApp) ? this.analyticsConnector : null, this.executorService, DEFAULT_CLOCK, DEFAULT_RANDOM, configCacheClient, getFrcBackendApiClient(this.firebaseApp.getOptions().getApiKey(), str, configMetadataClient), configMetadataClient, this.customHeaders);
    }

    public ConfigFetchHttpClient getFrcBackendApiClient(String str, String str2, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHttpClient(this.context, this.firebaseApp.getOptions().getApplicationId(), str, str2, configMetadataClient.getFetchTimeoutInSeconds(), configMetadataClient.getFetchTimeoutInSeconds());
    }

    public synchronized void setCustomHeaders(Map<String, String> map) {
        this.customHeaders = map;
    }

    public RemoteConfigComponent(Context context2, ExecutorService executorService2, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, AnalyticsConnector analyticsConnector2, boolean z) {
        this.frcNamespaceInstances = new HashMap();
        this.customHeaders = new HashMap();
        this.context = context2;
        this.executorService = executorService2;
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.analyticsConnector = analyticsConnector2;
        this.appId = firebaseApp2.getOptions().getApplicationId();
        if (z) {
            hd3.A(executorService2, RemoteConfigComponent$$Lambda$1.lambdaFactory$(this));
        }
    }

    public synchronized FirebaseRemoteConfig get(FirebaseApp firebaseApp2, String str, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        if (!this.frcNamespaceInstances.containsKey(str)) {
            FirebaseRemoteConfig firebaseRemoteConfig = new FirebaseRemoteConfig(this.context, firebaseApp2, firebaseInstallationsApi, isAbtSupported(firebaseApp2, str) ? firebaseABTesting : null, executor, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient);
            firebaseRemoteConfig.startLoadingConfigsFromDisk();
            this.frcNamespaceInstances.put(str, firebaseRemoteConfig);
        }
        return this.frcNamespaceInstances.get(str);
    }
}
