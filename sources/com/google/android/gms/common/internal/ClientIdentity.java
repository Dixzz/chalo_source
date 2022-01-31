package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class ClientIdentity extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new a92();
    public final int f;
    @RecentlyNullable
    public final String g;

    public ClientIdentity(int i, String str) {
        this.f = i;
        this.g = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f == this.f && gj1.G(clientIdentity.g, this.g);
    }

    public final int hashCode() {
        return this.f;
    }

    @RecentlyNonNull
    public final String toString() {
        int i = this.f;
        String str = this.g;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i);
        sb.append(ProductDiscountsObject.KEY_DELIMITER);
        sb.append(str);
        return sb.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        gj1.B0(parcel, 2, this.g, false);
        gj1.H1(parcel, o1);
    }
}
