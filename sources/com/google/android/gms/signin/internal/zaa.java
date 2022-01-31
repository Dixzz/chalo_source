package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class zaa extends AbstractSafeParcelable implements f32 {
    public static final Parcelable.Creator<zaa> CREATOR = new bi4();
    public final int f;
    public int g;
    public Intent h;

    public zaa() {
        this.f = 2;
        this.g = 0;
        this.h = null;
    }

    @Override // defpackage.f32
    public final Status M0() {
        if (this.g == 0) {
            return Status.k;
        }
        return Status.o;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        gj1.A0(parcel, 3, this.h, i, false);
        gj1.H1(parcel, o1);
    }

    public zaa(int i, int i2, Intent intent) {
        this.f = i;
        this.g = i2;
        this.h = intent;
    }
}
