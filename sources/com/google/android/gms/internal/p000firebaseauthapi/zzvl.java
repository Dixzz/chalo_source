package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzvl extends AbstractSafeParcelable implements p53<zzvl> {
    public static final Parcelable.Creator<zzvl> CREATOR = new x63();
    public static final String l = zzvl.class.getSimpleName();
    public String f;
    public boolean g;
    public String h;
    public boolean i;
    public zzxe j;
    public List<String> k;

    public zzvl() {
        this.j = new zzxe(null);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        boolean z = this.g;
        parcel.writeInt(262147);
        parcel.writeInt(z ? 1 : 0);
        gj1.B0(parcel, 4, this.h, false);
        boolean z2 = this.i;
        parcel.writeInt(262149);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.A0(parcel, 6, this.j, i2, false);
        gj1.D0(parcel, 7, this.k, false);
        gj1.H1(parcel, o1);
    }

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ zzvl zza(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = jSONObject.optString("authUri", null);
            this.g = jSONObject.optBoolean("registered", false);
            this.h = jSONObject.optString("providerId", null);
            this.i = jSONObject.optBoolean("forExistingProvider", false);
            if (!jSONObject.has("allProviders")) {
                this.j = new zzxe(null);
            } else {
                this.j = new zzxe(1, gj1.W0(jSONObject.optJSONArray("allProviders")));
            }
            this.k = gj1.W0(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, l, str);
        }
    }

    public zzvl(String str, boolean z, String str2, boolean z2, zzxe zzxe, List<String> list) {
        zzxe zzxe2;
        this.f = str;
        this.g = z;
        this.h = str2;
        this.i = z2;
        if (zzxe == null) {
            zzxe2 = new zzxe(null);
        } else {
            zzxe2 = new zzxe(zzxe.g);
        }
        this.j = zzxe2;
        this.k = list;
    }
}
