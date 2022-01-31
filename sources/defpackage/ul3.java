package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzu;

/* renamed from: ul3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ul3 implements Parcelable.Creator<zzu> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzu createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        boolean z = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                z = gj1.Z(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzu(z);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzu[] newArray(int i) {
        return new zzu[i];
    }
}
