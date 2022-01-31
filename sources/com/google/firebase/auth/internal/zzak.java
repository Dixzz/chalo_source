package com.google.firebase.auth.internal;

import com.google.firebase.FirebaseNetworkException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzak implements ui4 {
    public final /* synthetic */ zzal zza;

    public zzak(zzal zzal) {
        this.zza = zzal;
    }

    @Override // defpackage.ui4
    public final void onFailure(Exception exc) {
        if (exc instanceof FirebaseNetworkException) {
            zzam.zzg.c("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.zza.zza.zzb();
        }
    }
}
