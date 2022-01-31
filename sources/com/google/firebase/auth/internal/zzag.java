package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzag extends MultiFactorSession {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();
    private String zza;
    private String zzb;
    private List<PhoneMultiFactorInfo> zzc;

    private zzag() {
    }

    public static zzag zza(String str) {
        gj1.j(str);
        zzag zzag = new zzag();
        zzag.zza = str;
        return zzag;
    }

    public static zzag zzb(List<MultiFactorInfo> list, String str) {
        Objects.requireNonNull(list, "null reference");
        gj1.j(str);
        zzag zzag = new zzag();
        zzag.zzc = new ArrayList();
        for (MultiFactorInfo multiFactorInfo : list) {
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                zzag.zzc.add((PhoneMultiFactorInfo) multiFactorInfo);
            }
        }
        zzag.zzb = str;
        return zzag;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.zza, false);
        gj1.B0(parcel, 2, this.zzb, false);
        gj1.F0(parcel, 3, this.zzc, false);
        gj1.H1(parcel, o1);
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zza != null;
    }

    public zzag(String str, String str2, List<PhoneMultiFactorInfo> list) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list;
    }
}
