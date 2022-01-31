package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.zze;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zznq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznq> CREATOR = new gz2();
    public final String f;
    public final List<zzwk> g;
    public final zze h;

    public zznq(String str, List<zzwk> list, zze zze) {
        this.f = str;
        this.g = list;
        this.h = zze;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.F0(parcel, 2, this.g, false);
        gj1.A0(parcel, 3, this.h, i, false);
        gj1.H1(parcel, o1);
    }
}
