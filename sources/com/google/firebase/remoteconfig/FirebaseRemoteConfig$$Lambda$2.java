package com.google.firebase.remoteconfig;

/* compiled from: FirebaseRemoteConfig */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$2 implements qi4 {
    private final yi4 arg$1;

    private FirebaseRemoteConfig$$Lambda$2(yi4 yi4) {
        this.arg$1 = yi4;
    }

    public static qi4 lambdaFactory$(yi4 yi4) {
        return new FirebaseRemoteConfig$$Lambda$2(yi4);
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return FirebaseRemoteConfig.lambda$ensureInitialized$0(this.arg$1, yi4);
    }
}
