package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzk implements Runnable {
    public final /* synthetic */ FirebaseAuth.AuthStateListener zza;
    public final /* synthetic */ FirebaseAuth zzb;

    public zzk(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.zzb = firebaseAuth;
        this.zza = authStateListener;
    }

    public final void run() {
        this.zza.onAuthStateChanged(this.zzb);
    }
}
