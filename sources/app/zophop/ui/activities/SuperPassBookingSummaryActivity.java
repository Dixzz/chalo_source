package app.zophop.ui.activities;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import app.zophop.ui.fragments.superPassHistory.DigitalTripReceiptHistoryFragment;
import app.zophop.ui.fragments.superPassHistory.SuperPassTripReceiptFragment;
import java.util.List;
import java.util.Objects;

/* compiled from: SuperPassBookingSummaryActivity.kt */
public final class SuperPassBookingSummaryActivity extends wl0<hw> {
    public static final /* synthetic */ int n = 0;
    public u91 m;

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

    /* compiled from: SuperPassBookingSummaryActivity.kt */
    public static final class b extends o86 implements h76<ci> {
        public final /* synthetic */ SuperPassBookingSummaryActivity f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SuperPassBookingSummaryActivity superPassBookingSummaryActivity) {
            super(0);
            this.f = superPassBookingSummaryActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            Application application = this.f.getApplication();
            SuperPassBookingSummaryActivity superPassBookingSummaryActivity = this.f;
            Boolean bool = Boolean.FALSE;
            return new xh(application, superPassBookingSummaryActivity, h.j(new m56("keySuperPassId", superPassBookingSummaryActivity.getIntent().getStringExtra("arg_superPassId")), new m56("keySuperPassSubType", this.f.getIntent().getParcelableExtra("arg_superPassSubType")), new m56("keySuperPassApplication", this.f.getIntent().getParcelableExtra("arg_superPassApplication")), new m56("keySource", this.f.getIntent().getStringExtra("arg_source")), new m56("keyProofDocumentsExpansionState", bool), new m56("keyShouldShowLoader", bool), new m56("keyStartDestination", this.f.getIntent().getStringExtra("arg_startDestination"))));
        }
    }

    public static final void s0(String str, SuperPassSubType superPassSubType, String str2, Context context) {
        n86.e(str, "lSuperPassId");
        n86.e(superPassSubType, "lSuperPassSubType");
        n86.e(str2, "lSource");
        n86.e(context, "lContext");
        Intent intent = new Intent(context, SuperPassBookingSummaryActivity.class);
        intent.putExtra("arg_superPassId", str);
        intent.putExtra("arg_superPassSubType", (Parcelable) superPassSubType);
        intent.putExtra("arg_source", str2);
        intent.putExtra("arg_startDestination", "startDestinationSummaryScreen");
        context.startActivity(intent);
    }

    public static final void t0(String str, SuperPassSubType superPassSubType, long j, String str2, Context context) {
        n86.e(str, "lSuperPassId");
        n86.e(superPassSubType, "lSuperPassSubType");
        n86.e(str2, "lSource");
        n86.e(context, "lContext");
        Intent intent = new Intent(context, SuperPassBookingSummaryActivity.class);
        intent.putExtra("arg_source", str2);
        intent.putExtra("arg_startDestination", "startDestinationSuperPassTripReceiptScreen");
        intent.putExtra("arg_superPassId", str);
        intent.putExtra("arg_superPassSubType", (Parcelable) superPassSubType);
        intent.putExtra("arg_activationTimeStamp", j);
        context.startActivity(intent);
    }

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_super_pass_booking_summary, (ViewGroup) null, false);
        int i = R.id.nav_host_fragment_super_pass_booking_summary;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) inflate.findViewById(R.id.nav_host_fragment_super_pass_booking_summary);
        if (fragmentContainerView != null) {
            i = R.id.toolbar;
            Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
            if (toolbar != null) {
                hw hwVar = new hw((ConstraintLayout) inflate, fragmentContainerView, toolbar);
                n86.d(hwVar, "inflate(layoutInflater)");
                return hwVar;
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
    public boolean l0(View view) {
        FragmentManager childFragmentManager;
        List<Fragment> L;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        n86.d(supportFragmentManager, "supportFragmentManager");
        n86.e(supportFragmentManager, "<this>");
        Fragment fragment = supportFragmentManager.t;
        Fragment fragment2 = (fragment == null || (childFragmentManager = fragment.getChildFragmentManager()) == null || (L = childFragmentManager.L()) == null) ? null : (Fragment) y56.i(L);
        if (fragment2 instanceof DigitalTripReceiptHistoryFragment) {
            return super.l0(view);
        }
        if (fragment2 instanceof SuperPassTripReceiptFragment) {
            return super.l0(view);
        }
        return false;
    }

    @Override // defpackage.ol0
    public void m0() {
        jz5.b().o(this);
    }

    @Override // defpackage.wl0
    public void o0() {
        this.m = (u91) new ai(z86.a(u91.class), new a(this), new b(this)).getValue();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_problem_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public final void onEvent(qd1 qd1) {
        n86.e(qd1, "networkConnectivityEvent");
        jz5.b().m(qd1);
        boolean z = qd1.f2931a;
        u91 u91 = this.m;
        if (u91 != null) {
            boolean z2 = u91.d;
            if (z != z2) {
                if (z) {
                    k0();
                } else {
                    l0(((hw) f0()).f1435a);
                }
                u91 u912 = this.m;
                if (u912 != null) {
                    u912.d = z;
                } else {
                    n86.l("sharedViewModel");
                    throw null;
                }
            } else if (!z2) {
                l0(((hw) f0()).f1435a);
            }
        } else {
            n86.l("sharedViewModel");
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onOptionsItemSelected(android.view.MenuItem r11) {
        /*
        // Method dump skipped, instructions count: 400
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.SuperPassBookingSummaryActivity.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    @Override // defpackage.wl0
    public void q0() {
        u91 u91 = this.m;
        String str = null;
        if (u91 == null) {
            n86.l("sharedViewModel");
            throw null;
        } else if (u91.k) {
            if (u91 != null) {
                LiveData<PendingSuperPass> liveData = u91.r;
                if (liveData != null) {
                    liveData.f(this, new ma0(this));
                }
                u0(R.id.pendingSuperPassBookingSummaryFragment, new Bundle());
                return;
            }
            n86.l("sharedViewModel");
            throw null;
        } else if (u91 == null) {
            n86.l("sharedViewModel");
            throw null;
        } else if (u91.l) {
            x supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                u91 u912 = this.m;
                if (u912 != null) {
                    SuperPassApplication superPassApplication = u912.j;
                    if (superPassApplication != null) {
                        str = superPassApplication.getPassName();
                    }
                    supportActionBar.z(str);
                } else {
                    n86.l("sharedViewModel");
                    throw null;
                }
            }
            u0(R.id.superPassApplicationBookingSummaryFragment, new Bundle());
        } else if (u91 == null) {
            n86.l("sharedViewModel");
            throw null;
        } else if (u91.n) {
            m56[] m56Arr = new m56[4];
            if (u91 != null) {
                m56Arr[0] = new m56("arg_source", u91.h);
                m56Arr[1] = new m56("arg_superPassId", u91.f);
                m56Arr[2] = new m56("arg_superPassSubType", u91.g);
                m56Arr[3] = new m56("arg_activationTimeStamp", Long.valueOf(getIntent().getLongExtra("arg_activationTimeStamp", -1)));
                u0(R.id.superPassTripReceiptFragment, h.j(m56Arr));
                return;
            }
            n86.l("sharedViewModel");
            throw null;
        } else if (u91 == null) {
            n86.l("sharedViewModel");
            throw null;
        } else if (u91.m) {
            m56[] m56Arr2 = new m56[3];
            if (u91 != null) {
                m56Arr2[0] = new m56("arg_source", u91.h);
                m56Arr2[1] = new m56("arg_superPassId", u91.f);
                m56Arr2[2] = new m56("arg_superPassSubType", u91.g);
                u0(R.id.digitalTripReceiptHistoryFragment, h.j(m56Arr2));
                return;
            }
            n86.l("sharedViewModel");
            throw null;
        } else if (u91 != null) {
            LiveData<SuperPass> liveData2 = u91.q;
            if (liveData2 != null) {
                la0 la0 = new la0(this);
                n86.e(liveData2, "<this>");
                n86.e(this, "lifecycleOwner");
                n86.e(la0, "observer");
                liveData2.f(this, new th1(la0, liveData2));
            }
            u0(R.id.superPassBookingSummaryFragment, new Bundle());
        } else {
            n86.l("sharedViewModel");
            throw null;
        }
    }

    @Override // defpackage.wl0
    public void r0() {
    }

    public void u0(int i, Bundle bundle) {
        n86.e(bundle, "lArgBundle");
        Fragment H = getSupportFragmentManager().H(R.id.nav_host_fragment_super_pass_booking_summary);
        Objects.requireNonNull(H, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        NavHostFragment navHostFragment = (NavHostFragment) H;
        NavController e = navHostFragment.e();
        n86.d(e, "lNavHostFragment.navController");
        n86.e(e, "<set-?>");
        this.k = e;
        jj e2 = navHostFragment.e().e();
        n86.d(e2, "lNavHostFragment.navController.navInflater");
        gj c = e2.c(R.navigation.nav_graph_super_pass_booking_summary);
        n86.d(c, "lNavGraphInflater.inflat…per_pass_booking_summary)");
        c.A(i);
        p0().i(c, bundle);
        setSupportActionBar(((hw) f0()).b);
        h.B0(this, p0(), this.l);
        u91 u91 = this.m;
        if (u91 != null) {
            String str = u91.i;
            ed1 ed1 = new ed1("pass summary details screen opened", Long.MIN_VALUE);
            ed1.a("isSuperPass", Boolean.TRUE);
            ed1.a("start destination", str);
            u91 u912 = this.m;
            if (u912 != null) {
                ed1.a("source", u912.h);
                ui1.m0(ed1);
                return;
            }
            n86.l("sharedViewModel");
            throw null;
        }
        n86.l("sharedViewModel");
        throw null;
    }
}
