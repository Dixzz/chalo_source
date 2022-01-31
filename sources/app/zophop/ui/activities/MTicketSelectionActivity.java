package app.zophop.ui.activities;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.MTicketConfiguration;
import app.zophop.models.mTicketing.MTicketPassengerInfo;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductConfigurationMap;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.RouteStopsInfo;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.BookingTransactionEvent;
import app.zophop.pubsub.eventbus.events.ClearLoaderEvent;
import app.zophop.pubsub.eventbus.events.FaresFetchedEvent;
import app.zophop.pubsub.eventbus.events.FreeRidesCountEvent;
import app.zophop.pubsub.eventbus.events.ProductConfigurationFetchedEvent;
import app.zophop.pubsub.eventbus.events.RazorPayOrderData;
import app.zophop.pubsub.eventbus.events.RazorPayVerificationStatus;
import app.zophop.room.ProductRepository;
import app.zophop.room.Ticket;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.razorpay.AnalyticsConstants;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;
import defpackage.cb1;
import defpackage.mn0;
import defpackage.ut;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zophop.models.SPECIAL_FEATURE;

public class MTicketSelectionActivity extends ze0 implements cb1.a, mn0.c, PaymentResultWithDataListener {
    public static MTicket I;
    public Boolean A;
    public Boolean B;
    public rf1 C;
    public rf1 D;
    public boolean E;
    public MTicket F;
    public DialogFragment G;
    public String H;
    @InjectView(R.id.btn_mticket_pay)
    public TextView _btnBookMTicket;
    @InjectView(R.id.collapse_button)
    public ImageView _collapseRouteDetailsButton;
    @InjectView(R.id.fare_breakup_container)
    public LinearLayout _fareBreakUpContainer;
    @InjectView(R.id.free_ride_coupon_container)
    public LinearLayout _freeRideCouponContainer;
    @InjectView(R.id.passenger_fare_details)
    public LinearLayout _mTicketPassengerDetails;
    @InjectView(R.id.mticket_trip_info_container)
    public RelativeLayout _mTicketTripInfoContainer;
    @InjectView(R.id.mticket_passenger_details)
    public LinearLayout _passengerDetailsLayout;
    @InjectView(R.id.mticket_passenger_details_title)
    public TextView _passengerDetailsLayoutTitle;
    @InjectView(R.id.stop_details_layout)
    public ConstraintLayout _routeStopDetailsLayout;
    @InjectView(R.id.tv_terms_conditions)
    public TextView _tvTermsConditions;
    @InjectView(R.id.agency_text_id)
    public TextView agencyText;
    public Route m;
    public RouteInfo n;
    public Stop o;
    public Stop p;
    @InjectView(R.id.partner_text_id)
    public TextView partnerText;
    public ProductConfigurationMap q;
    public ProductConfiguration r;
    public HashMap<String, MTicketPassengerInfo> s;
    public Map<String, MTicketPassengerInfo> t;
    public RouteStopsInfo u;
    public String v;
    public String w;
    public cb1 x;
    public Snackbar y;
    public boolean z;

    public class a implements View.OnClickListener {
        public final /* synthetic */ FreeRidesCountEvent f;

        public a(FreeRidesCountEvent freeRidesCountEvent) {
            this.f = freeRidesCountEvent;
        }

        public void onClick(View view) {
            MTicketSelectionActivity mTicketSelectionActivity = MTicketSelectionActivity.this;
            RouteInfo routeInfo = this.f.getRouteInfo();
            MTicket mTicket = MTicketSelectionActivity.I;
            mTicketSelectionActivity.n0(routeInfo);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            MTicketSelectionActivity mTicketSelectionActivity = MTicketSelectionActivity.this;
            MTicket mTicket = MTicketSelectionActivity.I;
            mTicketSelectionActivity.m0();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            MTicketSelectionActivity mTicketSelectionActivity = MTicketSelectionActivity.this;
            MTicket mTicket = MTicketSelectionActivity.I;
            mTicketSelectionActivity.m0();
        }
    }

