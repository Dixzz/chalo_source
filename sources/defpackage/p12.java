package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cloudmessaging.CloudMessage;

/* renamed from: p12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class p12 implements Parcelable.Creator<CloudMessage> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final CloudMessage createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                intent = (Intent) gj1.w(parcel, readInt, Intent.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new CloudMessage(intent);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CloudMessage[] newArray(int i) {
        return new CloudMessage[i];
    }
}
