package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: e83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class e83 implements o53 {
    public final String f = "phone";
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public u63 m;

    public e83(String str, String str2, String str3, String str4, String str5, String str6) {
        gj1.j("phone");
        gj1.j(str);
        this.g = str;
        gj1.j(str2);
        this.h = str2;
        this.j = str3;
        this.i = str4;
        this.k = str5;
        this.l = str6;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mfaPendingCredential", this.g);
        jSONObject.put("mfaEnrollmentId", this.h);
        this.f.hashCode();
        jSONObject.put("mfaProvider", 1);
        if (this.j != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("phoneNumber", this.j);
            if (!TextUtils.isEmpty(this.k)) {
                jSONObject2.put("recaptchaToken", this.k);
            }
            if (!TextUtils.isEmpty(this.l)) {
                jSONObject2.put("safetyNetToken", this.l);
            }
            u63 u63 = this.m;
            if (u63 != null) {
                jSONObject2.put("autoRetrievalInfo", u63.a());
            }
            jSONObject.put("phoneSignInInfo", jSONObject2);
        }
        return jSONObject.toString();
    }
}
