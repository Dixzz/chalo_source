package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.location.zzad;

/* renamed from: zl3  reason: default package */
public final class zl3 implements Parcelable.Creator<zzad> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzad createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        Status status = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                gj1.p0(parcel, readInt);
            } else {
                status = (Status) gj1.w(parcel, readInt, Status.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzad(status);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzad[] newArray(int i) {
        return new zzad[i];
    }
}
