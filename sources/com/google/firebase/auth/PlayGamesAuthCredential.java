package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class PlayGamesAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<PlayGamesAuthCredential> CREATOR = new zzaf();
    private final String zza;

    public PlayGamesAuthCredential(String str) {
        gj1.j(str);
        this.zza = str;
    }

    public static zzxg zzb(PlayGamesAuthCredential playGamesAuthCredential, String str) {
        Objects.requireNonNull(playGamesAuthCredential, "null reference");
        return new zzxg(null, null, playGamesAuthCredential.getProvider(), null, playGamesAuthCredential.zza, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "playgames.google.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "playgames.google.com";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.zza, false);
        gj1.H1(parcel, o1);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new PlayGamesAuthCredential(this.zza);
    }
}
