package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

/* renamed from: m72  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class m72 implements Parcelable.Creator<Scope> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final Scope createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new Scope(i, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Scope[] newArray(int i) {
        return new Scope[i];
    }
}
