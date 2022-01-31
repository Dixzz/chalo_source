package com.urbanairship.actions;

import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import defpackage.qk5;
import defpackage.zt5;
import java.util.Objects;
import java.util.Set;

public class FetchDeviceInfoAction extends nk5 {

    public static class FetchDeviceInfoPredicate implements qk5.b {
        @Override // defpackage.qk5.b
        public boolean a(ok5 ok5) {
            int i = ok5.f2706a;
            return i == 3 || i == 0;
        }
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        Objects.requireNonNull(UAirship.l());
        zt5.b s = zt5.s();
        s.f("channel_id", UAirship.l().j.l());
        zt5.b g = s.g("push_opt_in", UAirship.l().i.n()).g("location_enabled", false);
        g.i("named_user", UAirship.l().o.j());
        Set<String> o = UAirship.l().j.o();
        if (!o.isEmpty()) {
            g.e("tags", JsonValue.x(o));
        }
        return rk5.d(new ActionValue(JsonValue.x(g.a())));
    }
}
