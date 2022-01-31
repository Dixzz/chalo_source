package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzbh;
import com.google.android.gms.location.GeofencingRequest;
import java.util.ArrayList;

/* renamed from: t34  reason: default package */
public final class t34 implements Parcelable.Creator<GeofencingRequest> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GeofencingRequest createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        ArrayList arrayList = null;
        int i = 0;
        String str = "";
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                arrayList = gj1.B(parcel, readInt, zzbh.CREATOR);
            } else if (c == 2) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new GeofencingRequest(arrayList, i, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GeofencingRequest[] newArray(int i) {
        return new GeofencingRequest[i];
    }
}
