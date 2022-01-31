package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* renamed from: ka2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ka2 implements Parcelable.Creator<ConnectionTelemetryConfiguration> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ConnectionTelemetryConfiguration createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArr = null;
        int[] iArr2 = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) gj1.w(parcel, readInt, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 3:
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case 4:
                    iArr = gj1.v(parcel, readInt);
                    break;
                case 5:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 6:
                    iArr2 = gj1.v(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z, z2, iArr, i, iArr2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ConnectionTelemetryConfiguration[] newArray(int i) {
        return new ConnectionTelemetryConfiguration[i];
    }
}