    public static void v0(Context context, Route route, MTicket mTicket, TransitMode transitMode, String str, String str2) {
        if (context != null && mTicket != null && mTicket.getUpTripRouteStopsInfo() != null && transitMode != null) {
            I = mTicket;
            Gson gson = new Gson();
            Intent intent = new Intent(context, MTicketSelectionActivity.class);
            RouteInfo routeInfo = new RouteInfo(mTicket.getUpTripRouteStopsInfo().getRouteId(), transitMode, mTicket.getUpTripRouteStopsInfo().getRouteName(), "dummy_stop_name", "dummy_stop_name", null, mTicket.getAgency(), mTicket.getUpTripRouteStopsInfo().getSpecialFeatures(), mTicket.getUpTripRouteStopsInfo().get_spf(), null, false, true, route.isFreeRide(), false, route.getPolyline());
            Stop stop = new Stop(mTicket.getUpTripRouteStopsInfo().getStartStopId(), mTicket.getUpTripRouteStopsInfo().getStartStopName(), null, transitMode);
            Stop stop2 = new Stop(mTicket.getUpTripRouteStopsInfo().getEndStopId(), mTicket.getUpTripRouteStopsInfo().getEndStopName(), null, transitMode);
            intent.putExtra("src", str);
            intent.putExtra("route_extra", new Gson().toJson(route));
            intent.putExtra("route_info_extra", gson.toJson(routeInfo));
            intent.putExtra("from_stop_extra", gson.toJson(stop));
            intent.putExtra("to_stop_extra", gson.toJson(stop2));
            intent.putExtra("is_coming_from_history_extra", true);
            if (str2 != null) {
                intent.putExtra("booking_config_id_extra", str2);
            }
            context.startActivity(intent);
        }
    }

    public final void A0() {
        if (this.z) {
            Boolean bool = this.B;
            if (bool == null || !bool.booleanValue()) {
                this._freeRideCouponContainer.setVisibility(8);
            } else if (this._passengerDetailsLayout.getVisibility() == 0) {
                if (this._btnBookMTicket.getVisibility() == 0) {
                    Boolean bool2 = this.A;
                    if (bool2 == null || !bool2.booleanValue()) {
                        this._freeRideCouponContainer.setVisibility(8);
                        return;
                    }
                    double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    for (MTicketPassengerInfo mTicketPassengerInfo : this.s.values()) {
                        if (mTicketPassengerInfo != null && mTicketPassengerInfo.getPassengerCount() > 0) {
                            d = Math.max(d, mTicketPassengerInfo.get_totalFare());
                        }
                    }
                    this._freeRideCouponContainer.setVisibility(0);
                    ((TextView) this._freeRideCouponContainer.findViewById(R.id.coupon_discount)).setText(getString(R.string.txt_minus) + " " + vn.M(d));
                    return;
                }
                this._freeRideCouponContainer.setVisibility(8);
            }
        }
    }

