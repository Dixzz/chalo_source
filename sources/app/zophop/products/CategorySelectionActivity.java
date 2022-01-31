package app.zophop.products;

import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.RouteInfo;
import app.zophop.models.mTicketing.BookingPassType;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.ProductDuration;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.RouteStopsInfo;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.FareFetchRoutePassEvent;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.MPassPurchaseActivity;
import com.google.android.material.snackbar.Snackbar;
import defpackage.xt;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import zophop.models.SPECIAL_FEATURE;

public class CategorySelectionActivity extends wt {
    public static final /* synthetic */ int d0 = 0;
    public pu A;
    public RecyclerView.m B;
    public Button C;
    public int D = -1;
    public TextView E;
    public long F;
    public Map<Pair<String, Long>, String> G;
    public String H;
    public String I;
    public List<String> J;
    public double K;
    public RouteInfo L;
    public TextView M;
    public TextView N;
    public Snackbar O;
    public RelativeLayout P;
    public String Q;
    public CardView R;
    public TextView S;
    public boolean T;
    public DialogFragment U;
    public String V;
    public p70 W;
    public LinearLayout X;
    public TextView Y;
    public int Z;
    public int a0;
    public boolean b0;
    public TextView c0;
    public String l;
    public String m;
    public String n;
    public List<ProductConfiguration> o;
    public ProductConfiguration p;
    public LinkedHashSet<String> q;
    public LinearLayout r;
    public HorizontalScrollView s;
    public Map<String, String> t;
    public List<String> u;
    public ArrayList<String> v;
    public Map<Integer, ProductCategory> w;
    public Map<String, ProductCategory> x;
    public RecyclerView y;
    public Map<String, List<ProductFareMapping>> z;

    public class a implements Comparator<ProductConfiguration>, j$.util.Comparator {
        public a(CategorySelectionActivity categorySelectionActivity) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(ProductConfiguration productConfiguration, ProductConfiguration productConfiguration2) {
            return Integer.valueOf(productConfiguration.getProductPriority()).compareTo(Integer.valueOf(productConfiguration2.getProductPriority()));
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<ProductConfiguration> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<ProductConfiguration> thenComparing(java.util.Comparator<? super ProductConfiguration> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            CategorySelectionActivity categorySelectionActivity = CategorySelectionActivity.this;
            categorySelectionActivity.k0(categorySelectionActivity.Q);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            ProductConfiguration productConfiguration;
            for (Map.Entry<Pair<String, Long>, String> entry : CategorySelectionActivity.this.G.entrySet()) {
                if (CategorySelectionActivity.this.H.equals(entry.getKey().first) && CategorySelectionActivity.this.F == ((Long) entry.getKey().second).longValue()) {
                    CategorySelectionActivity.this.I = entry.getValue();
                    MPass mPass = new MPass();
                    mPass.setConfigId(CategorySelectionActivity.this.I);
                    mPass.setNoOfDays((int) (CategorySelectionActivity.this.F / 86400000));
                    mPass.setPassengerType(CategorySelectionActivity.this.H);
                    mPass.setSpecialFeatures(CategorySelectionActivity.this.J);
                    mPass.setFare(CategorySelectionActivity.this.K);
                    mPass.set_productName(CategorySelectionActivity.this.V);
                    CategorySelectionActivity categorySelectionActivity = CategorySelectionActivity.this;
                    ProductCategory productCategory = categorySelectionActivity.x.get(categorySelectionActivity.H);
                    mPass.set_grouping(productCategory);
                    mPass.set_productType(CategorySelectionActivity.this.n);
                    mPass.set_maxTrips(CategorySelectionActivity.this.Z);
                    mPass.set_maxTripsPerDay(CategorySelectionActivity.this.a0);
                    mPass.set_bookingPassType(BookingPassType.MAGIC);
                    mPass.set_passApplicationActionRequired(PassApplicationActionRequired.FRESH);
                    CategorySelectionActivity categorySelectionActivity2 = CategorySelectionActivity.this;
                    if (categorySelectionActivity2.u == null && (productConfiguration = categorySelectionActivity2.p) != null) {
                        mPass.setAgency(productConfiguration.getProductAgency());
                    }
                    boolean z = true;
                    mPass.set_isVerificationRequired(productCategory == null || productCategory.isCategoryVerificationRequired());
                    xt.t1 t1Var = xt.f3961a;
                    if (t1Var.L().m()) {
                        mPass.setUserProfile(t1Var.L().e());
                    }
                    if (CategorySelectionActivity.this.L != null) {
                        mPass.setRouteStopsInfo(new RouteStopsInfo(CategorySelectionActivity.this.L.getRouteId(), CategorySelectionActivity.this.L.getRouteName(), null, CategorySelectionActivity.this.L.getFirstStopName(), null, CategorySelectionActivity.this.L.getLastStopName()));
                        mPass.setAgency(CategorySelectionActivity.this.L.getAgencyName());
                    }
                    Objects.requireNonNull(CategorySelectionActivity.this);
                    ed1 ed1 = new ed1("pass details selected", Long.MIN_VALUE);
                    ed1.a("passengerType", mPass.getPassengerType());
                    ed1.a("bookingDate", jh1.c(System.currentTimeMillis()));
                    ed1.a(SuperPassJsonKeys.FARE, mPass.getFare() + "");
                    ed1.a("numDays", mPass.getNoOfDays() + "");
                    if (mPass.getRouteStopsInfo() == null) {
                        z = false;
                    }
                    ed1.a("isRoutePass", Boolean.valueOf(z));
                    ed1.a("productType", mPass.get_productType());
                    jz5.b().g(ed1);
                    CategorySelectionActivity categorySelectionActivity3 = CategorySelectionActivity.this;
                    MPassPurchaseActivity.s0(categorySelectionActivity3, "sourceCategorySelectionActivity", "flowFreshPurchase", mPass, categorySelectionActivity3.L);
                }
            }
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        this.n = getIntent().getStringExtra("src");
        this.l = getIntent().getStringExtra("productId");
        this.u = getIntent().getStringArrayListExtra("productIds");
        m0();
        String productType = this.p.getProductType();
        this.m = productType;
        this.b0 = !productType.equals("superSaver");
        l0();
        r0();
        String stringExtra = getIntent().getStringExtra("routeInfo");
        if (!TextUtils.isEmpty(stringExtra)) {
            RouteInfo routeInfo = (RouteInfo) hj1.s(stringExtra, RouteInfo.class);
            this.L = routeInfo;
            q0(routeInfo);
        }
    }

    @Override // defpackage.tf1
    public void e0() {
        Snackbar snackbar = this.O;
        if (snackbar != null) {
            snackbar.b(3);
        }
    }

    public final void h0() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        getSupportActionBar().z(this.o.get(0).getProductName());
        getSupportActionBar().t(R.drawable.abc_ic_ab_back_material);
    }

