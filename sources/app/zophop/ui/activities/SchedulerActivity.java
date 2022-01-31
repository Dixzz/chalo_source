package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import app.zophop.R;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RailFavourite;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.DatabaseSyncEvent;
import app.zophop.pubsub.eventbus.events.SchedulerInputEvent;
import app.zophop.ui.fragments.SchedulerInputFormFragment;
import app.zophop.utilities.ui.views.sliding_tabs.HorizontalTabScrollWithViewPager;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import defpackage.s30;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;

public class SchedulerActivity extends wt {
    public int l;
    public HorizontalTabScrollWithViewPager m;
    public ViewPager n;
    public List<TransitMode> o;
    public Favourite p;
    public MenuItem q;
    public boolean r;
    public int s = R.drawable.favorites_save;
    public boolean t = false;
    public TransitMode u;
    public va1 v;
    public k00 w;
    public Map<TransitMode, Pair<Stop, Stop>> x;
    public String y;

    public static void j0(Context context, Favourite favourite, String str) {
        Intent intent = new Intent(context, SchedulerActivity.class);
        intent.putExtra("extar:transit_mode", favourite.getMode().name());
        intent.putExtra("extra:fav_type", favourite.getType().name());
        intent.putExtra("extra_favorite", new Gson().toJson(favourite));
        intent.putExtra("extra:origin", str);
        context.startActivity(intent);
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        this.l = getIntent().getIntExtra("extra:tab_pos", 0);
        if (getIntent().getStringExtra("extar:transit_mode") != null) {
            this.u = TransitMode.getTransitMode(getIntent().getStringExtra("extar:transit_mode"));
        }
        xt.t1 t1Var = xt.f3961a;
        this.w = t1Var.y();
        g30 g30 = new g30(getIntent());
        if (g30.a()) {
            if (g30.f1208a.containsKey("source")) {
                this.w.a("schedulerScreen", g30.f1208a.get("source"), g30.f1208a.get("tag"));
            }
            e80 k = t1Var.k();
            LatLng h = t1Var.B().h();
            if (h != null) {
                ui1.c(this, k, h, SchedulerActivity.class, false, SchedulerActivity.class.getSimpleName());
            }
        }
        if (t1Var.A().j()) {
            t1Var.J().b();
        }
        this.p = SchedulerInputFormFragment.c(getIntent().getStringExtra("extra:fav_type"), getIntent().getStringExtra("extra_favorite"));
        this.y = getIntent().getStringExtra("extra:origin");
        setContentView(R.layout.schedular_screen);
        this.m = (HorizontalTabScrollWithViewPager) findViewById(R.id.schedular_tabs);
        setSupportActionBar((Toolbar) findViewById(R.id.schedular_screen_action_tool_bar));
        getSupportActionBar().z(getString(R.string.scheduler_activity_toolbar_title));
        getSupportActionBar().o(true);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        this.n = viewPager;
        viewPager.setOffscreenPageLimit(3);
        ArrayList arrayList = new ArrayList(t1Var.k().d().getModes());
        this.o = arrayList;
        Collections.sort(arrayList, new vi1());
        this.n.setAdapter(new hk0(getFragmentManager(), this, this.o, this.p, this.y));
        if (this.o.size() == 1) {
            this.m.setVisibility(8);
        } else {
            this.m.setDistributeEvenly(true);
            this.m.setSelectedIndicatorColors(Color.parseColor("#fe7c00"));
            this.m.c(R.layout.screen_tabs, R.id.tab_title);
            this.m.setViewPager(this.n);
            TransitMode transitMode = this.u;
            if (transitMode != null) {
                HorizontalTabScrollWithViewPager horizontalTabScrollWithViewPager = this.m;
                horizontalTabScrollWithViewPager.l.setCurrentItem(this.o.indexOf(transitMode));
            } else {
                HorizontalTabScrollWithViewPager horizontalTabScrollWithViewPager2 = this.m;
                horizontalTabScrollWithViewPager2.l.setCurrentItem(this.l);
            }
        }
        this.x = new HashMap();
    }

