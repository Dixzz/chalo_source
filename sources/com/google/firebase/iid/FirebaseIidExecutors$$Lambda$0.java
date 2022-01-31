package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public final /* synthetic */ class FirebaseIidExecutors$$Lambda$0 implements Executor {
    public static final Executor $instance = new FirebaseIidExecutors$$Lambda$0();

    private FirebaseIidExecutors$$Lambda$0() {
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
