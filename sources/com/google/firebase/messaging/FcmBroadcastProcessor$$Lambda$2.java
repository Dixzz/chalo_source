package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class FcmBroadcastProcessor$$Lambda$2 implements qi4 {
    private final Context arg$1;
    private final Intent arg$2;

    public FcmBroadcastProcessor$$Lambda$2(Context context, Intent intent) {
        this.arg$1 = context;
        this.arg$2 = intent;
    }

    @Override // defpackage.qi4
    public Object then(yi4 yi4) {
        return FcmBroadcastProcessor.lambda$startMessagingService$2$FcmBroadcastProcessor(this.arg$1, this.arg$2, yi4);
    }
}
