package com.google.firebase.perf.internal;

/* compiled from: RemoteConfigManager */
public final /* synthetic */ class RemoteConfigManager$$Lambda$2 implements ui4 {
    private final RemoteConfigManager arg$1;

    private RemoteConfigManager$$Lambda$2(RemoteConfigManager remoteConfigManager) {
        this.arg$1 = remoteConfigManager;
    }

    public static ui4 lambdaFactory$(RemoteConfigManager remoteConfigManager) {
        return new RemoteConfigManager$$Lambda$2(remoteConfigManager);
    }

    @Override // defpackage.ui4
    public void onFailure(Exception exc) {
        this.arg$1.firebaseRemoteConfigLastFetchTimestampMs = 0;
    }
}
