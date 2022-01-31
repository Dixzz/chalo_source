package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.firebase.messaging.WithinAppServiceConnection;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class WithinAppServiceBinder extends Binder {
    private final IntentHandler intentHandler;

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    public interface IntentHandler {
        yi4<Void> handle(Intent intent);
    }

    public WithinAppServiceBinder(IntentHandler intentHandler2) {
        this.intentHandler = intentHandler2;
    }

    public void send(WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() == Process.myUid()) {
            Log.isLoggable(Constants.TAG, 3);
            this.intentHandler.handle(bindRequest.intent).c(WithinAppServiceBinder$$Lambda$0.$instance, new WithinAppServiceBinder$$Lambda$1(bindRequest));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
