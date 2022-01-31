package com.urbanairship.actions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.urbanairship.UAirship;

public class RateAppAction extends nk5 {
    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        int i = ok5.f2706a;
        if ((i == 0 || i == 6 || i == 2 || i == 3 || i == 4) && g() != null) {
            return true;
        }
        return false;
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        Uri g = g();
        hd3.E(g, "Missing store URI");
        if (ok5.b.f.n().u("show_link_prompt").a(false)) {
            Context d = UAirship.d();
            zt5 n = ok5.b.f.n();
            Intent putExtra = new Intent("com.urbanairship.actions.SHOW_RATE_APP_INTENT_ACTION").addFlags(805306368).setPackage(UAirship.g()).putExtra("store_uri", g);
            if (n.u(ProductPromotionsObject.KEY_TITLE).f instanceof String) {
                putExtra.putExtra(ProductPromotionsObject.KEY_TITLE, n.u(ProductPromotionsObject.KEY_TITLE).i());
            }
            if (n.u(ProductPromotionsObject.KEY_BODY).f instanceof String) {
                putExtra.putExtra(ProductPromotionsObject.KEY_BODY, n.u(ProductPromotionsObject.KEY_BODY).i());
            }
            d.startActivity(putExtra);
        } else {
            UAirship.d().startActivity(new Intent("android.intent.action.VIEW", g).setFlags(268435456));
        }
        return rk5.a();
    }

    @Override // defpackage.nk5
    public boolean f() {
        return true;
    }

    public final Uri g() {
        Uri uri = UAirship.l().e.i;
        if (uri != null) {
            return uri;
        }
        String packageName = UAirship.d().getPackageName();
        if (UAirship.l().h() == 1) {
            return Uri.parse("amzn://apps/android?p=" + packageName);
        } else if (UAirship.l().h() != 2) {
            return null;
        } else {
            if (pq5.b(UAirship.d())) {
                return Uri.parse("market://details?id=" + packageName);
            }
            return Uri.parse("https://play.google.com/store/apps/details?id=" + packageName);
        }
    }
}
