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
import app.zophop.models.Agency;
import app.zophop.models.City;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.models.mTicketing.PassApplicationRejectionReasons;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.SuperPassApplicationStatus;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassOrderDetails;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: SuperPassPurchaseActivity.kt */
public final class SuperPassPurchaseActivity extends sl0<iw> {
    public static final /* synthetic */ int n = 0;
    public SuperPassPurchaseSharedViewModel k;
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

    /* compiled from: SuperPassPurchaseActivity.kt */
    public static final class b extends o86 implements h76<ci> {
        public final /* synthetic */ SuperPassPurchaseActivity f;
        public final /* synthetic */ Bundle g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SuperPassPurchaseActivity superPassPurchaseActivity, Bundle bundle) {
            super(0);
            this.f = superPassPurchaseActivity;
            this.g = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new SuperPassPurchaseSharedViewModel.a(this.f, this.g);
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

    public SuperPassPurchaseActivity() {
        d66 d66 = d66.f;
        c cVar = c.f;
        HashSet hashSet = new HashSet();
        hashSet.addAll(d66);
        rj rjVar = new rj(hashSet, null, new wf0(cVar), null);
        n86.b(rjVar, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        this.m = rjVar;
    }

    public static final Intent r0(Context context, String str, String str2, BookableSuperPassConfiguration bookableSuperPassConfiguration) {
        Intent N0 = hj1.N0(context, SuperPassPurchaseActivity.class, "arg_source", str);
        N0.putExtra("arg_purchase_flow_type", str2);
        N0.putExtra("arg_isVerificationRequired", bookableSuperPassConfiguration.isVerificationRequired());
        N0.putExtra("arg_bookable_super_pass_config", BookableSuperPassConfiguration.Companion.convertBookableSuperPassConfigToString(bookableSuperPassConfiguration));
        return N0;
    }

    public static final void s0(Context context, String str, BookableSuperPassConfiguration bookableSuperPassConfiguration, SuperPassApplication superPassApplication) {
        n86.e(context, "lContext");
        n86.e(str, "lSource");
        n86.e(bookableSuperPassConfiguration, "lBookableSuperPassConfiguration");
        n86.e(superPassApplication, "lSuperPassApplication");
        Intent r0 = r0(context, str, "flowPaymentPostVerification", bookableSuperPassConfiguration);
        r0.putExtra("arg_superPassUserDetails", SuperPassUserDetails.Companion.convertSuperPassUserDetailsToString(superPassApplication.getSuperPassUserDetails()));
        r0.putExtra("arg_verificationExpiryTime", superPassApplication.getVerificationExpiryTime());
        r0.putExtra("arg_passStartTime", superPassApplication.getPassStartDate());
        context.startActivity(r0);
    }

    public static final void t0(Context context, String str, BookableSuperPassConfiguration bookableSuperPassConfiguration, SuperPassApplication superPassApplication) {
        n86.e(context, "lContext");
        n86.e(str, "lSource");
        n86.e(bookableSuperPassConfiguration, "lBookableSuperPassConfiguration");
        n86.e(superPassApplication, "lSuperPassApplication");
        Intent r0 = r0(context, str, "flowReapplication", bookableSuperPassConfiguration);
        String convertSuperPassUserDetailsToString = SuperPassUserDetails.Companion.convertSuperPassUserDetailsToString(superPassApplication.getSuperPassUserDetails());
        PassApplicationActionRequired.Companion companion = PassApplicationActionRequired.Companion;
        PassApplicationActionRequired passApplicationActionRequired = superPassApplication.getPassApplicationActionRequired();
        n86.c(passApplicationActionRequired);
        String convertPassApplicationActionRequiredToString = companion.convertPassApplicationActionRequiredToString(passApplicationActionRequired);
        PassApplicationRejectionReasons.Companion companion2 = PassApplicationRejectionReasons.Companion;
        PassApplicationRejectionReasons passApplicationRejectionReasons = superPassApplication.getPassApplicationRejectionReasons();
        n86.c(passApplicationRejectionReasons);
        String convertPassApplicationRejectionReasonsToString = companion2.convertPassApplicationRejectionReasonsToString(passApplicationRejectionReasons);
        r0.putExtra("arg_superPassUserDetails", convertSuperPassUserDetailsToString);
        r0.putExtra("arg_passApplicationActionRequired", convertPassApplicationActionRequiredToString);
        r0.putExtra("arg_passApplicationRejectionReasons", convertPassApplicationRejectionReasonsToString);
        if (superPassApplication.getPassStartDate() != 0) {
            r0.putExtra("arg_passStartTime", superPassApplication.getPassStartDate());
        }
        context.startActivity(r0);
    }

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_super_pass_purchase, (ViewGroup) null, false);
        int i = R.id.super_pass_purchase_nav_host_fragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) inflate.findViewById(R.id.super_pass_purchase_nav_host_fragment);
        if (fragmentContainerView != null) {
            i = R.id.toolbar;
            Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
            if (toolbar != null) {
                iw iwVar = new iw((LinearLayout) inflate, fragmentContainerView, toolbar);
                n86.d(iwVar, "inflate(layoutInflater)");
                return iwVar;
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
        String str;
        Bundle bundle = new Bundle();
        Bundle extras = getIntent().getExtras();
        if (!(extras != null && extras.containsKey("info"))) {
            if (extras != null && extras.containsKey("arg_purchase_flow_type")) {
                String string = extras.getString("arg_source");
                n86.c(string);
                n86.d(string, "lIntentBundle.getString(ARG_SOURCE)!!");
                String string2 = extras.getString("arg_purchase_flow_type");
                n86.c(string2);
                n86.d(string2, "lIntentBundle.getString(ARG_PURCHASE_FLOW_TYPE)!!");
                String stringExtra = getIntent().getStringExtra("arg_bookable_super_pass_config");
                n86.c(stringExtra);
                n86.d(stringExtra, "intent.getStringExtra(AR…ABLE_SUPER_PASS_CONFIG)!!");
                BookableSuperPassConfiguration bookableSuperPassConfigFromString = BookableSuperPassConfiguration.Companion.getBookableSuperPassConfigFromString(stringExtra);
                bundle.putBoolean("keyIsVerificationRequired", extras.getBoolean("arg_isVerificationRequired"));
                bundle.putString("keySource", string);
                bundle.putString("keyPurchaseFlowType", string2);
                bundle.putParcelable("keyBookablePassConfig", bookableSuperPassConfigFromString);
                if (!n86.a(string2, "flowFreshPurchase")) {
                    String string3 = extras.getString("arg_superPassUserDetails");
                    n86.c(string3);
                    n86.d(string3, "lIntentBundle.getString(…UPER_PASS_USER_DETAILS)!!");
                    bundle.putParcelable("keySuperPassUserDetails", SuperPassUserDetails.Companion.getSuperPassUserDetailsFromString(string3));
                    switch (string2.hashCode()) {
                        case -1494163469:
                            if (string2.equals("flowPaymentPostVerification")) {
                                long j = extras.getLong("arg_passStartTime");
                                long j2 = extras.getLong("arg_verificationExpiryTime");
                                bundle.putLong("keyStartTime", j);
                                bundle.putLong("keyPassVerificationExpiryTime", j2);
                                break;
                            }
                            break;
                        case -334841259:
                            if (string2.equals("flowPaymentModeChangedNoVerification")) {
                                bundle.putLong("keyStartTime", extras.getLong("arg_passStartTime"));
                                break;
                            }
                            break;
                        case 220607151:
                            if (string2.equals("flowReapplication")) {
                                String string4 = extras.getString("arg_passApplicationRejectionReasons");
                                n86.c(string4);
                                n86.d(string4, "lIntentBundle.getString(…TION_REJECTION_REASONS)!!");
                                String string5 = extras.getString("arg_passApplicationActionRequired");
                                n86.c(string5);
                                n86.d(string5, "lIntentBundle.getString(…CATION_ACTION_REQUIRED)!!");
                                bundle.putParcelable("keySuperPassApplicationRejectionReasons", PassApplicationRejectionReasons.Companion.getPassApplicationRejectionReasonsFromString(string4));
                                bundle.putParcelable("keyPassApplicationActionRequired", PassApplicationActionRequired.Companion.getPassApplicationActionRequiredFromString(string5));
                                break;
                            }
                            break;
                        case 1278174896:
                            if (string2.equals("flowRenewPass")) {
                                long j3 = extras.getLong("arg_verificationExpiryTime");
                                bundle.putString("keySuperPassIdForRenew", extras.getString("arg_passId"));
                                bundle.putLong("keyPassVerificationExpiryTime", j3);
                                break;
                            }
                            break;
                    }
                }
            }
        } else {
            String string6 = extras.getString("info");
            if (string6 != null) {
                JSONObject jSONObject = new JSONObject(string6);
                n86.e(jSONObject, "lPayloadJson");
                String string7 = jSONObject.getString("status");
                n86.d(string7, "lPayloadJson.getString(KEY_APPLICATION_STATUS)");
                String upperCase = string7.toUpperCase();
                n86.d(upperCase, "(this as java.lang.String).toUpperCase()");
                int ordinal = SuperPassApplicationStatus.valueOf(upperCase).ordinal();
                if (ordinal != 1) {
                    str = ordinal != 2 ? null : "flowReapplication";
                } else {
                    str = "flowPaymentPostVerification";
                }
                BookableSuperPassConfiguration b2 = x60.b(jSONObject);
                if (b2 != null) {
                    SuperPassUserDetails f = x60.f(jSONObject);
                    if (n86.a(str, "flowPaymentPostVerification")) {
                        n86.e(jSONObject, "lPayload");
                        long optLong = jSONObject.optLong(SuperPassJsonKeys.VERIFICATION_EXPIRY_TIME, -1);
                        long e = x60.e(jSONObject);
                        bundle.putLong("keyPassVerificationExpiryTime", optLong);
                        bundle.putLong("keyStartTime", e);
                        bundle.putBoolean("keyIsVerificationRequired", true);
                    } else if (n86.a(str, "flowReapplication")) {
                        n86.e(jSONObject, "lPayloadJson");
                        String string8 = jSONObject.getString(SuperPassJsonKeys.ACTION_REQUIRED);
                        n86.d(string8, "lPayloadJson.getString(KEY_ACTION_REQUIRED)");
                        PassApplicationActionRequired valueOf = PassApplicationActionRequired.valueOf(string8);
                        PassApplicationRejectionReasons d = x60.d(jSONObject);
                        long e2 = x60.e(jSONObject);
                        bundle.putParcelable("keySuperPassApplicationRejectionReasons", d);
                        bundle.putParcelable("keyPassApplicationActionRequired", valueOf);
                        bundle.putLong("keyStartTime", e2);
                        bundle.putBoolean("keyIsVerificationRequired", true);
                    }
                    bundle.putString("keySource", "sourceNotification");
                    bundle.putString("keyPurchaseFlowType", str);
                    bundle.putParcelable("keyBookablePassConfig", b2);
                    bundle.putParcelable("keySuperPassUserDetails", f);
                }
            }
            bundle = null;
        }
        if (bundle == null) {
            finish();
        }
        SuperPassPurchaseSharedViewModel superPassPurchaseSharedViewModel = (SuperPassPurchaseSharedViewModel) new ai(z86.a(SuperPassPurchaseSharedViewModel.class), new a(this), new b(this, bundle)).getValue();
        this.k = superPassPurchaseSharedViewModel;
        ed1 ed1 = new ed1("superPassPurchaseActivity open", Long.MIN_VALUE);
        if (superPassPurchaseSharedViewModel != null) {
            ed1.a(AnalyticsConstants.FLOW, superPassPurchaseSharedViewModel.f);
            SuperPassPurchaseSharedViewModel superPassPurchaseSharedViewModel2 = this.k;
            if (superPassPurchaseSharedViewModel2 != null) {
                ed1.a("source", superPassPurchaseSharedViewModel2.e);
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
        boolean z = false;
        if (menuItem.getItemId() != R.id.report_problem_menu) {
            return false;
        }
        xt.t1 t1Var = xt.f3961a;
        y20 R = t1Var.R();
        SuperPassPurchaseSharedViewModel superPassPurchaseSharedViewModel = this.k;
        if (superPassPurchaseSharedViewModel != null) {
            HashMap hashMap = new HashMap();
            City d = t1Var.k().d();
            n86.c(d);
            String name = d.getName();
            n86.d(name, "DependencyFactory.cityProvider.currentCity!!.name");
            hashMap.put("userPropertyCity", name);
            SuperPassUserDetails superPassUserDetails = superPassPurchaseSharedViewModel.k;
            if (superPassUserDetails.getFullName().length() > 0) {
                hashMap.put("userPropertyUserName", superPassUserDetails.getFullName());
            }
            if (superPassUserDetails.getMobileNumber().length() > 0) {
                hashMap.put("userPropertyPhoneNo", superPassUserDetails.getMobileNumber());
            }
            if (superPassUserDetails.getUserId().length() > 0) {
                z = true;
            }
            if (z) {
                hashMap.put("userPropertyUserID", superPassUserDetails.getUserId());
            }
            Agency agency = superPassPurchaseSharedViewModel.t;
            if (agency != null) {
                String agencyName = agency.getAgencyName();
                n86.d(agencyName, "it.agencyName");
                hashMap.put("userPropertyAgencyName", agencyName);
            }
            SuperPassOrderDetails superPassOrderDetails = superPassPurchaseSharedViewModel.q;
            if (superPassOrderDetails != null) {
                hashMap.put("userPropertyMPassId", superPassOrderDetails.getTransactionId());
                String str = superPassOrderDetails.getRazorPayOrderData().get_orderId();
                n86.d(str, "it.razorPayOrderData._orderId");
                hashMap.put("userPropertyOrderId", str);
            }
            R.b(this, "verificationScreen", "mPassPurchaseActivity", hashMap, false);
            ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "passVerificationProblemsV2");
            l2.a("problemSource", "mPassPurchaseActivity");
            SuperPassPurchaseSharedViewModel superPassPurchaseSharedViewModel2 = this.k;
            if (superPassPurchaseSharedViewModel2 != null) {
                l2.a(AnalyticsConstants.FLOW, superPassPurchaseSharedViewModel2.f);
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
        SuperPassPurchaseSharedViewModel superPassPurchaseSharedViewModel = this.k;
        if (superPassPurchaseSharedViewModel == null) {
            n86.l("sharedViewModel");
            throw null;
        } else if (!superPassPurchaseSharedViewModel.s) {
            ui1.m0(new ed1("agency not available for purchase", Long.MIN_VALUE));
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            finish();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (r0.equals("flowPaymentModeChangedNoVerification") == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        if (r0.equals("flowPaymentPostVerification") == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r4 = app.zophop.R.id.confirmSuperPassPurchaseFragment;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r0.equals("flowRenewPass") == false) goto L_0x0049;
     */
    @Override // defpackage.sl0
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q0() {
        /*
        // Method dump skipped, instructions count: 262
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.SuperPassPurchaseActivity.q0():void");
    }
}
