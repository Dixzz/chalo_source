package com.google.firebase.messaging;

import android.content.Intent;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class EnhancedIntentService$$Lambda$2 implements ti4 {
    private final EnhancedIntentService arg$1;
    private final Intent arg$2;

    public EnhancedIntentService$$Lambda$2(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.arg$1 = enhancedIntentService;
        this.arg$2 = intent;
    }

    @Override // defpackage.ti4
    public void onComplete(yi4 yi4) {
        this.arg$1.lambda$onStartCommand$1$EnhancedIntentService(this.arg$2, yi4);
    }
}
