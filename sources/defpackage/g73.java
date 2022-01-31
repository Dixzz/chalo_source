package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: g73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class g73 implements o53 {
    public final String f = f73.REFRESH_TOKEN.toString();
    public final String g;

    public g73(String str) {
        gj1.j(str);
        this.g = str;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("grantType", this.f);
        jSONObject.put("refreshToken", this.g);
        return jSONObject.toString();
    }
}
