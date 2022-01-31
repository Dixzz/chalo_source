package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import defpackage.i12;
import java.util.Arrays;

public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new m12();
    public zzr f;
    public byte[] g;
    public int[] h;
    public String[] i;
    public int[] j;
    public byte[][] k;
    public ExperimentTokens[] l;
    public boolean m;
    public final sk2 n;
    public final i12.c o;

    public zze(zzr zzr, sk2 sk2, i12.c cVar, int[] iArr, int[] iArr2, boolean z) {
        this.f = zzr;
        this.n = sk2;
        this.o = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = z;
    }

    public zze(zzr zzr, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z, ExperimentTokens[] experimentTokensArr) {
        this.f = zzr;
        this.g = bArr;
        this.h = iArr;
        this.i = strArr;
        this.n = null;
        this.o = null;
        this.j = iArr2;
        this.k = bArr2;
        this.l = experimentTokensArr;
        this.m = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zze) {
            zze zze = (zze) obj;
            return gj1.G(this.f, zze.f) && Arrays.equals(this.g, zze.g) && Arrays.equals(this.h, zze.h) && Arrays.equals(this.i, zze.i) && gj1.G(this.n, zze.n) && gj1.G(this.o, zze.o) && gj1.G(null, null) && Arrays.equals(this.j, zze.j) && Arrays.deepEquals(this.k, zze.k) && Arrays.equals(this.l, zze.l) && this.m == zze.m;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f, this.g, this.h, this.i, this.n, this.o, null, this.j, this.k, this.l, Boolean.valueOf(this.m)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.f);
        sb.append(", LogEventBytes: ");
        sb.append(this.g == null ? null : new String(this.g));
        sb.append(", TestCodes: ");
        sb.append(Arrays.toString(this.h));
        sb.append(", MendelPackages: ");
        sb.append(Arrays.toString(this.i));
        sb.append(", LogEvent: ");
        sb.append(this.n);
        sb.append(", ExtensionProducer: ");
        sb.append(this.o);
        sb.append(", VeProducer: ");
        sb.append((Object) null);
        sb.append(", ExperimentIDs: ");
        sb.append(Arrays.toString(this.j));
        sb.append(", ExperimentTokens: ");
        sb.append(Arrays.toString(this.k));
        sb.append(", ExperimentTokensParcelables: ");
        sb.append(Arrays.toString(this.l));
        sb.append(", AddPhenotypeExperimentTokens: ");
        sb.append(this.m);
        sb.append("]");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 2, this.f, i2, false);
        gj1.u0(parcel, 3, this.g, false);
        gj1.y0(parcel, 4, this.h, false);
        gj1.C0(parcel, 5, this.i, false);
        gj1.y0(parcel, 6, this.j, false);
        gj1.v0(parcel, 7, this.k, false);
        boolean z = this.m;
        parcel.writeInt(262152);
        parcel.writeInt(z ? 1 : 0);
        gj1.E0(parcel, 9, this.l, i2, false);
        gj1.H1(parcel, o1);
    }
}
