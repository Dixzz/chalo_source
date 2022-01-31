package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

public final class StreetViewSource extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new zzq();
    public static final StreetViewSource DEFAULT = new StreetViewSource(0);
    public static final StreetViewSource OUTDOOR = new StreetViewSource(1);
    private static final String TAG = StreetViewSource.class.getSimpleName();
    private final int type;

    public StreetViewSource(int i) {
        this.type = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.type == ((StreetViewSource) obj).type;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.type)});
    }

    public final String toString() {
        String str;
        int i = this.type;
        if (i == 0) {
            str = "DEFAULT";
        } else if (i != 1) {
            str = String.format("UNKNOWN(%s)", Integer.valueOf(i));
        } else {
            str = "OUTDOOR";
        }
        return String.format("StreetViewSource:%s", str);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.type;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        gj1.H1(parcel, o1);
    }
}
