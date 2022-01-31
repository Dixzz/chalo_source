package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzxe;
import java.util.ArrayList;

/* renamed from: g83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class g83 implements Parcelable.Creator<zzxe> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzxe createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                arrayList = gj1.z(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzxe(i, arrayList);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzxe[] newArray(int i) {
        return new zzxe[i];
    }
}
