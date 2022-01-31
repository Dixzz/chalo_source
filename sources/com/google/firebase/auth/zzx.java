package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzx implements qi4<GetTokenResult, yi4<Void>> {
    public final /* synthetic */ ActionCodeSettings zza;
    public final /* synthetic */ FirebaseUser zzb;

    public zzx(FirebaseUser firebaseUser, ActionCodeSettings actionCodeSettings) {
        this.zzb = firebaseUser;
        this.zza = actionCodeSettings;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [yi4] */
    @Override // defpackage.qi4
    public final /* bridge */ /* synthetic */ yi4<Void> then(yi4<GetTokenResult> yi4) throws Exception {
        return FirebaseAuth.getInstance(this.zzb.zzd()).zzt(this.zza, yi4.m().getToken());
    }
}
