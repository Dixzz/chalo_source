package com.google.firebase.messaging;

import android.content.Intent;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class EnhancedIntentService$$Lambda$0 implements Runnable {
    private final EnhancedIntentService arg$1;
    private final Intent arg$2;
    private final zi4 arg$3;

    public EnhancedIntentService$$Lambda$0(EnhancedIntentService enhancedIntentService, Intent intent, zi4 zi4) {
        this.arg$1 = enhancedIntentService;
        this.arg$2 = intent;
        this.arg$3 = zi4;
    }

    public void run() {
        this.arg$1.lambda$processIntent$0$EnhancedIntentService(this.arg$2, this.arg$3);
    }
}
