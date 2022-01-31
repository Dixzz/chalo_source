package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Scope> CREATOR = new m72();
    public final int f;
    public final String g;

    public Scope(@RecentlyNonNull String str) {
        gj1.i(str, "scopeUri must not be null or empty");
        this.f = 1;
        this.g = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.g.equals(((Scope) obj).g);
    }

    public int hashCode() {
        return this.g.hashCode();
    }

    @RecentlyNonNull
    public String toString() {
        return this.g;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        gj1.B0(parcel, 2, this.g, false);
        gj1.H1(parcel, o1);
    }

    public Scope(int i, String str) {
        gj1.i(str, "scopeUri must not be null or empty");
        this.f = i;
        this.g = str;
    }
}
