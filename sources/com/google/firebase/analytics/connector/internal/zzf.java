package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.razorpay.AnalyticsConstants;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final class zzf implements ad4 {
    private final /* synthetic */ zzc zza;

    public zzf(zzc zzc) {
        this.zza = zzc;
    }

    @Override // defpackage.ad4
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (this.zza.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(AnalyticsConstants.EVENTS, zzd.zze(str2));
            this.zza.zzb.onMessageTriggered(2, bundle2);
        }
    }
}
