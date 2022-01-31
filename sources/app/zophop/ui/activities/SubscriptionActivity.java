package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Route;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.RouteDetailsEvent;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.gson.Gson;
import defpackage.nn0;
import defpackage.xt;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import org.json.JSONException;
import server.zophop.logging.LoggingConstants;

public class SubscriptionActivity extends au {
    public static final /* synthetic */ int y = 0;
    @InjectView(R.id.done)
    public TextView _confirmButton;
    @InjectView(R.id.remove)
    public TextView _removeButton;
    @InjectView(R.id.stop_view)
    public View _stopView;
    @InjectView(R.id.time_view)
    public View _timeView;
    @InjectView(R.id.tool_bar)
    public Toolbar _toolbar;
    public Route k;
    public f80 l;
    public Stop m;
    public int n;
    public int o;
    public BusFavourite p;
    public BusFavouriteWithSubscription q;
    public TextView r;
    public TextView s;
    public String t;
    public String u;
    public String v;
    public String w;
    public TransitMode x;

    public static void h0(Context context, Route route) {
        Gson gson = new Gson();
        Intent intent = new Intent(context, SubscriptionActivity.class);
        intent.putExtra("subscribed_route", gson.toJson(route));
        context.startActivity(intent);
    }

    public static void j0(BusFavouriteWithSubscription busFavouriteWithSubscription) {
        if (busFavouriteWithSubscription != null) {
            ed1 ed1 = new ed1("route unsubscribed", Long.MIN_VALUE);
            ed1.a(LoggingConstants.ROUTE_ID, busFavouriteWithSubscription.getRouteId());
            ed1.a("routeName", busFavouriteWithSubscription.getRouteName());
            if (busFavouriteWithSubscription.getSubscribedStop() != null) {
                ed1.a("stopId", busFavouriteWithSubscription.getSubscribedStop().getId());
                ed1.a("stopName", busFavouriteWithSubscription.getSubscribedStop().getName());
            }
            ed1.a("hour", Integer.valueOf(busFavouriteWithSubscription.getSubscribedHour()));
            ed1.a("minute", Integer.valueOf(busFavouriteWithSubscription.getSubscribedMinute()));
            long currentTimeMillis = System.currentTimeMillis();
            Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("gmt"));
            instance.setTimeInMillis(currentTimeMillis + 19800000);
            int i = instance.get(11);
            int i2 = instance.get(12);
            ed1.a("cHour", Integer.valueOf(i));
            ed1.a("cMinute", Integer.valueOf(i2));
            jz5.b().g(ed1);
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        Intent intent = getIntent();
        this.l = xt.f3961a.r();
        if (intent.hasExtra("subscribed_route")) {
            Route route = (Route) hj1.s(intent.getStringExtra("subscribed_route"), Route.class);
            this.k = route;
            this.t = route.getRouteId();
            this.u = this.k.getRouteName();
            this.v = this.k.getStopSequence().get(0).getName();
            this.w = this.k.getStopSequence().get(this.k.getStopSequence().size() - 1).getName();
            this.x = this.k.getMode();
        } else if (intent.hasExtra("favorite_route")) {
            try {
                BusFavourite a2 = new mv().a(intent.getStringExtra("favorite_route"));
                this.p = a2;
                this.t = a2.getRouteId();
                this.u = this.p.getRouteName();
                this.v = this.p.getStartStopName();
                this.w = this.p.getEndStopName();
                this.x = this.p.getMode();
            } catch (JSONException unused) {
                finish();
            }
        } else {
            finish();
        }
        BusFavouriteWithSubscription busFavouriteWithSubscription = (BusFavouriteWithSubscription) ((c80) this.l).h(this.t, RouteStoreType.SUBSCRIBED);
        this.q = busFavouriteWithSubscription;
        if (busFavouriteWithSubscription != null) {
            this.m = busFavouriteWithSubscription.getSubscribedStop();
            this.n = this.q.getSubscribedHour();
            this.o = this.q.getSubscribedMinute();
        } else {
            if (this.k != null) {
                Stop E = ui1.E(xt.f3961a.B().h(), this.k.getStopSequence());
                this.m = E;
                if (E == null) {
                    this.m = this.k.getStopSequence().get(0);
                }
            }
            int N = ui1.N() / 60;
            this.o = N % 60;
            this.n = N / 60;
        }
        setContentView(R.layout.subscription_screen);
        ButterKnife.inject(this);
        Toolbar toolbar = this._toolbar;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().r(false);
        getSupportActionBar().q(true);
        getSupportActionBar().o(true);
        getSupportActionBar().z(this.u);
        getSupportActionBar().t(R.drawable.close_nearby);
        if (!ui1.Y()) {
            x supportActionBar = getSupportActionBar();
            supportActionBar.x(this.v + " - " + this.w);
        }
        ((TextView) this._stopView.findViewById(R.id.title)).setText(getString(R.string.set_stop));
        ((TextView) this._timeView.findViewById(R.id.title)).setText(getString(R.string.alarm_time));
        this._timeView.setBackgroundResource(R.drawable.drawer_item_selector);
        this._stopView.setBackgroundResource(R.drawable.drawer_item_selector);
        this._removeButton.setText(getString(R.string.remove).toUpperCase());
        this._confirmButton.setText(getString(R.string.add).toUpperCase());
        this._stopView.findViewById(R.id.desination_eta).setVisibility(8);
        this._timeView.findViewById(R.id.desination_eta).setVisibility(8);
        if (this.q == null) {
            this._removeButton.setVisibility(8);
        }
        this.r = (TextView) this._stopView.findViewById(R.id.sub_title);
        this.s = (TextView) this._timeView.findViewById(R.id.sub_title);
        Stop stop = this.m;
        if (stop != null) {
            this.r.setText(stop.getName());
        } else {
            this.r.setVisibility(8);
        }
        i0(this.n, this.o);
        this._stopView.setOnClickListener(new qf0(this));
        this._timeView.setOnClickListener(new rf0(this));
        this._confirmButton.setOnClickListener(new sf0(this));
        this._confirmButton.requestFocus();
        this._removeButton.setOnClickListener(new tf0(this));
        if (this.k == null) {
            xt.t1 t1Var = xt.f3961a;
            t1Var.U().c(this.t, this.x, hj1.B(t1Var));
        }
    }

