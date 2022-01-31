package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzbi {
    private volatile int zza = 0;
    private final zzam zzb;
    private volatile boolean zzc = false;

    public zzbi(FirebaseApp firebaseApp) {
        Context applicationContext = firebaseApp.getApplicationContext();
        zzam zzam = new zzam(firebaseApp);
        this.zzb = zzam;
        k32.b((Application) applicationContext.getApplicationContext());
        k32.j.a(new zzbh(this));
    }

    /* access modifiers changed from: private */
    public final boolean zzg() {
        return this.zza > 0 && !this.zzc;
    }

    public final void zza(int i) {
        if (i > 0 && this.zza == 0) {
            this.zza = i;
            if (zzg()) {
                this.zzb.zza();
            }
        } else if (i == 0 && this.zza != 0) {
            this.zzb.zzc();
        }
        this.zza = i;
    }

    public final void zzb(zzwg zzwg) {
        long j;
        if (zzwg != null) {
            Long l = zzwg.h;
            if (l == null) {
                j = 0;
            } else {
                j = l.longValue();
            }
            if (j <= 0) {
                j = 3600;
            }
            long longValue = zzwg.j.longValue();
            zzam zzam = this.zzb;
            zzam.zza = (j * 1000) + longValue;
            zzam.zzb = -1;
            if (zzg()) {
                this.zzb.zza();
            }
        }
    }

    public final void zzc() {
        this.zzb.zzc();
    }
}
