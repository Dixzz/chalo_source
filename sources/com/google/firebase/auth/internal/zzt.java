package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwm;
import com.google.firebase.auth.UserInfo;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzt extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private String zzd;
    private Uri zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;
    private final String zzi;

    public zzt(zzvz zzvz, String str) {
        Objects.requireNonNull(zzvz, "null reference");
        gj1.j("firebase");
        String str2 = zzvz.f;
        gj1.j(str2);
        this.zza = str2;
        this.zzb = "firebase";
        this.zzf = zzvz.g;
        this.zzc = zzvz.i;
        Uri parse = !TextUtils.isEmpty(zzvz.j) ? Uri.parse(zzvz.j) : null;
        if (parse != null) {
            this.zzd = parse.toString();
            this.zze = parse;
        }
        this.zzh = zzvz.h;
        this.zzi = null;
        this.zzg = zzvz.m;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getDisplayName() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getEmail() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getPhoneNumber() {
        return this.zzg;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            this.zze = Uri.parse(this.zzd);
        }
        return this.zze;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getProviderId() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getUid() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.zzh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.zza, false);
        gj1.B0(parcel, 2, this.zzb, false);
        gj1.B0(parcel, 3, this.zzc, false);
        gj1.B0(parcel, 4, this.zzd, false);
        gj1.B0(parcel, 5, this.zzf, false);
        gj1.B0(parcel, 6, this.zzg, false);
        boolean z = this.zzh;
        parcel.writeInt(262151);
        parcel.writeInt(z ? 1 : 0);
        gj1.B0(parcel, 8, this.zzi, false);
        gj1.H1(parcel, o1);
    }

    public final String zza() {
        return this.zzi;
    }

    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zza);
            jSONObject.putOpt("providerId", this.zzb);
            jSONObject.putOpt(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, this.zzc);
            jSONObject.putOpt("photoUrl", this.zzd);
            jSONObject.putOpt("email", this.zzf);
            jSONObject.putOpt("phoneNumber", this.zzg);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
            jSONObject.putOpt("rawUserInfo", this.zzi);
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new xx2(e);
        }
    }

    public zzt(zzwm zzwm) {
        Objects.requireNonNull(zzwm, "null reference");
        this.zza = zzwm.f;
        String str = zzwm.i;
        gj1.j(str);
        this.zzb = str;
        this.zzc = zzwm.g;
        Uri parse = !TextUtils.isEmpty(zzwm.h) ? Uri.parse(zzwm.h) : null;
        if (parse != null) {
            this.zzd = parse.toString();
            this.zze = parse;
        }
        this.zzf = zzwm.l;
        this.zzg = zzwm.k;
        this.zzh = false;
        this.zzi = zzwm.j;
    }

    public zzt(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzc = str5;
        this.zzd = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z;
        this.zzi = str7;
    }
}
