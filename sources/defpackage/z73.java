package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: z73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class z73 implements o53 {
    public String f;
    public String g;
    public final String h;

    public z73(String str) {
        this.h = str;
    }

    public z73(String str, String str2, String str3) {
        gj1.j(str);
        this.f = str;
        gj1.j(str2);
        this.g = str2;
        this.h = str3;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.f;
        if (str != null) {
            jSONObject.put("email", str);
        }
        String str2 = this.g;
        if (str2 != null) {
            jSONObject.put("password", str2);
        }
        String str3 = this.h;
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        return jSONObject.toString();
    }
}
