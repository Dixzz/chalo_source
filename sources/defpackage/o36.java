package defpackage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: o36  reason: default package */
/* compiled from: HandshakeData */
public class o36 {

    /* renamed from: a  reason: collision with root package name */
    public String f2648a;
    public String[] b;
    public long c;
    public long d;

    public o36(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray jSONArray = jSONObject.getJSONArray("upgrades");
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.getString(i);
        }
        this.f2648a = jSONObject.getString("sid");
        this.b = strArr;
        this.c = jSONObject.getLong("pingInterval");
        this.d = jSONObject.getLong("pingTimeout");
    }
}
