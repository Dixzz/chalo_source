package com.urbanairship.iam.actions;

import android.net.Uri;
import androidx.appcompat.widget.RtlSpacingHelper;
import com.urbanairship.UAirship;
import com.urbanairship.automation.Trigger;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.push.PushMessage;
import defpackage.ln5;
import defpackage.ss5;
import java.util.UUID;
import java.util.concurrent.Callable;

public class LandingPageAction extends nk5 {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<dn5> f730a;
    public float b = 2.0f;

    public LandingPageAction() {
        dy5 dy5 = new dy5(dn5.class);
        this.f730a = dy5;
    }

    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        int i = ok5.f2706a;
        if ((i == 0 || i == 6 || i == 2 || i == 3 || i == 4) && g(ok5) != null) {
            return true;
        }
        return false;
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        boolean z;
        String str;
        boolean z2;
        try {
            dn5 call = this.f730a.call();
            Uri g = g(ok5);
            hd3.E(g, "URI should not be null");
            zt5 n = ok5.b.f.n();
            int e = n.u("width").e(0);
            int e2 = n.u("height").e(0);
            if (n.f.containsKey("aspect_lock")) {
                z = n.u("aspect_lock").a(false);
            } else {
                z = n.u("aspectLock").a(false);
            }
            PushMessage pushMessage = (PushMessage) ok5.c.getParcelable("com.urbanairship.PUSH_MESSAGE");
            if (pushMessage == null || pushMessage.i() == null) {
                str = UUID.randomUUID().toString();
                z2 = false;
            } else {
                str = pushMessage.i();
                z2 = true;
            }
            InAppMessage.b d = InAppMessage.d();
            ss5.b bVar = new ss5.b(null);
            bVar.f3251a = g.toString();
            bVar.e = false;
            bVar.d = this.b;
            bVar.f = e;
            bVar.g = e2;
            bVar.h = z;
            bVar.i = false;
            ss5 a2 = bVar.a();
            d.f729a = "html";
            d.d = a2;
            d.h = z2;
            d.g = "immediate";
            ln5.b<InAppMessage> c = ln5.c(d.a());
            c.m = str;
            c.d.add(new Trigger(9, 1.0d, null));
            c.f2244a = 1;
            c.f = RtlSpacingHelper.UNDEFINED;
            call.o(c.a());
            return rk5.a();
        } catch (Exception e3) {
            return rk5.c(e3);
        }
    }

    public Uri g(ok5 ok5) {
        String str;
        Uri f;
        if (ok5.b.c() != null) {
            str = ok5.b.c().u("url").i();
        } else {
            str = ok5.b.d();
        }
        if (str == null || (f = qy5.f(str)) == null || hd3.G1(f.toString())) {
            return null;
        }
        if (hd3.G1(f.getScheme())) {
            f = Uri.parse("https://" + f);
        }
        if (UAirship.l().k.d(f.toString(), 2)) {
            return f;
        }
        yj5.c("Landing page URL is not allowed: %s", f);
        return null;
    }
}
