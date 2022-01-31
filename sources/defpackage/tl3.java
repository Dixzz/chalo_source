package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzm;
import com.google.android.gms.internal.icing.zzt;
import com.google.android.gms.internal.icing.zzu;

/* renamed from: tl3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class tl3 implements Parcelable.Creator<zzt> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzt createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        zzm[] zzmArr = null;
        String str4 = null;
        zzu zzu = null;
        boolean z = false;
        int i = 1;
        boolean z2 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 11) {
                str4 = gj1.x(parcel, readInt);
            } else if (c != '\f') {
                switch (c) {
                    case 1:
                        str = gj1.x(parcel, readInt);
                        continue;
                    case 2:
                        str2 = gj1.x(parcel, readInt);
                        continue;
                    case 3:
                        z = gj1.Z(parcel, readInt);
                        continue;
                    case 4:
                        i = gj1.g0(parcel, readInt);
                        continue;
                    case 5:
                        z2 = gj1.Z(parcel, readInt);
                        continue;
                    case 6:
                        str3 = gj1.x(parcel, readInt);
                        continue;
                    case 7:
                        zzmArr = (zzm[]) gj1.A(parcel, readInt, zzm.CREATOR);
                        continue;
                    default:
                        gj1.p0(parcel, readInt);
                        continue;
                }
            } else {
                zzu = (zzu) gj1.w(parcel, readInt, zzu.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzt(str, str2, z, i, z2, str3, zzmArr, str4, zzu);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzt[] newArray(int i) {
        return new zzt[i];
    }
}
