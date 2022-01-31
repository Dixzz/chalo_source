package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new ja2();
    public Bundle f;
    public Feature[] g;
    public int h;
    public ConnectionTelemetryConfiguration i;

    public zzi() {
    }

    public zzi(Bundle bundle, Feature[] featureArr, int i2, ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f = bundle;
        this.g = featureArr;
        this.h = i2;
        this.i = connectionTelemetryConfiguration;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.t0(parcel, 1, this.f, false);
        gj1.E0(parcel, 2, this.g, i2, false);
        int i3 = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        gj1.A0(parcel, 4, this.i, i2, false);
        gj1.H1(parcel, o1);
    }
}
