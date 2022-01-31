package com.google.firebase.iid;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public final /* synthetic */ class FirebaseInstanceId$$Lambda$4 implements xi4 {
    private final FirebaseInstanceId arg$1;
    private final String arg$2;
    private final String arg$3;
    private final String arg$4;

    public FirebaseInstanceId$$Lambda$4(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.arg$1 = firebaseInstanceId;
        this.arg$2 = str;
        this.arg$3 = str2;
        this.arg$4 = str3;
    }

    @Override // defpackage.xi4
    public yi4 then(Object obj) {
        return this.arg$1.lambda$getInstanceId$0$FirebaseInstanceId(this.arg$2, this.arg$3, this.arg$4, (String) obj);
    }
}
