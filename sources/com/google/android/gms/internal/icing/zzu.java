package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new ul3();
    public final boolean f;

    public zzu(boolean z) {
        this.f = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzu) && this.f == ((zzu) obj).f;
    }

    public final int hashCode() {
        return this.f ? 1 : 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        boolean z = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        gj1.H1(parcel, o1);
    }
}
