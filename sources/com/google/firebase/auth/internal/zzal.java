package com.google.firebase.auth.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzal implements Runnable {
    public final /* synthetic */ zzam zza;
    private final String zzb;

    public zzal(zzam zzam, String str) {
        this.zza = zzam;
        gj1.j(str);
        this.zzb = str;
    }

    public final void run() {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzb));
        if (instance.getCurrentUser() != null) {
            yi4<GetTokenResult> accessToken = instance.getAccessToken(true);
            zzam.zzd().c("Token refreshing started", new Object[0]);
            accessToken.d(new zzak(this));
        }
    }
}
