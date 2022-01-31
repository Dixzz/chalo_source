package com.google.firebase.messaging;

import java.util.concurrent.ScheduledFuture;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class WithinAppServiceConnection$BindRequest$$Lambda$1 implements ti4 {
    private final ScheduledFuture arg$1;

    public WithinAppServiceConnection$BindRequest$$Lambda$1(ScheduledFuture scheduledFuture) {
        this.arg$1 = scheduledFuture;
    }

    @Override // defpackage.ti4
    public void onComplete(yi4 yi4) {
        this.arg$1.cancel(false);
    }
}
