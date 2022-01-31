package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;

public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new r34();
    public final List<String> f;
    public final PendingIntent g;
    public final String h;

    public zzal(List<String> list, PendingIntent pendingIntent, String str) {
        this.f = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.g = pendingIntent;
        this.h = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.D0(parcel, 1, this.f, false);
        gj1.A0(parcel, 2, this.g, i, false);
        gj1.B0(parcel, 3, this.h, false);
        gj1.H1(parcel, o1);
    }
}
