package com.urbanairship.actions;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushMessage;
import defpackage.kl5;
import defpackage.qk5;
import java.math.BigDecimal;

public class AddCustomEventAction extends nk5 {

    public static class AddCustomEventActionPredicate implements qk5.b {
        @Override // defpackage.qk5.b
        public boolean a(ok5 ok5) {
            return 1 != ok5.f2706a;
        }
    }

    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        if (ok5.b.c() == null) {
            yj5.c("CustomEventAction requires a map of event data.", new Object[0]);
            return false;
        } else if (ok5.b.c().f.get("event_name") != null) {
            return true;
        } else {
            yj5.c("CustomEventAction requires an event name in the event data.", new Object[0]);
            return false;
        }
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        String string;
        zt5 n = ok5.b.f.n();
        String i = n.u("event_name").i();
        hd3.E(i, "Missing event name");
        String i2 = n.u("event_value").i();
        double c = n.u("event_value").c(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        String i3 = n.u(FirebaseAnalytics.Param.TRANSACTION_ID).i();
        String i4 = n.u("interaction_type").i();
        String i5 = n.u("interaction_id").i();
        zt5 h = n.u(AnalyticsConstants.PROPERTIES).h();
        BigDecimal bigDecimal = kl5.o;
        kl5.b bVar = new kl5.b(i);
        bVar.c = i3;
        PushMessage pushMessage = (PushMessage) ok5.c.getParcelable("com.urbanairship.PUSH_MESSAGE");
        if (pushMessage != null) {
            bVar.f = pushMessage.i();
        }
        bVar.e = i5;
        bVar.d = i4;
        if (i2 == null) {
            BigDecimal valueOf = BigDecimal.valueOf(c);
            if (valueOf == null) {
                bVar.b = null;
            } else {
                bVar.b = valueOf;
            }
        } else if (hd3.G1(i2)) {
            bVar.b = null;
        } else {
            bVar.b = new BigDecimal(i2);
        }
        if (i5 == null && i4 == null && (string = ok5.c.getString("com.urbanairship.RICH_PUSH_ID_METADATA")) != null) {
            bVar.d = "ua_mcrap";
            bVar.e = string;
        }
        if (h != null) {
            bVar.g = h.n();
        }
        kl5 kl5 = new kl5(bVar, null);
        UAirship.l().f.i(kl5);
        if (kl5.g()) {
            return rk5.a();
        }
        return rk5.c(new IllegalArgumentException("Unable to add custom event. Event is invalid."));
    }
}
