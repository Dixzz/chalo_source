package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzbh;
import java.util.List;

public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new t34();
    public final List<zzbh> f;
    public final int g;
    public final String h;

    public GeofencingRequest(List<zzbh> list, int i, String str) {
        this.f = list;
        this.g = i;
        this.h = str;
    }

    public String toString() {
        StringBuilder k0 = hj1.k0("GeofencingRequest[", "geofences=");
        k0.append(this.f);
        int i = this.g;
        StringBuilder sb = new StringBuilder(30);
        sb.append(", initialTrigger=");
        sb.append(i);
        sb.append(", ");
        k0.append(sb.toString());
        String valueOf = String.valueOf(this.h);
        return hj1.a0(k0, valueOf.length() != 0 ? "tag=".concat(valueOf) : new String("tag="), "]");
    }

    public void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.F0(parcel, 1, this.f, false);
        int i2 = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        gj1.B0(parcel, 3, this.h, false);
        gj1.H1(parcel, o1);
    }
}
