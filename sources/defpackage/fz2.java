package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzno;
import com.google.firebase.auth.zze;

/* renamed from: fz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class fz2 implements Parcelable.Creator<zzno> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzno createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        Status status = null;
        zze zze = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                status = (Status) gj1.w(parcel, readInt, Status.CREATOR);
            } else if (c == 2) {
                zze = (zze) gj1.w(parcel, readInt, zze.CREATOR);
            } else if (c == 3) {
                str = gj1.x(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                str2 = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzno(status, zze, str, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzno[] newArray(int i) {
        return new zzno[i];
    }
}
