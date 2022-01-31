package com.google.firebase.iid;

import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public final /* synthetic */ class FirebaseInstanceId$$Lambda$2 implements ti4 {
    private final CountDownLatch arg$1;

    public FirebaseInstanceId$$Lambda$2(CountDownLatch countDownLatch) {
        this.arg$1 = countDownLatch;
    }

    @Override // defpackage.ti4
    public void onComplete(yi4 yi4) {
        this.arg$1.countDown();
    }
}
