package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new tl3();
    public final String f;
    public final String g;
    public final boolean h;
    public final int i;
    public final boolean j;
    public final String k;
    @Nullable
    public final zzm[] l;
    public final String m;
    public final zzu n;

    public zzt(String str, String str2, boolean z, int i2, boolean z2, String str3, zzm[] zzmArr, String str4, zzu zzu) {
        this.f = str;
        this.g = str2;
        this.h = z;
        this.i = i2;
        this.j = z2;
        this.k = str3;
        this.l = zzmArr;
        this.m = str4;
        this.n = zzu;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt zzt = (zzt) obj;
        return this.h == zzt.h && this.i == zzt.i && this.j == zzt.j && gj1.G(this.f, zzt.f) && gj1.G(this.g, zzt.g) && gj1.G(this.k, zzt.k) && gj1.G(this.m, zzt.m) && gj1.G(this.n, zzt.n) && Arrays.equals(this.l, zzt.l);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f, this.g, Boolean.valueOf(this.h), Integer.valueOf(this.i), Boolean.valueOf(this.j), this.k, Integer.valueOf(Arrays.hashCode(this.l)), this.m, this.n});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.B0(parcel, 2, this.g, false);
        boolean z = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(z ? 1 : 0);
        int i3 = this.i;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        boolean z2 = this.j;
        parcel.writeInt(262149);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.B0(parcel, 6, this.k, false);
        gj1.E0(parcel, 7, this.l, i2, false);
        gj1.B0(parcel, 11, this.m, false);
        gj1.A0(parcel, 12, this.n, i2, false);
        gj1.H1(parcel, o1);
    }
}
