package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class EmailAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzg();
    private String zza;
    private String zzb;
    private final String zzc;
    private String zzd;
    private boolean zze;

    public EmailAuthCredential(String str, String str2, String str3, String str4, boolean z) {
        gj1.j(str);
        this.zza = str;
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = z;
            return;
        }
        throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
    }

    public static boolean zzi(String str) {
        ActionCodeUrl parseLink;
        if (!TextUtils.isEmpty(str) && (parseLink = ActionCodeUrl.parseLink(str)) != null && parseLink.getOperation() == 4) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "password";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return !TextUtils.isEmpty(this.zzb) ? "password" : EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.zza, false);
        gj1.B0(parcel, 2, this.zzb, false);
        gj1.B0(parcel, 3, this.zzc, false);
        gj1.B0(parcel, 4, this.zzd, false);
        boolean z = this.zze;
        parcel.writeInt(262149);
        parcel.writeInt(z ? 1 : 0);
        gj1.H1(parcel, o1);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new EmailAuthCredential(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzd;
    }

    public final boolean zzf() {
        return this.zze;
    }

    public final EmailAuthCredential zzg(FirebaseUser firebaseUser) {
        this.zzd = firebaseUser.zzg();
        this.zze = true;
        return this;
    }

    public final boolean zzh() {
        return !TextUtils.isEmpty(this.zzc);
    }
}
