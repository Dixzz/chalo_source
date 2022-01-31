package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.zzi;

/* renamed from: ja2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ja2 implements Parcelable.Creator<zzi> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzi createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                bundle = gj1.s(parcel, readInt);
            } else if (c == 2) {
                featureArr = (Feature[]) gj1.A(parcel, readInt, Feature.CREATOR);
            } else if (c == 3) {
                i = gj1.g0(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) gj1.w(parcel, readInt, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzi(bundle, featureArr, i, connectionTelemetryConfiguration);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzi[] newArray(int i) {
        return new zzi[i];
    }
}
