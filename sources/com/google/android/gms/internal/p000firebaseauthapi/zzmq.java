package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzmq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmq> CREATOR = new ty2();
    public final zzxg f;

    public zzmq(zzxg zzxg) {
        this.f = zzxg;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.f, i, false);
        gj1.H1(parcel, o1);
    }
}
