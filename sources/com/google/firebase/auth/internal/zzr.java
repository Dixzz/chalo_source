package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zze;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzr implements AuthResult {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    private zzx zza;
    private zzp zzb;
    private zze zzc;

    public zzr(zzx zzx) {
        Objects.requireNonNull(zzx, "null reference");
        this.zza = zzx;
        List<zzt> zzl = zzx.zzl();
        this.zzb = null;
        for (int i = 0; i < zzl.size(); i++) {
            if (!TextUtils.isEmpty(zzl.get(i).zza())) {
                this.zzb = new zzp(zzl.get(i).getProviderId(), zzl.get(i).zza(), zzx.zzo());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzp(zzx.zzo());
        }
        this.zzc = zzx.zzq();
    }

    public zzr(zzx zzx, zzp zzp, zze zze) {
        this.zza = zzx;
        this.zzb = zzp;
        this.zzc = zze;
    }

    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AuthCredential getCredential() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final FirebaseUser getUser() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.zza, i, false);
        gj1.A0(parcel, 2, this.zzb, i, false);
        gj1.A0(parcel, 3, this.zzc, i, false);
        gj1.H1(parcel, o1);
    }
}
