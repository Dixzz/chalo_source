package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzbh;

/* renamed from: zm3  reason: default package */
public final class zm3 implements Parcelable.Creator<zzbh> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzbh createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        double d = 0.0d;
        double d2 = 0.0d;
        String str = null;
        long j = 0;
        int i = 0;
        short s = 0;
        float f = 0.0f;
        int i2 = 0;
        int i3 = -1;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    str = gj1.x(parcel, readInt);
                    break;
                case 2:
                    j = gj1.h0(parcel, readInt);
                    break;
                case 3:
                    gj1.X0(parcel, readInt, 4);
                    s = (short) parcel.readInt();
                    break;
                case 4:
                    d = gj1.c0(parcel, readInt);
                    break;
                case 5:
                    d2 = gj1.c0(parcel, readInt);
                    break;
                case 6:
                    f = gj1.d0(parcel, readInt);
                    break;
                case 7:
                    i = gj1.g0(parcel, readInt);
                    break;
                case '\b':
                    i2 = gj1.g0(parcel, readInt);
                    break;
                case '\t':
                    i3 = gj1.g0(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzbh(str, i, s, d, d2, f, j, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbh[] newArray(int i) {
        return new zzbh[i];
    }
}
