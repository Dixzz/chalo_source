package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: b73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class b73 implements o53 {
    public final String f = "phone";
    public String g;
    public final String h;
    public final String i;
    public final String j;

    public b73(String str, String str2, String str3, String str4) {
        gj1.j("phone");
        gj1.j(str);
        this.g = str;
        this.h = str2;
        this.j = str3;
        this.i = str4;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.g);
        this.f.hashCode();
        jSONObject.put("mfaProvider", 1);
        String str = this.i;
        if (str != null) {
            jSONObject.put(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, str);
        }
        JSONObject jSONObject2 = new JSONObject();
        String str2 = this.h;
        if (str2 != null) {
            jSONObject2.put("sessionInfo", str2);
        }
        String str3 = this.j;
        if (str3 != null) {
            jSONObject2.put("code", str3);
        }
        jSONObject.put("phoneVerificationInfo", jSONObject2);
        return jSONObject.toString();
    }
}
