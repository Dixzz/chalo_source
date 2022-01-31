package app.zophop.ui.activities;

import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.models.DataInfo;
import app.zophop.models.EtaUpdateInfo;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.LiveRouteData;
import app.zophop.models.Route;
import app.zophop.models.Stop;
import app.zophop.models.StreamInfo;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.pubsub.eventbus.events.DatabaseConnectionEvent;
import app.zophop.pubsub.eventbus.events.FirebaseRouteUpdateEvent;
import app.zophop.pubsub.eventbus.events.LiveFeedDetailsEvent;
import app.zophop.pubsub.eventbus.events.LiveRouteDetailsEvent;
import app.zophop.pubsub.eventbus.events.RouteDetailsEvent;
import app.zophop.pubsub.eventbus.events.RouteListScrollEvent;
import app.zophop.pubsub.eventbus.events.StopSearchedEvent;
import app.zophop.pubsub.eventbus.events.SubscriptionEvent;
import app.zophop.ui.activities.SplashScreen;
import app.zophop.ui.utils.FrequencyRouteHelper;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.razorpay.AnalyticsConstants;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import defpackage.a32;
import defpackage.gm0;
import defpackage.mt0;
import defpackage.ut;
import defpackage.wd1;
import defpackage.xt;
import io.github.inflationx.calligraphy3.CalligraphyUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import server.zophop.Constants;

