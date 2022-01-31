package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.TripSummary;
import app.zophop.ui.views.summary_card.LoaderView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import defpackage.a32;
import defpackage.xt;
import java.util.List;
import java.util.Objects;

public class TripSchedulesActivity extends au {
    public static final /* synthetic */ int u = 0;
    @InjectView(R.id.loader)
    public LoaderView _loader;
    @InjectView(R.id.trips)
    public ListView _trainSchedulesView;
    public List<TripSummary> k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public a32 r;
    public k00 s;
    public p5 t;

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        a32.a aVar = new a32.a(this);
        aVar.a(qz1.f3013a);
        a32 d = aVar.d();
        this.r = d;
        d.f();
        this.t = new p5(this);
        xt.t1 t1Var = xt.f3961a;
        this.s = t1Var.y();
        Intent intent = getIntent();
        g30 g30 = new g30(intent);
        if (g30.a()) {
            this.l = g30.f1208a.get("first_stop_name");
            this.m = g30.f1208a.get("first_stop_id");
            this.n = g30.f1208a.get("last_stop_name");
            this.o = g30.f1208a.get("last_stop_id");
            this.p = g30.f1208a.get("mode");
            this.q = g30.f1208a.get("city");
            if (g30.f1208a.containsKey("source")) {
                this.s.a("tripSchedulesScreen", g30.f1208a.get("source"), g30.f1208a.get("tag"));
            }
            this.t.b(h.R(this));
        } else {
            this.l = intent.getStringExtra("extra_first_stop_name");
            this.m = intent.getStringExtra("extra_first_stop_id");
            this.n = intent.getStringExtra("extra_last_stop_name");
            this.o = intent.getStringExtra("extra_last_stop_id");
            this.p = intent.getStringExtra("extra_mode");
            this.q = hj1.B(t1Var);
        }
        setContentView(R.layout.more_trips_screen);
        setSupportActionBar((Toolbar) findViewById(R.id.tool_bar));
        ButterKnife.inject(this);
        getSupportActionBar().o(true);
        getSupportActionBar().z("");
        getSupportActionBar().r(false);
        getSupportActionBar().q(false);
        getSupportActionBar().o(true);
        String format = String.format(getString(R.string.from), this.l);
        String format2 = String.format(getString(R.string.to), this.n);
        getSupportActionBar().z(format);
        getSupportActionBar().x(format2);
        this._trainSchedulesView.setAdapter((ListAdapter) new kk0(this, null, null, TransitMode.getTransitMode(this.p), this.l));
        this._trainSchedulesView.setEmptyView(findViewById(R.id.empty_view));
        this._loader.setRetryHandler(new yg0(this));
        h0(this.q);
    }

    public final void h0(String str) {
        xt.t1 t1Var = xt.f3961a;
        w40 c0 = t1Var.c0();
        String str2 = this.m;
        String str3 = this.o;
        TransitMode transitMode = TransitMode.getTransitMode(this.p);
        Objects.requireNonNull(c0);
        String name = t1Var.k().d().getName();
        if (!str.equalsIgnoreCase(name)) {
            c0.d(str2, str3, str);
        } else if (t1Var.A().j()) {
            HandlerThread handlerThread = new HandlerThread("AllTripsFetcher");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new y40(c0, str2, str3, transitMode, handler));
        } else {
            c0.d(str2, str3, name);
        }
        this._loader.d();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        ui1.F0(this.t);
        super.onBackPressed();
    }

    public void onEventMainThread(List<TripSummary> list) {
        String str;
        list.toString();
        if (list.size() != 0) {
            this._loader.setVisibility(8);
            this.k = list;
            kk0 kk0 = new kk0(this, list, new xg0(this), TransitMode.getTransitMode(this.p), this.l);
            this._trainSchedulesView.setAdapter((ListAdapter) kk0);
            this._trainSchedulesView.setSelection(kk0.c(ui1.N()));
            List<TripSummary> list2 = this.k;
            if (list2 == null || list2.size() <= 0) {
                str = this.l + " to " + this.n;
            } else {
                str = this.l + " to " + this.n + " - " + this.k.get(0).getRouteName();
            }
            if (this.q == null) {
                this.q = hj1.B(xt.f3961a);
            }
            this.q = vn.g(this.q);
            StringBuilder i0 = hj1.i0("android-app://");
            i0.append(getPackageName());
            i0.append("/zophop/schedules?first_stop_id=");
            i0.append(this.m);
            i0.append("&first_stop_name=");
            i0.append(this.l);
            i0.append("&last_stop_id=");
            i0.append(this.o);
            i0.append("&last_stop_name=");
            i0.append(this.n);
            i0.append("&city=");
            i0.append(this.q);
            i0.append("&mode=");
            hj1.V0(i0, this.p, "&", "source", "=");
            ((gf3) qz1.b).a(this.r, hj1.m(i0, "appIndex", "http://schema.org/ViewAction", str));
        } else if (!vn.K0(this)) {
            this._loader.a();
        } else {
            this._loader.b(R.drawable.alert_scheduler, getString(R.string.something_bad_happened));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        ui1.F0(this.t);
        return true;
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }
}
