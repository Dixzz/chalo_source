package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new vl3();
    public final zzi f;
    public final long g;
    public int h;
    public final String i;
    public final zzh j;
    public final boolean k;
    public int l;
    public int m;
    public final String n;

    public zzw(zzi zzi, long j2, int i2, String str, zzh zzh, boolean z, int i3, int i4, String str2) {
        this.f = zzi;
        this.g = j2;
        this.h = i2;
        this.i = str;
        this.j = zzh;
        this.k = z;
        this.l = i3;
        this.m = i4;
        this.n = str2;
    }

    public static zzk l1(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        return new zzk(str2, new zzt(str, null, true, 1, false, null, (zzm[]) arrayList.toArray(new zzm[arrayList.size()]), null, null), str);
    }

    public final String toString() {
        return String.format(Locale.US, "UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", this.f, Long.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.m));
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i2, false);
        long j2 = this.g;
        parcel.writeInt(524290);
        parcel.writeLong(j2);
        int i3 = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        gj1.B0(parcel, 4, this.i, false);
        gj1.A0(parcel, 5, this.j, i2, false);
        boolean z = this.k;
        parcel.writeInt(262150);
        parcel.writeInt(z ? 1 : 0);
        int i4 = this.l;
        parcel.writeInt(262151);
        parcel.writeInt(i4);
        int i5 = this.m;
        parcel.writeInt(262152);
        parcel.writeInt(i5);
        gj1.B0(parcel, 9, this.n, false);
        gj1.H1(parcel, o1);
    }
}
