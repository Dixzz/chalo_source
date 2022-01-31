package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: p83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class p83 implements o53 {
    public final String f;
    public final String g;

    public p83(String str, String str2) {
        gj1.j(str);
        this.f = str;
        gj1.j(str2);
        this.g = str2;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.f);
        jSONObject.put("mfaEnrollmentId", this.g);
        return jSONObject.toString();
    }
}
