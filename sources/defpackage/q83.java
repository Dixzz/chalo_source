package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: q83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class q83 implements p53<q83> {
    public static final String h = "q83";
    public String f;
    public String g;

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ q83 zza(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = hb2.a(jSONObject.optString("idToken", null));
            this.g = hb2.a(jSONObject.optString("refreshToken", null));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, h, str);
        }
    }
}
