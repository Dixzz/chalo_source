package com.google.firebase.analytics.connector.internal;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final class zzc implements zza {
    public Set<String> zza = new HashSet();
    private AnalyticsConnector.AnalyticsConnectorListener zzb;
    private a64 zzc;
    private zzf zzd;

    public zzc(a64 a64, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = a64;
        zzf zzf = new zzf(this);
        this.zzd = zzf;
        this.zzc.f127a.c(zzf);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb() {
        this.zza.clear();
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zza(Set<String> set) {
        this.zza.clear();
        Set<String> set2 = this.zza;
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzd.zzd(str) && zzd.zzc(str)) {
                hashSet.add(zzd.zzf(str));
            }
        }
        set2.addAll(hashSet);
    }
}
