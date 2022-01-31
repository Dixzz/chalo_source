package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzh;
import com.google.android.gms.internal.icing.zzi;
import com.google.android.gms.internal.icing.zzw;

/* renamed from: vl3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class vl3 implements Parcelable.Creator<zzw> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzw createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        zzi zzi = null;
        String str = null;
        zzh zzh = null;
        String str2 = null;
        long j = 0;
        int i = 0;
        boolean z = false;
        int i2 = -1;
        int i3 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    zzi = (zzi) gj1.w(parcel, readInt, zzi.CREATOR);
                    break;
                case 2:
                    j = gj1.h0(parcel, readInt);
                    break;
                case 3:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 4:
                    str = gj1.x(parcel, readInt);
                    break;
                case 5:
                    zzh = (zzh) gj1.w(parcel, readInt, zzh.CREATOR);
                    break;
                case 6:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 7:
                    i2 = gj1.g0(parcel, readInt);
                    break;
                case '\b':
                    i3 = gj1.g0(parcel, readInt);
                    break;
                case '\t':
                    str2 = gj1.x(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzw(zzi, j, i, str, zzh, z, i2, i3, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzw[] newArray(int i) {
        return new zzw[i];
    }
}
