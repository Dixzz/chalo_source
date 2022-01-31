package app.zophop.ui.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.StopFavourite;
import app.zophop.models.Stop;
import app.zophop.models.UniversalSearchItem;
import app.zophop.pubsub.eventbus.events.FavoriteAddedEvent;
import app.zophop.pubsub.eventbus.events.UniversalSearchResponseEvent;
import app.zophop.service.LocationTrackingService;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import defpackage.bj0;
import defpackage.gl0;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class PickLocationActivity extends uf1 {
    public static final /* synthetic */ int u = 0;
    public gl0 s;
    public String t;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent();
            PickLocationActivity pickLocationActivity = PickLocationActivity.this;
            int i2 = PickLocationActivity.u;
            if (pickLocationActivity.k.getAdapter().getItem(i) instanceof Stop) {
                Gson gson = new Gson();
                Stop stop = (Stop) PickLocationActivity.this.k.getAdapter().getItem(i);
                intent.putExtra("result:picked_stop", gson.toJson(stop));
                String name = stop.getName();
                LatLng latLong = stop.getLatLong();
                JSONObject jSONObject = new JSONObject();
                String str = null;
                if (latLong != null) {
                    try {
                        jSONObject.put("lat", latLong.latitude);
                        jSONObject.put("long", latLong.longitude);
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put(FirebaseAnalytics.Param.LOCATION, name);
                jSONObject.put("placeId", (Object) null);
                jSONObject.put("description", name);
                str = jSONObject.toString();
                intent.putExtra("result:picked_location", str);
            } else {
                intent.putExtra("result:picked_location", ((mf1) PickLocationActivity.this.k.getAdapter().getItem(i)).b());
            }
            PickLocationActivity.this.setResult(-1, intent);
            PickLocationActivity.this.finish();
        }
    }

    @Override // defpackage.tf1
    public void d0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.MODE_CHANGED");
        intentFilter.addAction("android.location.PROVIDER_CHANGED_ACTION");
        this.g = new fh1();
        he1 he1 = new he1();
        this.h = he1;
        registerReceiver(he1, intentFilter);
        registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // defpackage.vf1, defpackage.tf1
    public void e(Bundle bundle) {
        jz5.b().l(UniversalSearchResponseEvent.class);
        if (!getIntent().hasExtra("extra:search_copy")) {
            getIntent().putExtra("extra:search_copy", getString(R.string.enter_location));
        }
        getIntent().putExtra("extra:search_color", R.color.black_40);
        if (getIntent().hasExtra("extra:source")) {
            this.t = getIntent().getStringExtra("extra:source");
        } else {
            this.t = "pickLocation";
        }
        super.e(bundle);
        String stringExtra = getIntent().getStringExtra("extra:show_extra_locations");
        if ((stringExtra != null && stringExtra.equals("true")) || p0()) {
            this.k.setAdapter(i0());
        }
    }

    @Override // defpackage.tf1
    public void g0() {
        if (!LocationTrackingService.l) {
            unregisterReceiver(this.g);
            unregisterReceiver(this.h);
        }
    }

    @Override // defpackage.vf1
    public ListAdapter h0() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.location_list_container);
        findViewById(R.id.pick_location_container).setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
        return new tj0(this, this.t, getIntent().getBooleanExtra("extra:show_locations", true), getIntent().getBooleanExtra("extra:show_stops", true));
    }

    @Override // defpackage.vf1
    public ListAdapter i0() {
        String stringExtra = getIntent().getStringExtra("extra:show_extra_locations");
        if ((stringExtra == null || !stringExtra.equals("true")) && !p0()) {
            return null;
        }
        findViewById(R.id.pick_location_container).setBackgroundColor(getApplicationContext().getResources().getColor(R.color.picker_view_empty_list_color));
        ((LinearLayout) findViewById(R.id.location_list_container)).setPadding(0, 0, 0, getApplicationContext().getResources().getDimensionPixelSize(R.dimen.favorite_empty_list_top_padding));
        ArrayList arrayList = new ArrayList();
        xt.t1 t1Var = xt.f3961a;
        b60 Y = t1Var.Y();
        if (p0()) {
            LatLng h = t1Var.B().h();
            if (vn.K0(this) && h != null) {
                arrayList.add(new gl0.d(gl0.c.MY_LOCATION, new mf1(h)));
            }
        } else {
            if (Y.g().b.contains("work") || !Y.g().b.contains("home")) {
                arrayList.add(new gl0.d(gl0.c.SET_HOME, Y.h("home")));
                arrayList.add(new gl0.d(gl0.c.DIVIDER, (mf1) null));
                arrayList.add(new gl0.d(gl0.c.SET_WORK, Y.h("work")));
            } else {
                arrayList.add(new gl0.d(gl0.c.SET_WORK, (mf1) null));
                arrayList.add(new gl0.d(gl0.c.DIVIDER, (mf1) null));
                arrayList.add(new gl0.d(gl0.c.SET_HOME, Y.h("home")));
            }
            arrayList.add(new gl0.d(gl0.c.DIVIDER, (mf1) null));
            Iterator<mf1> it = Y.d().iterator();
            while (it.hasNext()) {
                arrayList.add(new gl0.d(gl0.c.FAVORITE_ITEM, it.next()));
                arrayList.add(new gl0.d(gl0.c.DIVIDER, (mf1) null));
            }
            ArrayList<pf1> e = Y.e();
            List<StopFavourite> c = xt.f3961a.b0().c(RouteStoreType.RECENT);
            ArrayList arrayList2 = new ArrayList();
            if (e.size() > 0 || c.size() > 0) {
                arrayList.add(new gl0.d(gl0.c.RECENT_SEARCH_STRING, (mf1) null));
                for (StopFavourite stopFavourite : c) {
                    arrayList2.add(new bj0.k(bj0.l.FAVORITE_ITEM_STOP, stopFavourite));
                }
                Iterator<pf1> it2 = e.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new bj0.k(bj0.l.RECENT_LOCATION, it2.next()));
                }
            }
            Collections.sort(arrayList2, new cf0(this));
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                bj0.k kVar = (bj0.k) it3.next();
                if (kVar.f438a.equals(bj0.l.FAVORITE_ITEM_STOP)) {
                    arrayList.add(new gl0.d(gl0.c.STOP, ((StopFavourite) kVar.b).getStop()));
                    arrayList.add(new gl0.d(gl0.c.DIVIDER, (mf1) null));
                } else if (kVar.f438a.equals(bj0.l.RECENT_LOCATION)) {
                    arrayList.add(new gl0.d(gl0.c.RECENT_ITEM, kVar.d.f2797a));
                    arrayList.add(new gl0.d(gl0.c.DIVIDER, (mf1) null));
                }
            }
        }
        gl0 gl0 = new gl0(this, arrayList, this.t);
        this.s = gl0;
        return gl0;
    }

    @Override // defpackage.vf1, defpackage.uf1
    public AdapterView.OnItemClickListener j0() {
        return new a();
    }

    @Override // defpackage.vf1
    public void m0() {
        ui1.g(this, xt.f3961a.z().b());
    }

    @Override // defpackage.vf1
    public void n0() {
        super.n0();
        findViewById(R.id.location_search_container).setBackgroundResource(R.drawable.favorite_actionbar_search_bg);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        if (intent != null && (stringExtra = intent.getStringExtra("result:picked_location")) != null) {
            mf1 a2 = mf1.a(stringExtra);
            if (i == 1) {
                if (xt.f3961a.Y().m(a2, "Home", "home")) {
                    q0();
                }
            } else if (i == 2 && xt.f3961a.Y().m(a2, "Work", "work")) {
                q0();
            }
        }
    }

    public void onEvent(FavoriteAddedEvent favoriteAddedEvent) {
        if (favoriteAddedEvent.getIsFavoriteAdded()) {
            Toast.makeText(this, getString(R.string.favorite_added_toast), 0).show();
        } else {
            Toast.makeText(this, getString(R.string.favorite_not_added_toast), 0).show();
        }
        q0();
        jz5.b().m(favoriteAddedEvent);
    }

    public void onEventMainThread(UniversalSearchResponseEvent universalSearchResponseEvent) {
        if (getIntent().getBooleanExtra("extra:show_stops", true) && this.l != null && universalSearchResponseEvent.getSearchQuery().equals(this.l.getText().toString())) {
            h0();
            tj0 tj0 = (tj0) this.k.getAdapter();
            List<UniversalSearchItem> itemList = universalSearchResponseEvent.getItemList();
            Objects.requireNonNull(tj0);
            tj0.j = new ArrayList();
            for (UniversalSearchItem universalSearchItem : itemList) {
                if ((universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.STOP) && tj0.l) || (universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.LOCATION) && tj0.m)) {
                    tj0.j.add(universalSearchItem);
                }
            }
            ((tj0) this.k.getAdapter()).notifyDataSetChanged();
            findViewById(app.zophop.utilities.R.id.loading_spinner).setVisibility(8);
            jz5.b().m(universalSearchResponseEvent);
        }
    }

    @Override // defpackage.ve, defpackage.tf1
    public void onResume() {
        PopupWindow popupWindow;
        super.onResume();
        gl0 gl0 = this.s;
        if (gl0 != null && (popupWindow = gl0.j) != null && popupWindow.isShowing()) {
            gl0.j.update();
        }
    }

    @Override // defpackage.uf1
    public void q0() {
        if (this.k.getAdapter() instanceof gl0) {
            this.k.setAdapter(i0());
        }
    }
}
