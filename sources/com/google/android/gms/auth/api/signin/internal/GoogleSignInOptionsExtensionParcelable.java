package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new j02();
    public final int f;
    public int g;
    public Bundle h;

    public GoogleSignInOptionsExtensionParcelable(int i, int i2, Bundle bundle) {
        this.f = i;
        this.g = i2;
        this.h = bundle;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        gj1.t0(parcel, 3, this.h, false);
        gj1.H1(parcel, o1);
    }
}
