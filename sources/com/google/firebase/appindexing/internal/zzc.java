package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzv();
    private int zzaq = 0;
    private final boolean zzel;
    private final boolean zzem;
    private final String zzes;
    private final String zzet;
    private final byte[] zzeu;

    public zzc(int i, boolean z, String str, String str2, byte[] bArr, boolean z2) {
        this.zzaq = i;
        this.zzel = z;
        this.zzes = str;
        this.zzet = str2;
        this.zzeu = bArr;
        this.zzem = z2;
    }

    public final String toString() {
        StringBuilder k0 = hj1.k0("MetadataImpl { ", "{ eventStatus: '");
        k0.append(this.zzaq);
        k0.append("' } ");
        k0.append("{ uploadable: '");
        k0.append(this.zzel);
        k0.append("' } ");
        if (this.zzes != null) {
            k0.append("{ completionToken: '");
            k0.append(this.zzes);
            k0.append("' } ");
        }
        if (this.zzet != null) {
            k0.append("{ accountName: '");
            k0.append(this.zzet);
            k0.append("' } ");
        }
        if (this.zzeu != null) {
            k0.append("{ ssbContext: [ ");
            byte[] bArr = this.zzeu;
            for (byte b : bArr) {
                k0.append("0x");
                k0.append(Integer.toHexString(b));
                k0.append(" ");
            }
            k0.append("] } ");
        }
        k0.append("{ contextOnly: '");
        k0.append(this.zzem);
        k0.append("' } ");
        k0.append("}");
        return k0.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.zzaq;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        boolean z = this.zzel;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        gj1.B0(parcel, 3, this.zzes, false);
        gj1.B0(parcel, 4, this.zzet, false);
        gj1.u0(parcel, 5, this.zzeu, false);
        boolean z2 = this.zzem;
        parcel.writeInt(262150);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.H1(parcel, o1);
    }

    public final void zzf(int i) {
        this.zzaq = i;
    }

    public zzc(boolean z, String str, String str2, byte[] bArr, boolean z2) {
        this.zzel = z;
        this.zzes = null;
        this.zzet = null;
        this.zzeu = null;
        this.zzem = false;
    }
}
