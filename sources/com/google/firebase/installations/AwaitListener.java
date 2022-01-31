package com.google.firebase.installations;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class AwaitListener implements ti4<Void> {
    private final CountDownLatch latch = new CountDownLatch(1);

    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.latch.await(j, timeUnit);
    }

    @Override // defpackage.ti4
    public void onComplete(yi4<Void> yi4) {
        this.latch.countDown();
    }

    public void onSuccess() {
        this.latch.countDown();
    }
}
