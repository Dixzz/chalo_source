package com.google.firebase.iid;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public final /* synthetic */ class FirebaseInstanceId$$Lambda$0 implements qi4 {
    private final FirebaseInstanceId arg$1;
    private final String arg$2;
    private final String arg$3;

    public FirebaseInstanceId$$Lambda$0(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.arg$1 = firebaseInstanceId;
        this.arg$2 = str;
        this.arg$3 = str2;
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return this.arg$1.lambda$getInstanceId$3$FirebaseInstanceId(this.arg$2, this.arg$3, yi4);
    }
}
