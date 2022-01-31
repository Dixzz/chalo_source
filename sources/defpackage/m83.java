package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.google.android.gms.internal.p000firebaseauthapi.zzwk;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: m83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class m83 implements p53<m83> {
    public static final String k = "m83";
    public String f;
    public String g;
    public long h;
    public List<zzwk> i;
    public String j;

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ m83 zza(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            hb2.a(jSONObject.optString("localId", null));
            hb2.a(jSONObject.optString("email", null));
            hb2.a(jSONObject.optString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, null));
            this.f = hb2.a(jSONObject.optString("idToken", null));
            hb2.a(jSONObject.optString("photoUrl", null));
            this.g = hb2.a(jSONObject.optString("refreshToken", null));
            this.h = jSONObject.optLong("expiresIn", 0);
            this.i = zzwk.m1(jSONObject.optJSONArray("mfaInfo"));
            this.j = jSONObject.optString("mfaPendingCredential", null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, k, str);
        }
    }
}
