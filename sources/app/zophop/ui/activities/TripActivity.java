package app.zophop.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.RouteWithoutTimings;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.Trip;
import app.zophop.models.TripLeg;
import app.zophop.pubsub.eventbus.events.ResultActivityToFragment;
import app.zophop.pubsub.eventbus.events.StopSearchedEvent;
import app.zophop.ui.utils.FrequencyRouteHelper;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import defpackage.wd1;
import defpackage.xt;
import io.github.inflationx.calligraphy3.CalligraphyUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import server.zophop.logging.LoggingConstants;

public class TripActivity extends fe0 implements wd1.a {
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public Trip t;
    public FrequencyRouteHelper u;
    public ah1 v;

    @Override // defpackage.wd1.a
    public void b0() {
        this.u._panelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }

    @Override // defpackage.wd1.a
    public void c0() {
        this.u.c0();
    }

    @Override // defpackage.fe0
    public void init() {
        this.m = getIntent().getStringExtra("trip_id");
        this.n = getIntent().getStringExtra("stop_id");
        this.o = getIntent().getStringExtra("end_stop_id");
        getIntent().getStringExtra("extra:leg");
        this.s = getIntent().getStringExtra(LoggingConstants.ROUTE_ID);
        this.q = getIntent().getStringExtra("routeName");
        this.p = getIntent().getStringExtra("transit_mode");
        this.r = getIntent().getStringExtra("source");
        if (this.p == null) {
            this.p = TransitMode.train.toString();
        }
        xt.t1 t1Var = xt.f3961a;
        w40 c0 = t1Var.c0();
        String str = this.s;
        String str2 = this.m;
        TransitMode transitMode = TransitMode.getTransitMode(this.p);
        Objects.requireNonNull(c0);
        if (!t1Var.A().j()) {
            long currentTimeMillis = System.currentTimeMillis();
            a50 a50 = new a50(c0, currentTimeMillis, str2);
            b50 b50 = new b50(c0, str2, currentTimeMillis, a50);
            Uri.Builder builder = new Uri.Builder();
            Uri.Builder appendPath = builder.encodedPath(ut.d).appendPath(c0.b.d().getName()).appendPath("trip");
            appendPath.appendQueryParameter("trip_id", str2 + "").appendQueryParameter("meta", ui1.K0().toString());
            builder.build().toString();
            d70 d70 = new d70(builder.build().toString(), null, b50, a50);
            d70.n = true;
            c0.f3717a.a(d70);
        } else if (str == null || str2 == null || transitMode == null) {
            jz5.b().i(new Trip(str2, null, null, null));
        } else {
            HandlerThread handlerThread = new HandlerThread("trip details");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new z40(c0, str, str2, transitMode, handler));
        }
    }

    @Override // defpackage.fe0
    public void j0() {
        this.u = new FrequencyRouteHelper(this, this.t, this.q, l0(), m0(), this.r);
        setContentView(R.layout.frequency_route_new);
        this.u.d();
        xt.t1 t1Var = xt.f3961a;
        this.v = new ah1(this, t1Var.B().a());
        String format = String.format(getResources().getString(R.string.to), m0().getName());
        String format2 = String.format(getResources().getString(R.string.from), l0().getName());
        ((TextView) findViewById(R.id.title)).setText(format);
        TextView textView = (TextView) findViewById(R.id.subtext);
        textView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.favorite_item_bus_to));
        textView.setText(format2);
        textView.setMaxLines(2);
        CalligraphyUtils.applyFontToTextView(this, (TextView) findViewById(R.id.title), getString(R.string.font_medium));
        xw0 xw0 = new xw0();
        Trip trip = this.t;
        xw0.w = trip;
        xw0.m = trip.get_routeId();
        Bundle bundle = new Bundle();
        bundle.putString("extra:trip", new Gson().toJson(trip));
        xw0.setArguments(bundle);
        xw0.e(new xf0(this));
        getFragmentManager().beginTransaction().add(R.id.route_container, xw0, xw0.class.getSimpleName()).commit();
        t1Var.N().f(this.s);
    }

    public final Stop k0(String str) {
        for (TripLeg tripLeg : this.t.getTripLegs()) {
            if (tripLeg.getStop().getId().equals(str)) {
                return tripLeg.getStop();
            }
        }
        return null;
    }

    public final Stop l0() {
        String str = this.n;
        Stop k0 = str != null ? k0(str) : null;
        if (k0 != null) {
            return k0;
        }
        LatLng h = xt.f3961a.B().h();
        Route G = ui1.G(this.t, this.q, "");
        Stop E = ui1.E(h, G.getStopSequence());
        return E == null ? G.getStopSequence().get(0) : E;
    }

    public final Stop m0() {
        String str = this.o;
        Stop k0 = str != null ? k0(str) : null;
        if (k0 != null) {
            return k0;
        }
        Route G = ui1.G(this.t, this.q, "");
        return G.getStopSequence().get(G.getStopSequence().size() - 1);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1010 && i2 == -1) {
            jz5.b().i(new StopSearchedEvent((Stop) hj1.s(intent.getStringExtra("result_picked_stop"), Stop.class), this.s));
        }
        jz5.b().g(new ResultActivityToFragment(i, i2, intent));
        super.onActivityResult(i, i2, intent);
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void onEventMainThread(Trip trip) {
        if (trip.getTripId().equals(this.m) && this.t == null) {
            if (trip.getTripLegs() != null) {
                this.t = trip;
                j0();
                return;
            }
            h0();
        }
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        } else if (itemId != R.id.check_in) {
            return false;
        } else {
            if (ui1.V(this)) {
                List<TripLeg> tripLegs = this.t.getTripLegs();
                ArrayList arrayList = new ArrayList();
                for (TripLeg tripLeg : tripLegs) {
                    arrayList.add(tripLeg.getStop());
                }
                Stop E = ui1.E(xt.f3961a.B().h(), arrayList);
                if (E == null) {
                    E = (Stop) arrayList.get(0);
                }
                ui1.k0(this, new RouteWithoutTimings(this.s, this.q, E.getMode(), arrayList), E, (Stop) arrayList.get(arrayList.size() - 1));
                String transitMode = this.t.getTransitMode().toString();
                String str = this.s;
                ed1 l = hj1.l("checkin initiated", Long.MIN_VALUE, "source", "trip details screen");
                if (transitMode != null) {
                    l.a("mode", transitMode);
                }
                if (str != null) {
                    l.a("route", str);
                }
                jz5.b().g(l);
            } else if (!vn.K0(this)) {
                Toast.makeText(this, getString(R.string.check_in_activity_failure_query_failed), 1).show();
            } else if (!vn.J0(this)) {
                this.v.b(getString(R.string.gps_not_available_toast));
            }
            return true;
        }
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
