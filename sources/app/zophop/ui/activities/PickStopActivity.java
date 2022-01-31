package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import app.zophop.R;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.DatabaseSyncEvent;
import app.zophop.pubsub.eventbus.events.RouteDetailsEvent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import defpackage.k90;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickStopActivity extends ee0 {
    public static final /* synthetic */ int x = 0;
    public List<Stop> s;
    public TransitMode t;
    public k90.a u;
    public String v;
    public String w;

    public class a extends TypeToken<List<Stop>> {
        public a(PickStopActivity pickStopActivity) {
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PickStopActivity pickStopActivity = PickStopActivity.this;
            int i2 = PickStopActivity.x;
            Stop stop = (Stop) pickStopActivity.k.getAdapter().getItem(i);
            String json = new Gson().toJson(PickStopActivity.this.k.getAdapter().getItem(i));
            Intent intent = new Intent();
            intent.putExtra("result_picked_stop", json);
            PickStopActivity.this.setResult(-1, intent);
            if (view != null) {
                ((InputMethodManager) PickStopActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            if (PickStopActivity.this.getIntent().getStringExtra("stop_list_extra") == null) {
                xt.f3961a.b0().d(stop);
            }
            PickStopActivity.this.finish();
        }
    }

    @Override // defpackage.vf1, defpackage.tf1
    public void e(Bundle bundle) {
        this.t = TransitMode.getTransitMode(getIntent().getStringExtra("extra_mode"));
        if (getIntent().getStringExtra("extra_agency") != null) {
            this.v = getIntent().getStringExtra("extra_agency");
        }
        this.s = (List) new Gson().fromJson(getIntent().getStringExtra("stop_list_extra"), new a(this).getType());
        this.w = getIntent().getStringExtra("extra_route_id");
        getIntent().putExtra("extra:search_color", R.color.black_40);
        getIntent().putExtra("extra:search_copy", getString(R.string.enter_stop_search));
        super.e(bundle);
        if (r0()) {
            this.o.setVisibility(8);
        }
        p0();
        ed1 ed1 = new ed1("pick stop screen opened", Long.MIN_VALUE);
        if (getIntent().hasExtra("src")) {
            ed1.a("source", getIntent().getStringExtra("src"));
        }
        jz5.b().g(ed1);
    }

    @Override // defpackage.vf1
    public ListAdapter h0() {
        if (this.w == null || this.s != null) {
            return new lk0(this, this.t, this.s, this.v, new de0(this));
        }
        return new lk0(this, this.t, null, this.v, new de0(this));
    }

    @Override // defpackage.vf1
    public ListAdapter i0() {
        ArrayList arrayList;
        lk0 lk0 = new lk0(this, this.t, this.s, this.v, new de0(this));
        if (this.v != null) {
            arrayList = new ArrayList();
        } else {
            arrayList = (List<T>) this.s;
            if (arrayList == null) {
                if (this.w != null) {
                    arrayList = new ArrayList(1);
                } else {
                    xt.t1 t1Var = xt.f3961a;
                    if (t1Var.A().l()) {
                        Object[] array = t1Var.A().g(this.t).values().toArray();
                        int length = array.length;
                        ArrayList arrayList2 = new ArrayList(length);
                        for (Object obj : array) {
                            arrayList2.add((Stop) obj);
                        }
                        if (arrayList2.size() < 200) {
                            Collections.sort(arrayList2, new xi1());
                        }
                        arrayList = arrayList2;
                    } else {
                        arrayList = new ArrayList(1);
                    }
                }
            }
        }
        arrayList.size();
        lk0.g = arrayList;
        return lk0;
    }

    @Override // defpackage.vf1
    public AdapterView.OnItemClickListener j0() {
        return new b();
    }

    public void onEventMainThread(RouteDetailsEvent routeDetailsEvent) {
        if (routeDetailsEvent.getRouteId().equals(this.w) && routeDetailsEvent.getResponseType().equals(ad1.SUCCESS)) {
            this.o.setVisibility(8);
            this.s = routeDetailsEvent.getRoute().getStopSequence();
            String trim = this.l.getText().toString().trim();
            if (trim.length() == 0) {
                this.k.setAdapter(i0());
                return;
            }
            this.k.setAdapter((ListAdapter) new lk0(this, this.t, xt.f3961a.b().b(trim, this.s), this.v, new de0(this)));
        }
    }

    @Override // defpackage.ee0
    public void q0(k90.a aVar) {
        if (vn.K0(this) || this.s != null) {
            this.u = aVar;
        } else {
            this.u = k90.a.NETWORK_ERROR;
        }
        super.q0(aVar);
    }

    public boolean r0() {
        return xt.f3961a.A().l() || this.s != null;
    }

    public void onEventMainThread(DatabaseSyncEvent databaseSyncEvent) {
        DatabaseSyncEvent.STATUS status = databaseSyncEvent.getStatus();
        if (status.equals(DatabaseSyncEvent.STATUS.STOPS_DONE) || status.equals(DatabaseSyncEvent.STATUS.DONE)) {
            this.o.setVisibility(8);
            String trim = this.l.getText().toString().trim();
            if (trim.length() > 0) {
                ((Filterable) this.k.getAdapter()).getFilter().filter(trim);
            } else {
                this.k.setAdapter(i0());
            }
        }
    }
}
