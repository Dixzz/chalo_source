package com.google.firebase.messaging;

import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class FirebaseMessaging$$Lambda$0 implements FirebaseInstanceIdInternal.NewTokenListener {
    private final FirebaseMessaging arg$1;

    public FirebaseMessaging$$Lambda$0(FirebaseMessaging firebaseMessaging) {
        this.arg$1 = firebaseMessaging;
    }

    @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener
    public void onNewToken(String str) {
        this.arg$1.bridge$lambda$0$FirebaseMessaging(str);
    }
}
