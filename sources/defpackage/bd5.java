package defpackage;

import java.security.SecureRandom;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: bd5  reason: default package */
/* compiled from: SessionMetadata */
public class bd5 {

    /* renamed from: a  reason: collision with root package name */
    public long f414a;
    public long b;
    public long c;
    public String d;
    public SecureRandom e = new SecureRandom();

    public bd5() {
        b();
    }

    public final JSONObject a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$mp_event_id", Long.toHexString(this.e.nextLong()));
            jSONObject.put("$mp_session_id", this.d);
            jSONObject.put("$mp_session_seq_id", z ? this.f414a : this.b);
            jSONObject.put("$mp_session_start_sec", this.c);
            if (z) {
                this.f414a++;
            } else {
                this.b++;
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void b() {
        this.f414a = 0;
        this.b = 0;
        this.d = Long.toHexString(new SecureRandom().nextLong());
        this.c = System.currentTimeMillis() / 1000;
    }
}
