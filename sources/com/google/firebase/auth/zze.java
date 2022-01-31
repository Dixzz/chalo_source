package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zze extends OAuthCredential {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzxg zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    public zze(String str, String str2, String str3, zzxg zzxg, String str4, String str5, String str6) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzxg;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
    }

    public static zze zzb(String str, String str2, String str3, String str4, String str5) {
        gj1.i(str, "Must specify a non-empty providerId");
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return new zze(str, str2, str3, null, str4, str5, null);
        }
        throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
    }

    public static zze zzc(zzxg zzxg) {
        gj1.l(zzxg, "Must specify a non-null webSignInCredential");
        return new zze(null, null, null, zzxg, null, null, null);
    }

    public static zzxg zzd(zze zze2, String str) {
        Objects.requireNonNull(zze2, "null reference");
        zzxg zzxg = zze2.zzd;
        if (zzxg != null) {
            return zzxg;
        }
        return new zzxg(zze2.zzb, zze2.zzc, zze2.zza, zze2.zzf, null, str, zze2.zze, zze2.zzg);
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final String getAccessToken() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final String getIdToken() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String getProvider() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final String getSecret() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String getSignInMethod() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.zza, false);
        gj1.B0(parcel, 2, this.zzb, false);
        gj1.B0(parcel, 3, this.zzc, false);
        gj1.A0(parcel, 4, this.zzd, i, false);
        gj1.B0(parcel, 5, this.zze, false);
        gj1.B0(parcel, 6, this.zzf, false);
        gj1.B0(parcel, 7, this.zzg, false);
        gj1.H1(parcel, o1);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new zze(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }
}
