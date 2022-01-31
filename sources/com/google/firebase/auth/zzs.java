package com.google.firebase.auth;

import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.internal.zzg;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class zzs implements zzg {
    public final /* synthetic */ FirebaseAuth zza;

    public zzs(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(zzwg zzwg, FirebaseUser firebaseUser) {
        Objects.requireNonNull(zzwg, "null reference");
        Objects.requireNonNull(firebaseUser, "null reference");
        firebaseUser.zzf(zzwg);
        this.zza.zza(firebaseUser, zzwg, true, false);
    }
}
