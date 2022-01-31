package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.google.android.gms.internal.p000firebaseauthapi.zzwo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: y73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class y73 implements p53<y73> {
    public static final String k = "y73";
    public String f;
    public zzwo g;
    public String h;
    public String i;
    public long j;

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ y73 zza(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = hb2.a(jSONObject.optString("email", null));
            hb2.a(jSONObject.optString("passwordHash", null));
            jSONObject.optBoolean("emailVerified", false);
            hb2.a(jSONObject.optString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, null));
            hb2.a(jSONObject.optString("photoUrl", null));
            this.g = zzwo.l1(jSONObject.optJSONArray("providerUserInfo"));
            this.h = hb2.a(jSONObject.optString("idToken", null));
            this.i = hb2.a(jSONObject.optString("refreshToken", null));
            this.j = jSONObject.optLong("expiresIn", 0);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, k, str);
        }
    }
}
