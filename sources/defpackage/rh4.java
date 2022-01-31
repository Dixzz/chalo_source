package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.safetynet.zza;

/* renamed from: rh4  reason: default package */
public final class rh4 implements Parcelable.Creator<zza> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zza createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 2) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zza(str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
