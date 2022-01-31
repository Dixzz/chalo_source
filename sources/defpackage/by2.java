package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzli;

/* renamed from: by2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class by2 implements Parcelable.Creator<zzli> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzli createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                str = gj1.x(parcel, readInt);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                str2 = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzli(str, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzli[] newArray(int i) {
        return new zzli[i];
    }
}
