package app.zophop.ui.fragments.superpassPurchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.Agency;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.FareBreakupComponent;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.ProductSubCategory;
import app.zophop.models.mTicketing.ProofUploadDetails;
import app.zophop.models.mTicketing.SuperPassProductConfigurationProperties;
import app.zophop.models.mTicketing.superPass.CashPaymentPendingTransactionDetails;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.SuperPassApplicationStatus;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassOrderDetails;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.pubsub.eventbus.events.CashPaymentInfoFetchedEvent;
import app.zophop.pubsub.eventbus.events.RazorPayOrderData;
import app.zophop.pubsub.eventbus.events.SuperPassApplicationSubmissionEvent;
import app.zophop.pubsub.eventbus.events.SuperPassOrderCreationEvent;
import app.zophop.ui.activities.CheckoutActivity;
import app.zophop.ui.activities.SuperPassCashPaymentWebViewActivity;
import app.zophop.ui.activities.SuperPassVerificationStatusActivity;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;
import com.razorpay.AnalyticsConstants;
import defpackage.ba1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: ConfirmSuperPassPurchaseFragment.kt */
public final class ConfirmSuperPassPurchaseFragment extends ul0<lx> {
    public static final /* synthetic */ int k = 0;
    public final j56 g = h.B(this, z86.a(SuperPassPurchaseSharedViewModel.class), new d(this), new e(this));
    public ba1 h;
    public gv0 i;
    public r<Intent> j;

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

    /* compiled from: ConfirmSuperPassPurchaseFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ ConfirmSuperPassPurchaseFragment f;
        public final /* synthetic */ Bundle g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment, Bundle bundle) {
            super(0);
            this.f = confirmSuperPassPurchaseFragment;
            this.g = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new ba1.a(this.f, this.g);
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

    public static final void i(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment, boolean z) {
        ed1 ed1;
        if (z) {
            ed1 = new ed1("terms accept", Long.MIN_VALUE);
        } else {
            ed1 = new ed1("terms cancel", Long.MIN_VALUE);
        }
        confirmSuperPassPurchaseFragment.k(ed1);
        ui1.m0(ed1);
    }

    @Override // defpackage.rl0
    public qo e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_confirm_super_pass_purchase, (ViewGroup) null, false);
        int i2 = R.id.activation_text;
        TextView textView = (TextView) inflate.findViewById(R.id.activation_text);
        if (textView != null) {
            i2 = R.id.bottom_sheet_confirm;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bottom_sheet_confirm);
            if (linearLayout != null) {
                i2 = R.id.bottomsheet_fare_amount;
                TextView textView2 = (TextView) inflate.findViewById(R.id.bottomsheet_fare_amount);
                if (textView2 != null) {
                    i2 = R.id.btn_expand_fare_split;
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_expand_fare_split);
                    if (imageView != null) {
                        i2 = R.id.btn_submit;
                        TextView textView3 = (TextView) inflate.findViewById(R.id.btn_submit);
                        if (textView3 != null) {
                            i2 = R.id.component_divider_1;
                            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.component_divider_1);
                            if (linearLayout2 != null) {
                                i2 = R.id.component_divider_2;
                                LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.component_divider_2);
                                if (linearLayout3 != null) {
                                    i2 = R.id.component_divider_3;
                                    LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.component_divider_3);
                                    if (linearLayout4 != null) {
                                        i2 = R.id.edit_pass_start_date;
                                        TextView textView4 = (TextView) inflate.findViewById(R.id.edit_pass_start_date);
                                        if (textView4 != null) {
                                            i2 = R.id.fare_details_layout;
                                            LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.fare_details_layout);
                                            if (linearLayout5 != null) {
                                                i2 = R.id.fare_split_layout;
                                                LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.fare_split_layout);
                                                if (linearLayout6 != null) {
                                                    i2 = R.id.fare_split_title;
                                                    LinearLayout linearLayout7 = (LinearLayout) inflate.findViewById(R.id.fare_split_title);
                                                    if (linearLayout7 != null) {
                                                        i2 = R.id.guideline_left;
                                                        Guideline guideline = (Guideline) inflate.findViewById(R.id.guideline_left);
                                                        if (guideline != null) {
                                                            i2 = R.id.guideline_right;
                                                            Guideline guideline2 = (Guideline) inflate.findViewById(R.id.guideline_right);
                                                            if (guideline2 != null) {
                                                                i2 = R.id.pass_start_date;
                                                                TextView textView5 = (TextView) inflate.findViewById(R.id.pass_start_date);
                                                                if (textView5 != null) {
                                                                    i2 = R.id.product_duration_category_name;
                                                                    TextView textView6 = (TextView) inflate.findViewById(R.id.product_duration_category_name);
                                                                    if (textView6 != null) {
                                                                        i2 = R.id.product_name;
                                                                        TextView textView7 = (TextView) inflate.findViewById(R.id.product_name);
                                                                        if (textView7 != null) {
                                                                            i2 = R.id.ride_details;
                                                                            TextView textView8 = (TextView) inflate.findViewById(R.id.ride_details);
                                                                            if (textView8 != null) {
                                                                                i2 = R.id.subcategory_info_note;
                                                                                TextView textView9 = (TextView) inflate.findViewById(R.id.subcategory_info_note);
                                                                                if (textView9 != null) {
                                                                                    i2 = R.id.title_text;
                                                                                    TextView textView10 = (TextView) inflate.findViewById(R.id.title_text);
                                                                                    if (textView10 != null) {
                                                                                        i2 = R.id.uploaded_proofs_recycler_view;
                                                                                        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.uploaded_proofs_recycler_view);
                                                                                        if (recyclerView != null) {
                                                                                            i2 = R.id.user_name;
                                                                                            TextView textView11 = (TextView) inflate.findViewById(R.id.user_name);
                                                                                            if (textView11 != null) {
                                                                                                lx lxVar = new lx((RelativeLayout) inflate, textView, linearLayout, textView2, imageView, textView3, linearLayout2, linearLayout3, linearLayout4, textView4, linearLayout5, linearLayout6, linearLayout7, guideline, guideline2, textView5, textView6, textView7, textView8, textView9, textView10, recyclerView, textView11);
                                                                                                n86.d(lxVar, "inflate(layoutInflater)");
                                                                                                return lxVar;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // defpackage.ul0
    public void f() {
        Bundle bundle = new Bundle();
        if ((!n86.a(l().f, "flowFreshPurchase") || !l().g) && !n86.a(l().f, "flowReapplication") && !n86.a(l().f, "flowPaymentModeChangedNoVerification")) {
            bundle.putBoolean("keyIsFareLayoutExpanded", true);
        } else {
            bundle.putBoolean("keyIsFareLayoutExpanded", true);
        }
        bundle.putLong("keyPassStartTime", l().m);
        this.h = (ba1) ((ai) h.B(this, z86.a(ba1.class), new b(new a(this)), new c(this, bundle))).getValue();
    }

    @Override // defpackage.ul0
    public void g() {
        ba1 ba1 = this.h;
        if (ba1 != null) {
            Object value = ba1.e.getValue();
            n86.d(value, "<get-passStartTime>(...)");
            ((LiveData) value).f(getViewLifecycleOwner(), new o41(this));
            ba1 ba12 = this.h;
            if (ba12 != null) {
                Object value2 = ba12.d.getValue();
                n86.d(value2, "<get-isFareLayoutExpanded>(...)");
                ((LiveData) value2).f(getViewLifecycleOwner(), new r41(this));
                ba1 ba13 = this.h;
                if (ba13 != null) {
                    Object value3 = ba13.g.getValue();
                    n86.d(value3, "<get-shouldShowLoader>(...)");
                    ((LiveData) value3).f(getViewLifecycleOwner(), new s41(this));
                    return;
                }
                n86.l("viewModel");
                throw null;
            }
            n86.l("viewModel");
            throw null;
        }
        n86.l("viewModel");
        throw null;
    }

    @Override // defpackage.ul0
    public void h() {
        ve activity;
        String str = l().f;
        if (n86.a(str, "flowPaymentPostVerification")) {
            T t = this.f;
            n86.c(t);
            ((lx) t).n.setText(getString(R.string.confirmation_fragment_title_successful_verification_payment));
        } else if (n86.a(str, "flowRenewPass")) {
            T t2 = this.f;
            n86.c(t2);
            ((lx) t2).n.setText(getString(R.string.confirmation_fragment_title_no_verification_payment));
        } else if (l().g) {
            T t3 = this.f;
            n86.c(t3);
            ((lx) t3).n.setText(getString(R.string.confirmation_fragment_title_submit_proofs));
        } else {
            T t4 = this.f;
            n86.c(t4);
            ((lx) t4).n.setText(getString(R.string.confirmation_fragment_title_no_verification_payment));
        }
        int i2 = 8;
        if (n86.a(l().f, "flowPaymentPostVerification") || n86.a(l().f, "flowRenewPass") || !l().g) {
            T t5 = this.f;
            n86.c(t5);
            TextView textView = ((lx) t5).p;
            n86.d(textView, "viewBinding.userName");
            textView.setVisibility(8);
            T t6 = this.f;
            n86.c(t6);
            LinearLayout linearLayout = ((lx) t6).e;
            n86.d(linearLayout, "viewBinding.componentDivider1");
            linearLayout.setVisibility(8);
        } else {
            T t7 = this.f;
            n86.c(t7);
            TextView textView2 = ((lx) t7).p;
            n86.d(textView2, "viewBinding.userName");
            textView2.setVisibility(0);
            T t8 = this.f;
            n86.c(t8);
            LinearLayout linearLayout2 = ((lx) t8).e;
            n86.d(linearLayout2, "viewBinding.componentDivider1");
            linearLayout2.setVisibility(0);
            T t9 = this.f;
            n86.c(t9);
            ((lx) t9).p.setText(l().k.getFullName());
        }
        if (n86.a(l().f, "flowPaymentPostVerification") || n86.a(l().f, "flowRenewPass") || !l().g) {
            T t10 = this.f;
            n86.c(t10);
            RecyclerView recyclerView = ((lx) t10).o;
            n86.d(recyclerView, "viewBinding.uploadedProofsRecyclerView");
            recyclerView.setVisibility(8);
        } else {
            T t11 = this.f;
            n86.c(t11);
            RecyclerView recyclerView2 = ((lx) t11).o;
            n86.d(recyclerView2, "viewBinding.uploadedProofsRecyclerView");
            recyclerView2.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            Map<String, ProofUploadDetails> d2 = l().d().d();
            if (d2 != null) {
                for (Map.Entry<String, ProofUploadDetails> entry : d2.entrySet()) {
                    ProofUploadDetails value = entry.getValue();
                    if (value.isFreshUpload()) {
                        arrayList.add(value);
                    }
                }
            }
            ru ruVar = new ru(c(), arrayList, new x51(this));
            T t12 = this.f;
            n86.c(t12);
            RecyclerView recyclerView3 = ((lx) t12).o;
            recyclerView3.setAdapter(ruVar);
            c();
            recyclerView3.setLayoutManager(new LinearLayoutManager(0, false));
            recyclerView3.setHasFixedSize(true);
        }
        BookableSuperPassConfiguration bookableSuperPassConfiguration = l().l;
        SuperPassProductConfigurationProperties superPassProductConfigurationProperties = bookableSuperPassConfiguration.getSuperPassProductConfigurationProperties();
        ProductFareMapping selectedProductFareMapping = bookableSuperPassConfiguration.getSelectedProductFareMapping();
        T t13 = this.f;
        n86.c(t13);
        ((lx) t13).k.setText(superPassProductConfigurationProperties.getProductName());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ui1.j(String.valueOf(selectedProductFareMapping.getNoOfDays())));
        spannableStringBuilder.append((CharSequence) ",");
        spannableStringBuilder.append((CharSequence) " ");
        List<String> specialFeatures = selectedProductFareMapping.getSpecialFeatures();
        if (!(specialFeatures == null || specialFeatures.isEmpty()) && (activity = c()) != null) {
            spannableStringBuilder.append((CharSequence) f71.f1097a.d(activity, selectedProductFareMapping.getSpecialFeatures()));
        }
        spannableStringBuilder.append((CharSequence) bookableSuperPassConfiguration.getSelectedProductCategory().get_categoryName());
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) getResources().getString(R.string.category));
        T t14 = this.f;
        n86.c(t14);
        ((lx) t14).j.setText(spannableStringBuilder);
        if (n86.a(superPassProductConfigurationProperties.getProductSubType(), SuperPassConstants.SUBTYPE_RIDE_PASS)) {
            T t15 = this.f;
            n86.c(t15);
            lx lxVar = (lx) t15;
            TextView textView3 = lxVar.m;
            n86.d(textView3, "subcategoryInfoNote");
            ProductSubCategory selectedSubCategory = bookableSuperPassConfiguration.getSelectedSubCategory();
            String infoNote = selectedSubCategory == null ? null : selectedSubCategory.getInfoNote();
            textView3.setVisibility((infoNote == null || infoNote.length() == 0) ^ true ? 0 : 8);
            TextView textView4 = lxVar.l;
            n86.d(textView4, "rideDetails");
            String desc = selectedProductFareMapping.getDesc();
            if (true ^ (desc == null || desc.length() == 0)) {
                i2 = 0;
            }
            textView4.setVisibility(i2);
            TextView textView5 = lxVar.m;
            ProductSubCategory selectedSubCategory2 = bookableSuperPassConfiguration.getSelectedSubCategory();
            textView5.setText(selectedSubCategory2 == null ? null : selectedSubCategory2.getInfoNote());
            lxVar.l.setText(selectedProductFareMapping.getDesc());
        } else if (n86.a(superPassProductConfigurationProperties.getProductSubType(), "magicPass")) {
            T t16 = this.f;
            n86.c(t16);
            TextView textView6 = ((lx) t16).l;
            n86.d(textView6, "viewBinding.rideDetails");
            textView6.setVisibility(8);
            T t17 = this.f;
            n86.c(t17);
            TextView textView7 = ((lx) t17).m;
            n86.d(textView7, "viewBinding.subcategoryInfoNote");
            textView7.setVisibility(8);
        }
        T t18 = this.f;
        n86.c(t18);
        ((lx) t18).i.setText(jh1.d(l().m));
        T t19 = this.f;
        n86.c(t19);
        ((lx) t19).f.setOnClickListener(new p41(this));
        for (FareBreakupComponent fareBreakupComponent : l().l.getSelectedProductFareMapping().getFareInfo().getFareBreakupComponentList()) {
            bx b2 = bx.b(getLayoutInflater());
            n86.d(b2, "inflate(layoutInflater)");
            b2.c.setText(fareBreakupComponent.getDisplayName());
            b2.b.setText(fareBreakupComponent.getAmountName());
            T t20 = this.f;
            n86.c(t20);
            ((lx) t20).h.addView(b2.f485a);
        }
        T t21 = this.f;
        n86.c(t21);
        ((lx) t21).g.setOnClickListener(new m41(this));
        T t22 = this.f;
        n86.c(t22);
        ((lx) t22).b.setText(n86.j(ui1.H(), l().l.getSelectedProductFareMapping().getFareInfo().getPayableAmountString()));
        if (n86.a(l().f, "flowPaymentPostVerification") || n86.a(l().f, "flowRenewPass")) {
            T t23 = this.f;
            n86.c(t23);
            ((lx) t23).d.setText(getString(R.string.make_payment_caps));
            n();
            T t24 = this.f;
            n86.c(t24);
            ((lx) t24).d.setOnClickListener(new n41(this));
        } else if (!l().g) {
            T t25 = this.f;
            n86.c(t25);
            ((lx) t25).d.setText(getString(R.string.make_payment_caps));
            n();
            T t26 = this.f;
            n86.c(t26);
            ((lx) t26).d.setOnClickListener(new t41(this));
        } else {
            T t27 = this.f;
            n86.c(t27);
            ((lx) t27).d.setText(getString(R.string.submit_for_verification));
            zz zzVar = new zz("proof submission for verification screen open", null, 2);
            zzVar.a("source", l().e);
            ui1.l0(zzVar);
            T t28 = this.f;
            n86.c(t28);
            ((lx) t28).d.setOnClickListener(new q41(this));
        }
    }

    public final void j(ed1 ed1) {
        BookableSuperPassConfiguration bookableSuperPassConfiguration = l().l;
        ed1.a("productType", bookableSuperPassConfiguration.getSuperPassProductConfigurationProperties().getProductType());
        ed1.a("productSubType", bookableSuperPassConfiguration.getSuperPassProductConfigurationProperties().getProductSubType());
        ed1.a("passengerType", bookableSuperPassConfiguration.getSelectedProductCategory().getCategoryId());
        ed1.a("noOfDays", String.valueOf(bookableSuperPassConfiguration.getSelectedProductFareMapping().getNoOfDays()));
        ed1.a(SuperPassJsonKeys.PASS_FARE, Double.valueOf(bookableSuperPassConfiguration.getSelectedProductFareMapping().getFareInfo().getActualFare()));
        ed1.a("payable fare", Double.valueOf(bookableSuperPassConfiguration.getSelectedProductFareMapping().getFareInfo().getPayableAmount()));
        ed1.a("startDate", jh1.c(l().m));
    }

    public final void k(ed1 ed1) {
        ed1.a("source", "confirmMpassPurchaseFragment");
        ed1.a(AnalyticsConstants.FLOW, l().f);
        ed1.a("isSuperPass", Boolean.TRUE);
    }

    public final SuperPassPurchaseSharedViewModel l() {
        return (SuperPassPurchaseSharedViewModel) this.g.getValue();
    }

    public final void m(boolean z, String str) {
        ed1 ed1;
        if (z) {
            ed1 = hj1.l("mPass cash payment option selected", Long.MIN_VALUE, SuperPassJsonKeys.REFERENCE_ID, str);
        } else {
            ed1 = hj1.l("mPass cash payment option selected", Long.MIN_VALUE, "failureReason", str);
        }
        k(ed1);
        ui1.m0(ed1);
    }

    public final void n() {
        zz zzVar = new zz("confirm payment screen open", null, 2);
        zzVar.a("source", l().e);
        ui1.l0(zzVar);
    }

    public final void o() {
        ed1 ed1 = new ed1("mPass confirm purchase pay btn clicked", Long.MIN_VALUE);
        j(ed1);
        k(ed1);
        ui1.m0(ed1);
        zz zzVar = new zz("make payment clicked", null, 2);
        zzVar.a("product type", l().l.getSuperPassProductConfigurationProperties().getProductType());
        zzVar.a("product subType", l().l.getSuperPassProductConfigurationProperties().getProductSubType());
        ui1.l0(zzVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        super.onAttach(context);
        r<Intent> registerForActivityResult = registerForActivityResult(new w(), new u41(this));
        n86.d(registerForActivityResult, "registerForActivityResul…\n            }\n\n        }");
        this.j = registerForActivityResult;
    }

    public final void onEvent(SuperPassApplicationSubmissionEvent superPassApplicationSubmissionEvent) {
        String str;
        n86.e(superPassApplicationSubmissionEvent, "lSuperPassApplicationSubmissionEvent");
        ba1 ba1 = this.h;
        if (ba1 == null) {
            n86.l("viewModel");
            throw null;
        } else if (ba1.f) {
            jz5.b().m(superPassApplicationSubmissionEvent);
            ba1 ba12 = this.h;
            if (ba12 != null) {
                ba12.d(false);
                if (superPassApplicationSubmissionEvent.getResponseType() == ad1.FAILED) {
                    if (superPassApplicationSubmissionEvent.getMessage().length() == 0) {
                        str = getString(R.string.something_bad_happened);
                    } else {
                        str = superPassApplicationSubmissionEvent.getMessage();
                    }
                    n86.d(str, "if (lSuperPassApplicatio…ent.message\n            }");
                    ve activity = c();
                    if (activity != null) {
                        Toast.makeText(activity, str, 0).show();
                    }
                    p(false);
                }
                if (superPassApplicationSubmissionEvent.getResponseType() == ad1.SUCCESS) {
                    ba1 ba13 = this.h;
                    if (ba13 != null) {
                        ba13.f = false;
                        SuperPassApplication.Companion companion = SuperPassApplication.Companion;
                        BookableSuperPassConfiguration bookableSuperPassConfiguration = l().l;
                        long j2 = l().m;
                        long j3 = l().n;
                        Agency agency = l().t;
                        n86.c(agency);
                        String agencyName = agency.getAgencyName();
                        n86.d(agencyName, "sharedViewModel.agency!!.agencyName");
                        SuperPassApplication convertBookableConfigToSuperPassApplication$default = SuperPassApplication.Companion.convertBookableConfigToSuperPassApplication$default(companion, bookableSuperPassConfiguration, j2, j3, agencyName, l().k, SuperPassApplicationStatus.UNVERIFIED, l().g(), l().u, null, 256, null);
                        p(true);
                        ve activity2 = c();
                        if (activity2 != null) {
                            xt.f3961a.e0().insertSuperPassApplication(convertBookableConfigToSuperPassApplication$default);
                            SuperPassVerificationStatusActivity.v0(activity2, convertBookableConfigToSuperPassApplication$default, "sourceSuperPassPurchaseFragment");
                            return;
                        }
                        return;
                    }
                    n86.l("viewModel");
                    throw null;
                }
                return;
            }
            n86.l("viewModel");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public final void p(boolean z) {
        ed1 ed1;
        if (z) {
            ed1 = new ed1("application submit success", Long.MIN_VALUE);
        } else {
            ed1 = new ed1("application submit failure", Long.MIN_VALUE);
        }
        j(ed1);
        k(ed1);
        ui1.m0(ed1);
    }

    public final void onEvent(SuperPassOrderCreationEvent superPassOrderCreationEvent) {
        n86.e(superPassOrderCreationEvent, "lEvent");
        jz5.b().m(superPassOrderCreationEvent);
        ba1 ba1 = this.h;
        if (ba1 != null) {
            boolean z = false;
            ba1.d(false);
            if (superPassOrderCreationEvent.getResponseType() == ad1.SUCCESS) {
                SuperPassOrderDetails superPassOrderDetails = superPassOrderCreationEvent.getSuperPassOrderDetails();
                if (superPassOrderDetails != null) {
                    SuperPassPurchaseSharedViewModel l = l();
                    Objects.requireNonNull(l);
                    n86.e(superPassOrderDetails, "lSuperPassOrderDetails");
                    l.q = superPassOrderDetails;
                    l.c.b("keySuperPassOrderDetails", superPassOrderDetails);
                    if (n86.a(l.l.getSuperPassProductConfigurationProperties().getProductSubType(), SuperPassConstants.SUBTYPE_RIDE_PASS)) {
                        xt.f3961a.e0().createFreshEntryInRideBasedSuperPassRideDetailsRoomPostPurchase(superPassOrderDetails.getTransactionId());
                    }
                    ed1 l2 = hj1.l("mPass order created", Long.MIN_VALUE, SuperPassJsonKeys.ORDER_ID, superPassOrderDetails.getRazorPayOrderData().get_orderId());
                    j(l2);
                    k(l2);
                    ui1.m0(l2);
                    RazorPayOrderData razorPayOrderData = superPassOrderDetails.getRazorPayOrderData();
                    ve activity = c();
                    if (activity != null) {
                        String str = razorPayOrderData.get_orderId();
                        String X = hj1.X(new StringBuilder(), (int) razorPayOrderData.get_amount(), "");
                        BookableSuperPassConfiguration bookableSuperPassConfiguration = l().l;
                        SuperPassOrderDetails superPassOrderDetails2 = l().q;
                        SuperPassUserDetails superPassUserDetails = l().k;
                        if (l().l.getSelectedProductFareMapping().getNoOfDays() > 1) {
                            z = true;
                        }
                        String merchantKey = razorPayOrderData.getMerchantKey();
                        int i2 = CheckoutActivity.d0;
                        Bundle c2 = hj1.c("currency", "INR", AnalyticsConstants.ORDER_ID, str);
                        c2.putString(AnalyticsConstants.AMOUNT, X);
                        c2.putBoolean("arg_isSuperPassBookingFlow", true);
                        c2.putParcelable("arg_bookableSuperPassConfig", bookableSuperPassConfiguration);
                        c2.putParcelable("arg_superPassOrderDetails", superPassOrderDetails2);
                        c2.putParcelable("arg_superPassUserDetails", superPassUserDetails);
                        c2.putBoolean("arg_isCashPaymentAllowedForSuperPass", z);
                        c2.putBoolean("lpEligible", superPassOrderDetails2.isLPEligible());
                        c2.putString("eligibilityResponseId", superPassOrderDetails2.getLPEligibilityResponseId());
                        c2.putString(AnalyticsConstants.MERCHANT_KEY, merchantKey);
                        c2.putParcelableArrayList("card_details", (ArrayList) superPassOrderDetails2.getCardDetailsList());
                        Intent intent = new Intent(activity, CheckoutActivity.class);
                        intent.addFlags(67108864);
                        intent.putExtra("src", "sourceSuperPassPurchaseFragment");
                        intent.putExtras(c2);
                        r<Intent> rVar = this.j;
                        if (rVar != null) {
                            rVar.a(intent, null);
                        } else {
                            n86.l("checkoutActivityResultLauncher");
                            throw null;
                        }
                    }
                }
            } else {
                ed1 l3 = hj1.l("mPass order creation failed", Long.MIN_VALUE, "failureReason", superPassOrderCreationEvent.getMessage());
                j(l3);
                k(l3);
                ui1.m0(l3);
                if (!TextUtils.isEmpty(superPassOrderCreationEvent.getMessage())) {
                    Toast.makeText(c(), superPassOrderCreationEvent.getMessage(), 1).show();
                } else {
                    Toast.makeText(c(), "something went wrong", 1).show();
                }
            }
        } else {
            n86.l("viewModel");
            throw null;
        }
    }

    public final void onEvent(CashPaymentInfoFetchedEvent cashPaymentInfoFetchedEvent) {
        n86.e(cashPaymentInfoFetchedEvent, "lEvent");
        jz5.b().m(cashPaymentInfoFetchedEvent);
        ba1 ba1 = this.h;
        if (ba1 != null) {
            ba1.d(false);
            if (cashPaymentInfoFetchedEvent.getResponseType() == ad1.SUCCESS) {
                SuperPassPurchaseSharedViewModel l = l();
                String referenceId = cashPaymentInfoFetchedEvent.getReferenceId();
                double amount = cashPaymentInfoFetchedEvent.getAmount();
                Objects.requireNonNull(l);
                n86.e(referenceId, "lReferenceId");
                l.r = referenceId;
                l.c.b("keyReferenceIdForCashPayment", referenceId);
                CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails = new CashPaymentPendingTransactionDetails(amount, l.r);
                SuperPassApplication.Companion companion = SuperPassApplication.Companion;
                BookableSuperPassConfiguration bookableSuperPassConfiguration = l.l;
                long j2 = l.m;
                long j3 = l.n;
                Agency agency = l.t;
                n86.c(agency);
                String agencyName = agency.getAgencyName();
                n86.d(agencyName, "agency!!.agencyName");
                SuperPassApplication convertBookableConfigToSuperPassApplication = companion.convertBookableConfigToSuperPassApplication(bookableSuperPassConfiguration, j2, j3, agencyName, l.k, SuperPassApplicationStatus.PAYMENT_PENDING, l.g(), l.u, cashPaymentPendingTransactionDetails);
                xt.f3961a.e0().insertSuperPassApplication(convertBookableConfigToSuperPassApplication);
                m(true, cashPaymentInfoFetchedEvent.getReferenceId());
                ve activity = c();
                if (activity != null) {
                    SuperPassCashPaymentWebViewActivity.l0("sourceSuperPassPurchaseFragment", convertBookableConfigToSuperPassApplication, l().l, activity);
                    return;
                }
                return;
            }
            ve activity2 = c();
            if (activity2 != null) {
                m(false, cashPaymentInfoFetchedEvent.getMessage());
                if (TextUtils.isEmpty(cashPaymentInfoFetchedEvent.getMessage())) {
                    Toast.makeText(activity2, "something went wrong", 1).show();
                } else {
                    Toast.makeText(activity2, cashPaymentInfoFetchedEvent.getMessage(), 1).show();
                }
            }
        } else {
            n86.l("viewModel");
            throw null;
        }
    }
}
