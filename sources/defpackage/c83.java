package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: c83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class c83 implements o53 {
    public final String f;
    public final String g = "phone";
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public u63 l;

    public c83(String str, String str2, String str3, String str4, String str5) {
        gj1.j(str);
        this.f = str;
        gj1.j("phone");
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = str5;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.f);
        this.g.hashCode();
        jSONObject.put("mfaProvider", 1);
        if (this.h != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("phoneNumber", this.h);
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject2.put("recaptchaToken", this.j);
            }
            if (!TextUtils.isEmpty(this.k)) {
                jSONObject2.put("safetyNetToken", this.k);
            }
            u63 u63 = this.l;
            if (u63 != null) {
                jSONObject2.put("autoRetrievalInfo", u63.a());
            }
            jSONObject.put("phoneEnrollmentInfo", jSONObject2);
        }
        return jSONObject.toString();
    }
}
