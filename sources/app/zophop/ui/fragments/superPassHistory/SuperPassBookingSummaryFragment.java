package app.zophop.ui.fragments.superPassHistory;

import android.app.Application;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import app.zophop.R;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassProofProperties;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.pubsub.eventbus.events.ProductConfigurationFetchedEvent;
import app.zophop.ui.activities.SuperPassPurchaseActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: SuperPassBookingSummaryFragment.kt */
public final class SuperPassBookingSummaryFragment extends ul0<qx> {
    public static final /* synthetic */ int j = 0;
    public final j56 g = h.B(this, z86.a(u91.class), new e(this), new f(this));
    public v91 h;
    public gv0 i;

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

    /* compiled from: SuperPassBookingSummaryFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ SuperPassBookingSummaryFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SuperPassBookingSummaryFragment superPassBookingSummaryFragment) {
            super(0);
            this.f = superPassBookingSummaryFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            ve activity = this.f.c();
            n86.c(activity);
            Application application = activity.getApplication();
            SuperPassBookingSummaryFragment superPassBookingSummaryFragment = this.f;
            Boolean bool = Boolean.FALSE;
            return new xh(application, superPassBookingSummaryFragment, h.j(new m56("keyShouldShowLoader", bool), new m56("keyProofDocumentsExpansionState", bool), new m56("keyFareLayoutExpansionState", bool)));
        }
    }

    @y66(c = "app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment$onEvent$1$1", f = "SuperPassBookingSummaryFragment.kt", l = {522}, m = "invokeSuspend")
    /* compiled from: SuperPassBookingSummaryFragment.kt */
    public static final class d extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ SuperPassBookingSummaryFragment g;
        public final /* synthetic */ ProductConfigurationFetchedEvent h;
        public final /* synthetic */ SuperPass i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(SuperPassBookingSummaryFragment superPassBookingSummaryFragment, ProductConfigurationFetchedEvent productConfigurationFetchedEvent, SuperPass superPass, k66<? super d> k66) {
            super(2, k66);
            this.g = superPassBookingSummaryFragment;
            this.h = productConfigurationFetchedEvent;
            this.i = superPass;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new d(this.g, this.h, this.i, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new d(this.g, this.h, this.i, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            boolean z;
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i2 = this.f;
            boolean z2 = true;
            if (i2 == 0) {
                hd3.Y2(obj);
                v91 v91 = this.g.h;
                if (v91 != null) {
                    ProductConfigurationFetchedEvent productConfigurationFetchedEvent = this.h;
                    SuperPass superPass = this.i;
                    n86.d(superPass, "lSuperPass");
                    this.f = 1;
                    obj2 = v91.d(productConfigurationFetchedEvent, superPass, this);
                    if (obj2 == p66) {
                        return p66;
                    }
                } else {
                    n86.l("viewModel");
                    throw null;
                }
            } else if (i2 == 1) {
                hd3.Y2(obj);
                obj2 = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            BookableSuperPassConfiguration bookableSuperPassConfiguration = (BookableSuperPassConfiguration) obj2;
            if (bookableSuperPassConfiguration != null) {
                boolean z3 = false;
                if (!bookableSuperPassConfiguration.isBookablePassConfigActive()) {
                    String inactiveReason = bookableSuperPassConfiguration.getInactiveReason();
                    if (inactiveReason.length() != 0) {
                        z2 = false;
                    }
                    if (z2) {
                        inactiveReason = this.g.getString(R.string.recent_products_disabled_dialog_copy);
                        n86.d(inactiveReason, "getString(R.string.recen…cts_disabled_dialog_copy)");
                    }
                    if (this.g.c() != null) {
                        SuperPassBookingSummaryFragment superPassBookingSummaryFragment = this.g;
                        SuperPass superPass2 = this.i;
                        n86.d(superPass2, "lSuperPass");
                        String string = superPassBookingSummaryFragment.getString(R.string.recent_products_disabled_dialog_title);
                        n86.d(string, "getString(R.string.recen…ts_disabled_dialog_title)");
                        SuperPassBookingSummaryFragment.n(superPassBookingSummaryFragment, superPass2, string, inactiveReason, true, false, null, 32);
                    }
                } else {
                    SuperPass superPass3 = this.i;
                    n86.d(superPass3, "lSuperPass");
                    n86.e(bookableSuperPassConfiguration, "lBookableSuperPassConfiguration");
                    n86.e(superPass3, "lSuperPass");
                    List<String> requiredProofsList = bookableSuperPassConfiguration.getRequiredProofsList();
                    Map<String, SuperPassProofProperties> proofs = superPass3.getSuperPassUIProperties().getProofs();
                    if (requiredProofsList.size() == proofs.size()) {
                        Iterator<String> it = requiredProofsList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!proofs.containsKey(it.next())) {
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                    }
                    if (z) {
                        SuperPassBookingSummaryFragment superPassBookingSummaryFragment2 = this.g;
                        SuperPass superPass4 = this.i;
                        n86.d(superPass4, "lSuperPass");
                        String string2 = this.g.getString(R.string.recent_products_proof_requirement_changed_dialog_title);
                        n86.d(string2, "getString(R.string.recen…ent_changed_dialog_title)");
                        String string3 = this.g.getString(R.string.recent_products_proof_requirement_changed_dialog_copy);
                        n86.d(string3, "getString(R.string.recen…ment_changed_dialog_copy)");
                        SuperPassBookingSummaryFragment.n(superPassBookingSummaryFragment2, superPass4, string2, string3, true, false, null, 32);
                    } else {
                        SuperPass superPass5 = this.i;
                        n86.d(superPass5, "lSuperPass");
                        n86.e(bookableSuperPassConfiguration, "lBookableSuperPassConfiguration");
                        n86.e(superPass5, "lSuperPass");
                        if (superPass5.getSuperPassUIProperties().getFareInfo().getActualFare() == bookableSuperPassConfiguration.getSelectedProductFareMapping().getFareInfo().getActualFare()) {
                            z3 = true;
                        }
                        if (!z3) {
                            SuperPassBookingSummaryFragment superPassBookingSummaryFragment3 = this.g;
                            SuperPass superPass6 = this.i;
                            n86.d(superPass6, "lSuperPass");
                            String string4 = this.g.getString(R.string.recent_products_fare_changed_dialog_title);
                            n86.d(string4, "getString(R.string.recen…are_changed_dialog_title)");
                            String string5 = this.g.getString(R.string.recent_products_fare_changed_dialog_copy);
                            n86.d(string5, "getString(R.string.recen…fare_changed_dialog_copy)");
                            SuperPassBookingSummaryFragment.n(superPassBookingSummaryFragment3, superPass6, string4, string5, false, true, null, 32);
                        } else {
                            SuperPassBookingSummaryFragment superPassBookingSummaryFragment4 = this.g;
                            SuperPass superPass7 = this.i;
                            n86.d(superPass7, "lSuperPass");
                            int i3 = SuperPassBookingSummaryFragment.j;
                            superPassBookingSummaryFragment4.k(bookableSuperPassConfiguration, superPass7);
                        }
                    }
                }
            } else if (this.g.c() != null) {
                SuperPassBookingSummaryFragment superPassBookingSummaryFragment5 = this.g;
                SuperPass superPass8 = this.i;
                n86.d(superPass8, "lSuperPass");
                String string6 = superPassBookingSummaryFragment5.getString(R.string.recent_products_disabled_dialog_title);
                n86.d(string6, "getString(R.string.recen…ts_disabled_dialog_title)");
                String string7 = superPassBookingSummaryFragment5.getString(R.string.recent_products_disabled_dialog_copy);
                n86.d(string7, "getString(R.string.recen…cts_disabled_dialog_copy)");
                SuperPassBookingSummaryFragment.n(superPassBookingSummaryFragment5, superPass8, string6, string7, true, false, null, 32);
            }
            return s56.f3190a;
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class e extends o86 implements h76<gi> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            return hj1.j(this.f, "requireActivity()", "requireActivity().viewModelStore");
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class f extends o86 implements h76<ci> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            ve requireActivity = this.f.requireActivity();
            n86.d(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void n(app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment r16, app.zophop.models.mTicketing.superPass.SuperPass r17, java.lang.String r18, java.lang.String r19, boolean r20, boolean r21, app.zophop.models.mTicketing.BookableSuperPassConfiguration r22, int r23) {
        /*
        // Method dump skipped, instructions count: 313
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment.n(app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment, app.zophop.models.mTicketing.superPass.SuperPass, java.lang.String, java.lang.String, boolean, boolean, app.zophop.models.mTicketing.BookableSuperPassConfiguration, int):void");
    }

    @Override // defpackage.rl0
    public qo e() {
        qx b2 = qx.b(getLayoutInflater());
        n86.d(b2, "inflate(layoutInflater)");
        return b2;
    }

    @Override // defpackage.ul0
    public void f() {
        this.h = (v91) ((ai) h.B(this, z86.a(v91.class), new b(new a(this)), new c(this))).getValue();
    }

    @Override // defpackage.ul0
    public void g() {
        LiveData<SuperPass> liveData = j().q;
        if (liveData != null) {
            liveData.f(getViewLifecycleOwner(), new oz0(this));
        }
        v91 v91 = this.h;
        if (v91 != null) {
            v91.g.f(getViewLifecycleOwner(), new pz0(this));
            v91 v912 = this.h;
            if (v912 != null) {
                v912.i.f(getViewLifecycleOwner(), new mz0(this));
                v91 v913 = this.h;
                if (v913 != null) {
                    v913.k.f(getViewLifecycleOwner(), new wz0(this));
                } else {
                    n86.l("viewModel");
                    throw null;
                }
            } else {
                n86.l("viewModel");
                throw null;
            }
        } else {
            n86.l("viewModel");
            throw null;
        }
    }

    @Override // defpackage.ul0
    public void h() {
    }

    public final void i(ed1 ed1, SuperPass superPass) {
        ed1.a("source", "superPassBookingSummaryFragment");
        ed1.a("isSuperPass", Boolean.TRUE);
        ed1.a("passId", superPass.getSuperPassProperties().getPassId());
        ed1.a("productType", superPass.getSuperPassProperties().getProductType());
        ed1.a("productSubType", superPass.getSuperPassProperties().getProductSubType().toString());
        ed1.a(SuperPassJsonKeys.CATEGORY_ID, superPass.getSuperPassRepurchaseProperties().getCategoryId());
        ed1.a("fareMappingId", Integer.valueOf(superPass.getSuperPassRepurchaseProperties().getFareMappingId()));
        ed1.a("productId", superPass.getSuperPassRepurchaseProperties().getConfigId());
        ed1.a("productName", superPass.getSuperPassUIProperties().getPassName());
        ed1.a("pass status", superPass.getSuperPassValidationProperties().getStatus().toString());
        ed1.a(SuperPassJsonKeys.VERIFICATION_FLAG, Boolean.valueOf(superPass.getSuperPassRepurchaseProperties().getVerificationFlag()));
        ed1.a(SuperPassJsonKeys.VERIFICATION_EXPIRY_TIME, jh1.c(superPass.getSuperPassRepurchaseProperties().getVerificationExpiryTime()));
        ed1.a("expiry time", jh1.c(superPass.getSuperPassValidationProperties().getExpiryTime()));
        ed1.a("paymentMode", superPass.getSuperPassTransactionDetails().getPaymentMode());
        ed1.a("transaction id", superPass.getSuperPassTransactionDetails().getTransactionId());
        ed1.a("startDate", jh1.c(superPass.getSuperPassValidationProperties().getStartTime()));
    }

    public final u91 j() {
        return (u91) this.g.getValue();
    }

    public final void k(BookableSuperPassConfiguration bookableSuperPassConfiguration, SuperPass superPass) {
        ve activity = c();
        if (activity != null) {
            n86.e(activity, "lContext");
            n86.e("sourceBookingSummarySuperPassActivity", "lSource");
            n86.e(bookableSuperPassConfiguration, "lBookableSuperPassConfiguration");
            n86.e(superPass, "lSuperPass");
            Intent r0 = SuperPassPurchaseActivity.r0(activity, "sourceBookingSummarySuperPassActivity", "flowRenewPass", bookableSuperPassConfiguration);
            r0.putExtra("arg_superPassUserDetails", SuperPassUserDetails.Companion.convertSuperPassUserDetailsToString(superPass.getSuperPassUIProperties().getSuperPassUserDetails()));
            r0.putExtra("arg_passId", superPass.getSuperPassProperties().getPassId());
            r0.putExtra("arg_verificationExpiryTime", superPass.getSuperPassRepurchaseProperties().getVerificationExpiryTime());
            activity.startActivity(r0);
        }
    }

    public final void l(String str) {
        ve activity = c();
        if (activity != null) {
            int i2 = ProductSelectionActivity.D;
            Intent intent = new Intent(activity, ProductSelectionActivity.class);
            intent.putExtra("src", "sourceBookingSummarySuperPassActivity");
            if (str != null) {
                intent.putExtra("extraTargetConfigId", str);
            }
            activity.startActivity(intent);
        }
    }

    public final void m(String str, String str2, SuperPass superPass) {
        ed1 l = hj1.l("renew error dialog shown", Long.MIN_VALUE, ProductPromotionsObject.KEY_TITLE, str);
        l.a("reason", str2);
        i(l, superPass);
        ui1.m0(l);
    }

    public final void onEvent(ProductConfigurationFetchedEvent productConfigurationFetchedEvent) {
        SuperPass d2;
        n86.e(productConfigurationFetchedEvent, "lConfigurationsFetchedEvent");
        String configRequestId = productConfigurationFetchedEvent.getConfigRequestId();
        v91 v91 = this.h;
        if (v91 == null) {
            n86.l("viewModel");
            throw null;
        } else if (n86.a(configRequestId, v91.l)) {
            jz5.b().m(productConfigurationFetchedEvent);
            LiveData<SuperPass> liveData = j().q;
            if (liveData != null && (d2 = liveData.d()) != null) {
                ah b2 = wg.b(this);
                kb6 kb6 = xb6.b;
                int i2 = CoroutineExceptionHandler.d;
                hd3.Y1(b2, kb6.plus(new lh1(CoroutineExceptionHandler.a.f)), null, new d(this, productConfigurationFetchedEvent, d2, null), 2, null);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }
}
