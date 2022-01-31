package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzwk;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: a73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class a73 implements p53<a73> {
    public static final String l = "a73";
    public String f;
    public String g;
    public boolean h;
    public long i;
    public List<zzwk> j;
    public String k;

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ a73 zza(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("localId", null);
            jSONObject.optString("email", null);
            this.f = jSONObject.optString("idToken", null);
            this.g = jSONObject.optString("refreshToken", null);
            this.h = jSONObject.optBoolean("isNewUser", false);
            this.i = jSONObject.optLong("expiresIn", 0);
            this.j = zzwk.m1(jSONObject.optJSONArray("mfaInfo"));
            this.k = jSONObject.optString("mfaPendingCredential", null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, l, str);
        }
    }
}
