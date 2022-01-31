package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.DefaultsXmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebaseRemoteConfig {
    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0.0d;
    public static final long DEFAULT_VALUE_FOR_LONG = 0;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = -1;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final String TAG = "FirebaseRemoteConfig";
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC = 0;
    private final ConfigCacheClient activatedConfigsCache;
    private final Context context;
    private final ConfigCacheClient defaultConfigsCache;
    private final Executor executor;
    private final ConfigFetchHandler fetchHandler;
    private final ConfigCacheClient fetchedConfigsCache;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigMetadataClient frcMetadata;
    private final ConfigGetParameterHandler getHandler;

    public FirebaseRemoteConfig(Context context2, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor2, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        this.context = context2;
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.executor = executor2;
        this.fetchedConfigsCache = configCacheClient;
        this.activatedConfigsCache = configCacheClient2;
        this.defaultConfigsCache = configCacheClient3;
        this.fetchHandler = configFetchHandler;
        this.getHandler = configGetParameterHandler;
        this.frcMetadata = configMetadataClient;
    }

    public static FirebaseRemoteConfig getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    private static boolean isFetchedFresh(ConfigContainer configContainer, ConfigContainer configContainer2) {
        return configContainer2 == null || !configContainer.getFetchTime().equals(configContainer2.getFetchTime());
    }

    public static /* synthetic */ yi4 lambda$activate$2(FirebaseRemoteConfig firebaseRemoteConfig, yi4 yi4, yi4 yi42, yi4 yi43) throws Exception {
        Boolean bool = Boolean.FALSE;
        if (!yi4.q() || yi4.m() == null) {
            return hd3.W0(bool);
        }
        ConfigContainer configContainer = (ConfigContainer) yi4.m();
        if (!yi42.q() || isFetchedFresh(configContainer, (ConfigContainer) yi42.m())) {
            return firebaseRemoteConfig.activatedConfigsCache.put(configContainer).i(firebaseRemoteConfig.executor, FirebaseRemoteConfig$$Lambda$10.lambdaFactory$(firebaseRemoteConfig));
        }
        return hd3.W0(bool);
    }

    public static /* synthetic */ FirebaseRemoteConfigInfo lambda$ensureInitialized$0(yi4 yi4, yi4 yi42) throws Exception {
        return (FirebaseRemoteConfigInfo) yi4.m();
    }

    public static /* synthetic */ Void lambda$reset$6(FirebaseRemoteConfig firebaseRemoteConfig) throws Exception {
        firebaseRemoteConfig.activatedConfigsCache.clear();
        firebaseRemoteConfig.fetchedConfigsCache.clear();
        firebaseRemoteConfig.defaultConfigsCache.clear();
        firebaseRemoteConfig.frcMetadata.clear();
        return null;
    }

    /* access modifiers changed from: private */
    public boolean processActivatePutTask(yi4<ConfigContainer> yi4) {
        if (!yi4.q()) {
            return false;
        }
        this.fetchedConfigsCache.clear();
        if (yi4.m() == null) {
            return true;
        }
        updateAbtWithActivatedExperiments(yi4.m().getAbtExperiments());
        return true;
    }

    private yi4<Void> setDefaultsWithStringsMapAsync(Map<String, String> map) {
        try {
            return this.defaultConfigsCache.put(ConfigContainer.newBuilder().replaceConfigsWith(map).build()).r(FirebaseRemoteConfig$$Lambda$9.lambdaFactory$());
        } catch (JSONException unused) {
            return hd3.W0(null);
        }
    }

    public static List<Map<String, String>> toExperimentInfoMaps(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public yi4<Boolean> activate() {
        yi4<ConfigContainer> yi4 = this.fetchedConfigsCache.get();
        yi4<ConfigContainer> yi42 = this.activatedConfigsCache.get();
        return hd3.i3(yi4, yi42).k(this.executor, FirebaseRemoteConfig$$Lambda$4.lambdaFactory$(this, yi4, yi42));
    }

    public yi4<FirebaseRemoteConfigInfo> ensureInitialized() {
        yi4<ConfigContainer> yi4 = this.activatedConfigsCache.get();
        yi4<ConfigContainer> yi42 = this.defaultConfigsCache.get();
        yi4<ConfigContainer> yi43 = this.fetchedConfigsCache.get();
        yi4 A = hd3.A(this.executor, FirebaseRemoteConfig$$Lambda$1.lambdaFactory$(this));
        return hd3.i3(yi4, yi42, yi43, A, this.firebaseInstallations.getId(), this.firebaseInstallations.getToken(false)).i(this.executor, FirebaseRemoteConfig$$Lambda$2.lambdaFactory$(A));
    }

    public yi4<Void> fetch() {
        return this.fetchHandler.fetch().r(FirebaseRemoteConfig$$Lambda$5.lambdaFactory$());
    }

    public yi4<Boolean> fetchAndActivate() {
        return fetch().s(this.executor, FirebaseRemoteConfig$$Lambda$3.lambdaFactory$(this));
    }

    public Map<String, FirebaseRemoteConfigValue> getAll() {
        return this.getHandler.getAll();
    }

    public boolean getBoolean(String str) {
        return this.getHandler.getBoolean(str);
    }

    public double getDouble(String str) {
        return this.getHandler.getDouble(str);
    }

    public FirebaseRemoteConfigInfo getInfo() {
        return this.frcMetadata.getInfo();
    }

    public Set<String> getKeysByPrefix(String str) {
        return this.getHandler.getKeysByPrefix(str);
    }

    public long getLong(String str) {
        return this.getHandler.getLong(str);
    }

    public String getString(String str) {
        return this.getHandler.getString(str);
    }

    public FirebaseRemoteConfigValue getValue(String str) {
        return this.getHandler.getValue(str);
    }

    public yi4<Void> reset() {
        return hd3.A(this.executor, FirebaseRemoteConfig$$Lambda$8.lambdaFactory$(this));
    }

    public yi4<Void> setConfigSettingsAsync(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return hd3.A(this.executor, FirebaseRemoteConfig$$Lambda$7.lambdaFactory$(this, firebaseRemoteConfigSettings));
    }

    public yi4<Void> setDefaultsAsync(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                hashMap.put(entry.getKey(), new String((byte[]) value));
            } else {
                hashMap.put(entry.getKey(), value.toString());
            }
        }
        return setDefaultsWithStringsMapAsync(hashMap);
    }

    public void startLoadingConfigsFromDisk() {
        this.activatedConfigsCache.get();
        this.defaultConfigsCache.get();
        this.fetchedConfigsCache.get();
    }

    public void updateAbtWithActivatedExperiments(JSONArray jSONArray) {
        if (this.firebaseAbt != null) {
            try {
                this.firebaseAbt.replaceAllExperiments(toExperimentInfoMaps(jSONArray));
            } catch (AbtException | JSONException unused) {
            }
        }
    }

    public static FirebaseRemoteConfig getInstance(FirebaseApp firebaseApp2) {
        return ((RemoteConfigComponent) firebaseApp2.get(RemoteConfigComponent.class)).getDefault();
    }

    public yi4<Void> fetch(long j) {
        return this.fetchHandler.fetch(j).r(FirebaseRemoteConfig$$Lambda$6.lambdaFactory$());
    }

    public yi4<Void> setDefaultsAsync(int i) {
        return setDefaultsWithStringsMapAsync(DefaultsXmlParser.getDefaultsFromXml(this.context, i));
    }
}
