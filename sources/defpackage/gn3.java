package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzm;
import com.google.android.gms.internal.location.zzo;

/* renamed from: gn3  reason: default package */
public final class gn3 implements Parcelable.Creator<zzo> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzo createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        zzm zzm = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i = 1;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 2) {
                zzm = (zzm) gj1.w(parcel, readInt, zzm.CREATOR);
            } else if (c == 3) {
                iBinder = gj1.f0(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                iBinder2 = gj1.f0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzo(i, zzm, iBinder, iBinder2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i) {
        return new zzo[i];
    }
}
