package com.google.firebase.messaging;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class FirebaseMessaging$$Lambda$8 implements qi4 {
    private final FirebaseMessaging arg$1;
    private final String arg$2;

    public FirebaseMessaging$$Lambda$8(FirebaseMessaging firebaseMessaging, String str) {
        this.arg$1 = firebaseMessaging;
        this.arg$2 = str;
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return this.arg$1.lambda$blockingGetToken$9$FirebaseMessaging(this.arg$2, yi4);
    }
}
