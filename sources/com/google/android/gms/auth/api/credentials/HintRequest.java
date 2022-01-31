package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;

public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new c02();
    public final int f;
    public final CredentialPickerConfig g;
    public final boolean h;
    public final boolean i;
    public final String[] j;
    public final boolean k;
    public final String l;
    public final String m;

    public HintRequest(int i2, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr, boolean z3, String str, String str2) {
        this.f = i2;
        Objects.requireNonNull(credentialPickerConfig, "null reference");
        this.g = credentialPickerConfig;
        this.h = z;
        this.i = z2;
        Objects.requireNonNull(strArr, "null reference");
        this.j = strArr;
        if (i2 < 2) {
            this.k = true;
            this.l = null;
            this.m = null;
            return;
        }
        this.k = z3;
        this.l = str;
        this.m = str2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.g, i2, false);
        boolean z = this.h;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.i;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.C0(parcel, 4, this.j, false);
        boolean z3 = this.k;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        gj1.B0(parcel, 6, this.l, false);
        gj1.B0(parcel, 7, this.m, false);
        int i3 = this.f;
        parcel.writeInt(263144);
        parcel.writeInt(i3);
        gj1.H1(parcel, o1);
    }
}
