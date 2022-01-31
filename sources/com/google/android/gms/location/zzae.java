package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new m34();
    public final String f;
    public final String g;
    public final String h;

    public zzae(String str, String str2, String str3) {
        this.h = str;
        this.f = str2;
        this.g = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.B0(parcel, 2, this.g, false);
        gj1.B0(parcel, 5, this.h, false);
        gj1.H1(parcel, o1);
    }
}
