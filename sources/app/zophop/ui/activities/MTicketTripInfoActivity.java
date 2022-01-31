package app.zophop.ui.activities;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.pubsub.eventbus.events.ClearLoaderEvent;
import app.zophop.pubsub.eventbus.events.FreeRidesCountEvent;
import app.zophop.pubsub.eventbus.events.LiveRouteDetailsEvent;
import app.zophop.pubsub.eventbus.events.ProductConfigurationFetchedEvent;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.crashlytics.android.answers.InviteEvent;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import defpackage.xt;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import server.zophop.logging.LoggingConstants;
import zophop.models.SPECIAL_FEATURE;

public class MTicketTripInfoActivity extends ze0 {
    public static final /* synthetic */ int y = 0;
    @InjectView(R.id.from_station)
    public View _fromStationLayout;
    @InjectView(R.id.mticket_trip_info_container)
    public RelativeLayout _mTicketTripInfoContainer;
    @InjectView(R.id.btn_mticket_pay)
    public Button _paymentButton;
    @InjectView(R.id.route_number)
    public View _routeInfoLayout;
    @InjectView(R.id.to_station)
    public View _toStationLayout;
    @InjectView(R.id.free_ride_info_banner)
    public TextView _tvFreeRideInfoBanner;
    @InjectView(R.id.agency_text_id)
    public TextView agencyText;
    public String m;
    public Route n;
    public RouteInfo o;
    public Stop p;
    @InjectView(R.id.partner_text_id)
    public TextView partnerText;
    public Stop q;
    public final TransitMode r = TransitMode.bus;
    public Handler s;
    public boolean t;
    public Boolean u;
    public Boolean v;
    public Snackbar w;
    public DialogFragment x;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            MTicketTripInfoActivity mTicketTripInfoActivity = MTicketTripInfoActivity.this;
            int i = MTicketTripInfoActivity.y;
            mTicketTripInfoActivity.o0(null);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ LiveRouteDetailsEvent f;

        public b(LiveRouteDetailsEvent liveRouteDetailsEvent) {
            this.f = liveRouteDetailsEvent;
        }

        public void run() {
            if (MTicketTripInfoActivity.this.o != null && this.f.getRouteId().equals(MTicketTripInfoActivity.this.o.getRouteId())) {
                MTicketTripInfoActivity.this.v0();
                MTicketTripInfoActivity.this.z0(this.f.getRoute());
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            MTicketTripInfoActivity mTicketTripInfoActivity = MTicketTripInfoActivity.this;
            int i = MTicketTripInfoActivity.y;
            mTicketTripInfoActivity.o0(null);
        }
    }

    public class d extends ClickableSpan {
        public d() {
        }

        public void onClick(View view) {
            Boolean bool = MTicketTripInfoActivity.this.u;
            if (bool == null || !bool.booleanValue()) {
                jz5.b().g(hj1.l(InviteEvent.TYPE, 86400000, "source", "mticket booking screen"));
                MTicketTripInfoActivity mTicketTripInfoActivity = MTicketTripInfoActivity.this;
                String packageName = mTicketTripInfoActivity.getPackageName();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.SUBJECT", mTicketTripInfoActivity.getString(R.string.zophop_recommend_subject));
                intent.putExtra("android.intent.extra.TEXT", String.format(mTicketTripInfoActivity.getString(R.string.zophop_recommend_text), xt.f3961a.P().a(packageName)));
                intent.setType("text/plain");
                mTicketTripInfoActivity.startActivity(Intent.createChooser(intent, mTicketTripInfoActivity.getString(R.string.invite_friend)));
                return;
            }
            jz5.b().g(hj1.l("free rides info clicked", 86400000, "source", "mticket booking screen"));
            WebViewActivity.h0(MTicketTripInfoActivity.this, xt.f3961a.c().i0(), MTicketTripInfoActivity.this.getString(R.string.free_bus_ride_web_view_title), false, false);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            MTicketTripInfoActivity mTicketTripInfoActivity = MTicketTripInfoActivity.this;
            int i = MTicketTripInfoActivity.y;
            mTicketTripInfoActivity.n0();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            MTicketTripInfoActivity mTicketTripInfoActivity = MTicketTripInfoActivity.this;
            int i = MTicketTripInfoActivity.y;
            mTicketTripInfoActivity.n0();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            MTicketTripInfoActivity mTicketTripInfoActivity = MTicketTripInfoActivity.this;
            int i = MTicketTripInfoActivity.y;
            mTicketTripInfoActivity.n0();
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ FreeRidesCountEvent f;

        public h(FreeRidesCountEvent freeRidesCountEvent) {
            this.f = freeRidesCountEvent;
        }

        public void onClick(View view) {
            MTicketTripInfoActivity mTicketTripInfoActivity = MTicketTripInfoActivity.this;
            RouteInfo routeInfo = this.f.getRouteInfo();
            int i = MTicketTripInfoActivity.y;
            mTicketTripInfoActivity.m0(routeInfo);
        }
    }