public class RouteDetailsActivity extends fe0 implements wd1.a, gm0.c {
    public static final /* synthetic */ int b0 = 0;
    public Integer A;
    public boolean B = true;
    public final View.OnClickListener C = new b();
    public FrequencyRouteHelper D;
    public boolean E;
    public ChildEventListener F;
    public ValueEventListener G;
    public DatabaseReference H;
    public LiveRouteData I;
    public boolean J;
    public boolean K;
    public boolean L;
    public Snackbar M;
    public boolean N;
    public boolean O;
    public Handler P;
    public int Q;
    public int R;
    public Runnable S;
    public Long T;
    public final Map<String, DataSnapshot> U = new HashMap();
    public String V;
    public int W;
    public String X;
    public List<DataInfo> Y;
    public View Z;
    public boolean a0;
    public String m;
    public String n;
    public Route o;
    public Route p;
    public String q;
    public ev0 r;
    public String s;
    public String t;
    public TransitMode u;
    public String v;
    public String w;
    public a32 x;
    public k00 y;
    public ah1 z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            RouteDetailsActivity.this.M.b(3);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            RouteDetailsActivity routeDetailsActivity = RouteDetailsActivity.this;
            int i = RouteDetailsActivity.b0;
            routeDetailsActivity.m0();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            Intent intent;
            Gson gson = new Gson();
            if (RouteDetailsActivity.this.p.isMTicketEnabled()) {
                intent = new Intent(RouteDetailsActivity.this, MTicketTripInfoActivity.class);
            } else {
                intent = new Intent(RouteDetailsActivity.this, ProductSelectionActivity.class);
            }
            intent.putExtra("src", "route details");
            intent.putExtra("route_extra", gson.toJson(RouteDetailsActivity.this.p));
            RouteDetailsActivity.this.startActivity(intent);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            Gson gson = new Gson();
            Intent intent = new Intent(RouteDetailsActivity.this, ProductSelectionActivity.class);
            intent.putExtra("src", "route details");
            intent.putExtra("route_extra", gson.toJson(RouteDetailsActivity.this.p));
            RouteDetailsActivity.this.startActivity(intent);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            RouteDetailsActivity routeDetailsActivity = RouteDetailsActivity.this;
            int i = RouteDetailsActivity.b0;
            routeDetailsActivity.x0("alarmIcon");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean D0() {
        /*
            xt$t1 r0 = defpackage.xt.f3961a
            f20 r1 = r0.t()
            java.lang.String r2 = "showAlarmIconRouteScreen"
            boolean r1 = r1.b(r2)
            r2 = 1
            if (r1 == 0) goto L_0x0052
            java.lang.String r1 = defpackage.hj1.B(r0)
            if (r1 != 0) goto L_0x0016
            goto L_0x003a
        L_0x0016:
            f20 r0 = r0.t()
            java.lang.String r3 = "cityListForNoSubscriptionIcon"
            java.lang.String r0 = r0.f(r3)
            if (r0 == 0) goto L_0x004e
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x003f }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x003f }
            r0 = 0
        L_0x0028:
            int r4 = r3.length()     // Catch:{ JSONException -> 0x003f }
            if (r0 >= r4) goto L_0x004e
            java.lang.String r4 = r3.getString(r0)     // Catch:{ JSONException -> 0x003f }
            if (r4 == 0) goto L_0x003c
            boolean r4 = r4.equalsIgnoreCase(r1)     // Catch:{ JSONException -> 0x003f }
            if (r4 == 0) goto L_0x003c
        L_0x003a:
            r0 = 0
            goto L_0x004f
        L_0x003c:
            int r0 = r0 + 1
            goto L_0x0028
        L_0x003f:
            r0 = move-exception
            java.lang.Class<app.zophop.ui.activities.RouteDetailsActivity> r1 = app.zophop.ui.activities.RouteDetailsActivity.class
            r0.getMessage()
            b00 r1 = defpackage.b00.f358a
            c00 r1 = defpackage.b00.a()
            r1.b(r0)
        L_0x004e:
            r0 = 1
        L_0x004f:
            if (r0 == 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r2 = 0
        L_0x0053:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.RouteDetailsActivity.D0():boolean");
    }

    public static /* synthetic */ int k0(RouteDetailsActivity routeDetailsActivity) {
        int i = routeDetailsActivity.Q;
        routeDetailsActivity.Q = i + 1;
        return i;
    }

    public static Intent r0(Context context, String str, Stop stop, Stop stop2, TransitMode transitMode, String str2) {
        Gson gson = new Gson();
        Intent intent = new Intent(context, RouteDetailsActivity.class);
        if (stop != null) {
            intent.putExtra("route_details:from_stop", gson.toJson(stop));
        }
        if (stop2 != null) {
            intent.putExtra("route_details:to_stop", gson.toJson(stop2));
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("extra:route_id", str);
        }
        intent.putExtra("extra:mode", transitMode.name());
        intent.putExtra("trigger_origin", str2);
        return intent;
    }

    public static void v0(Context context, String str, Stop stop, Stop stop2, TransitMode transitMode, StreamInfo streamInfo, String str2) {
        Intent r0 = r0(context, str, null, null, transitMode, str2);
        if (streamInfo != null) {
            r0.putExtra("stream_info", new Gson().toJson(streamInfo));
        }
        context.startActivity(r0);
    }

    public static void w0(Context context, String str, Stop stop, Stop stop2, TransitMode transitMode, String str2) {
        context.startActivity(r0(context, str, stop, stop2, transitMode, str2));
    }

    public final void A0() {
        ImageView imageView = (ImageView) findViewById(R.id.subscription_icon);
        if (this.o != null && imageView != null && D0()) {
            if (this.o.isLive() || this.O) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new e());
                if (!xt.f3961a.r().p(this.m, RouteStoreType.SUBSCRIBED)) {
                    imageView.setImageResource(R.drawable.subscribe_tool_bar_icon);
                } else {
                    imageView.setImageResource(R.drawable.unsubscribe_tool_bar_icon);
                }
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public final void B0() {
        Snackbar snackbar = this.M;
        if (snackbar != null) {
            snackbar.b(3);
        }
    }

    public final void C0() {
        ed1 ed1 = new ed1("mticket hook route details rendered", Long.MIN_VALUE);
        ed1.a("isUserLoggedIn", String.valueOf(xt.f3961a.L().m()));
        String str = this.n;
        if (str == null) {
            str = "";
        }
        ed1.a("city", str);
        ed1.a("agency", this.p.getAgencyName());
        ed1.a("upTripRouteId", this.p.getRouteId());
        ed1.a("isFreeRide", String.valueOf(this.p.isFreeRide()));
        ed1.a("time", jh1.g(System.currentTimeMillis()));
        ed1.a("date", jh1.c(System.currentTimeMillis()));
        jz5.b().g(ed1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E0() {
        /*
        // Method dump skipped, instructions count: 188
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.RouteDetailsActivity.E0():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
        if (r1.getRoutes().contains(r11.m) != false) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        if ((r2.equals(app.zophop.models.mTicketing.ProductDiscountsObject.KEY_PRODUCT_TYPE_ROUTE_PASS) ? !((r2 = r11.p) == null || !r2.isIsRoutePassEnabled()) : !(r2.equals(app.zophop.models.mTicketing.ProductDiscountsObject.KEY_PRODUCT_TYPE_MTICKET) && ((r2 = r11.p) == null || !r2.isMTicketEnabled()))) != false) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        r2 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void F0() {
        /*
        // Method dump skipped, instructions count: 219
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.RouteDetailsActivity.F0():void");
    }

    public final void G0(int i, int i2, boolean z2, boolean z3, View.OnClickListener onClickListener, int i3, int i4, int i5, int i6) {
        if (this.Z == null || !z2) {
            B0();
            return;
        }
        B0();
        String string = getString(i);
        Snackbar j = Snackbar.j(this.Z, vn.k(string, 0, string.length(), i3, false), -2);
        this.M = j;
        j.c.setBackgroundColor(i5);
        ((TextView) this.M.c.findViewById(R.id.snackbar_text)).setTextSize(14.0f);
        if (z3) {
            String string2 = getString(i2);
            this.M.k(vn.k(string2, 0, string2.length(), i4, false), onClickListener);
            this.M.l(i4);
            TextView textView = (TextView) this.M.c.findViewById(R.id.snackbar_action);
            textView.setTypeface(textView.getTypeface(), 1);
            textView.setTextSize(14.0f);
        }
        if (i6 != -1) {
            this.M.e = i6;
        }
        this.M.m();
    }

    public final boolean H0(StreamInfo streamInfo) {
        int s0 = s0(streamInfo.getNextStopId());
        int i = s0 - 1;
        if (i >= 0) {
            s0 = i;
        }
        return !vn.R0(streamInfo.getTimeStamp(), streamInfo.getOriginalEtaSec(), true) && s0 >= 0;
    }

    @Override // defpackage.gm0.c
    public void a0() {
        x0("autoSubscribeDialog");
    }

    @Override // defpackage.wd1.a
    public void b0() {
    }

    @Override // defpackage.wd1.a
    public void c0() {
    }

    @Override // defpackage.fe0
    public void init() {
        NotificationManager notificationManager;
        xt.t1 t1Var = xt.f3961a;
        this.y = t1Var.y();
        this.E = false;
        this.Y = new ArrayList();
        Intent intent = getIntent();
        g30 g30 = new g30(intent);
        if (g30.a()) {
            o0(g30);
        } else {
            this.m = intent.getStringExtra("extra:route_id");
            this.s = intent.getStringExtra("route_details:from_stop");
            this.t = intent.getStringExtra("route_details:to_stop");
            this.w = intent.getStringExtra("stream_info");
            this.u = TransitMode.getTransitMode(intent.getStringExtra("extra:mode"));
            this.q = intent.getStringExtra("trigger_origin");
            this.n = hj1.B(t1Var);
            if (intent.hasExtra("extraNotificationId")) {
                this.A = Integer.valueOf(intent.getIntExtra("extraNotificationId", 0));
            }
            String str = this.q;
            if (str != null && (str.equals("subscription notification") || this.q.equals("subscription notificaiton"))) {
                SplashScreen.a.a(this.q);
            }
        }
        if (this.v == null) {
            this.v = "list";
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            activeNetworkInfo.isConnected();
        }
        try {
            if (!(this.A == null || (notificationManager = (NotificationManager) getSystemService("notification")) == null)) {
                notificationManager.cancel(this.A.intValue());
            }
        } catch (Exception e2) {
            e2.getMessage();
            b00 b00 = b00.f358a;
            b00.a().b(e2);
        }
        xt.t1 t1Var2 = xt.f3961a;
        if (xt.p) {
            u0();
        } else {
            t1Var2.N().h();
        }
        jz5.b().l(LiveFeedDetailsEvent.class);
        this.P = new Handler();
        if (this.n == null || this.m == null || this.u == null) {
            h0();
            this.l.c(true);
        } else {
            t1Var2.U().c(this.m, this.u, this.n);
            t1Var2.U().d(this.m, this.n);
            a32.a aVar = new a32.a(this);
            aVar.a(qz1.f3013a);
            a32 d2 = aVar.d();
            this.x = d2;
            d2.f();
            this.z = new ah1(this, t1Var2.B().a());
            t1Var2.r();
            this.F = new kf0(this);
            this.G = new lf0(this);
            this.H = t1Var2.N().f(this.m);
            this.J = false;
            this.L = false;
        }
        ed1 ed1 = new ed1("route details activity open", Long.MIN_VALUE);
        String str2 = this.q;
        if (str2 != null) {
            ed1.a("source", str2);
        }
        ui1.m0(ed1);
        zz zzVar = new zz("route screen opened", new HashMap());
        String str3 = this.q;
        if (str3 != null) {
            zzVar.a("source", str3);
        }
        ui1.l0(zzVar);
    }

    @Override // defpackage.fe0
    public void j0() {
        FrequencyRouteHelper frequencyRouteHelper = new FrequencyRouteHelper(this, this.o, p0(), q0());
        this.D = frequencyRouteHelper;
        String str = this.s;
        String str2 = this.t;
        String str3 = this.q;
        frequencyRouteHelper.j = str;
        frequencyRouteHelper.i = str2;
        frequencyRouteHelper.n = str3;
        if (getIntent().getStringExtra("extra_trigger_stop") != null) {
            this.D.l = getIntent().getStringExtra("extra_trigger_stop");
        }
        if (getIntent().getStringExtra("extra_trigger_stop_id") != null) {
            this.D.m = getIntent().getStringExtra("extra_trigger_stop_id");
        }
        this.D.w = getIntent().getBooleanExtra("isBoardingStopBasedOnLocation", true);
        Objects.requireNonNull(this.D);
        setContentView(R.layout.frequency_route_new);
        String str4 = this.w;
        if (str4 != null) {
            this.D.k = str4;
        }
        this.D.d();
        String o2 = ui1.o(this.o.getRouteName());
        String p2 = ui1.p(this.o.getRouteName());
        ut.a aVar = ut.f3552a;
        SpannableStringBuilder f = hj1.f(o2);
        d71.a(this, f, this.o.getAgencyName().toUpperCase(), true, this.o.getRouteName().length());
        CalligraphyUtils.applyFontToTextView(this, (TextView) findViewById(R.id.title), getString(R.string.font_medium));
        ((TextView) findViewById(R.id.title)).setTextSize(20.0f);
        ((TextView) findViewById(R.id.title)).setText(f);
        ((TextView) findViewById(R.id.bus_agency_name)).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.subtext);
        if (p2 != null) {
            textView.setVisibility(0);
            textView.setText(p2);
            textView.setMaxLines(2);
        } else {
            textView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.favorite_item_bus_to));
            Stop directionStop = this.o.getDirectionStop();
            if (directionStop == null) {
                textView.setVisibility(8);
            } else if (directionStop.getName() != null) {
                textView.setText(String.format(getResources().getString(R.string.to), this.o.getDirectionStop().getName()));
                textView.setMaxLines(2);
            } else {
                textView.setVisibility(8);
            }
        }
        for (int i = 0; i < this.o.get_spfList().size(); i++) {
            d71.b(this, f, this.o.get_spfList().get(i), true, R.color.spf, this.o.getRouteName().length(), R.color.black_87);
        }
        if (this.p != null) {
            y0();
        }
        A0();
        Route route = this.o;
        bw0 bw0 = new bw0();
        Bundle bundle = new Bundle();
        bundle.putString("extra:route", new Gson().toJson(route));
        bw0.setArguments(bundle);
        this.r = bw0;
        bw0.e(new mf0(this));
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        ev0 ev0 = this.r;
        beginTransaction.add(R.id.route_container, ev0, ev0.getTag()).commit();
        String str5 = this.u.equals(TransitMode.bus) ? this.o.getAgencyName() + " " + this.o.getRouteName() + " - " + this.o.getStopSequence().get(0).getName() + " to " + this.o.getDirectionStop().getName() : this.o.getRouteName() + " - " + this.o.getStopSequence().get(0).getName() + " to " + this.o.getDirectionStop().getName();
        if (this.n == null) {
            this.n = hj1.B(xt.f3961a);
        }
        this.n = vn.g(this.n);
        StringBuilder i0 = hj1.i0("android-app://");
        i0.append(getPackageName());
        i0.append("/zophop/route?city=");
        i0.append(this.n);
        i0.append("&route_id=");
        hj1.V0(i0, this.m, "&", "source", "=");
        ((gf3) qz1.b).a(this.x, hj1.m(i0, "appIndex", "http://schema.org/ViewAction", str5));
        this.Z = findViewById(R.id.frequency_route_container);
        E0();
    }

    public final void l0() {
        if (!this.J) {
            this.H.addChildEventListener(this.F);
            this.H.addListenerForSingleValueEvent(this.G);
            this.J = true;
        }
    }

    public final void m0() {
        if (ui1.V(this)) {
            Stop p0 = p0();
            Stop q0 = q0();
            String name = this.o.getMode().name();
            String routeName = this.o.getRouteName();
            ed1 l = hj1.l("checkin initiated", Long.MIN_VALUE, "source", "route details screen");
            if (name != null) {
                l.a("mode", name);
            }
            if (routeName != null) {
                l.a("route", routeName);
            }
            jz5.b().g(l);
            ui1.k0(this, this.o, p0, q0);
        } else if (!vn.K0(this)) {
            Toast.makeText(this, getString(R.string.check_in_activity_failure_query_failed), 1).show();
        } else if (!vn.J0(this)) {
            this.z.b(getString(R.string.gps_not_available_toast));
        }
    }

    public final void n0() {
        DatabaseReference databaseReference = this.H;
        if (databaseReference != null) {
            databaseReference.removeEventListener(this.G);
            this.H.removeEventListener(this.F);
        }
        this.J = false;
    }

    public final void o0(g30 g30) {
        TransitMode transitMode;
        this.m = g30.f1208a.get("route_id");
        this.n = g30.f1208a.get("city");
        this.v = g30.f1208a.get(AnalyticsConstants.SCREEN);
        String str = g30.f1208a.get("mode");
        if (str == null) {
            transitMode = TransitMode.bus;
        } else {
            transitMode = TransitMode.getTransitMode(str);
        }
        this.u = transitMode;
        if (g30.f1208a.containsKey("source")) {
            this.y.a("routeDetailsScreen", g30.f1208a.get("source"), g30.f1208a.get("tag"));
        }
        this.n = g30.f1208a.get("city");
        this.q = "appIndexing";
        this.k.b(h.R(this));
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1010 && i2 == -1) {
            this.D._panelLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            jz5.b().i(new StopSearchedEvent((Stop) hj1.s(intent.getStringExtra("result_picked_stop"), Stop.class), this.m));
        }
        if (i == 99 && i2 == -1) {
            m0();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        if (!xt.f3961a.G().d(getFragmentManager(), "routeScreen", RouteDetailsActivity.class.getSimpleName())) {
            super.onBackPressed();
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        this.Y = null;
        if (this.o != null) {
            xt.t1 t1Var = xt.f3961a;
            if (!xt.p) {
                this.H.keepSynced(false);
            }
        }
        xt.f3961a.u().d();
        super.onDestroy();
    }

    public void onEvent(DatabaseConnectionEvent databaseConnectionEvent) {
        boolean isConnected = databaseConnectionEvent.isConnected();
        this.B = isConnected;
        ed1 ed1 = new ed1("firebase database connection", Long.MIN_VALUE);
        ed1.a("connection status", Boolean.valueOf(isConnected));
        ed1.a(AnalyticsConstants.NETWORK, vn.Y(this));
        Route route = this.o;
        if (route != null) {
            ed1.a("route id", route.getRouteId());
        }
        jz5.b().g(ed1);
        if (!databaseConnectionEvent.isConnected() && !this.L) {
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.t().b("firebasePollingEnabled")) {
                n0();
                this.V = t1Var.u().b(t0(this.m), "route");
                this.L = true;
                return;
            }
        }
        l0();
        xt.f3961a.u().d();
        this.L = false;
    }

    public void onEventMainThread(RouteDetailsEvent routeDetailsEvent) {
        ad1 responseType = routeDetailsEvent.getResponseType();
        if (this.o == null && routeDetailsEvent.getRouteId().equals(this.m)) {
            if (responseType.equals(ad1.SUCCESS)) {
                Route route = routeDetailsEvent.getRoute();
                this.o = route;
                this.I = new LiveRouteData(route);
                List<DataInfo> list = this.Y;
                if (list != null && list.size() > 0) {
                    z0(this.Y);
                }
                i0();
                xt.t1 t1Var = xt.f3961a;
                if (t1Var.k().d().isLiveFeedUrlForAgencyAvailable(this.u, this.o.getAgencyName())) {
                    v40 U2 = t1Var.U();
                    String str = this.n;
                    TransitMode transitMode = this.u;
                    String agencyName = this.o.getAgencyName();
                    String str2 = this.m;
                    d70 d70 = new d70(U2.e(str, transitMode, agencyName, str2), null, new n40(U2, str2), new o40(U2, str2));
                    d70.n = false;
                    U2.f3592a.a(d70);
                }
                if (!xt.p) {
                    this.H.keepSynced(true);
                }
                if (xt.p) {
                    u0();
                    n0();
                    t1Var.u().a(this.V);
                } else if (this.B || !t1Var.t().b("firebasePollingEnabled")) {
                    l0();
                    t1Var.u().a(this.V);
                } else if (!this.L) {
                    this.V = t1Var.u().b(t0(this.m), "route");
                    this.L = true;
                    n0();
                }
            } else {
                h0();
            }
        }
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        xt.f3961a.G().n();
        super.onPause();
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        xt.f3961a.G().h("routeScreen", getFragmentManager(), RouteDetailsActivity.class.getSimpleName());
        FrequencyRouteHelper frequencyRouteHelper = this.D;
        if (frequencyRouteHelper != null) {
            PopupMenu popupMenu = frequencyRouteHelper.v;
            if (popupMenu != null) {
                popupMenu.dismiss();
            }
            CardView cardView = this.D._productDiscountCard;
            if (cardView != null) {
                cardView.setClickable(true);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        if (this.E) {
            xt.t1 t1Var = xt.f3961a;
            v40 U2 = t1Var.U();
            String str = this.n;
            TransitMode transitMode = this.u;
            String agencyName = this.o.getAgencyName();
            String str2 = this.m;
            t1Var.l0().a(U2.e(str, transitMode, agencyName, str2), Constants.THRESHOLD_TIMESTAMP, new p40(U2, str2));
        }
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
        invalidateOptionsMenu();
        if (this.o != null) {
            xt.t1 t1Var2 = xt.f3961a;
            if (xt.p) {
                u0();
            } else if (this.B || this.L || !t1Var2.t().b("firebasePollingEnabled")) {
                l0();
                t1Var2.u().a(this.V);
            } else {
                n0();
                this.V = t1Var2.u().b(t0(this.m), "route");
                this.L = true;
            }
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        Runnable runnable;
        super.onStop();
        if (this.E) {
            xt.t1 t1Var = xt.f3961a;
            t1Var.l0().b(t1Var.U().e(this.n, this.u, this.o.getAgencyName(), this.m));
        }
        LiveRouteData liveRouteData = (LiveRouteData) jz5.b().c(LiveRouteData.class);
        if (liveRouteData != null) {
            jz5.b().m(liveRouteData);
        }
        jz5.b().o(this);
        DatabaseReference databaseReference = this.H;
        if (databaseReference != null) {
            databaseReference.removeEventListener(this.G);
            this.H.removeEventListener(this.F);
        }
        this.J = false;
        this.L = false;
        this.K = false;
        Handler handler = this.P;
        if (!(handler == null || (runnable = this.S) == null)) {
            handler.removeCallbacks(runnable);
            this.S = null;
        }
        xt.t1 t1Var2 = xt.f3961a;
        t1Var2.u().a(this.V);
        t1Var2.O().l(this.X, this.W);
        this.U.clear();
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        xt.f3961a.G().k();
    }

    public final Stop p0() {
        Stop stop;
        if (this.s != null) {
            return (Stop) new Gson().fromJson(this.s, Stop.class);
        }
        try {
            stop = ui1.E(xt.f3961a.B().h(), this.o.getStopSequence());
        } catch (Exception unused) {
            b00 b00 = b00.f358a;
            c00 a2 = b00.a();
            StringBuilder i0 = hj1.i0("Invalid stop sequence");
            i0.append(this.m);
            i0.append(this.o.getRouteName());
            i0.append(this.n);
            a2.b(new Throwable(i0.toString()));
            stop = null;
        }
        return stop == null ? this.o.getStopSequence().get(0) : stop;
    }

    public final Stop q0() {
        if (this.t != null) {
            return (Stop) new Gson().fromJson(this.t, Stop.class);
        }
        return this.o.getStopSequence().get(this.o.getStopSequence().size() - 1);
    }

    public final int s0(String str) {
        for (int i = 0; i < this.o.getStopSequence().size(); i++) {
            if (this.o.getStopSequence().get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public final String t0(String str) {
        String lowerCase = xt.f3961a.k().d().getDisplayName().toLowerCase();
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.q).appendEncodedPath("route").appendEncodedPath(lowerCase).appendEncodedPath(str);
        return builder.build().toString();
    }

    public final void u0() {
        if (!this.K) {
            this.K = true;
            this.X = vn.u(ProductDiscountsObject.KEY_ROUTES, this.m);
            this.W = xt.f3961a.O().k(this.X, new nf0(this));
        }
    }

    public final void x0(String str) {
        SubscriptionActivity.h0(this, this.o);
        ed1 ed1 = new ed1("route screen subscribe clicked", Long.MIN_VALUE);
        ed1.a("source", str);
        ed1.a("isActive", Boolean.valueOf(xt.f3961a.r().p(this.m, RouteStoreType.SUBSCRIBED)));
        jz5.b().g(ed1);
    }

    public final void y0() {
        Route route = this.p;
        if (route != null && route.isMTicketEnabled()) {
            TextView textView = (TextView) findViewById(R.id.btn_book_mticket);
            textView.setVisibility(0);
            C0();
            textView.setOnClickListener(new c());
            if (xt.f3961a.c().K() && this.p.isFreeRide()) {
                textView.setText(R.string.btn_txn_get_free_ride);
            }
            F0();
        }
        Route route2 = this.p;
        if (route2 != null && route2.isIsRoutePassEnabled()) {
            TextView textView2 = (TextView) findViewById(R.id.btn_book_mticket);
            textView2.setText(getResources().getString(R.string.btn_text_buy_pass));
            textView2.setVisibility(0);
            C0();
            textView2.setOnClickListener(new d());
        }
        F0();
    }

    public final void z0(List<DataInfo> list) {
        ArrayList arrayList = new ArrayList();
        this.I.clearStreams();
        Iterator<DataInfo> it = list.iterator();
        while (it.hasNext()) {
            StreamInfo streamInfo = (StreamInfo) it.next();
            if (H0(streamInfo)) {
                arrayList.add(streamInfo);
                this.I.addStreamInfo(streamInfo);
            }
        }
        if (arrayList.size() <= 0 || !vn.K0(this)) {
            this.I.setFirebaseResponse(mt0.h.FAILED);
        } else {
            this.I.setFirebaseResponse(mt0.h.SUCCESS);
        }
        jz5.b().i(this.I);
    }

    public void onEvent(FirebaseRouteUpdateEvent firebaseRouteUpdateEvent) {
        if (firebaseRouteUpdateEvent.get_requestId() == this.V && this.I != null) {
            if (firebaseRouteUpdateEvent.get_responseType().equals(ad1.SUCCESS)) {
                List<StreamInfo> list = firebaseRouteUpdateEvent.get_streamInfoList();
                ArrayList arrayList = new ArrayList();
                this.I.clearStreams();
                for (StreamInfo streamInfo : list) {
                    if (H0(streamInfo)) {
                        arrayList.add(streamInfo);
                        this.I.addStreamInfo(streamInfo);
                    }
                }
                if (arrayList.size() <= 0 || !vn.K0(this)) {
                    this.I.setFirebaseResponse(mt0.h.FAILED);
                } else {
                    this.I.setFirebaseResponse(mt0.h.SUCCESS);
                }
            } else if (firebaseRouteUpdateEvent.get_responseType().equals(ad1.FAILED)) {
                this.I.setFirebaseResponse(mt0.h.FAILED);
            }
            jz5.b().i(this.I);
        }
    }

    public void onEventMainThread(LiveRouteDetailsEvent liveRouteDetailsEvent) {
        jz5.b().m(liveRouteDetailsEvent);
        ad1 responseType = liveRouteDetailsEvent.getResponseType();
        if (liveRouteDetailsEvent.getRouteId().equals(this.m) && responseType.equals(ad1.SUCCESS)) {
            this.p = liveRouteDetailsEvent.getRoute();
            if (this.o != null) {
                y0();
            }
        }
    }

    public void onEvent(RouteListScrollEvent routeListScrollEvent) {
        routeListScrollEvent.getType();
    }

    public void onEvent(SubscriptionEvent subscriptionEvent) {
        if (subscriptionEvent != null) {
            jz5.b().m(subscriptionEvent);
            if (subscriptionEvent.getRouteId() != null && subscriptionEvent.getRouteId().equals(this.m)) {
                View findViewById = findViewById(R.id.subscription_icon);
                if (findViewById != null) {
                    A0();
                }
                FrequencyRouteHelper frequencyRouteHelper = this.D;
                if (frequencyRouteHelper != null) {
                    frequencyRouteHelper.v = null;
                }
                if (subscriptionEvent.isAdded()) {
                    if (findViewById != null) {
                        G0(R.string.sb_subscription_added, 0, true, false, null, getResources().getColor(R.color.white), 0, getResources().getColor(R.color.mticket_status_background_color), Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
                    } else {
                        Toast.makeText(this, (int) R.string.sb_subscription_added, (int) Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL).show();
                    }
                } else if (findViewById != null) {
                    G0(R.string.sb_subscription_removed, 0, true, false, null, getResources().getColor(R.color.white), 0, getResources().getColor(R.color.mticket_status_background_color), Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
                } else {
                    Toast.makeText(this, (int) R.string.sb_subscription_removed, (int) Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL).show();
                }
            }
        }
    }

    public void onEventMainThread(LiveFeedDetailsEvent liveFeedDetailsEvent) {
        ad1 responseType = liveFeedDetailsEvent.getResponseType();
        String routeId = liveFeedDetailsEvent.getRouteId();
        Route route = this.o;
        if (route != null && route.getRouteId().equals(routeId)) {
            if (responseType.equals(ad1.SUCCESS)) {
                if (!this.E) {
                    xt.t1 t1Var = xt.f3961a;
                    v40 U2 = t1Var.U();
                    String str = this.n;
                    TransitMode transitMode = this.u;
                    String agencyName = this.o.getAgencyName();
                    String str2 = this.m;
                    t1Var.l0().a(U2.e(str, transitMode, agencyName, str2), Constants.THRESHOLD_TIMESTAMP, new p40(U2, str2));
                    this.E = true;
                }
                Map<String, List<EtaUpdateInfo>> etaUpdateInfoMap = liveFeedDetailsEvent.getLiveFeed().getEtaUpdateInfoMap();
                if (etaUpdateInfoMap == null || etaUpdateInfoMap.size() <= 0) {
                    this.I.setLiveFeedResponse(mt0.h.FAILED);
                } else {
                    this.I.setLiveFeedData(etaUpdateInfoMap, liveFeedDetailsEvent.getLiveFeed().getLocationInfoList());
                    this.I.setLiveFeedResponse(mt0.h.SUCCESS);
                }
            } else {
                this.I.setLiveFeedResponse(mt0.h.FAILED);
            }
            jz5.b().i(this.I);
        }
    }

    public void onEvent(qd1 qd1) {
        E0();
    }
}
