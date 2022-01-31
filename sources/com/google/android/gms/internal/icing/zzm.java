package com.google.android.gms.internal.icing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new ql3();
    public final int f;
    public final Bundle g;

    public zzm(int i, Bundle bundle) {
        this.f = i;
        this.g = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof com.google.android.gms.internal.icing.zzm
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            com.google.android.gms.internal.icing.zzm r7 = (com.google.android.gms.internal.icing.zzm) r7
            int r1 = r6.f
            int r3 = r7.f
            if (r1 == r3) goto L_0x0013
            return r2
        L_0x0013:
            android.os.Bundle r1 = r6.g
            if (r1 != 0) goto L_0x001d
            android.os.Bundle r7 = r7.g
            if (r7 != 0) goto L_0x001c
            return r0
        L_0x001c:
            return r2
        L_0x001d:
            android.os.Bundle r3 = r7.g
            if (r3 != 0) goto L_0x0022
            return r2
        L_0x0022:
            int r1 = r1.size()
            android.os.Bundle r3 = r7.g
            int r3 = r3.size()
            if (r1 == r3) goto L_0x002f
            return r2
        L_0x002f:
            android.os.Bundle r1 = r6.g
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0039:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0060
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            android.os.Bundle r4 = r7.g
            boolean r4 = r4.containsKey(r3)
            if (r4 == 0) goto L_0x005f
            android.os.Bundle r4 = r6.g
            java.lang.String r4 = r4.getString(r3)
            android.os.Bundle r5 = r7.g
            java.lang.String r3 = r5.getString(r3)
            boolean r3 = defpackage.gj1.G(r4, r3)
            if (r3 != 0) goto L_0x0039
        L_0x005f:
            return r2
        L_0x0060:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.zzm.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.f));
        Bundle bundle = this.g;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                arrayList.add(str);
                arrayList.add(this.g.getString(str));
            }
        }
        return Arrays.hashCode(arrayList.toArray(new Object[0]));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        gj1.t0(parcel, 2, this.g, false);
        gj1.H1(parcel, o1);
    }
}
