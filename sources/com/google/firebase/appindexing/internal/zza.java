package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.appindexing.Action;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zza extends AbstractSafeParcelable implements Action {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    private final String zzar;
    private final Bundle zzay;
    private final String zzeg;
    private final String zzeh;
    private final String zzei;
    private final zzc zzej;
    private final String zzek;

    public zza(String str, String str2, String str3, String str4, zzc zzc, String str5, Bundle bundle) {
        this.zzar = str;
        this.zzeg = str2;
        this.zzeh = str3;
        this.zzei = str4;
        this.zzej = zzc;
        this.zzek = str5;
        if (bundle != null) {
            this.zzay = bundle;
        } else {
            this.zzay = Bundle.EMPTY;
        }
        this.zzay.setClassLoader(zza.class.getClassLoader());
    }

    public final String toString() {
        StringBuilder k0 = hj1.k0("ActionImpl { ", "{ actionType: '");
        k0.append(this.zzar);
        k0.append("' } ");
        k0.append("{ objectName: '");
        k0.append(this.zzeg);
        k0.append("' } ");
        k0.append("{ objectUrl: '");
        k0.append(this.zzeh);
        k0.append("' } ");
        if (this.zzei != null) {
            k0.append("{ objectSameAs: '");
            k0.append(this.zzei);
            k0.append("' } ");
        }
        if (this.zzej != null) {
            k0.append("{ metadata: '");
            k0.append(this.zzej.toString());
            k0.append("' } ");
        }
        if (this.zzek != null) {
            k0.append("{ actionStatus: '");
            k0.append(this.zzek);
            k0.append("' } ");
        }
        if (!this.zzay.isEmpty()) {
            k0.append("{ ");
            k0.append(this.zzay);
            k0.append(" } ");
        }
        k0.append("}");
        return k0.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.zzar, false);
        gj1.B0(parcel, 2, this.zzeg, false);
        gj1.B0(parcel, 3, this.zzeh, false);
        gj1.B0(parcel, 4, this.zzei, false);
        gj1.A0(parcel, 5, this.zzej, i, false);
        gj1.B0(parcel, 6, this.zzek, false);
        gj1.t0(parcel, 7, this.zzay, false);
        gj1.H1(parcel, o1);
    }

    public final zzc zzab() {
        return this.zzej;
    }
}
