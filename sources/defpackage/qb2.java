package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: qb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class qb2 implements Parcelable.Creator<ConnectionResult> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ConnectionResult createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 2) {
                i2 = gj1.g0(parcel, readInt);
            } else if (c == 3) {
                pendingIntent = (PendingIntent) gj1.w(parcel, readInt, PendingIntent.CREATOR);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new ConnectionResult(i, i2, pendingIntent, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
