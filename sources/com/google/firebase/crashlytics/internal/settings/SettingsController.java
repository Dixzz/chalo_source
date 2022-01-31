package com.google.firebase.crashlytics.internal.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsController implements SettingsDataProvider {
    private static final String PREFS_BUILD_INSTANCE_IDENTIFIER = "existing_instance_identifier";
    private static final String SETTINGS_URL_FORMAT = "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings";
    private final AtomicReference<zi4<AppSettingsData>> appSettingsData = new AtomicReference<>(new zi4());
    private final CachedSettingsIo cachedSettingsIo;
    private final Context context;
    private final CurrentTimeProvider currentTimeProvider;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final AtomicReference<Settings> settings;
    private final SettingsJsonParser settingsJsonParser;
    private final SettingsRequest settingsRequest;
    private final SettingsSpiCall settingsSpiCall;

    public SettingsController(Context context2, SettingsRequest settingsRequest2, CurrentTimeProvider currentTimeProvider2, SettingsJsonParser settingsJsonParser2, CachedSettingsIo cachedSettingsIo2, SettingsSpiCall settingsSpiCall2, DataCollectionArbiter dataCollectionArbiter2) {
        AtomicReference<Settings> atomicReference = new AtomicReference<>();
        this.settings = atomicReference;
        this.context = context2;
        this.settingsRequest = settingsRequest2;
        this.currentTimeProvider = currentTimeProvider2;
        this.settingsJsonParser = settingsJsonParser2;
        this.cachedSettingsIo = cachedSettingsIo2;
        this.settingsSpiCall = settingsSpiCall2;
        this.dataCollectionArbiter = dataCollectionArbiter2;
        atomicReference.set(DefaultSettingsJsonTransform.defaultSettings(currentTimeProvider2));
    }

    public static SettingsController create(Context context2, String str, IdManager idManager, HttpRequestFactory httpRequestFactory, String str2, String str3, String str4, DataCollectionArbiter dataCollectionArbiter2) {
        String installerPackageName = idManager.getInstallerPackageName();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        return new SettingsController(context2, new SettingsRequest(str, idManager.getModelName(), idManager.getOsBuildVersionString(), idManager.getOsDisplayVersionString(), idManager, CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(context2), str, str3, str2), str3, str2, DeliveryMechanism.determineFrom(installerPackageName).getId()), systemCurrentTimeProvider, new SettingsJsonParser(systemCurrentTimeProvider), new CachedSettingsIo(context2), new DefaultSettingsSpiCall(str4, String.format(Locale.US, SETTINGS_URL_FORMAT, str), httpRequestFactory), dataCollectionArbiter2);
    }

    private SettingsData getCachedSettingsData(SettingsCacheBehavior settingsCacheBehavior) {
        Exception e;
        SettingsData settingsData = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject readCachedSettings = this.cachedSettingsIo.readCachedSettings();
            if (readCachedSettings != null) {
                SettingsData parseSettingsJson = this.settingsJsonParser.parseSettingsJson(readCachedSettings);
                if (parseSettingsJson != null) {
                    logSettings(readCachedSettings, "Loaded cached settings: ");
                    long currentTimeMillis = this.currentTimeProvider.getCurrentTimeMillis();
                    if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior)) {
                        if (parseSettingsJson.isExpired(currentTimeMillis)) {
                            Logger.getLogger().d("Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        Logger.getLogger().d("Returning cached settings.");
                        return parseSettingsJson;
                    } catch (Exception e2) {
                        e = e2;
                        settingsData = parseSettingsJson;
                        Logger.getLogger().e("Failed to get cached settings", e);
                        return settingsData;
                    }
                } else {
                    Logger.getLogger().e("Failed to parse cached settings data.", null);
                    return null;
                }
            } else {
                Logger.getLogger().d("No cached settings data found.");
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            Logger.getLogger().e("Failed to get cached settings", e);
            return settingsData;
        }
    }

    private String getStoredBuildInstanceIdentifier() {
        return CommonUtils.getSharedPrefs(this.context).getString(PREFS_BUILD_INSTANCE_IDENTIFIER, "");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void logSettings(JSONObject jSONObject, String str) throws JSONException {
        Logger logger = Logger.getLogger();
        StringBuilder i0 = hj1.i0(str);
        i0.append(jSONObject.toString());
        logger.d(i0.toString());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"CommitPrefEdits"})
    private boolean setStoredBuildInstanceIdentifier(String str) {
        SharedPreferences.Editor edit = CommonUtils.getSharedPrefs(this.context).edit();
        edit.putString(PREFS_BUILD_INSTANCE_IDENTIFIER, str);
        edit.apply();
        return true;
    }

    public boolean buildInstanceIdentifierChanged() {
        return !getStoredBuildInstanceIdentifier().equals(this.settingsRequest.instanceId);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsDataProvider
    public yi4<AppSettingsData> getAppSettings() {
        return this.appSettingsData.get().f4178a;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsDataProvider
    public Settings getSettings() {
        return this.settings.get();
    }

    public yi4<Void> loadSettingsData(Executor executor) {
        return loadSettingsData(SettingsCacheBehavior.USE_CACHE, executor);
    }

    public yi4<Void> loadSettingsData(SettingsCacheBehavior settingsCacheBehavior, Executor executor) {
        SettingsData cachedSettingsData;
        if (buildInstanceIdentifierChanged() || (cachedSettingsData = getCachedSettingsData(settingsCacheBehavior)) == null) {
            SettingsData cachedSettingsData2 = getCachedSettingsData(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
            if (cachedSettingsData2 != null) {
                this.settings.set(cachedSettingsData2);
                this.appSettingsData.get().b(cachedSettingsData2.getAppSettingsData());
            }
            return this.dataCollectionArbiter.waitForDataCollectionPermission().s(executor, new xi4<Void, Void>() {
                /* class com.google.firebase.crashlytics.internal.settings.SettingsController.AnonymousClass1 */

                public yi4<Void> then(Void r5) throws Exception {
                    JSONObject invoke = SettingsController.this.settingsSpiCall.invoke(SettingsController.this.settingsRequest, true);
                    if (invoke != null) {
                        SettingsData parseSettingsJson = SettingsController.this.settingsJsonParser.parseSettingsJson(invoke);
                        SettingsController.this.cachedSettingsIo.writeCachedSettings(parseSettingsJson.getExpiresAtMillis(), invoke);
                        SettingsController.this.logSettings(invoke, "Loaded settings: ");
                        SettingsController settingsController = SettingsController.this;
                        settingsController.setStoredBuildInstanceIdentifier(settingsController.settingsRequest.instanceId);
                        SettingsController.this.settings.set(parseSettingsJson);
                        ((zi4) SettingsController.this.appSettingsData.get()).b(parseSettingsJson.getAppSettingsData());
                        zi4 zi4 = new zi4();
                        zi4.b(parseSettingsJson.getAppSettingsData());
                        SettingsController.this.appSettingsData.set(zi4);
                    }
                    return hd3.W0(null);
                }
            });
        }
        this.settings.set(cachedSettingsData);
        this.appSettingsData.get().b(cachedSettingsData.getAppSettingsData());
        return hd3.W0(null);
    }
}
