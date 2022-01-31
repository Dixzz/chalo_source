package com.google.firebase.perf.config;

import android.content.Context;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.config.ConfigurationConstants;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.Utils;

public class ConfigResolver {
    private static volatile ConfigResolver configResolver;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private DeviceCacheManager deviceCacheManager;
    private ImmutableBundle metadataBundle;
    private RemoteConfigManager remoteConfigManager;

    public ConfigResolver(RemoteConfigManager remoteConfigManager2, ImmutableBundle immutableBundle, DeviceCacheManager deviceCacheManager2) {
        this.remoteConfigManager = remoteConfigManager2 == null ? RemoteConfigManager.getInstance() : remoteConfigManager2;
        this.metadataBundle = immutableBundle == null ? new ImmutableBundle() : immutableBundle;
        this.deviceCacheManager = deviceCacheManager2 == null ? DeviceCacheManager.getInstance() : deviceCacheManager2;
    }

    public static void clearInstance() {
        configResolver = null;
    }

    private Optional<Boolean> getDeviceCacheBoolean(ConfigurationFlag<Boolean> configurationFlag) {
        return this.deviceCacheManager.getBoolean(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<Float> getDeviceCacheFloat(ConfigurationFlag<Float> configurationFlag) {
        return this.deviceCacheManager.getFloat(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<Long> getDeviceCacheLong(ConfigurationFlag<Long> configurationFlag) {
        return this.deviceCacheManager.getLong(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<String> getDeviceCacheString(ConfigurationFlag<String> configurationFlag) {
        return this.deviceCacheManager.getString(configurationFlag.getDeviceCacheFlag());
    }

    public static synchronized ConfigResolver getInstance() {
        ConfigResolver configResolver2;
        synchronized (ConfigResolver.class) {
            if (configResolver == null) {
                configResolver = new ConfigResolver(null, null, null);
            }
            configResolver2 = configResolver;
        }
        return configResolver2;
    }

    private boolean getIsSdkEnabled() {
        ConfigurationConstants.SdkEnabled instance = ConfigurationConstants.SdkEnabled.getInstance();
        Optional<Boolean> remoteConfigBoolean = getRemoteConfigBoolean(instance);
        if (!remoteConfigBoolean.isPresent()) {
            Optional<Boolean> deviceCacheBoolean = getDeviceCacheBoolean(instance);
            if (deviceCacheBoolean.isPresent()) {
                return deviceCacheBoolean.get().booleanValue();
            }
            return instance.getDefault().booleanValue();
        } else if (this.remoteConfigManager.isLastFetchFailed()) {
            return false;
        } else {
            this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigBoolean.get().booleanValue());
            return remoteConfigBoolean.get().booleanValue();
        }
    }

    private boolean getIsSdkVersionDisabled() {
        ConfigurationConstants.SdkDisabledVersions instance = ConfigurationConstants.SdkDisabledVersions.getInstance();
        Optional<String> remoteConfigString = getRemoteConfigString(instance);
        if (remoteConfigString.isPresent()) {
            this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigString.get());
            return isFireperfSdkVersionInList(remoteConfigString.get());
        }
        Optional<String> deviceCacheString = getDeviceCacheString(instance);
        if (deviceCacheString.isPresent()) {
            return isFireperfSdkVersionInList(deviceCacheString.get());
        }
        return isFireperfSdkVersionInList(instance.getDefault());
    }

    private Optional<Boolean> getMetadataBoolean(ConfigurationFlag<Boolean> configurationFlag) {
        return this.metadataBundle.getBoolean(configurationFlag.getMetadataFlag());
    }

    private Optional<Float> getMetadataFloat(ConfigurationFlag<Float> configurationFlag) {
        return this.metadataBundle.getFloat(configurationFlag.getMetadataFlag());
    }

    private Optional<Long> getMetadataLong(ConfigurationFlag<Long> configurationFlag) {
        return this.metadataBundle.getLong(configurationFlag.getMetadataFlag());
    }

    private Optional<Boolean> getRemoteConfigBoolean(ConfigurationFlag<Boolean> configurationFlag) {
        return this.remoteConfigManager.getBoolean(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<Float> getRemoteConfigFloat(ConfigurationFlag<Float> configurationFlag) {
        return this.remoteConfigManager.getFloat(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<Long> getRemoteConfigLong(ConfigurationFlag<Long> configurationFlag) {
        return this.remoteConfigManager.getLong(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<String> getRemoteConfigString(ConfigurationFlag<String> configurationFlag) {
        return this.remoteConfigManager.getString(configurationFlag.getRemoteConfigFlag());
    }

    private Long getRemoteConfigValue(ConfigurationFlag<Long> configurationFlag) {
        String remoteConfigFlag = configurationFlag.getRemoteConfigFlag();
        if (remoteConfigFlag == null) {
            return configurationFlag.getDefault();
        }
        return (Long) this.remoteConfigManager.getRemoteConfigValueOrDefault(remoteConfigFlag, configurationFlag.getDefault());
    }

    private boolean isEventCountValid(long j) {
        return j >= 0;
    }

    private boolean isFireperfSdkVersionInList(String str) {
        if (str.trim().isEmpty()) {
            return false;
        }
        for (String str2 : str.split(";")) {
            if (str2.trim().equals(BuildConfig.FIREPERF_VERSION_NAME)) {
                return true;
            }
        }
        return false;
    }

    private boolean isGaugeCaptureFrequencyMsValid(long j) {
        return j >= 0;
    }

    private boolean isSamplingRateValid(float f) {
        return 0.0f <= f && f <= 1.0f;
    }

    private boolean isSessionsMaxDurationMinutesValid(long j) {
        return j > 0;
    }

    private boolean isTimeRangeSecValid(long j) {
        return j > 0;
    }

    private boolean isTransportRolloutPercentageValid(float f) {
        return 0.0f <= f && f <= 100.0f;
    }

    public String getAndCacheLogSourceName() {
        String logSourceName;
        ConfigurationConstants.LogSourceName instance = ConfigurationConstants.LogSourceName.getInstance();
        if (BuildConfig.ENFORCE_DEFAULT_LOG_SRC.booleanValue()) {
            return instance.getDefault();
        }
        String remoteConfigFlag = instance.getRemoteConfigFlag();
        long j = -1;
        if (remoteConfigFlag != null) {
            j = ((Long) this.remoteConfigManager.getRemoteConfigValueOrDefault(remoteConfigFlag, -1L)).longValue();
        }
        String deviceCacheFlag = instance.getDeviceCacheFlag();
        if (!ConfigurationConstants.LogSourceName.isLogSourceKnown(j) || (logSourceName = ConfigurationConstants.LogSourceName.getLogSourceName(j)) == null) {
            Optional<String> deviceCacheString = getDeviceCacheString(instance);
            if (deviceCacheString.isPresent()) {
                return deviceCacheString.get();
            }
            return instance.getDefault();
        }
        this.deviceCacheManager.setValue(deviceCacheFlag, logSourceName);
        return logSourceName;
    }

    public float getFlgTransportRolloutPercentage() {
        ConfigurationConstants.TransportRolloutPercentage instance = ConfigurationConstants.TransportRolloutPercentage.getInstance();
        Optional<Float> deviceCacheFloat = getDeviceCacheFloat(instance);
        if (this.remoteConfigManager.isFirebaseRemoteConfigAvailable()) {
            Optional<Float> remoteConfigFloat = getRemoteConfigFloat(instance);
            if (remoteConfigFloat.isPresent()) {
                if (isTransportRolloutPercentageValid(remoteConfigFloat.get().floatValue())) {
                    this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigFloat.get().floatValue());
                    return remoteConfigFloat.get().floatValue();
                } else if (!deviceCacheFloat.isPresent() || !isTransportRolloutPercentageValid(deviceCacheFloat.get().floatValue())) {
                    return ConfigurationConstants.TransportRolloutPercentage.getCctPercentage();
                } else {
                    return deviceCacheFloat.get().floatValue();
                }
            } else if (this.remoteConfigManager.isFirebaseRemoteConfigMapEmpty()) {
                return ConfigurationConstants.TransportRolloutPercentage.getCctPercentage();
            } else {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), ConfigurationConstants.TransportRolloutPercentage.getFlgPercentage());
                return ConfigurationConstants.TransportRolloutPercentage.getFlgPercentage();
            }
        } else if (!deviceCacheFloat.isPresent() || !isTransportRolloutPercentageValid(deviceCacheFloat.get().floatValue())) {
            return ConfigurationConstants.TransportRolloutPercentage.getCctPercentage();
        } else {
            return deviceCacheFloat.get().floatValue();
        }
    }

    public int getHashPercentage(String str) {
        return Math.abs(str.hashCode() % 100);
    }

    public Boolean getIsPerformanceCollectionDeactivated() {
        ConfigurationConstants.CollectionDeactivated instance = ConfigurationConstants.CollectionDeactivated.getInstance();
        Optional<Boolean> metadataBoolean = getMetadataBoolean(instance);
        if (metadataBoolean.isPresent()) {
            return metadataBoolean.get();
        }
        return instance.getDefault();
    }

    public Boolean getIsPerformanceCollectionEnabled() {
        if (getIsPerformanceCollectionDeactivated().booleanValue()) {
            return Boolean.FALSE;
        }
        ConfigurationConstants.CollectionEnabled instance = ConfigurationConstants.CollectionEnabled.getInstance();
        Optional<Boolean> deviceCacheBoolean = getDeviceCacheBoolean(instance);
        if (deviceCacheBoolean.isPresent()) {
            return deviceCacheBoolean.get();
        }
        Optional<Boolean> metadataBoolean = getMetadataBoolean(instance);
        if (metadataBoolean.isPresent()) {
            return metadataBoolean.get();
        }
        logger.debug("CollectionEnabled metadata key unknown or value not found in manifest.", new Object[0]);
        return null;
    }

    public boolean getIsPerformanceMasterFlagEnabled() {
        return getIsSdkEnabled() && !getIsSdkVersionDisabled();
    }

    public long getNetworkEventCountBackground() {
        ConfigurationConstants.NetworkEventCountBackground instance = ConfigurationConstants.NetworkEventCountBackground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance);
        if (!remoteConfigLong.isPresent() || !isEventCountValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance);
            if (!deviceCacheLong.isPresent() || !isEventCountValid(deviceCacheLong.get().longValue())) {
                return instance.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getNetworkEventCountForeground() {
        ConfigurationConstants.NetworkEventCountForeground instance = ConfigurationConstants.NetworkEventCountForeground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance);
        if (!remoteConfigLong.isPresent() || !isEventCountValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance);
            if (!deviceCacheLong.isPresent() || !isEventCountValid(deviceCacheLong.get().longValue())) {
                return instance.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public float getNetworkRequestSamplingRate() {
        ConfigurationConstants.NetworkRequestSamplingRate instance = ConfigurationConstants.NetworkRequestSamplingRate.getInstance();
        Optional<Float> remoteConfigFloat = getRemoteConfigFloat(instance);
        if (!remoteConfigFloat.isPresent() || !isSamplingRateValid(remoteConfigFloat.get().floatValue())) {
            Optional<Float> deviceCacheFloat = getDeviceCacheFloat(instance);
            if (!deviceCacheFloat.isPresent() || !isSamplingRateValid(deviceCacheFloat.get().floatValue())) {
                return instance.getDefault().floatValue();
            }
            return deviceCacheFloat.get().floatValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigFloat.get().floatValue());
        return remoteConfigFloat.get().floatValue();
    }

    public long getRateLimitSec() {
        ConfigurationConstants.RateLimitSec instance = ConfigurationConstants.RateLimitSec.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance);
        if (!remoteConfigLong.isPresent() || !isTimeRangeSecValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance);
            if (!deviceCacheLong.isPresent() || !isTimeRangeSecValid(deviceCacheLong.get().longValue())) {
                return instance.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getSessionsCpuCaptureFrequencyBackgroundMs() {
        ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs instance = ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(instance);
        if (metadataLong.isPresent() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance);
        if (!remoteConfigLong.isPresent() || !isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance);
            if (!deviceCacheLong.isPresent() || !isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) {
                return instance.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getSessionsCpuCaptureFrequencyForegroundMs() {
        ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs instance = ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(instance);
        if (metadataLong.isPresent() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance);
        if (!remoteConfigLong.isPresent() || !isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance);
            if (!deviceCacheLong.isPresent() || !isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) {
                return instance.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getSessionsMaxDurationMinutes() {
        ConfigurationConstants.SessionsMaxDurationMinutes instance = ConfigurationConstants.SessionsMaxDurationMinutes.getInstance();
        Optional<Long> metadataLong = getMetadataLong(instance);
        if (metadataLong.isPresent() && isSessionsMaxDurationMinutesValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance);
        if (!remoteConfigLong.isPresent() || !isSessionsMaxDurationMinutesValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance);
            if (!deviceCacheLong.isPresent() || !isSessionsMaxDurationMinutesValid(deviceCacheLong.get().longValue())) {
                return instance.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getSessionsMemoryCaptureFrequencyBackgroundMs() {
        ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs instance = ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(instance);
        if (metadataLong.isPresent() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance);
        if (!remoteConfigLong.isPresent() || !isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance);
            if (!deviceCacheLong.isPresent() || !isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) {
                return instance.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getSessionsMemoryCaptureFrequencyForegroundMs() {
        ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs instance = ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(instance);
        if (metadataLong.isPresent() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance);
        if (!remoteConfigLong.isPresent() || !isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance);
            if (!deviceCacheLong.isPresent() || !isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) {
                return instance.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public float getSessionsSamplingRate() {
        ConfigurationConstants.SessionsSamplingRate instance = ConfigurationConstants.SessionsSamplingRate.getInstance();
        Optional<Float> metadataFloat = getMetadataFloat(instance);
        if (metadataFloat.isPresent()) {
            float floatValue = metadataFloat.get().floatValue() / 100.0f;
            if (isSamplingRateValid(floatValue)) {
                return floatValue;
            }
        }
        Optional<Float> remoteConfigFloat = getRemoteConfigFloat(instance);
        if (!remoteConfigFloat.isPresent() || !isSamplingRateValid(remoteConfigFloat.get().floatValue())) {
            Optional<Float> deviceCacheFloat = getDeviceCacheFloat(instance);
            if (!deviceCacheFloat.isPresent() || !isSamplingRateValid(deviceCacheFloat.get().floatValue())) {
                return instance.getDefault().floatValue();
            }
            return deviceCacheFloat.get().floatValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigFloat.get().floatValue());
        return remoteConfigFloat.get().floatValue();
    }

    public long getTraceEventCountBackground() {
        ConfigurationConstants.TraceEventCountBackground instance = ConfigurationConstants.TraceEventCountBackground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance);
        if (!remoteConfigLong.isPresent() || !isEventCountValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance);
            if (!deviceCacheLong.isPresent() || !isEventCountValid(deviceCacheLong.get().longValue())) {
                return instance.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getTraceEventCountForeground() {
        ConfigurationConstants.TraceEventCountForeground instance = ConfigurationConstants.TraceEventCountForeground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance);
        if (!remoteConfigLong.isPresent() || !isEventCountValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance);
            if (!deviceCacheLong.isPresent() || !isEventCountValid(deviceCacheLong.get().longValue())) {
                return instance.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public float getTraceSamplingRate() {
        ConfigurationConstants.TraceSamplingRate instance = ConfigurationConstants.TraceSamplingRate.getInstance();
        Optional<Float> remoteConfigFloat = getRemoteConfigFloat(instance);
        if (!remoteConfigFloat.isPresent() || !isSamplingRateValid(remoteConfigFloat.get().floatValue())) {
            Optional<Float> deviceCacheFloat = getDeviceCacheFloat(instance);
            if (!deviceCacheFloat.isPresent() || !isSamplingRateValid(deviceCacheFloat.get().floatValue())) {
                return instance.getDefault().floatValue();
            }
            return deviceCacheFloat.get().floatValue();
        }
        this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), remoteConfigFloat.get().floatValue());
        return remoteConfigFloat.get().floatValue();
    }

    public boolean isDispatchToFlg(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (((float) getHashPercentage(str)) < getFlgTransportRolloutPercentage()) {
            return true;
        }
        return false;
    }

    public boolean isPerformanceMonitoringEnabled() {
        Boolean isPerformanceCollectionEnabled = getIsPerformanceCollectionEnabled();
        if ((isPerformanceCollectionEnabled == null || isPerformanceCollectionEnabled.booleanValue()) && getIsPerformanceMasterFlagEnabled()) {
            return true;
        }
        return false;
    }

    public void setApplicationContext(Context context) {
        logger.setLogcatEnabled(Utils.isDebugLoggingEnabled(context));
        this.deviceCacheManager.setContext(context);
    }

    public void setContentProviderContext(Context context) {
        setApplicationContext(context.getApplicationContext());
    }

    public void setIsPerformanceCollectionEnabled(Boolean bool) {
        String deviceCacheFlag;
        if (getIsPerformanceCollectionDeactivated().booleanValue() || (deviceCacheFlag = ConfigurationConstants.CollectionEnabled.getInstance().getDeviceCacheFlag()) == null) {
            return;
        }
        if (bool != null) {
            this.deviceCacheManager.setValue(deviceCacheFlag, Boolean.TRUE.equals(bool));
        } else {
            this.deviceCacheManager.clear(deviceCacheFlag);
        }
    }

    public void setMetadataBundle(ImmutableBundle immutableBundle) {
        this.metadataBundle = immutableBundle;
    }
}
