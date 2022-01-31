package defpackage;

import com.razorpay.AnalyticsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: j83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class j83 implements o53 {
    public final String f;
    public final String g;

    public j83(String str, String str2) {
        gj1.j(str);
        this.f = str;
        this.g = str2;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AnalyticsConstants.TOKEN, this.f);
        jSONObject.put("returnSecureToken", true);
        String str = this.g;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        return jSONObject.toString();
    }
}
