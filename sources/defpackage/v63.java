package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: v63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class v63 implements p53<v63> {
    public String f;

    public final v63 a(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("error"));
            jSONObject.getInt("code");
            this.f = jSONObject.getString("message");
            return this;
        } catch (NullPointerException | JSONException e) {
            String message = e.getMessage();
            String.valueOf(str).length();
            String.valueOf(message).length();
            throw new e13(hj1.b0(new StringBuilder(String.valueOf(str).length() + 35), "Failed to parse error for string [", str, "]"), e);
        }
    }

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ v63 zza(String str) throws e13 {
        a(str);
        return this;
    }
}
