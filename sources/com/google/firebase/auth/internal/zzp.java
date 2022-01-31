package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzp implements AdditionalUserInfo {
    public static final Parcelable.Creator<zzp> CREATOR = new zzq();
    private final String zza;
    private final String zzb;
    private final Map<String, Object> zzc;
    private final boolean zzd;

    public zzp(String str, String str2, boolean z) {
        gj1.j(str);
        gj1.j(str2);
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzaz.zzb(str2);
        this.zzd = z;
    }

    public zzp(boolean z) {
        this.zzd = z;
        this.zzb = null;
        this.zza = null;
        this.zzc = null;
    }

    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    @Nullable
    public final Map<String, Object> getProfile() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    @Nullable
    public final String getProviderId() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    @Nullable
    public final String getUsername() {
        if ("github.com".equals(this.zza)) {
            return (String) this.zzc.get("login");
        }
        if ("twitter.com".equals(this.zza)) {
            return (String) this.zzc.get(FirebaseAnalytics.Param.SCREEN_NAME);
        }
        return null;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    public final boolean isNewUser() {
        return this.zzd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.zza, false);
        gj1.B0(parcel, 2, this.zzb, false);
        boolean z = this.zzd;
        parcel.writeInt(262147);
        parcel.writeInt(z ? 1 : 0);
        gj1.H1(parcel, o1);
    }
}
