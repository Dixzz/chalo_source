package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* renamed from: ba2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ba2 implements Parcelable.Creator<RootTelemetryConfiguration> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final RootTelemetryConfiguration createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                i = gj1.g0(parcel, readInt);
            } else if (c == 2) {
                z = gj1.Z(parcel, readInt);
            } else if (c == 3) {
                z2 = gj1.Z(parcel, readInt);
            } else if (c == 4) {
                i2 = gj1.g0(parcel, readInt);
            } else if (c != 5) {
                gj1.p0(parcel, readInt);
            } else {
                i3 = gj1.g0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new RootTelemetryConfiguration(i, z, z2, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ RootTelemetryConfiguration[] newArray(int i) {
        return new RootTelemetryConfiguration[i];
    }
}
