package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzy implements qi4<GetTokenResult, yi4<Void>> {
    public final /* synthetic */ String zza;
    public final /* synthetic */ ActionCodeSettings zzb;
    public final /* synthetic */ FirebaseUser zzc;

    public zzy(FirebaseUser firebaseUser, String str, ActionCodeSettings actionCodeSettings) {
        this.zzc = firebaseUser;
        this.zza = str;
        this.zzb = actionCodeSettings;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [yi4] */
    @Override // defpackage.qi4
    public final /* bridge */ /* synthetic */ yi4<Void> then(yi4<GetTokenResult> yi4) throws Exception {
        return FirebaseAuth.getInstance(this.zzc.zzd()).zzz(yi4.m().getToken(), this.zza, this.zzb);
    }
}
