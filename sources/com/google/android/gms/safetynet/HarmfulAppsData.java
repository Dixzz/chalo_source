package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class HarmfulAppsData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<HarmfulAppsData> CREATOR = new sh4();
    public final String f;
    public final byte[] g;
    public final int h;

    public HarmfulAppsData(String str, byte[] bArr, int i) {
        this.f = str;
        this.g = bArr;
        this.h = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.u0(parcel, 3, this.g, false);
        int i2 = this.h;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        gj1.H1(parcel, o1);
    }
}
