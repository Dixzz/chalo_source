package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zze;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzax {
    private static zzax zzc;
    private boolean zza = false;
    private BroadcastReceiver zzb;

    private zzax() {
    }

    public static zzax zza() {
        if (zzc == null) {
            zzc = new zzax();
        }
        return zzc;
    }

    public static void zzd(Context context) {
        zzax zzax = zzc;
        zzax.zza = false;
        if (zzax.zzb != null) {
            ni.a(context).d(zzc.zzb);
        }
        zzc.zzb = null;
    }

    private final void zzh(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.zzb = broadcastReceiver;
        ni.a(activity).b(broadcastReceiver, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }

    private static final AuthCredential zzi(Intent intent) {
        SafeParcelable safeParcelable;
        Objects.requireNonNull(intent, "null reference");
        Parcelable.Creator<zzxg> creator = zzxg.CREATOR;
        byte[] byteArrayExtra = intent.getByteArrayExtra("com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
        if (byteArrayExtra == null) {
            safeParcelable = null;
        } else {
            safeParcelable = gj1.D(byteArrayExtra, creator);
        }
        zzxg zzxg = (zzxg) safeParcelable;
        zzxg.n = true;
        return zze.zzc(zzxg);
    }

    public final boolean zzb(Activity activity, zi4<String> zi4) {
        if (this.zza) {
            return false;
        }
        zzh(activity, new zzaw(this, activity, zi4));
        this.zza = true;
        return true;
    }

    public final boolean zzc(Activity activity, zi4<AuthResult> zi4, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (this.zza) {
            return false;
        }
        zzh(activity, new zzav(this, activity, zi4, firebaseAuth, firebaseUser));
        this.zza = true;
        return true;
    }
}
