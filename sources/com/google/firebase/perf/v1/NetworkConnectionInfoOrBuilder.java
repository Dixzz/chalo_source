package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkConnectionInfo;

public interface NetworkConnectionInfoOrBuilder extends k15 {
    @Override // defpackage.k15
    /* synthetic */ j15 getDefaultInstanceForType();

    NetworkConnectionInfo.MobileSubtype getMobileSubtype();

    NetworkConnectionInfo.NetworkType getNetworkType();

    boolean hasMobileSubtype();

    boolean hasNetworkType();

    @Override // defpackage.k15
    /* synthetic */ boolean isInitialized();
}
