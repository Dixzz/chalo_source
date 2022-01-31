package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;

/* renamed from: ii4  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class ii4 implements Parcelable.Creator<zak> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zak createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        ConnectionResult connectionResult = null;
        zav zav = null;
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 2) {
                connectionResult = (ConnectionResult) gj1.w(parcel, readInt, ConnectionResult.CREATOR);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                zav = (zav) gj1.w(parcel, readInt, zav.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zak(i, connectionResult, zav);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zak[] newArray(int i) {
        return new zak[i];
    }
}
