package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class TwitterAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<TwitterAuthCredential> CREATOR = new zzag();
    private String zza;
    private String zzb;

    public TwitterAuthCredential(String str, String str2) {
        gj1.j(str);
        this.zza = str;
        gj1.j(str2);
        this.zzb = str2;
    }

    public static zzxg zzb(TwitterAuthCredential twitterAuthCredential, String str) {
        Objects.requireNonNull(twitterAuthCredential, "null reference");
        return new zzxg(null, twitterAuthCredential.zza, twitterAuthCredential.getProvider(), twitterAuthCredential.zzb, null, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "twitter.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "twitter.com";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.zza, false);
        gj1.B0(parcel, 2, this.zzb, false);
        gj1.H1(parcel, o1);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new TwitterAuthCredential(this.zza, this.zzb);
    }
}
