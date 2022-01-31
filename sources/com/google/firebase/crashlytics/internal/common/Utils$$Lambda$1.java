package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.CountDownLatch;

/* compiled from: Utils */
public final /* synthetic */ class Utils$$Lambda$1 implements qi4 {
    private final CountDownLatch arg$1;

    private Utils$$Lambda$1(CountDownLatch countDownLatch) {
        this.arg$1 = countDownLatch;
    }

    public static qi4 lambdaFactory$(CountDownLatch countDownLatch) {
        return new Utils$$Lambda$1(countDownLatch);
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return this.arg$1.countDown();
    }
}
