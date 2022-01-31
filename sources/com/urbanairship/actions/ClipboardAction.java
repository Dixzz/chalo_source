package com.urbanairship.actions;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Handler;
import android.os.Looper;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UAirship;

public class ClipboardAction extends nk5 {

    public class a implements Runnable {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public a(ClipboardAction clipboardAction, String str, String str2) {
            this.f = str;
            this.g = str2;
        }

        public void run() {
            ((ClipboardManager) UAirship.d().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(this.f, this.g));
        }
    }

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
        String str2;
        if (ok5.b.c() != null) {
            str2 = ok5.b.c().u("text").i();
            str = ok5.b.c().u(Constants.ScionAnalytics.PARAM_LABEL).i();
        } else {
            str2 = ok5.b.d();
            str = null;
        }
        new Handler(Looper.getMainLooper()).post(new a(this, str, str2));
        return rk5.d(ok5.b);
    }

    @Override // defpackage.nk5
    public boolean f() {
        return true;
    }
}
