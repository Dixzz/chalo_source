package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class zag extends AbstractSafeParcelable implements f32 {
    public static final Parcelable.Creator<zag> CREATOR = new gi4();
    public final List<String> f;
    public final String g;

    public zag(List<String> list, String str) {
        this.f = list;
        this.g = str;
    }

    @Override // defpackage.f32
    public final Status M0() {
        if (this.g != null) {
            return Status.k;
        }
        return Status.o;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.D0(parcel, 1, this.f, false);
        gj1.B0(parcel, 2, this.g, false);
        gj1.H1(parcel, o1);
    }
}
