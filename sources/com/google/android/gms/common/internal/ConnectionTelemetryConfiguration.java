package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new ka2();
    public final RootTelemetryConfiguration f;
    public final boolean g;
    public final boolean h;
    public final int[] i;
    public final int j;
    public final int[] k;

    public ConnectionTelemetryConfiguration(@RecentlyNonNull RootTelemetryConfiguration rootTelemetryConfiguration, boolean z, boolean z2, int[] iArr, int i2, int[] iArr2) {
        this.f = rootTelemetryConfiguration;
        this.g = z;
        this.h = z2;
        this.i = iArr;
        this.j = i2;
        this.k = iArr2;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i2, false);
        boolean z = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.y0(parcel, 4, this.i, false);
        int i3 = this.j;
        parcel.writeInt(262149);
        parcel.writeInt(i3);
        gj1.y0(parcel, 6, this.k, false);
        gj1.H1(parcel, o1);
    }
}
