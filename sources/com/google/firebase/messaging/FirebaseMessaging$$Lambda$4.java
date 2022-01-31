package com.google.firebase.messaging;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class FirebaseMessaging$$Lambda$4 implements Runnable {
    private final FirebaseMessaging arg$1;
    private final zi4 arg$2;

    public FirebaseMessaging$$Lambda$4(FirebaseMessaging firebaseMessaging, zi4 zi4) {
        this.arg$1 = firebaseMessaging;
        this.arg$2 = zi4;
    }

    public void run() {
        this.arg$1.lambda$deleteToken$3$FirebaseMessaging(this.arg$2);
    }
}
