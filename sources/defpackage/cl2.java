package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.clearcut.zzr;

/* renamed from: cl2  reason: default package */
public final class cl2 implements Parcelable.Creator<zzr> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzr createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        int i2 = 0;
        boolean z = true;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    str = gj1.x(parcel, readInt);
                    break;
                case 3:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 4:
                    i2 = gj1.g0(parcel, readInt);
                    break;
                case 5:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 6:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case 7:
                    z = gj1.Z(parcel, readInt);
                    break;
                case '\b':
                    str4 = gj1.x(parcel, readInt);
                    break;
                case '\t':
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case '\n':
                    i3 = gj1.g0(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzr(str, i, i2, str2, str3, z, str4, z2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i) {
        return new zzr[i];
    }
}
