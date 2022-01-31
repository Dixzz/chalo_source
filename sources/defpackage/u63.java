package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: u63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class u63 {

    /* renamed from: a  reason: collision with root package name */
    public final String f3462a;

    public u63(String str) {
        gj1.j(str);
        this.f3462a = str;
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appSignatureHash", this.f3462a);
        return jSONObject;
    }
}
