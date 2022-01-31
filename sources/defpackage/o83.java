package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: o83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class o83 implements p53<o83> {
    public static final String l = "o83";
    public String f;
    public String g;
    public long h;
    public boolean i;
    public String j;
    public String k;

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ o83 zza(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = hb2.a(jSONObject.optString("idToken", null));
            this.g = hb2.a(jSONObject.optString("refreshToken", null));
            this.h = jSONObject.optLong("expiresIn", 0);
            hb2.a(jSONObject.optString("localId", null));
            this.i = jSONObject.optBoolean("isNewUser", false);
            this.j = hb2.a(jSONObject.optString("temporaryProof", null));
            this.k = hb2.a(jSONObject.optString("phoneNumber", null));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, l, str);
        }
    }
}
