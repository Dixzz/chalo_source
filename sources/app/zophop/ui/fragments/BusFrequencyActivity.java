package app.zophop.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.RouteDetailsEvent;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import defpackage.xt;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.List;
import server.zophop.logging.LoggingConstants;

public class BusFrequencyActivity extends fe0 {
    public List<Route.RouteTiming> m;
    public String n;
    public String o;

    public class a extends TypeToken<List<Route.RouteTiming>> {
        public a(BusFrequencyActivity busFrequencyActivity) {
        }
    }

    public static void l0(Context context, Route route) {
        Intent intent = new Intent(context, BusFrequencyActivity.class);
        intent.putExtra("busFrquency", new Gson().toJson(route.getRouteTiming()));
        intent.putExtra("fromStop", route.getStopSequence().get(0).getName());
        context.startActivity(intent);
    }

    @Override // defpackage.fe0
    public void init() {
        this.m = (List) new Gson().fromJson(getIntent().getStringExtra("busFrquency"), new a(this).getType());
        this.n = getIntent().getStringExtra("fromStop");
        if (this.m != null) {
            j0();
            return;
        }
        this.o = getIntent().getStringExtra(LoggingConstants.ROUTE_ID);
        String stringExtra = getIntent().getStringExtra("mode");
        xt.t1 t1Var = xt.f3961a;
        String B = hj1.B(t1Var);
        t1Var.U().c(this.o, TransitMode.valueOf(stringExtra), B);
    }

    @Override // defpackage.fe0
    public void j0() {
        int i;
        int i2;
        setContentView(R.layout.bus_route_frequency);
        setSupportActionBar((Toolbar) findViewById(R.id.frequency_toolbar));
        getSupportActionBar().z("Timetable");
        getSupportActionBar().o(true);
        getSupportActionBar().t(R.drawable.close_nearby);
        ((TextView) findViewById(R.id.frequency_start_stop)).setText(String.format(getString(R.string.start_from_stop), this.n));
        TextView textView = (TextView) findViewById(R.id.tv_schedule_first_last);
        List<Route.RouteTiming> list = this.m;
        if (list == null || list.size() == 0) {
            textView.setVisibility(8);
        } else {
            int i3 = Integer.MAX_VALUE;
            int i4 = RtlSpacingHelper.UNDEFINED;
            for (Route.RouteTiming routeTiming : this.m) {
                if (routeTiming._isFrequency) {
                    i = ((TimeInterval) routeTiming._frequencyTuple.first).getLow();
                } else {
                    i = routeTiming._startTime;
                }
                i3 = Math.min(i3, i);
                if (routeTiming._isFrequency) {
                    i2 = ((TimeInterval) routeTiming._frequencyTuple.first).getHigh();
                } else {
                    i2 = routeTiming._startTime;
                }
                i4 = Math.max(i4, i2);
            }
            if (i3 == i4) {
                textView.setText(String.format(getString(R.string.schedule_single_bus), jh1.g((long) i3)));
            } else {
                textView.setText(String.format(getString(R.string.schedule_first_last_bus), jh1.g((long) i3), jh1.g((long) i4)));
            }
            textView.setVisibility(0);
        }
        ListView listView = (ListView) findViewById(R.id.frequency_list);
        jj0 jj0 = new jj0(this, this.m);
        jj0.h = k0();
        listView.setAdapter((ListAdapter) jj0);
        listView.setSelection(k0());
    }

    public final int k0() {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
        instance.setTimeInMillis(System.currentTimeMillis());
        int i = instance.get(11);
        long j = (long) ((instance.get(12) * 60) + (i * SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT));
        int i2 = -1;
        for (Route.RouteTiming routeTiming : this.m) {
            if (!routeTiming._isFrequency) {
                i2++;
                if (j < ((long) routeTiming._startTime)) {
                    break;
                }
            } else {
                i2++;
                Pair<TimeInterval, Integer> pair = routeTiming._frequencyTuple;
                long low = (long) ((TimeInterval) pair.first).getLow();
                long high = (long) ((TimeInterval) pair.first).getHigh();
                if ((j >= low && j <= high) || low >= j) {
                    return i2;
                }
            }
        }
        return i2;
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        finish();
    }

    public void onEventMainThread(RouteDetailsEvent routeDetailsEvent) {
        if (this.m == null && routeDetailsEvent.getRouteId().equals(this.o)) {
            if (routeDetailsEvent.getResponseType().equals(ad1.SUCCESS)) {
                this.m = routeDetailsEvent.getRoute().getRouteTiming();
                this.n = routeDetailsEvent.getRoute().getStopSequence().get(0).getName();
                j0();
                return;
            }
            h0();
        }
    }

    @Override // defpackage.wt
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
