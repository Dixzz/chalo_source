package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zzae;

/* renamed from: po3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class po3 implements Parcelable.Creator<zzae> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzae createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    j = gj1.h0(parcel, readInt);
                    break;
                case 2:
                    j2 = gj1.h0(parcel, readInt);
                    break;
                case 3:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 4:
                    str = gj1.x(parcel, readInt);
                    break;
                case 5:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 6:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case 7:
                    bundle = gj1.s(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzae(j, j2, z, str, str2, str3, bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzae[] newArray(int i) {
        return new zzae[i];
    }
}
