package com.google.firebase.perf.v1;

import java.util.Map;

public interface ApplicationInfoOrBuilder extends k15 {
    boolean containsCustomAttributes(String str);

    AndroidApplicationInfo getAndroidAppInfo();

    String getAppInstanceId();

    a05 getAppInstanceIdBytes();

    ApplicationProcessState getApplicationProcessState();

    @Deprecated
    Map<String, String> getCustomAttributes();

    int getCustomAttributesCount();

    Map<String, String> getCustomAttributesMap();

    String getCustomAttributesOrDefault(String str, String str2);

    String getCustomAttributesOrThrow(String str);

    @Override // defpackage.k15
    /* synthetic */ j15 getDefaultInstanceForType();

    String getGoogleAppId();

    a05 getGoogleAppIdBytes();

    IosApplicationInfo getIosAppInfo();

    WebApplicationInfo getWebAppInfo();

    boolean hasAndroidAppInfo();

    boolean hasAppInstanceId();

    boolean hasApplicationProcessState();

    boolean hasGoogleAppId();

    boolean hasIosAppInfo();

    boolean hasWebAppInfo();

    @Override // defpackage.k15
    /* synthetic */ boolean isInitialized();
}
