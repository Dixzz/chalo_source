package com.google.firebase.auth.internal;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzd implements vi4<String> {
    public final /* synthetic */ zi4 zza;

    public zzd(zzf zzf, zi4 zi4) {
        this.zza = zi4;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.vi4
    public final void onSuccess(String str) {
        zi4 zi4 = this.zza;
        zi4.f4178a.t(new zze(null, str));
    }
}