    public final void i0() {
        if (this.v.size() > 0) {
            for (int i = 0; i < this.v.size(); i++) {
                p0(this.v.size(), i, this.v.get(i));
            }
        } else if (this.w.size() > 0) {
            int i2 = 0;
            for (Map.Entry<Integer, ProductCategory> entry : this.w.entrySet()) {
                p0(this.w.size(), i2, entry.getValue().getCategoryId());
                i2++;
            }
        }
        for (int i3 = 0; i3 < this.r.getChildCount(); i3++) {
            if (this.H == this.r.getChildAt(i3).getTag()) {
                this.r.getChildAt(i3).performClick();
            }
        }
        this.C.setOnClickListener(new c());
        if (this.r.getChildCount() == 1) {
            this.s.setVisibility(8);
        } else {
            this.s.setVisibility(0);
        }
        for (int i4 = 0; i4 < this.r.getChildCount(); i4++) {
            if (!this.T) {
                this.r.getChildAt(i4).callOnClick();
            }
        }
    }

    public final boolean j0(ProductCategory productCategory, ProductFareMapping productFareMapping, ProductConfiguration productConfiguration) {
        String str;
        productFareMapping.setInactiveReasonPriority(-1);
        ProductDuration productDuration = null;
        if (!productCategory.isCategoryActive()) {
            productFareMapping.setIsActive(Boolean.FALSE);
            if (!TextUtils.isEmpty(productCategory.getInactiveReason())) {
                str = productCategory.getInactiveReason();
                productFareMapping.setInactiveReason(str);
            } else {
                str = null;
            }
            productFareMapping.setInactiveReasonPriority(productConfiguration.getProductPriority());
        } else {
            str = null;
        }
        long durationId = productFareMapping.getDurationId();
        Iterator<ProductDuration> it = productConfiguration.getProductDurations().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ProductDuration next = it.next();
            if (next.getValidity() == durationId) {
                productDuration = next.deepCopyProductDuration(next);
                break;
            }
        }
        if (productDuration == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            productDuration.setInactiveReason(str);
        }
        productFareMapping.setProductDuration(productDuration);
        return true;
    }

    public final void k0(String str) {
        this.C.setVisibility(8);
        String uuid = UUID.randomUUID().toString();
        s0(R.string.fetching_fare_details, 0, true, false, null, getResources().getColor(R.color.white), 0, getResources().getColor(R.color.mticket_status_background_color));
        xt.f3961a.c().N(str, this.l, uuid);
    }

