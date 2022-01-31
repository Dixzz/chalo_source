package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: w73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class w73 implements p53<w73> {
    public static final String g = "w73";
    public String f;

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ w73 zza(String str) throws e13 {
        try {
            this.f = hb2.a(new JSONObject(str).optString("sessionInfo", null));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, g, str);
        }
    }
}
