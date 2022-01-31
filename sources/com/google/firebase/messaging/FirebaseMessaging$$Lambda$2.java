package com.google.firebase.messaging;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class FirebaseMessaging$$Lambda$2 implements vi4 {
    private final FirebaseMessaging arg$1;

    public FirebaseMessaging$$Lambda$2(FirebaseMessaging firebaseMessaging) {
        this.arg$1 = firebaseMessaging;
    }

    @Override // defpackage.vi4
    public void onSuccess(Object obj) {
        this.arg$1.lambda$new$1$FirebaseMessaging((TopicsSubscriber) obj);
    }
}
