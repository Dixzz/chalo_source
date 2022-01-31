package defpackage;

import defpackage.yj1;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: lk1  reason: default package */
/* compiled from: JsonObjectRequest */
public class lk1 extends mk1<JSONObject> {
    public lk1(String str, JSONObject jSONObject, yj1.b<JSONObject> bVar, yj1.a aVar) {
        super(0, str, null, bVar, aVar);
    }

    @Override // defpackage.wj1
    public yj1<JSONObject> A(tj1 tj1) {
        try {
            return new yj1<>(new JSONObject(new String(tj1.b, gj1.X(tj1.c, "utf-8"))), gj1.W(tj1));
        } catch (UnsupportedEncodingException e) {
            return new yj1<>(new vj1(e));
        } catch (JSONException e2) {
            return new yj1<>(new vj1(e2));
        }
    }
}
