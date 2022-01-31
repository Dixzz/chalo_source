package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.internal.location.zzbd;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* renamed from: xm3  reason: default package */
public final class xm3 implements Parcelable.Creator<zzbd> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzbd createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        List<ClientIdentity> list = zzbd.m;
        LocationRequest locationRequest = null;
        String str = null;
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                switch (c) {
                    case 5:
                        list = gj1.B(parcel, readInt, ClientIdentity.CREATOR);
                        continue;
                    case 6:
                        str = gj1.x(parcel, readInt);
                        continue;
                    case 7:
                        z = gj1.Z(parcel, readInt);
                        continue;
                    case '\b':
                        z2 = gj1.Z(parcel, readInt);
                        continue;
                    case '\t':
                        z3 = gj1.Z(parcel, readInt);
                        continue;
                    case '\n':
                        str2 = gj1.x(parcel, readInt);
                        continue;
                    default:
                        gj1.p0(parcel, readInt);
                        continue;
                }
            } else {
                locationRequest = (LocationRequest) gj1.w(parcel, readInt, LocationRequest.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzbd(locationRequest, list, str, z, z2, z3, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbd[] newArray(int i) {
        return new zzbd[i];
    }
}
