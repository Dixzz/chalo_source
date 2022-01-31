package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzwt extends AbstractSafeParcelable implements o53 {
    public static final Parcelable.Creator<zzwt> CREATOR = new v73();
    public final String f;
    public final long g;
    public final boolean h;
    public final String i;
    public final String j;
    public final String k;
    public final boolean l;
    public final String m;
    public u63 n;

    public zzwt(String str, long j2, boolean z, String str2, String str3, String str4, boolean z2, String str5) {
        gj1.j(str);
        this.f = str;
        this.g = j2;
        this.h = z;
        this.i = str2;
        this.j = str3;
        this.k = str4;
        this.l = z2;
        this.m = str5;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        long j2 = this.g;
        parcel.writeInt(524290);
        parcel.writeLong(j2);
        boolean z = this.h;
        parcel.writeInt(262147);
        parcel.writeInt(z ? 1 : 0);
        gj1.B0(parcel, 4, this.i, false);
        gj1.B0(parcel, 5, this.j, false);
        gj1.B0(parcel, 6, this.k, false);
        boolean z2 = this.l;
        parcel.writeInt(262151);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.B0(parcel, 8, this.m, false);
        gj1.H1(parcel, o1);
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("phoneNumber", this.f);
        String str = this.j;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        String str2 = this.k;
        if (str2 != null) {
            jSONObject.put("recaptchaToken", str2);
        }
        u63 u63 = this.n;
        if (u63 != null) {
            jSONObject.put("autoRetrievalInfo", u63.a());
        }
        String str3 = this.m;
        if (str3 != null) {
            jSONObject.put("safetyNetToken", str3);
        }
        return jSONObject.toString();
    }
}
