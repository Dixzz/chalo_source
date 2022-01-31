package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;

/* renamed from: t92  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class t92 implements Parcelable.Creator<zav> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zav createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 2) {
                iBinder = gj1.f0(parcel, readInt);
            } else if (c == 3) {
                connectionResult = (ConnectionResult) gj1.w(parcel, readInt, ConnectionResult.CREATOR);
            } else if (c == 4) {
                z = gj1.Z(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                z2 = gj1.Z(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zav(i, iBinder, connectionResult, z, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zav[] newArray(int i) {
        return new zav[i];
    }
}
