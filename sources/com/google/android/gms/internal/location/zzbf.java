package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzbf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbf> CREATOR = new ym3();
    public int f;
    public zzbd g;
    public a44 h;
    public PendingIntent i;
    public x34 j;
    public em3 k;

    public zzbf(int i2, zzbd zzbd, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        a44 a44;
        x34 x34;
        this.f = i2;
        this.g = zzbd;
        em3 em3 = null;
        if (iBinder == null) {
            a44 = null;
        } else {
            int i3 = b44.f;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            a44 = queryLocalInterface instanceof a44 ? (a44) queryLocalInterface : new c44(iBinder);
        }
        this.h = a44;
        this.i = pendingIntent;
        if (iBinder2 == null) {
            x34 = null;
        } else {
            int i4 = y34.f;
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
            x34 = queryLocalInterface2 instanceof x34 ? (x34) queryLocalInterface2 : new z34(iBinder2);
        }
        this.j = x34;
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            em3 = queryLocalInterface3 instanceof em3 ? (em3) queryLocalInterface3 : new gm3(iBinder3);
        }
        this.k = em3;
    }

    public static zzbf l1(a44 a44, em3 em3) {
        return new zzbf(2, null, (tm3) a44, null, null, em3 != null ? em3.asBinder() : null);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        gj1.A0(parcel, 2, this.g, i2, false);
        a44 a44 = this.h;
        IBinder iBinder = null;
        gj1.x0(parcel, 3, a44 == null ? null : a44.asBinder(), false);
        gj1.A0(parcel, 4, this.i, i2, false);
        x34 x34 = this.j;
        gj1.x0(parcel, 5, x34 == null ? null : x34.asBinder(), false);
        em3 em3 = this.k;
        if (em3 != null) {
            iBinder = em3.asBinder();
        }
        gj1.x0(parcel, 6, iBinder, false);
        gj1.H1(parcel, o1);
    }
}
