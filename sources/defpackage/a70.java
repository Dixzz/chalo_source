package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: a70  reason: default package */
/* compiled from: DataAndHeaders */
public class a70 {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f128a;
    public JSONObject b;
    public int c;

    public a70(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data")) {
                this.f128a = jSONObject.getJSONObject("data");
            }
            if (jSONObject.has("headers")) {
                this.b = jSONObject.getJSONObject("headers");
            }
            if (jSONObject.has("statusCode")) {
                this.c = jSONObject.getInt("statusCode");
            }
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            b00.a().b(new Throwable(e));
            e.printStackTrace();
        }
    }
}
