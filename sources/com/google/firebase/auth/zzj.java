package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzj implements Runnable {
    public final /* synthetic */ FirebaseAuth.IdTokenListener zza;
    public final /* synthetic */ FirebaseAuth zzb;

    public zzj(FirebaseAuth firebaseAuth, FirebaseAuth.IdTokenListener idTokenListener) {
        this.zzb = firebaseAuth;
        this.zza = idTokenListener;
    }

    public final void run() {
        this.zza.onIdTokenChanged(this.zzb);
    }
}
