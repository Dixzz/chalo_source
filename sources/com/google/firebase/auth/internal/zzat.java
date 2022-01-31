package com.google.firebase.auth.internal;

import android.content.Context;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzat implements ui4 {
    public final /* synthetic */ zi4 zza;
    public final /* synthetic */ Context zzb;

    public zzat(zzax zzax, zi4 zi4, Context context) {
        this.zza = zi4;
        this.zzb = context;
    }

    @Override // defpackage.ui4
    public final void onFailure(Exception exc) {
        this.zza.f4178a.u(exc);
        zzax.zzd(this.zzb);
    }
}
