package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: e73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class e73 implements p53<e73> {
    public static final String h = "e73";
    public String f;
    public String g;

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ e73 zza(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = jSONObject.optString("idToken", null);
            this.g = jSONObject.optString("refreshToken", null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, h, str);
        }
    }
}
