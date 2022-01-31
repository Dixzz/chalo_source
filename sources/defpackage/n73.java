package defpackage;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: n73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class n73 implements p53<n73> {
    public static final String g = "n73";
    public List<String> f;

    public final n73 a(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("authorizedDomains");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.f.add(optJSONArray.getString(i));
                }
            }
            return this;
        } catch (JSONException e) {
            throw gj1.r1(e, g, str);
        }
    }

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ n73 zza(String str) throws e13 {
        a(str);
        return this;
    }
}
