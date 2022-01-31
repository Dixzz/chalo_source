package com.google.firebase.auth.internal;

import android.app.Activity;
import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zza implements ui4 {
    public final /* synthetic */ FirebaseAuth zza;
    public final /* synthetic */ zzbm zzb;
    public final /* synthetic */ Activity zzc;
    public final /* synthetic */ zi4 zzd;
    public final /* synthetic */ zzf zze;

    public zza(zzf zzf, FirebaseAuth firebaseAuth, zzbm zzbm, Activity activity, zi4 zi4) {
        this.zze = zzf;
        this.zza = firebaseAuth;
        this.zzb = zzbm;
        this.zzc = activity;
        this.zzd = zi4;
    }

    @Override // defpackage.ui4
    public final void onFailure(Exception exc) {
        String unused = zzf.zza;
        String valueOf = String.valueOf(exc.getMessage());
        if (valueOf.length() != 0) {
            "Problem retrieving SafetyNet Token: ".concat(valueOf);
        } else {
            new String("Problem retrieving SafetyNet Token: ");
        }
        this.zze.zze(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
