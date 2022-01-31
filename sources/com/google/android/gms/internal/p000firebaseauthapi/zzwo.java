package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzwo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwo> CREATOR = new s73();
    public final List<zzwm> f;

    public zzwo() {
        this.f = new ArrayList();
    }

    public static zzwo l1(JSONArray jSONArray) throws JSONException {
        zzwm zzwm;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzwo(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject == null) {
                zzwm = new zzwm();
            } else {
                zzwm = new zzwm(hb2.a(jSONObject.optString("federatedId", null)), hb2.a(jSONObject.optString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, null)), hb2.a(jSONObject.optString("photoUrl", null)), hb2.a(jSONObject.optString("providerId", null)), null, hb2.a(jSONObject.optString("phoneNumber", null)), hb2.a(jSONObject.optString("email", null)));
            }
            arrayList.add(zzwm);
        }
        return new zzwo(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.F0(parcel, 2, this.f, false);
        gj1.H1(parcel, o1);
    }

    public zzwo(List<zzwm> list) {
        if (list == null || list.isEmpty()) {
            this.f = Collections.emptyList();
        } else {
            this.f = Collections.unmodifiableList(list);
        }
    }
}
