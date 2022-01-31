package defpackage;

import android.os.Bundle;
import defpackage.zt5;

/* renamed from: ml5  reason: default package */
/* compiled from: InteractiveNotificationEvent */
public class ml5 extends ll5 {
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final boolean l;
    public final Bundle m;

    public ml5(qv5 qv5, pv5 pv5) {
        this.h = qv5.f2995a.i();
        this.i = qv5.f2995a.g.get("com.urbanairship.interactive_type");
        this.j = pv5.f2860a;
        this.k = pv5.d;
        this.l = pv5.b;
        this.m = pv5.c;
    }

    @Override // defpackage.ll5
    public final zt5 d() {
        zt5.b s = zt5.s();
        s.f("send_id", this.h);
        s.f("button_group", this.i);
        s.f("button_id", this.j);
        s.f("button_description", this.k);
        zt5.b g = s.g("foreground", this.l);
        Bundle bundle = this.m;
        if (bundle != null && !bundle.isEmpty()) {
            zt5.b s2 = zt5.s();
            for (String str : this.m.keySet()) {
                s2.f(str, this.m.getString(str));
            }
            g.e("user_input", s2.a());
        }
        return g.a();
    }

    @Override // defpackage.ll5
    public final String f() {
        return "interactive_notification_action";
    }
}
