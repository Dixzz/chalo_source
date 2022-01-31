package com.truecaller.android.sdk.clients;

import android.os.Parcel;
import android.os.Parcelable;

public class CustomDataBundle implements Parcelable {
    public static final Parcelable.Creator<CustomDataBundle> CREATOR = new a();
    public final int f;
    public final int g;
    public final String h;
    public final String i;
    public final int j;
    public final int k;
    public final int l;

    public static class a implements Parcelable.Creator<CustomDataBundle> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public CustomDataBundle createFromParcel(Parcel parcel) {
            return new CustomDataBundle(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public CustomDataBundle[] newArray(int i) {
            return new CustomDataBundle[i];
        }
    }

    public CustomDataBundle(int i2, int i3, String str, String str2, int i4, int i5, int i6) {
        this.f = i2;
        this.g = i3;
        this.h = str;
        this.i = str2;
        this.l = i4;
        this.j = i5;
        this.k = i6;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeInt(this.l);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
    }

    public CustomDataBundle(Parcel parcel, a aVar) {
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.l = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
    }
}
