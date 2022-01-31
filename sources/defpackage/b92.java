package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import java.util.ArrayList;

/* renamed from: b92  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class b92 implements Parcelable.Creator<TelemetryData> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final TelemetryData createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 2) {
                gj1.p0(parcel, readInt);
            } else {
                arrayList = gj1.B(parcel, readInt, MethodInvocation.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new TelemetryData(i, arrayList);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ TelemetryData[] newArray(int i) {
        return new TelemetryData[i];
    }
}
