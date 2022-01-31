package app.zophop.ui.activities;

import android.app.DialogFragment;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import app.zophop.R;
import app.zophop.models.AutoCabAggregatorInfo;
import app.zophop.models.AutoCabInfo;
import app.zophop.models.AutoCabResponse;
import app.zophop.models.LocationTripRequest;
import app.zophop.models.autoCabBooking.BookingCode;
import app.zophop.models.autoCabBooking.BookingDetails;
import app.zophop.models.autoCabBooking.BookingVehicleInfo;
import app.zophop.pubsub.eventbus.events.AutoCabBookingEvent;
import app.zophop.pubsub.eventbus.events.CabDestinationUpdatedEvent;
import app.zophop.pubsub.eventbus.events.CabRideCancelled;
import app.zophop.pubsub.eventbus.events.NearByCabTripEvent;
import app.zophop.pubsub.eventbus.events.OauthEvent;
import app.zophop.pubsub.eventbus.events.TripPlannerCabTripEvent;
import app.zophop.utilities.ui.views.sliding_tabs.HorizontalTabScrollWithViewPager;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.firebase.appindexing.Indexable;
import com.google.gson.Gson;
import defpackage.u00;
import defpackage.wd1;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CabBookingActivity extends wt implements wd1.a {
    public static final /* synthetic */ int K = 0;
    public vi0 A;
    public AutoCabInfo B;
    public Button C;
    public TextView D;
    public TextView E;
    public TextView F;
    public boolean G = false;
    public DialogFragment H;
    public DialogFragment I;
    public boolean J = false;
    public View l;
    public View m;
    public e44 n;
    public mf1 o;
    public mf1 p;
    public Marker q;
    public Marker r;
    public Marker s;
    public HorizontalTabScrollWithViewPager t;
    public ViewPager u;
    public String v;
    public String w;
    public AutoCabResponse x;
    public AutoCabAggregatorInfo y;
    public String z;

    public class a extends ViewPager.k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f294a;

        public a(List list) {
            this.f294a = list;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(int i) {
            CabBookingActivity cabBookingActivity = CabBookingActivity.this;
            if (!cabBookingActivity.G) {
                cabBookingActivity.B = (AutoCabInfo) this.f294a.get(i);
                CabBookingActivity cabBookingActivity2 = CabBookingActivity.this;
                cabBookingActivity2.w = cabBookingActivity2.B.getId();
            }
        }
    }

    public static void h0(CabBookingActivity cabBookingActivity) {
        Objects.requireNonNull(cabBookingActivity);
        xt.t1 t1Var = xt.f3961a;
        BookingDetails b = t1Var.f().b();
        if (b != null) {
            t1Var.g().f(b.getProvider(), b.getRequestId(), t1Var.H().f(b.getProvider()));
        }
    }

    public static void i0(CabBookingActivity cabBookingActivity, String str, String str2) {
        Objects.requireNonNull(cabBookingActivity);
        ed1 ed1 = new ed1("request cab clicked", Long.MIN_VALUE);
        ed1.a("result", str);
        hj1.K0(ed1, "reason", str2, ed1);
    }

    public static boolean t0(mf1 mf1) {
        if (mf1 == null || mf1.f2368a == null || mf1.b == null) {
            return false;
        }
        return true;
    }

    public final void A0(BookingDetails bookingDetails) {
        if (!vn.K0(this)) {
            this.F.setVisibility(0);
            this.F.setText(String.format(getString(R.string.cab_last_updated), jh1.m(bookingDetails.getLastUpdatedTime())));
            return;
        }
        this.F.setVisibility(8);
    }

    public final void B0(String str) {
        xt.t1 t1Var = xt.f3961a;
        String f = t1Var.H().f(this.v);
        String name = this.B.getName();
        if (this.p != null) {
            t1Var.g().n(this.v, f, this.o, this.p, this.B, str);
        } else {
            t1Var.g().n(this.v, f, this.o, null, this.B, str);
        }
        s0();
        DialogFragment S = vn.S(name, getString(R.string.cab_requesting), false, true, new hd0(this), getString(R.string.cab_cancel), true);
        this.H = S;
        S.show(getFragmentManager(), "TAG");
    }

    public final void C0() {
        H0();
        if (this.p != null) {
            L0();
        } else {
            r0();
        }
    }

    public final void D0(BookingDetails bookingDetails) {
        this.o = bookingDetails.getFromLocation();
        this.p = bookingDetails.getToLocation();
        LatLng currentLocation = bookingDetails.getCurrentLocation();
        if (currentLocation != null) {
            int bearing = bookingDetails.getBearing();
            Marker marker = this.s;
            if (marker == null) {
                e44 e44 = this.n;
                if (e44 != null) {
                    Marker a2 = e44.a(new MarkerOptions().position(currentLocation).anchor(0.5f, 0.5f).flat(true).icon(BitmapDescriptorFactory.fromResource(R.drawable.top_taxi)));
                    this.s = a2;
                    a2.setRotation((float) bearing);
                }
            } else {
                marker.setPosition(currentLocation);
                this.s.setRotation((float) bearing);
            }
        }
        H0();
        this.l.setEnabled(false);
        if (q0(this.o)) {
            LatLng latLng = this.o.f2368a;
            F0();
        }
        if (q0(this.p)) {
            LatLng latLng2 = this.p.f2368a;
            K0();
        }
    }

    public final void E0() {
        this.m.setAlpha(0.15f);
        G0(2, getString(R.string.favorite_saving_data));
        this.m.findViewById(R.id.header_title).setOnClickListener(null);
    }

    public final void F0() {
        this.q = v0(this.q, this.o.f2368a, true);
    }

    public final void G0(int i, String str) {
        if (i == 1) {
            ((TextView) this.l.findViewById(R.id.header_title)).setText(str);
        } else if (i == 2) {
            ((TextView) this.m.findViewById(R.id.header_title)).setText(str);
        }
    }

    public final void H0() {
        mf1 mf1 = this.o;
        if (mf1 != null) {
            G0(1, mf1.b);
        }
        if (xt.f3961a.f().c) {
            E0();
            return;
        }
        mf1 mf12 = this.p;
        if (mf12 != null) {
            G0(2, mf12.b);
            w0();
            return;
        }
        G0(2, null);
        w0();
    }

    public final void I0(int i, mf1 mf1) {
        if (i == 1) {
            this.o = mf1;
        } else if (i == 2) {
            this.p = mf1;
        }
    }

    public final void J0() {
        if (this.n != null) {
            n0();
            e44 e44 = this.n;
            int n0 = n0();
            Objects.requireNonNull(e44);
            try {
                e44.f924a.z0(0, n0, 0, 0);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public final void K0() {
        this.r = v0(this.r, this.p.f2368a, false);
    }

    public final void L0() {
        this.J = true;
        this.m.setVisibility(0);
        ((ImageView) findViewById(R.id.drop_down)).setImageDrawable(getResources().getDrawable(R.drawable.arrow_up_tripplanner_details));
        this.l.findViewById(R.id.circle_bottom).setVisibility(0);
        this.l.findViewById(R.id.header_separator).setVisibility(0);
    }

    public final void M0(List<AutoCabInfo> list) {
        int i;
        if (xt.f3961a.f().c()) {
            return;
        }
        if (list.size() == 0) {
            findViewById(R.id.cab_type_container).setVisibility(8);
            return;
        }
        if (!t0(this.o) || !t0(this.p)) {
            i = getResources().getDimensionPixelOffset(R.dimen.cab_viewpager_single_height);
        } else {
            i = getResources().getDimensionPixelOffset(R.dimen.cab_viewpager_double_height);
        }
        this.u.getLayoutParams().height = i;
        this.u.invalidate();
        this.u.requestLayout();
        int i2 = 0;
        findViewById(R.id.cab_type_container).setVisibility(0);
        vi0 vi0 = this.A;
        vi0.d = list;
        synchronized (vi0) {
            DataSetObserver dataSetObserver = vi0.b;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        vi0.f3106a.notifyChanged();
        this.u.setAdapter(this.A);
        this.t.setViewPager(this.u);
        this.t.setOnPageChangeListener(new a(list));
        if (this.w != null) {
            Iterator<AutoCabInfo> it = list.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getId().equalsIgnoreCase(this.w)) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
        }
        this.t.l.setCurrentItem(i2);
        if (!this.G) {
            this.B = list.get(i2);
        }
    }

    public final void N0() {
        int i;
        LatLng latLng;
        J0();
        if (q0(this.o)) {
            LatLng latLng2 = this.o.f2368a;
            F0();
            latLng = this.o.f2368a;
            i = 1;
        } else {
            latLng = null;
            i = 0;
        }
        if (q0(this.p)) {
            LatLng latLng3 = this.p.f2368a;
            K0();
            i++;
            latLng = this.p.f2368a;
        }
        e44 e44 = this.n;
        if (e44 == null) {
            return;
        }
        if (i == 1) {
            if (this.s == null) {
                e44.j(new eh1(e44, latLng, 14.0f));
                return;
            }
            e44.j(new bh1(new LatLng[]{latLng, this.s.getPosition()}, e44, (int) getResources().getDimension(R.dimen.detail_map_padding)));
        } else if (i != 2) {
        } else {
            if (this.s == null) {
                e44.j(new bh1(new LatLng[]{this.o.f2368a, this.p.f2368a}, e44, (int) getResources().getDimension(R.dimen.detail_map_padding)));
                return;
            }
            e44.j(new bh1(new LatLng[]{this.o.f2368a, this.p.f2368a, this.s.getPosition()}, e44, (int) getResources().getDimension(R.dimen.detail_map_padding)));
        }
    }

    @Override // defpackage.wd1.a
    public void b0() {
    }

    @Override // defpackage.wd1.a
    public void c0() {
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        LatLng h;
        LatLng latLng;
        g30 g30 = new g30(getIntent());
        if (g30.a()) {
            String str = g30.b;
            this.v = str;
            if (str == null) {
                this.v = "UBER";
            }
            this.w = g30.f1208a.get("productId");
        } else {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("extra:aggregatorName");
            this.v = stringExtra;
            if (stringExtra == null) {
                this.v = "UBER";
            }
            this.w = intent.getStringExtra("extra:productId");
            if (intent.hasExtra("from_location")) {
                this.o = mf1.a(intent.getStringExtra("from_location"));
            }
            if (intent.hasExtra("to_location")) {
                this.p = mf1.a(intent.getStringExtra("to_location"));
            }
        }
        boolean z2 = true;
        if (bundle != null) {
            if (bundle.containsKey("from_location")) {
                this.o = mf1.a(bundle.getString("from_location"));
            }
            if (bundle.containsKey("to_location")) {
                this.p = mf1.a(bundle.getString("to_location"));
            }
            if (bundle.containsKey("request_pending_status") && bundle.getString("request_pending_status").equals(String.valueOf(true))) {
                this.G = true;
                this.B = (AutoCabInfo) new Gson().fromJson(bundle.getString("autocab_info"), AutoCabInfo.class);
                this.v = bundle.getString("extra:aggregatorName");
                this.w = bundle.getString("extra:productId");
            }
        }
        setContentView(R.layout.activity_cab_booking);
        ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).e(new ed0(this));
        setSupportActionBar((Toolbar) findViewById(R.id.cab_booking_action_tool_bar));
        getSupportActionBar().z(getString(R.string.cab_booking_activity_toolbar_title));
        getSupportActionBar().o(true);
        this.l = findViewById(R.id.input_from);
        this.m = findViewById(R.id.input_to);
        this.C = (Button) findViewById(R.id.cab_action);
        this.D = (TextView) findViewById(R.id.cab_action_left);
        this.E = (TextView) findViewById(R.id.cab_action_right);
        this.F = (TextView) findViewById(R.id.last_eta_banner);
        this.t = (HorizontalTabScrollWithViewPager) findViewById(R.id.cab_type_tabs);
        this.A = new vi0(this);
        ViewPager viewPager = (ViewPager) findViewById(R.id.cab_type_viewpager);
        this.u = viewPager;
        viewPager.setOffscreenPageLimit(3);
        this.u.setAdapter(this.A);
        this.m.findViewById(R.id.circle_top).setVisibility(0);
        ((ImageView) this.m.findViewById(R.id.circle_image)).setImageResource(R.drawable.scheduler_input_circle_to);
        this.l.findViewById(R.id.header_title).setOnClickListener(new cd0(this, 1));
        this.m.findViewById(R.id.header_title).setOnClickListener(new cd0(this, 2));
        ((TextView) this.l.findViewById(R.id.header_title)).setHint(getString(R.string.origin));
        ((TextView) this.m.findViewById(R.id.header_title)).setHint(getString(R.string.destination));
        this.m.findViewById(R.id.divider_drop_down).setVisibility(4);
        this.m.findViewById(R.id.header_separator).setVisibility(4);
        this.l.findViewById(R.id.divider_drop_down).setOnClickListener(new bd0(this));
        C0();
        this.H = vn.S(getResources().getString(R.string.please_wait), getResources().getString(R.string.cab_requesting), false, true, new hd0(this), getString(R.string.cab_cancel), true);
        this.I = vn.T(getResources().getString(R.string.please_wait), getResources().getString(R.string.cab_cancelling), true, true);
        this.t.setDistributeEvenly(true);
        this.t.setSelectedIndicatorColors(getResources().getColor(R.color.orange_primary));
        this.t.c(R.layout.cab_tabs, R.id.tab_title);
        this.t.setViewPager(this.u);
        xt.t1 t1Var = xt.f3961a;
        BookingDetails b = t1Var.f().b();
        if (b != null) {
            D0(b);
        }
        C0();
        N0();
        u00.l lVar = t1Var.g().c;
        if (lVar != null) {
            if (System.currentTimeMillis() - lVar.c >= 120000) {
                z2 = false;
            }
            if (z2) {
                LatLng latLng2 = lVar.b;
                mf1 mf1 = this.o;
                if (mf1 == null || ((latLng = mf1.f2368a) != null && j0(latLng2, latLng))) {
                    this.x = lVar.f3437a;
                    k0();
                    if (!t0(this.o)) {
                        mf1 mf12 = new mf1(latLng2, getString(R.string.my_location));
                        this.o = mf12;
                        String string = getString(R.string.my_location);
                        mf12.b = string;
                        mf12.c = string;
                        t1Var.B().f(latLng2);
                    }
                }
            }
        }
        if (this.o == null && (h = t1Var.B().h()) != null) {
            t1Var.B().f(h);
            this.o = new mf1(h, getString(R.string.my_location));
        }
        m0(this.o);
        m0(this.p);
        C0();
        BookingDetails b2 = t1Var.f().b();
        if (b2 != null && !t1Var.H().e(b2.getProvider())) {
            t1Var.H().c(b2.getProvider(), this);
        }
    }

    public final boolean j0(LatLng latLng, LatLng latLng2) {
        return ui1.m(latLng, latLng2) < 100.0d;
    }

    public final void k0() {
        this.y = null;
        AutoCabResponse autoCabResponse = this.x;
        if (autoCabResponse != null) {
            List<AutoCabAggregatorInfo> autoCabs = autoCabResponse.getAutoCabs();
            if (autoCabs.size() > 0) {
                for (AutoCabAggregatorInfo autoCabAggregatorInfo : autoCabs) {
                    if (autoCabAggregatorInfo.getAggregatorName().equalsIgnoreCase(this.v)) {
                        this.y = autoCabAggregatorInfo;
                        M0(autoCabAggregatorInfo.getAutoCabs());
                        return;
                    }
                }
            }
        }
    }

    public final void l0(AutoCabBookingEvent autoCabBookingEvent, String str) {
        BookingDetails bookingDetails = autoCabBookingEvent.getBookingDetails();
        String provider = bookingDetails.getProvider();
        String T = hj1.T(str, " ", String.format(getResources().getString(R.string.redirect_to_provider_app), provider));
        String href = bookingDetails.getHref();
        BookingCode code = autoCabBookingEvent.getCode();
        lm0 a2 = lm0.a(getFragmentManager(), null, T, getResources().getString(R.string.redirect), getResources().getString(R.string.no_thanks));
        si1 si1 = new si1(a2);
        TextView textView = a2.j;
        if (textView != null) {
            textView.setOnClickListener(si1);
        } else {
            a2.r = si1;
        }
        ti1 ti1 = new ti1(a2, code, this, href, provider);
        TextView textView2 = a2.i;
        if (textView2 != null) {
            textView2.setOnClickListener(ti1);
        } else {
            a2.q = ti1;
        }
    }

    public final void m0(mf1 mf1) {
        if (mf1 != null) {
            LatLng latLng = mf1.f2368a;
            if (latLng != null && mf1.b == null) {
                xt.f3961a.B().f(mf1.f2368a);
            } else if (mf1.b != null && latLng == null) {
                xt.f3961a.B().c(mf1.b);
            }
        }
    }

    public final int n0() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.cab_single_input_height);
        if (this.J) {
            dimensionPixelOffset *= 2;
        }
        return getResources().getDimensionPixelOffset(R.dimen.cab_input_verical_spaces) + dimensionPixelOffset;
    }

    public final void o0(int i, mf1 mf1) {
        I0(i, mf1);
        xt.t1 t1Var = xt.f3961a;
        if (!t1Var.f().c() || i != 2) {
            m0(this.o);
            m0(this.p);
        } else {
            u00 g = t1Var.g();
            Objects.requireNonNull(g);
            t1Var.f().c = true;
            if (mf1.f2368a == null) {
                g.e = t1Var.B().e(new md1(mf1.c, mf1.d));
            } else if (t1Var.k().d().containsLocation(mf1.f2368a)) {
                g.e(mf1);
            } else {
                t1Var.f().c = false;
                g.m(mf1.b);
                g.o(ad1.FAILED, null, CabDestinationUpdatedEvent.CabDestinationStatus.GEOCODE_OUT_OF_BOUNDS);
            }
            E0();
        }
        if (i == 1) {
            this.x = null;
            this.y = null;
            if (!this.G) {
                this.B = null;
            }
            M0(new ArrayList());
            y0();
        }
        x0();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        Long l2;
        if (i2 != -1) {
            return;
        }
        if (i == 69) {
            String stringExtra = intent.getStringExtra("webview_result");
            String queryParameter = Uri.parse(stringExtra).getQueryParameter("access_token");
            String queryParameter2 = Uri.parse(stringExtra).getQueryParameter("refresh_token");
            try {
                l2 = Long.valueOf(Uri.parse(stringExtra).getQueryParameter("expires_in"));
            } catch (NumberFormatException unused) {
                l2 = 0L;
            }
            xt.f3961a.H().b(this.v, queryParameter, queryParameter2, Long.valueOf(l2.longValue() * 1000).longValue());
            Toast.makeText(this, getResources().getString(R.string.cab_auth_successful), 1).show();
        } else if (i == 9999) {
            B0(Uri.parse(intent.getStringExtra("webview_result")).getQueryParameter("surge_confirmation_id"));
        } else if (i == 1 || i == 2) {
            o0(i, mf1.a(intent.getStringExtra("result:picked_location")));
        }
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cab_booking_menu, menu);
        p0(menu.findItem(R.id.share));
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(ie1 ie1) {
        if (ie1.c.equals(ad1.SUCCESS)) {
            xt.t1 t1Var = xt.f3961a;
            if (!t1Var.f().c()) {
                if (t1Var.k().d().containsLocation(ie1.b)) {
                    String str = ie1.f1509a;
                    mf1 mf1 = this.o;
                    if (mf1 == null || !str.equals(mf1.b)) {
                        mf1 mf12 = this.p;
                        if (mf12 != null && str.equals(mf12.b)) {
                            this.p.f2368a = ie1.b;
                            if (t1Var.f().c() && t0(this.p)) {
                                o0(2, this.p);
                            }
                        }
                    } else {
                        this.o.f2368a = ie1.b;
                    }
                    u0();
                    N0();
                    y0();
                } else {
                    Toast.makeText(this, getString(R.string.location_outside_city_toast), 1).show();
                }
                jz5.b().m(ie1);
            }
        }
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.share) {
            String string = xt.f3961a.f().f3289a.b.getString("live_booking_url", null);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.addFlags(268435456);
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", "I am travelling. Check my live trip here " + string);
            intent.putExtra("android.intent.extra.SUBJECT", "Cab trip");
            startActivity(intent);
            jz5.b().g(new ed1("live cab ride share", Long.MIN_VALUE));
            return true;
        } else if (itemId != R.id.help) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            startActivity(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "grievanceofficer_india@uber.com", null)), getString(R.string.cab_send_email)));
            return true;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        p0(menu.findItem(R.id.share));
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        mf1 mf1 = this.o;
        if (mf1 != null) {
            bundle.putString("from_location", mf1.b());
        }
        mf1 mf12 = this.p;
        if (mf12 != null) {
            bundle.putString("to_location", mf12.b());
        }
        if (this.G) {
            bundle.putString("request_pending_status", String.valueOf(true));
            bundle.putString("extra:aggregatorName", this.v);
            bundle.putString("extra:productId", this.w);
            bundle.putString("autocab_info", new Gson().toJson(this.B));
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        x0();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        jz5.b().o(this);
        super.onStop();
    }

    public final void p0(MenuItem menuItem) {
        xt.t1 t1Var = xt.f3961a;
        if (!t1Var.f().c()) {
            menuItem.setVisible(false);
        } else if (!t1Var.f().b().getCode().equals(BookingCode.PROCESSING)) {
            menuItem.setVisible(true);
        } else {
            menuItem.setVisible(false);
        }
    }

    public final boolean q0(mf1 mf1) {
        return (mf1 == null || mf1.f2368a == null) ? false : true;
    }

    public final void r0() {
        this.J = false;
        this.m.setVisibility(8);
        ((ImageView) findViewById(R.id.drop_down)).setImageDrawable(getResources().getDrawable(R.drawable.arrow_down_tripplanner_details));
        this.l.findViewById(R.id.circle_bottom).setVisibility(8);
        this.l.findViewById(R.id.header_separator).setVisibility(8);
    }

    public final void s0() {
        if (this.H.isVisible()) {
            this.H.dismiss();
        }
    }

    public final void u0() {
        if (q0(this.o) && q0(this.p)) {
            System.currentTimeMillis();
            this.z = xt.f3961a.g().h(new LocationTripRequest(this.o, this.p, ui1.N()));
        } else if (q0(this.o)) {
            this.z = xt.f3961a.g().i(this.o.f2368a, false);
        }
    }

    public final Marker v0(Marker marker, LatLng latLng, boolean z2) {
        e44 e44 = this.n;
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

    public final void w0() {
        this.m.setAlpha(1.0f);
        this.m.findViewById(R.id.header_title).setOnClickListener(new cd0(this, 2));
    }

    public final void x0() {
        xt.t1 t1Var = xt.f3961a;
        BookingDetails b = t1Var.f().b();
        if (b == null) {
            s0();
            if (this.I.isVisible()) {
                this.I.dismiss();
            }
            z0();
        } else if (b.getCode().equals(BookingCode.PROCESSING)) {
            if (!this.H.isVisible()) {
                DialogFragment S = vn.S(b.getProductName(), getResources().getString(R.string.cab_requesting), false, true, new hd0(this), getString(R.string.cab_cancel), true);
                this.H = S;
                S.show(getFragmentManager(), "TAG");
            }
        } else if (b.getCode().equals(BookingCode.ACCEPTED)) {
            String requestId = b.getRequestId();
            String provider = b.getProvider();
            t1Var.g().k(provider, requestId, t1Var.H().f(provider));
            s0();
            findViewById(R.id.cab_type_container).setVisibility(8);
            findViewById(R.id.cab_trip_details_card).setVisibility(8);
            findViewById(R.id.cab_in_progress_action_container).setVisibility(0);
            D0(b);
            BookingVehicleInfo vehicleInfo = b.getVehicleInfo();
            View findViewById = findViewById(R.id.driver_details_card);
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
                String driverName = vehicleInfo.getDriverName();
                String carModel = vehicleInfo.getCarModel();
                String carNumberPlate = vehicleInfo.getCarNumberPlate();
                ((TextView) findViewById.findViewById(R.id.driver_name)).setText(driverName);
                ((TextView) findViewById.findViewById(R.id.vehicle_identifier)).setText(carModel);
                ((TextView) findViewById.findViewById(R.id.vehicle_number)).setText(carNumberPlate);
                ((TextView) findViewById.findViewById(R.id.driver_rating)).setText(vehicleInfo.getDriverRating() + "/5");
                ((RatingBar) findViewById.findViewById(R.id.driver_rating_indicator)).setRating((float) vehicleInfo.getDriverRating());
            }
            ui1.H0((TextView) findViewById.findViewById(R.id.driver_eta_text), ii1.d((long) (b.getEta() * 60 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), findViewById.getContext()), findViewById.getContext(), 2);
            this.E.setOnClickListener(new dd0(this, vehicleInfo));
            this.D.setOnClickListener(new gd0(this));
            this.E.setText(getString(R.string.call_driver));
            this.D.setText(getString(R.string.cancel_ride));
            getSupportActionBar().z(getResources().getString(R.string.cab_en_route));
            A0(b);
        } else if (b.getCode().equals(BookingCode.IN_PROGRESS)) {
            s0();
            findViewById(R.id.cab_type_container).setVisibility(8);
            findViewById(R.id.driver_details_card).setVisibility(8);
            findViewById(R.id.cab_in_progress_action_container).setVisibility(8);
            this.C.setVisibility(0);
            this.C.setText(getResources().getString(R.string.cab_end_trip));
            D0(b);
            getSupportActionBar().z(getResources().getString(R.string.cab_en_route));
            if (b.getToLocation() != null) {
                findViewById(R.id.cab_trip_details_card).setVisibility(0);
                View findViewById2 = findViewById(R.id.cab_trip_details_card);
                ui1.H0((TextView) findViewById2.findViewById(R.id.cab_destination_eta), ii1.d((long) (b.getEta() * 60 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), findViewById2.getContext()), findViewById2.getContext(), 2);
            } else {
                findViewById(R.id.cab_trip_details_card).setVisibility(8);
            }
            A0(b);
        } else {
            Toast.makeText(this, getResources().getString(R.string.look_something_has_gone_wrong) + b.getCode(), 1).show();
            z0();
        }
        H0();
        invalidateOptionsMenu();
        y0();
    }

    public final void y0() {
        BookingDetails b = xt.f3961a.f().b();
        if (b == null) {
            this.C.setVisibility(0);
            this.C.setText(getString(R.string.cab_request));
            this.C.setOnClickListener(new fd0(this));
            this.C.setEnabled(true);
            if (!t0(this.o) || this.B == null) {
                this.C.setAlpha(0.4f);
            } else {
                this.C.setAlpha(1.0f);
            }
        } else if (b.getCode().equals(BookingCode.IN_PROGRESS)) {
            this.C.setVisibility(0);
            this.C.setText(getString(R.string.cab_end_trip));
            this.C.setAlpha(1.0f);
            this.C.setEnabled(true);
            this.C.setOnClickListener(new gd0(this));
        } else if (b.getCode().equals(BookingCode.PROCESSING)) {
            this.C.setVisibility(0);
            this.C.setAlpha(0.4f);
            this.C.setEnabled(false);
        } else {
            this.C.setVisibility(8);
        }
    }

    public final void z0() {
        findViewById(R.id.driver_details_card).setVisibility(8);
        findViewById(R.id.cab_trip_details_card).setVisibility(8);
        findViewById(R.id.cab_in_progress_action_container).setVisibility(8);
        findViewById(R.id.cab_input_container).setVisibility(0);
        Marker marker = this.s;
        if (marker != null) {
            marker.remove();
            this.s = null;
        }
        this.C.setVisibility(0);
        this.l.setEnabled(true);
        getSupportActionBar().z(getResources().getString(R.string.cab_confirm));
        N0();
        u0();
    }

    public void onEvent(qe1 qe1) {
        LatLng latLng;
        LatLng latLng2;
        if (qe1.c.equals(ad1.SUCCESS)) {
            LatLng latLng3 = qe1.b;
            mf1 mf1 = this.o;
            if (!(mf1 == null || (latLng2 = mf1.f2368a) == null || !j0(latLng2, latLng3))) {
                mf1 mf12 = this.o;
                String str = qe1.f2934a;
                mf12.b = str;
                mf12.c = str;
                G0(1, str);
            }
            mf1 mf13 = this.p;
            if (mf13 != null && (latLng = mf13.f2368a) != null && j0(latLng, latLng3)) {
                mf1 mf14 = this.p;
                String str2 = qe1.f2934a;
                mf14.b = str2;
                mf14.c = str2;
                G0(2, str2);
            }
        }
    }

    public void onEvent(OauthEvent oauthEvent) {
        if (this.G) {
            B0(null);
            this.G = false;
        } else if (oauthEvent.getResponseType().equals(ad1.SUCCESS)) {
            xt.t1 t1Var = xt.f3961a;
            BookingDetails b = t1Var.f().b();
            if (b != null && b.getProvider().equalsIgnoreCase(oauthEvent.getProvider())) {
                t1Var.g().p(b.getProvider(), t1Var.H().f(b.getProvider()), b.getRequestId());
            }
        }
    }

    public void onEvent(AutoCabBookingEvent autoCabBookingEvent) {
        BookingCode code = autoCabBookingEvent.getCode();
        if (t00.d(code)) {
            x0();
            return;
        }
        if (Arrays.asList(BookingCode.RIDER_CANCELED, BookingCode.DRIVER_CANCELED, BookingCode.COMPLETED).contains(code)) {
            int ordinal = code.ordinal();
            if (ordinal == 4) {
                Toast.makeText(this, getString(R.string.cab_ride_driver_canceled), 1).show();
            } else if (ordinal == 5) {
                Toast.makeText(this, getString(R.string.cab_ride_completed), 1).show();
            } else if (ordinal == 6) {
                Toast.makeText(this, getString(R.string.cab_ride_completed), 1).show();
            }
            x0();
            return;
        }
        s0();
        BookingCode code2 = autoCabBookingEvent.getCode();
        if (code2.equals(BookingCode.SURGE)) {
            Toast.makeText(this, getString(R.string.cab_surge_warning), 1).show();
            WebViewInterceptActivity.l0(this, autoCabBookingEvent.getBookingDetails().getHref(), "Surge", false, true, Uri.parse(ut.t).buildUpon().appendPath("uber").appendPath("surge").toString(), 9999);
            x0();
        } else if (code2.equals(BookingCode.NO_DRIVERS_AVAILABLE)) {
            Toast.makeText(this, getString(R.string.no_cabs_available), 1).show();
            x0();
        } else if (code2.equals(BookingCode.USER_ACCOUNT_ISSUE) || code2.equals(BookingCode.USER_BLOCKED_ISSUE)) {
            l0(autoCabBookingEvent, String.format(getResources().getString(R.string.cab_booking_issue), "account"));
            x0();
        } else if (code2.equals(BookingCode.PAYMENT_ISSUE)) {
            l0(autoCabBookingEvent, String.format(getResources().getString(R.string.cab_booking_issue), "payments"));
            x0();
        } else if (code2.equals(BookingCode.INVALID_TOKEN)) {
            Toast.makeText(this, getString(R.string.cab_invalid_token_error), 0).show();
            String provider = autoCabBookingEvent.getBookingDetails().getProvider();
            xt.t1 t1Var = xt.f3961a;
            t1Var.H().d(provider);
            t1Var.H().c(provider, this);
        } else {
            Toast.makeText(this, getString(R.string.cab_error), 1).show();
            x0();
        }
    }

    public void onEvent(CabDestinationUpdatedEvent cabDestinationUpdatedEvent) {
        ad1 responseType = cabDestinationUpdatedEvent.getResponseType();
        mf1 destination = cabDestinationUpdatedEvent.getDestination();
        CabDestinationUpdatedEvent.CabDestinationStatus cabDestinationStatus = cabDestinationUpdatedEvent.getCabDestinationStatus();
        w0();
        if (responseType.equals(ad1.SUCCESS)) {
            Toast.makeText(this, getString(R.string.cab_destination_updated_successfully), 1).show();
            I0(2, destination);
            H0();
            N0();
        } else {
            BookingDetails b = xt.f3961a.f().b();
            if (b != null) {
                I0(2, b.getToLocation());
                H0();
            }
            int ordinal = cabDestinationStatus.ordinal();
            if (ordinal == 0) {
                Toast.makeText(this, getString(R.string.cab_destination_update_failed), 1).show();
            } else if (ordinal == 1) {
                Toast.makeText(this, getString(R.string.location_outside_city_toast), 1).show();
            } else if (ordinal == 2) {
                Toast.makeText(this, getString(R.string.cab_destination_update_failed), 1).show();
            }
        }
        jz5.b().m(cabDestinationUpdatedEvent);
    }

    public void onEvent(CabRideCancelled cabRideCancelled) {
        if (this.I.isVisible()) {
            this.I.dismiss();
        }
        if (cabRideCancelled.getResponseType().equals(ad1.SUCCESS)) {
            Toast.makeText(this, getString(R.string.cab_ride_cancel_success), 1).show();
            x0();
            return;
        }
        Toast.makeText(this, getString(R.string.cab_ride_cancel_failed), 1).show();
    }

    public void onEvent(TripPlannerCabTripEvent tripPlannerCabTripEvent) {
        if (tripPlannerCabTripEvent.getRequestId().equals(this.z) && tripPlannerCabTripEvent.getResponseType().equals(ad1.SUCCESS)) {
            this.x = tripPlannerCabTripEvent.getResponse();
            k0();
            AutoCabAggregatorInfo autoCabAggregatorInfo = this.y;
            if (autoCabAggregatorInfo != null) {
                M0(autoCabAggregatorInfo.getAutoCabs());
                y0();
            }
            jz5.b().m(tripPlannerCabTripEvent);
        }
    }

    public void onEvent(NearByCabTripEvent nearByCabTripEvent) {
        if (nearByCabTripEvent.getRequestId().equals(this.z) && nearByCabTripEvent.getResponseType().equals(ad1.SUCCESS)) {
            this.x = nearByCabTripEvent.getResponse();
            k0();
            AutoCabAggregatorInfo autoCabAggregatorInfo = this.y;
            if (autoCabAggregatorInfo != null) {
                M0(autoCabAggregatorInfo.getAutoCabs());
                y0();
            }
            jz5.b().m(nearByCabTripEvent);
        }
    }
}
