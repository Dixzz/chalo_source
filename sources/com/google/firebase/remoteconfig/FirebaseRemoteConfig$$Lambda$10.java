package com.google.firebase.remoteconfig;

/* compiled from: FirebaseRemoteConfig */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$10 implements qi4 {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$10(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static qi4 lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new FirebaseRemoteConfig$$Lambda$10(firebaseRemoteConfig);
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return Boolean.valueOf(this.arg$1.processActivatePutTask(yi4));
    }
}
