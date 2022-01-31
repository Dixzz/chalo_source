package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class RemoteMessageCreator implements Parcelable.Creator<RemoteMessage> {
    public static final int CONTENT_DESCRIPTION = 0;

    public static void writeToParcel(RemoteMessage remoteMessage, Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.t0(parcel, 2, remoteMessage.bundle, false);
        gj1.H1(parcel, o1);
    }

    @Override // android.os.Parcelable.Creator
    public RemoteMessage createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 2) {
                gj1.p0(parcel, readInt);
            } else {
                bundle = gj1.s(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new RemoteMessage(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public RemoteMessage[] newArray(int i) {
        return new RemoteMessage[i];
    }
}
