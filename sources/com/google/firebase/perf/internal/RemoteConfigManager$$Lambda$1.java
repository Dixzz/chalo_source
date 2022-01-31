package com.google.firebase.perf.internal;

/* compiled from: RemoteConfigManager */
public final /* synthetic */ class RemoteConfigManager$$Lambda$1 implements vi4 {
    private final RemoteConfigManager arg$1;

    private RemoteConfigManager$$Lambda$1(RemoteConfigManager remoteConfigManager) {
        this.arg$1 = remoteConfigManager;
    }

    public static vi4 lambdaFactory$(RemoteConfigManager remoteConfigManager) {
        return new RemoteConfigManager$$Lambda$1(remoteConfigManager);
    }

    @Override // defpackage.vi4
    public void onSuccess(Object obj) {
        RemoteConfigManager remoteConfigManager;
        Boolean bool = (Boolean) obj;
        remoteConfigManager.syncConfigValues(this.arg$1.firebaseRemoteConfig.getAll());
    }
}
