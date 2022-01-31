package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;

/* renamed from: rb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class rb2 implements Parcelable.Creator<Feature> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Feature createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c == 2) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                j = gj1.h0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new Feature(str, i, j);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Feature[] newArray(int i) {
        return new Feature[i];
    }
}
