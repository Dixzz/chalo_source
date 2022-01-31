package com.google.android.gms.internal.icing;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.BitSet;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new nl3();
    public final zzk[] f;
    public final String g;
    public final boolean h;
    public final Account i;

    public zzh(String str, boolean z, Account account, zzk... zzkArr) {
        this.f = zzkArr;
        this.g = str;
        this.h = z;
        this.i = account;
        if (zzkArr != null) {
            BitSet bitSet = new BitSet(rl3.f3094a.length);
            for (zzk zzk : zzkArr) {
                int i2 = zzk.h;
                if (i2 != -1) {
                    if (bitSet.get(i2)) {
                        String valueOf = String.valueOf(rl3.a(i2));
                        throw new IllegalArgumentException(valueOf.length() != 0 ? "Duplicate global search section type ".concat(valueOf) : new String("Duplicate global search section type "));
                    }
                    bitSet.set(i2);
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzh) {
            zzh zzh = (zzh) obj;
            if (!gj1.G(this.g, zzh.g) || !gj1.G(Boolean.valueOf(this.h), Boolean.valueOf(zzh.h)) || !gj1.G(this.i, zzh.i) || !Arrays.equals(this.f, zzh.f)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.g, Boolean.valueOf(this.h), this.i, Integer.valueOf(Arrays.hashCode(this.f))});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.E0(parcel, 1, this.f, i2, false);
        gj1.B0(parcel, 2, this.g, false);
        boolean z = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(z ? 1 : 0);
        gj1.A0(parcel, 4, this.i, i2, false);
        gj1.H1(parcel, o1);
    }

    public zzh(zzk[] zzkArr, String str, boolean z, Account account) {
        this.f = zzkArr;
        this.g = str;
        this.h = z;
        this.i = account;
    }
}
