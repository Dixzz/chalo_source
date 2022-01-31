package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: t73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class t73 implements o53 {
    public final String f;
    public final String g;
    public final String h;

    public t73(String str, String str2, String str3) {
        gj1.j(str);
        this.f = str;
        this.g = str2;
        this.h = str3;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("oobCode", this.f);
        String str = this.g;
        if (str != null) {
            jSONObject.put("newPassword", str);
        }
        String str2 = this.h;
        if (str2 != null) {
            jSONObject.put("tenantId", str2);
        }
        return jSONObject.toString();
    }
}
