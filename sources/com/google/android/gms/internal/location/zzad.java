package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzad extends AbstractSafeParcelable implements f32 {
    public static final Parcelable.Creator<zzad> CREATOR = new zl3();
    public final Status f;

    static {
        new zzad(Status.k);
    }

    public zzad(Status status) {
        this.f = status;
    }

    @Override // defpackage.f32
    public final Status M0() {
        return this.f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i, false);
        gj1.H1(parcel, o1);
    }
}
