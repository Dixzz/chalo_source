package com.google.firebase.auth.internal;

import android.text.TextUtils;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzbf {
    private static final String zza = "zzbf";

    private zzbf() {
    }

    public static boolean zza(oh4 oh4) {
        zzbe zza2;
        if (oh4 == null || TextUtils.isEmpty(oh4.a()) || (zza2 = zzbe.zza(oh4.a())) == null || !zza2.zzb()) {
            return false;
        }
        if (TextUtils.isEmpty(zza2.zzc())) {
            return true;
        }
        String valueOf = String.valueOf(zza2.zzc());
        if (valueOf.length() != 0) {
            "SafetyNet Attestation has advice: \n".concat(valueOf);
        } else {
            new String("SafetyNet Attestation has advice: \n");
        }
        return false;
    }
}
