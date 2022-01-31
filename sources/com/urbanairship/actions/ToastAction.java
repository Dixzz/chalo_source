package com.urbanairship.actions;

import android.widget.Toast;
import com.urbanairship.UAirship;

public class ToastAction extends nk5 {
    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        int i = ok5.f2706a;
        if (i != 0 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6) {
            return false;
        }
        if (ok5.b.c() != null) {
            return ok5.b.c().u("text").f instanceof String;
        }
        if (ok5.b.d() != null) {
            return true;
        }
        return false;
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        String str;
        int i;
        if (ok5.b.c() != null) {
            i = ok5.b.c().u("length").e(0);
            str = ok5.b.c().u("text").i();
        } else {
            str = ok5.b.d();
            i = 0;
        }
        if (i == 1) {
            Toast.makeText(UAirship.d(), str, 1).show();
        } else {
            Toast.makeText(UAirship.d(), str, 0).show();
        }
        return rk5.d(ok5.b);
    }

    @Override // defpackage.nk5
    public boolean f() {
        return true;
    }
}
