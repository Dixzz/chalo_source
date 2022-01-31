package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class TelemetryData extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<TelemetryData> CREATOR = new b92();
    public final int f;
    @Nullable
    public List<MethodInvocation> g;

    public TelemetryData(int i, @Nullable List<MethodInvocation> list) {
        this.f = i;
        this.g = list;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        gj1.F0(parcel, 2, this.g, false);
        gj1.H1(parcel, o1);
    }
}
