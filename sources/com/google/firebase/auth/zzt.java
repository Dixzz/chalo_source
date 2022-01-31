package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzbk;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzt implements zzbk {
    public final /* synthetic */ FirebaseAuth zza;

    public zzt(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(zzwg zzwg, FirebaseUser firebaseUser) {
        Objects.requireNonNull(zzwg, "null reference");
        Objects.requireNonNull(firebaseUser, "null reference");
        firebaseUser.zzf(zzwg);
        this.zza.zza(firebaseUser, zzwg, true, true);
    }

    @Override // com.google.firebase.auth.internal.zzao
    public final void zzb(Status status) {
        int i = status.g;
        if (i == 17011 || i == 17021 || i == 17005 || i == 17091) {
            this.zza.signOut();
        }
    }
}
