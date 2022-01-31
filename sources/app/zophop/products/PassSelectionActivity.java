package app.zophop.products;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.SubCategorySelectionDetails;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.SuperPassPurchaseActivity;
import com.google.android.material.snackbar.Snackbar;
import defpackage.ca1;
import java.util.Map;

/* compiled from: PassSelectionActivity.kt */
public final class PassSelectionActivity extends xl0<fw> {
    public static final /* synthetic */ int n = 0;
    public ca1 l;
    public boolean m;

    /* compiled from: ActivityViewModelLazy.kt */
    public static final class a extends o86 implements h76<gi> {
        public final /* synthetic */ ComponentActivity f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ComponentActivity componentActivity) {
            super(0);
            this.f = componentActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            gi viewModelStore = this.f.getViewModelStore();
            n86.d(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: PassSelectionActivity.kt */
    public static final class b extends o86 implements h76<ci> {
        public final /* synthetic */ PassSelectionActivity f;
        public final /* synthetic */ Bundle g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PassSelectionActivity passSelectionActivity, Bundle bundle) {
            super(0);
            this.f = passSelectionActivity;
            this.g = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new ca1.a(this.f, this.g);
        }
    }

    public static final void t0(Context context, String str, String str2) {
        n86.e(context, "lContext");
        Intent intent = new Intent(context, PassSelectionActivity.class);
        intent.putExtra("src", str2);
        intent.putExtra("productId", str);
        context.startActivity(intent);
    }

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_pass_selection, (ViewGroup) null, false);
        int i = R.id.alertIcon;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.alertIcon);
        if (imageView != null) {
            i = R.id.announcement;
            TextView textView = (TextView) inflate.findViewById(R.id.announcement);
            if (textView != null) {
                i = R.id.category_level_disabled_banner_text_view;
                TextView textView2 = (TextView) inflate.findViewById(R.id.category_level_disabled_banner_text_view);
                if (textView2 != null) {
                    i = R.id.category_level_product_disabled_banner;
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.category_level_product_disabled_banner);
                    if (linearLayout != null) {
                        i = R.id.category_types;
                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.category_types);
                        if (linearLayout2 != null) {
                            i = R.id.duration_list;
                            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.duration_list);
                            if (recyclerView != null) {
                                i = R.id.header_layout;
                                LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.header_layout);
                                if (linearLayout3 != null) {
                                    i = R.id.horizontal_scroll_view;
                                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) inflate.findViewById(R.id.horizontal_scroll_view);
                                    if (horizontalScrollView != null) {
                                        i = R.id.info_note;
                                        TextView textView3 = (TextView) inflate.findViewById(R.id.info_note);
                                        if (textView3 != null) {
                                            RelativeLayout relativeLayout = (RelativeLayout) inflate;
                                            i = R.id.pass_options_header;
                                            TextView textView4 = (TextView) inflate.findViewById(R.id.pass_options_header);
                                            if (textView4 != null) {
                                                i = R.id.pass_selection_layout;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) inflate.findViewById(R.id.pass_selection_layout);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.pass_selection_toolbar;
                                                    Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.pass_selection_toolbar);
                                                    if (toolbar != null) {
                                                        i = R.id.pay_btn;
                                                        Button button = (Button) inflate.findViewById(R.id.pay_btn);
                                                        if (button != null) {
                                                            i = R.id.sub_category_selection_description;
                                                            TextView textView5 = (TextView) inflate.findViewById(R.id.sub_category_selection_description);
                                                            if (textView5 != null) {
                                                                i = R.id.sub_category_selection_grid_view;
                                                                GridView gridView = (GridView) inflate.findViewById(R.id.sub_category_selection_grid_view);
                                                                if (gridView != null) {
                                                                    i = R.id.sub_category_selection_layout;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) inflate.findViewById(R.id.sub_category_selection_layout);
                                                                    if (relativeLayout3 != null) {
                                                                        i = R.id.sub_category_selection_title;
                                                                        TextView textView6 = (TextView) inflate.findViewById(R.id.sub_category_selection_title);
                                                                        if (textView6 != null) {
                                                                            i = R.id.sub_category_selection_toolbar;
                                                                            Toolbar toolbar2 = (Toolbar) inflate.findViewById(R.id.sub_category_selection_toolbar);
                                                                            if (toolbar2 != null) {
                                                                                i = R.id.top_layout;
                                                                                LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.top_layout);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.trip_details_disruption_cta;
                                                                                    TextView textView7 = (TextView) inflate.findViewById(R.id.trip_details_disruption_cta);
                                                                                    if (textView7 != null) {
                                                                                        fw fwVar = new fw(relativeLayout, imageView, textView, textView2, linearLayout, linearLayout2, recyclerView, linearLayout3, horizontalScrollView, textView3, relativeLayout, textView4, relativeLayout2, toolbar, button, textView5, gridView, relativeLayout3, textView6, toolbar2, linearLayout4, textView7);
                                                                                        n86.d(fwVar, "inflate(layoutInflater)");
                                                                                        return fwVar;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.ol0, defpackage.tl0
    public void h0(Bundle bundle) {
        super.h0(bundle);
        ed1 ed1 = new ed1("product selected", Long.MIN_VALUE);
        ca1 ca1 = this.l;
        if (ca1 != null) {
            ed1.a("source", ca1.e);
            ca1 ca12 = this.l;
            if (ca12 != null) {
                ed1.a("productId", ca12.d);
                ca1 ca13 = this.l;
                if (ca13 != null) {
                    ed1.a("productType", ca13.d().getProductType());
                    jz5.b().g(ed1);
                    ed1 ed12 = new ed1("book pass screen opened", Long.MIN_VALUE);
                    if (getIntent().hasExtra("source")) {
                        ed12.a("source", getIntent().getStringExtra("source"));
                    }
                    if (getIntent().hasExtra("src")) {
                        ca1 ca14 = this.l;
                        if (ca14 != null) {
                            ed12.a("pass type", ca14.e);
                        } else {
                            n86.l("viewModel");
                            throw null;
                        }
                    }
                    hj1.J0(ed12, "isSuperPass", Boolean.TRUE, ed12);
                    return;
                }
                n86.l("viewModel");
                throw null;
            }
            n86.l("viewModel");
            throw null;
        }
        n86.l("viewModel");
        throw null;
    }

    @Override // defpackage.ol0
    public void i0() {
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
    }

    @Override // defpackage.ol0
    public void k0() {
        Snackbar snackbar = this.i;
        if (snackbar != null) {
            snackbar.b(3);
        }
    }

    @Override // defpackage.ol0
    public void m0() {
        jz5.b().o(this);
    }

    @Override // defpackage.tl0
    public void o0() {
        String stringExtra = getIntent().getStringExtra("src");
        String stringExtra2 = getIntent().getStringExtra("productId");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        ca1 ca1 = (ca1) new ai(z86.a(ca1.class), new a(this), new b(this, hj1.c("keyProductId", stringExtra2, "keySrc", stringExtra))).getValue();
        this.l = ca1;
        if (ca1 == null) {
            n86.l("viewModel");
            throw null;
        } else if (!ca1.h) {
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.xl0
    public void onBackPressed() {
        if (y0()) {
            x0();
        } else if (isTaskRoot()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public final void onEvent(qd1 qd1) {
        n86.e(qd1, "event");
    }

    @Override // defpackage.xl0
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        n86.e(menuItem, "lItem");
        onBackPressed();
        return true;
    }

    @Override // defpackage.tl0
    public void p0() {
        ((fw) f0()).l.setOnClickListener(new h70(this));
    }

    @Override // defpackage.tl0
    public void q0() {
    }

    @Override // defpackage.tl0
    public void r0() {
        if (y0()) {
            x0();
        } else {
            w0();
        }
    }

    public final void s0(boolean z) {
        if (z) {
            setSupportActionBar(((fw) f0()).q);
            ((fw) f0()).q.setVisibility(0);
            ((fw) f0()).k.setVisibility(8);
        } else {
            setSupportActionBar(((fw) f0()).k);
            ((fw) f0()).k.setVisibility(0);
            ((fw) f0()).q.setVisibility(8);
        }
        x supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.o(true);
        }
        x supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            ca1 ca1 = this.l;
            if (ca1 != null) {
                supportActionBar2.z(ca1.d().getProductName());
            } else {
                n86.l("viewModel");
                throw null;
            }
        }
        x supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.t(R.drawable.abc_ic_ab_back_material);
        }
    }

    public final void u0(TextView textView, int i, int i2) {
        textView.setBackgroundResource(i2);
        textView.setTextColor(i);
        textView.setPadding((int) ui1.n(16.0f, this), (int) ui1.n(10.0f, this), (int) ui1.n(16.0f, this), (int) ui1.n(10.0f, this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v0(boolean r7, app.zophop.models.mTicketing.ProductCategory r8, app.zophop.models.mTicketing.ProductSubCategory r9) {
        /*
        // Method dump skipped, instructions count: 353
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.products.PassSelectionActivity.v0(boolean, app.zophop.models.mTicketing.ProductCategory, app.zophop.models.mTicketing.ProductSubCategory):void");
    }

    public final void w0() {
        this.m = false;
        ((fw) f0()).j.setVisibility(0);
        ((fw) f0()).o.setVisibility(8);
        s0(false);
        ((fw) f0()).e.removeAllViews();
        ca1 ca1 = this.l;
        if (ca1 != null) {
            Map<String, ? extends ProductCategory> map = ca1.j;
            if (map != null) {
                int size = map.size();
                int i = 0;
                boolean z = false;
                for (Map.Entry<String, ? extends ProductCategory> entry : map.entrySet()) {
                    ProductCategory productCategory = (ProductCategory) entry.getValue();
                    if (i == size - 1) {
                        z = true;
                    }
                    String str = productCategory.get_categoryName();
                    String categoryId = productCategory.getCategoryId();
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(0, 0, (int) ui1.n(12.0f, this), 0);
                    TextView textView = new TextView(this);
                    textView.setText(str);
                    textView.setTextSize(14.0f);
                    textView.setTypeface(Typeface.createFromAsset(getResources().getAssets(), "fonts/NotoSans-SemiBold.ttf"));
                    textView.setBackgroundResource(R.drawable.grey_capsule);
                    textView.setTextColor(getResources().getColor(R.color.black));
                    if (z) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(0, 0, (int) ui1.n(24.0f, this), 0);
                        textView.setLayoutParams(layoutParams2);
                    } else {
                        textView.setLayoutParams(layoutParams);
                    }
                    textView.setPadding((int) ui1.n(16.0f, this), (int) ui1.n(10.0f, this), (int) ui1.n(16.0f, this), (int) ui1.n(10.0f, this));
                    textView.setTag(categoryId);
                    textView.setOnClickListener(new f70(this, textView, productCategory));
                    ((fw) f0()).e.addView(textView);
                    i++;
                }
                if (((fw) f0()).e.getChildCount() > 0) {
                    ((fw) f0()).e.getChildAt(0).callOnClick();
                }
                if (((fw) f0()).e.getChildCount() <= 1) {
                    ((fw) f0()).e.setVisibility(8);
                } else {
                    ((fw) f0()).e.setVisibility(0);
                }
            } else {
                n86.l("sortedCategoryIdCategoryMap");
                throw null;
            }
        } else {
            n86.l("viewModel");
            throw null;
        }
    }

    public final void x0() {
        ((fw) f0()).o.setVisibility(0);
        ((fw) f0()).j.setVisibility(8);
        s0(true);
        ca1 ca1 = this.l;
        if (ca1 != null) {
            SubCategorySelectionDetails subCategorySelectionDetails = ca1.d().getSubCategorySelectionDetails();
            String str = subCategorySelectionDetails == null ? null : subCategorySelectionDetails.get_title();
            ca1 ca12 = this.l;
            if (ca12 != null) {
                SubCategorySelectionDetails subCategorySelectionDetails2 = ca12.d().getSubCategorySelectionDetails();
                String str2 = subCategorySelectionDetails2 == null ? null : subCategorySelectionDetails2.get_description();
                ((fw) f0()).p.setText(str);
                ((fw) f0()).m.setText(str2);
                GridView gridView = ((fw) f0()).n;
                n86.d(gridView, "viewBinding.subCategorySelectionGridView");
                ca1 ca13 = this.l;
                if (ca13 != null) {
                    qu quVar = new qu(this, ca13.g());
                    ed1 ed1 = new ed1("subCategory selection screen opened", Long.MIN_VALUE);
                    ca1 ca14 = this.l;
                    if (ca14 != null) {
                        ed1.a("configId", ca14.d().getProductId());
                        hj1.J0(ed1, "isSuperPass", Boolean.TRUE, ed1);
                        gridView.setAdapter((ListAdapter) quVar);
                        gridView.setOnItemClickListener(new j70(this, quVar));
                        return;
                    }
                    n86.l("viewModel");
                    throw null;
                }
                n86.l("viewModel");
                throw null;
            }
            n86.l("viewModel");
            throw null;
        }
        n86.l("viewModel");
        throw null;
    }

    public final boolean y0() {
        if (this.m) {
            return false;
        }
        ca1 ca1 = this.l;
        if (ca1 == null) {
            n86.l("viewModel");
            throw null;
        } else if (ca1.g().isEmpty()) {
            return false;
        } else {
            this.m = true;
            return true;
        }
    }

    public final void z0() {
        ca1 ca1 = this.l;
        if (ca1 != null) {
            BookableSuperPassConfiguration f = ca1.f();
            if (f != null) {
                n86.e(this, "lContext");
                n86.e("sourceSuperPassSelectionActivity", "lSource");
                n86.e(f, "lBookableSuperPassConfiguration");
                Intent intent = new Intent(this, SuperPassPurchaseActivity.class);
                intent.putExtra("arg_source", "sourceSuperPassSelectionActivity");
                intent.putExtra("arg_purchase_flow_type", "flowFreshPurchase");
                intent.putExtra("arg_isVerificationRequired", f.isVerificationRequired());
                intent.putExtra("arg_bookable_super_pass_config", BookableSuperPassConfiguration.Companion.convertBookableSuperPassConfigToString(f));
                startActivity(intent);
                return;
            }
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
