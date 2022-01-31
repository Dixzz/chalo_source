package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class UserProfileChangeRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzah();
    private String zza;
    private String zzb;
    private boolean zzc;
    private boolean zzd;
    private Uri zze;

    /* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
    public static class Builder {
        private String zza;
        private Uri zzb;
        private boolean zzc;
        private boolean zzd;

        public UserProfileChangeRequest build() {
            String str;
            String str2 = this.zza;
            Uri uri = this.zzb;
            if (uri == null) {
                str = null;
            } else {
                str = uri.toString();
            }
            return new UserProfileChangeRequest(str2, str, this.zzc, this.zzd);
        }

        public String getDisplayName() {
            return this.zza;
        }

        public Uri getPhotoUri() {
            return this.zzb;
        }

        public Builder setDisplayName(String str) {
            if (str == null) {
                this.zzc = true;
            } else {
                this.zza = str;
            }
            return this;
        }

        public Builder setPhotoUri(Uri uri) {
            if (uri == null) {
                this.zzd = true;
            } else {
                this.zzb = uri;
            }
            return this;
        }
    }

    public UserProfileChangeRequest(String str, String str2, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = z2;
        this.zze = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    public String getDisplayName() {
        return this.zza;
    }

    public Uri getPhotoUri() {
        return this.zze;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, getDisplayName(), false);
        gj1.B0(parcel, 3, this.zzb, false);
        boolean z = this.zzc;
        parcel.writeInt(262148);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzd;
        parcel.writeInt(262149);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.H1(parcel, o1);
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }
}
