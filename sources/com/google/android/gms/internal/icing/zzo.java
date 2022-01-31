package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzo extends AbstractSafeParcelable implements f32 {
    public static final Parcelable.Creator<zzo> CREATOR = new sl3();
    public Status f;
    public List<zzw> g;
    @Deprecated
    public String[] h;

    public zzo() {
    }

    @Override // defpackage.f32
    public final Status M0() {
        return this.f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i, false);
        gj1.F0(parcel, 2, this.g, false);
        gj1.C0(parcel, 3, this.h, false);
        gj1.H1(parcel, o1);
    }

    public zzo(Status status, List<zzw> list, String[] strArr) {
        this.f = status;
        this.g = list;
        this.h = strArr;
    }
}
