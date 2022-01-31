package com.google.android.gms.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new ec2();
    public final String f;
    @Nullable
    public final xb2 g;
    public final boolean h;
    public final boolean i;

    public zzs(String str, @Nullable IBinder iBinder, boolean z, boolean z2) {
        ua2 ua2;
        byte[] bArr;
        this.f = str;
        yb2 yb2 = null;
        if (iBinder != null) {
            try {
                int i2 = xb2.g;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
                if (queryLocalInterface instanceof ua2) {
                    ua2 = (ua2) queryLocalInterface;
                } else {
                    ua2 = new ta2(iBinder);
                }
                ic2 zzd = ua2.zzd();
                if (zzd == null) {
                    bArr = null;
                } else {
                    bArr = (byte[]) kc2.L(zzd);
                }
                if (bArr != null) {
                    yb2 = new yb2(bArr);
                }
            } catch (RemoteException unused) {
            }
        }
        this.g = yb2;
        this.h = z;
        this.i = z2;
    }

    public zzs(String str, @Nullable xb2 xb2, boolean z, boolean z2) {
        this.f = str;
        this.g = xb2;
        this.h = z;
        this.i = z2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        xb2 xb2 = this.g;
        if (xb2 == null) {
            xb2 = null;
        }
        gj1.x0(parcel, 2, xb2, false);
        boolean z = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.i;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.H1(parcel, o1);
    }
}
