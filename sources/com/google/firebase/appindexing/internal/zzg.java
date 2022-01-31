package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzf();
    private static final zzg zzew = new zzg(1);
    private static final zzg zzex = new zzg(2);
    private static final zzg zzey = new zzg(3);
    public final int status;

    public zzg(int i) {
        this.status = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.status;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        gj1.H1(parcel, o1);
    }
}
