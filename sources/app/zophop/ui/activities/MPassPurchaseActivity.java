package app.zophop.ui.activities;

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
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import app.zophop.R;
import app.zophop.models.RouteInfo;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.razorpay.AnalyticsConstants;
import defpackage.p81;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: MPassPurchaseActivity.kt */
public final class MPassPurchaseActivity extends sl0<zv> {
    public static final /* synthetic */ int n = 0;
    public p81 k;
    public NavController l;
    public final rj m;

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

    /* compiled from: MPassPurchaseActivity.kt */
    public static final class b extends o86 implements h76<ci> {
        public final /* synthetic */ MPassPurchaseActivity f;
        public final /* synthetic */ Bundle g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MPassPurchaseActivity mPassPurchaseActivity, Bundle bundle) {
            super(0);
            this.f = mPassPurchaseActivity;
            this.g = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new p81.a(this.f, this.g);
        }
    }

    /* compiled from: AppBarConfiguration.kt */
    public static final class c extends o86 implements h76<Boolean> {
        public static final c f = new c();

        public c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    public MPassPurchaseActivity() {
        d66 d66 = d66.f;
        c cVar = c.f;
        HashSet hashSet = new HashSet();
        hashSet.addAll(d66);
        rj rjVar = new rj(hashSet, null, new ge0(cVar), null);
        n86.b(rjVar, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        this.m = rjVar;
    }

    public static final Intent r0(Context context, String str, String str2, MPass mPass, RouteInfo routeInfo) {
        n86.e(context, "lContext");
        n86.e(str, "lSource");
        n86.e(str2, "lPurchaseFlowType");
        n86.e(mPass, "lMPass");
        Intent intent = new Intent(context, MPassPurchaseActivity.class);
        intent.putExtra("arg_source", str);
        intent.putExtra("arg_purchase_flow_type", str2);
        intent.putExtra("arg_mPass", ov.f(mPass));
        return intent;
    }

    public static final void s0(Context context, String str, String str2, MPass mPass, RouteInfo routeInfo) {
        n86.e(context, "lContext");
        n86.e(str, "lSource");
        n86.e(str2, "lPurchaseFlowType");
        n86.e(mPass, "lMPass");
        Intent intent = new Intent(context, MPassPurchaseActivity.class);
        intent.putExtra("arg_source", str);
        intent.putExtra("arg_purchase_flow_type", str2);
        intent.putExtra("arg_mPass", ov.f(mPass));
        if (routeInfo != null) {
            intent.putExtra("arg_route_info", routeInfo);
        }
        context.startActivity(intent);
    }

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_mpass_purchase, (ViewGroup) null, false);
        int i = R.id.super_pass_purchase_nav_host_fragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) inflate.findViewById(R.id.super_pass_purchase_nav_host_fragment);
        if (fragmentContainerView != null) {
            i = R.id.toolbar;
            Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
            if (toolbar != null) {
                zv zvVar = new zv((LinearLayout) inflate, fragmentContainerView, toolbar);
                n86.d(zvVar, "inflate(layoutInflater)");
                return zvVar;
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

    @Override // defpackage.sl0
    public void o0() {
        MPass mPass;
        Bundle bundle = new Bundle();
        Bundle extras = getIntent().getExtras();
        boolean z = false;
        if (extras != null && extras.containsKey("info")) {
            z = true;
        }
        if (!z || !extras.containsKey(SuperPassJsonKeys.USER_PROFILE)) {
            String stringExtra = getIntent().getStringExtra("arg_source");
            n86.c(stringExtra);
            n86.d(stringExtra, "intent.getStringExtra(ARG_SOURCE)!!");
            String stringExtra2 = getIntent().getStringExtra("arg_purchase_flow_type");
            n86.c(stringExtra2);
            n86.d(stringExtra2, "intent.getStringExtra(ARG_PURCHASE_FLOW_TYPE)!!");
            String stringExtra3 = getIntent().getStringExtra("arg_mPass");
            n86.c(stringExtra3);
            n86.d(stringExtra3, "intent.getStringExtra(ARG_MPASS)!!");
            MPass r = ov.r(stringExtra3);
            bundle.putString("keySource", stringExtra);
            bundle.putString("keyPurchaseFlowType", stringExtra2);
            bundle.putParcelable("keyMPass", r);
            bundle.putParcelable("keyRouteInfo", (RouteInfo) getIntent().getParcelableExtra("arg_route_info"));
        } else {
            String string = extras.getString("info");
            UserProfile H = ov.H(extras.getString(SuperPassJsonKeys.USER_PROFILE));
            String str = "flowPaymentPostVerification";
            if (ea6.f(".MakePayment", getIntent().getAction(), true)) {
                mPass = ov.I(string, H);
                n86.d(mPass, "getVerifiedMpassFromProf…InfoString, lUserProfile)");
                if (n86.a(mPass.get_productType(), "superSaver")) {
                    mPass = new MPass();
                }
            } else if (ea6.f(".ViewPass", getIntent().getAction(), true)) {
                mPass = ov.D(string, H);
                n86.c(mPass);
                if (n86.a(mPass.get_productType(), "superSaver")) {
                    mPass = new MPass();
                }
                str = "flowReapplication";
            } else {
                mPass = new MPass();
                str = "flowFreshPurchase";
            }
            bundle.putString("keySource", "sourceNotification");
            bundle.putString("keyPurchaseFlowType", str);
            bundle.putParcelable("keyMPass", mPass);
            bundle.putParcelable("keyRouteInfo", (RouteInfo) getIntent().getParcelableExtra("arg_route_info"));
        }
        p81 p81 = (p81) new ai(z86.a(p81.class), new a(this), new b(this, bundle)).getValue();
        this.k = p81;
        ed1 ed1 = new ed1("mPassPurchaseActivity open", Long.MIN_VALUE);
        if (p81 != null) {
            ed1.a(AnalyticsConstants.FLOW, p81.f);
            p81 p812 = this.k;
            if (p812 != null) {
                ed1.a("source", p812.e);
                ui1.m0(ed1);
                return;
            }
            n86.l("sharedViewModel");
            throw null;
        }
        n86.l("sharedViewModel");
        throw null;
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
        y20 R = xt.f3961a.R();
        p81 p81 = this.k;
        if (p81 != null) {
            HashMap hashMap = new HashMap();
            if (p81.g.get_cityName() != null) {
                String str = p81.g.get_cityName();
                n86.d(str, "mPass._cityName");
                hashMap.put("userPropertyCity", str);
            }
            if (p81.g.getUserProfile() != null) {
                UserProfile userProfile = p81.g.getUserProfile();
                String firstName = userProfile.getFirstName();
                String lastName = userProfile.getLastName();
                if (firstName != null) {
                    if (lastName != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append((Object) firstName);
                        sb.append(' ');
                        sb.append((Object) lastName);
                        firstName = sb.toString();
                    }
                    n86.d(firstName, "lFirstName");
                    hashMap.put("userPropertyUserName", firstName);
                } else if (lastName != null) {
                    hashMap.put("userPropertyUserName", lastName);
                }
                if (userProfile.getPhone() != null) {
                    String phone = userProfile.getPhone();
                    n86.d(phone, "lUserProfile.phone");
                    hashMap.put("userPropertyPhoneNo", phone);
                }
                if (userProfile.getUserId() != null) {
                    String userId = userProfile.getUserId();
                    n86.d(userId, "lUserProfile.userId");
                    hashMap.put("userPropertyUserID", userId);
                }
            }
            if (p81.g.getAgency() != null) {
                String agency = p81.g.getAgency();
                n86.d(agency, "mPass.agency");
                hashMap.put("userPropertyAgencyName", agency);
            }
            if (p81.g.getRouteStopsInfo() != null) {
                if (p81.g.getRouteStopsInfo().getRouteId() != null) {
                    String routeId = p81.g.getRouteStopsInfo().getRouteId();
                    n86.d(routeId, "mPass.routeStopsInfo.routeId");
                    hashMap.put("userPropertyRouteId", routeId);
                }
                if (p81.g.getRouteStopsInfo().getRouteName() != null) {
                    String routeName = p81.g.getRouteStopsInfo().getRouteName();
                    n86.d(routeName, "mPass.routeStopsInfo.routeName");
                    hashMap.put("userPropertyRouteName", routeName);
                }
            }
            if (p81.g.getBookingPassId() != null) {
                String bookingPassId = p81.g.getBookingPassId();
                n86.d(bookingPassId, "mPass.bookingPassId");
                hashMap.put("userPropertyMPassId", bookingPassId);
            }
            if (p81.g.getOrderId() != null) {
                String orderId = p81.g.getOrderId();
                n86.d(orderId, "mPass.orderId");
                hashMap.put("userPropertyOrderId", orderId);
            }
            R.b(this, "verificationScreen", "mPassPurchaseActivity", hashMap, false);
            ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "passVerificationProblemsV2");
            l2.a("problemSource", "mPassPurchaseActivity");
            p81 p812 = this.k;
            if (p812 != null) {
                l2.a(AnalyticsConstants.FLOW, p812.f);
                ui1.m0(l2);
                return true;
            }
            n86.l("sharedViewModel");
            throw null;
        }
        n86.l("sharedViewModel");
        throw null;
    }

    @Override // defpackage.f0
    public boolean onSupportNavigateUp() {
        NavController navController = this.l;
        if (navController == null) {
            n86.l("navController");
            throw null;
        } else if (h.j0(navController, this.m)) {
            return true;
        } else {
            if (isTaskRoot()) {
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                return true;
            } else if (super.onSupportNavigateUp()) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override // defpackage.sl0
    public void p0() {
        p81 p81 = this.k;
        if (p81 == null) {
            n86.l("sharedViewModel");
            throw null;
        } else if (!p81.i) {
            ed1 ed1 = new ed1("complete product configuration not available", Long.MIN_VALUE);
            if (p81 != null) {
                ed1.a("productConfiguration avl", Boolean.valueOf(p81.j));
                p81 p812 = this.k;
                if (p812 != null) {
                    ed1.a("productConfiguration avl", Boolean.valueOf(p812.k));
                    p81 p813 = this.k;
                    if (p813 != null) {
                        ed1.a("productConfiguration avl", Boolean.valueOf(p813.l));
                        p81 p814 = this.k;
                        if (p814 != null) {
                            ed1.a("productConfiguration avl", Boolean.valueOf(p814.m));
                            ui1.m0(ed1);
                            Intent intent = new Intent(this, HomeActivity.class);
                            intent.setFlags(268468224);
                            startActivity(intent);
                            finish();
                            return;
                        }
                        n86.l("sharedViewModel");
                        throw null;
                    }
                    n86.l("sharedViewModel");
                    throw null;
                }
                n86.l("sharedViewModel");
                throw null;
            }
            n86.l("sharedViewModel");
            throw null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (r0.equals("flowPaymentPostVerification") == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r0.equals("flowRenewPass") == false) goto L_0x003c;
     */
    @Override // defpackage.sl0
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q0() {
        /*
        // Method dump skipped, instructions count: 248
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.MPassPurchaseActivity.q0():void");
    }
}
