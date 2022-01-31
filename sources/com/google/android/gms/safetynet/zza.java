package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new rh4();
    public final String f;

    public zza(String str) {
        this.f = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.H1(parcel, o1);
    }
}
