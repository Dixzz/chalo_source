package com.google.firebase.analytics;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import defpackage.oo3;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final class zzd implements ce4 {
    private final /* synthetic */ oo3 zza;

    public zzd(oo3 oo3) {
        this.zza = oo3;
    }

    @Override // defpackage.ce4
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.e(str, str2, bundle, true, true, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r0.h == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.h.unregisterOnMeasurementEventListener(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(defpackage.ad4 r6) {
        /*
            r5 = this;
            oo3 r0 = r5.zza
            java.util.Objects.requireNonNull(r0)
            java.lang.String r1 = "null reference"
            java.util.Objects.requireNonNull(r6, r1)
            java.util.List<android.util.Pair<ad4, oo3$d>> r1 = r0.e
            monitor-enter(r1)
            r2 = 0
            r3 = 0
        L_0x000f:
            java.util.List<android.util.Pair<ad4, oo3$d>> r4 = r0.e     // Catch:{ all -> 0x0057 }
            int r4 = r4.size()     // Catch:{ all -> 0x0057 }
            if (r3 >= r4) goto L_0x0034
            java.util.List<android.util.Pair<ad4, oo3$d>> r4 = r0.e     // Catch:{ all -> 0x0057 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x0057 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0057 }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x0057 }
            boolean r4 = r6.equals(r4)     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x0031
            java.util.List<android.util.Pair<ad4, oo3$d>> r6 = r0.e     // Catch:{ all -> 0x0057 }
            java.lang.Object r6 = r6.get(r3)     // Catch:{ all -> 0x0057 }
            r2 = r6
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0057 }
            goto L_0x0034
        L_0x0031:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0034:
            if (r2 != 0) goto L_0x0038
            monitor-exit(r1)     // Catch:{ all -> 0x0057 }
            goto L_0x0056
        L_0x0038:
            java.util.List<android.util.Pair<ad4, oo3$d>> r6 = r0.e     // Catch:{ all -> 0x0057 }
            r6.remove(r2)     // Catch:{ all -> 0x0057 }
            java.lang.Object r6 = r2.second     // Catch:{ all -> 0x0057 }
            oo3$d r6 = (defpackage.oo3.d) r6     // Catch:{ all -> 0x0057 }
            monitor-exit(r1)     // Catch:{ all -> 0x0057 }
            f24 r1 = r0.h
            if (r1 == 0) goto L_0x004c
            f24 r1 = r0.h     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004c }
            r1.unregisterOnMeasurementEventListener(r6)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004c }
            goto L_0x0056
        L_0x004c:
            rp3 r1 = new rp3
            r1.<init>(r0, r6)
            java.util.concurrent.ExecutorService r6 = r0.c
            r6.execute(r1)
        L_0x0056:
            return
        L_0x0057:
            r6 = move-exception
            monitor-exit(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.analytics.zzd.zzb(ad4):void");
    }

    @Override // defpackage.ce4
    public final String zzc() {
        oo3 oo3 = this.zza;
        Objects.requireNonNull(oo3);
        d24 d24 = new d24();
        oo3.c.execute(new dp3(oo3, d24));
        return d24.L(50);
    }

    @Override // defpackage.ce4
    public final String zzd() {
        oo3 oo3 = this.zza;
        Objects.requireNonNull(oo3);
        d24 d24 = new d24();
        oo3.c.execute(new ep3(oo3, d24));
        return d24.L(500);
    }

    @Override // defpackage.ce4
    public final long zze() {
        oo3 oo3 = this.zza;
        Objects.requireNonNull(oo3);
        d24 d24 = new d24();
        oo3.c.execute(new gp3(oo3, d24));
        Long l = (Long) d24.F(d24.C1(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nanoTime = System.nanoTime();
        Objects.requireNonNull((db2) oo3.b);
        long nextLong = new Random(nanoTime ^ System.currentTimeMillis()).nextLong();
        int i = oo3.f + 1;
        oo3.f = i;
        return nextLong + ((long) i);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        this.zza.e(str, str2, bundle, true, false, Long.valueOf(j));
    }

    @Override // defpackage.ce4
    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return this.zza.b(str, str2, z);
    }

    public final void zza(xc4 xc4) {
        oo3 oo3 = this.zza;
        Objects.requireNonNull(oo3);
        oo3.a aVar = new oo3.a(xc4);
        if (oo3.h != null) {
            try {
                oo3.h.setEventInterceptor(aVar);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
            }
        }
        oo3.c.execute(new mp3(oo3, aVar));
    }

    @Override // defpackage.ce4
    public final int zzc(String str) {
        return this.zza.j(str);
    }

    public final void zza(ad4 ad4) {
        this.zza.c(ad4);
    }

    @Override // defpackage.ce4
    public final String zza() {
        oo3 oo3 = this.zza;
        Objects.requireNonNull(oo3);
        d24 d24 = new d24();
        oo3.c.execute(new fp3(oo3, d24));
        return d24.L(500);
    }

    @Override // defpackage.ce4
    public final String zzb() {
        oo3 oo3 = this.zza;
        Objects.requireNonNull(oo3);
        d24 d24 = new d24();
        oo3.c.execute(new jp3(oo3, d24));
        return d24.L(500);
    }

    @Override // defpackage.ce4
    public final void zza(String str) {
        oo3 oo3 = this.zza;
        Objects.requireNonNull(oo3);
        oo3.c.execute(new cp3(oo3, str));
    }

    @Override // defpackage.ce4
    public final void zzb(String str) {
        oo3 oo3 = this.zza;
        Objects.requireNonNull(oo3);
        oo3.c.execute(new bp3(oo3, str));
    }

    @Override // defpackage.ce4
    public final void zza(Bundle bundle) {
        oo3 oo3 = this.zza;
        Objects.requireNonNull(oo3);
        oo3.c.execute(new qo3(oo3, bundle));
    }

    @Override // defpackage.ce4
    public final void zzb(String str, String str2, Bundle bundle) {
        oo3 oo3 = this.zza;
        Objects.requireNonNull(oo3);
        oo3.c.execute(new to3(oo3, str, str2, bundle));
    }

    @Override // defpackage.ce4
    public final List<Bundle> zza(String str, String str2) {
        return this.zza.g(str, str2);
    }

    public final Object zza(int i) {
        oo3 oo3 = this.zza;
        Objects.requireNonNull(oo3);
        d24 d24 = new d24();
        oo3.c.execute(new np3(oo3, d24, i));
        return d24.F(d24.C1(DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD), Object.class);
    }
}
