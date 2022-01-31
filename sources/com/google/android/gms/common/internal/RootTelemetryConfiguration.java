package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new ba2();
    public final int f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;

    public RootTelemetryConfiguration(int i2, boolean z, boolean z2, int i3, int i4) {
        this.f = i2;
        this.g = z;
        this.h = z2;
        this.i = i3;
        this.j = i4;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        boolean z = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        int i4 = this.i;
        parcel.writeInt(262148);
        parcel.writeInt(i4);
        int i5 = this.j;
        parcel.writeInt(262149);
        parcel.writeInt(i5);
        gj1.H1(parcel, o1);
    }
}
