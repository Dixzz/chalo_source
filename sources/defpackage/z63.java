package defpackage;

import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: z63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class z63 implements o53 {
    public final String f;
    public final String g;
    public final String h;

    static {
        new wa2(z63.class.getSimpleName(), new String[0]);
    }

    public z63(EmailAuthCredential emailAuthCredential, String str) {
        String zzb = emailAuthCredential.zzb();
        gj1.j(zzb);
        this.f = zzb;
        String zzd = emailAuthCredential.zzd();
        gj1.j(zzd);
        this.g = zzd;
        this.h = str;
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(this.g);
        String str = null;
        String code = parseLink != null ? parseLink.getCode() : null;
        if (parseLink != null) {
            str = parseLink.zza();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.f);
        if (code != null) {
            jSONObject.put("oobCode", code);
        }
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        String str2 = this.h;
        if (str2 != null) {
            jSONObject.put("idToken", str2);
        }
        return jSONObject.toString();
    }
}
