package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: h73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class h73 implements o53 {
    public final String f;

    public h73(String str) {
        gj1.j(str);
        this.f = str;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.f);
        return jSONObject.toString();
    }
}
