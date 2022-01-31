package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: a83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class a83 implements p53<a83> {
    public static final String i = "a83";
    public String f;
    public String g;
    public long h;

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ a83 zza(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = hb2.a(jSONObject.optString("idToken", null));
            hb2.a(jSONObject.optString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, null));
            hb2.a(jSONObject.optString("email", null));
            this.g = hb2.a(jSONObject.optString("refreshToken", null));
            this.h = jSONObject.optLong("expiresIn", 0);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, i, str);
        }
    }
}
