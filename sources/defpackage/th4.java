package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.zzd;

/* renamed from: th4  reason: default package */
public final class th4 implements Parcelable.Creator<zzd> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzd createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        long j = 0;
        HarmfulAppsData[] harmfulAppsDataArr = null;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                j = gj1.h0(parcel, readInt);
            } else if (c == 3) {
                harmfulAppsDataArr = (HarmfulAppsData[]) gj1.A(parcel, readInt, HarmfulAppsData.CREATOR);
            } else if (c == 4) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                z = gj1.Z(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzd(j, harmfulAppsDataArr, i, z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd[] newArray(int i) {
        return new zzd[i];
    }
}
