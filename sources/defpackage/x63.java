package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzvl;
import com.google.android.gms.internal.p000firebaseauthapi.zzxe;
import java.util.ArrayList;

/* renamed from: x63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class x63 implements Parcelable.Creator<zzvl> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzvl createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        zzxe zzxe = null;
        ArrayList<String> arrayList = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    str = gj1.x(parcel, readInt);
                    break;
                case 3:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 4:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 5:
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case 6:
                    zzxe = (zzxe) gj1.w(parcel, readInt, zzxe.CREATOR);
                    break;
                case 7:
                    arrayList = gj1.z(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzvl(str, z, str2, z2, zzxe, arrayList);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzvl[] newArray(int i) {
        return new zzvl[i];
    }
}
