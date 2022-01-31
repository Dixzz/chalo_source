package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.firebase.auth.AuthResult;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzau implements vi4<AuthResult> {
    public final /* synthetic */ zi4 zza;
    public final /* synthetic */ Context zzb;

    public zzau(zzax zzax, zi4 zi4, Context context) {
        this.zza = zi4;
        this.zzb = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.vi4
    public final void onSuccess(AuthResult authResult) {
        this.zza.f4178a.t(authResult);
        zzax.zzd(this.zzb);
    }
}
