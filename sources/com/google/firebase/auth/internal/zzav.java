package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzav extends BroadcastReceiver {
    public final /* synthetic */ zzax zza;
    private final WeakReference<Activity> zzb;
    private final zi4<AuthResult> zzc;
    private final FirebaseAuth zzd;
    private final FirebaseUser zze;

    public zzav(zzax zzax, Activity activity, zi4<AuthResult> zi4, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zza = zzax;
        this.zzb = new WeakReference<>(activity);
        this.zzc = zi4;
        this.zzd = firebaseAuth;
        this.zze = firebaseUser;
    }

    public final void onReceive(Context context, Intent intent) {
        zzax zzax;
        zi4<AuthResult> zi4;
        zzax zzax2;
        zi4<AuthResult> zi42;
        zzax zzax3;
        zi4<AuthResult> zi43;
        if (this.zzb.get() == null) {
            zi4<AuthResult> zi44 = this.zzc;
            zi44.f4178a.u(w43.a(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.zzd(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
                this.zzd.signInWithCredential(zzax.zzi(intent)).f(new zzaq(zzax3, zi43, context)).d(new zzap(this.zza, this.zzc, context));
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
                this.zze.linkWithCredential(zzax.zzi(intent)).f(new zzas(zzax2, zi42, context)).d(new zzar(this.zza, this.zzc, context));
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
                this.zze.reauthenticateAndRetrieveData(zzax.zzi(intent)).f(new zzau(zzax, zi4, context)).d(new zzat(this.zza, this.zzc, context));
            } else {
                zi4<AuthResult> zi45 = this.zzc;
                StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 50);
                sb.append("WEB_CONTEXT_CANCELED:Unknown operation received (");
                sb.append(stringExtra);
                sb.append(")");
                zi45.f4178a.u(w43.a(zzai.zza(sb.toString())));
            }
        } else if (zzbl.zzb(intent)) {
            Status zzc2 = zzbl.zzc(intent);
            zi4<AuthResult> zi46 = this.zzc;
            zi46.f4178a.u(w43.a(zzc2));
            zzax.zzd(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            zi4<AuthResult> zi47 = this.zzc;
            zi47.f4178a.u(w43.a(zzai.zza("WEB_CONTEXT_CANCELED")));
            zzax.zzd(context);
        }
    }
}
