package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public final /* synthetic */ class FirebaseInstanceId$$Lambda$1 implements Executor {
    public static final Executor $instance = new FirebaseInstanceId$$Lambda$1();

    private FirebaseInstanceId$$Lambda$1() {
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
