package app.zophop.ui.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import defpackage.wd1;
import defpackage.xt;
import java.util.List;

/* compiled from: HomeActivity.kt */
public final class HomeActivity extends ol0<yx> implements wd1.a {
    public static final a k = new a(null);
    public static final String l = HomeActivity.class.getSimpleName();
    public static final fd5<String> m;
    public static final fd5<String> n;

    /* compiled from: HomeActivity.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    static {
        xt.t1 t1Var = xt.f3961a;
        fd5<String> q = nc5.q("searchBarCopy", t1Var.t().f("searchBarCopy"));
        n86.d(q, "stringTweak(\"searchBarCo…tString(\"searchBarCopy\"))");
        m = q;
        fd5<String> q2 = nc5.q("universalSearchBarTextColor", "#DD000000");
        n86.d(q2, "stringTweak(\"universalSe…rTextColor\", \"#DD000000\")");
        n = q2;
        n86.d(nc5.d("askForFeedback", t1Var.t().b("askForFeedbackABExpDefaultValue")), "booleanTweak(\"askForFeed…dbackABExpDefaultValue\"))");
    }

    @Override // defpackage.wd1.a
    public void b0() {
    }

    @Override // defpackage.wd1.a
    public void c0() {
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.ol0
    public yx g0() {
        View inflate = getLayoutInflater().inflate(R.layout.home_activity, (ViewGroup) null, false);
        FragmentContainerView fragmentContainerView = (FragmentContainerView) inflate.findViewById(R.id.nav_host_fragment);
        if (fragmentContainerView != null) {
            yx yxVar = new yx((ConstraintLayout) inflate, fragmentContainerView);
            n86.d(yxVar, "inflate(layoutInflater)");
            return yxVar;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.nav_host_fragment)));
    }

    @Override // defpackage.ol0
    public void h0(Bundle bundle) {
    }

    @Override // defpackage.ol0
    public void i0() {
    }

    @Override // defpackage.ol0
    public void j0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.MODE_CHANGED");
        intentFilter.addAction("android.location.PROVIDER_CHANGED_ACTION");
        registerReceiver(d0(), intentFilter);
        registerReceiver(e0(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // defpackage.ol0
    public void m0() {
    }

    @Override // defpackage.ol0
    public void n0() {
        unregisterReceiver(d0());
        unregisterReceiver(e0());
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        FragmentManager childFragmentManager;
        List<Fragment> L;
        super.onActivityResult(i, i2, intent);
        if (i == 99) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            n86.d(supportFragmentManager, "supportFragmentManager");
            n86.e(supportFragmentManager, "<this>");
            Fragment fragment = supportFragmentManager.t;
            Fragment fragment2 = null;
            if (!(fragment == null || (childFragmentManager = fragment.getChildFragmentManager()) == null || (L = childFragmentManager.L()) == null)) {
                fragment2 = (Fragment) y56.i(L);
            }
            if (fragment2 instanceof HomeScreenMainFragment) {
                ((HomeScreenMainFragment) fragment2).r();
            }
        }
    }
}
