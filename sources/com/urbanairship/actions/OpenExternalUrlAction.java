package com.urbanairship.actions;

import android.content.Intent;
import android.net.Uri;
import com.urbanairship.UAirship;

public class OpenExternalUrlAction extends nk5 {
    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        int i = ok5.f2706a;
        if ((i == 0 || i == 6 || i == 2 || i == 3 || i == 4) && qy5.f(ok5.b.d()) != null) {
            return UAirship.l().k.d(ok5.b.d(), 2);
        }
        return false;
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        Uri f = qy5.f(ok5.b.d());
        yj5.f("Opening URI: %s", f);
        Intent intent = new Intent("android.intent.action.VIEW", f);
        intent.addFlags(268435456);
        UAirship.d().startActivity(intent);
        return rk5.d(ok5.b);
    }

    @Override // defpackage.nk5
    public boolean f() {
        return true;
    }
}
