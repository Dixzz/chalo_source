package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzbk;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzn implements zzbk {
    public final /* synthetic */ FirebaseAuth zza;

    public zzn(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(zzwg zzwg, FirebaseUser firebaseUser) {
        this.zza.zza(firebaseUser, zzwg, true, true);
    }

    @Override // com.google.firebase.auth.internal.zzao
    public final void zzb(Status status) {
        int i = status.g;
        if (i == 17011 || i == 17021 || i == 17005) {
            this.zza.signOut();
        }
    }
}
