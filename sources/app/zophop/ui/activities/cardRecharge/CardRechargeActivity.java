package app.zophop.ui.activities.cardRecharge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.pubsub.eventbus.events.CardRechargeTransactionsFetchedEvent;
import app.zophop.ui.activities.UserProfileActivity;
import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;
import app.zophop.ui.fragments.cardRecharge.CardRechargeAmountFragment;
import app.zophop.ui.fragments.cardRecharge.CardRechargeConfirmPaymentFragment;
import app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel;
import defpackage.xt;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* compiled from: CardRechargeActivity.kt */
public final class CardRechargeActivity extends wl0<yv> {
    public static final /* synthetic */ int o = 0;
    public CardRechargeActivitySharedViewModel m;
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

    /* compiled from: CardRechargeActivity.kt */
    public static final class b extends o86 implements h76<ci> {
        public final /* synthetic */ CardRechargeActivity f;
        public final /* synthetic */ Bundle g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CardRechargeActivity cardRechargeActivity, Bundle bundle) {
            super(0);
            this.f = cardRechargeActivity;
            this.g = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new xh(this.f.getApplication(), this.f, this.g);
        }
    }

    public CardRechargeActivity() {
        r<Intent> registerForActivityResult = registerForActivityResult(new w(), new uh0(this));
        n86.d(registerForActivityResult, "registerForActivityResul…Pressed()\n        }\n    }");
        this.n = registerForActivityResult;
    }

    public static final void s0(String str, Context context) {
        n86.e(str, "lSource");
        n86.e(context, "lContext");
        Intent intent = new Intent(context, CardRechargeActivity.class);
        intent.putExtra("arg_source", str);
        context.startActivity(intent);
    }

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_card_recharge, (ViewGroup) null, false);
        int i = R.id.card_recharge_nav_host_fragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) inflate.findViewById(R.id.card_recharge_nav_host_fragment);
        if (fragmentContainerView != null) {
            i = R.id.connection_error_layout;
            View findViewById = inflate.findViewById(R.id.connection_error_layout);
            if (findViewById != null) {
                yw b2 = yw.b(findViewById);
                i = R.id.connection_error_view;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.connection_error_view);
                if (linearLayout != null) {
                    i = R.id.skeleton_loader_layout;
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.skeleton_loader_layout);
                    if (linearLayout2 != null) {
                        i = R.id.toolbar;
                        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
                        if (toolbar != null) {
                            yv yvVar = new yv((ConstraintLayout) inflate, fragmentContainerView, b2, linearLayout, linearLayout2, toolbar);
                            n86.d(yvVar, "inflate(layoutInflater)");
                            return yvVar;
                        }
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

    @Override // defpackage.wl0
    public void o0() {
        String stringExtra = getIntent().getStringExtra("arg_source");
        Bundle bundle = new Bundle();
        bundle.putString("keySource", stringExtra);
        CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel = (CardRechargeActivitySharedViewModel) new ai(z86.a(CardRechargeActivitySharedViewModel.class), new a(this), new b(this, bundle)).getValue();
        this.m = cardRechargeActivitySharedViewModel;
        ed1 ed1 = new ed1("online card recharge activity open", Long.MIN_VALUE);
        if (cardRechargeActivitySharedViewModel != null) {
            ed1.a("source", cardRechargeActivitySharedViewModel.g);
            ui1.m0(ed1);
            if (xt.f3961a.L().m()) {
                u0(true);
                CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel2 = this.m;
                if (cardRechargeActivitySharedViewModel2 != null) {
                    cardRechargeActivitySharedViewModel2.d(this);
                } else {
                    n86.l("sharedViewModel");
                    throw null;
                }
            } else {
                u0(false);
                this.n.a(UserProfileActivity.h0(this), null);
            }
        } else {
            n86.l("sharedViewModel");
            throw null;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_problem_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public final void onEvent(CardRechargeTransactionsFetchedEvent cardRechargeTransactionsFetchedEvent) {
        n86.e(cardRechargeTransactionsFetchedEvent, "lEvent");
        jz5.b().m(cardRechargeTransactionsFetchedEvent);
        String requestId = cardRechargeTransactionsFetchedEvent.getRequestId();
        CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel = this.m;
        if (cardRechargeActivitySharedViewModel == null) {
            n86.l("sharedViewModel");
            throw null;
        } else if (n86.a(requestId, cardRechargeActivitySharedViewModel.m)) {
            if (cardRechargeTransactionsFetchedEvent.getResponseType() == ad1.SUCCESS) {
                t0(true);
                CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel2 = this.m;
                if (cardRechargeActivitySharedViewModel2 != null) {
                    Objects.requireNonNull(cardRechargeActivitySharedViewModel2);
                    n86.e(cardRechargeTransactionsFetchedEvent, "lEvent");
                    hd3.Y1(h.Z(cardRechargeActivitySharedViewModel2), cardRechargeActivitySharedViewModel2.e, null, new l91(cardRechargeActivitySharedViewModel2, cardRechargeTransactionsFetchedEvent, null), 2, null);
                    return;
                }
                n86.l("sharedViewModel");
                throw null;
            }
            t0(false);
            LinearLayout linearLayout = ((yv) f0()).c;
            n86.d(linearLayout, "viewBinding.connectionErrorView");
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = ((yv) f0()).d;
            n86.d(linearLayout2, "viewBinding.skeletonLoaderLayout");
            linearLayout2.setVisibility(8);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        FragmentManager childFragmentManager;
        List<Fragment> L;
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
        R.b(this, "cardRelatedProblems", "cardRechargeActivity", hashMap, false);
        ed1 l = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "cardRelatedProblems");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        n86.d(supportFragmentManager, "supportFragmentManager");
        n86.e(supportFragmentManager, "<this>");
        Fragment fragment = supportFragmentManager.t;
        Fragment fragment2 = null;
        if (!(fragment == null || (childFragmentManager = fragment.getChildFragmentManager()) == null || (L = childFragmentManager.L()) == null)) {
            fragment2 = (Fragment) y56.i(L);
        }
        if (fragment2 instanceof CardDetailsFragment) {
            l.a("problemSource", "cardDetailsFragment");
        } else if (fragment2 instanceof CardRechargeAmountFragment) {
            l.a("problemSource", "cardRechargeAmountFragment");
        } else if (fragment2 instanceof CardRechargeConfirmPaymentFragment) {
            l.a("problemSource", "cardRechargeConfirmPaymentFragment");
        } else {
            l.a("problemSource", "cardRechargeActivity");
        }
        ui1.m0(l);
        return true;
    }

    @Override // defpackage.wl0
    public void q0() {
        CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel = this.m;
        if (cardRechargeActivitySharedViewModel != null) {
            Object value = cardRechargeActivitySharedViewModel.k.getValue();
            n86.d(value, "<get-cardRechargeConfiguration>(...)");
            ((LiveData) value).f(this, new vh0(this));
            return;
        }
        n86.l("sharedViewModel");
        throw null;
    }

    @Override // defpackage.wl0
    public void r0() {
        ((yv) f0()).b.c.setText(getString(R.string.profile_fetch_please_try_again));
        ((yv) f0()).b.b.setOnClickListener(new wh0(this));
    }

    public final void t0(boolean z) {
        ed1 l = hj1.l("online card recharge activity open", Long.MIN_VALUE, "source", "sourceOnlineCardRechargeActivity");
        l.a("isSuccessful", Boolean.valueOf(z));
        ui1.m0(l);
    }

    public final void u0(boolean z) {
        ed1 ed1;
        if (z) {
            ed1 = new ed1("ocr user already logged in", Long.MIN_VALUE);
        } else {
            ed1 = new ed1("ocr redirecting to user login", Long.MIN_VALUE);
        }
        ed1.a("source", "sourceOnlineCardRechargeActivity");
        ui1.m0(ed1);
    }

    public final void onEvent(qd1 qd1) {
        n86.e(qd1, "networkConnectivityEvent");
        jz5.b().m(qd1);
        boolean z = qd1.f2931a;
        CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel = this.m;
        if (cardRechargeActivitySharedViewModel != null) {
            boolean z2 = cardRechargeActivitySharedViewModel.f;
            if (z != z2) {
                if (z) {
                    if (!cardRechargeActivitySharedViewModel.i) {
                        cardRechargeActivitySharedViewModel.e(this);
                    }
                    k0();
                } else {
                    l0(((yv) f0()).f4087a);
                }
                CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel2 = this.m;
                if (cardRechargeActivitySharedViewModel2 != null) {
                    cardRechargeActivitySharedViewModel2.f = z;
                } else {
                    n86.l("sharedViewModel");
                    throw null;
                }
            } else if (!z2) {
                l0(((yv) f0()).f4087a);
            }
        } else {
            n86.l("sharedViewModel");
            throw null;
        }
    }
}
