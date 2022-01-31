package defpackage;

import com.freshchat.consumer.sdk.beans.User;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.Locale;

/* renamed from: eo5  reason: default package */
/* compiled from: StateOverrides */
public class eo5 implements cu5 {
    public final String f;
    public final boolean g;
    public final String h;
    public final String i;

    public eo5(String str, String str2, boolean z, Locale locale) {
        this.f = str;
        this.g = z;
        this.h = locale.getLanguage();
        this.i = locale.getCountry();
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.f(User.DEVICE_META_APP_VERSION_NAME, this.f);
        s.f("sdk_version", "14.6.0");
        zt5.b g2 = s.g("notification_opt_in", this.g);
        g2.f("locale_language", this.h);
        g2.f("locale_country", this.i);
        return JsonValue.x(g2.a());
    }
}
