package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: n83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class n83 implements o53 {
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public boolean k;

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.i)) {
            jSONObject.put("phoneNumber", this.f);
            jSONObject.put("temporaryProof", this.i);
        } else {
            jSONObject.put("sessionInfo", this.g);
            jSONObject.put("code", this.h);
        }
        String str = this.j;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.k) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }
}
