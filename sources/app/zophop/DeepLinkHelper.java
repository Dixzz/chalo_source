package app.zophop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import app.zophop.models.City;
import app.zophop.models.TransitMode;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.scanPay.ScanPayBaseActivity;
import app.zophop.ui.activities.AlertsListActivity;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.SplashScreen;
import app.zophop.ui.activities.WebViewActivity;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import defpackage.xt;
import java.util.ArrayList;
import server.zophop.Constants;

public class DeepLinkHelper extends au {
    public String k;

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        boolean z;
        Intent intent;
        SplashScreen.a.a("deeplink");
        Intent intent2 = getIntent();
        this.k = intent2.getStringExtra("header");
        g30 g30 = new g30(intent2);
        if (!g30.a()) {
            return;
        }
        if (TextUtils.isEmpty(g30.b) || !g30.c.contains(Constants.ELASTIC_SEARCH_BASIC_AUTH_USERNAME) || !g30.b.contains("terms-of-use")) {
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.k().d() == null) {
                h0();
                z = true;
            } else {
                z = false;
            }
            if (z || TextUtils.isEmpty(g30.b)) {
                return;
            }
            if (g30.b.equalsIgnoreCase("bookPass") || g30.b.equalsIgnoreCase("bookTicket") || g30.b.equalsIgnoreCase("bookProduct")) {
                String str = null;
                if (g30.a() && g30.f1208a.containsKey("configId")) {
                    str = g30.f1208a.get("configId");
                }
                City d = t1Var.k().d();
                TransitMode transitMode = TransitMode.bus;
                if (!ui1.b0(transitMode, d)) {
                    intent = new Intent(this, HomeActivity.class);
                    intent.addFlags(536870912);
                } else if (ui1.b0(transitMode, d)) {
                    intent = new Intent(this, ProductSelectionActivity.class);
                    if (getIntent() != null) {
                        intent.putExtras(getIntent());
                    }
                    intent.putExtra("src", "deeplink product");
                    if (str != null) {
                        intent.putExtra("extraTargetConfigId", str);
                    }
                } else {
                    intent = new Intent(this, HomeActivity.class);
                    intent.addFlags(536870912);
                }
                finish();
                startActivity(intent);
            } else if (g30.b.equalsIgnoreCase("bookScanPay")) {
                Intent intent3 = new Intent(this, ScanPayBaseActivity.class);
                intent3.addFlags(536870912);
                intent3.putExtra("source", "scan pay deeplink");
                finish();
                startActivity(intent3);
            } else if (g30.b.equalsIgnoreCase("homescreen")) {
                h0();
            } else if (g30.b.equalsIgnoreCase("availability")) {
                finish();
                if (g30.d.getQueryParameter("status") != null) {
                    Integer.parseInt(g30.d.getQueryParameter("status"));
                }
            } else if (g30.b.contains("alerts")) {
                finish();
                Intent intent4 = new Intent(this, AlertsListActivity.class);
                if (g30.a() && g30.f1208a.containsKey("alert_id")) {
                    intent4.putExtra("alert_id", g30.f1208a.get("alert_id"));
                }
                startActivity(intent4);
            } else if (g30.b.contains("support")) {
                finish();
                ArrayList arrayList = new ArrayList();
                String C = hj1.C(t1Var);
                if (C != null) {
                    arrayList.add(C);
                }
                arrayList.add("commontag");
                Freshchat.showFAQs(this, new FaqOptions().showFaqCategoriesAsGrid(false).filterByTags(arrayList, "Help and Support", FaqOptions.FilterType.CATEGORY));
                jz5.b().g(hj1.l("chat screen", Long.MIN_VALUE, "source", "deep link helper"));
            } else if (g30.c.contains(Constants.ELASTIC_SEARCH_BASIC_AUTH_USERNAME)) {
                finish();
                WebViewActivity.h0(this, g30.d.toString(), this.k, false, false);
            }
        } else {
            finish();
            WebViewActivity.h0(this, g30.d.toString(), this.k, false, false);
        }
    }

    public final void h0() {
        Intent intent = new Intent(this, SplashScreen.class);
        intent.addFlags(536870912);
        intent.putExtra("src", "deeplink homescreen");
        finish();
        startActivity(intent);
    }
}
