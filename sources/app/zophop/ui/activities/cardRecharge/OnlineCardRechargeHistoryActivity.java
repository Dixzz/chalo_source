package app.zophop.ui.activities.cardRecharge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import app.zophop.pubsub.eventbus.events.CardRechargeTransactionsFetchedEvent;
import com.google.android.material.textview.MaterialTextView;
import defpackage.xt;
import java.util.HashMap;
import java.util.List;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: OnlineCardRechargeHistoryActivity.kt */
public final class OnlineCardRechargeHistoryActivity extends tl0<dw> {
    public static final /* synthetic */ int o = 0;
    public p91 k;
    public rc6 l;
    public final j56 m = hd3.a2(new d(this));
    public final r<Intent> n;

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

    /* compiled from: OnlineCardRechargeHistoryActivity.kt */
    public static final class b extends o86 implements h76<ci> {
        public final /* synthetic */ OnlineCardRechargeHistoryActivity f;
        public final /* synthetic */ Bundle g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity, Bundle bundle) {
            super(0);
            this.f = onlineCardRechargeHistoryActivity;
            this.g = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new xh(this.f.getApplication(), this.f, this.g);
        }
    }

    @y66(c = "app.zophop.ui.activities.cardRecharge.OnlineCardRechargeHistoryActivity$initSkeletonLayoutTimeoutAndUpdateEmptyView$1", f = "OnlineCardRechargeHistoryActivity.kt", l = {147}, m = "invokeSuspend")
    /* compiled from: OnlineCardRechargeHistoryActivity.kt */
    public static final class c extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ OnlineCardRechargeHistoryActivity g;

        @y66(c = "app.zophop.ui.activities.cardRecharge.OnlineCardRechargeHistoryActivity$initSkeletonLayoutTimeoutAndUpdateEmptyView$1$1", f = "OnlineCardRechargeHistoryActivity.kt", l = {148}, m = "invokeSuspend")
        /* compiled from: OnlineCardRechargeHistoryActivity.kt */
        public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
            public int f;

            public a(k66<? super a> k66) {
                super(2, k66);
            }

            @Override // defpackage.u66
            public final k66<s56> create(Object obj, k66<?> k66) {
                return new a(k66);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // defpackage.w76
            public Object invoke(mb6 mb6, k66<? super s56> k66) {
                return new a(k66).invokeSuspend(s56.f3190a);
            }

            @Override // defpackage.u66
            public final Object invokeSuspend(Object obj) {
                p66 p66 = p66.COROUTINE_SUSPENDED;
                int i = this.f;
                if (i == 0) {
                    hd3.Y2(obj);
                    this.f = 1;
                    if (hd3.C0(2000, this) == p66) {
                        return p66;
                    }
                } else if (i == 1) {
                    hd3.Y2(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return s56.f3190a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity, k66<? super c> k66) {
            super(2, k66);
            this.g = onlineCardRechargeHistoryActivity;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new c(this.g, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new c(this.g, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                kb6 kb6 = xb6.b;
                a aVar = new a(null);
                this.f = 1;
                if (hd3.j3(kb6, aVar, this) == p66) {
                    return p66;
                }
            } else if (i == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity = this.g;
            int i2 = OnlineCardRechargeHistoryActivity.o;
            onlineCardRechargeHistoryActivity.x0();
            return s56.f3190a;
        }
    }

    /* compiled from: OnlineCardRechargeHistoryActivity.kt */
    public static final class d extends o86 implements h76<yu> {
        public final /* synthetic */ OnlineCardRechargeHistoryActivity f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity) {
            super(0);
            this.f = onlineCardRechargeHistoryActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public yu invoke() {
            OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity = this.f;
            return new yu(onlineCardRechargeHistoryActivity, true, new gi0(onlineCardRechargeHistoryActivity));
        }
    }

    public OnlineCardRechargeHistoryActivity() {
        r<Intent> registerForActivityResult = registerForActivityResult(new w(), new ai0(this));
        n86.d(registerForActivityResult, "registerForActivityResul…}\n            }\n        }");
        this.n = registerForActivityResult;
    }

    public static final void u0(String str, Context context) {
        n86.e(str, "lSource");
        n86.e(context, "lContext");
        Intent intent = new Intent(context, OnlineCardRechargeHistoryActivity.class);
        intent.putExtra("arg_source", str);
        context.startActivity(intent);
    }

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_online_card_recharge_history, (ViewGroup) null, false);
        int i = R.id.card_payments_history_recycler_view;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.card_payments_history_recycler_view);
        if (recyclerView != null) {
            i = R.id.connection_error_layout;
            View findViewById = inflate.findViewById(R.id.connection_error_layout);
            if (findViewById != null) {
                yw b2 = yw.b(findViewById);
                i = R.id.connection_error_view;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.connection_error_view);
                if (linearLayout != null) {
                    i = R.id.empty_view;
                    View findViewById2 = inflate.findViewById(R.id.empty_view);
                    if (findViewById2 != null) {
                        int i2 = R.id.btn_recharge;
                        MaterialTextView materialTextView = (MaterialTextView) findViewById2.findViewById(R.id.btn_recharge);
                        if (materialTextView != null) {
                            i2 = R.id.empty_my_bookings;
                            ImageView imageView = (ImageView) findViewById2.findViewById(R.id.empty_my_bookings);
                            if (imageView != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) findViewById2;
                                i2 = R.id.empty_view_description_text;
                                MaterialTextView materialTextView2 = (MaterialTextView) findViewById2.findViewById(R.id.empty_view_description_text);
                                if (materialTextView2 != null) {
                                    i2 = R.id.empty_view_title;
                                    MaterialTextView materialTextView3 = (MaterialTextView) findViewById2.findViewById(R.id.empty_view_title);
                                    if (materialTextView3 != null) {
                                        sw swVar = new sw(constraintLayout, materialTextView, imageView, constraintLayout, materialTextView2, materialTextView3);
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate;
                                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.skeleton_loader_layout);
                                        if (linearLayout2 != null) {
                                            Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
                                            if (toolbar != null) {
                                                dw dwVar = new dw(constraintLayout2, recyclerView, b2, linearLayout, swVar, constraintLayout2, linearLayout2, toolbar);
                                                n86.d(dwVar, "inflate(layoutInflater)");
                                                return dwVar;
                                            }
                                            i = R.id.toolbar;
                                        } else {
                                            i = R.id.skeleton_loader_layout;
                                        }
                                    }
                                }
                            }
                        }
                        throw new NullPointerException("Missing required view with ID: ".concat(findViewById2.getResources().getResourceName(i2)));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.ol0
    public void i0() {
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.ol0
    public void m0() {
        jz5.b().o(this);
    }

    @Override // defpackage.tl0
    public void o0() {
        String stringExtra = getIntent().getStringExtra("arg_source");
        Bundle bundle = new Bundle();
        bundle.putString("keySource", stringExtra);
        p91 p91 = (p91) new ai(z86.a(p91.class), new a(this), new b(this, bundle)).getValue();
        n86.e(p91, "<set-?>");
        this.k = p91;
        ed1 ed1 = new ed1("ocr history activity open", Long.MIN_VALUE);
        ed1.a("source", s0().e);
        ui1.m0(ed1);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_problem_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public final void onEvent(CardRechargeTransactionsFetchedEvent cardRechargeTransactionsFetchedEvent) {
        n86.e(cardRechargeTransactionsFetchedEvent, "lCardRechargeTransactionsFetchedEvent");
        jz5.b().m(cardRechargeTransactionsFetchedEvent);
        if (n86.a(cardRechargeTransactionsFetchedEvent.getRequestId(), s0().i)) {
            if (cardRechargeTransactionsFetchedEvent.getResponseType() == ad1.SUCCESS) {
                w0(true);
                p91 s0 = s0();
                n86.e(cardRechargeTransactionsFetchedEvent, "lEvent");
                s0.h = true;
                s0.d.b("keyIsCardRechargeHistoryFetched", Boolean.TRUE);
                rc6 rc6 = this.l;
                if (rc6 != null) {
                    ec6.j(rc6, null, 1, null);
                }
                x0();
                return;
            }
            w0(false);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        n86.e(menuItem, "item");
        if (menuItem.getItemId() != R.id.report_problem_menu) {
            return false;
        }
        xt.t1 t1Var = xt.f3961a;
        y20 R = t1Var.R();
        HashMap hashMap = new HashMap();
        City d2 = t1Var.k().d();
        n86.c(d2);
        String name = d2.getName();
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
        l2.a("problemSource", "cardRechargeHistoryActivity");
        ui1.m0(l2);
        return true;
    }

    @Override // defpackage.tl0
    public void p0() {
    }

    @Override // defpackage.tl0
    public void q0() {
        s0().g.f(this, new zh0(this));
    }

    @Override // defpackage.tl0
    public void r0() {
        Toolbar toolbar = ((dw) f0()).e;
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
        ((dw) f0()).b.setAdapter((yu) this.m.getValue());
        t0();
    }

    public final p91 s0() {
        p91 p91 = this.k;
        if (p91 != null) {
            return p91;
        }
        n86.l("viewModel");
        throw null;
    }

    public final void t0() {
        if (xt.f3961a.L().m()) {
            s0().d(this);
            ConstraintLayout constraintLayout = ((dw) f0()).c.c;
            n86.d(constraintLayout, "viewBinding.emptyView.emptyViewContainer");
            constraintLayout.setVisibility(8);
            LinearLayout linearLayout = ((dw) f0()).d;
            n86.d(linearLayout, "viewBinding.skeletonLoaderLayout");
            linearLayout.setVisibility(0);
            rc6 rc6 = this.l;
            if (rc6 != null) {
                ec6.j(rc6, null, 1, null);
            }
            ah b2 = wg.b(this);
            xb6 xb6 = xb6.f3911a;
            ad6 ad6 = xf6.c;
            int i = CoroutineExceptionHandler.d;
            this.l = hd3.Y1(b2, ad6.plus(new lh1(CoroutineExceptionHandler.a.f)), null, new c(this, null), 2, null);
            return;
        }
        x0();
    }

    public final void v0() {
        List<OnlineCardRecharge> d2 = s0().g.d();
        if (d2 == null ? true : d2.isEmpty()) {
            t0();
        }
        s0().d(this);
    }

    public final void w0(boolean z) {
        ed1 l2 = hj1.l("online card recharge activity open", Long.MIN_VALUE, "source", "sourceCardRechargeHistoryActivity");
        l2.a("isSuccessful", Boolean.valueOf(z));
        ui1.m0(l2);
    }

    public final void x0() {
        LinearLayout linearLayout = ((dw) f0()).d;
        n86.d(linearLayout, "viewBinding.skeletonLoaderLayout");
        linearLayout.setVisibility(8);
        List<OnlineCardRecharge> d2 = s0().g.d();
        if (!(d2 == null ? true : d2.isEmpty())) {
            ConstraintLayout constraintLayout = ((dw) f0()).c.c;
            n86.d(constraintLayout, "viewBinding.emptyView.emptyViewContainer");
            constraintLayout.setVisibility(8);
        } else if (!xt.f3961a.L().m()) {
            sw swVar = ((dw) f0()).c;
            ConstraintLayout constraintLayout2 = swVar.c;
            n86.d(constraintLayout2, "emptyViewContainer");
            constraintLayout2.setVisibility(0);
            swVar.d.setText(getString(R.string.card_recharge_login_banner));
            swVar.b.setText(getString(R.string.log_in));
            MaterialTextView materialTextView = swVar.b;
            n86.d(materialTextView, "btnRecharge");
            materialTextView.setVisibility(0);
            swVar.b.setOnClickListener(new xh0(this));
        } else {
            sw swVar2 = ((dw) f0()).c;
            ConstraintLayout constraintLayout3 = swVar2.c;
            n86.d(constraintLayout3, "emptyViewContainer");
            constraintLayout3.setVisibility(0);
            swVar2.d.setText(getString(R.string.no_recharges_copy));
            swVar2.b.setText(getString(R.string.recharge));
            MaterialTextView materialTextView2 = swVar2.b;
            n86.d(materialTextView2, "btnRecharge");
            materialTextView2.setVisibility(0);
            swVar2.b.setOnClickListener(new yh0(this));
        }
    }

    public final void onEvent(qd1 qd1) {
        n86.e(qd1, "networkConnectivityEvent");
        jz5.b().m(qd1);
        boolean z = qd1.f2931a;
        if (z != s0().f) {
            if (qd1.f2931a) {
                if (!s0().h) {
                    v0();
                }
                k0();
            } else {
                l0(((dw) f0()).f894a);
            }
            s0().f = z;
        } else if (!s0().f) {
            l0(((dw) f0()).f894a);
        }
    }
}
