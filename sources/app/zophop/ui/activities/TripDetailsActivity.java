package app.zophop.ui.activities;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.LiveRouteDetailsListEvent;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.android.gms.maps.MapFragment;
import com.google.firebase.appindexing.Indexable;
import com.google.gson.Gson;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import defpackage.wd1;
import defpackage.xt;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import zophop.models.Itinerary;
import zophop.models.Leg;
import zophop.models.LegMode;

public class TripDetailsActivity extends au implements wd1.a {
    public static final /* synthetic */ int v = 0;
    @InjectView(R.id.back_button_card)
    public CardView _backButtonCard;
    @InjectView(R.id.route_screen_back_v19)
    public ImageView _backButtonV19;
    @InjectView(R.id.trip_details_list)
    public ListView _listView;
    @InjectView(R.id.sliding_layout)
    public SlidingUpPanelLayout _panelLayout;
    @InjectView(R.id.route_header_back)
    public View _routeHeaderBack;
    public Itinerary k;
    public e44 l;
    public ok0 m;
    public String n;
    public Handler o;
    public qb1 p;
    public String q;
    public boolean r;
    public Handler s;
    public boolean t = false;
    public final ji1 u = new d();

    public class a implements Runnable {
        public final /* synthetic */ List f;

        public a(List list) {
            this.f = list;
        }

        public void run() {
            ok0 ok0 = TripDetailsActivity.this.m;
            List<Route> list = this.f;
            Objects.requireNonNull(ok0);
            if (list != null) {
                for (Route route : list) {
                    if (route != null) {
                        ok0.m.put(route.getRouteId(), route);
                    }
                }
            }
            TripDetailsActivity.this.m.notifyDataSetChanged();
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public b(TripDetailsActivity tripDetailsActivity) {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        }
    }

    public class c extends t61 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f300a = true;

        public c() {
        }

        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
        public void a(View view, float f) {
            f(false);
            int dimensionPixelSize = TripDetailsActivity.this.getResources().getDimensionPixelSize(R.dimen.route_back_arrow_max_size);
            TripDetailsActivity tripDetailsActivity = TripDetailsActivity.this;
            float f2 = (f - 0.7f) / 0.3f;
            float f3 = f2 * 100.0f;
            if (f < 0.7f) {
                f3 = 0.0f;
            }
            int i = (int) ((f3 * ((float) dimensionPixelSize)) / 100.0f);
            ViewGroup.LayoutParams layoutParams = tripDetailsActivity._routeHeaderBack.getLayoutParams();
            layoutParams.width = Math.max(i, tripDetailsActivity.getResources().getDimensionPixelSize(R.dimen.route_back_arrow_initial_size));
            layoutParams.height = i;
            tripDetailsActivity._routeHeaderBack.setLayoutParams(layoutParams);
            tripDetailsActivity._routeHeaderBack.invalidate();
            tripDetailsActivity._routeHeaderBack.requestLayout();
            if (Float.compare(0.7f, 1.0f) != 0) {
                if (f2 > 0.8f) {
                    tripDetailsActivity._backButtonCard.setCardElevation(((1.0f - f2) / 0.2f) * ((float) tripDetailsActivity.getResources().getDimensionPixelOffset(R.dimen.back_button_elevation)));
                } else {
                    tripDetailsActivity._backButtonCard.setCardElevation((float) tripDetailsActivity.getResources().getDimensionPixelOffset(R.dimen.back_button_elevation));
                }
                tripDetailsActivity._backButtonCard.invalidate();
                tripDetailsActivity._backButtonCard.requestLayout();
            }
        }

        @Override // defpackage.t61
        public void c(View view) {
            f(true);
        }

        @Override // defpackage.t61
        public void d(View view) {
        }

        @Override // defpackage.t61
        public void e(View view) {
            f(false);
        }

        public final void f(boolean z) {
            if (this.f300a != z) {
                Objects.requireNonNull(TripDetailsActivity.this);
                this.f300a = z;
            }
        }
    }

    public class d implements ji1 {
        public d() {
        }

        @Override // defpackage.ji1
        public void a(Object obj) {
        }

        @Override // defpackage.ji1
        public void onSuccess(Object obj) {
            ui1.q0("Trip Details Activity", "", "", 1);
            ok0 ok0 = TripDetailsActivity.this.m;
            ok0.k = (HashMap) obj;
            ok0.notifyDataSetChanged();
        }
    }

    @Override // defpackage.wd1.a
    public void b0() {
        this._panelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }

