package com.google.firebase.perf.v1;

public interface WebApplicationInfoOrBuilder extends k15 {
    @Override // defpackage.k15
    /* synthetic */ j15 getDefaultInstanceForType();

    EffectiveConnectionType getEffectiveConnectionType();

    String getPageUrl();

    a05 getPageUrlBytes();

    String getSdkVersion();

    a05 getSdkVersionBytes();

    ServiceWorkerStatus getServiceWorkerStatus();

    VisibilityState getVisibilityState();

    boolean hasEffectiveConnectionType();

    boolean hasPageUrl();

    boolean hasSdkVersion();

    boolean hasServiceWorkerStatus();

    boolean hasVisibilityState();

    @Override // defpackage.k15
    /* synthetic */ boolean isInitialized();
}