    public final void A0(Stop stop) {
        this.q = stop;
        View view = this._toStationLayout;
        if (view != null) {
            view.findViewById(R.id.status).setVisibility(8);
        }
    }

    public final void B0(int i, int i2, boolean z, View.OnClickListener onClickListener, int i3, int i4, int i5) {
        v0();
        String string = getString(i);
        Snackbar j = Snackbar.j(this._mTicketTripInfoContainer, vn.k(string, 0, string.length(), i3, true), -2);
        this.w = j;
        j.c.setBackgroundColor(i5);
        if (z) {
            String string2 = getString(i2);
            this.w.k(vn.k(string2, 0, string2.length(), i4, true), onClickListener);
            this.w.l(i4);
            TextView textView = (TextView) this.w.c.findViewById(R.id.snackbar_action);
            textView.setTypeface(textView.getTypeface(), 1);
        }
        this.w.m();
    }

    @Override // defpackage.ze0
    public void h0(Bundle bundle) {
        if (bundle == null) {
            l0();
        } else {
            Stop stop = null;
            String string = bundle.containsKey("route_extra") ? bundle.getString("route_extra") : null;
            z0(string != null ? (Route) hj1.s(string, Route.class) : null);
            String string2 = bundle.containsKey("route_info_extra") ? bundle.getString("route_info_extra") : null;
            this.o = string2 != null ? (RouteInfo) hj1.s(string2, RouteInfo.class) : null;
            View view = this._routeInfoLayout;
            if (view != null) {
                view.findViewById(R.id.status).setVisibility(8);
            }
            String string3 = bundle.containsKey("from_stop_extra") ? bundle.getString("from_stop_extra") : null;
            x0(string3 != null ? (Stop) hj1.s(string3, Stop.class) : null);
            String string4 = bundle.containsKey("to_stop_extra") ? bundle.getString("to_stop_extra") : null;
            if (string4 != null) {
                stop = (Stop) hj1.s(string4, Stop.class);
            }
            A0(stop);
        }
        this.s = new Handler();
        this.t = xt.f3961a.c().K();
        UUID.randomUUID().toString();
        ed1 ed1 = new ed1("book mticket screen opened", Long.MIN_VALUE);
        if (getIntent().hasExtra("src")) {
            ed1.a("src", getIntent().getStringExtra("src"));
        }
        if (getIntent().hasExtra("source")) {
            ed1.a("source", getIntent().getStringExtra("source"));
        }
        jz5.b().g(ed1);
        zz zzVar = new zz("mticket tripInfo screen open", new HashMap());
        if (getIntent().hasExtra("source")) {
            zzVar.a("source", getIntent().getStringExtra("source"));
        }
        ui1.l0(zzVar);
        i0();
    }

    @Override // defpackage.ze0
    public void j0() {
        setContentView(R.layout.activity_mticket_trip_info);
        ButterKnife.inject(this);
        s0();
        this._routeInfoLayout.setOnClickListener(new oe0(this));
        this._fromStationLayout.setOnClickListener(new pe0(this, 101));
        this._toStationLayout.setOnClickListener(new pe0(this, 102));
        this._paymentButton.setOnClickListener(new ne0(this));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        getSupportActionBar().y(R.string.title_activity_landing);
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.L().m() && !t1Var.c().Y()) {
            t1Var.c().d(t1Var.L().getUserId(), t1Var.L().j());
        }
    }

