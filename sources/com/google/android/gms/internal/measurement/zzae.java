package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new po3();
    public final long f;
    public final long g;
    public final boolean h;
    public final String i;
    public final String j;
    public final String k;
    public final Bundle l;

    public zzae(long j2, long j3, boolean z, String str, String str2, String str3, Bundle bundle) {
        this.f = j2;
        this.g = j3;
        this.h = z;
        this.i = str;
        this.j = str2;
        this.k = str3;
        this.l = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        long j2 = this.f;
        parcel.writeInt(524289);
        parcel.writeLong(j2);
        long j3 = this.g;
        parcel.writeInt(524290);
        parcel.writeLong(j3);
        boolean z = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(z ? 1 : 0);
        gj1.B0(parcel, 4, this.i, false);
        gj1.B0(parcel, 5, this.j, false);
        gj1.B0(parcel, 6, this.k, false);
        gj1.t0(parcel, 7, this.l, false);
        gj1.H1(parcel, o1);
    }
}
