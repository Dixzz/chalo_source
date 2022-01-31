package app.zophop.ui.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AlertsListActivity extends au {
    public Toolbar k;
    public RecyclerView l;

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        String str;
        g30 g30 = new g30(getIntent());
        if (!g30.a() || !g30.f1208a.containsKey("alert_id")) {
            str = null;
        } else {
            str = g30.f1208a.get("alert_id");
            p30 h0 = h0();
            for (re1 re1 : h0.e()) {
                if (re1.f.equals(str)) {
                    ed1 l2 = hj1.l("alert notification clicked", Long.MIN_VALUE, "alertId", str);
                    l2.a("alertTitle", re1.g);
                    l2.a("alertType", re1.a());
                    l2.a("clickedTime", String.valueOf(System.currentTimeMillis()));
                    hj1.K0(l2, "isLocationFiltered", String.valueOf(h0.i(re1)), l2);
                }
            }
        }
        p30 F = xt.f3961a.F();
        F.k(F.b);
        F.k(F.c);
        setContentView(R.layout.alerts_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.k = toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().z(getString(R.string.alert_screen_title));
        getSupportActionBar().o(true);
        this.l = (RecyclerView) findViewById(R.id.alerts_recycler_view);
        List<re1> e = h0().e();
        Objects.requireNonNull(h0());
        ed1 ed1 = new ed1("list of displayed alerts", Long.MIN_VALUE);
        ed1.a("size of alerts list", Integer.valueOf(e.size()));
        int i = 0;
        for (int i2 = 0; i2 < e.size(); i2++) {
            String valueOf = String.valueOf(i2);
            StringBuilder i0 = hj1.i0("alertId ");
            i0.append(e.get(i2).f);
            ed1.a(valueOf, i0.toString());
        }
        jz5.b().g(ed1);
        if (e.size() > 0) {
            this.l.setVisibility(0);
            findViewById(R.id.no_alerts_yet).setVisibility(8);
            si0 si0 = new si0(this, e);
            this.l.setLayoutManager(new LinearLayoutManager(1, false));
            this.l.f(new a71(getResources().getDimensionPixelSize(R.dimen.alert_card_divider_height)));
            this.l.setAdapter(si0);
            if (str != null) {
                while (true) {
                    if (i >= e.size()) {
                        i = -1;
                        break;
                    } else if (e.get(i).f.equals(str)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    new Handler().postDelayed(new mc0(this, this, i), 1000);
                    return;
                }
                return;
            }
            return;
        }
        this.l.setVisibility(8);
        findViewById(R.id.no_alerts_yet).setVisibility(0);
    }

    public final p30 h0() {
        return xt.f3961a.F();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!xt.f3961a.t().b("showChatOptionsDrawer")) {
            return true;
        }
        getMenuInflater().inflate(R.menu.alert_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.alert_chat_hook) {
            return super.onOptionsItemSelected(menuItem);
        }
        ArrayList arrayList = new ArrayList();
        String C = hj1.C(xt.f3961a);
        if (C != null) {
            arrayList.add(C);
        }
        arrayList.add("commontag");
        Freshchat.showFAQs(this, new FaqOptions().showFaqCategoriesAsGrid(false).filterByTags(arrayList, "Help and Support", FaqOptions.FilterType.CATEGORY));
        jz5.b().g(hj1.l("chat screen", Long.MIN_VALUE, "source", "alert info menu"));
        return true;
    }
}
