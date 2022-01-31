package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxe  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzxe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxe> CREATOR = new g83();
    public final int f;
    public List<String> g;

    public zzxe() {
        this(null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        gj1.D0(parcel, 2, this.g, false);
        gj1.H1(parcel, o1);
    }

    public zzxe(int i, List<String> list) {
        this.f = i;
        if (list == null || list.isEmpty()) {
            this.g = Collections.emptyList();
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.set(i2, hb2.a(list.get(i2)));
        }
        this.g = Collections.unmodifiableList(list);
    }

    public zzxe(List<String> list) {
        this.f = 1;
        this.g = new ArrayList();
        if (list != null && !list.isEmpty()) {
            this.g.addAll(list);
        }
    }
}
