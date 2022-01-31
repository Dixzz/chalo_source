package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new a02();
    public final int f;
    public final boolean g;
    public final boolean h;
    public final int i;

    public CredentialPickerConfig(int i2, boolean z, boolean z2, boolean z3, int i3) {
        this.f = i2;
        this.g = z;
        this.h = z2;
        int i4 = 3;
        if (i2 < 2) {
            this.i = !z3 ? 1 : i4;
        } else {
            this.i = i3;
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        boolean z = this.g;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.h;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        int i3 = this.i == 3 ? 1 : 0;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        int i4 = this.i;
        parcel.writeInt(262148);
        parcel.writeInt(i4);
        int i5 = this.f;
        parcel.writeInt(263144);
        parcel.writeInt(i5);
        gj1.H1(parcel, o1);
    }
}
