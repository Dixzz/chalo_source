package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final /* synthetic */ class GmsRpc$$Lambda$0 implements Executor {
    public static final Executor $instance = new GmsRpc$$Lambda$0();

    private GmsRpc$$Lambda$0() {
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
