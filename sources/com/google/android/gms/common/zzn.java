package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.ic2;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new cc2();
    public final String f;
    public final boolean g;
    public final boolean h;
    public final Context i;
    public final boolean j;

    public zzn(String str, boolean z, boolean z2, IBinder iBinder, boolean z3) {
        this.f = str;
        this.g = z;
        this.h = z2;
        this.i = (Context) kc2.L(ic2.a.F(iBinder));
        this.j = z3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        boolean z = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.x0(parcel, 4, new kc2(this.i), false);
        boolean z3 = this.j;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        gj1.H1(parcel, o1);
    }
}
