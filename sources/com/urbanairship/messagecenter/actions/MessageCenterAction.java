package com.urbanairship.messagecenter.actions;

import com.urbanairship.push.PushMessage;
import java.util.concurrent.Callable;

public class MessageCenterAction extends nk5 {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<yu5> f736a = new dy5(yu5.class);

    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        int i = ok5.f2706a;
        return i == 0 || i == 6 || i == 2 || i == 3 || i == 4;
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        try {
            yu5 call = this.f736a.call();
            String d = ok5.b.d();
            if ("auto".equalsIgnoreCase(d)) {
                PushMessage pushMessage = (PushMessage) ok5.c.getParcelable("com.urbanairship.PUSH_MESSAGE");
                if (pushMessage == null || pushMessage.h() == null) {
                    d = ok5.c.containsKey("com.urbanairship.RICH_PUSH_ID_METADATA") ? ok5.c.getString("com.urbanairship.RICH_PUSH_ID_METADATA") : null;
                } else {
                    d = pushMessage.h();
                }
            }
            if (hd3.G1(d)) {
                call.k(null);
            } else {
                call.k(d);
            }
            return rk5.a();
        } catch (Exception e) {
            return rk5.c(e);
        }
    }

    @Override // defpackage.nk5
    public boolean f() {
        return true;
    }
}
