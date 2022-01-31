package app.zophop.products;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.RouteInfo;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductConfigurationMap;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.pubsub.eventbus.events.FareFetchRoutePassEvent;
import app.zophop.pubsub.eventbus.events.FetchRoutePassEvent;
import app.zophop.pubsub.eventbus.events.LiveRouteDetailsEvent;
import app.zophop.pubsub.eventbus.events.ProductConfigurationFetchedEvent;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.MTicketSelectionActivity;
import app.zophop.ui.activities.MTicketTripInfoActivity;
import app.zophop.ui.activities.PickRouteLocationActivity;
import app.zophop.ui.activities.RenewMagicPassActivity;
import app.zophop.ui.adapters.ProductInfo;
import app.zophop.ui.views.RecentProductItemView;
import butterknife.InjectView;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import defpackage.xm0;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import server.zophop.logicLayer.CsLogic;

public class ProductSelectionActivity extends pf0 {
    public static final /* synthetic */ int D = 0;
    public boolean A = false;
    public Map<String, MPass> B;
    public Set<ProductInfo> C;
    @InjectView(R.id.product_selection_nested_scroll_view)
    public NestedScrollView _productSelectionNestedScrollView;
    @InjectView(R.id.multiple_products_disabled_banner_product_selection)
    public LinearLayout allProductsDisabledBanner;
    @InjectView(R.id.product_selection_disabled_textview)
    public TextView allProductsDisabledTextview;
    public String o;
    public String p;
    public HashMap<String, ProductInfo> q;
    public String r;
    @InjectView(R.id.recent_purchases_header)
    public LinearLayout recentPurchasesHeader;
    @InjectView(R.id.recent_purchases_layout)
    public LinearLayout recentPurchasesLinearLayout;
    @InjectView(R.id.recent_purchases_see_all)
    public TextView recentPurchasesSeeAllButton;
    @InjectView(R.id.product_recycler_view)
    public RecyclerView recyclerView;
    public DialogFragment s;
    public MTicket t;
    public boolean u;
    public List<BookingItem> v;
    public Context w;
    public String x;
    public ProductConfigurationMap y;
    public boolean z;

    public class a implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public a(ProductSelectionActivity productSelectionActivity, lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            this.f.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public b(lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            this.f.dismiss();
            jz5.b().o(this);
            Intent intent = new Intent(ProductSelectionActivity.this.w, MTicketTripInfoActivity.class);
            intent.putExtra("src", "product_selection_recent_products");
            ProductSelectionActivity.this.startActivity(intent);
        }
    }

    public class c implements xm0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f278a;
        public final /* synthetic */ MPass b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ List d;

        public c(String str, MPass mPass, boolean z, List list) {
            this.f278a = str;
            this.b = mPass;
            this.c = z;
            this.d = list;
        }

        @Override // defpackage.xm0.a
        public void a() {
            HashMap hashMap = new HashMap();
            hashMap.put("reason for disabled product dialog popup", this.f278a);
            hashMap.put("mpass verification expiry time ", String.valueOf(this.b.getVerificationExpiryTime()));
            if (this.b.getRouteStopsInfo() != null) {
                ProductSelectionActivity.s0("recent product error dialog rendered mpass", hashMap);
            } else {
                ProductSelectionActivity.s0("recent product error dialog rendered routepass", hashMap);
            }
        }

