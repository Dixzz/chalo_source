package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationResult> CREATOR = new k34();
    public static final List<Location> g = Collections.emptyList();
    public final List<Location> f;

    public LocationResult(List<Location> list) {
        this.f = list;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f.size() != this.f.size()) {
            return false;
        }
        Iterator<Location> it = this.f.iterator();
        for (Location location : locationResult.f) {
            if (it.next().getTime() != location.getTime()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 17;
        for (Location location : this.f) {
            long time = location.getTime();
            i = (i * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f);
        return hj1.y(valueOf.length() + 27, "LocationResult[locations: ", valueOf, "]");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.F0(parcel, 1, this.f, false);
        gj1.H1(parcel, o1);
    }
}
