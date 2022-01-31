package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class zzl implements Parcelable.Creator<PolylineOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final PolylineOptions createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        ArrayList arrayList = null;
        Cap cap = null;
        Cap cap2 = null;
        ArrayList arrayList2 = null;
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    arrayList = gj1.B(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    f = gj1.d0(parcel, readInt);
                    break;
                case 4:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 5:
                    f2 = gj1.d0(parcel, readInt);
                    break;
                case 6:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 7:
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case '\b':
                    z3 = gj1.Z(parcel, readInt);
                    break;
                case '\t':
                    cap = (Cap) gj1.w(parcel, readInt, Cap.CREATOR);
                    break;
                case '\n':
                    cap2 = (Cap) gj1.w(parcel, readInt, Cap.CREATOR);
                    break;
                case 11:
                    i2 = gj1.g0(parcel, readInt);
                    break;
                case '\f':
                    arrayList2 = gj1.B(parcel, readInt, PatternItem.CREATOR);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new PolylineOptions(arrayList, f, i, f2, z, z2, z3, cap, cap2, i2, arrayList2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolylineOptions[] newArray(int i) {
        return new PolylineOptions[i];
    }
}
