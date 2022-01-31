package com.google.firebase.analytics.connector.internal;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final class zze implements zza {
    private AnalyticsConnector.AnalyticsConnectorListener zza;
    private a64 zzb;
    private zzg zzc;

    public zze(a64 a64, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zza = analyticsConnectorListener;
        this.zzb = a64;
        zzg zzg = new zzg(this);
        this.zzc = zzg;
        this.zzb.f127a.c(zzg);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zza;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zza(Set<String> set) {
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb() {
    }
}
