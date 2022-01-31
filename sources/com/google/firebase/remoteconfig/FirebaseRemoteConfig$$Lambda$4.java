package com.google.firebase.remoteconfig;

/* compiled from: FirebaseRemoteConfig */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$4 implements qi4 {
    private final FirebaseRemoteConfig arg$1;
    private final yi4 arg$2;
    private final yi4 arg$3;

    private FirebaseRemoteConfig$$Lambda$4(FirebaseRemoteConfig firebaseRemoteConfig, yi4 yi4, yi4 yi42) {
        this.arg$1 = firebaseRemoteConfig;
        this.arg$2 = yi4;
        this.arg$3 = yi42;
    }

    public static qi4 lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig, yi4 yi4, yi4 yi42) {
        return new FirebaseRemoteConfig$$Lambda$4(firebaseRemoteConfig, yi4, yi42);
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return FirebaseRemoteConfig.lambda$activate$2(this.arg$1, this.arg$2, this.arg$3, yi4);
    }
}
