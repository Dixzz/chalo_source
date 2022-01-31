package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.icing.zzo;
import com.google.android.gms.internal.icing.zzw;
import java.util.ArrayList;

/* renamed from: sl3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class sl3 implements Parcelable.Creator<zzo> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzo createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        Status status = null;
        ArrayList arrayList = null;
        String[] strArr = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                status = (Status) gj1.w(parcel, readInt, Status.CREATOR);
            } else if (c == 2) {
                arrayList = gj1.B(parcel, readInt, zzw.CREATOR);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                strArr = gj1.y(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzo(status, arrayList, strArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i) {
        return new zzo[i];
    }
}
