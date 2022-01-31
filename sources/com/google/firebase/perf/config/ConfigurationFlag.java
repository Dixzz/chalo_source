package com.google.firebase.perf.config;

public abstract class ConfigurationFlag<T> {
    public abstract T getDefault();

    public String getDeviceCacheFlag() {
        return null;
    }

    public String getMetadataFlag() {
        return null;
    }

    public String getRemoteConfigFlag() {
        return null;
    }
}
