package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzaw extends BroadcastReceiver {
    public final /* synthetic */ zzax zza;
    private final WeakReference<Activity> zzb;
    private final zi4<String> zzc;

    public zzaw(zzax zzax, Activity activity, zi4<String> zi4) {
        this.zza = zzax;
        this.zzb = new WeakReference<>(activity);
        this.zzc = zi4;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.zzb.get() == null) {
            zi4<String> zi4 = this.zzc;
            zi4.f4178a.u(w43.a(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.zzd(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(stringExtra)) {
                zi4<String> zi42 = this.zzc;
                zi42.f4178a.t(intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
                zzax.zzd(context);
                return;
            }
            zi4<String> zi43 = this.zzc;
            StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 50);
            sb.append("WEB_CONTEXT_CANCELED:Unknown operation received (");
            sb.append(stringExtra);
            sb.append(")");
            zi43.f4178a.u(w43.a(zzai.zza(sb.toString())));
        } else if (zzbl.zzb(intent)) {
            Status zzc2 = zzbl.zzc(intent);
            zi4<String> zi44 = this.zzc;
            zi44.f4178a.u(w43.a(zzc2));
            zzax.zzd(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            zi4<String> zi45 = this.zzc;
            zi45.f4178a.u(w43.a(zzai.zza("WEB_CONTEXT_CANCELED")));
            zzax.zzd(context);
        }
    }
}
