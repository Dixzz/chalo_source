package com.google.firebase.remoteconfig;

/* compiled from: FirebaseRemoteConfig */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$3 implements xi4 {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$3(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static xi4 lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new FirebaseRemoteConfig$$Lambda$3(firebaseRemoteConfig);
    }

    @Override // defpackage.xi4
    public yi4 then(Object obj) {
        Void r2 = (Void) obj;
        return this.arg$1.activate();
    }
}
