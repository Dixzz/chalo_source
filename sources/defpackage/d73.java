package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class d73 implements o53 {
    public final String f = "phone";
    public final String g;
    public final String h;
    public final String i;

    public d73(String str, String str2, String str3) {
        gj1.j("phone");
        gj1.j(str);
        this.g = str;
        this.h = str2;
        this.i = str3;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        this.f.hashCode();
        jSONObject.put("mfaProvider", 1);
        jSONObject.put("mfaPendingCredential", this.g);
        JSONObject jSONObject2 = new JSONObject();
        String str = this.h;
        if (str != null) {
            jSONObject2.put("sessionInfo", str);
        }
        String str2 = this.i;
        if (str2 != null) {
            jSONObject2.put("code", str2);
        }
        jSONObject.put("phoneVerificationInfo", jSONObject2);
        return jSONObject.toString();
    }
}
