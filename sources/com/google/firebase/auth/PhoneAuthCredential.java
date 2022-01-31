package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzac();
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private boolean zze;
    private String zzf;
    private String zzg;

    public PhoneAuthCredential(String str, String str2, boolean z, String str3, boolean z2, String str4, String str5) {
        boolean z3 = false;
        if ((z && !TextUtils.isEmpty(str3) && TextUtils.isEmpty(str5)) || ((z && TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str5)) || ((!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4))))) {
            z3 = true;
        }
        gj1.c(z3, "Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, temporary proof, or enrollment ID.");
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = str3;
        this.zze = z2;
        this.zzf = str4;
        this.zzg = str5;
    }

    public static PhoneAuthCredential zzb(String str, String str2) {
        return new PhoneAuthCredential(str, str2, false, null, true, null, null);
    }

    public static PhoneAuthCredential zzc(String str, String str2) {
        return new PhoneAuthCredential(null, null, false, str, true, str2, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "phone";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "phone";
    }

    public String getSmsCode() {
        return this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.zza, false);
        gj1.B0(parcel, 2, getSmsCode(), false);
        boolean z = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(z ? 1 : 0);
        gj1.B0(parcel, 4, this.zzd, false);
        boolean z2 = this.zze;
        parcel.writeInt(262149);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.B0(parcel, 6, this.zzf, false);
        gj1.B0(parcel, 7, this.zzg, false);
        gj1.H1(parcel, o1);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return clone();
    }

    public final String zzd() {
        return this.zza;
    }

    public final String zze() {
        return this.zzd;
    }

    public final PhoneAuthCredential zzf(boolean z) {
        this.zze = false;
        return this;
    }

    public final boolean zzg() {
        return this.zze;
    }

    public final String zzh() {
        return this.zzf;
    }

    /* renamed from: zzi */
    public final PhoneAuthCredential clone() {
        return new PhoneAuthCredential(this.zza, getSmsCode(), this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }
}
