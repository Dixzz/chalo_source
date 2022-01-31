package app.zophop.ui.fragments.superPassHistory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.FareBreakupComponent;
import app.zophop.models.mTicketing.FareInfo;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassProofProperties;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: SuperPassApplicationBookingSummaryFragment.kt */
public final class SuperPassApplicationBookingSummaryFragment extends ul0<qx> {
    public static final /* synthetic */ int i = 0;
    public final j56 g = h.B(this, z86.a(u91.class), new d(this), new e(this));
    public t91 h;

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

    /* compiled from: SuperPassApplicationBookingSummaryFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ SuperPassApplicationBookingSummaryFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SuperPassApplicationBookingSummaryFragment superPassApplicationBookingSummaryFragment) {
            super(0);
            this.f = superPassApplicationBookingSummaryFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            ve activity = this.f.c();
            n86.c(activity);
            return new xh(activity.getApplication(), this.f, h.j(new m56("keyProofDocumentsExpansionState", Boolean.FALSE)));
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
        this.h = (t91) ((ai) h.B(this, z86.a(t91.class), new b(new a(this)), new c(this))).getValue();
        ed1 ed1 = new ed1("superPassApplication Summary Fragment Opened", Long.MIN_VALUE);
        i(ed1);
        ui1.m0(ed1);
    }

    @Override // defpackage.ul0
    public void g() {
        t91 t91 = this.h;
        if (t91 != null) {
            t91.f.f(this, new fz0(this));
            t91 t912 = this.h;
            if (t912 != null) {
                t912.h.f(getViewLifecycleOwner(), new ez0(this));
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
        ProductFareMapping selectedProductFareMapping;
        Map<String, SuperPassProofProperties> proofs;
        SuperPassUserDetails superPassUserDetails;
        T t = this.f;
        n86.c(t);
        ((qx) t).q.setImageDrawable(getResources().getDrawable(R.drawable.pending_pass_summary));
        T t2 = this.f;
        n86.c(t2);
        ((qx) t2).r.setText(getResources().getString(R.string.verification_pending));
        T t3 = this.f;
        n86.c(t3);
        TextView textView = ((qx) t3).o;
        n86.d(textView, "viewBinding.passExpiryDetails");
        textView.setVisibility(8);
        T t4 = this.f;
        n86.c(t4);
        CardView cardView = ((qx) t4).f;
        n86.d(cardView, "viewBinding.btnRenew");
        cardView.setVisibility(8);
        BookableSuperPassConfiguration bookableSuperPassConfiguration = j().o;
        FareInfo fareInfo = null;
        if (bookableSuperPassConfiguration != null) {
            SpannableStringBuilder d2 = f71.f1097a.d(requireContext(), bookableSuperPassConfiguration.getSelectedProductFareMapping().getSpecialFeatures());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) bookableSuperPassConfiguration.getSelectedProductFareMapping().getDurationDisplayName());
            spannableStringBuilder.append((CharSequence) ",");
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) bookableSuperPassConfiguration.getSelectedProductCategory().get_categoryName());
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) getResources().getString(R.string.category));
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) d2);
            T t5 = this.f;
            n86.c(t5);
            qx qxVar = (qx) t5;
            TextView textView2 = qxVar.p;
            SuperPassApplication superPassApplication = j().j;
            textView2.setText(superPassApplication == null ? null : superPassApplication.getPassName());
            qxVar.w.setText(spannableStringBuilder);
            TextView textView3 = qxVar.u;
            n86.d(textView3, "rideBasedPassFareLimitsDescription");
            textView3.setVisibility(8);
            TextView textView4 = qxVar.v;
            n86.d(textView4, "rideBasedPassTripLimitsDescription");
            textView4.setVisibility(8);
        }
        SuperPassApplication superPassApplication2 = j().j;
        if (!(superPassApplication2 == null || (superPassUserDetails = superPassApplication2.getSuperPassUserDetails()) == null)) {
            T t6 = this.f;
            n86.c(t6);
            ((qx) t6).z.setText(superPassUserDetails.getFullName());
            T t7 = this.f;
            n86.c(t7);
            ((qx) t7).l.setText(superPassUserDetails.getGender().name());
            StringBuilder sb = new StringBuilder(getResources().getString(R.string.date_of_birth));
            sb.append(ProductDiscountsObject.KEY_DELIMITER);
            sb.append(" ");
            sb.append(superPassUserDetails.getDateOfBirth());
            T t8 = this.f;
            n86.c(t8);
            ((qx) t8).h.setText(sb);
            String profilePhoto = superPassUserDetails.getProfilePhoto();
            ml1<Drawable> p = gl1.f(requireContext()).p(profilePhoto);
            T t9 = this.f;
            n86.c(t9);
            p.e(((qx) t9).A);
            T t10 = this.f;
            n86.c(t10);
            ((qx) t10).A.setOnClickListener(new hz0(this, profilePhoto));
        }
        SuperPassApplication superPassApplication3 = j().j;
        if (!(superPassApplication3 == null || (proofs = superPassApplication3.getProofs()) == null)) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, SuperPassProofProperties> entry : proofs.entrySet()) {
                arrayList.add(entry.getValue());
            }
            T t11 = this.f;
            n86.c(t11);
            qx qxVar2 = (qx) t11;
            View view = qxVar2.i;
            n86.d(view, "divider");
            int i2 = 0;
            view.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
            LinearLayout linearLayout = qxVar2.B;
            n86.d(linearLayout, "viewDocumentsHeader");
            linearLayout.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
            RecyclerView recyclerView = qxVar2.t;
            n86.d(recyclerView, "proofDocumentsList");
            if (!(!arrayList.isEmpty())) {
                i2 = 8;
            }
            recyclerView.setVisibility(i2);
            if (!arrayList.isEmpty()) {
                Context requireContext = requireContext();
                n86.d(requireContext, "requireContext()");
                ti0 ti0 = new ti0(requireContext, arrayList, new f01(this));
                T t12 = this.f;
                n86.c(t12);
                ((qx) t12).t.setAdapter(ti0);
                T t13 = this.f;
                n86.c(t13);
                ((qx) t13).t.setLayoutManager(new GridLayoutManager(requireContext(), 2));
                T t14 = this.f;
                n86.c(t14);
                ((qx) t14).B.setOnClickListener(new iz0(this));
            }
        }
        BookableSuperPassConfiguration bookableSuperPassConfiguration2 = j().o;
        if (!(bookableSuperPassConfiguration2 == null || (selectedProductFareMapping = bookableSuperPassConfiguration2.getSelectedProductFareMapping()) == null)) {
            fareInfo = selectedProductFareMapping.getFareInfo();
        }
        if (fareInfo != null) {
            T t15 = this.f;
            n86.c(t15);
            ((qx) t15).x.setText(n86.j(ui1.H(), fareInfo.getPayableAmountString()));
            T t16 = this.f;
            n86.c(t16);
            ((qx) t16).j.removeAllViews();
            for (FareBreakupComponent fareBreakupComponent : fareInfo.getFareBreakupComponentList()) {
                bx b2 = bx.b(getLayoutInflater());
                n86.d(b2, "inflate(layoutInflater)");
                b2.c.setText(fareBreakupComponent.getDisplayName());
                b2.b.setText(fareBreakupComponent.getAmountName());
                T t17 = this.f;
                n86.c(t17);
                ((qx) t17).j.addView(b2.f485a);
            }
            T t18 = this.f;
            n86.c(t18);
            ((qx) t18).k.setOnClickListener(new gz0(this));
        }
        T t19 = this.f;
        n86.c(t19);
        CardView cardView2 = ((qx) t19).y;
        n86.d(cardView2, "viewBinding.transactionDetailsLayout");
        cardView2.setVisibility(8);
    }

    public final void i(ed1 ed1) {
        ed1.a("source", "superPassApplicationBookingSummaryFragment");
        ed1.a("isSuperPass", Boolean.TRUE);
        SuperPassApplication superPassApplication = j().j;
        if (superPassApplication != null) {
            ed1.a(SuperPassJsonKeys.CATEGORY_ID, superPassApplication.getCategoryId());
            ed1.a("fareMappingId", Integer.valueOf(superPassApplication.getFareMappingId()));
            ed1.a("productId", superPassApplication.getConfigId());
            ed1.a("productName", superPassApplication.getPassName());
            ed1.a("startDate", jh1.c(superPassApplication.getPassStartDate()));
        }
    }

    public final u91 j() {
        return (u91) this.g.getValue();
    }
}
