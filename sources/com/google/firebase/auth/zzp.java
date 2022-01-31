package com.google.firebase.auth;

import android.app.Activity;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zze;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzp implements ti4<zze> {
    public final /* synthetic */ PhoneAuthOptions zza;
    public final /* synthetic */ FirebaseAuth zzb;

    public zzp(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions) {
        this.zzb = firebaseAuth;
        this.zza = phoneAuthOptions;
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
            str = yi4.m().zzb();
            str2 = zza2;
        }
        long longValue = this.zza.zzc().longValue();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = this.zzb.zzJ(this.zza.zzb(), this.zza.zzd());
        zzag zzag = (zzag) this.zza.zzg();
        if (zzag.zze()) {
            p43 p43 = this.zzb.zze;
            String zzb2 = this.zza.zzb();
            String str3 = this.zzb.zzi;
            boolean z = this.zza.zzf() != null;
            boolean zzh = this.zza.zzh();
            boolean z2 = s43.f3183a;
            Executor zze = this.zza.zze();
            Activity zzi = this.zza.zzi();
            Objects.requireNonNull(p43);
            s33 s33 = new s33(zzag, zzb2, str3, longValue, z, zzh, str2, str, z2);
            s33.f(onVerificationStateChangedCallbacks, zzi, zze, zzb2);
            p43.c(s33);
            return;
        }
        p43 p432 = this.zzb.zze;
        PhoneMultiFactorInfo zzj = this.zza.zzj();
        String str4 = this.zzb.zzi;
        boolean z3 = this.zza.zzf() != null;
        boolean zzh2 = this.zza.zzh();
        boolean z4 = s43.f3183a;
        Executor zze2 = this.zza.zze();
        Activity zzi2 = this.zza.zzi();
        Objects.requireNonNull(p432);
        u33 u33 = new u33(zzj, zzag.zzd(), str4, longValue, z3, zzh2, str2, str, z4);
        u33.f(onVerificationStateChangedCallbacks, zzi2, zze2, zzj.getUid());
        p432.c(u33);
    }
}
