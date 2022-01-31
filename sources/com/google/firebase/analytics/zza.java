package com.google.firebase.analytics;

import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final class zza implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zza;

    public zza(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final String call() throws Exception {
        oo3 oo3 = this.zza.zzb;
        Objects.requireNonNull(oo3);
        d24 d24 = new d24();
        oo3.c.execute(new op3(oo3, d24));
        return d24.L(120000);
    }
}
