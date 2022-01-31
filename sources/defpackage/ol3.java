package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzi;

/* renamed from: ol3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ol3 implements Parcelable.Creator<zzi> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzi createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c == 2) {
                str2 = gj1.x(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                str3 = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzi(str, str2, str3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi[] newArray(int i) {
        return new zzi[i];
    }
}
