package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class GoogleAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GoogleAuthCredential> CREATOR = new zzaa();
    private final String zza;
    private final String zzb;

    public GoogleAuthCredential(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        zzc(str, "idToken");
        this.zza = str;
        zzc(str2, "accessToken");
        this.zzb = str2;
    }

    public static zzxg zzb(GoogleAuthCredential googleAuthCredential, String str) {
        Objects.requireNonNull(googleAuthCredential, "null reference");
        return new zzxg(googleAuthCredential.zza, googleAuthCredential.zzb, googleAuthCredential.getProvider(), null, null, str, null, null);
    }

    private static String zzc(String str, String str2) {
        if (str == null || !TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(str2.concat(" must not be empty"));
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "google.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "google.com";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.zza, false);
        gj1.B0(parcel, 2, this.zzb, false);
        gj1.H1(parcel, o1);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new GoogleAuthCredential(this.zza, this.zzb);
    }
}