    public final void B0(boolean z2) {
        if (z2) {
            ProductConfiguration p0 = p0();
            if (p0 != null) {
                this.F = q0(p0);
                this._btnBookMTicket.setVisibility(0);
                if (!this.F.isFreeRide() || this.F.getTotalFare() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    TextView textView = this._btnBookMTicket;
                    textView.setText(getString(R.string.btn_txt_book_mticket) + " " + vn.M(this.F.getTotalFare()));
                } else {
                    this._btnBookMTicket.setText(getString(R.string.btn_txt_get_free_ticket));
                }
                this._fareBreakUpContainer.setVisibility(0);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.fare_details);
                za1 za1 = new za1(this, this.F);
                linearLayout.removeAllViews();
                linearLayout.addView(za1);
            } else {
                return;
            }
        } else {
            this._btnBookMTicket.setVisibility(8);
            this._fareBreakUpContainer.setVisibility(8);
        }
        A0();
    }

    public final void C0() {
        Snackbar snackbar = this.y;
        if (snackbar != null) {
            snackbar.b(3);
        }
    }

    public final void D0() {
        if (!this.G.isVisible() && !this.G.isAdded()) {
            this.G.show(getFragmentManager(), "loader_tag");
        }
    }

    public final void E0(boolean z2) {
        String str;
        ProductConfiguration p0 = p0();
        if (p0 != null) {
            if (z2) {
                for (ProductCategory productCategory : p0.getProductCategoryList()) {
                    String categoryId = productCategory.getCategoryId();
                    Map<String, MTicketPassengerInfo> map = this.t;
                    if (map == null || !map.containsKey(categoryId)) {
                        this.s.remove(categoryId);
                    } else if (!this.s.containsKey(categoryId) || this.s.get(categoryId) == null) {
                        MTicketPassengerInfo mTicketPassengerInfo = new MTicketPassengerInfo(this.t.get(categoryId).getFare(), this.t.get(categoryId).getDiscountPercentage(), 0, this.t.get(categoryId).getRoundingLogic());
                        mTicketPassengerInfo.set_subMap(this.t.get(categoryId).get_subMap());
                        mTicketPassengerInfo.set_addMap(this.t.get(categoryId).get_addMap());
                        mTicketPassengerInfo.set_totalFare(this.t.get(categoryId).get_totalFare());
                        mTicketPassengerInfo.setRoundingLogic(this.t.get(categoryId).getRoundingLogic());
                        this.s.put(categoryId, mTicketPassengerInfo);
                    } else {
                        MTicketPassengerInfo mTicketPassengerInfo2 = this.s.get(categoryId);
                        mTicketPassengerInfo2.set_subMap(this.t.get(categoryId).get_subMap());
                        mTicketPassengerInfo2.set_addMap(this.t.get(categoryId).get_addMap());
                        mTicketPassengerInfo2.setFare(this.t.get(categoryId).getFare());
                        mTicketPassengerInfo2.setDiscountPercentage(this.t.get(categoryId).getDiscountPercentage());
                        mTicketPassengerInfo2.set_totalFare(this.t.get(categoryId).get_totalFare());
                        mTicketPassengerInfo2.setRoundingLogic(this.t.get(categoryId).getRoundingLogic());
                        this.s.put(categoryId, mTicketPassengerInfo2);
                    }
                }
            } else {
                for (int i = 0; i < p0.getProductCategoryList().size(); i++) {
                    if (p0.getProductCategoryList().get(i).isCategoryActive()) {
                        this.s.put(p0.getProductCategoryList().get(i).getCategoryId(), new MTicketPassengerInfo(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1, 0));
                    }
                }
            }
            cb1 cb1 = this.x;
            if (cb1 == null) {
                cb1 cb12 = new cb1(this, this, p0, this.s, z2);
                this.x = cb12;
                this._mTicketPassengerDetails.addView(cb12);
            } else {
                cb1.c(p0, this.s, z2);
            }
        }
        this._passengerDetailsLayout.setVisibility(0);
        TextView textView = this._passengerDetailsLayoutTitle;
        if (p0() == null) {
            str = getString(R.string.tag_text_ticket_type);
        } else {
            str = p0().getProductName();
        }
        textView.setText(str);
        B0(z2);
    }

    public final void F0(int i, int i2, boolean z2, View.OnClickListener onClickListener, int i3, int i4, int i5) {
        C0();
        String string = getString(i);
        Snackbar j = Snackbar.j(this._mTicketTripInfoContainer, vn.k(string, 0, string.length(), i3, true), -2);
        this.y = j;
        j.c.setBackgroundColor(i5);
        if (z2) {
            String string2 = getString(i2);
            this.y.k(vn.k(string2, 0, string2.length(), i4, true), onClickListener);
            this.y.l(i4);
            TextView textView = (TextView) this.y.c.findViewById(R.id.snackbar_action);
            textView.setTypeface(textView.getTypeface(), 1);
        }
        this.y.m();
    }

    @Override // defpackage.mn0.c
    public void a0() {
        this.C.g(getString(R.string.isTermsAndConditionSeen), true);
        w0();
    }

    @Override // defpackage.ze0
    public void h0(Bundle bundle) {
        if (bundle == null) {
            l0();
        } else {
            String str = null;
            String string = bundle.containsKey("route_extra") ? bundle.getString("route_extra") : null;
            this.m = string != null ? (Route) hj1.s(string, Route.class) : null;
            String string2 = bundle.containsKey("route_info_extra") ? bundle.getString("route_info_extra") : null;
            this.n = string2 != null ? (RouteInfo) hj1.s(string2, RouteInfo.class) : null;
            String string3 = bundle.containsKey("from_stop_extra") ? bundle.getString("from_stop_extra") : null;
            this.o = string3 != null ? (Stop) hj1.s(string3, Stop.class) : null;
            String string4 = bundle.containsKey("to_stop_extra") ? bundle.getString("to_stop_extra") : null;
            this.p = string4 != null ? (Stop) hj1.s(string4, Stop.class) : null;
            if (bundle.containsKey("booking_config_id_extra")) {
                str = bundle.getString("booking_config_id_extra");
            }
            if (str != null) {
                this.r = vn.m0(str);
            }
            if (this.F == null && bundle.containsKey(ProductDiscountsObject.KEY_PRODUCT_TYPE_MTICKET)) {
                this.F = (MTicket) bundle.getParcelable(ProductDiscountsObject.KEY_PRODUCT_TYPE_MTICKET);
            }
            if (I == null && bundle.containsKey("old_mticket")) {
                I = (MTicket) bundle.getParcelable("old_mticket");
            }
        }
        this.s = new HashMap<>();
        ed1 ed1 = new ed1("mticket selection screen opened", Long.MIN_VALUE);
        if (getIntent().hasExtra("src")) {
            ed1.a("source", getIntent().getStringExtra("src"));
        }
        jz5.b().g(ed1);
        zz zzVar = new zz("mticket selection screen open", new HashMap());
        if (getIntent().hasExtra("source")) {
            zzVar.a("source", getIntent().getStringExtra("source"));
        }
        ui1.l0(zzVar);
        xt.t1 t1Var = xt.f3961a;
        this.z = t1Var.c().K();
        if (this.r == null) {
            this.w = UUID.randomUUID().toString();
            t1Var.c().b(hj1.B(t1Var), this.w);
            return;
        }
        i0();
    }

    @Override // defpackage.ze0
    public void j0() {
        setContentView(R.layout.activity_mticket_selection_screen);
        ButterKnife.inject(this);
        u0();
        this._tvTermsConditions.setOnClickListener(new ke0(this));
        this._btnBookMTicket.setOnClickListener(new le0(this));
        this._collapseRouteDetailsButton.setOnClickListener(new je0(this));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        getSupportActionBar().y(R.string.title_activity_trip_info);
    }

    public final void k0() {
        DialogFragment dialogFragment = this.G;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    public final void l0() {
        String stringExtra = getIntent().getStringExtra("route_extra");
        this.m = stringExtra != null ? (Route) hj1.s(stringExtra, Route.class) : null;
        String stringExtra2 = getIntent().getStringExtra("route_info_extra");
        this.n = stringExtra2 != null ? (RouteInfo) hj1.s(stringExtra2, RouteInfo.class) : null;
        String stringExtra3 = getIntent().getStringExtra("from_stop_extra");
        this.o = stringExtra3 != null ? (Stop) hj1.s(stringExtra3, Stop.class) : null;
        String stringExtra4 = getIntent().getStringExtra("to_stop_extra");
        this.p = stringExtra4 != null ? (Stop) hj1.s(stringExtra4, Stop.class) : null;
        String stringExtra5 = getIntent().getStringExtra("booking_config_id_extra");
        if (stringExtra5 != null) {
            this.r = vn.m0(stringExtra5);
        }
        if (!getIntent().getBooleanExtra("is_coming_from_history_extra", false)) {
            I = null;
        }
    }

    public final void m0() {
        RouteInfo routeInfo = this.n;
        RouteStopsInfo routeStopsInfo = new RouteStopsInfo(routeInfo != null ? routeInfo.getRouteId() : this.m.getRouteId(), r0(), this.o.getId(), this.o.getName(), this.p.getId(), this.p.getName());
        routeStopsInfo.set_spf(s0());
        routeStopsInfo.setSpecialFeatures(t0());
        xt.t1 t1Var = xt.f3961a;
        String B2 = hj1.B(t1Var);
        this.v = UUID.randomUUID().toString();
        t1Var.c().P(B2, o0(), routeStopsInfo, this.v);
        E0(false);
        F0(R.string.fetching_fare_details, 0, false, null, getResources().getColor(R.color.white), 0, getResources().getColor(R.color.mticket_status_background_color));
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n0(app.zophop.models.RouteInfo r13) {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.MTicketSelectionActivity.n0(app.zophop.models.RouteInfo):void");
    }

    public final String o0() {
        RouteInfo routeInfo = this.n;
        return routeInfo != null ? routeInfo.getAgencyName() : this.m.getAgencyName();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 123) {
            if (i2 == -1) {
                if (this.H == null) {
                    this.H = UUID.randomUUID().toString();
                }
                k0();
                MTicket mTicket = this.F;
                xt.t1 t1Var = xt.f3961a;
                mTicket.setUserId(t1Var.L().getUserId());
                ut.a aVar = ut.f3552a;
                xt.t1 t1Var2 = xt.f3961a;
                String f = t1Var2.t().f("visualValidationCityList");
                String D2 = hj1.D(t1Var2);
                boolean z2 = true;
                if (f != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(f);
                        int length = jSONArray.length();
                        if (length > 0) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3 + 1;
                                String string = jSONArray.getString(i3);
                                if (string != null && ea6.f(string, D2, true)) {
                                    break;
                                } else if (i4 >= length) {
                                    break;
                                } else {
                                    i3 = i4;
                                }
                            }
                        }
                    } catch (JSONException e) {
                        b00 b00 = b00.f358a;
                        hj1.X0(e, b00.a());
                    }
                }
                z2 = false;
                if (z2) {
                    Intent intent2 = new Intent(this, UserDetailsActivity.class);
                    intent2.putExtra("mticket_info", new ov().e(this.F));
                    startActivity(intent2);
                    return;
                }
                D0();
                t1Var.c().B(this.F, t1Var.L().j(), this.H, null);
                return;
            }
            k0();
        } else if (i == 12345 && i2 == -1) {
            D0();
        }
    }

    public void onEvent(ProductConfigurationFetchedEvent productConfigurationFetchedEvent) {
        if (productConfigurationFetchedEvent == null || productConfigurationFetchedEvent.getResponseType() == null) {
            this.l.a();
            return;
        }
        String str = this.w;
        if (str != null && str.equals(productConfigurationFetchedEvent.getConfigRequestId())) {
            if (productConfigurationFetchedEvent.getResponseType().equals(ad1.SUCCESS)) {
                ProductConfigurationMap productConfigMap = productConfigurationFetchedEvent.getProductConfigMap();
                this.q = productConfigMap;
                if (productConfigMap != null) {
                    i0();
                } else {
                    this.l.a();
                }
            } else {
                this.l.a();
            }
            this.w = null;
        }
    }

    @Override // defpackage.ve
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        l0();
        u0();
    }

    @Override // com.razorpay.PaymentResultWithDataListener
    public void onPaymentError(int i, String str, PaymentData paymentData) {
        Toast.makeText(this, (int) R.string.toast_error_message_payment_failed, 1).show();
        try {
            y0(this.F, i, str);
        } catch (Exception unused) {
        }
    }

    @Override // com.razorpay.PaymentResultWithDataListener
    public void onPaymentSuccess(String str, PaymentData paymentData) {
        D0();
        try {
            paymentData.getOrderId();
            paymentData.getSignature();
            paymentData.getPaymentId();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.n != null) {
            bundle.putString("route_info_extra", new Gson().toJson(this.n));
        }
        if (this.m != null) {
            bundle.putString("route_extra", new Gson().toJson(this.m));
        }
        if (this.o != null) {
            bundle.putString("from_stop_extra", new Gson().toJson(this.o));
        }
        if (this.p != null) {
            bundle.putString("to_stop_extra", new Gson().toJson(this.p));
        }
        ProductConfiguration productConfiguration = this.r;
        if (productConfiguration != null) {
            bundle.putString("booking_config_id_extra", productConfiguration.getProductId());
        }
        MTicket mTicket = this.F;
        if (mTicket != null) {
            bundle.putParcelable(ProductDiscountsObject.KEY_PRODUCT_TYPE_MTICKET, mTicket);
        }
        MTicket mTicket2 = I;
        if (mTicket2 != null) {
            bundle.putParcelable("old_mticket", mTicket2);
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public final ProductConfiguration p0() {
        ProductConfiguration productConfiguration = this.r;
        if (productConfiguration != null) {
            return productConfiguration;
        }
        if (this.n == null && this.m == null) {
            return null;
        }
        return vn.w0(this.q.getProductConfiguration(o0()));
    }

    public final MTicket q0(ProductConfiguration productConfiguration) {
        Boolean bool;
        Boolean bool2;
        xt.t1 t1Var = xt.f3961a;
        String m0 = t1Var.m0();
        String B2 = hj1.B(t1Var);
        RouteInfo routeInfo = this.n;
        RouteStopsInfo routeStopsInfo = new RouteStopsInfo(routeInfo != null ? routeInfo.getRouteId() : this.m.getRouteId(), r0(), this.o.getId(), this.o.getName(), this.p.getId(), this.p.getName());
        routeStopsInfo.setSpecialFeatures(t0());
        routeStopsInfo.set_spf(s0());
        MTicket mTicket = new MTicket(m0, B2, o0(), new MTicketConfiguration(productConfiguration.getProductId()));
        mTicket.setUpTripRouteStopsInfo(routeStopsInfo);
        HashMap<String, MTicketPassengerInfo> hashMap = new HashMap<>();
        for (String str : this.s.keySet()) {
            if (this.s.get(str).getPassengerCount() > 0) {
                hashMap.put(str, this.s.get(str));
            }
        }
        mTicket.setPassengerDetails(hashMap);
        mTicket.setUpTripRouteStopsStageInfo(this.u);
        if (this.z && (bool = this.A) != null && bool.booleanValue() && (bool2 = this.B) != null && bool2.booleanValue()) {
            mTicket.set_isFreeRide(true);
        }
        return mTicket;
    }

    public final String r0() {
        RouteInfo routeInfo = this.n;
        return routeInfo != null ? routeInfo.getRouteName() : this.m.getRouteName();
    }

    public final List<String> s0() {
        RouteInfo routeInfo = this.n;
        return routeInfo != null ? routeInfo.get_updateSpecialFeaturesList() : this.m.get_spfList();
    }

    public final List<SPECIAL_FEATURE> t0() {
        RouteInfo routeInfo = this.n;
        return routeInfo != null ? routeInfo.getSpecialFeatures() : this.m.get_special_features();
    }

    public final void u0() {
        ui1.x0(this, (TextView) findViewById(R.id.route_name), r0(), t0(), s0());
        ((TextView) findViewById(R.id.tv_start_stop)).setText(this.o.getName());
        ((TextView) findViewById(R.id.tv_end_stop)).setText(this.p.getName());
        this._passengerDetailsLayout.setVisibility(8);
        B0(false);
        n0(null);
        if (this.m != null) {
            ProductConfiguration p0 = p0();
            if (p0 == null) {
                this.agencyText.setVisibility(8);
                this.partnerText.setVisibility(8);
            } else if (!vn.Y0(p0.getProductId())) {
                this.agencyText.setVisibility(8);
                this.partnerText.setVisibility(8);
            } else {
                String string = getResources().getString(R.color.cards_container_background);
                if (xt.f3961a.k().d().getDisplayName().equalsIgnoreCase("kolkata")) {
                    this.partnerText.setVisibility(0);
                    this.partnerText.setBackgroundColor(Color.parseColor(string));
                }
                String upperCase = this.m.getAgencyName().toUpperCase();
                if (vn.I0(upperCase)) {
                    upperCase = "WBTC";
                }
                TextView textView = this.agencyText;
                StringBuilder i0 = hj1.i0(" ");
                i0.append(upperCase.toUpperCase());
                textView.append(i0.toString());
                this.agencyText.setVisibility(0);
                this.agencyText.setBackgroundColor(Color.parseColor(string));
            }
        } else {
            this.agencyText.setVisibility(8);
            this.partnerText.setVisibility(8);
        }
        this.C = new rf1(this, getString(R.string.isTermsAndConditionSeenKey));
        this.D = new rf1(this, getString(R.string.mTicketBookTime));
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.G = fv0;
        if (fv0 == null) {
            fv0 T = vn.T(null, getString(R.string.loading), false, false);
            this.G = T;
            T.setRetainInstance(true);
        }
        this._collapseRouteDetailsButton.setVisibility(0);
    }

    public final void w0() {
        ProductConfiguration p0 = p0();
        if (p0 != null) {
            MTicket q0 = q0(p0);
            this.F = q0;
            ed1 ed1 = new ed1("mticket pay button clicked", Long.MIN_VALUE);
            vn.a(ed1, q0);
            if (getIntent().hasExtra("src")) {
                ed1.a("source", getIntent().getStringExtra("src"));
            }
            jz5.b().g(ed1);
            if (this.H == null) {
                this.H = UUID.randomUUID().toString();
            }
            xt.t1 t1Var = xt.f3961a;
            if (!t1Var.L().m()) {
                D0();
                Intent intent = new Intent(this, UserProfileActivity.class);
                intent.putExtra("mticket_info", new ov().e(this.F));
                intent.putExtra("src", "mticketing");
                startActivityForResult(intent, 123);
                return;
            }
            ut.a aVar = ut.f3552a;
            xt.t1 t1Var2 = xt.f3961a;
            String f = t1Var2.t().f("visualValidationCityList");
            String D2 = hj1.D(t1Var2);
            boolean z2 = true;
            if (f != null) {
                try {
                    JSONArray jSONArray = new JSONArray(f);
                    int length = jSONArray.length();
                    if (length > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            String string = jSONArray.getString(i);
                            if (string != null && ea6.f(string, D2, true)) {
                                break;
                            } else if (i2 >= length) {
                                break;
                            } else {
                                i = i2;
                            }
                        }
                    }
                } catch (JSONException e) {
                    b00 b00 = b00.f358a;
                    hj1.X0(e, b00.a());
                }
            }
            z2 = false;
            if (z2) {
                Intent intent2 = new Intent(this, UserDetailsActivity.class);
                intent2.putExtra("mticket_info", new ov().e(this.F));
                startActivity(intent2);
                return;
            }
            D0();
            t1Var.c().B(this.F, t1Var.L().j(), this.H, null);
        }
    }

    public final void x0() {
        z0(true);
        ProductRepository productRepository = new ProductRepository(this);
        MTicket mTicket = this.F;
        mTicket.setCityName(mTicket.getCityName().toLowerCase());
        Ticket ticket = new Ticket();
        ticket.setTicketId(this.F.getMTicketId());
        ticket.setmTicket(this.F);
        productRepository.insertTicket(ticket);
        xt.t1 t1Var = xt.f3961a;
        t1Var.c().d(t1Var.L().getUserId(), t1Var.L().j());
        rf1 rf1 = this.D;
        String mTicketId = this.F.getMTicketId();
        StringBuilder i0 = hj1.i0("mticket=>");
        i0.append(System.currentTimeMillis());
        rf1.j(mTicketId, i0.toString());
        SharedPreferences.Editor edit = getSharedPreferences(getString(R.string.FROM_KEY), 0).edit();
        edit.putString(getString(R.string.FROM), getString(R.string.activate));
        edit.commit();
        ActivateMTicketScreen.h0(this, this.F, "confirm mticket screen", true);
    }

    public final void y0(MTicket mTicket, int i, String str) {
        ed1 ed1 = new ed1("mticket payment failed", Long.MIN_VALUE);
        vn.a(ed1, mTicket);
        ed1.a("hourOfEvent", jh1.j(System.currentTimeMillis()) + "");
        ed1.a("paymentMode", "online");
        ed1.a("errorCode", "" + i);
        ed1.a("reason", str);
        if (getIntent().hasExtra("src")) {
            ed1.a("source", getIntent().getStringExtra("src"));
        }
        jz5.b().g(ed1);
    }

    public final void z0(boolean z2) {
        ed1 ed1 = new ed1("mticket get qrCode response received", Long.MIN_VALUE);
        ed1.a("response", String.valueOf(z2));
        vn.a(ed1, this.F);
        if (getIntent().hasExtra("src")) {
            ed1.a("source", getIntent().getStringExtra("src"));
        }
        jz5.b().g(ed1);
    }

    public void onEvent(FreeRidesCountEvent freeRidesCountEvent) {
        jz5.b().m(freeRidesCountEvent);
        boolean z2 = false;
        if (freeRidesCountEvent.getResponseType() == null) {
            C0();
            Toast.makeText(this, getString(R.string.look_something_has_gone_wrong), 0).show();
        } else if (freeRidesCountEvent.getResponseType().equals(ad1.SUCCESS)) {
            C0();
            if (freeRidesCountEvent.getCount() > 0) {
                z2 = true;
            }
            this.A = Boolean.valueOf(z2);
            A0();
            m0();
        } else {
            C0();
            F0(R.string.fetching_mticket_data_failed, R.string.retry, true, new a(freeRidesCountEvent), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
        }
    }

    public void onEvent(FaresFetchedEvent faresFetchedEvent) {
        jz5.b().m(faresFetchedEvent);
        ed1 ed1 = new ed1("mticket fare fetched", Long.MIN_VALUE);
        boolean z2 = false;
        if (faresFetchedEvent.getResponseType() == null) {
            C0();
            ed1.a("response", String.valueOf(false));
            F0(R.string.fetching_fare_details_failed, R.string.retry, true, new b(), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
            return;
        }
        if (!faresFetchedEvent.getResponseType().equals(ad1.SUCCESS) || faresFetchedEvent.getFareMap() == null) {
            C0();
            ed1.a("response", String.valueOf(false));
            F0(R.string.fetching_fare_details_failed, R.string.retry, true, new c(), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
        } else {
            String str = this.v;
            if (str != null && str.equals(faresFetchedEvent.getRequestId())) {
                C0();
                this.t = faresFetchedEvent.getFareMap();
                this.u = faresFetchedEvent.getStageRouteStopsInfo();
                Map<String, MTicketPassengerInfo> map = this.t;
                MTicket mTicket = I;
                if (mTicket != null && map != null && mTicket.getPassengerDetails() != null) {
                    Iterator<Map.Entry<String, MTicketPassengerInfo>> it = I.getPassengerDetails().entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, MTicketPassengerInfo> next = it.next();
                        String key = next.getKey();
                        if (map.containsKey(key) && next.getValue().get_totalFare() != map.get(key).get_totalFare()) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    String string = getString(R.string.recent_products_fare_changed_dialog_title);
                    xm0.a(getFragmentManager(), this, new me0(this, "product fare changed"), MTicketSelectionActivity.class.getSimpleName(), getString(R.string.recent_products_fare_changed_dialog_copy), string, false);
                }
                E0(true);
                ed1.a("response", String.valueOf(true));
            }
        }
        jz5.b().g(ed1);
    }

    public void onEvent(RazorPayVerificationStatus razorPayVerificationStatus) {
        k0();
        jz5.b().m(razorPayVerificationStatus);
        if (razorPayVerificationStatus.get_responseType().equals(ad1.SUCCESS)) {
            xt.f3961a.j().a();
            this.F.setQrCode(razorPayVerificationStatus.getQrCode());
            x0();
            return;
        }
        z0(false);
        Toast.makeText(this, (int) R.string.toast_error_message_payment_failed, 1).show();
    }

    public void onEvent(ClearLoaderEvent clearLoaderEvent) {
        jz5.b().m(clearLoaderEvent);
        if (this._btnBookMTicket != null) {
            k0();
            this._btnBookMTicket.setEnabled(true);
            return;
        }
        this.l.a();
        C0();
    }

    public void onEvent(BookingTransactionEvent bookingTransactionEvent) {
        jz5.b().m(bookingTransactionEvent);
        ed1 ed1 = new ed1("mticket booking response received", Long.MIN_VALUE);
        ad1 responseType = bookingTransactionEvent.getResponseType();
        ad1 ad1 = ad1.SUCCESS;
        if (responseType.equals(ad1)) {
            vn.a(ed1, this.F);
            ed1.a("isPaymentRequired", String.valueOf(this.F.isPaymentRequired()));
            ed1.a("response", String.valueOf(true));
            ed1.a(SuperPassJsonKeys.ORDER_ID, bookingTransactionEvent.getRazorPayOrderData().get_orderId());
            ed1.a("paymentMode", "online");
        } else {
            vn.a(ed1, this.F);
            ed1.a("isPaymentRequired", String.valueOf(this.F.isPaymentRequired()));
            ed1.a("response", String.valueOf(false));
            ed1.a("paymentMode", "online");
        }
        jz5.b().g(ed1);
        this._btnBookMTicket.setEnabled(true);
        k0();
        if (bookingTransactionEvent.getResponseType().equals(ad1)) {
            this.F = bookingTransactionEvent.getBookingTransaction().getMTicket();
            boolean isLpEligible = bookingTransactionEvent.getBookingTransaction().isLpEligible();
            String lpId = bookingTransactionEvent.getBookingTransaction().getLpId();
            if (this.F.isPaymentRequired()) {
                try {
                    RazorPayOrderData razorPayOrderData = bookingTransactionEvent.getRazorPayOrderData();
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ticketId", this.F.getMTicketId());
                    jSONObject2.put("agency", this.F.getAgency());
                    jSONObject2.put("userId", this.F.getUserId());
                    jSONObject.put("currency", "INR");
                    jSONObject.put(AnalyticsConstants.ORDER_ID, razorPayOrderData.get_orderId());
                    jSONObject.put(AnalyticsConstants.AMOUNT, (((int) razorPayOrderData.get_amount()) * 100) + "");
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(AnalyticsConstants.CONTACT, this.F.getUserId());
                    jSONObject.put("prefill", jSONObject3);
                    jSONObject.put("notes", jSONObject2);
                    Bundle bundle = new Bundle();
                    bundle.putString("currency", "INR");
                    bundle.putString(AnalyticsConstants.ORDER_ID, razorPayOrderData.get_orderId());
                    bundle.putString(AnalyticsConstants.AMOUNT, ((int) razorPayOrderData.get_amount()) + "");
                    bundle.putParcelable("mticket_pass_info", this.F);
                    bundle.putBoolean("lpEligible", isLpEligible);
                    bundle.putString("eligibilityResponseId", lpId);
                    bundle.putString(AnalyticsConstants.MERCHANT_KEY, razorPayOrderData.getMerchantKey());
                    bundle.putParcelableArrayList("card_details", (ArrayList) this.F.getCardDetails());
                    Intent intent = new Intent(this, CheckoutActivity.class);
                    intent.putExtra("src", "Confirm Mticket Screen");
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 12345);
                } catch (JSONException e) {
                    RazorPayOrderData razorPayOrderData2 = bookingTransactionEvent.getRazorPayOrderData();
                    String str = null;
                    if (razorPayOrderData2 != null) {
                        StringBuilder i0 = hj1.i0(razorPayOrderData2.get_orderId());
                        i0.append(jh1.c(System.currentTimeMillis()));
                        str = i0.toString();
                    }
                    b00 b00 = b00.f358a;
                    c00 a2 = b00.a();
                    StringBuilder i02 = hj1.i0("Payment exception for ");
                    i02.append(this.F.getMTicketId());
                    i02.append(" ");
                    i02.append(str);
                    a2.b(new Throwable(i02.toString()));
                    b00.a().b(e);
                }
            } else {
                x0();
            }
        } else if (bookingTransactionEvent.getStatusCode() != null) {
            if (bookingTransactionEvent.getStatusCode().equals("410")) {
                ed1 ed12 = new ed1("mticket dupe free ride response received", Long.MIN_VALUE);
                vn.a(ed12, this.F);
                if (getIntent().hasExtra("src")) {
                    ed12.a("source", getIntent().getStringExtra("src"));
                }
                jz5.b().g(ed12);
                this.F.set_isFreeRide(false);
                this.F.setPaymentRequired(true);
                this.A = Boolean.FALSE;
                E0(true);
                this._freeRideCouponContainer.setVisibility(0);
                this._freeRideCouponContainer.findViewById(R.id.coupon_discount).setVisibility(8);
                TextView textView = (TextView) this._freeRideCouponContainer.findViewById(R.id.coupon_description);
                textView.setText(getString(R.string.tv_error_free_ride_redeemed));
                textView.setTextColor(getResources().getColor(R.color.no_internet_banner_color));
            } else {
                Toast.makeText(this, (int) R.string.toast_generic_error_message, 1).show();
            }
        } else if (!TextUtils.isEmpty(bookingTransactionEvent.getErrorMessage())) {
            Toast.makeText(this, bookingTransactionEvent.getErrorMessage(), 1).show();
        } else {
            Toast.makeText(this, (int) R.string.toast_generic_error_message, 1).show();
        }
        k0();
    }

    public void onEvent(qd1 qd1) {
        if (vn.K0(this)) {
            e0();
        } else {
            f0(this._mTicketTripInfoContainer);
        }
    }
}
