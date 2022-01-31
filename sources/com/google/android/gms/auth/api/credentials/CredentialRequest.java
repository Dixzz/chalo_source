package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;

public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new b02();
    public final int f;
    public final boolean g;
    public final String[] h;
    public final CredentialPickerConfig i;
    public final CredentialPickerConfig j;
    public final boolean k;
    public final String l;
    public final String m;
    public final boolean n;

    public CredentialRequest(int i2, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z2, String str, String str2, boolean z3) {
        this.f = i2;
        this.g = z;
        Objects.requireNonNull(strArr, "null reference");
        this.h = strArr;
        this.i = credentialPickerConfig == null ? new CredentialPickerConfig(2, false, true, false, 1) : credentialPickerConfig;
        this.j = credentialPickerConfig2 == null ? new CredentialPickerConfig(2, false, true, false, 1) : credentialPickerConfig2;
        if (i2 < 3) {
            this.k = true;
            this.l = null;
            this.m = null;
        } else {
            this.k = z2;
            this.l = str;
            this.m = str2;
        }
        this.n = z3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        boolean z = this.g;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        gj1.C0(parcel, 2, this.h, false);
        gj1.A0(parcel, 3, this.i, i2, false);
        gj1.A0(parcel, 4, this.j, i2, false);
        boolean z2 = this.k;
        parcel.writeInt(262149);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.B0(parcel, 6, this.l, false);
        gj1.B0(parcel, 7, this.m, false);
        int i3 = this.f;
        parcel.writeInt(263144);
        parcel.writeInt(i3);
        boolean z3 = this.n;
        parcel.writeInt(262152);
        parcel.writeInt(z3 ? 1 : 0);
        gj1.H1(parcel, o1);
    }
}
