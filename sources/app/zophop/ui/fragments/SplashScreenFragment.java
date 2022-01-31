package app.zophop.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.ui.activities.CityDiscontinuedActivity;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.SplashScreen;
import defpackage.xt;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: SplashScreenFragment.kt */
public final class SplashScreenFragment extends rl0<hz> {
    public final j56 g = h.B(this, z86.a(d91.class), new b(new a(this)), null);

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class a extends o86 implements h76<Fragment> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Fragment invoke() {
            return this.f;
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class b extends o86 implements h76<gi> {
        public final /* synthetic */ h76 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(h76 h76) {
            super(0);
            this.f = h76;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            gi viewModelStore = ((hi) this.f.invoke()).getViewModelStore();
            n86.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public hz e() {
        View inflate = getLayoutInflater().inflate(R.layout.splash_screen_fragment, (ViewGroup) null, false);
        Objects.requireNonNull(inflate, "rootView");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        hz hzVar = new hz(constraintLayout, constraintLayout);
        n86.d(hzVar, "inflate(layoutInflater)");
        return hzVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        d91 d91 = (d91) this.g.getValue();
        Objects.requireNonNull(d91);
        xt.t1 t1Var = xt.f3961a;
        t1Var.j().a();
        HashMap hashMap = new HashMap();
        String a2 = t1Var.n().a();
        n86.d(a2, "DependencyFactory.device.getDeviceId(false)");
        hashMap.put("deviceId", a2);
        t1Var.a().a(hashMap);
        t1Var.a().b(hashMap);
        if (!t1Var.l().h.has("lang_info_shown")) {
            t1Var.a().a((Map) d91.d.getValue());
            t1Var.a().b((Map) d91.d.getValue());
        }
        City d = t1Var.k().d();
        if (d != null) {
            t1Var.r0(d);
        }
        SplashScreen.a.a("onboarding");
        jz5.b().g(new ed1("first screen open", Long.MAX_VALUE));
        String str = null;
        r0 = null;
        r0 = null;
        Intent intent = null;
        hd3.Y1(h.Z(d91), d91.f, null, new e91(d91, null), 2, null);
        Boolean bool = Boolean.TRUE;
        vh1 vh1 = vh1.f3649a;
        Objects.requireNonNull((d91) this.g.getValue());
        e80 k = t1Var.k();
        t1Var.l().put("key_app_open_time_in_millis", String.valueOf(System.currentTimeMillis()));
        boolean z = false;
        if (k.e() == null || (k.f() == null && t1Var.t().b("syncMetaData"))) {
            k.g();
        } else if (t1Var.l().h.has("key_meta_update_time")) {
            String optString = t1Var.l().h.optString("key_meta_update_time", null);
            n86.c(optString);
            n86.d(optString, "DependencyFactory.getPro…r.KEY_META_UPDATE_TIME]!!");
            long parseLong = Long.parseLong(optString);
            j56<xd1> j56 = xt.d0;
            if (j56.getValue().c || System.currentTimeMillis() - parseLong > t1Var.t().c("metaUpdateFrequency")) {
                j56.getValue().c = false;
                k.g();
            } else if (t1Var.t().b("forceMetaUpdate")) {
                k.g();
            }
        } else {
            k.g();
        }
        boolean has = t1Var.l().h.has("preference:key");
        if (!t1Var.l().h.has("language_selected")) {
            ui1.c = null;
            n86.f(this, "$this$findNavController");
            NavController d2 = NavHostFragment.d(this);
            n86.b(d2, "NavHostFragment.findNavController(this)");
            qw0 qw0 = new qw0(null);
            qw0.f2997a.put("isFromSplash", bool);
            n86.d(qw0, "actionSplashScreenFragme…n().setIsFromSplash(true)");
            vh1.a(d2, qw0);
        } else if (t1Var.k().d() == null) {
            ui1.c = null;
            n86.f(this, "$this$findNavController");
            NavController d3 = NavHostFragment.d(this);
            n86.b(d3, "NavHostFragment.findNavController(this)");
            pw0 pw0 = new pw0(null);
            pw0.f2862a.put("isFromSplash", bool);
            n86.d(pw0, "actionSplashScreenFragme…t().setIsFromSplash(true)");
            vh1.a(d3, pw0);
        } else if (!has) {
            ui1.c = null;
            n86.f(this, "$this$findNavController");
            NavController d4 = NavHostFragment.d(this);
            n86.b(d4, "NavHostFragment.findNavController(this)");
            fj siVar = new si(R.id.action_splashScreenFragment_to_tutorialViewPagerFragment);
            n86.d(siVar, "actionSplashScreenFragme…torialViewPagerFragment()");
            vh1.a(d4, siVar);
        } else {
            City d5 = t1Var.k().d();
            if (d5 != null && d5.isCityDiscontinued()) {
                z = true;
            }
            if (z) {
                ui1.c = null;
                Intent intent2 = new Intent(getContext(), CityDiscontinuedActivity.class);
                City d6 = t1Var.k().d();
                if (d6 != null) {
                    str = d6.getDisplayName();
                }
                intent2.putExtra("selectedCity", str);
                intent2.addFlags(67108864);
                intent = intent2;
            } else {
                intent = new Intent(getContext(), HomeActivity.class);
                intent.addFlags(67108864);
                if (n86.a(HomeActivity.class, HomeActivity.class)) {
                    hj1.O0("new home screen rendered", Long.MIN_VALUE);
                } else {
                    hj1.O0("old home screen rendered", Long.MIN_VALUE);
                }
            }
        }
        if (intent != null) {
            startActivity(intent);
            ve activity = c();
            if (activity != null) {
                activity.finish();
            }
        }
    }
}
