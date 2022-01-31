package com.google.firebase.auth.internal;

import android.app.Activity;
import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzb implements vi4<oh4> {
    public final /* synthetic */ zi4 zza;
    public final /* synthetic */ FirebaseAuth zzb;
    public final /* synthetic */ zzbm zzc;
    public final /* synthetic */ Activity zzd;
    public final /* synthetic */ zzf zze;

    public zzb(zzf zzf, zi4 zi4, FirebaseAuth firebaseAuth, zzbm zzbm, Activity activity) {
        this.zze = zzf;
        this.zza = zi4;
        this.zzb = firebaseAuth;
        this.zzc = zzbm;
        this.zzd = activity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.vi4
    public final void onSuccess(oh4 oh4) {
        oh4 oh42 = oh4;
        if (zzbf.zza(oh42)) {
            zi4 zi4 = this.zza;
            zi4.f4178a.t(new zze(oh42.a(), null));
            return;
        }
        this.zze.zze(this.zzb, this.zzc, this.zzd, this.zza);
    }
}
