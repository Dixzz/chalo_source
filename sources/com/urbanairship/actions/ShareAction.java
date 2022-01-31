package com.urbanairship.actions;

import android.content.Context;
import android.content.Intent;
import com.urbanairship.R;
import com.urbanairship.UAirship;

public class ShareAction extends nk5 {
    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        int i = ok5.f2706a;
        if ((i == 0 || i == 6 || i == 2 || i == 3 || i == 4) && ok5.b.d() != null) {
            return true;
        }
        return false;
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        Context d = UAirship.d();
        d.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", ok5.b.d()), d.getString(R.string.ua_share_dialog_title)).setFlags(268435456));
        return rk5.a();
    }

    @Override // defpackage.nk5
    public boolean f() {
        return true;
    }
}
