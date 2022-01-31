package com.google.firebase.messaging;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class FirebaseMessaging$$Lambda$6 implements xi4 {
    private final String arg$1;

    public FirebaseMessaging$$Lambda$6(String str) {
        this.arg$1 = str;
    }

    @Override // defpackage.xi4
    public yi4 then(Object obj) {
        return FirebaseMessaging.lambda$subscribeToTopic$6$FirebaseMessaging(this.arg$1, (TopicsSubscriber) obj);
    }
}
