package com.urbanairship.automation.actions;

import com.razorpay.AnalyticsConstants;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.automation.ScheduleDelay;
import com.urbanairship.automation.Trigger;
import com.urbanairship.json.JsonValue;
import defpackage.ln5;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ScheduleAction extends nk5 {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<dn5> f724a = new dy5(dn5.class);

    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        int i = ok5.f2706a;
        if (i == 0 || i == 1 || i == 3 || i == 6) {
            return ok5.b.f.f instanceof zt5;
        }
        return false;
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        try {
            dn5 call = this.f724a.call();
            try {
                ln5<vn5> g = g(ok5.b.f);
                Boolean bool = call.o(g).get();
                return (bool == null || !bool.booleanValue()) ? rk5.a() : rk5.d(new ActionValue(JsonValue.x(g.f2243a)));
            } catch (InterruptedException | ExecutionException | xt5 e) {
                return rk5.c(e);
            }
        } catch (Exception e2) {
            return rk5.c(e2);
        }
    }

    public ln5<vn5> g(JsonValue jsonValue) throws xt5 {
        zt5 n = jsonValue.n();
        ln5.b<vn5> b = ln5.b(new vn5(n.u("actions").n()));
        b.f2244a = n.u("limit").e(1);
        b.f = n.u("priority").e(0);
        b.k = n.u("group").i();
        if (n.f.containsKey(AnalyticsConstants.END)) {
            b.c = ly5.c(n.u(AnalyticsConstants.END).o(), -1);
        }
        if (n.f.containsKey(AnalyticsConstants.START)) {
            b.b = ly5.c(n.u(AnalyticsConstants.START).o(), -1);
        }
        Iterator<JsonValue> it = n.u("triggers").m().iterator();
        while (it.hasNext()) {
            b.d.add(Trigger.c(it.next()));
        }
        if (n.f.containsKey("delay")) {
            b.e = ScheduleDelay.a(n.u("delay"));
        }
        if (n.f.containsKey("interval")) {
            b.b(n.u("interval").g(0), TimeUnit.SECONDS);
        }
        JsonValue jsonValue2 = n.u("audience").n().f.get("audience");
        if (jsonValue2 != null) {
            b.n = fm5.a(jsonValue2);
        }
        try {
            return b.a();
        } catch (IllegalArgumentException e) {
            throw new xt5("Invalid schedule info", e);
        }
    }
}
