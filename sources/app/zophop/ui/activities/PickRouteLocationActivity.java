package app.zophop.ui.activities;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.RouteInfo;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.BookingItemType;
import app.zophop.pubsub.eventbus.events.DatabaseSyncEvent;
import app.zophop.pubsub.eventbus.events.FetchRoutePassEvent;
import app.zophop.pubsub.eventbus.events.FetchRoutesEvent;
import app.zophop.pubsub.eventbus.events.LiveRouteDetailsEvent;
import app.zophop.ui.fragments.SchedulerInputFormFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import defpackage.k90;
import defpackage.ml0;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import server.zophop.logging.LoggingConstants;

public class PickRouteLocationActivity extends ee0 {
    public List<RouteInfo> A = new ArrayList();
    public List<RouteInfo> B = new ArrayList();
    public boolean C;
    public DialogFragment D;
    public RouteInfo E;
    public Handler F;
    public RouteInfo G;
    public boolean s;
    public String t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public String z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (PickRouteLocationActivity.this.D.isVisible()) {
                PickRouteLocationActivity.this.D.dismiss();
            }
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PickRouteLocationActivity pickRouteLocationActivity = PickRouteLocationActivity.this;
            if (!pickRouteLocationActivity.s) {
                RouteInfo routeInfo = (RouteInfo) pickRouteLocationActivity.k.getAdapter().getItem(i);
                RouteDetailsActivity.w0(PickRouteLocationActivity.this, routeInfo.getRouteId(), null, null, routeInfo.getTransitMode(), PickRouteLocationActivity.this.y ? "free rides pick route" : "schedulerRouteSearch");
                if (PickRouteLocationActivity.this.y) {
                    ed1 ed1 = new ed1("free rides card item clicked", Long.MIN_VALUE);
                    ed1.a("agency", routeInfo.getAgencyName().toLowerCase());
                    ed1.a("routeName", routeInfo.getRouteName());
                    ed1.a(LoggingConstants.ROUTE_ID, routeInfo.getRouteId());
                    ed1.a("fromStop", routeInfo.getFirstStopName());
                    ed1.a("toStop", routeInfo.getLastStopName());
                    hj1.K0(ed1, "source", "free rides pick route", ed1);
                } else {
                    ed1 ed12 = new ed1("schedule requested", Long.MIN_VALUE);
                    ed12.a("mode", TransitMode.bus.name());
                    ed12.a("route", routeInfo.getRouteId());
                    ed12.a(Constants.MessagePayloadKeys.FROM, routeInfo.getFirstStopName());
                    ed12.a("to", routeInfo.getLastStopName());
                    ed12.a("source", SchedulerInputFormFragment.e.MANUAL.toString());
                    jz5.b().g(ed12);
                    xt.f3961a.r().d(routeInfo.getRouteId(), routeInfo.getRouteName(), routeInfo.getFirstStopName(), routeInfo.getLastStopName(), null, routeInfo.getAgencyName(), routeInfo.get_updateSpecialFeaturesList(), routeInfo.isFreeRide(), routeInfo.getTransitMode());
                    ui1.t0("schedulerUsed");
                }
                PickRouteLocationActivity.this.v = true;
            } else if (pickRouteLocationActivity.w) {
                PickRouteLocationActivity.r0(pickRouteLocationActivity, (RouteInfo) pickRouteLocationActivity.k.getAdapter().getItem(i));
            } else if (pickRouteLocationActivity.x) {
                PickRouteLocationActivity.s0(pickRouteLocationActivity, (RouteInfo) pickRouteLocationActivity.k.getAdapter().getItem(i));
            } else {
                Intent intent = new Intent();
                intent.putExtra("result_route_info", new Gson().toJson((RouteInfo) PickRouteLocationActivity.this.k.getAdapter().getItem(i)));
                PickRouteLocationActivity.this.setResult(-1, intent);
                PickRouteLocationActivity.this.finish();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            PickRouteLocationActivity pickRouteLocationActivity = PickRouteLocationActivity.this;
            if (pickRouteLocationActivity.w) {
                PickRouteLocationActivity.r0(pickRouteLocationActivity, pickRouteLocationActivity.E);
            }
            PickRouteLocationActivity pickRouteLocationActivity2 = PickRouteLocationActivity.this;
            if (pickRouteLocationActivity2.x) {
                PickRouteLocationActivity.s0(pickRouteLocationActivity2, pickRouteLocationActivity2.G);
            }
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public d(PickRouteLocationActivity pickRouteLocationActivity, lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            this.f.dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            PickRouteLocationActivity pickRouteLocationActivity = PickRouteLocationActivity.this;
            if (pickRouteLocationActivity.w) {
                PickRouteLocationActivity.r0(pickRouteLocationActivity, pickRouteLocationActivity.E);
            }
            PickRouteLocationActivity pickRouteLocationActivity2 = PickRouteLocationActivity.this;
            if (pickRouteLocationActivity2.x) {
                PickRouteLocationActivity.s0(pickRouteLocationActivity2, pickRouteLocationActivity2.G);
            }
        }
    }