    @Override // defpackage.wd1.a
    public void c0() {
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        LegMode legMode;
        this.k = (Itinerary) new Gson().fromJson(getIntent().getStringExtra("trip_details:response"), Itinerary.class);
        this.n = getIntent().getStringExtra("extra:tag");
        setContentView(R.layout.trip_details_screen);
        ButterKnife.inject(this);
        this.o = new Handler();
        this.s = new Handler();
        xt.f3961a.Z().e(this.s);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.error_report_hook, (ViewGroup) null, false);
        this._listView.addFooterView(inflate);
        inflate.setOnClickListener(new ag0(this));
        ok0 ok0 = new ok0(this, this.k, "trip details");
        this.m = ok0;
        this._listView.setAdapter((ListAdapter) ok0);
        Itinerary itinerary = this.k;
        if (!(itinerary == null || itinerary.legs == null)) {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (int i = 0; i < this.k.legs.size(); i++) {
                Leg leg = this.k.legs.get(i);
                if (!(leg == null || (legMode = leg.mode) == null || !legMode.equals(LegMode.BUS))) {
                    if (z) {
                        sb.append(",");
                    } else {
                        z = true;
                    }
                    sb.append(leg.route_id);
                }
            }
            if (sb.length() > 0) {
                xt.t1 t1Var = xt.f3961a;
                String B = hj1.B(t1Var);
                this.q = UUID.randomUUID().toString();
                v40 U = t1Var.U();
                String str = this.q;
                String sb2 = sb.toString();
                TransitMode transitMode = TransitMode.bus;
                Objects.requireNonNull(U);
                String name = t1Var.k().d().getName();
                if (name.equalsIgnoreCase(B)) {
                    B = name;
                }
                Uri.Builder builder = new Uri.Builder();
                if (B == null) {
                    B = hj1.B(t1Var);
                }
                builder.encodedPath(ut.d).appendPath(B).appendPath("routedetailslive").appendQueryParameter("route_id", sb2).appendQueryParameter("day", vn.I()).appendQueryParameter("meta", ui1.K0().toString());
                String uri = builder.build().toString();
                r40 r40 = new r40(U, str);
                c70 c70 = new c70(uri, new s40(U, str, r40), r40);
                c70.n = false;
                U.f3592a.a(c70);
            }
        }
        this.t = ui1.T(this, "android.permission.ACCESS_FINE_LOCATION");
        ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).e(new bg0(this));
        h0();
        this._listView.setOnItemClickListener(new b(this));
        this._backButtonCard.setVisibility(0);
        this._backButtonV19.setVisibility(8);
        this._backButtonCard.setCardElevation((float) getResources().getDimensionPixelOffset(R.dimen.back_button_elevation));
        this._backButtonCard.setOnClickListener(new yf0(this));
        if (this.n != null) {
            TextView textView = (TextView) findViewById(R.id.tag);
            if (this.n.equalsIgnoreCase(getResources().getString(R.string.fastest_cheapest))) {
                TextView textView2 = (TextView) findViewById(R.id.tag1);
                textView2.setText(getResources().getString(R.string.fastest));
                textView.setText(getResources().getString(R.string.cheapest));
                textView.setVisibility(0);
                textView2.setVisibility(0);
            } else {
                textView.setText(this.n);
                textView.setVisibility(0);
            }
        }
        findViewById(R.id.fare_header_container).setBackgroundResource(R.color.white);
        TextView textView3 = (TextView) findViewById(R.id.time);
        ((TextView) findViewById(R.id.fare)).setText(jh1.k((long) (((int) this.k.time_taken) * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)));
        if (this.k.inCompleteFare) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(ui1.H() + ui1.D(this.k.fares));
        }
        findViewById(R.id.fare_header_container).setOnClickListener(new cg0(this));
        this._panelLayout.setAnchorPoint(0.7f);
        this._panelLayout.c(new c());
        this._panelLayout.getViewTreeObserver().addOnGlobalLayoutListener(new zf0(this));
        jz5.b().g(new ed1("trip details activity opened", Long.MIN_VALUE));
        ui1.l0(new zz("tripDetails screen open", new HashMap()));
    }

    public final void h0() {
        if (vn.K0(this)) {
            e0();
            this.r = false;
        } else if (!this.r) {
            this.r = f0(this._listView);
        }
    }

    public final int i0() {
        return R.drawable.stop_marker_route_details;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (!xt.f3961a.G().d(getFragmentManager(), "tripDetailsScreen", TripDetailsActivity.class.getSimpleName())) {
            super.onBackPressed();
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
    }

    public void onEvent(LiveRouteDetailsListEvent liveRouteDetailsListEvent) {
        List<Route> routeList;
        jz5.b().m(liveRouteDetailsListEvent);
        if (liveRouteDetailsListEvent.getResponseType() != null && liveRouteDetailsListEvent.getResponseType().equals(ad1.SUCCESS) && this.q != null && liveRouteDetailsListEvent.getRequestId() != null && this.q.equals(liveRouteDetailsListEvent.getRequestId()) && (routeList = liveRouteDetailsListEvent.getRouteList()) != null) {
            this.o.post(new a(routeList));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        xt.f3961a.G().n();
        super.onPause();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.t4.b, defpackage.ve
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 123 && iArr.length > 0 && iArr[0] == 0) {
            this.t = true;
            e44 e44 = this.l;
            if (e44 != null) {
                e44.h(true);
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        e44 e44;
        super.onResume();
        boolean T = ui1.T(this, "android.permission.ACCESS_FINE_LOCATION");
        this.t = T;
        if (T && (e44 = this.l) != null) {
            e44.h(T);
        }
        xt.f3961a.G().h("tripDetailsScreen", getFragmentManager(), TripDetailsActivity.class.getSimpleName());
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        qb1 qb1 = new qb1(this.k, this.u);
        this.p = qb1;
        qb1.c();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        qb1 qb1 = this.p;
        if (qb1 != null) {
            qb1.b();
        }
        this.o.removeCallbacksAndMessages(null);
        xt.f3961a.Z().b();
        Handler handler = this.s;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.s = null;
        ok0 ok0 = this.m;
        if (ok0 != null) {
            Objects.requireNonNull(ok0);
            jz5.b().o(ok0);
        }
        jz5.b().o(this);
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        xt.f3961a.G().k();
    }

    public void onEvent(qd1 qd1) {
        h0();
    }
}
