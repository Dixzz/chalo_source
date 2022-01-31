package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.firebase.FirebaseApp;
import java.util.Objects;

public final class zzam {
    private static final wa2 zzg = new wa2("TokenRefresher", "FirebaseAuth:");
    public volatile long zza;
    public volatile long zzb;
    public final long zzc = DefaultRefreshIntervals.RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL;
    public final HandlerThread zzd;
    public final Handler zze;
    public final Runnable zzf;
    private final FirebaseApp zzh;

    public zzam(FirebaseApp firebaseApp) {
        zzg.c("Initializing TokenRefresher", new Object[0]);
        Objects.requireNonNull(firebaseApp, "null reference");
        this.zzh = firebaseApp;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.zzd = handlerThread;
        handlerThread.start();
        this.zze = new iv2(handlerThread.getLooper());
        this.zzf = new zzal(this, firebaseApp.getName());
    }

    public final void zza() {
        wa2 wa2 = zzg;
        long j = this.zza;
        long j2 = this.zzc;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j - j2);
        wa2.c(sb.toString(), new Object[0]);
        zzc();
        this.zzb = Math.max((this.zza - System.currentTimeMillis()) - this.zzc, 0L) / 1000;
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }

    public final void zzb() {
        long j;
        int i = (int) this.zzb;
        if (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) {
            long j2 = this.zzb;
            j = j2 + j2;
        } else {
            j = i != 960 ? 30 : 960;
        }
        this.zzb = j;
        this.zza = (this.zzb * 1000) + System.currentTimeMillis();
        wa2 wa2 = zzg;
        long j3 = this.zza;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j3);
        wa2.c(sb.toString(), new Object[0]);
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }

    public final void zzc() {
        this.zze.removeCallbacks(this.zzf);
    }
}
