package com.google.firebase.auth.internal;

import defpackage.k32;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzbh implements k32.a {
    public final /* synthetic */ zzbi zza;

    public zzbh(zzbi zzbi) {
        this.zza = zzbi;
    }

    @Override // defpackage.k32.a
    public final void onBackgroundStateChanged(boolean z) {
        if (z) {
            this.zza.zzc = true;
            this.zza.zzc();
            return;
        }
        this.zza.zzc = false;
        if (this.zza.zzg()) {
            this.zza.zzb.zza();
        }
    }
}