    public final void k0() {
        if (this.x.isVisible()) {
            this.x.dismiss();
        }
    }

    public final void l0() {
        String stringExtra = getIntent().getStringExtra("route_extra");
        Stop stop = null;
        z0(stringExtra != null ? (Route) hj1.s(stringExtra, Route.class) : null);
        String stringExtra2 = getIntent().getStringExtra("route_info_extra");
        this.o = stringExtra2 != null ? (RouteInfo) hj1.s(stringExtra2, RouteInfo.class) : null;
        View view = this._routeInfoLayout;
        if (view != null) {
            view.findViewById(R.id.status).setVisibility(8);
        }
        String stringExtra3 = getIntent().getStringExtra("from_stop_extra");
        x0(stringExtra3 != null ? (Stop) hj1.s(stringExtra3, Stop.class) : null);
        String stringExtra4 = getIntent().getStringExtra("to_stop_extra");
        if (stringExtra4 != null) {
            stop = (Stop) hj1.s(stringExtra4, Stop.class);
        }
        A0(stop);
    }

    public final void m0(RouteInfo routeInfo) {
        String str;
        if (this.t) {
            u0(routeInfo);
            Boolean bool = null;
            this.v = null;
            if (routeInfo == null) {
                RouteInfo routeInfo2 = this.o;
                this.v = routeInfo2 != null ? Boolean.valueOf(routeInfo2.isFreeRide()) : null;
            } else {
                this.v = Boolean.valueOf(routeInfo.isFreeRide());
            }
            if (this.v == null) {
                Route route = this.n;
                if (route != null) {
                    bool = Boolean.valueOf(route.isFreeRide());
                }
                this.v = bool;
            }
            Boolean bool2 = this.v;
            if (bool2 == null) {
                return;
            }
            if (!bool2.booleanValue()) {
                t0();
                o0(routeInfo);
            } else if (this.u == null) {
                xt.t1 t1Var = xt.f3961a;
                String B = hj1.B(t1Var);
                Route route2 = this.n;
                if (route2 != null) {
                    str = route2.getAgencyName();
                } else {
                    RouteInfo routeInfo3 = this.o;
                    str = routeInfo3 != null ? routeInfo3.getAgencyName() : "";
                }
                t1Var.c().b0(B, str, routeInfo);
                B0(R.string.fetching_mticket_data, 0, false, null, getResources().getColor(R.color.white), 0, getResources().getColor(R.color.mticket_status_background_color));
            } else {
                t0();
                o0(routeInfo);
            }
        } else {
            o0(routeInfo);
        }
    }

