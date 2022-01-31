package defpackage;

import com.google.firebase.messaging.Constants;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: hr5  reason: default package */
/* compiled from: InAppMessageEvent */
public abstract class hr5 extends ll5 {
    public final String h;
    public final String i;
    public final JsonValue j;

    public hr5(String str, String str2, JsonValue jsonValue) {
        this.h = str;
        this.i = str2;
        this.j = jsonValue;
    }

    @Override // defpackage.ll5
    public zt5 d() {
        JsonValue jsonValue;
        String str = "app-defined";
        boolean equals = str.equals(this.i);
        zt5.b s = zt5.s();
        String str2 = this.h;
        String str3 = this.i;
        JsonValue jsonValue2 = this.j;
        str3.hashCode();
        int hashCode = str3.hashCode();
        char c = 65535;
        if (hashCode != -2115218223) {
            if (hashCode != -949613987) {
                if (hashCode == 2072105630 && str3.equals("legacy-push")) {
                    c = 2;
                }
            } else if (str3.equals(str)) {
                c = 1;
            }
        } else if (str3.equals("remote-data")) {
            c = 0;
        }
        if (c == 0) {
            zt5.b s2 = zt5.s();
            s2.f(Constants.MessagePayloadKeys.MSGID_SERVER, str2);
            s2.e("campaigns", jsonValue2);
            jsonValue = JsonValue.x(s2.a());
        } else if (c == 1) {
            zt5.b s3 = zt5.s();
            s3.f(Constants.MessagePayloadKeys.MSGID_SERVER, str2);
            jsonValue = JsonValue.x(s3.a());
        } else if (c != 2) {
            jsonValue = JsonValue.g;
        } else {
            jsonValue = JsonValue.x(str2);
        }
        s.e("id", jsonValue);
        if (!equals) {
            str = "urban-airship";
        }
        s.f("source", str);
        s.i("conversion_send_id", UAirship.l().f.r);
        s.i("conversion_metadata", UAirship.l().f.s);
        return i(s).a();
    }

    public abstract zt5.b i(zt5.b bVar);
}
