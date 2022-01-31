package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzxk extends AbstractSafeParcelable implements p53<zzxk> {
    public static final Parcelable.Creator<zzxk> CREATOR = new k83();
    public static final String j = zzxk.class.getSimpleName();
    public String f;
    public String g;
    public long h;
    public boolean i;

    public zzxk() {
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.B0(parcel, 3, this.g, false);
        long j2 = this.h;
        parcel.writeInt(524292);
        parcel.writeLong(j2);
        boolean z = this.i;
        parcel.writeInt(262149);
        parcel.writeInt(z ? 1 : 0);
        gj1.H1(parcel, o1);
    }

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ zzxk zza(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = hb2.a(jSONObject.optString("idToken", null));
            this.g = hb2.a(jSONObject.optString("refreshToken", null));
            this.h = jSONObject.optLong("expiresIn", 0);
            this.i = jSONObject.optBoolean("isNewUser", false);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, j, str);
        }
    }

    public zzxk(String str, String str2, long j2, boolean z) {
        this.f = str;
        this.g = str2;
        this.h = j2;
        this.i = z;
    }
}
