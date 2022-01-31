package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public final class zzbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbd> CREATOR = new xm3();
    public static final List<ClientIdentity> m = Collections.emptyList();
    public LocationRequest f;
    public List<ClientIdentity> g;
    public String h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;

    public zzbd(LocationRequest locationRequest, List<ClientIdentity> list, String str, boolean z, boolean z2, boolean z3, String str2) {
        this.f = locationRequest;
        this.g = list;
        this.h = str;
        this.i = z;
        this.j = z2;
        this.k = z3;
        this.l = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbd = (zzbd) obj;
        return gj1.G(this.f, zzbd.f) && gj1.G(this.g, zzbd.g) && gj1.G(this.h, zzbd.h) && this.i == zzbd.i && this.j == zzbd.j && this.k == zzbd.k && gj1.G(this.l, zzbd.l);
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f);
        if (this.h != null) {
            sb.append(" tag=");
            sb.append(this.h);
        }
        if (this.l != null) {
            sb.append(" moduleId=");
            sb.append(this.l);
        }
        sb.append(" hideAppOps=");
        sb.append(this.i);
        sb.append(" clients=");
        sb.append(this.g);
        sb.append(" forceCoarseLocation=");
        sb.append(this.j);
        if (this.k) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i2, false);
        gj1.F0(parcel, 5, this.g, false);
        gj1.B0(parcel, 6, this.h, false);
        boolean z = this.i;
        parcel.writeInt(262151);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.j;
        parcel.writeInt(262152);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.k;
        parcel.writeInt(262153);
        parcel.writeInt(z3 ? 1 : 0);
        gj1.B0(parcel, 10, this.l, false);
        gj1.H1(parcel, o1);
    }
}
