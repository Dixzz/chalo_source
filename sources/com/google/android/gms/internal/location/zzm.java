package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.zzj;
import java.util.Collections;
import java.util.List;

public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new fn3();
    public static final List<ClientIdentity> i = Collections.emptyList();
    public static final zzj j = new zzj();
    public zzj f;
    public List<ClientIdentity> g;
    public String h;

    public zzm(zzj zzj, List<ClientIdentity> list, String str) {
        this.f = zzj;
        this.g = list;
        this.h = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzm = (zzm) obj;
        return gj1.G(this.f, zzm.f) && gj1.G(this.g, zzm.g) && gj1.G(this.h, zzm.h);
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i2, false);
        gj1.F0(parcel, 2, this.g, false);
        gj1.B0(parcel, 3, this.h, false);
        gj1.H1(parcel, o1);
    }
}
