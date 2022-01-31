package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.MethodInvocation;

/* renamed from: n92  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class n92 implements Parcelable.Creator<MethodInvocation> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final MethodInvocation createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 2:
                    i2 = gj1.g0(parcel, readInt);
                    break;
                case 3:
                    i3 = gj1.g0(parcel, readInt);
                    break;
                case 4:
                    j = gj1.h0(parcel, readInt);
                    break;
                case 5:
                    j2 = gj1.h0(parcel, readInt);
                    break;
                case 6:
                    str = gj1.x(parcel, readInt);
                    break;
                case 7:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case '\b':
                    i4 = gj1.g0(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new MethodInvocation(i, i2, i3, j, j2, str, str2, i4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MethodInvocation[] newArray(int i) {
        return new MethodInvocation[i];
    }
}
