package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzan;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzi implements zzan {
    public final /* synthetic */ FirebaseUser zza;
    public final /* synthetic */ FirebaseAuth zzb;

    public zzi(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zzb = firebaseAuth;
        this.zza = firebaseUser;
    }

    @Override // com.google.firebase.auth.internal.zzan
    public final void zza() {
        if (this.zzb.zzf.getUid().equalsIgnoreCase(this.zza.getUid())) {
            this.zzb.zzb();
        }
    }

    @Override // com.google.firebase.auth.internal.zzao
    public final void zzb(Status status) {
        int i = status.g;
        if (i == 17011 || i == 17021 || i == 17005) {
            this.zzb.signOut();
        }
    }
}
