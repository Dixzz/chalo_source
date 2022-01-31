package defpackage;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: p73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class p73 {

    /* renamed from: a  reason: collision with root package name */
    public Long f2776a;
    public Long b;

    public static p73 a(String str) throws UnsupportedEncodingException {
        try {
            p73 p73 = new p73();
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("iss");
            jSONObject.optString("aud");
            jSONObject.optString("sub");
            p73.f2776a = Long.valueOf(jSONObject.optLong("iat"));
            p73.b = Long.valueOf(jSONObject.optLong("exp"));
            jSONObject.optBoolean("is_anonymous");
            return p73;
        } catch (JSONException e) {
            if (Log.isLoggable("JwtToken", 3)) {
                String.valueOf(e).length();
            }
            String valueOf = String.valueOf(e);
            throw new UnsupportedEncodingException(hj1.a0(new StringBuilder(valueOf.length() + 41), "Failed to read JwtToken from JSONObject. ", valueOf));
        }
    }
}
