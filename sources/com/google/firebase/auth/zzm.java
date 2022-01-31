package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzm implements Runnable {
    public final /* synthetic */ FirebaseAuth zza;

    public zzm(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void run() {
        for (FirebaseAuth.AuthStateListener authStateListener : this.zza.zzd) {
            authStateListener.onAuthStateChanged(this.zza);
        }
    }
}
