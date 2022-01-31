package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final class zzg implements ad4 {
    private final /* synthetic */ zze zza;

    public zzg(zze zze) {
        this.zza = zze;
    }

    @Override // defpackage.ad4
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (str != null && !str.equals("crash") && zzd.zzb(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", str2);
            bundle2.putLong("timestampInMillis", j);
            bundle2.putBundle(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, bundle);
            this.zza.zza.onMessageTriggered(3, bundle2);
        }
    }
}
