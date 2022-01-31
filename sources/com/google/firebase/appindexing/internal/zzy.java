package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzx();
    private final int type;
    private final Thing[] zzfo;
    private final String[] zzfp;
    private final String[] zzfq;
    private final zza zzfr;
    private final String zzfs;
    private final String zzft;

    public zzy(int i, Thing[] thingArr, String[] strArr, String[] strArr2, zza zza, String str, String str2) {
        if (!(i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 7)) {
            i = 0;
        }
        this.type = i;
        this.zzfo = thingArr;
        this.zzfp = strArr;
        this.zzfq = strArr2;
        this.zzfr = zza;
        this.zzfs = str;
        this.zzft = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.type;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        gj1.E0(parcel, 2, this.zzfo, i, false);
        gj1.C0(parcel, 3, this.zzfp, false);
        gj1.C0(parcel, 5, this.zzfq, false);
        gj1.A0(parcel, 6, this.zzfr, i, false);
        gj1.B0(parcel, 7, this.zzfs, false);
        gj1.B0(parcel, 8, this.zzft, false);
        gj1.H1(parcel, o1);
    }

    public zzy(int i, Thing[] thingArr) {
        this(1, thingArr, null, null, null, null, null);
    }
}
