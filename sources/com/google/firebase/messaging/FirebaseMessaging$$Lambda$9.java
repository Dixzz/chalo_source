package com.google.firebase.messaging;

import com.google.firebase.messaging.RequestDeduplicator;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class FirebaseMessaging$$Lambda$9 implements RequestDeduplicator.GetTokenRequest {
    private final FirebaseMessaging arg$1;
    private final yi4 arg$2;

    public FirebaseMessaging$$Lambda$9(FirebaseMessaging firebaseMessaging, yi4 yi4) {
        this.arg$1 = firebaseMessaging;
        this.arg$2 = yi4;
    }

    @Override // com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest
    public yi4 start() {
        return this.arg$1.lambda$blockingGetToken$8$FirebaseMessaging(this.arg$2);
    }
}
