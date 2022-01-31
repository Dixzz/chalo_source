package app.zophop.ui.activities.cardRecharge;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.mTicketing.UserProfile;
import defpackage.xt;
import java.util.HashMap;

/* compiled from: OnlineCardRechargeSummaryActivity.kt */
public final class OnlineCardRechargeSummaryActivity extends tl0<ew> {
    public static final /* synthetic */ int l = 0;
    public q91 k;

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

    /* compiled from: OnlineCardRechargeSummaryActivity.kt */
    public static final class b extends o86 implements h76<ci> {
        public final /* synthetic */ OnlineCardRechargeSummaryActivity f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(OnlineCardRechargeSummaryActivity onlineCardRechargeSummaryActivity, String str, String str2) {
            super(0);
            this.f = onlineCardRechargeSummaryActivity;
            this.g = str;
            this.h = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new xh(this.f.getApplication(), this.f, h.j(new m56("keySource", this.g), new m56("keySuperPassId", this.h)));
        }
    }

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_online_card_recharge_summary, (ViewGroup) null, false);
        int i = R.id.booking_date;
        TextView textView = (TextView) inflate.findViewById(R.id.booking_date);
        if (textView != null) {
            i = R.id.booking_id;
            TextView textView2 = (TextView) inflate.findViewById(R.id.booking_id);
            if (textView2 != null) {
                i = R.id.btn_expand_fare_split;
                ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_expand_fare_split);
                if (imageView != null) {
                    i = R.id.card_number;
                    TextView textView3 = (TextView) inflate.findViewById(R.id.card_number);
                    if (textView3 != null) {
                        i = R.id.fare_details_layout;
                        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.fare_details_layout);
                        if (linearLayout != null) {
                            i = R.id.fare_split_layout;
                            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.fare_split_layout);
                            if (linearLayout2 != null) {
                                i = R.id.fare_split_title;
                                LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.fare_split_title);
                                if (linearLayout3 != null) {
                                    i = R.id.payment_mode;
                                    TextView textView4 = (TextView) inflate.findViewById(R.id.payment_mode);
                                    if (textView4 != null) {
                                        i = R.id.recharge_amount_info;
                                        TextView textView5 = (TextView) inflate.findViewById(R.id.recharge_amount_info);
                                        if (textView5 != null) {
                                            i = R.id.recharge_info;
                                            TextView textView6 = (TextView) inflate.findViewById(R.id.recharge_info);
                                            if (textView6 != null) {
                                                i = R.id.recharge_status_image;
                                                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.recharge_status_image);
                                                if (imageView2 != null) {
                                                    i = R.id.recharge_status_text;
                                                    TextView textView7 = (TextView) inflate.findViewById(R.id.recharge_status_text);
                                                    if (textView7 != null) {
                                                        i = R.id.toolbar;
                                                        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
                                                        if (toolbar != null) {
                                                            i = R.id.total_amount_text;
                                                            TextView textView8 = (TextView) inflate.findViewById(R.id.total_amount_text);
                                                            if (textView8 != null) {
                                                                i = R.id.total_fare;
                                                                LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.total_fare);
                                                                if (linearLayout4 != null) {
                                                                    i = R.id.transaction_details_layout;
                                                                    CardView cardView = (CardView) inflate.findViewById(R.id.transaction_details_layout);
                                                                    if (cardView != null) {
                                                                        ew ewVar = new ew((ConstraintLayout) inflate, textView, textView2, imageView, textView3, linearLayout, linearLayout2, linearLayout3, textView4, textView5, textView6, imageView2, textView7, toolbar, textView8, linearLayout4, cardView);
                                                                        n86.d(ewVar, "inflate(layoutInflater)");
                                                                        return ewVar;
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

    @Override // defpackage.ol0
    public void i0() {
    }

    @Override // defpackage.ol0
    public void m0() {
    }

    @Override // defpackage.tl0
    public void o0() {
        this.k = (q91) new ai(z86.a(q91.class), new a(this), new b(this, getIntent().getStringExtra("arg_source"), getIntent().getStringExtra("arg_transactionId"))).getValue();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_problem_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        n86.e(menuItem, "item");
        if (menuItem.getItemId() != R.id.report_problem_menu) {
            return false;
        }
        xt.t1 t1Var = xt.f3961a;
        y20 R = t1Var.R();
        HashMap hashMap = new HashMap();
        City d = t1Var.k().d();
        n86.c(d);
        String name = d.getName();
        n86.d(name, "DependencyFactory.cityProvider.currentCity!!.name");
        hashMap.put("userPropertyCity", name);
        UserProfile e = t1Var.L().e();
        if (e != null) {
            String fullName = e.getFullName();
            n86.d(fullName, "it.fullName");
            hashMap.put("userPropertyUserName", fullName);
            String phone = e.getPhone();
            n86.d(phone, "it.phone");
            hashMap.put("userPropertyPhoneNo", phone);
            String userId = e.getUserId();
            n86.d(userId, "it.userId");
            hashMap.put("userPropertyUserID", userId);
        }
        R.b(this, "cardRelatedProblems", "cardRechargeHistoryActivity", hashMap, false);
        ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "cardRelatedProblems");
        l2.a("problemSource", "cardRechargeSummaryActivity");
        q91 q91 = this.k;
        if (q91 != null) {
            l2.a("cardTransactionId", q91.e);
            ui1.m0(l2);
            return true;
        }
        n86.l("viewModel");
        throw null;
    }

    @Override // defpackage.tl0
    public void p0() {
    }

    @Override // defpackage.tl0
    public void q0() {
        q91 q91 = this.k;
        if (q91 != null) {
            q91.g.f(this, new fi0(this));
            q91 q912 = this.k;
            if (q912 != null) {
                Object value = q912.h.getValue();
                n86.d(value, "<get-isFareLayoutExpanded>(...)");
                ((LiveData) value).f(this, new ei0(this));
                return;
            }
            n86.l("viewModel");
            throw null;
        }
        n86.l("viewModel");
        throw null;
    }

    @Override // defpackage.tl0
    public void r0() {
        Toolbar toolbar = ((ew) f0()).m;
        n86.d(toolbar, "viewBinding.toolbar");
        setSupportActionBar(toolbar);
        x supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.o(true);
        }
        x supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.t(R.drawable.ic_arrow_back_black_24dp);
        }
    }
}
