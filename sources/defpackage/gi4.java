package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.signin.internal.zag;
import java.util.ArrayList;

/* renamed from: gi4  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class gi4 implements Parcelable.Creator<zag> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zag createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                arrayList = gj1.z(parcel, readInt);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zag(arrayList, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zag[] newArray(int i) {
        return new zag[i];
    }
}
