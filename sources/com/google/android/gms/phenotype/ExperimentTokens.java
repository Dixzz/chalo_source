package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExperimentTokens extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ExperimentTokens> CREATOR = new lh4();
    public static final byte[][] n;
    public final String f;
    public final byte[] g;
    public final byte[][] h;
    public final byte[][] i;
    public final byte[][] j;
    public final byte[][] k;
    public final int[] l;
    public final byte[][] m;

    static {
        byte[][] bArr = new byte[0][];
        n = bArr;
        new ExperimentTokens("", null, bArr, bArr, bArr, bArr, null, null);
    }

    public ExperimentTokens(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6) {
        this.f = str;
        this.g = bArr;
        this.h = bArr2;
        this.i = bArr3;
        this.j = bArr4;
        this.k = bArr5;
        this.l = iArr;
        this.m = bArr6;
    }

    public static List<Integer> l1(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List<String> m1(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] bArr2 : bArr) {
            arrayList.add(Base64.encodeToString(bArr2, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static void n1(StringBuilder sb, String str, byte[][] bArr) {
        String str2;
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            str2 = AnalyticsConstants.NULL;
        } else {
            sb.append("(");
            int length = bArr.length;
            boolean z = true;
            int i2 = 0;
            while (i2 < length) {
                byte[] bArr2 = bArr[i2];
                if (!z) {
                    sb.append(", ");
                }
                sb.append("'");
                sb.append(Base64.encodeToString(bArr2, 3));
                sb.append("'");
                i2++;
                z = false;
            }
            str2 = ")";
        }
        sb.append(str2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExperimentTokens) {
            ExperimentTokens experimentTokens = (ExperimentTokens) obj;
            return hd3.Q0(this.f, experimentTokens.f) && Arrays.equals(this.g, experimentTokens.g) && hd3.Q0(m1(this.h), m1(experimentTokens.h)) && hd3.Q0(m1(this.i), m1(experimentTokens.i)) && hd3.Q0(m1(this.j), m1(experimentTokens.j)) && hd3.Q0(m1(this.k), m1(experimentTokens.k)) && hd3.Q0(l1(this.l), l1(experimentTokens.l)) && hd3.Q0(m1(this.m), m1(experimentTokens.m));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ExperimentTokens");
        sb.append("(");
        String str = this.f;
        sb.append(str == null ? AnalyticsConstants.NULL : hj1.y(hj1.g0(str, 2), "'", str, "'"));
        sb.append(", ");
        byte[] bArr = this.g;
        sb.append("direct");
        sb.append("=");
        if (bArr == null) {
            sb.append(AnalyticsConstants.NULL);
        } else {
            sb.append("'");
            sb.append(Base64.encodeToString(bArr, 3));
            sb.append("'");
        }
        sb.append(", ");
        n1(sb, "GAIA", this.h);
        sb.append(", ");
        n1(sb, "PSEUDO", this.i);
        sb.append(", ");
        n1(sb, "ALWAYS", this.j);
        sb.append(", ");
        n1(sb, "OTHER", this.k);
        sb.append(", ");
        int[] iArr = this.l;
        sb.append("weak");
        sb.append("=");
        if (iArr == null) {
            sb.append(AnalyticsConstants.NULL);
        } else {
            sb.append("(");
            int length = iArr.length;
            boolean z = true;
            int i2 = 0;
            while (i2 < length) {
                int i3 = iArr[i2];
                if (!z) {
                    sb.append(", ");
                }
                sb.append(i3);
                i2++;
                z = false;
            }
            sb.append(")");
        }
        sb.append(", ");
        n1(sb, "directs", this.m);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.u0(parcel, 3, this.g, false);
        gj1.v0(parcel, 4, this.h, false);
        gj1.v0(parcel, 5, this.i, false);
        gj1.v0(parcel, 6, this.j, false);
        gj1.v0(parcel, 7, this.k, false);
        gj1.y0(parcel, 8, this.l, false);
        gj1.v0(parcel, 9, this.m, false);
        gj1.H1(parcel, o1);
    }
}
