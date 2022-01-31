package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzn;
import java.util.ArrayList;

/* renamed from: ah4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ah4 implements Parcelable.Creator<zzn> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzn createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str8 = null;
        long j6 = -2147483648L;
        String str9 = "";
        boolean z = true;
        boolean z2 = false;
        int i = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    str = gj1.x(parcel, readInt);
                    break;
                case 3:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 4:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case 5:
                    str4 = gj1.x(parcel, readInt);
                    break;
                case 6:
                    j = gj1.h0(parcel, readInt);
                    break;
                case 7:
                    j2 = gj1.h0(parcel, readInt);
                    break;
                case '\b':
                    str5 = gj1.x(parcel, readInt);
                    break;
                case '\t':
                    z = gj1.Z(parcel, readInt);
                    break;
                case '\n':
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case 11:
                    j6 = gj1.h0(parcel, readInt);
                    break;
                case '\f':
                    str6 = gj1.x(parcel, readInt);
                    break;
                case '\r':
                    j3 = gj1.h0(parcel, readInt);
                    break;
                case 14:
                    j4 = gj1.h0(parcel, readInt);
                    break;
                case 15:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 16:
                    z3 = gj1.Z(parcel, readInt);
                    break;
                case 17:
                    z4 = gj1.Z(parcel, readInt);
                    break;
                case 18:
                    z5 = gj1.Z(parcel, readInt);
                    break;
                case 19:
                    str7 = gj1.x(parcel, readInt);
                    break;
                case 20:
                default:
                    gj1.p0(parcel, readInt);
                    break;
                case 21:
                    bool = gj1.a0(parcel, readInt);
                    break;
                case 22:
                    j5 = gj1.h0(parcel, readInt);
                    break;
                case 23:
                    arrayList = gj1.z(parcel, readInt);
                    break;
                case 24:
                    str8 = gj1.x(parcel, readInt);
                    break;
                case 25:
                    str9 = gj1.x(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzn(str, str2, str3, str4, j, j2, str5, z, z2, j6, str6, j3, j4, i, z3, z4, z5, str7, bool, j5, arrayList, str8, str9);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzn[] newArray(int i) {
        return new zzn[i];
    }
}
