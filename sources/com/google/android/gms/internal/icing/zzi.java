package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new ol3();
    public final String f;
    public final String g;
    public final String h;

    public zzi(String str, String str2, String str3) {
        this.f = str;
        this.g = str2;
        this.h = str3;
    }

    public final String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", this.f, this.g, this.h);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.B0(parcel, 2, this.g, false);
        gj1.B0(parcel, 3, this.h, false);
        gj1.H1(parcel, o1);
    }
}
