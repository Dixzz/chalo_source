package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzku;

/* renamed from: tg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class tg4 implements Parcelable.Creator<zzku> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzku createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        Long l = null;
        Float f = null;
        String str2 = null;
        String str3 = null;
        Double d = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 2:
                    str = gj1.x(parcel, readInt);
                    break;
                case 3:
                    j = gj1.h0(parcel, readInt);
                    break;
                case 4:
                    l = gj1.i0(parcel, readInt);
                    break;
                case 5:
                    f = gj1.e0(parcel, readInt);
                    break;
                case 6:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 7:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case '\b':
                    int j0 = gj1.j0(parcel, readInt);
                    if (j0 != 0) {
                        gj1.u1(parcel, readInt, j0, 8);
                        d = Double.valueOf(parcel.readDouble());
                        break;
                    } else {
                        d = null;
                        break;
                    }
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzku(i, str, j, l, f, str2, str3, d);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzku[] newArray(int i) {
        return new zzku[i];
    }
}
