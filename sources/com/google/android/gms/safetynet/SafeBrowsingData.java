package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SafeBrowsingData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new wh4();
    public String f;
    public DataHolder g;
    public ParcelFileDescriptor h;
    public long i;
    public byte[] j;

    public SafeBrowsingData() {
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = null;
    }

    public SafeBrowsingData(String str, DataHolder dataHolder, ParcelFileDescriptor parcelFileDescriptor, long j2, byte[] bArr) {
        this.f = str;
        this.g = dataHolder;
        this.h = parcelFileDescriptor;
        this.i = j2;
        this.j = bArr;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        ParcelFileDescriptor parcelFileDescriptor = this.h;
        wh4.a(this, parcel, i2);
        this.h = null;
    }
}