    public void i0(int i, int i2) {
        this.n = i;
        this.o = i2;
        this.s.setText(jh1.g((long) (((i * 60) + i2) * 60)));
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1010 && i2 == -1) {
            Stop stop = (Stop) hj1.s(intent.getStringExtra("result_picked_stop"), Stop.class);
            this.m = stop;
            this.r.setText(stop.getName());
            this.r.setVisibility(0);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onEvent(nn0.a aVar) {
        if (aVar != null) {
            int i = aVar.f2577a;
            int i2 = aVar.b;
            ed1 ed1 = new ed1("route subscribe time changed", Long.MIN_VALUE);
            Stop stop = this.m;
            if (stop != null) {
                ed1.a("stopId", stop.getId());
            }
            String str = this.t;
            if (str != null) {
                ed1.a(LoggingConstants.ROUTE_ID, str);
            }
            ed1.a("hour", Integer.valueOf(i));
            ed1.a("minute", Integer.valueOf(i2));
            jz5.b().g(ed1);
            i0(aVar.f2577a, aVar.b);
            jz5.b().m(aVar);
        }
    }

    public void onEventMainThread(RouteDetailsEvent routeDetailsEvent) {
        if (routeDetailsEvent.getResponseType().equals(ad1.SUCCESS) && routeDetailsEvent.getRouteId().equals(this.t)) {
            this.k = routeDetailsEvent.getRoute();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
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
