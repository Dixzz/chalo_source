package app.zophop.ui.fragments.superPassHistory;

import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;

/* compiled from: PendingSuperPassBookingSummaryFragment.kt */
public final class PendingSuperPassBookingSummaryFragment extends ul0<qx> {
    public static final /* synthetic */ int i = 0;
    public final j56 g = h.B(this, z86.a(u91.class), new d(this), new e(this));
    public s91 h;

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

    /* compiled from: PendingSuperPassBookingSummaryFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ PendingSuperPassBookingSummaryFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(PendingSuperPassBookingSummaryFragment pendingSuperPassBookingSummaryFragment) {
            super(0);
            this.f = pendingSuperPassBookingSummaryFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            ve activity = this.f.c();
            n86.c(activity);
            Application application = activity.getApplication();
            PendingSuperPassBookingSummaryFragment pendingSuperPassBookingSummaryFragment = this.f;
            Boolean bool = Boolean.FALSE;
            return new xh(application, pendingSuperPassBookingSummaryFragment, h.j(new m56("keyProofDocumentsExpansionState", bool), new m56("keyFareLayoutExpansionState", bool)));
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class d extends o86 implements h76<gi> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
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
    public static final class e extends o86 implements h76<ci> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
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

    @Override // defpackage.rl0
    public qo e() {
        qx b2 = qx.b(getLayoutInflater());
        n86.d(b2, "inflate(layoutInflater)");
        return b2;
    }

    @Override // defpackage.ul0
    public void f() {
        this.h = (s91) ((ai) h.B(this, z86.a(s91.class), new b(new a(this)), new c(this))).getValue();
    }

    @Override // defpackage.ul0
    public void g() {
        LiveData<PendingSuperPass> liveData = j().r;
        if (liveData != null) {
            liveData.f(getViewLifecycleOwner(), new bz0(this));
        }
        s91 s91 = this.h;
        if (s91 != null) {
            s91.f.f(getViewLifecycleOwner(), new az0(this));
            s91 s912 = this.h;
            if (s912 != null) {
                s912.h.f(getViewLifecycleOwner(), new zy0(this));
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

    public final void i(ed1 ed1, PendingSuperPass pendingSuperPass) {
        ed1.a("source", "pendingSuperPassBookingSummaryFragment");
        ed1.a("isSuperPass", Boolean.TRUE);
        ed1.a("passId", pendingSuperPass.getPendingSuperPassProperties().getPassId());
        ed1.a("productType", pendingSuperPass.getPendingSuperPassProperties().getProductType());
        ed1.a("productSubType", pendingSuperPass.getPendingSuperPassProperties().getProductSubType().toString());
        ed1.a(SuperPassJsonKeys.CATEGORY_ID, pendingSuperPass.getPendingSuperPassRepurchaseProperties().getCategoryId());
        ed1.a("fareMappingId", Integer.valueOf(pendingSuperPass.getPendingSuperPassRepurchaseProperties().getFareMappingId()));
        ed1.a("productId", pendingSuperPass.getPendingSuperPassRepurchaseProperties().getConfigId());
        ed1.a("productName", pendingSuperPass.getPendingSuperPassUIProperties().getPassName());
        ed1.a(SuperPassJsonKeys.VERIFICATION_FLAG, Boolean.valueOf(pendingSuperPass.getPendingSuperPassRepurchaseProperties().getVerificationFlag()));
        ed1.a(SuperPassJsonKeys.VERIFICATION_EXPIRY_TIME, jh1.c(pendingSuperPass.getPendingSuperPassRepurchaseProperties().getVerificationExpiryTime()));
        ed1.a("paymentMode", pendingSuperPass.getPendingSuperPassTransactionDetails().getPaymentMode());
        ed1.a(SuperPassJsonKeys.ORDER_ID, pendingSuperPass.getPendingSuperPassTransactionDetails().getOrderId());
        ed1.a("startDate", jh1.c(pendingSuperPass.getPendingSuperPassRepurchaseProperties().getStartTime()));
    }

    public final u91 j() {
        return (u91) this.g.getValue();
    }
}