    public final void n0() {
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.c().I().size() == 0) {
            if (!this.x.isVisible()) {
                this.x.show(getFragmentManager(), "loader_tag");
            }
            this.m = UUID.randomUUID().toString();
            t1Var.c().b(hj1.B(t1Var), this.m);
        }
    }

    public final void o0(RouteInfo routeInfo) {
        u0(routeInfo);
        if (this.o != null && this.n == null) {
            xt.t1 t1Var = xt.f3961a;
            String B = hj1.B(t1Var);
            v40 U = t1Var.U();
            String routeId = this.o.getRouteId();
            this.o.getTransitMode();
            U.d(routeId, B);
            B0(R.string.fetching_route_details, 0, false, null, getResources().getColor(R.color.white), 0, getResources().getColor(R.color.mticket_status_background_color));
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 101:
                    Stop stop = (Stop) hj1.s(intent.getStringExtra("result_picked_stop"), Stop.class);
                    x0(stop);
                    n61 n61 = n61.FROM;
                    w0(stop, n61);
                    q0(this._fromStationLayout, stop.getName(), n61);
                    return;
                case 102:
                    Stop stop2 = (Stop) hj1.s(intent.getStringExtra("result_picked_stop"), Stop.class);
                    A0(stop2);
                    n61 n612 = n61.TO;
                    w0(stop2, n612);
                    q0(this._toStationLayout, stop2.getName(), n612);
                    return;
                case 103:
                    z0((Route) new Gson().fromJson(intent.getStringExtra("result_route"), Route.class));
                    Route route = this.n;
                    ed1 ed1 = new ed1("mticket route selected", Long.MIN_VALUE);
                    ed1.a("agency", route.getAgencyName().toLowerCase());
                    ed1.a(LoggingConstants.ROUTE_ID, route.getRouteId());
                    ed1.a("routeName", route.getRouteName());
                    jz5.b().g(ed1);
                    m0((RouteInfo) hj1.s(intent.getStringExtra("result_route_info"), RouteInfo.class));
                    return;
                default:
                    return;
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        if (isTaskRoot()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
            return;
        }
        super.onBackPressed();
    }

    public void onEvent(ProductConfigurationFetchedEvent productConfigurationFetchedEvent) {
        jz5.b().m(productConfigurationFetchedEvent);
        k0();
        if (productConfigurationFetchedEvent.getResponseType() == null) {
            B0(R.string.toast_generic_error_message, R.string.retry, true, new e(), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
            return;
        }
        String str = this.m;
        if (str != null && str.equals(productConfigurationFetchedEvent.getConfigRequestId())) {
            if (!productConfigurationFetchedEvent.getResponseType().equals(ad1.SUCCESS)) {
                B0(R.string.toast_generic_error_message, R.string.retry, true, new g(), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
            } else if (productConfigurationFetchedEvent.getProductConfigMap() == null) {
                B0(R.string.toast_generic_error_message, R.string.retry, true, new f(), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
            } else {
                return;
            }
            this.m = null;
        }
    }

    @Override // defpackage.ve
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        l0();
        s0();
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.o != null) {
            bundle.putString("route_info_extra", new Gson().toJson(this.o));
        }
        if (this.n != null) {
            bundle.putString("route_extra", new Gson().toJson(this.n));
        }
        if (this.p != null) {
            bundle.putString("from_stop_extra", new Gson().toJson(this.p));
        }
        if (this.q != null) {
            bundle.putString("to_stop_extra", new Gson().toJson(this.q));
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        k0();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public final List<ProductConfiguration> p0() {
        RouteInfo routeInfo = this.o;
        if (routeInfo == null && this.n == null) {
            return null;
        }
        Route route = this.n;
        return xt.f3961a.c().j0((route == null ? routeInfo.getAgencyName() : route.getAgencyName()).toLowerCase());
    }

    public final void q0(View view, String str, n61 n61) {
        String str2;
        TextView textView = (TextView) view.findViewById(R.id.field_description);
        TextView textView2 = (TextView) view.findViewById(R.id.input);
        TextView textView3 = (TextView) view.findViewById(R.id.field_description_bottom);
        int ordinal = n61.ordinal();
        if (ordinal == 2) {
            str2 = getString(R.string.hint_start_stop);
        } else if (ordinal != 3) {
            str2 = getString(R.string.hint_route_number);
        } else {
            str2 = getString(R.string.hint_end_stop);
        }
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.book_mticket_hint);
        float dimensionPixelSize2 = (float) getResources().getDimensionPixelSize(R.dimen.book_mticket_input);
        if (str == null) {
            textView.setText((CharSequence) null);
            textView.setTextSize(0, dimensionPixelSize2);
            textView3.setText(str2);
            textView3.setTextSize(0, dimensionPixelSize);
            textView3.setVisibility(0);
            textView2.setVisibility(8);
            return;
        }
        textView.setText(str2);
        textView.setTextSize(0, dimensionPixelSize);
        textView.setVisibility(0);
        textView2.setText(str);
        textView2.setTextSize(0, dimensionPixelSize2);
        textView2.setVisibility(0);
        textView3.setVisibility(8);
    }

    public final void r0(View view, String str, List<SPECIAL_FEATURE> list, List<String> list2) {
        q0(view, str, n61.ROUTE);
        TextView textView = (TextView) view.findViewById(R.id.input);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) new SpannableString(str));
        if (list != null) {
            if (list.contains(SPECIAL_FEATURE.AC)) {
                d71.b(this, spannableStringBuilder, "AC", true, R.color.real_time_fetching_string_color, str.length(), R.color.white);
            } else if (list.contains(SPECIAL_FEATURE.FAST)) {
                d71.b(this, spannableStringBuilder, "FAST", true, R.color.real_time_fetching_string_color, str.length(), R.color.white);
            }
        }
        int i = 0;
        while (list2 != null && i < list2.size()) {
            d71.b(this, spannableStringBuilder, list2.get(i), true, R.color.spf, str.length(), R.color.black_87);
            i++;
        }
        textView.setText(spannableStringBuilder);
    }

    public final void s0() {
        Stop stop = this.p;
        if (stop == null) {
            q0(this._fromStationLayout, null, n61.FROM);
        } else {
            q0(this._fromStationLayout, stop.getName(), n61.FROM);
        }
        Stop stop2 = this.q;
        if (stop2 == null) {
            q0(this._toStationLayout, null, n61.TO);
        } else {
            q0(this._toStationLayout, stop2.getName(), n61.TO);
        }
        RouteInfo routeInfo = this.o;
        if (routeInfo == null && this.n == null) {
            q0(this._routeInfoLayout, null, n61.ROUTE);
        } else if (routeInfo != null) {
            r0(this._routeInfoLayout, routeInfo.getRouteName(), this.o.getSpecialFeatures(), this.o.get_updateSpecialFeaturesList());
        } else {
            r0(this._routeInfoLayout, this.n.getRouteName(), this.n.get_special_features(), this.n.get_spfList());
        }
        ((TextView) this._routeInfoLayout.findViewById(R.id.status)).setText(R.string.status_error_route_number);
        ((TextView) this._fromStationLayout.findViewById(R.id.status)).setText(R.string.status_error_enter_stop);
        ((TextView) this._toStationLayout.findViewById(R.id.status)).setText(R.string.status_error_enter_stop);
        m0(null);
        y0();
        this.partnerText.setBackgroundColor(getResources().getColor(R.color.white));
        this.agencyText.setBackgroundColor(getResources().getColor(R.color.white));
        findViewById(R.id.main_layout).setBackgroundColor(getResources().getColor(R.color.white));
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.x = fv0;
        if (fv0 == null) {
            fv0 T = vn.T(null, getString(R.string.loading), false, false);
            this.x = T;
            T.setRetainInstance(true);
        }
        n0();
    }

    public final void t0() {
        String str;
        String str2;
        if (this.t) {
            Boolean bool = this.v;
            if (bool == null || !bool.booleanValue()) {
                this._tvFreeRideInfoBanner.setVisibility(8);
            } else if (this.u != null) {
                this._tvFreeRideInfoBanner.setVisibility(0);
                if (this.u.booleanValue()) {
                    str2 = getString(R.string.tv_banner_free_ride_info) + " " + getString(R.string.free_ride_how_it_works);
                    str = getString(R.string.free_ride_how_it_works);
                } else {
                    str2 = getString(R.string.tv_banner_free_ride_redeemed_info) + "\n\n" + getString(R.string.tv_banner_free_ride_share_now_info) + " " + getString(R.string.tv_banner_free_ride_share_now_btn);
                    str = getString(R.string.tv_banner_free_ride_share_now_btn);
                }
                SpannableString spannableString = new SpannableString(str2);
                spannableString.setSpan(new d(), str2.indexOf(str), str2.length(), 33);
                this._tvFreeRideInfoBanner.setText(spannableString);
                this._tvFreeRideInfoBanner.setMovementMethod(LinkMovementMethod.getInstance());
                this._tvFreeRideInfoBanner.setHighlightColor(0);
            } else {
                this._tvFreeRideInfoBanner.setVisibility(8);
            }
        }
    }

    public final void u0(RouteInfo routeInfo) {
        if (routeInfo != null) {
            RouteInfo routeInfo2 = this.o;
            if (routeInfo2 == null || !routeInfo2.getRouteId().equals(routeInfo.getRouteId())) {
                Route route = this.n;
                if (route != null && !route.getRouteId().equals(routeInfo.getRouteId())) {
                    this.n = null;
                }
                this.o = routeInfo;
                r0(this._routeInfoLayout, routeInfo.getRouteName(), this.o.getSpecialFeatures(), this.o.get_updateSpecialFeaturesList());
                y0();
                x0(null);
                A0(null);
                q0(this._fromStationLayout, null, n61.FROM);
                q0(this._toStationLayout, null, n61.TO);
                v0();
            }
        }
    }

    public final void v0() {
        Snackbar snackbar = this.w;
        if (snackbar != null) {
            snackbar.b(3);
        }
    }

    public final void w0(Stop stop, n61 n61) {
        ed1 ed1 = new ed1("mticket stop selected", Long.MIN_VALUE);
        ed1.a("stopType", n61.toString());
        ed1.a("stopId", stop.getId());
        ed1.a("stopName", stop.getName());
        jz5.b().g(ed1);
    }

    public final void x0(Stop stop) {
        this.p = stop;
        View view = this._fromStationLayout;
        if (view != null) {
            view.findViewById(R.id.status).setVisibility(8);
        }
    }

    public final void y0() {
        String str;
        List<ProductConfiguration> p0 = p0();
        if (p0 == null) {
            this.agencyText.setVisibility(8);
            this.partnerText.setVisibility(8);
            return;
        }
        ProductConfiguration w0 = vn.w0(p0);
        if (w0 == null) {
            this.agencyText.setVisibility(8);
            this.partnerText.setVisibility(8);
        } else if (!vn.Y0(w0.getProductId())) {
            this.agencyText.setVisibility(8);
            this.partnerText.setVisibility(8);
        } else {
            Route route = this.n;
            if (route != null) {
                str = route.getAgencyName();
            } else {
                RouteInfo routeInfo = this.o;
                str = routeInfo != null ? routeInfo.getAgencyName() : "";
            }
            if (TextUtils.isEmpty(str)) {
                this.agencyText.setVisibility(8);
                this.partnerText.setVisibility(8);
                return;
            }
            String upperCase = vn.I0(str) ? "WBTC" : str.toUpperCase();
            this.agencyText.setVisibility(0);
            if (xt.f3961a.k().d().getDisplayName().equalsIgnoreCase("kolkata")) {
                this.partnerText.setVisibility(0);
            }
            this.agencyText.setText(getResources().getString(R.string.agency_text) + " " + upperCase);
        }
    }

    public final void z0(Route route) {
        this.n = route;
        View view = this._routeInfoLayout;
        if (view != null) {
            view.findViewById(R.id.status).setVisibility(8);
        }
    }

    public void onEvent(ClearLoaderEvent clearLoaderEvent) {
        jz5.b().m(clearLoaderEvent);
        this.l.a();
        v0();
    }

    public void onEvent(FreeRidesCountEvent freeRidesCountEvent) {
        jz5.b().m(freeRidesCountEvent);
        boolean z = false;
        if (freeRidesCountEvent.getResponseType() == null) {
            v0();
            Toast.makeText(this, getString(R.string.look_something_has_gone_wrong), 0).show();
        } else if (freeRidesCountEvent.getResponseType().equals(ad1.SUCCESS)) {
            v0();
            if (freeRidesCountEvent.getCount() > 0) {
                z = true;
            }
            this.u = Boolean.valueOf(z);
            t0();
            o0(freeRidesCountEvent.getRouteInfo());
        } else {
            v0();
            B0(R.string.fetching_mticket_data_failed, R.string.retry, true, new h(freeRidesCountEvent), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
        }
    }

    public void onEvent(LiveRouteDetailsEvent liveRouteDetailsEvent) {
        jz5.b().m(liveRouteDetailsEvent);
        if (liveRouteDetailsEvent.getResponseType() == null) {
            v0();
            B0(R.string.fetching_route_details_failed, R.string.retry, true, new a(), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
            return;
        }
        ad1 responseType = liveRouteDetailsEvent.getResponseType();
        if (this.o != null && liveRouteDetailsEvent.getRouteId().equals(this.o.getRouteId())) {
            if (responseType.equals(ad1.SUCCESS)) {
                this.s.postDelayed(new b(liveRouteDetailsEvent), 200);
                return;
            }
            v0();
            B0(R.string.fetching_route_details_failed, R.string.retry, true, new c(), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
        }
    }
}
