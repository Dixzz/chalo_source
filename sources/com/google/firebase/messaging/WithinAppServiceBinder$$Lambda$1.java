package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class WithinAppServiceBinder$$Lambda$1 implements ti4 {
    private final WithinAppServiceConnection.BindRequest arg$1;

    public WithinAppServiceBinder$$Lambda$1(WithinAppServiceConnection.BindRequest bindRequest) {
        this.arg$1 = bindRequest;
    }

    @Override // defpackage.ti4
    public void onComplete(yi4 yi4) {
        this.arg$1.finish();
    }
}
