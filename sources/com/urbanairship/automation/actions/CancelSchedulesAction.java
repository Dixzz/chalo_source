package com.urbanairship.automation.actions;

import com.urbanairship.actions.ActionValue;
import com.urbanairship.json.JsonValue;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;

public class CancelSchedulesAction extends nk5 {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<dn5> f723a = new dy5(dn5.class);

    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        int i = ok5.f2706a;
        if (i != 0 && i != 1 && i != 3 && i != 6) {
            return false;
        }
        ActionValue actionValue = ok5.b;
        Object obj = actionValue.f.f;
        if (obj instanceof String) {
            return "all".equalsIgnoreCase(actionValue.d());
        }
        return obj instanceof zt5;
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        try {
            dn5 call = this.f723a.call();
            JsonValue jsonValue = ok5.b.f;
            if (!(jsonValue.f instanceof String) || !"all".equalsIgnoreCase(jsonValue.i())) {
                JsonValue u = jsonValue.n().u("groups");
                Object obj = u.f;
                if (obj instanceof String) {
                    String o = u.o();
                    call.l();
                    mm5 mm5 = call.h;
                    Objects.requireNonNull(mm5);
                    mm5.i.post(new im5(mm5, o, new ck5()));
                } else if (obj instanceof yt5) {
                    Iterator<JsonValue> it = u.m().iterator();
                    while (it.hasNext()) {
                        JsonValue next = it.next();
                        if (next.f instanceof String) {
                            String o2 = next.o();
                            call.l();
                            mm5 mm52 = call.h;
                            Objects.requireNonNull(mm52);
                            mm52.i.post(new im5(mm52, o2, new ck5()));
                        }
                    }
                }
                JsonValue u2 = jsonValue.n().u("ids");
                Object obj2 = u2.f;
                if (obj2 instanceof String) {
                    call.i(u2.o());
                } else if (obj2 instanceof yt5) {
                    Iterator<JsonValue> it2 = u2.m().iterator();
                    while (it2.hasNext()) {
                        JsonValue next2 = it2.next();
                        if (next2.f instanceof String) {
                            call.i(next2.o());
                        }
                    }
                }
                return rk5.a();
            }
            call.l();
            mm5 mm53 = call.h;
            Objects.requireNonNull(mm53);
            mm53.i.post(new hm5(mm53, "actions", new ck5()));
            return rk5.a();
        } catch (Exception e) {
            return rk5.c(e);
        }
    }
}
