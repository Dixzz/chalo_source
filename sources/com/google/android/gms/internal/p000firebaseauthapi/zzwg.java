package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzwg extends AbstractSafeParcelable implements p53<zzwg> {
    public static final Parcelable.Creator<zzwg> CREATOR = new o73();
    public static final String k = zzwg.class.getSimpleName();
    public String f;
    public String g;
    public Long h;
    public String i;
    public Long j;

    public zzwg() {
        this.j = Long.valueOf(System.currentTimeMillis());
    }

    public static zzwg m1(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzwg zzwg = new zzwg();
            zzwg.f = jSONObject.optString("refresh_token", null);
            zzwg.g = jSONObject.optString("access_token", null);
            zzwg.h = Long.valueOf(jSONObject.optLong("expires_in"));
            zzwg.i = jSONObject.optString("token_type", null);
            zzwg.j = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzwg;
        } catch (JSONException e) {
            throw new xx2(e);
        }
    }

    public final String l1() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.f);
            jSONObject.put("access_token", this.g);
            jSONObject.put("expires_in", this.h);
            jSONObject.put("token_type", this.i);
            jSONObject.put("issued_at", this.j);
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new xx2(e);
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        long j2;
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.B0(parcel, 3, this.g, false);
        Long l = this.h;
        if (l == null) {
            j2 = 0;
        } else {
            j2 = l.longValue();
        }
        gj1.z0(parcel, 4, Long.valueOf(j2), false);
        gj1.B0(parcel, 5, this.i, false);
        gj1.z0(parcel, 6, Long.valueOf(this.j.longValue()), false);
        gj1.H1(parcel, o1);
    }

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ zzwg zza(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = hb2.a(jSONObject.optString("refresh_token"));
            this.g = hb2.a(jSONObject.optString("access_token"));
            this.h = Long.valueOf(jSONObject.optLong("expires_in", 0));
            this.i = hb2.a(jSONObject.optString("token_type"));
            this.j = Long.valueOf(System.currentTimeMillis());
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, k, str);
        }
    }

    public final boolean zzb() {
        return System.currentTimeMillis() + DefaultRefreshIntervals.RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL < (this.h.longValue() * 1000) + this.j.longValue();
    }

    public zzwg(String str, String str2, Long l, String str3) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.f = str;
        this.g = str2;
        this.h = l;
        this.i = str3;
        this.j = valueOf;
    }

    public zzwg(String str, String str2, Long l, String str3, Long l2) {
        this.f = str;
        this.g = str2;
        this.h = l;
        this.i = str3;
        this.j = l2;
    }
}
