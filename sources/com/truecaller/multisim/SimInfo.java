package com.truecaller.multisim;

import android.os.Parcel;
import android.os.Parcelable;

public class SimInfo implements Parcelable {
    public static final Parcelable.Creator<SimInfo> CREATOR = new a();
    public final int f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final boolean o;

    public static class a implements Parcelable.Creator<SimInfo> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public SimInfo createFromParcel(Parcel parcel) {
            return new SimInfo(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public SimInfo[] newArray(int i) {
            return new SimInfo[i];
        }
    }

    public SimInfo(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z) {
        this.f = i2;
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = str5;
        this.l = str6;
        this.m = str7;
        this.n = str8;
        this.o = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public SimInfo(Parcel parcel, a aVar) {
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readInt() != 1 ? false : true;
    }
}
