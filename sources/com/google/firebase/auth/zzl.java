package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzl implements Runnable {
    public final /* synthetic */ InternalTokenResult zza;
    public final /* synthetic */ FirebaseAuth zzb;

    public zzl(FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult) {
        this.zzb = firebaseAuth;
        this.zza = internalTokenResult;
    }

    public final void run() {
        for (IdTokenListener idTokenListener : this.zzb.zzc) {
            idTokenListener.onIdTokenChanged(this.zza);
        }
        for (FirebaseAuth.IdTokenListener idTokenListener2 : this.zzb.zzb) {
            idTokenListener2.onIdTokenChanged(this.zzb);
        }
    }
}
