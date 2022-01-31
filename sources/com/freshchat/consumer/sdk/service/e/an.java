package com.freshchat.consumer.sdk.service.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.freshchat.consumer.sdk.service.Status;

public class an extends ag {
    public static final Parcelable.Creator<an> CREATOR = new ao();
    private boolean success;

    public an() {
    }

    public an(Parcel parcel) {
        super(parcel);
    }

    @Override // com.freshchat.consumer.sdk.service.e.ag
    public int describeContents() {
        return 0;
    }

    @Override // com.freshchat.consumer.sdk.service.e.ag
    public Status getStatus() {
        return this.success ? Status.SUCCESS : Status.ERROR;
    }

    @Override // com.freshchat.consumer.sdk.service.e.ag
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