    public static void r0(PickRouteLocationActivity pickRouteLocationActivity, RouteInfo routeInfo) {
        Objects.requireNonNull(pickRouteLocationActivity);
        if (routeInfo != null) {
            pickRouteLocationActivity.t0();
            if (!pickRouteLocationActivity.D.isVisible()) {
                pickRouteLocationActivity.D.show(pickRouteLocationActivity.getFragmentManager(), "loader_tag");
            }
            pickRouteLocationActivity.E = routeInfo;
            xt.t1 t1Var = xt.f3961a;
            String name = t1Var.k().d().getName();
            pickRouteLocationActivity.v0();
            v40 U = t1Var.U();
            String routeId = routeInfo.getRouteId();
            TransitMode transitMode = TransitMode.bus;
            U.d(routeId, name);
        }
    }

    public static void s0(PickRouteLocationActivity pickRouteLocationActivity, RouteInfo routeInfo) {
        Objects.requireNonNull(pickRouteLocationActivity);
        if (routeInfo != null) {
            pickRouteLocationActivity.t0();
            if (!pickRouteLocationActivity.D.isVisible()) {
                pickRouteLocationActivity.D.show(pickRouteLocationActivity.getFragmentManager(), "loader_tag");
            }
            pickRouteLocationActivity.G = routeInfo;
            pickRouteLocationActivity.z = vn.t("routePass", routeInfo.getAgencyName());
            xt.t1 t1Var = xt.f3961a;
            String name = t1Var.k().d().getName();
            pickRouteLocationActivity.v0();
            v40 U = t1Var.U();
            String routeId = routeInfo.getRouteId();
            TransitMode transitMode = TransitMode.bus;
            U.d(routeId, name);
        }
    }

    @Override // defpackage.vf1, defpackage.tf1
    public void e(Bundle bundle) {
        getIntent().putExtra("extra:search_color", R.color.black_40);
        getIntent().putExtra("extra:search_copy", getString(R.string.enter_route_number));
        super.e(bundle);
        if (xt.f3961a.A().j()) {
            this.o.setVisibility(8);
        }
        this.s = getIntent().getStringExtra("is_for_result") != null;
        if (getIntent().getStringExtra("agency_name") != null) {
            this.t = getIntent().getStringExtra("agency_name");
        }
        this.u = getIntent().getStringExtra("is_for_mumbai_mticketing") != null;
        this.w = getIntent().getStringExtra("is_for_mticket") != null;
        if (getIntent().getStringExtra("is_for_route_pass") != null) {
            this.x = true;
            this.z = getIntent().getStringExtra("productId");
            this.B = getIntent().getParcelableArrayListExtra("routePassIds");
        } else {
            this.x = false;
        }
        this.y = getIntent().getBooleanExtra("showOnlyFreeRideRoutes", false);
        this.k.setAdapter(i0());
        this.F = new Handler();
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.D = fv0;
        if (fv0 == null) {
            fv0 T = vn.T(null, getString(R.string.loading), false, false);
            this.D = T;
            T.setRetainInstance(true);
        }
        this.k.setPadding(0, 0, 0, 0);
        this.j.setBackgroundColor(getResources().getColor(R.color.new_activity_color));
        p0();
        ed1 ed1 = new ed1("pick route screen opened", Long.MIN_VALUE);
        if (getIntent().hasExtra("src")) {
            ed1.a("source", getIntent().getStringExtra("src"));
        }
        jz5.b().g(ed1);
    }

    @Override // defpackage.vf1
    public ListAdapter h0() {
        return new ek0(this, new de0(this), this.t, this.u, this.w, this.x, this.z, this.y);
    }

