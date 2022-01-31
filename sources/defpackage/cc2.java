package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzn;

/* renamed from: cc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class cc2 implements Parcelable.Creator<zzn> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzn createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c == 2) {
                z = gj1.Z(parcel, readInt);
            } else if (c == 3) {
                z2 = gj1.Z(parcel, readInt);
            } else if (c == 4) {
                iBinder = gj1.f0(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                z3 = gj1.Z(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzn(str, z, z2, iBinder, z3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzn[] newArray(int i) {
        return new zzn[i];
    }
}
