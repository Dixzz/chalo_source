package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzwr extends AbstractSafeParcelable implements p53<zzwr> {
    public static final Parcelable.Creator<zzwr> CREATOR = new u73();
    public static final String j = zzwr.class.getSimpleName();
    public String f;
    public String g;
    public String h;
    public zzwk i;

    public zzwr() {
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.B0(parcel, 3, this.g, false);
        gj1.B0(parcel, 4, this.h, false);
        gj1.A0(parcel, 5, this.i, i2, false);
        gj1.H1(parcel, o1);
    }

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ zzwr zza(String str) throws e13 {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = hb2.a(jSONObject.optString("email"));
            this.g = hb2.a(jSONObject.optString("newEmail"));
            int optInt = jSONObject.optInt("reqType");
            if (optInt != 1) {
                switch (optInt) {
                    case 4:
                        str2 = "VERIFY_EMAIL";
                        break;
                    case 5:
                        str2 = "RECOVER_EMAIL";
                        break;
                    case 6:
                        str2 = "EMAIL_SIGNIN";
                        break;
                    case 7:
                        str2 = "VERIFY_BEFORE_UPDATE_EMAIL";
                        break;
                    case 8:
                        str2 = "REVERT_SECOND_FACTOR_ADDITION";
                        break;
                    default:
                        str2 = null;
                        break;
                }
            } else {
                str2 = "PASSWORD_RESET";
            }
            this.h = str2;
            if (jSONObject.has("mfaInfo")) {
                this.i = zzwk.l1(jSONObject.optJSONObject("mfaInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, j, str);
        }
    }

    public zzwr(String str, String str2, String str3, zzwk zzwk) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = zzwk;
    }
}
