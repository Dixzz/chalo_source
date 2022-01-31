package app.zophop.ui.activities;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import app.zophop.R;
import app.zophop.models.Favourites.FavType;
import app.zophop.models.Favourites.RecentTripConvertor;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.TripFavourite;
import app.zophop.models.LocationTripRequest;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.TripRequest;
import app.zophop.pubsub.eventbus.events.TripPlannerInputLocationChangedEvent;
import app.zophop.ui.views.collapse_on_scroll.CollapseOnScrollViewPager;
import app.zophop.utilities.ui.views.sliding_tabs.HorizontalTabScrollWithViewPager;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.razorpay.AnalyticsConstants;
import defpackage.e44;
import defpackage.fv0;
import defpackage.nn0;
import defpackage.sm0;
import defpackage.xt;
import io.github.inflationx.calligraphy3.TypefaceUtils;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TripPlanningActivity extends au implements fv0.c {
    public static final /* synthetic */ int B = 0;
    public g34 A;
    @InjectView(R.id.collpase_view)
    public CollapseOnScrollViewPager _collaspeScrollView;
    @InjectView(R.id.header)
    public View _inputForm;
    @InjectView(R.id.map_container)
    public View _mapContainer;
    @InjectView(R.id.pages)
    public ViewPager _pages;
    @InjectView(R.id.preference_hook)
    public View _preferenceHook;
    @InjectView(R.id.tabs)
    public HorizontalTabScrollWithViewPager _tabs;
    @InjectView(R.id.tabs_line_above)
    public View _tabsLineAbove;
    public mf1 k;
    public mf1 l;
    public Marker m;
    public Marker n;
    public TripRequest o;
    public int p = -1;
    public e44 q;
    public TextView r;
    public TextView s;
    public boolean t;
    public k00 u;
    public p5 v;
    public boolean w;
    public boolean x;
    public ah1 y;
    public DialogFragment z;

    public class a implements e44.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LatLng f302a;

        public a(LatLng latLng) {
            this.f302a = latLng;
        }

        @Override // defpackage.e44.g
        public void a() {
            TripPlanningActivity.this.q.g(hd3.i2(this.f302a));
        }
    }

    public static void m0(Activity activity, mf1 mf1, mf1 mf12, boolean z2) {
        Intent intent = new Intent(activity, TripPlanningActivity.class);
        if (mf1 == null) {
            xt.t1 t1Var = xt.f3961a;
            LatLng h = t1Var.B().h();
            if (h != null && t1Var.k().d().containsLocation(h)) {
                mf1 = new mf1(h, activity.getString(R.string.my_location));
            }
        }
        if (mf1 != null) {
            intent.putExtra("extra:from", mf1.b());
        }
        if (mf12 != null) {
            intent.putExtra("extra:to", mf12.b());
        }
        intent.putExtra("extra_recent_trip", z2);
        activity.startActivity(intent);
    }

    public static void u0(TextView textView, String str, Context context) {
        if (str != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String[] split = str.split(",");
            int i = 0;
            while (i < 1 && i < split.length) {
                spannableStringBuilder.append((CharSequence) split[i]);
                i++;
            }
            int length = spannableStringBuilder.length();
            while (i < split.length) {
                spannableStringBuilder.append((CharSequence) ",");
                spannableStringBuilder.append((CharSequence) split[i]);
                i++;
            }
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), length, spannableStringBuilder.length(), 17);
            spannableStringBuilder.setSpan(TypefaceUtils.getSpan(TypefaceUtils.load(context.getAssets(), "fonts/NotoSans-Regular.ttf")), length, spannableStringBuilder.length(), 17);
            textView.setText(spannableStringBuilder);
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        mf1 mf1;
        mf1 mf12;
        setContentView(R.layout.trip_planning_screen);
        ButterKnife.inject(this);
        jz5.b().l(TripPlannerInputLocationChangedEvent.class);
        xt.t1 t1Var = xt.f3961a;
        this.y = new ah1(this, t1Var.B().a());
        this.p = ui1.N();
        ui1.z0(this, "tripPlannerPreferences");
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        getSupportActionBar().z(getString(R.string.trip_planner_activity_label));
        t1Var.B();
        this.v = new p5(this);
        this.u = t1Var.y();
        this.p = ui1.N();
        Intent intent = getIntent();
        g30 g30 = new g30(intent);
        boolean z2 = false;
        if (g30.a()) {
            if (g30.f1208a.containsKey("source")) {
                this.u.a("tripPlanningScreen", g30.f1208a.get("source"), g30.f1208a.get("tag"));
            }
            if (g30.f1208a.containsKey("source")) {
                String str = g30.f1208a.get("source");
                this.k = new mf1(str, str);
                t1Var.B().c(str);
            } else {
                LatLng h = t1Var.B().h();
                this.k = h != null ? new mf1(getString(R.string.my_location), h) : null;
            }
            if (g30.f1208a.containsKey(FirebaseAnalytics.Param.DESTINATION)) {
                String str2 = g30.f1208a.get(FirebaseAnalytics.Param.DESTINATION);
                LatLng latLng = g30.f1208a.containsKey("lat") && g30.f1208a.containsKey("lon") ? new LatLng(Double.parseDouble(g30.f1208a.get("lat")), Double.parseDouble(g30.f1208a.get("lon"))) : null;
                if (str2 != null && latLng != null) {
                    this.l = new mf1(str2, latLng);
                } else if (str2 == null && latLng != null) {
                    this.l = new mf1(latLng);
                    t1Var.B().f(latLng);
                } else if (str2 != null && latLng == null) {
                    this.l = new mf1(str2, str2);
                    t1Var.B().c(str2);
                }
            }
            e80 k2 = t1Var.k();
            LatLng h2 = t1Var.B().h();
            if (h2 != null) {
                ui1.c(this, k2, h2, TripPlanningActivity.class, false, TripPlanningActivity.class.getSimpleName());
            }
            if (!(this.k == null || this.l == null)) {
                Toast.makeText(this, getString(R.string.click_get_route_for_fastest_way), 1).show();
            }
            this.v.b(h.R(this));
        } else {
            String stringExtra = intent.getStringExtra("extra:from");
            if (stringExtra == null) {
                mf1 = null;
            } else {
                mf1 = mf1.a(stringExtra);
            }
            this.k = mf1;
            if (mf1 != null && ui1.r(mf1) && !i0(this.k.f2368a)) {
                Toast.makeText(this, getString(R.string.location_outside_city_toast), 0).show();
                this.k = null;
            }
            String stringExtra2 = intent.getStringExtra("extra:to");
            if (stringExtra2 == null) {
                mf12 = null;
            } else {
                mf12 = mf1.a(stringExtra2);
            }
            this.l = mf12;
            if (mf12 != null && ui1.r(mf12) && !i0(this.l.f2368a)) {
                Toast.makeText(this, getString(R.string.location_outside_city_toast), 0).show();
                this.l = null;
            }
            boolean booleanExtra = intent.getBooleanExtra("openPickerScreen", false);
            this.w = booleanExtra;
            this.x = booleanExtra;
        }
        if (bundle != null) {
            if (bundle.containsKey(RecentTripConvertor.KEY_FROM_LOCATION)) {
                this.k = mf1.a(bundle.getString(RecentTripConvertor.KEY_FROM_LOCATION));
            }
            if (bundle.containsKey(RecentTripConvertor.KEY_TO_LOCATION)) {
                this.l = mf1.a(bundle.getString(RecentTripConvertor.KEY_TO_LOCATION));
            }
            this.w = bundle.getBoolean("openPickerScreen", false);
        }
        this._collaspeScrollView.setScrollable(false);
        fg0 fg0 = new fg0(this);
        this.s = (TextView) findViewById(R.id.scheduler_time);
        this.r = (TextView) findViewById(R.id.done_text);
        findViewById(R.id.time_container).setOnClickListener(fg0);
        View findViewById = findViewById(R.id.input_from);
        View findViewById2 = findViewById(R.id.input_to);
        findViewById.setOnClickListener(new ig0(this, 0));
        findViewById2.setOnClickListener(new ig0(this, 1));
        this.r.setOnClickListener(new gg0(this));
        ((ImageButton) findViewById(R.id.swap_planner_button)).setOnClickListener(new hg0(this));
        t0();
        h0();
        if (this.w) {
            new ig0(this, 1).onClick(findViewById(R.id.input_to));
        }
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.z = fv0;
        if (fv0 == null) {
            fv0 T = vn.T(null, getString(R.string.loading_location), false, false);
            this.z = T;
            Bundle arguments = T.getArguments();
            if (arguments != null) {
                arguments.putBoolean("show_cancel_button", true);
            }
            this.z.setRetainInstance(true);
        }
        if (k0()) {
            j0(false);
            return;
        }
        findViewById(R.id.map_container).setVisibility(0);
        ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).e(new eg0(this));
        if (!t1Var.l().h.has("isLocationDialogShownInTripPlanner")) {
            mf1 mf13 = this.k;
            if (!(mf13 == null || mf13.f2368a == null)) {
                z2 = true;
            }
            if (!z2 && ui1.T(this, "android.permission.ACCESS_FINE_LOCATION")) {
                this.y.b(getString(R.string.gps_not_available_toast));
                t1Var.l().put("isLocationDialogShownInTripPlanner", String.valueOf(true));
            }
        }
    }

    public final void h0() {
        if (vn.K0(this)) {
            e0();
            this.t = false;
        } else if (!this.t) {
            this.t = f0(this._mapContainer);
        }
    }

    public final boolean i0(LatLng latLng) {
        return xt.f3961a.k().d().containsLocation(latLng);
    }

    public final void j0(boolean z2) {
        jz5.b().l(TripPlannerInputLocationChangedEvent.class);
        o0();
        this.r.setVisibility(8);
        findViewById(R.id.dummyView).setVisibility(0);
        if (findViewById(R.id.map_container).getVisibility() == 0) {
            findViewById(R.id.map_container).startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom_up));
            this._mapContainer.setVisibility(8);
        }
        this._pages.setVisibility(0);
        this._preferenceHook.setVisibility(0);
        this._collaspeScrollView.setScrollable(true);
        this._tabsLineAbove.setVisibility(0);
        xt.f3961a.k().d();
        List<l90> singletonList = Collections.singletonList(l90.ALL_TRANSIT);
        this._collaspeScrollView.setResultTabItems(singletonList);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pages);
        this._pages = viewPager;
        viewPager.setAdapter(new ck0(getFragmentManager(), this, singletonList, this.o));
        this._tabs.setSelectedIndicatorColors(getResources().getColor(R.color.orange_primary));
        this._tabs.c(R.layout.trip_planner_tabs, R.id.tab_title);
        this._tabs.setViewPager(this._pages);
        n0();
        getSupportActionBar().z(getString(R.string.trip_planner_result_activity_label));
        ed1 l2 = hj1.l("get route clicked", Long.MIN_VALUE, "source", "trip plannig activity button");
        hj1.d(z2, l2, "isUserAction", l2);
    }

    public final boolean k0() {
        mf1 mf1;
        mf1 mf12 = this.k;
        return (mf12 == null || (mf1 = this.l) == null || mf12.f2368a == null || mf1.f2368a == null) ? false : true;
    }

    public final boolean l0(qe1 qe1, mf1 mf1) {
        LatLng latLng;
        return (mf1 == null || (latLng = mf1.f2368a) == null || !latLng.equals(qe1.b)) ? false : true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Ljava/util/List<Ll90;>;)V */
    public final void n0() {
        this._pages.setCurrentItem(0);
    }

    public final void o0() {
        jz5.b().l(sm0.b.class);
        jz5.b().l(nn0.a.class);
        this.o = new LocationTripRequest(this.k, this.l, this.p);
        if (this._mapContainer.getVisibility() == 8 && k0()) {
            jz5.b().i(new TripPlannerInputLocationChangedEvent(TripPlannerInputLocationChangedEvent.RESPONSE_TYPE.TRIP_REQUEST, this.o));
        }
        if (k0() && this.k.c != null && this.l.c != null) {
            xt.f3961a.i0().g(new TripFavourite(FavType.TRIP, this.k, this.l, UUID.randomUUID().toString(), TransitMode.bus, System.currentTimeMillis(), RouteStoreType.RECENT));
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 0) {
            if (i != 99 && this.w) {
                finish();
            }
        } else if (i2 != -1) {
        } else {
            if (i == 99) {
                this.A = new dg0(this);
                if (!this.z.isVisible()) {
                    this.z.show(getFragmentManager(), "loader_tag");
                }
                je1 B2 = xt.f3961a.B();
                LocationRequest locationRequest = new LocationRequest();
                locationRequest.m1(100);
                locationRequest.l1(1000);
                B2.b(locationRequest, this.A);
                return;
            }
            this.w = false;
            String stringExtra = intent.getStringExtra("result:picked_location");
            String stringExtra2 = intent.hasExtra("result:picked_stop") ? intent.getStringExtra("result:picked_stop") : null;
            mf1 a2 = mf1.a(stringExtra);
            if (i == 0) {
                this.k = a2;
                q0(true);
            } else if (i == 1) {
                this.l = a2;
                q0(false);
            }
            if (ui1.r(a2)) {
                if (!i0(a2.f2368a)) {
                    if (i == 0) {
                        this.k = null;
                    } else if (i == 1) {
                        this.l = null;
                    }
                    Toast.makeText(this, getString(R.string.location_outside_city_toast), 0).show();
                } else {
                    o0();
                }
                if (stringExtra2 == null) {
                    xt.f3961a.Y().a(a2, System.currentTimeMillis());
                } else {
                    xt.f3961a.b0().d((Stop) hj1.s(stringExtra2, Stop.class));
                }
            } else if (!(this.k == null || this.l == null)) {
                jz5.b().i(new TripPlannerInputLocationChangedEvent(TripPlannerInputLocationChangedEvent.RESPONSE_TYPE.LOCATION_UPDATE, null));
            }
            s0();
            r0();
            View view = this._mapContainer;
            if (view != null && view.getVisibility() != 8 && k0()) {
                j0(false);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.x) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        } else if (!xt.f3961a.G().d(getFragmentManager(), "tripPlannerScreen", TripPlanningActivity.class.getSimpleName())) {
            ui1.F0(this.v);
            super.onBackPressed();
        }
    }

    public void onEvent(nn0.a aVar) {
        if (aVar != null) {
            int i = ((aVar.f2577a * 60) + aVar.b) * 60;
            this.p = i;
            this.s.setText(jh1.g((long) i));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        if (this.x) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
            return false;
        }
        ui1.F0(this.v);
        finish();
        return true;
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        xt.f3961a.G().n();
        super.onPause();
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        xt.f3961a.G().h("tripPlannerScreen", getFragmentManager(), TripPlanningActivity.class.getSimpleName());
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        mf1 mf1 = this.k;
        if (mf1 != null) {
            bundle.putString(RecentTripConvertor.KEY_FROM_LOCATION, mf1.b());
        }
        mf1 mf12 = this.l;
        if (mf12 != null) {
            bundle.putString(RecentTripConvertor.KEY_TO_LOCATION, mf12.b());
        }
        bundle.putBoolean("openPickerScreen", this.w);
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

    public void onUserInteraction() {
        super.onUserInteraction();
        xt.f3961a.G().k();
    }

    public final Marker p0(Marker marker, LatLng latLng, boolean z2) {
        e44 e44 = this.q;
        if (e44 == null) {
            return marker;
        }
        int i = z2 ? R.drawable.start : R.drawable.end;
        if (marker == null) {
            return e44.a(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(i)));
        }
        marker.setPosition(latLng);
        return marker;
    }

    public final void q0(boolean z2) {
        ed1 ed1 = new ed1("trip planner location entered", Long.MIN_VALUE);
        hj1.K0(ed1, "type", z2 ? Constants.MessagePayloadKeys.FROM : "to", ed1);
    }

    public final void r0() {
        if (!k0() || !vn.K0(this)) {
            this.r.setEnabled(false);
            this.r.setAlpha(0.4f);
            return;
        }
        this.r.setEnabled(true);
        this.r.setAlpha(1.0f);
    }

    public final void s0() {
        int i;
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        mf1 mf1 = this.k;
        if (mf1 == null || (latLng3 = mf1.f2368a) == null) {
            latLng = null;
            i = 0;
        } else {
            this.m = p0(this.m, latLng3, true);
            latLng = this.k.f2368a;
            i = 1;
        }
        mf1 mf12 = this.l;
        if (!(mf12 == null || (latLng2 = mf12.f2368a) == null)) {
            this.n = p0(this.n, latLng2, false);
            latLng = this.l.f2368a;
            i++;
        }
        e44 e44 = this.q;
        if (e44 != null) {
            if (i == 1) {
                e44.j(new a(latLng));
            } else if (i == 2) {
                int measuredHeight = findViewById(R.id.map).getMeasuredHeight();
                int dimension = (int) getResources().getDimension(R.dimen.map_padding_bound);
                if (dimension > measuredHeight) {
                    dimension = 0;
                }
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.include(this.k.f2368a);
                builder.include(this.l.f2368a);
                vn.g1(this.q, dimension, this.k.f2368a, this.l.f2368a);
            }
        }
        t0();
    }

    @Override // defpackage.fv0.c
    public void t() {
        if (this.z.isVisible()) {
            this.z.dismiss();
        }
        if (this.A != null) {
            xt.f3961a.B().d(this.A);
        }
    }

    public final void t0() {
        String str;
        String str2;
        View findViewById = this._inputForm.findViewById(R.id.input_from);
        View findViewById2 = this._inputForm.findViewById(R.id.input_to);
        TextView textView = (TextView) findViewById.findViewById(R.id.header_title);
        TextView textView2 = (TextView) findViewById2.findViewById(R.id.header_title);
        mf1 mf1 = this.k;
        if (mf1 == null || (str2 = mf1.c) == null) {
            textView.setHint(getString(R.string.enter_origin_location));
        } else {
            u0(textView, str2, this);
        }
        mf1 mf12 = this.l;
        if (mf12 == null || (str = mf12.c) == null) {
            textView2.setHint(getString(R.string.enter_destination_location));
        } else {
            u0(textView2, str, this);
        }
        int i = this.p;
        if (i == -1) {
            i = ui1.N();
        }
        this.p = i;
        this.s.setText(jh1.g((long) i));
        r0();
    }

    public void onEvent(ie1 ie1) {
        String str;
        mf1 mf1;
        String str2;
        ad1 ad1 = ie1.c;
        StringBuilder i0 = hj1.i0("received geocode event for ");
        i0.append(ie1.f1509a);
        i0.append(ie1.c);
        i0.toString();
        ed1 ed1 = new ed1("tripPlanner location fetch", Long.MIN_VALUE);
        ad1 ad12 = ie1.c;
        hj1.K0(ed1, "status", (ad12 == null || !ad12.equals(ad1.SUCCESS)) ? "0" : "1", ed1);
        mf1 mf12 = null;
        if (ad1.equals(ad1.SUCCESS)) {
            mf1 mf13 = this.k;
            boolean z2 = true;
            boolean z3 = mf13 != null && ie1.f1509a.equals(mf13.b);
            mf1 mf14 = this.l;
            if (mf14 == null || !ie1.f1509a.equals(mf14.b)) {
                z2 = false;
            }
            if (z3 || z2) {
                if (i0(ie1.b)) {
                    if (z3) {
                        this.k.f2368a = ie1.b;
                        String stringExtra = getIntent().getStringExtra("extra:from");
                        if (stringExtra == null) {
                            mf1 = null;
                        } else {
                            mf1 = mf1.a(stringExtra);
                        }
                        if (!getIntent().getBooleanExtra("extra_recent_trip", false) || mf1 == null || (str2 = mf1.d) == null || !str2.equals(this.k.d)) {
                            xt.f3961a.Y().a(this.k, System.currentTimeMillis());
                        }
                    }
                    if (z2) {
                        this.l.f2368a = ie1.b;
                        String stringExtra2 = getIntent().getStringExtra("extra:to");
                        if (stringExtra2 != null) {
                            mf12 = mf1.a(stringExtra2);
                        }
                        if (!getIntent().getBooleanExtra("extra_recent_trip", false) || mf12 == null || (str = mf12.d) == null || !str.equals(this.l.d)) {
                            xt.f3961a.Y().a(this.l, System.currentTimeMillis());
                        }
                    }
                    ed1 ed12 = new ed1("tripplanner location picked", Long.MIN_VALUE);
                    hj1.p(ed12, "type", z3 ? AnalyticsConstants.START : AnalyticsConstants.END, "source", "pickerScreen").g(ed12);
                    o0();
                    View view = this._mapContainer;
                    if (!(view == null || view.getVisibility() == 8 || !k0())) {
                        j0(false);
                    }
                } else {
                    if (z3) {
                        this.k = null;
                    }
                    if (z2) {
                        this.l = null;
                    }
                    Toast.makeText(this, getString(R.string.location_outside_city_toast), 0).show();
                    jz5.b().i(new TripPlannerInputLocationChangedEvent(TripPlannerInputLocationChangedEvent.RESPONSE_TYPE.LOCATION_UPDATE_FAILED, null));
                }
                s0();
                r0();
                return;
            }
            return;
        }
        Toast.makeText(this, getString(R.string.unable_fetch_location), 0).show();
        jz5.b().i(new TripPlannerInputLocationChangedEvent(TripPlannerInputLocationChangedEvent.RESPONSE_TYPE.LOCATION_UPDATE_FAILED, null));
    }

    public void onEvent(qe1 qe1) {
        if (qe1.c.equals(ad1.SUCCESS)) {
            if (l0(qe1, this.k)) {
                mf1 mf1 = this.k;
                String str = qe1.f2934a;
                mf1.b = str;
                mf1.c = str;
            }
            if (l0(qe1, this.l)) {
                mf1 mf12 = this.l;
                String str2 = qe1.f2934a;
                mf12.b = str2;
                mf12.c = str2;
            }
            t0();
        }
    }

    public void onEvent(qd1 qd1) {
        h0();
        r0();
    }
}
