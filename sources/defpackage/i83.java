package defpackage;

import android.text.TextUtils;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.google.android.gms.internal.p000firebaseauthapi.zzwk;
import com.google.firebase.auth.zze;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: i83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class i83 implements p53<i83> {
    public static final String v = "i83";
    public boolean f;
    public String g;
    public String h;
    public long i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public List<zzwk> t;
    public String u;

    public final zze a() {
        if (!TextUtils.isEmpty(this.n) || !TextUtils.isEmpty(this.o)) {
            return zze.zzb(this.k, this.o, this.n, this.r, this.p);
        }
        return null;
    }

    /* Return type fixed from 'p53' to match base method */
    @Override // defpackage.p53
    public final /* bridge */ /* synthetic */ i83 zza(String str) throws e13 {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = jSONObject.optBoolean("needConfirmation", false);
            jSONObject.optBoolean("needEmail", false);
            this.g = hb2.a(jSONObject.optString("idToken", null));
            this.h = hb2.a(jSONObject.optString("refreshToken", null));
            this.i = jSONObject.optLong("expiresIn", 0);
            hb2.a(jSONObject.optString("localId", null));
            this.j = hb2.a(jSONObject.optString("email", null));
            hb2.a(jSONObject.optString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, null));
            hb2.a(jSONObject.optString("photoUrl", null));
            this.k = hb2.a(jSONObject.optString("providerId", null));
            this.l = hb2.a(jSONObject.optString("rawUserInfo", null));
            this.m = jSONObject.optBoolean("isNewUser", false);
            this.n = jSONObject.optString("oauthAccessToken", null);
            this.o = jSONObject.optString("oauthIdToken", null);
            this.q = hb2.a(jSONObject.optString("errorMessage", null));
            this.r = hb2.a(jSONObject.optString("pendingToken", null));
            this.s = hb2.a(jSONObject.optString("tenantId", null));
            this.t = zzwk.m1(jSONObject.optJSONArray("mfaInfo"));
            this.u = hb2.a(jSONObject.optString("mfaPendingCredential", null));
            this.p = hb2.a(jSONObject.optString("oauthTokenSecret", null));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw gj1.r1(e, v, str);
        }
    }
}