        @Override // defpackage.xm0.a
        public void b() {
            if (this.c) {
                RenewMagicPassActivity.m0(ProductSelectionActivity.this.w, this.b, "product_selection_recent_products", this.d);
            }
        }
    }

    public class d implements xm0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f279a;
        public final /* synthetic */ Route b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ MTicket e;
        public final /* synthetic */ ProductConfiguration f;

        public d(ProductSelectionActivity productSelectionActivity, String str, Route route, boolean z, Context context, MTicket mTicket, ProductConfiguration productConfiguration) {
            this.f279a = str;
            this.b = route;
            this.c = z;
            this.d = context;
            this.e = mTicket;
            this.f = productConfiguration;
        }

        @Override // defpackage.xm0.a
        public void a() {
            HashMap hashMap = new HashMap();
            hashMap.put("reason for disabled product dialog popup", this.f279a);
            hashMap.put("route name", this.b.getRouteId());
            ProductSelectionActivity.s0("recent product error dialog rendered mTicket", hashMap);
        }

        @Override // defpackage.xm0.a
        public void b() {
            if (this.c) {
                MTicketSelectionActivity.v0(this.d, this.b, this.e, TransitMode.bus, "product_selection_recent_products", this.f.getProductId());
            }
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ FareFetchRoutePassEvent f;

        public e(FareFetchRoutePassEvent fareFetchRoutePassEvent) {
            this.f = fareFetchRoutePassEvent;
        }

        public void onClick(View view) {
            Map<String, MPass> map = ProductSelectionActivity.this.B;
            if (map != null && map.containsKey(this.f.getRequestId())) {
                ProductSelectionActivity.this.B.remove(this.f.getRequestId());
                ProductSelectionActivity.this.m0(ProductSelectionActivity.this.B.get(this.f.getRequestId()));
            }
        }
    }

    public class f {

        /* renamed from: a  reason: collision with root package name */
        public double f280a;
        public String b;
        public String c;
        public String d;

        public f(ProductSelectionActivity productSelectionActivity, double d2, String str, String str2, String str3) {
            this.f280a = d2;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (this.f280a != fVar.f280a || !this.b.equals(fVar.b) || !this.c.equals(fVar.c) || !this.d.equals(fVar.d)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(Double.valueOf(this.f280a), this.b, this.c, this.d);
        }
    }

    public class g {

        /* renamed from: a  reason: collision with root package name */
        public int f281a;
        public double b;
        public String c;

        public g(ProductSelectionActivity productSelectionActivity, int i, double d, String str) {
            this.f281a = i;
            this.b = d;
            this.c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            if (this.f281a == gVar.f281a && this.b == gVar.b && this.c.equals(gVar.c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f281a), Double.valueOf(this.b), this.c);
        }
    }

    public class h {

        /* renamed from: a  reason: collision with root package name */
        public int f282a;
        public double b;
        public String c;
        public String d;
        public String e;
        public String f;

        public h(ProductSelectionActivity productSelectionActivity, int i, double d2, String str, String str2, String str3, String str4) {
            this.f282a = i;
            this.b = d2;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (this.f282a != hVar.f282a || this.b != hVar.b || !this.c.equals(hVar.c) || !this.d.equals(hVar.d) || !this.e.equals(hVar.e) || !this.f.equals(hVar.f)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f282a), Double.valueOf(this.b), this.c, this.d, this.e, this.f);
        }
    }

    public static String n0() {
        return ProductSelectionActivity.class.getSimpleName();
    }

    public static void s0(String str, Map<String, String> map) {
        ed1 ed1 = new ed1(str, Long.MIN_VALUE);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                ed1.a(entry.getKey(), entry.getValue());
            }
        }
        jz5.b().g(ed1);
    }

    @Override // defpackage.pf0, defpackage.tf1
    public void e(Bundle bundle) {
        this.n = "productSelectionActivity";
        super.e(bundle);
    }

    @Override // defpackage.pf0
    public void init() {
        this.x = UUID.randomUUID().toString();
        getIntent().getStringExtra("agency");
        this.o = getIntent().getStringExtra("src");
        if (getIntent().hasExtra("extraTargetConfigId")) {
            this.p = getIntent().getStringExtra("extraTargetConfigId");
        }
        if (TextUtils.isEmpty(this.o)) {
            this.o = getIntent().getStringExtra("source");
        }
        boolean z2 = false;
        if (getIntent().hasExtra("isFromProductGroupHook")) {
            this.A = getIntent().getBooleanExtra("isFromProductGroupHook", false);
        }
        fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
        this.s = fv0;
        if (fv0 == null) {
            fv0 T = vn.T(null, getString(R.string.loading), false, false);
            this.s = T;
            T.setRetainInstance(true);
        }
        xt.t1 t1Var = xt.f3961a;
        if (ui1.c0(t1Var.k().d()) && !this.A) {
            z2 = true;
        }
        this.z = z2;
        t1Var.c().b(hj1.B(t1Var), this.x);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0199  */
    @Override // defpackage.pf0
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j0() {
        /*
        // Method dump skipped, instructions count: 1311
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.products.ProductSelectionActivity.j0():void");
    }

    public void k0(View view, BookingItem bookingItem) {
        CardView cardView = new CardView(this);
        cardView.addView(new RecentProductItemView(this, bookingItem));
        cardView.setOnClickListener(new t70(this, bookingItem));
        float applyDimension = TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
        cardView.setClickable(true);
        cardView.setUseCompatPadding(true);
        cardView.setCardElevation(applyDimension);
        LinearLayout linearLayout = (LinearLayout) view;
        linearLayout.addView(cardView);
        View view2 = new View(this);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.scheduler_results_divider)));
        linearLayout.addView(view2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0087 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l0(app.zophop.models.mTicketing.MPass r14, app.zophop.models.mTicketing.ProductConfiguration r15, java.util.Map<java.lang.String, java.util.List<app.zophop.models.mTicketing.ProductFareMapping>> r16) {
        /*
        // Method dump skipped, instructions count: 136
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.products.ProductSelectionActivity.l0(app.zophop.models.mTicketing.MPass, app.zophop.models.mTicketing.ProductConfiguration, java.util.Map):boolean");
    }

    public final void m0(MPass mPass) {
        if (mPass != null) {
            String uuid = UUID.randomUUID().toString();
            w0();
            String routeId = mPass.getRouteStopsInfo().getRouteId();
            String configId = mPass.getConfigId();
            this.B.put(uuid, mPass);
            xt.f3961a.c().N(routeId, configId, uuid);
        }
    }

    public final ProductInfo o0(String str) {
        for (ProductInfo productInfo : this.C) {
            if (productInfo.i.equals(str)) {
                return productInfo;
            }
            List<String> list = productInfo.p;
            if (list != null) {
                for (String str2 : list) {
                    if (str2.equals(str)) {
                        return productInfo;
                    }
                }
                continue;
            }
        }
        return null;
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 123) {
            Route route = (Route) new Gson().fromJson(intent.getStringExtra("result_route"), Route.class);
            u0();
            Intent intent2 = new Intent(this, CategorySelectionActivity.class);
            intent2.putExtra("src", "routePass");
            String stringExtra = intent.getStringExtra("productId");
            this.r = stringExtra;
            intent2.putExtra("productId", stringExtra);
            intent2.putExtra("routeInfo", new Gson().toJson((RouteInfo) hj1.s(intent.getStringExtra("result_route_info"), RouteInfo.class)));
            startActivity(intent2);
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

    public void onEvent(FetchRoutePassEvent fetchRoutePassEvent) {
        DialogFragment dialogFragment = this.s;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
        jz5.b().m(fetchRoutePassEvent);
        List<RouteInfo> list = null;
        if (!(fetchRoutePassEvent.getResponseType() == null || fetchRoutePassEvent.getCityName() == null)) {
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.k().d() != null && fetchRoutePassEvent.getCityName().equalsIgnoreCase(t1Var.k().d().getName())) {
                if (fetchRoutePassEvent.getResponseType().equals(ad1.SUCCESS)) {
                    list = fetchRoutePassEvent.getRouteInfoList();
                } else {
                    Toast.makeText(this, getString(R.string.internet_error), 1).show();
                    return;
                }
            }
        }
        if (list == null || list.size() != 1) {
            Intent intent = new Intent(this, PickRouteLocationActivity.class);
            intent.putExtra("is_for_result", String.valueOf(true));
            intent.putExtra("is_for_route_pass", String.valueOf(true));
            intent.putExtra("productId", this.r);
            intent.putParcelableArrayListExtra("routePassIds", (ArrayList) list);
            startActivityForResult(intent, 123);
            return;
        }
        RouteInfo routeInfo = list.get(0);
        String json = new Gson().toJson(routeInfo);
        this.r = vn.t("routePass", routeInfo.getAgencyName());
        Intent intent2 = new Intent(this, CategorySelectionActivity.class);
        intent2.putExtra("src", "routePass");
        intent2.putExtra("routeInfo", json);
        intent2.putExtra("productId", this.r);
        startActivity(intent2);
        finish();
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public final void p0(String str, String str2, MTicket mTicket, String str3, boolean z2, Context context, Route route, ProductConfiguration productConfiguration) {
        xm0.a(getFragmentManager(), context, new d(this, str3, route, z2, context, mTicket, productConfiguration), n0(), str2, str, false);
    }

    public final void q0(String str, String str2, MPass mPass, String str3, boolean z2, List<ProductFareMapping> list) {
        xm0.a(getFragmentManager(), this.w, new c(str3, mPass, z2, list), n0(), str2, str, false);
    }

    public final boolean r0(long j) {
        return ui1.Q() - j > jh1.a(CsLogic.ETA_FORCE_UPDATE_REDIS_TTL);
    }

    public final boolean t0(ProductInfo productInfo) {
        if (productInfo == null) {
            return false;
        }
        String str = productInfo.n;
        String str2 = productInfo.i;
        if (str.equals("routePass") || str.contains("rpPass")) {
            w0();
            this.r = str2;
            xt.f3961a.c().c();
            return true;
        } else if (str.equals("magicPass") || str.contains("pass")) {
            List<String> list = productInfo.p;
            Intent intent = new Intent(this.w, CategorySelectionActivity.class);
            intent.putExtra("src", "magicPass");
            intent.putExtra("productId", str2);
            intent.putStringArrayListExtra("productIds", (ArrayList) list);
            intent.putExtra("source", "product_selection_recent_products");
            this.w.startActivity(intent);
            return true;
        } else if (!str.equals("superSaver")) {
            return false;
        } else {
            List<String> list2 = productInfo.p;
            Intent intent2 = new Intent(this.w, CategorySelectionActivity.class);
            intent2.putExtra("src", str);
            intent2.putExtra("productId", str2);
            intent2.putStringArrayListExtra("productIds", (ArrayList) list2);
            intent2.putExtra("source", "product_selection_recent_products");
            this.w.startActivity(intent2);
            return true;
        }
    }

    public final void u0() {
    }

    public void v0(boolean z2) {
        if (z2) {
            this.recentPurchasesLinearLayout.setVisibility(0);
            this.recentPurchasesHeader.setVisibility(0);
            return;
        }
        this.recentPurchasesLinearLayout.setVisibility(8);
        this.recentPurchasesHeader.setVisibility(8);
    }

    public void w0() {
        DialogFragment dialogFragment = this.s;
        if (dialogFragment != null && !dialogFragment.isVisible()) {
            this.s.show(getFragmentManager(), "loader_tag");
        }
    }

    public void onEvent(FareFetchRoutePassEvent fareFetchRoutePassEvent) {
        jz5.b().m(this);
        DialogFragment dialogFragment = this.s;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
        if (fareFetchRoutePassEvent.getResponseType().equals(ad1.SUCCESS)) {
            e0();
            Map<String, List<ProductFareMapping>> fareMapping = fareFetchRoutePassEvent.getFareMapping();
            MPass mPass = this.B.get(fareFetchRoutePassEvent.getRequestId());
            if (mPass != null && !l0(mPass, xt.f3961a.c().h0(mPass.getConfigId()), fareMapping)) {
                RenewMagicPassActivity.m0(this, mPass, "product_selection_recent_products", vn.t0(mPass, fareMapping));
                return;
            }
            return;
        }
        e0();
        e eVar = new e(fareFetchRoutePassEvent);
        int color = getResources().getColor(R.color.white);
        int color2 = getResources().getColor(R.color.mticket_status_action_color);
        int color3 = getResources().getColor(R.color.mticket_status_background_color);
        e0();
        String string = getString(R.string.fetching_fare_details_failed);
        Snackbar j = Snackbar.j(this.recentPurchasesLinearLayout, vn.k(string, 0, string.length(), color, true), -2);
        this.i = j;
        j.c.setBackgroundColor(color3);
        String string2 = getString(R.string.retry);
        this.i.k(vn.k(string2, 0, string2.length(), color2, true), eVar);
        this.i.l(color2);
        TextView textView = (TextView) this.i.c.findViewById(R.id.snackbar_action);
        textView.setTypeface(textView.getTypeface(), 1);
        this.i.m();
    }

    public void onEvent(LiveRouteDetailsEvent liveRouteDetailsEvent) {
        Route route;
        jz5.b().m(liveRouteDetailsEvent);
        if (liveRouteDetailsEvent.getResponseType() == null) {
            Toast.makeText(this, getString(R.string.toast_generic_error_message), 0).show();
        } else if (!liveRouteDetailsEvent.getResponseType().equals(ad1.SUCCESS)) {
            Toast.makeText(this, getString(R.string.toast_generic_error_message), 0).show();
        } else if (this.t != null && liveRouteDetailsEvent.getRouteId().equals(this.t.getUpTripRouteStopsInfo().getRouteId()) && (route = liveRouteDetailsEvent.getRoute()) != null) {
            if (route.isMTicketEnabled()) {
                ProductConfiguration w0 = vn.w0(xt.f3961a.c().j0(this.t.getAgency().toLowerCase()));
                if (w0 == null) {
                    p0(getString(R.string.recent_products_not_available_dialog_title), getString(R.string.recent_products_not_available_dialog_copy), this.t, "product permanently disabled", false, this.w, null, null);
                    return;
                }
                Map i = vn.i(w0, this.w);
                if (i != null) {
                    p0((String) i.get("keyDialogTitle"), (String) i.get("keyDialogCopy"), this.t, (String) i.get("keyDialogReason"), false, this.w, route, w0);
                } else {
                    MTicketSelectionActivity.v0(this.w, route, this.t, TransitMode.bus, "product_selection_recent_products", w0.getProductId());
                }
            } else {
                lm0 a2 = lm0.a(getFragmentManager(), getResources().getString(R.string.title_dialog_mticket_disabled_route), getResources().getString(R.string.msg_dialog_mticket_disabled_route, route.getRouteName()), getResources().getString(R.string.continue_dialog_mticket_disabled_route), getResources().getString(R.string.cancel_dialog_mticket_disabled_route));
                a aVar = new a(this, a2);
                TextView textView = a2.j;
                if (textView != null) {
                    textView.setOnClickListener(aVar);
                } else {
                    a2.r = aVar;
                }
                b bVar = new b(a2);
                TextView textView2 = a2.i;
                if (textView2 != null) {
                    textView2.setOnClickListener(bVar);
                } else {
                    a2.q = bVar;
                }
            }
        }
    }

    public void onEvent(ProductConfigurationFetchedEvent productConfigurationFetchedEvent) {
        jz5.b().m(productConfigurationFetchedEvent);
        ed1 ed1 = new ed1("configuration fetched", Long.MIN_VALUE);
        if (productConfigurationFetchedEvent.getResponseType() == null) {
            ed1.a("response", String.valueOf(true));
            h0();
            return;
        }
        String str = this.x;
        if (str != null && str.equals(productConfigurationFetchedEvent.getConfigRequestId())) {
            if (productConfigurationFetchedEvent.getResponseType().equals(ad1.SUCCESS)) {
                ed1.a("response", String.valueOf(true));
                ProductConfigurationMap productConfigMap = productConfigurationFetchedEvent.getProductConfigMap();
                this.y = productConfigMap;
                if (productConfigMap != null) {
                    i0();
                } else {
                    ed1.a("response", String.valueOf(false));
                    if (this.z) {
                        i0();
                    } else {
                        h0();
                    }
                }
            } else {
                ed1.a("response", String.valueOf(true));
                if (this.z) {
                    i0();
                } else {
                    h0();
                }
            }
            jz5.b().g(ed1);
            this.x = null;
        }
    }
}