    @Override // defpackage.vf1
    public ListAdapter i0() {
        ArrayList arrayList;
        ArrayList arrayList2;
        List<RouteInfo> list;
        View emptyView;
        if (!this.w || this.y) {
            ek0 ek0 = new ek0(this, new de0(this), this.t, this.u, this.w, this.x, this.z, this.y);
            if (this.w && this.A != null) {
                if (!this.C) {
                    xt.f3961a.c().j(this.y);
                    this.C = true;
                }
                arrayList = (List<T>) this.A;
            } else if (!this.x || (list = this.B) == null) {
                xt.t1 t1Var = xt.f3961a;
                if (t1Var.A().j()) {
                    arrayList = (List<T>) t1Var.A().f;
                    Collections.sort(arrayList, new wi1());
                    if (this.u) {
                        arrayList2 = new ArrayList();
                        for (T t2 : arrayList) {
                            if (t2.isMobileTicketing() && (this.t == null || t2.getAgencyName().equalsIgnoreCase(this.t))) {
                                arrayList2.add(t2);
                            }
                        }
                        Collections.sort(arrayList2, new wi1());
                    } else if (this.w) {
                        arrayList2 = new ArrayList();
                        for (T t3 : arrayList) {
                            if (t3.isMTicketEnabled() && (this.t == null || t3.getAgencyName().equalsIgnoreCase(this.t))) {
                                if (!this.y) {
                                    arrayList2.add(t3);
                                } else if (t3.isFreeRide()) {
                                    arrayList2.add(t3);
                                }
                            }
                        }
                        Collections.sort(arrayList2, new wi1());
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = new ArrayList(1);
                }
            } else {
                if (!this.C && list.size() == 0) {
                    xt.f3961a.c().c();
                    this.C = true;
                }
                arrayList = (List<T>) this.B;
            }
            ek0.g = arrayList;
            return ek0;
        }
        ListView listView = this.k;
        if (!(listView == null || (emptyView = listView.getEmptyView()) == null)) {
            View findViewById = emptyView.findViewById(R.id.empty_view_text);
            View findViewById2 = emptyView.findViewById(R.id.miscellaneous_text);
            emptyView.findViewById(R.id.connection_error_textview).setVisibility(8);
            if (findViewById != null) {
                ((TextView) findViewById).setText((CharSequence) null);
                findViewById.setVisibility(4);
            }
            if (findViewById2 != null) {
                ((TextView) findViewById2).setText((CharSequence) null);
                findViewById2.setVisibility(4);
            }
        }
        List<RouteInfo> c2 = xt.f3961a.d().c(BookingItemType.MTICKET);
        ArrayList arrayList3 = new ArrayList();
        if (c2 != null && c2.size() > 0) {
            arrayList3.add(new ml0.b(ml0.a.RECENT_SEARCH_STRING, null));
            for (RouteInfo routeInfo : c2) {
                arrayList3.add(new ml0.b(ml0.a.RECENT_ITEM, routeInfo));
            }
        }
        return new ml0(this, arrayList3, false);
    }

    @Override // defpackage.vf1
    public AdapterView.OnItemClickListener j0() {
        return new b();
    }

    public void onEvent(FetchRoutesEvent fetchRoutesEvent) {
        if (fetchRoutesEvent != null && fetchRoutesEvent.getResponseType() != null) {
            if (fetchRoutesEvent.getCityName() != null) {
                xt.t1 t1Var = xt.f3961a;
                if (t1Var.k().d() != null && fetchRoutesEvent.getCityName().equalsIgnoreCase(t1Var.k().d().getName())) {
                    if (fetchRoutesEvent.getResponseType().equals(ad1.SUCCESS)) {
                        this.A = fetchRoutesEvent.getRouteInfoList();
                    } else {
                        this.A = null;
                    }
                    if (this.l.getText().toString().trim().length() == 0) {
                        this.k.setAdapter(i0());
                    }
                }
            }
            jz5.b().m(fetchRoutesEvent);
        }
    }

    public void onEventMainThread(DatabaseSyncEvent databaseSyncEvent) {
        if (databaseSyncEvent.getStatus().equals(DatabaseSyncEvent.STATUS.DONE)) {
            String trim = this.l.getText().toString().trim();
            if (trim.length() > 0) {
                ((Filterable) this.k.getAdapter()).getFilter().filter(trim);
            } else {
                this.k.setAdapter(i0());
            }
        }
    }

    @Override // defpackage.vf1, defpackage.f0, defpackage.ve
    public void onStart() {
        super.onStart();
        if (this.v) {
            this.l.setText((CharSequence) null);
            this.k.setAdapter(i0());
        }
        this.v = false;
    }

    @Override // defpackage.ee0
    public void q0(k90.a aVar) {
        TextView textView = (TextView) this.k.getEmptyView().findViewById(R.id.miscellaneous_text);
        String obj = this.l.getText().toString();
        if (obj == null || obj.length() == 0) {
            textView.setText((CharSequence) null);
        } else if (aVar == null || !aVar.equals(k90.a.NO_MATCH_FOUND) || !this.w) {
            super.q0(aVar);
        } else {
            textView.setText(getString(R.string.no_mticket_entries_found));
            textView.setVisibility(0);
        }
    }

    public final void t0() {
        this.F.post(new a());
    }

    public final void u0(RouteInfo routeInfo, boolean z2) {
        BookingItemType bookingItemType = BookingItemType.MTICKET;
        if (bookingItemType != null && routeInfo != null) {
            if (!z2) {
                xt.f3961a.d().a(bookingItemType, routeInfo.getRouteId(), routeInfo.getRouteName(), routeInfo.getFirstStopName(), routeInfo.getLastStopName(), routeInfo.getAgencyName(), routeInfo.getSpecialFeatures(), routeInfo.get_updateSpecialFeaturesList(), routeInfo.isFreeRide());
            } else {
                xt.f3961a.d().b(bookingItemType, routeInfo.getRouteId());
            }
        }
    }

    public final void v0() {
        Snackbar snackbar = this.i;
        if (snackbar != null) {
            snackbar.b(3);
        }
    }

    public final void w0(int i, int i2, boolean z2, boolean z3, View.OnClickListener onClickListener, int i3, int i4, int i5) {
        if (z2) {
            v0();
            String string = getString(i);
            Snackbar j = Snackbar.j(findViewById(R.id.pick_location_container), vn.k(string, 0, string.length(), i3, true), -2);
            this.i = j;
            j.c.setBackgroundColor(i5);
            if (z3) {
                String string2 = getString(i2);
                this.i.k(vn.k(string2, 0, string2.length(), i4, true), onClickListener);
                this.i.l(i4);
                TextView textView = (TextView) this.i.c.findViewById(R.id.snackbar_action);
                textView.setTypeface(textView.getTypeface(), 1);
            }
            this.i.m();
            return;
        }
        v0();
    }

    public void onEvent(FetchRoutePassEvent fetchRoutePassEvent) {
        if (fetchRoutePassEvent != null && fetchRoutePassEvent.getResponseType() != null) {
            if (fetchRoutePassEvent.getCityName() != null) {
                xt.t1 t1Var = xt.f3961a;
                if (t1Var.k().d() != null && fetchRoutePassEvent.getCityName().equalsIgnoreCase(t1Var.k().d().getName())) {
                    if (fetchRoutePassEvent.getResponseType().equals(ad1.SUCCESS)) {
                        this.B = fetchRoutePassEvent.getRouteInfoList();
                    } else {
                        this.B = new ArrayList();
                    }
                    if (this.l.getText().toString().trim().length() == 0) {
                        this.k.setAdapter(i0());
                    }
                }
            }
            jz5.b().m(fetchRoutePassEvent);
        }
    }

    public void onEvent(LiveRouteDetailsEvent liveRouteDetailsEvent) {
        v0();
        t0();
        if (liveRouteDetailsEvent == null || liveRouteDetailsEvent.getResponseType() == null) {
            w0(R.string.fetching_route_details_failed, R.string.retry, true, true, new c(), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
            return;
        }
        if (!liveRouteDetailsEvent.getResponseType().equals(ad1.SUCCESS)) {
            w0(R.string.fetching_route_details_failed, R.string.retry, true, true, new e(), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
        } else if (liveRouteDetailsEvent.getRoute() != null) {
            if (this.E == null || !liveRouteDetailsEvent.getRouteId().equals(this.E.getRouteId())) {
                if (this.G != null && liveRouteDetailsEvent.getRouteId().equals(this.G.getRouteId())) {
                    Intent intent = new Intent();
                    intent.putExtra("result_route_info", new Gson().toJson(this.G));
                    intent.putExtra("result_route", new Gson().toJson(liveRouteDetailsEvent.getRoute()));
                    intent.putExtra("productId", this.z);
                    setResult(-1, intent);
                    finish();
                }
            } else if (liveRouteDetailsEvent.getRoute().isMTicketEnabled()) {
                u0(this.E, false);
                Intent intent2 = new Intent();
                intent2.putExtra("result_route_info", new Gson().toJson(this.E));
                intent2.putExtra("result_route", new Gson().toJson(liveRouteDetailsEvent.getRoute()));
                setResult(-1, intent2);
                finish();
            } else {
                u0(this.E, true);
                lm0 a2 = lm0.a(getFragmentManager(), getResources().getString(R.string.title_dialog_mticket_disabled_route), getResources().getString(R.string.msg_dialog_mticket_disabled_route, this.E.getRouteName()), getResources().getString(R.string.ok), null);
                d dVar = new d(this, a2);
                TextView textView = a2.i;
                if (textView != null) {
                    textView.setOnClickListener(dVar);
                } else {
                    a2.q = dVar;
                }
            }
        }
        jz5.b().m(liveRouteDetailsEvent);
    }
}
