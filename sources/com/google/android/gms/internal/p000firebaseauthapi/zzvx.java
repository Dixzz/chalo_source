package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzvx extends AbstractSafeParcelable implements p53<zzvx> {
    public static final Parcelable.Creator<zzvx> CREATOR = new i73();
    public static final String g = zzvx.class.getSimpleName();
    public zzwb f;

    public zzvx() {
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 2, this.f, i, false);
        gj1.H1(parcel, o1);
    }

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ zzvx zza(String str) throws e13 {
        zzwb zzwb;
        int i;
        zzvz zzvz;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("users")) {
                zzwb = new zzwb();
            } else {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                if (optJSONArray != null) {
                    if (optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        boolean z = false;
                        int i2 = 0;
                        while (i2 < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            if (jSONObject2 == null) {
                                zzvz = new zzvz();
                                i = i2;
                            } else {
                                i = i2;
                                zzvz = new zzvz(hb2.a(jSONObject2.optString("localId", null)), hb2.a(jSONObject2.optString("email", null)), jSONObject2.optBoolean("emailVerified", z), hb2.a(jSONObject2.optString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, null)), hb2.a(jSONObject2.optString("photoUrl", null)), zzwo.l1(jSONObject2.optJSONArray("providerUserInfo")), hb2.a(jSONObject2.optString("rawPassword", null)), hb2.a(jSONObject2.optString("phoneNumber", null)), jSONObject2.optLong("createdAt", 0), jSONObject2.optLong("lastLoginAt", 0), false, null, zzwk.m1(jSONObject2.optJSONArray("mfaInfo")));
                            }
                            arrayList.add(zzvz);
                            i2 = i + 1;
                            z = false;
                        }
                        zzwb = new zzwb(arrayList);
                    }
                }
                zzwb = new zzwb(new ArrayList());
            }
            this.f = zzwb;
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, g, str);
        }
    }

    public zzvx(zzwb zzwb) {
        zzwb zzwb2;
        if (zzwb == null) {
            zzwb2 = new zzwb();
        } else {
            List<zzvz> list = zzwb.f;
            zzwb zzwb3 = new zzwb();
            if (list != null && !list.isEmpty()) {
                zzwb3.f.addAll(list);
            }
            zzwb2 = zzwb3;
        }
        this.f = zzwb2;
    }
}
