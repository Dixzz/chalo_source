package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: f83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class f83 implements p53<f83> {
    public static final String g = "f83";
    public String f;

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ f83 zza(String str) throws e13 {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneResponseInfo");
            if (optJSONObject != null) {
                this.f = hb2.a(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, g, str);
        }
    }
}
