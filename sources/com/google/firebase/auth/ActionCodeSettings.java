package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class ActionCodeSettings extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActionCodeSettings> CREATOR = new zzb();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final boolean zze;
    private final String zzf;
    private final boolean zzg;
    private String zzh;
    private int zzi;
    private String zzj;

    /* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
    public static class Builder {
        private String zza;
        private String zzb;
        private String zzc;
        private boolean zzd;
        private String zze;
        private boolean zzf = false;
        private String zzg;

        private Builder() {
        }

        public /* synthetic */ Builder(zza zza2) {
        }

        public ActionCodeSettings build() {
            if (this.zza != null) {
                return new ActionCodeSettings(this);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }

        public String getDynamicLinkDomain() {
            return this.zzg;
        }

        public boolean getHandleCodeInApp() {
            return this.zzf;
        }

        public String getIOSBundleId() {
            return this.zzb;
        }

        public String getUrl() {
            return this.zza;
        }

        public Builder setAndroidPackageName(String str, boolean z, String str2) {
            this.zzc = str;
            this.zzd = z;
            this.zze = str2;
            return this;
        }

        public Builder setDynamicLinkDomain(String str) {
            this.zzg = str;
            return this;
        }

        public Builder setHandleCodeInApp(boolean z) {
            this.zzf = z;
            return this;
        }

        public Builder setIOSBundleId(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setUrl(String str) {
            this.zza = str;
            return this;
        }
    }

    private ActionCodeSettings(Builder builder) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = null;
        this.zzd = builder.zzc;
        this.zze = builder.zzd;
        this.zzf = builder.zze;
        this.zzg = builder.zzf;
        this.zzj = builder.zzg;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public static ActionCodeSettings zza() {
        return new ActionCodeSettings(new Builder(null));
    }

    public boolean canHandleCodeInApp() {
        return this.zzg;
    }

    public boolean getAndroidInstallApp() {
        return this.zze;
    }

    public String getAndroidMinimumVersion() {
        return this.zzf;
    }

    public String getAndroidPackageName() {
        return this.zzd;
    }

    public String getIOSBundle() {
        return this.zzb;
    }

    public String getUrl() {
        return this.zza;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, getUrl(), false);
        gj1.B0(parcel, 2, getIOSBundle(), false);
        gj1.B0(parcel, 3, this.zzc, false);
        gj1.B0(parcel, 4, getAndroidPackageName(), false);
        boolean androidInstallApp = getAndroidInstallApp();
        parcel.writeInt(262149);
        parcel.writeInt(androidInstallApp ? 1 : 0);
        gj1.B0(parcel, 6, getAndroidMinimumVersion(), false);
        boolean canHandleCodeInApp = canHandleCodeInApp();
        parcel.writeInt(262151);
        parcel.writeInt(canHandleCodeInApp ? 1 : 0);
        gj1.B0(parcel, 8, this.zzh, false);
        int i2 = this.zzi;
        parcel.writeInt(262153);
        parcel.writeInt(i2);
        gj1.B0(parcel, 10, this.zzj, false);
        gj1.H1(parcel, o1);
    }

    public final String zzb() {
        return this.zzc;
    }

    public final void zzc(String str) {
        this.zzh = str;
    }

    public final String zzd() {
        return this.zzh;
    }

    public final void zze(int i) {
        this.zzi = i;
    }

    public final int zzf() {
        return this.zzi;
    }

    public final String zzg() {
        return this.zzj;
    }

    public ActionCodeSettings(String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, String str6, int i, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = z;
        this.zzf = str5;
        this.zzg = z2;
        this.zzh = str6;
        this.zzi = i;
        this.zzj = str7;
    }
}
