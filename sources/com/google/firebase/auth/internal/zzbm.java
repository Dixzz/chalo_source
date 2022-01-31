package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzbm {
    private static final zzbm zzc = new zzbm();
    private final zzbd zza;
    private final zzax zzb;

    private zzbm() {
        zzbd zza2 = zzbd.zza();
        zzax zza3 = zzax.zza();
        this.zza = zza2;
        this.zzb = zza3;
    }

    public static zzbm zza() {
        return zzc;
    }

    public final void zzb(Context context, FirebaseAuth firebaseAuth) {
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(firebaseAuth, "null reference");
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.zze().getName());
        edit.commit();
    }

    public final void zzc(Context context, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(firebaseAuth, "null reference");
        Objects.requireNonNull(firebaseUser, "null reference");
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.zze().getName());
        edit.putString("firebaseUserUid", firebaseUser.getUid());
        edit.commit();
    }

    public final yi4<AuthResult> zzd() {
        return this.zza.zzc();
    }

    public final yi4<String> zze() {
        return this.zza.zzd();
    }

    public final void zzf(FirebaseAuth firebaseAuth) {
        this.zza.zzb(firebaseAuth);
    }

    public final void zzg(Context context, Status status) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.g);
        edit.putString("statusMessage", status.h);
        edit.putLong("timestamp", System.currentTimeMillis());
        edit.commit();
    }

    public final void zzh(Context context) {
        this.zza.zze(context);
    }

    public final boolean zzi(Activity activity, zi4<AuthResult> zi4, FirebaseAuth firebaseAuth) {
        return this.zzb.zzc(activity, zi4, firebaseAuth, null);
    }

    public final boolean zzj(Activity activity, zi4<AuthResult> zi4, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        return this.zzb.zzc(activity, zi4, firebaseAuth, firebaseUser);
    }
}
