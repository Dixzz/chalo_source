package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class GithubAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GithubAuthCredential> CREATOR = new zzz();
    private String zza;

    public GithubAuthCredential(String str) {
        gj1.j(str);
        this.zza = str;
    }

    public static zzxg zzb(GithubAuthCredential githubAuthCredential, String str) {
        Objects.requireNonNull(githubAuthCredential, "null reference");
        return new zzxg(null, githubAuthCredential.zza, githubAuthCredential.getProvider(), null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "github.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "github.com";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.zza, false);
        gj1.H1(parcel, o1);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new GithubAuthCredential(this.zza);
    }
}