    public final void l0() {
        this.q = new LinkedHashSet<>();
        this.w = new LinkedHashMap();
        for (int i = 0; i < this.o.size(); i++) {
            List<ProductCategory> productCategoryList = this.o.get(i).getProductCategoryList();
            for (int i2 = 0; i2 < productCategoryList.size(); i2++) {
                if (!(this.o.get(i).getProductSubType().equals("magicPass") && productCategoryList.get(i2).getCategoryId().equals("SUPER_SAVER")) && !this.x.containsKey(productCategoryList.get(i2).getCategoryId())) {
                    this.q.add(productCategoryList.get(i2).getCategoryId());
                    this.x.put(productCategoryList.get(i2).getCategoryId(), productCategoryList.get(i2));
                    this.w.put(Integer.valueOf(productCategoryList.get(i2).get_displayOrder()), productCategoryList.get(i2));
                }
            }
        }
    }

    public final void m0() {
        this.o = new ArrayList();
        this.G = new HashMap();
        this.x = new HashMap();
        ProductConfiguration m0 = vn.m0(this.l);
        this.p = m0;
        this.o.add(m0);
        if (this.u != null) {
            for (int i = 0; i < this.u.size(); i++) {
                if (!this.u.get(i).equals(this.l)) {
                    this.o.add(vn.m0(this.u.get(i)));
                }
            }
        }
        Collections.sort(this.o, new a(this));
    }

