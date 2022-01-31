package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new gn3();
    public int f;
    public zzm g;
    public u34 h;
    public em3 i;

    public zzo(int i2, zzm zzm, IBinder iBinder, IBinder iBinder2) {
        u34 u34;
        this.f = i2;
        this.g = zzm;
        em3 em3 = null;
        if (iBinder == null) {
            u34 = null;
        } else {
            int i3 = v34.f;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
            u34 = queryLocalInterface instanceof u34 ? (u34) queryLocalInterface : new w34(iBinder);
        }
        this.h = u34;
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            em3 = queryLocalInterface2 instanceof em3 ? (em3) queryLocalInterface2 : new gm3(iBinder2);
        }
        this.i = em3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        gj1.A0(parcel, 2, this.g, i2, false);
        u34 u34 = this.h;
        IBinder iBinder = null;
        gj1.x0(parcel, 3, u34 == null ? null : u34.asBinder(), false);
        em3 em3 = this.i;
        if (em3 != null) {
            iBinder = em3.asBinder();
        }
        gj1.x0(parcel, 4, iBinder, false);
        gj1.H1(parcel, o1);
    }
}
