package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: sx5  reason: default package */
/* compiled from: RemoteAirshipConfig */
public class sx5 implements cu5 {
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;

    public sx5(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = str6;
    }

    public static sx5 a(JsonValue jsonValue) {
        zt5 n = jsonValue.n();
        return new sx5(n.u("remote_data_url").i(), n.u("device_api_url").i(), n.u("wallet_url").i(), n.u("analytics_url").i(), n.u("chat_url").i(), n.u("chat_socket_url").i());
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.f("remote_data_url", this.f);
        s.f("device_api_url", this.g);
        s.f("analytics_url", this.i);
        s.f("wallet_url", this.h);
        s.f("chat_url", this.j);
        s.f("chat_socket_url", this.k);
        return JsonValue.x(s.a());
    }
}
