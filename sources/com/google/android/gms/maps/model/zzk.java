package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class zzk implements Parcelable.Creator<PolygonOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final PolygonOptions createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    arrayList2 = gj1.B(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    ClassLoader classLoader = zzk.class.getClassLoader();
                    int j0 = gj1.j0(parcel, readInt);
                    int dataPosition = parcel.dataPosition();
                    if (j0 != 0) {
                        parcel.readList(arrayList, classLoader);
                        parcel.setDataPosition(dataPosition + j0);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    f = gj1.d0(parcel, readInt);
                    break;
                case 5:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 6:
                    i2 = gj1.g0(parcel, readInt);
                    break;
                case 7:
                    f2 = gj1.d0(parcel, readInt);
                    break;
                case '\b':
                    z = gj1.Z(parcel, readInt);
                    break;
                case '\t':
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case '\n':
                    z3 = gj1.Z(parcel, readInt);
                    break;
                case 11:
                    i3 = gj1.g0(parcel, readInt);
                    break;
                case '\f':
                    arrayList3 = gj1.B(parcel, readInt, PatternItem.CREATOR);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new PolygonOptions(arrayList2, arrayList, f, i, i2, f2, z, z2, z3, i3, arrayList3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolygonOptions[] newArray(int i) {
        return new PolygonOptions[i];
    }
}
