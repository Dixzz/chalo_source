package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.signin.internal.zaa;

/* renamed from: bi4  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class bi4 implements Parcelable.Creator<zaa> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zaa createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 2) {
                i2 = gj1.g0(parcel, readInt);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                intent = (Intent) gj1.w(parcel, readInt, Intent.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zaa(i, i2, intent);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zaa[] newArray(int i) {
        return new zaa[i];
    }
}