    public final void h0() {
        Pair<Stop, Stop> pair = this.x.get(this.o.get(this.n.getCurrentItem()));
        if (pair != null) {
            Stop stop = (Stop) pair.first;
            Stop stop2 = (Stop) pair.second;
            MenuItem menuItem = this.q;
            if (menuItem != null) {
                menuItem.setVisible(true);
            } else {
                this.t = true;
            }
            if (!this.r) {
                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.scheduler_main_container);
                va1 va1 = null;
                if (!(xt.f3961a.l().h.optString("favourite:tutorial_shown", null) != null)) {
                    va1 = vn.a1(this, "favourite:tutorial_shown", null);
                }
                this.v = va1;
                this.r = true;
            }
            if (i0(stop, stop2)) {
                l0(true);
            } else {
                l0(false);
            }
        } else {
            MenuItem menuItem2 = this.q;
            if (menuItem2 != null) {
                menuItem2.setVisible(false);
            } else {
                this.t = false;
            }
            va1 va12 = this.v;
            if (va12 != null && this.r) {
                if (va12.e.getParent() != null) {
                    va12.b.removeView(va12.e);
                }
                this.r = false;
            }
        }
    }

    public boolean i0(Stop stop, Stop stop2) {
        return xt.f3961a.r().g(stop, stop2, RouteStoreType.FAVORITE) != null;
    }

    public final void k0(Favourite favourite, boolean z) {
        if (favourite instanceof RailFavourite) {
            RailFavourite railFavourite = (RailFavourite) favourite;
            c80.q("scheduler activity", "", railFavourite.getFromStop().getName(), railFavourite.getToStop().getName(), favourite.getMode(), z);
            return;
        }
        BusFavourite busFavourite = (BusFavourite) favourite;
        c80.q("scheduler activity", busFavourite.getRouteName(), busFavourite.getStartStopName(), busFavourite.getEndStopName(), TransitMode.bus, z);
    }

    public final void l0(boolean z) {
        if (z) {
            MenuItem menuItem = this.q;
            if (menuItem != null) {
                menuItem.setIcon(R.drawable.favorites_saved);
            } else {
                this.s = R.drawable.favorites_saved;
            }
        } else {
            MenuItem menuItem2 = this.q;
            if (menuItem2 != null) {
                menuItem2.setIcon(R.drawable.favorites_save);
            } else {
                this.s = R.drawable.favorites_save;
            }
        }
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.scheduler_screen_menu, menu);
        MenuItem findItem = menu.findItem(R.id.menu_scheduler_fav);
        this.q = findItem;
        findItem.setIcon(this.s);
        this.q.setOnMenuItemClickListener(new of0(this));
        this.q.setVisible(this.t);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        s30 J = xt.f3961a.J();
        Objects.requireNonNull(J);
        J.d = s30.b.NOT_STARTED;
        J.f3176a = null;
        J.b = null;
        ScheduledFuture<?> scheduledFuture = J.e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        super.onDestroy();
    }

    public void onEvent(rd1 rd1) {
        h0();
    }

    public void onEventMainThread(DatabaseSyncEvent databaseSyncEvent) {
        if (databaseSyncEvent.getStatus().equals(DatabaseSyncEvent.STATUS.DONE)) {
            this.m.setDistributeEvenly(true);
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.A().j()) {
                t1Var.J().b();
            }
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
        h0();
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        jz5.b().o(this);
        super.onStop();
    }

    public void onEvent(SchedulerInputEvent schedulerInputEvent) {
        this.x.put(schedulerInputEvent.getMode(), new Pair<>(schedulerInputEvent.getFromStop(), schedulerInputEvent.getToStop()));
        jz5.b().m(schedulerInputEvent);
        h0();
    }
}
