package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class Feature extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Feature> CREATOR = new rb2();
    public final String f;
    @Deprecated
    public final int g;
    public final long h;

    public Feature(@RecentlyNonNull String str, int i, long j) {
        this.f = str;
        this.g = i;
        this.h = j;
    }

    public Feature(@RecentlyNonNull String str, long j) {
        this.f = str;
        this.h = j;
        this.g = -1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.f;
            if (((str == null || !str.equals(feature.f)) && (this.f != null || feature.f != null)) || l1() != feature.l1()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f, Long.valueOf(l1())});
    }

    public long l1() {
        long j = this.h;
        return j == -1 ? (long) this.g : j;
    }

    @RecentlyNonNull
    public final String toString() {
        g82 g82 = new g82(this);
        g82.a("name", this.f);
        g82.a("version", Long.valueOf(l1()));
        return g82.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        int i2 = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        long l1 = l1();
        parcel.writeInt(524291);
        parcel.writeLong(l1);
        gj1.H1(parcel, o1);
    }
}
