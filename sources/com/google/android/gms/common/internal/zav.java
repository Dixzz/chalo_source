package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.c82;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new t92();
    public final int f;
    public final IBinder g;
    public final ConnectionResult h;
    public final boolean i;
    public final boolean j;

    public zav(int i2, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f = i2;
        this.g = iBinder;
        this.h = connectionResult;
        this.i = z;
        this.j = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zav = (zav) obj;
        return this.h.equals(zav.h) && gj1.G(l1(), zav.l1());
    }

    public final c82 l1() {
        IBinder iBinder = this.g;
        if (iBinder == null) {
            return null;
        }
        return c82.a.F(iBinder);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        gj1.x0(parcel, 2, this.g, false);
        gj1.A0(parcel, 3, this.h, i2, false);
        boolean z = this.i;
        parcel.writeInt(262148);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.j;
        parcel.writeInt(262149);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.H1(parcel, o1);
    }
}
