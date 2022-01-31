package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new pl3();
    public static final int j = Integer.parseInt("-1");
    public static final zzt k;
    public final String f;
    public final zzt g;
    public final int h;
    public final byte[] i;

    static {
        ArrayList arrayList = new ArrayList();
        k = new zzt("SsbContext", "blob", true, 1, false, null, (zzm[]) arrayList.toArray(new zzm[arrayList.size()]), null, null);
    }

    public zzk(String str, zzt zzt, int i2, byte[] bArr) {
        int i3 = j;
        boolean z = i2 == i3 || rl3.a(i2) != null;
        StringBuilder sb = new StringBuilder(32);
        sb.append("Invalid section type ");
        sb.append(i2);
        gj1.c(z, sb.toString());
        this.f = str;
        this.g = zzt;
        this.h = i2;
        this.i = bArr;
        String v = (i2 == i3 || rl3.a(i2) != null) ? (str == null || bArr == null) ? null : "Both content and blobContent set" : hj1.v(32, "Invalid section type ", i2);
        if (v != null) {
            throw new IllegalArgumentException(v);
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.A0(parcel, 3, this.g, i2, false);
        int i3 = this.h;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        gj1.u0(parcel, 5, this.i, false);
        gj1.H1(parcel, o1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzk(java.lang.String r3, com.google.android.gms.internal.icing.zzt r4, java.lang.String r5) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, java.lang.Integer> r0 = defpackage.rl3.b
            java.lang.Object r0 = r0.get(r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L_0x0013
            int r5 = r0.intValue()
            r0 = 0
            r2.<init>(r3, r4, r5, r0)
            return
        L_0x0013:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            r4 = 44
            int r4 = defpackage.hj1.g0(r5, r4)
            java.lang.String r0 = "["
            java.lang.String r1 = "] is not a valid global search section name"
            java.lang.String r4 = defpackage.hj1.y(r4, r0, r5, r1)
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.zzk.<init>(java.lang.String, com.google.android.gms.internal.icing.zzt, java.lang.String):void");
    }
}
