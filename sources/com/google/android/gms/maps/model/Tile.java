package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Tile extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Tile> CREATOR = new zzr();
    public final byte[] data;
    public final int height;
    public final int width;

    public Tile(int i, int i2, byte[] bArr) {
        this.width = i;
        this.height = i2;
        this.data = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.width;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        int i3 = this.height;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        gj1.u0(parcel, 4, this.data, false);
        gj1.H1(parcel, o1);
    }
}
