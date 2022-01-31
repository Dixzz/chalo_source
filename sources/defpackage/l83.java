package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: l83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class l83 implements o53 {
    public final String f;
    public final String g;
    public final String h;

    public l83(String str, String str2, String str3) {
        gj1.j(str);
        this.f = str;
        gj1.j(str2);
        this.g = str2;
        this.h = str3;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.f);
        jSONObject.put("password", this.g);
        jSONObject.put("returnSecureToken", true);
        String str = this.h;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        return jSONObject.toString();
    }
}
