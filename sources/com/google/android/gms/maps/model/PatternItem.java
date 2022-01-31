package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PatternItem> CREATOR = new zzi();
    private static final String TAG = PatternItem.class.getSimpleName();
    private final int type;
    private final Float zzdv;

    public PatternItem(int i, Float f) {
        boolean z = true;
        if (i != 1 && (f == null || f.floatValue() < 0.0f)) {
            z = false;
        }
        String valueOf = String.valueOf(f);
        StringBuilder sb = new StringBuilder(valueOf.length() + 45);
        sb.append("Invalid PatternItem: type=");
        sb.append(i);
        sb.append(" length=");
        sb.append(valueOf);
        gj1.c(z, sb.toString());
        this.type = i;
        this.zzdv = f;
    }

    public static List<PatternItem> zza(List<PatternItem> list) {
        PatternItem patternItem;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (PatternItem patternItem2 : list) {
            if (patternItem2 == null) {
                patternItem2 = null;
            } else {
                int i = patternItem2.type;
                if (i == 0) {
                    patternItem = new Dash(patternItem2.zzdv.floatValue());
                } else if (i == 1) {
                    patternItem2 = new Dot();
                } else if (i == 2) {
                    patternItem = new Gap(patternItem2.zzdv.floatValue());
                }
                patternItem2 = patternItem;
            }
            arrayList.add(patternItem2);
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        return this.type == patternItem.type && gj1.G(this.zzdv, patternItem.zzdv);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.type), this.zzdv});
    }

    public String toString() {
        int i = this.type;
        String valueOf = String.valueOf(this.zzdv);
        StringBuilder sb = new StringBuilder(valueOf.length() + 39);
        sb.append("[PatternItem: type=");
        sb.append(i);
        sb.append(" length=");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.type;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        gj1.w0(parcel, 3, this.zzdv, false);
        gj1.H1(parcel, o1);
    }
}
