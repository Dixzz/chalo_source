package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* renamed from: n72  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class n72 implements Parcelable.Creator<Status> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Status createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i2 = gj1.g0(parcel, readInt);
            } else if (c == 2) {
                str = gj1.x(parcel, readInt);
            } else if (c == 3) {
                pendingIntent = (PendingIntent) gj1.w(parcel, readInt, PendingIntent.CREATOR);
            } else if (c == 4) {
                connectionResult = (ConnectionResult) gj1.w(parcel, readInt, ConnectionResult.CREATOR);
            } else if (c != 1000) {
                gj1.p0(parcel, readInt);
            } else {
                i = gj1.g0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new Status(i, i2, str, pendingIntent, connectionResult);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }
}
