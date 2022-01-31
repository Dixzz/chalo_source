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

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzwk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwk> CREATOR = new q73();
    public final String f;
    public final String g;
    public final String h;
    public final long i;

    public zzwk(String str, String str2, String str3, long j) {
        this.f = str;
        gj1.j(str2);
        this.g = str2;
        this.h = str3;
        this.i = j;
    }

    public static zzwk l1(JSONObject jSONObject) {
        JSONObject optJSONObject;
        String optString = jSONObject.optString("phoneInfo", null);
        String optString2 = jSONObject.optString("mfaEnrollmentId", null);
        String optString3 = jSONObject.optString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, null);
        long j = 0;
        if (jSONObject.has("enrolledAt") && (optJSONObject = jSONObject.optJSONObject("enrolledAt")) != null && optJSONObject.has("seconds")) {
            j = optJSONObject.optLong("seconds", 0);
        }
        zzwk zzwk = new zzwk(optString, optString2, optString3, j);
        jSONObject.optString("unobfuscatedPhoneInfo");
        return zzwk;
    }

    public static List<zzwk> m1(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(l1(jSONArray.getJSONObject(i2)));
        }
        return arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 1, this.f, false);
        gj1.B0(parcel, 2, this.g, false);
        gj1.B0(parcel, 3, this.h, false);
        long j = this.i;
        parcel.writeInt(524292);
        parcel.writeLong(j);
        gj1.H1(parcel, o1);
    }
}
