package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzbk implements Parcelable {
    @Deprecated
    public static final Parcelable.Creator<zzbk> CREATOR = new vc3();
    public String f;
    public String g;
    public String h;

    @Deprecated
    public zzbk() {
    }

    @Deprecated
    public final int describeContents() {
        return 0;
    }

    @Deprecated
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    @Deprecated
    public zzbk(Parcel parcel) {
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
    }
}
