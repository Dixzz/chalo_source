package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.internal.location.zzm;
import com.google.android.gms.location.zzj;
import java.util.List;

/* renamed from: fn3  reason: default package */
public final class fn3 implements Parcelable.Creator<zzm> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzm createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        zzj zzj = zzm.j;
        List<ClientIdentity> list = zzm.i;
        String str = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                zzj = (zzj) gj1.w(parcel, readInt, zzj.CREATOR);
            } else if (c == 2) {
                list = gj1.B(parcel, readInt, ClientIdentity.CREATOR);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzm(zzj, list, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm[] newArray(int i) {
        return new zzm[i];
    }
}
