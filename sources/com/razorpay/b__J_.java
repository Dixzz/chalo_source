package com.razorpay;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ApplicationDetails */
public final class b__J_ implements Parcelable.Creator<ApplicationDetails> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ApplicationDetails createFromParcel(Parcel parcel) {
        return new ApplicationDetails(parcel);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ApplicationDetails[] newArray(int i) {
        return new ApplicationDetails[i];
    }
}
