package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.safetynet.HarmfulAppsData;

/* renamed from: sh4  reason: default package */
public final class sh4 implements Parcelable.Creator<HarmfulAppsData> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final HarmfulAppsData createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        byte[] bArr = null;
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                str = gj1.x(parcel, readInt);
            } else if (c == 3) {
                bArr = gj1.t(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                i = gj1.g0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new HarmfulAppsData(str, bArr, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HarmfulAppsData[] newArray(int i) {
        return new HarmfulAppsData[i];
    }
}
