package com.google.firebase.messaging;

import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class FirebaseMessaging$$Lambda$5 implements qi4 {
    private final FirebaseMessaging arg$1;
    private final ExecutorService arg$2;

    public FirebaseMessaging$$Lambda$5(FirebaseMessaging firebaseMessaging, ExecutorService executorService) {
        this.arg$1 = firebaseMessaging;
        this.arg$2 = executorService;
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return this.arg$1.lambda$deleteToken$5$FirebaseMessaging(this.arg$2, yi4);
    }
}
