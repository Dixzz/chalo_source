package com.google.firebase.auth.internal;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzad implements qi4<AuthResult, yi4<AuthResult>> {
    public final /* synthetic */ zzae zza;

    public zzad(zzae zzae) {
        this.zza = zzae;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [yi4] */
    @Override // defpackage.qi4
    public final /* bridge */ /* synthetic */ yi4<AuthResult> then(yi4<AuthResult> yi4) throws Exception {
        if (this.zza.zzd == null) {
            return yi4;
        }
        if (yi4.q()) {
            AuthResult m = yi4.m();
            return hd3.W0(new zzr((zzx) m.getUser(), (zzp) m.getAdditionalUserInfo(), this.zza.zzd));
        }
        Exception l = yi4.l();
        if (l instanceof FirebaseAuthUserCollisionException) {
            ((FirebaseAuthUserCollisionException) l).zzb(this.zza.zzd);
        }
        return hd3.V0(l);
    }
}
