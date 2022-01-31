package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

public class Cap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Cap> CREATOR = new zzb();
    private static final String TAG = Cap.class.getSimpleName();
    private final BitmapDescriptor bitmapDescriptor;
    private final int type;
    private final Float zzcn;

    private Cap(int i, BitmapDescriptor bitmapDescriptor2, Float f) {
        gj1.c(i != 3 || (bitmapDescriptor2 != null && (f != null && (f.floatValue() > 0.0f ? 1 : (f.floatValue() == 0.0f ? 0 : -1)) > 0)), String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i), bitmapDescriptor2, f));
        this.type = i;
        this.bitmapDescriptor = bitmapDescriptor2;
        this.zzcn = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.type == cap.type && gj1.G(this.bitmapDescriptor, cap.bitmapDescriptor) && gj1.G(this.zzcn, cap.zzcn);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.type), this.bitmapDescriptor, this.zzcn});
    }

    public String toString() {
        int i = this.type;
        StringBuilder sb = new StringBuilder(23);
        sb.append("[Cap: type=");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.type;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        BitmapDescriptor bitmapDescriptor2 = this.bitmapDescriptor;
        if (bitmapDescriptor2 == null) {
            iBinder = null;
        } else {
            iBinder = bitmapDescriptor2.zzb().asBinder();
        }
        gj1.x0(parcel, 3, iBinder, false);
        gj1.w0(parcel, 4, this.zzcn, false);
        gj1.H1(parcel, o1);
    }

    public final Cap zzh() {
        int i = this.type;
        if (i == 0) {
            return new ButtCap();
        }
        if (i == 1) {
            return new SquareCap();
        }
        if (i == 2) {
            return new RoundCap();
        }
        if (i != 3) {
            return this;
        }
        return new CustomCap(this.bitmapDescriptor, this.zzcn.floatValue());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Cap(int r2, android.os.IBinder r3, java.lang.Float r4) {
        /*
            r1 = this;
            if (r3 != 0) goto L_0x0004
            r3 = 0
            goto L_0x000e
        L_0x0004:
            ic2 r3 = defpackage.ic2.a.F(r3)
            com.google.android.gms.maps.model.BitmapDescriptor r0 = new com.google.android.gms.maps.model.BitmapDescriptor
            r0.<init>(r3)
            r3 = r0
        L_0x000e:
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.Cap.<init>(int, android.os.IBinder, java.lang.Float):void");
    }

    public Cap(BitmapDescriptor bitmapDescriptor2, float f) {
        this(3, bitmapDescriptor2, Float.valueOf(f));
    }

    public Cap(int i) {
        this(i, (BitmapDescriptor) null, (Float) null);
    }
}
