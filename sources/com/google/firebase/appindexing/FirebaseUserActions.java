package com.google.firebase.appindexing;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appindexing.internal.zzn;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public abstract class FirebaseUserActions {
    public static final String APP_INDEXING_API_TAG = "FirebaseUserActions";
    @GuardedBy("FirebaseUserActions.class")
    private static WeakReference<FirebaseUserActions> zzen;

    public static synchronized FirebaseUserActions getInstance() {
        FirebaseUserActions firebaseUserActions;
        synchronized (FirebaseUserActions.class) {
            WeakReference<FirebaseUserActions> weakReference = zzen;
            firebaseUserActions = weakReference == null ? null : weakReference.get();
            if (firebaseUserActions == null) {
                zzn zzn = new zzn(FirebaseApp.getInstance().getApplicationContext());
                zzen = new WeakReference<>(zzn);
                firebaseUserActions = zzn;
            }
        }
        return firebaseUserActions;
    }

    public abstract yi4<Void> end(Action action);

    public abstract yi4<Void> start(Action action);
}
