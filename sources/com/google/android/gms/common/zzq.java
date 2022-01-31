package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new dc2();
    public final boolean f;
    @Nullable
    public final String g;
    public final int h;

    public zzq(boolean z, String str, int i) {
        this.f = z;
        this.g = str;
        this.h = gj1.k1(i) - 1;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        boolean z = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        gj1.B0(parcel, 2, this.g, false);
        int i2 = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        gj1.H1(parcel, o1);
    }
}
