package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zzal;
import java.util.ArrayList;

/* renamed from: r34  reason: default package */
public final class r34 implements Parcelable.Creator<zzal> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzal createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        ArrayList<String> arrayList = null;
        String str = "";
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                arrayList = gj1.z(parcel, readInt);
            } else if (c == 2) {
                pendingIntent = (PendingIntent) gj1.w(parcel, readInt, PendingIntent.CREATOR);
            } else if (c != 3) {
                gj1.p0(parcel, readInt);
            } else {
                str = gj1.x(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new zzal(arrayList, pendingIntent, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal[] newArray(int i) {
        return new zzal[i];
    }
}
