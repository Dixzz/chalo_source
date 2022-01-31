package app.zophop.ui.activities;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.Agency;
import app.zophop.models.City;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductConfigurationMap;
import app.zophop.models.mTicketing.ProductDisplayProps;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.pubsub.eventbus.events.ProductConfigurationFetchedEvent;
import butterknife.ButterKnife;
import butterknife.InjectView;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RenewMagicPassActivity extends fe0 {
    public static List<ProductFareMapping> v;
    @InjectView(R.id.dual_logo)
    public RelativeLayout _dualLogo;
    @InjectView(R.id.renew_pass_container)
    public LinearLayout _renewContainer;
    @InjectView(R.id.renew_proceed)
    public Button _renewProceed;
    @InjectView(R.id.single_logo)
    public ImageView _singleLogo;
    public MPass m;
    public String n;
    public final Calendar o = Calendar.getInstance();
    public final Calendar p = Calendar.getInstance();
    public final Calendar q = Calendar.getInstance();
    public long r;
    public long s;
    public String t;
    public List<ProductDisplayProps> u;

    public static void k0(RenewMagicPassActivity renewMagicPassActivity, String str, String str2, String str3, String str4) {
        FragmentManager fragmentManager = renewMagicPassActivity.getFragmentManager();
        an0 an0 = new an0();
        Bundle c = hj1.c("renew_title", str, "renew_subtitle", str2);
        c.putString("renew_cancel_btn", str3);
        c.putString("renew_buy_pass_btn", str4);
        an0.setArguments(c);
        an0.show(fragmentManager, "ReportFragmentTag");
    }

    public static void m0(Context context, MPass mPass, String str, List<ProductFareMapping> list) {
        Intent intent = new Intent(context, RenewMagicPassActivity.class);
        v = list;
        intent.putExtra("magic_pass_info", mPass);
        intent.putExtra("src", str);
        context.startActivity(intent);
    }

    @Override // defpackage.fe0
    public void init() {
        jz5 b = jz5.b();
        b.k(this, b.e, false, 0);
        this.t = UUID.randomUUID().toString();
        xt.t1 t1Var = xt.f3961a;
        t1Var.c().b(hj1.B(t1Var), this.t);
    }

    @Override // defpackage.fe0
    public void j0() {
        setContentView(R.layout.renew_magic_pass);
        ButterKnife.inject(this);
        this.m = (MPass) getIntent().getParcelableExtra("magic_pass_info");
        this.n = getIntent().getStringExtra("src");
        if (this.m.getExpiryTime() > ui1.Q()) {
            this.r = this.m.getExpiryTime() + 86400000;
        } else {
            this.r = ui1.Q();
        }
        this.s = this.r;
        this.p.setTimeInMillis(ui1.Q());
        this.q.setTimeInMillis(ui1.Q());
        this.o.setTimeInMillis(ui1.Q());
        setSupportActionBar((Toolbar) findViewById(R.id.activity_renew_pass_toolbar));
        getSupportActionBar().o(true);
        xt.t1 t1Var = xt.f3961a;
        getSupportActionBar().z(new SpannableStringBuilder(t1Var.c().F(this.m.getPassengerType())).append((CharSequence) ui1.J(this, this.m.getSpecialFeatures())).append((CharSequence) " Pass"));
        City d = t1Var.k().d();
        String s2 = ui1.s(d);
        for (Agency agency : d.getModeAgencyMap().get(TransitMode.bus)) {
            if (agency.getAgencyName().equalsIgnoreCase(s2)) {
                agency.getMagicPassInfos();
            }
        }
        new ArrayList();
        HashMap hashMap = new HashMap();
        this._renewProceed.setOnClickListener(new ef0(this));
        this._renewContainer.removeAllViews();
        String passengerType = this.m.getPassengerType();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(ui1.Q());
        Date time = instance.getTime();
        LinearLayout linearLayout = this._renewContainer;
        qa1 qa1 = new qa1(this);
        qa1.setHeaderText(getResources().getString(R.string.select_pass_start_date));
        linearLayout.addView(qa1);
        ra1 ra1 = new ra1(this);
        time.getTime();
        ra1.setPassDate(jh1.d(this.r));
        this.m.setStartingTime(this.r);
        ra1.setDateEditListner(new hf0(this, ra1));
        this._renewContainer.addView(ra1);
        LinearLayout linearLayout2 = this._renewContainer;
        qa1 qa12 = new qa1(this);
        qa12.setHeaderText(getResources().getString(R.string.select_pass));
        linearLayout2.addView(qa12);
        String str = this.n;
        if (str == null || !str.equals("product_selection_recent_products")) {
            List<ProductConfiguration> j0 = xt.f3961a.c().j0(this.m.getAgency());
            for (int i = 0; i < j0.size(); i++) {
                ProductConfiguration productConfiguration = j0.get(i);
                ProductCategory k0 = vn.k0(productConfiguration.getProductCategoryList(), passengerType);
                if (productConfiguration.getProductId().equalsIgnoreCase(this.m.getConfigId()) && k0 != null && k0.isCategoryIsRenewable() && !productConfiguration.getProductType().equals("routePass")) {
                    List<ProductFareMapping> list = productConfiguration.getProductFareMapping().get(k0.getCategoryId());
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        hashMap.put(Long.valueOf(list.get(i2).getDurationId()), productConfiguration.getProductId());
                    }
                }
            }
            if (hashMap.size() == 0) {
                n0(passengerType);
            } else {
                LinkedList<Map.Entry> linkedList = new LinkedList(hashMap.entrySet());
                Collections.sort(linkedList, new gf0(this));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : linkedList) {
                    linkedHashMap.put((Long) entry.getKey(), (String) entry.getValue());
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    l0(passengerType, (String) entry2.getValue(), new sa1(this), ((Long) entry2.getKey()).longValue(), false, true);
                }
            }
        } else {
            n0(passengerType);
        }
        ed1 ed1 = new ed1("pass renew screen open", Long.MIN_VALUE);
        if (getIntent().hasExtra("src")) {
            ed1.a("src", getIntent().getStringExtra("src"));
        }
        jz5.b().g(ed1);
        ImageView imageView = this._singleLogo;
        RelativeLayout relativeLayout = this._dualLogo;
        String B = hj1.B(xt.f3961a);
        TextView textView = (TextView) findViewById(R.id.agency_text_id);
        if (!vn.Y0(this.m.getConfigId())) {
            imageView.setVisibility(8);
            relativeLayout.setVisibility(8);
            textView.setVisibility(8);
        } else if (B.equalsIgnoreCase("indore")) {
            imageView.setImageResource(R.drawable.aictsl_logo_grey);
            imageView.setVisibility(0);
            relativeLayout.setVisibility(8);
        } else if (B.equalsIgnoreCase("jabalpur")) {
            ((ImageView) relativeLayout.findViewById(R.id.left_logo)).setImageResource(R.drawable.jabalpur_logo_1);
            ((ImageView) relativeLayout.findViewById(R.id.right_logo)).setImageResource(R.drawable.jabalpur_logo_2);
            imageView.setVisibility(8);
            relativeLayout.setVisibility(0);
        } else if (B.equalsIgnoreCase("bhopal")) {
            ((ImageView) relativeLayout.findViewById(R.id.left_logo)).setImageResource(R.drawable.bhopal_logo_1);
            ((ImageView) relativeLayout.findViewById(R.id.right_logo)).setImageResource(R.drawable.bhopal_logo_2);
            imageView.setVisibility(8);
            relativeLayout.setVisibility(0);
        } else {
            imageView.setVisibility(8);
            relativeLayout.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(((Object) textView.getText()) + " " + this.m.getAgency().toUpperCase());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0143  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l0(java.lang.String r17, java.lang.String r18, defpackage.sa1 r19, long r20, boolean r22, boolean r23) {
        /*
        // Method dump skipped, instructions count: 341
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.RenewMagicPassActivity.l0(java.lang.String, java.lang.String, sa1, long, boolean, boolean):void");
    }

    public final void n0(String str) {
        ProductCategory k0;
        ProductConfiguration m0 = vn.m0(this.m.getConfigId());
        if (m0 != null && (k0 = vn.k0(m0.getProductCategoryList(), str)) != null) {
            if (v != null) {
                l0(str, this.m.getConfigId(), new sa1(this), ((long) this.m.getNoOfDays()) * 86400000, true, k0.isCategoryIsRenewable());
            } else {
                l0(str, this.m.getConfigId(), new sa1(this), ((long) this.m.getNoOfDays()) * 86400000, false, k0.isCategoryIsRenewable());
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
        v = null;
    }

    public void onEvent(ProductConfigurationFetchedEvent productConfigurationFetchedEvent) {
        jz5.b().m(productConfigurationFetchedEvent);
        ed1 ed1 = new ed1("configuration fetched", Long.MIN_VALUE);
        if (productConfigurationFetchedEvent.getResponseType() == null) {
            ed1.a("response", String.valueOf(true));
            h0();
            return;
        }
        String str = this.t;
        if (str != null && str.equals(productConfigurationFetchedEvent.getConfigRequestId())) {
            if (productConfigurationFetchedEvent.getResponseType().equals(ad1.SUCCESS)) {
                ed1.a("response", String.valueOf(true));
                ProductConfigurationMap productConfigMap = productConfigurationFetchedEvent.getProductConfigMap();
                this.u = productConfigurationFetchedEvent.getProductDisplayPropsList();
                HashMap hashMap = new HashMap();
                for (int i = 0; i < this.u.size(); i++) {
                    hashMap.put(this.u.get(i).getProductCategoryId(), this.u.get(i).getProductCategoryName());
                }
                if (productConfigMap != null) {
                    i0();
                } else {
                    ed1.a("response", String.valueOf(false));
                    h0();
                }
            } else {
                ed1.a("response", String.valueOf(true));
                h0();
            }
            jz5.b().g(ed1);
            this.t = null;
        }
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }
}
