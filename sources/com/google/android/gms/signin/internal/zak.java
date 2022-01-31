package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new ii4();
    public final int f;
    public final ConnectionResult g;
    public final zav h;

    public zak(int i, ConnectionResult connectionResult, zav zav) {
        this.f = i;
        this.g = connectionResult;
        this.h = zav;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        gj1.A0(parcel, 2, this.g, i, false);
        gj1.A0(parcel, 3, this.h, i, false);
        gj1.H1(parcel, o1);
    }
}
