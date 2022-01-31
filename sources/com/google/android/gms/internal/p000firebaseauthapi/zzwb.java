package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzwb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwb> CREATOR = new k73();
    public final List<zzvz> f;

    public zzwb() {
        this.f = new ArrayList();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.F0(parcel, 2, this.f, false);
        gj1.H1(parcel, o1);
    }

    public zzwb(List<zzvz> list) {
        List<zzvz> list2;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.f = list2;
    }
}
