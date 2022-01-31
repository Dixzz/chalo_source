package com.google.firebase.auth;

import android.app.Activity;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zze;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzo implements ti4<zze> {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ TimeUnit zzc;
    public final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zzd;
    public final /* synthetic */ Activity zze;
    public final /* synthetic */ Executor zzf;
    public final /* synthetic */ boolean zzg;
    public final /* synthetic */ FirebaseAuth zzh;

    public zzo(FirebaseAuth firebaseAuth, String str, long j, TimeUnit timeUnit, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, boolean z) {
        this.zzh = firebaseAuth;
        this.zza = str;
        this.zzb = j;
        this.zzc = timeUnit;
        this.zzd = onVerificationStateChangedCallbacks;
        this.zze = activity;
        this.zzf = executor;
        this.zzg = z;
    }

    @Override // defpackage.ti4
    public final void onComplete(yi4<zze> yi4) {
        String str;
        String str2;
        if (!yi4.q()) {
            String valueOf = String.valueOf(yi4.l().getMessage());
            if (valueOf.length() != 0) {
                "Error while validating application identity: ".concat(valueOf);
            } else {
                new String("Error while validating application identity: ");
            }
            str2 = null;
            str = null;
        } else {
            String zza2 = yi4.m().zza();
            str2 = yi4.m().zzb();
            str = zza2;
        }
        this.zzh.zzk(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, str2, str);
    }
}