    public final void n0() {
        p70 p70;
        for (ProductConfiguration productConfiguration : this.o) {
            if (this.z == null) {
                Map<String, List<ProductFareMapping>> productFareMapping = productConfiguration.getProductFareMapping();
                this.z = new HashMap();
                for (Map.Entry<String, List<ProductFareMapping>> entry : productFareMapping.entrySet()) {
                    ProductCategory o0 = o0(entry.getKey(), productConfiguration);
                    if (o0 != null) {
                        ArrayList arrayList = new ArrayList();
                        for (ProductFareMapping productFareMapping2 : entry.getValue()) {
                            if (j0(o0, productFareMapping2, productConfiguration)) {
                                arrayList.add(productFareMapping2);
                            }
                        }
                        if (arrayList.size() != 0) {
                            this.z.put(entry.getKey(), arrayList);
                        }
                    }
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        this.G.put(new Pair<>(entry.getKey(), Long.valueOf(entry.getValue().get(i).getDurationId())), productConfiguration.getProductId());
                    }
                }
            } else {
                for (Map.Entry<String, List<ProductFareMapping>> entry2 : productConfiguration.getProductFareMapping().entrySet()) {
                    ProductCategory o02 = o0(entry2.getKey(), productConfiguration);
                    if (this.z.containsKey(entry2.getKey()) && o02 != null) {
                        List<ProductFareMapping> list = this.z.get(entry2.getKey());
                        ArrayList arrayList2 = new ArrayList();
                        for (ProductFareMapping productFareMapping3 : entry2.getValue()) {
                            if (j0(o02, productFareMapping3, productConfiguration)) {
                                arrayList2.add(productFareMapping3);
                            }
                        }
                        if (arrayList2.size() != 0) {
                            list.addAll(arrayList2);
                        }
                    } else if (o02 != null) {
                        ArrayList arrayList3 = new ArrayList();
                        for (ProductFareMapping productFareMapping4 : entry2.getValue()) {
                            if (j0(o02, productFareMapping4, productConfiguration)) {
                                arrayList3.add(productFareMapping4);
                            }
                        }
                        if (arrayList3.size() != 0) {
                            this.z.put(entry2.getKey(), arrayList3);
                        }
                    }
                    for (int i2 = 0; i2 < entry2.getValue().size(); i2++) {
                        this.G.put(new Pair<>(entry2.getKey(), Long.valueOf(entry2.getValue().get(i2).getDurationId())), productConfiguration.getProductId());
                    }
                }
            }
        }
        Map<String, String> o03 = xt.f3961a.c().o0(this.n);
        this.t = o03;
        if (o03 != null && (p70 = this.W) != null) {
            p70.f = o03;
        } else if (this.W != null) {
            b00 b00 = b00.f358a;
            b00.a().a("DataFragment retention", "success");
            this.t = this.W.f;
        }
        if (this.t == null) {
            b00 b002 = b00.f358a;
            b00.a().a("DataFragment retention", "failed");
        }
        LinkedHashSet<String> linkedHashSet = this.q;
        this.v = new ArrayList<>();
        Map<String, String> map = this.t;
        if (map != null) {
            for (Map.Entry<String, String> entry3 : map.entrySet()) {
                String key = entry3.getKey();
                Iterator<String> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next.equalsIgnoreCase(key)) {
                        this.v.add(next);
                    }
                }
            }
        }
    }

    public final ProductCategory o0(String str, ProductConfiguration productConfiguration) {
        for (int i = 0; i < productConfiguration.getProductCategoryList().size(); i++) {
            if (productConfiguration.getProductCategoryList().get(i).getCategoryId().equals(str)) {
                return productConfiguration.getProductCategoryList().get(i);
            }
        }
        return null;
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        DialogFragment dialogFragment = this.U;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
        if (i2 == -1 && i == 123) {
            this.L = (RouteInfo) hj1.s(intent.getStringExtra("result_route_info"), RouteInfo.class);
            this.l = intent.getStringExtra("productId");
            q0(this.L);
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

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
        p70 p70 = this.W;
        if (p70 != null) {
            p70.f = xt.f3961a.c().o0(this.n);
        }
        jz5.b().o(this);
    }

    public void onEvent(FareFetchRoutePassEvent fareFetchRoutePassEvent) {
        this.C.setVisibility(8);
        this.T = false;
        jz5.b().m(this);
        if (fareFetchRoutePassEvent.getResponseType().equals(ad1.SUCCESS)) {
            e0();
            this.z = null;
            m0();
            l0();
            n0();
            this.r.removeAllViews();
            this.D = -1;
            i0();
            return;
        }
        this.r.setVisibility(8);
        e0();
        s0(R.string.fetching_fare_details_failed, R.string.retry, true, true, new b(), getResources().getColor(R.color.white), getResources().getColor(R.color.mticket_status_action_color), getResources().getColor(R.color.mticket_status_background_color));
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.l = bundle.getString("productId");
        this.u = bundle.getStringArrayList("productIds");
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("productId", this.l);
        bundle.putStringArrayList("productIds", (ArrayList) this.u);
    }

    public final void p0(int i, int i2, String str) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, (int) ui1.n(12.0f, this), 0);
        TextView textView = new TextView(this);
        textView.setAllCaps(false);
        String k0 = xt.f3961a.c().k0(str);
        if (TextUtils.isEmpty(k0)) {
            k0 = this.x.get(str).get_categoryName();
        }
        textView.setText(k0);
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.createFromAsset(getResources().getAssets(), "fonts/NotoSans-SemiBold.ttf"));
        textView.setBackgroundResource(R.drawable.grey_capsule);
        textView.setTextColor(getResources().getColor(R.color.black));
        if (i2 == i - 1) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, (int) ui1.n(24.0f, this), 0);
            textView.setLayoutParams(layoutParams2);
        } else {
            textView.setLayoutParams(layoutParams);
        }
        textView.setPadding((int) ui1.n(16.0f, this), (int) ui1.n(10.0f, this), (int) ui1.n(16.0f, this), (int) ui1.n(10.0f, this));
        textView.setTag(str);
        textView.setOnClickListener(new o70(this, i2));
        this.r.addView(textView);
    }

    public void q0(RouteInfo routeInfo) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) new SpannableString(routeInfo.getRouteName()));
        if (routeInfo.getSpecialFeatures() != null) {
            if (routeInfo.getSpecialFeatures().contains(SPECIAL_FEATURE.AC)) {
                new SpannableString("  ");
                d71.b(this, spannableStringBuilder, "AC", true, R.color.spf, this.L.getRouteName().length(), R.color.white);
            } else if (routeInfo.getSpecialFeatures().contains(SPECIAL_FEATURE.FAST)) {
                d71.b(this, spannableStringBuilder, "FAST", true, R.color.real_time_fetching_string_color, this.L.getRouteName().length(), R.color.white);
            }
        }
        List<String> list = this.L.get_updateSpecialFeaturesList();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains("AC") || list.get(i).contains("FAST")) {
                    d71.b(this, spannableStringBuilder, list.get(i), true, R.color.real_time_fetching_string_color, this.L.getRouteName().length(), R.color.white);
                } else {
                    d71.b(this, spannableStringBuilder, list.get(i), true, R.color.spf, this.L.getRouteName().length(), R.color.black_87);
                }
            }
        }
        d71.a(this, spannableStringBuilder, routeInfo.getAgencyName().toUpperCase(), true, routeInfo.getRouteName().length());
        this.M.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(routeInfo.getFirstStopName() + " ");
        spannableStringBuilder2.append((CharSequence) ProductDiscountsObject.KEY_DELIMITER);
        Drawable drawable = getResources().getDrawable(R.drawable.direction_route);
        drawable.setBounds(0, 0, 32, 32);
        spannableStringBuilder2.setSpan(new ImageSpan(drawable, 1), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 17);
        spannableStringBuilder2.append((CharSequence) (" " + routeInfo.getLastStopName()));
        this.N.setText(spannableStringBuilder2);
        this.Q = routeInfo.getRouteId();
        this.S.setOnClickListener(new m70(this));
        this.R.setOnClickListener(new m70(this));
        k0(routeInfo.getRouteId());
    }

    public final void r0() {
        int i = 0;
        if (this.p.shouldHideSubCategorySelection() || this.b0) {
            setContentView(R.layout.product_category_selection);
            jz5 b2 = jz5.b();
            b2.k(this, b2.e, false, 0);
            this.r = (LinearLayout) findViewById(R.id.category_types);
            this.s = (HorizontalScrollView) findViewById(R.id.horizontal_scroll_view);
            this.y = (RecyclerView) findViewById(R.id.duration_list);
            this.C = (Button) findViewById(R.id.pay_btn);
            this.R = (CardView) findViewById(R.id.route_layout);
            this.E = (TextView) findViewById(R.id.announcement);
            this.P = (RelativeLayout) findViewById(R.id.main_layout);
            this.M = (TextView) findViewById(R.id.route_number);
            this.N = (TextView) findViewById(R.id.route_info);
            this.S = (TextView) findViewById(R.id.edit);
            this.X = (LinearLayout) findViewById(R.id.category_selection_product_disabled_banner);
            this.Y = (TextView) findViewById(R.id.category_selection_disabled_product_textview);
            this.c0 = (TextView) findViewById(R.id.note);
            fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
            this.U = fv0;
            if (fv0 == null) {
                fv0 T2 = vn.T(null, getString(R.string.loading_pass), false, false);
                this.U = T2;
                T2.setRetainInstance(true);
            }
            ed1 ed1 = new ed1("product selected", Long.MIN_VALUE);
            ed1.a("source", this.n);
            ed1.a("productId", this.l);
            hj1.K0(ed1, "productType", this.m, ed1);
            if (this.p.getProductType().equals("routePass")) {
                this.R.setVisibility(0);
            } else {
                this.s.setVisibility(0);
                this.R.setVisibility(8);
            }
            n0();
            i0();
            h0();
            ed1 ed12 = new ed1("book pass screen opened", Long.MIN_VALUE);
            if (getIntent().hasExtra("source")) {
                ed12.a("source", getIntent().getStringExtra("source"));
            }
            if (getIntent().hasExtra("src")) {
                ed12.a("passType", getIntent().getStringExtra("src"));
            }
            jz5.b().g(ed12);
            zz zzVar = new zz("category selection screen open", new HashMap());
            zzVar.a("source", getIntent().getStringExtra("source"));
            ui1.l0(zzVar);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            p70 p70 = (p70) supportFragmentManager.I("data");
            this.W = p70;
            if (p70 == null) {
                this.W = new p70();
                ke keVar = new ke(supportFragmentManager);
                keVar.f(0, this.W, "data", 1);
                keVar.d();
                return;
            }
            return;
        }
        setContentView(R.layout.activity_super_saver_info);
        h0();
        GridView gridView = (GridView) findViewById(R.id.ss_categories);
        mu muVar = new mu(this, this.w);
        HashMap hashMap = new HashMap();
        Map<Integer, ProductCategory> map = this.w;
        if (map != null) {
            i = map.size();
        }
        hashMap.put("ss category count", Integer.valueOf(i));
        jz5.b().g(new ed1("ss intro screen open", Long.MIN_VALUE, hashMap));
        gridView.setAdapter((ListAdapter) muVar);
        gridView.setOnItemClickListener(new k70(this, muVar));
    }

    public final void s0(int i, int i2, boolean z2, boolean z3, View.OnClickListener onClickListener, int i3, int i4, int i5) {
        if (z2) {
            e0();
            String string = getString(i);
            Snackbar j = Snackbar.j(this.P, vn.k(string, 0, string.length(), i3, true), -2);
            this.O = j;
            j.c.setBackgroundColor(i5);
            if (z3) {
                String string2 = getString(i2);
                this.O.k(vn.k(string2, 0, string2.length(), i4, true), onClickListener);
                this.O.l(i4);
                TextView textView = (TextView) this.O.c.findViewById(R.id.snackbar_action);
                textView.setTypeface(textView.getTypeface(), 1);
            }
            this.O.m();
            return;
        }
        e0();
    }
}
