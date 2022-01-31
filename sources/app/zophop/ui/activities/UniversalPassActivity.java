package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.universalPass.UniversalPassInfo;
import app.zophop.pubsub.eventbus.events.UniversalPassInfoFetchedEvent;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.utilities.external.loader_view.LoadingSpinnerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textview.MaterialTextView;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: UniversalPassActivity.kt */
public final class UniversalPassActivity extends ol0<kw> {
    public static final a m = new a(null);
    public final j56 k = new ai(z86.a(ha1.class), new c(this), new b(this));
    public final r<Intent> l;

    /* compiled from: UniversalPassActivity.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    public static final class b extends o86 implements h76<ci> {
        public final /* synthetic */ ComponentActivity f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
            super(0);
            this.f = componentActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return this.f.getDefaultViewModelProviderFactory();
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    public static final class c extends o86 implements h76<gi> {
        public final /* synthetic */ ComponentActivity f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
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

    public UniversalPassActivity() {
        r<Intent> registerForActivityResult = registerForActivityResult(new w(), new va0(this));
        n86.d(registerForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.l = registerForActivityResult;
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.ol0
    public kw g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_universal_pass, (ViewGroup) null, false);
        int i = R.id.empty_view;
        View findViewById = inflate.findViewById(R.id.empty_view);
        if (findViewById != null) {
            int i2 = R.id.btn_generate_universal_pass;
            MaterialTextView materialTextView = (MaterialTextView) findViewById.findViewById(R.id.btn_generate_universal_pass);
            if (materialTextView != null) {
                i2 = R.id.no_passes_found;
                MaterialTextView materialTextView2 = (MaterialTextView) findViewById.findViewById(R.id.no_passes_found);
                if (materialTextView2 != null) {
                    i2 = R.id.universal_pass_empty_icon;
                    ImageView imageView = (ImageView) findViewById.findViewById(R.id.universal_pass_empty_icon);
                    if (imageView != null) {
                        mz mzVar = new mz((ConstraintLayout) findViewById, materialTextView, materialTextView2, imageView);
                        i = R.id.loading_screen;
                        View findViewById2 = inflate.findViewById(R.id.loading_screen);
                        if (findViewById2 != null) {
                            ky b2 = ky.b(findViewById2);
                            i = R.id.toolbar;
                            MaterialToolbar materialToolbar = (MaterialToolbar) inflate.findViewById(R.id.toolbar);
                            if (materialToolbar != null) {
                                i = R.id.uni_pass_list;
                                RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.uni_pass_list);
                                if (recyclerView != null) {
                                    kw kwVar = new kw((ConstraintLayout) inflate, mzVar, b2, materialToolbar, recyclerView);
                                    n86.d(kwVar, "inflate(layoutInflater)");
                                    return kwVar;
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(findViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.ol0
    public void h0(Bundle bundle) {
        RecyclerView recyclerView = ((kw) f0()).e;
        n86.d(recyclerView, "viewBinding.uniPassList");
        recyclerView.setVisibility(8);
        ConstraintLayout constraintLayout = ((kw) f0()).b.f2462a;
        n86.d(constraintLayout, "viewBinding.emptyView.root");
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = ((kw) f0()).c.f2134a;
        n86.d(constraintLayout2, "viewBinding.loadingScreen.root");
        constraintLayout2.setVisibility(8);
        ((kw) f0()).d.setTitle(getString(R.string.universal_passes_toolbar_heading));
        if (xt.f3961a.L().m()) {
            o0();
        } else {
            q0();
            this.l.a(UserProfileActivity.h0(this), null);
        }
        ((kw) f0()).c.e.setOnClickListener(new xa0(this));
        ((kw) f0()).d.setNavigationOnClickListener(new wa0(this));
        ((kw) f0()).b.b.setOnClickListener(new ua0(this));
        String stringExtra = getIntent().getStringExtra("source");
        if (stringExtra != null) {
            hj1.R0("universal pass activity opened", "lName", stringExtra, "lSource", "universal pass activity opened", Long.MIN_VALUE, "source", stringExtra);
        }
    }

    @Override // defpackage.ol0
    public void i0() {
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.ol0
    public void j0() {
        registerReceiver(e0(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // defpackage.ol0
    public void m0() {
        jz5.b().o(this);
    }

    @Override // defpackage.ol0
    public void n0() {
        unregisterReceiver(e0());
    }

    public final void o0() {
        xt.t1 t1Var = xt.f3961a;
        if (xt.x0.getValue().a()) {
            r0();
            return;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        n86.d(supportFragmentManager, "supportFragmentManager");
        String string = getString(R.string.universal_pass_permission_title);
        n86.d(string, "getString(R.string.unive…al_pass_permission_title)");
        String e0 = hj1.e0(new Object[]{t1Var.L().getUserId()}, 1, string, "java.lang.String.format(format, *args)");
        String string2 = getString(R.string.universal_pass_permission_sub_text);
        String string3 = getString(R.string.yes_allow);
        String string4 = getString(R.string.no_deny);
        HomeActivity.a aVar = HomeActivity.k;
        du0 f = du0.f(supportFragmentManager, e0, string2, string3, string4, 1, 0, "Home Screen");
        f.setCancelable(false);
        f.e(new ya0(f, this));
        f.d(new za0(this, f));
    }

    public final void onEvent(UniversalPassInfoFetchedEvent universalPassInfoFetchedEvent) {
        n86.e(universalPassInfoFetchedEvent, "lUniversalPassInfoFetchedEvent");
        jz5.b().m(universalPassInfoFetchedEvent);
        q0();
        List<UniversalPassInfo> universalPassInfos = universalPassInfoFetchedEvent.getUniversalPassInfos();
        if (!universalPassInfoFetchedEvent.getStatus() || universalPassInfos == null || !(!universalPassInfos.isEmpty())) {
            p0().f = false;
            s0();
            return;
        }
        ((kw) f0()).d.setTitle(getString(R.string.universal_passes_toolbar_heading));
        p0().f = true;
        int size = universalPassInfos.size();
        if (!xt.f3961a.L().m()) {
            return;
        }
        if (size == 1) {
            RecyclerView recyclerView = ((kw) f0()).e;
            n86.d(recyclerView, "viewBinding.uniPassList");
            recyclerView.setVisibility(8);
            ConstraintLayout constraintLayout = ((kw) f0()).b.f2462a;
            n86.d(constraintLayout, "viewBinding.emptyView.root");
            constraintLayout.setVisibility(8);
            UniversalPassInfo universalPassInfo = universalPassInfos.get(0);
            Map o = y56.o(new m56("universal pass user name", universalPassInfo.getName()), new m56("universal pass user id", universalPassInfo.getBeneficiaryId()));
            n86.e("single universal pass available", "lEventName");
            n86.e("universal pass info adapter", "lSource");
            ed1 ed1 = new ed1("single universal pass available", Long.MIN_VALUE);
            ed1.a("source", "universal pass info adapter");
            for (Map.Entry entry : o.entrySet()) {
                ed1.a((String) entry.getKey(), entry.getValue());
            }
            ui1.m0(ed1);
            WebViewActivity.h0(this, universalPassInfos.get(0).getUrl(), universalPassInfos.get(0).getName(), false, false);
            finish();
            return;
        }
        RecyclerView recyclerView2 = ((kw) f0()).e;
        n86.d(recyclerView2, "viewBinding.uniPassList");
        recyclerView2.setVisibility(0);
        ConstraintLayout constraintLayout2 = ((kw) f0()).b.f2462a;
        n86.d(constraintLayout2, "viewBinding.emptyView.root");
        constraintLayout2.setVisibility(8);
        bv bvVar = new bv(this);
        ((kw) f0()).e.setAdapter(bvVar);
        bvVar.f2701a.b(universalPassInfos, null);
    }

    public final ha1 p0() {
        return (ha1) this.k.getValue();
    }

    public final void q0() {
        ConstraintLayout constraintLayout = ((kw) f0()).c.f2134a;
        n86.d(constraintLayout, "viewBinding.loadingScreen.root");
        constraintLayout.setVisibility(8);
        LoadingSpinnerView loadingSpinnerView = ((kw) f0()).c.d;
        n86.d(loadingSpinnerView, "viewBinding.loadingScreen.loadingSpinner");
        loadingSpinnerView.setVisibility(8);
        LinearLayout linearLayout = ((kw) f0()).c.b;
        n86.d(linearLayout, "viewBinding.loadingScreen.connectionErrorLayout");
        linearLayout.setVisibility(8);
    }

    public final void r0() {
        ConstraintLayout constraintLayout = ((kw) f0()).c.f2134a;
        n86.d(constraintLayout, "viewBinding.loadingScreen.root");
        constraintLayout.setVisibility(0);
        LoadingSpinnerView loadingSpinnerView = ((kw) f0()).c.d;
        n86.d(loadingSpinnerView, "viewBinding.loadingScreen.loadingSpinner");
        loadingSpinnerView.setVisibility(0);
        LinearLayout linearLayout = ((kw) f0()).c.b;
        n86.d(linearLayout, "viewBinding.loadingScreen.connectionErrorLayout");
        linearLayout.setVisibility(8);
        ha1 p0 = p0();
        z60 z60 = z60.f4134a;
        Context context = p0.d;
        n86.d(context, AnalyticsConstants.CONTEXT);
        z60.a(context);
    }

    public final void s0() {
        if (vn.K0(this)) {
            ConstraintLayout constraintLayout = ((kw) f0()).c.f2134a;
            n86.d(constraintLayout, "viewBinding.loadingScreen.root");
            constraintLayout.setVisibility(8);
            RecyclerView recyclerView = ((kw) f0()).e;
            n86.d(recyclerView, "viewBinding.uniPassList");
            recyclerView.setVisibility(8);
            ConstraintLayout constraintLayout2 = ((kw) f0()).b.f2462a;
            n86.d(constraintLayout2, "viewBinding.emptyView.root");
            constraintLayout2.setVisibility(0);
            MaterialTextView materialTextView = ((kw) f0()).b.c;
            String string = getString(R.string.no_universal_passes_found_subtext);
            n86.d(string, "getString(R.string.no_un…sal_passes_found_subtext)");
            String format = String.format(string, Arrays.copyOf(new Object[]{xt.f3961a.L().getUserId()}, 1));
            n86.d(format, "java.lang.String.format(format, *args)");
            materialTextView.setText(format);
            ((kw) f0()).d.setTitle(getString(R.string.no_universal_passes_found_toolbar_heading));
            return;
        }
        ((kw) f0()).d.setTitle(getString(R.string.universal_passes_toolbar_heading));
        k0();
        RecyclerView recyclerView2 = ((kw) f0()).e;
        n86.d(recyclerView2, "viewBinding.uniPassList");
        recyclerView2.setVisibility(8);
        ConstraintLayout constraintLayout3 = ((kw) f0()).b.f2462a;
        n86.d(constraintLayout3, "viewBinding.emptyView.root");
        constraintLayout3.setVisibility(8);
        ConstraintLayout constraintLayout4 = ((kw) f0()).c.f2134a;
        n86.d(constraintLayout4, "viewBinding.loadingScreen.root");
        constraintLayout4.setVisibility(0);
        LoadingSpinnerView loadingSpinnerView = ((kw) f0()).c.d;
        n86.d(loadingSpinnerView, "viewBinding.loadingScreen.loadingSpinner");
        loadingSpinnerView.setVisibility(8);
        LinearLayout linearLayout = ((kw) f0()).c.b;
        n86.d(linearLayout, "viewBinding.loadingScreen.connectionErrorLayout");
        linearLayout.setVisibility(0);
    }

    public final void onEvent(qd1 qd1) {
        n86.e(qd1, "networkConnectivityEvent");
        jz5.b().m(qd1);
        boolean z = qd1.f2931a;
        if (z != p0().e) {
            p0().e = z;
            if (z) {
                o0();
                k0();
            } else if (p0().f) {
                l0(((kw) f0()).f2126a);
            } else {
                s0();
            }
        } else if (!z) {
            s0();
        }
    }
}
