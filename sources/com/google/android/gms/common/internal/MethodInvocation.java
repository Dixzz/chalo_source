package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class MethodInvocation extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new n92();
    public final int f;
    public final int g;
    public final int h;
    public final long i;
    public final long j;
    public final String k;
    public final String l;
    public final int m;

    public MethodInvocation(int i2, int i3, int i4, long j2, long j3, String str, String str2, int i5) {
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = j2;
        this.j = j3;
        this.k = str;
        this.l = str2;
        this.m = i5;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        int i4 = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(i4);
        int i5 = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(i5);
        long j2 = this.i;
        parcel.writeInt(524292);
        parcel.writeLong(j2);
        long j3 = this.j;
        parcel.writeInt(524293);
        parcel.writeLong(j3);
        gj1.B0(parcel, 6, this.k, false);
        gj1.B0(parcel, 7, this.l, false);
        int i6 = this.m;
        parcel.writeInt(262152);
        parcel.writeInt(i6);
        gj1.H1(parcel, o1);
    }
}
