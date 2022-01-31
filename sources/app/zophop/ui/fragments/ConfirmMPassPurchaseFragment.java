package app.zophop.ui.fragments;

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
import app.zophop.models.CardDetails;
import app.zophop.models.City;
import app.zophop.models.mTicketing.BookingTransaction;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.ProofUploadDetails;
import app.zophop.models.mTicketing.RouteStopsInfo;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassPaymentConstants;
import app.zophop.pubsub.eventbus.events.BookingTransactionEvent;
import app.zophop.pubsub.eventbus.events.CashPaymentEvent;
import app.zophop.pubsub.eventbus.events.RazorPayOrderData;
import app.zophop.pubsub.eventbus.events.RazorPayVerificationStatus;
import app.zophop.pubsub.eventbus.events.UserProfileEvent;
import app.zophop.ui.activities.ActivatePassScreen;
import app.zophop.ui.activities.CashWebViewActivity;
import app.zophop.ui.activities.CheckoutActivity;
import app.zophop.ui.activities.MPassVerificationStatusActivity;
import com.razorpay.AnalyticsConstants;
import defpackage.c81;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: ConfirmMPassPurchaseFragment.kt */
public final class ConfirmMPassPurchaseFragment extends ul0<kx> {
    public static final /* synthetic */ int k = 0;
    public final j56 g = h.B(this, z86.a(p81.class), new d(this), new e(this));
    public c81 h;
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

    /* compiled from: ConfirmMPassPurchaseFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ ConfirmMPassPurchaseFragment f;
        public final /* synthetic */ Bundle g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment, Bundle bundle) {
            super(0);
            this.f = confirmMPassPurchaseFragment;
            this.g = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new c81.a(this.f, this.g);
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

    public static final void i(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment, boolean z) {
        ed1 ed1;
        if (z) {
            ed1 = new ed1("terms accept", Long.MIN_VALUE);
        } else {
            ed1 = new ed1("terms cancel", Long.MIN_VALUE);
        }
        confirmMPassPurchaseFragment.j(ed1);
        ui1.m0(ed1);
    }

    @Override // defpackage.rl0
    public qo e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_confirm_mpass_purchase, (ViewGroup) null, false);
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
                                        i2 = R.id.discount_amount;
                                        TextView textView4 = (TextView) inflate.findViewById(R.id.discount_amount);
                                        if (textView4 != null) {
                                            i2 = R.id.discount_layout;
                                            LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.discount_layout);
                                            if (linearLayout5 != null) {
                                                i2 = R.id.edit_pass_start_date;
                                                TextView textView5 = (TextView) inflate.findViewById(R.id.edit_pass_start_date);
                                                if (textView5 != null) {
                                                    i2 = R.id.fare_details_layout;
                                                    LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.fare_details_layout);
                                                    if (linearLayout6 != null) {
                                                        i2 = R.id.fare_split_layout;
                                                        LinearLayout linearLayout7 = (LinearLayout) inflate.findViewById(R.id.fare_split_layout);
                                                        if (linearLayout7 != null) {
                                                            i2 = R.id.fare_split_title;
                                                            LinearLayout linearLayout8 = (LinearLayout) inflate.findViewById(R.id.fare_split_title);
                                                            if (linearLayout8 != null) {
                                                                i2 = R.id.first_stop_name;
                                                                TextView textView6 = (TextView) inflate.findViewById(R.id.first_stop_name);
                                                                if (textView6 != null) {
                                                                    i2 = R.id.guideline_left;
                                                                    Guideline guideline = (Guideline) inflate.findViewById(R.id.guideline_left);
                                                                    if (guideline != null) {
                                                                        i2 = R.id.guideline_right;
                                                                        Guideline guideline2 = (Guideline) inflate.findViewById(R.id.guideline_right);
                                                                        if (guideline2 != null) {
                                                                            i2 = R.id.last_stop_name;
                                                                            TextView textView7 = (TextView) inflate.findViewById(R.id.last_stop_name);
                                                                            if (textView7 != null) {
                                                                                i2 = R.id.pass_price;
                                                                                TextView textView8 = (TextView) inflate.findViewById(R.id.pass_price);
                                                                                if (textView8 != null) {
                                                                                    i2 = R.id.pass_start_date;
                                                                                    TextView textView9 = (TextView) inflate.findViewById(R.id.pass_start_date);
                                                                                    if (textView9 != null) {
                                                                                        i2 = R.id.product_duration_category_name;
                                                                                        TextView textView10 = (TextView) inflate.findViewById(R.id.product_duration_category_name);
                                                                                        if (textView10 != null) {
                                                                                            i2 = R.id.product_name;
                                                                                            TextView textView11 = (TextView) inflate.findViewById(R.id.product_name);
                                                                                            if (textView11 != null) {
                                                                                                i2 = R.id.ride_details;
                                                                                                TextView textView12 = (TextView) inflate.findViewById(R.id.ride_details);
                                                                                                if (textView12 != null) {
                                                                                                    i2 = R.id.route_layout;
                                                                                                    LinearLayout linearLayout9 = (LinearLayout) inflate.findViewById(R.id.route_layout);
                                                                                                    if (linearLayout9 != null) {
                                                                                                        i2 = R.id.route_number;
                                                                                                        TextView textView13 = (TextView) inflate.findViewById(R.id.route_number);
                                                                                                        if (textView13 != null) {
                                                                                                            i2 = R.id.special_feature_route;
                                                                                                            TextView textView14 = (TextView) inflate.findViewById(R.id.special_feature_route);
                                                                                                            if (textView14 != null) {
                                                                                                                i2 = R.id.title_text;
                                                                                                                TextView textView15 = (TextView) inflate.findViewById(R.id.title_text);
                                                                                                                if (textView15 != null) {
                                                                                                                    i2 = R.id.uploaded_proofs_recycler_view;
                                                                                                                    RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.uploaded_proofs_recycler_view);
                                                                                                                    if (recyclerView != null) {
                                                                                                                        i2 = R.id.user_name;
                                                                                                                        TextView textView16 = (TextView) inflate.findViewById(R.id.user_name);
                                                                                                                        if (textView16 != null) {
                                                                                                                            kx kxVar = new kx((RelativeLayout) inflate, textView, linearLayout, textView2, imageView, textView3, linearLayout2, linearLayout3, linearLayout4, textView4, linearLayout5, textView5, linearLayout6, linearLayout7, linearLayout8, textView6, guideline, guideline2, textView7, textView8, textView9, textView10, textView11, textView12, linearLayout9, textView13, textView14, textView15, recyclerView, textView16);
                                                                                                                            n86.d(kxVar, "inflate(layoutInflater)");
                                                                                                                            return kxVar;
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
        MPass mPass = k().g;
        if ((!n86.a(k().f, "flowFreshPurchase") || !mPass.is_isVerificationRequired()) && !n86.a(k().f, "flowReapplication")) {
            bundle.putBoolean("keyIsFareLayoutExpanded", true);
        } else {
            bundle.putBoolean("keyIsFareLayoutExpanded", true);
        }
        bundle.putLong("keyPassStartTime", mPass.getStartingTime());
        this.h = (c81) ((ai) h.B(this, z86.a(c81.class), new b(new a(this)), new c(this, bundle))).getValue();
    }

    @Override // defpackage.ul0
    public void g() {
        c81 c81 = this.h;
        if (c81 != null) {
            Object value = c81.e.getValue();
            n86.d(value, "<get-passStartTime>(...)");
            ((LiveData) value).f(getViewLifecycleOwner(), new uo0(this));
            c81 c812 = this.h;
            if (c812 != null) {
                Object value2 = c812.d.getValue();
                n86.d(value2, "<get-isFareLayoutExpanded>(...)");
                ((LiveData) value2).f(getViewLifecycleOwner(), new xo0(this));
                c81 c813 = this.h;
                if (c813 != null) {
                    Object value3 = c813.g.getValue();
                    n86.d(value3, "<get-shouldShowLoader>(...)");
                    ((LiveData) value3).f(getViewLifecycleOwner(), new qo0(this));
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
        String str;
        ve activity;
        String str2 = k().f;
        if (n86.a(str2, "flowPaymentPostVerification")) {
            T t = this.f;
            n86.c(t);
            ((kx) t).t.setText(getString(R.string.confirmation_fragment_title_successful_verification_payment));
        } else if (n86.a(str2, "flowRenewPass")) {
            T t2 = this.f;
            n86.c(t2);
            ((kx) t2).t.setText(getString(R.string.confirmation_fragment_title_no_verification_payment));
        } else if (k().g.is_isVerificationRequired()) {
            T t3 = this.f;
            n86.c(t3);
            ((kx) t3).t.setText(getString(R.string.confirmation_fragment_title_submit_proofs));
        } else {
            T t4 = this.f;
            n86.c(t4);
            ((kx) t4).t.setText(getString(R.string.confirmation_fragment_title_no_verification_payment));
        }
        if (n86.a(k().f, "flowPaymentPostVerification") || n86.a(k().f, "flowRenewPass") || !k().g.is_isVerificationRequired()) {
            T t5 = this.f;
            n86.c(t5);
            TextView textView = ((kx) t5).v;
            n86.d(textView, "viewBinding.userName");
            textView.setVisibility(8);
            T t6 = this.f;
            n86.c(t6);
            LinearLayout linearLayout = ((kx) t6).e;
            n86.d(linearLayout, "viewBinding.componentDivider1");
            linearLayout.setVisibility(8);
        } else {
            T t7 = this.f;
            n86.c(t7);
            TextView textView2 = ((kx) t7).v;
            n86.d(textView2, "viewBinding.userName");
            textView2.setVisibility(0);
            T t8 = this.f;
            n86.c(t8);
            LinearLayout linearLayout2 = ((kx) t8).e;
            n86.d(linearLayout2, "viewBinding.componentDivider1");
            linearLayout2.setVisibility(0);
            T t9 = this.f;
            n86.c(t9);
            TextView textView3 = ((kx) t9).v;
            UserProfile d2 = k().g().d();
            textView3.setText(d2 == null ? null : d2.getFirstName() + ' ' + ((Object) d2.getLastName()));
        }
        boolean z = true;
        if (n86.a(k().f, "flowPaymentPostVerification") || n86.a(k().f, "flowRenewPass") || !k().g.is_isVerificationRequired()) {
            T t10 = this.f;
            n86.c(t10);
            RecyclerView recyclerView = ((kx) t10).u;
            n86.d(recyclerView, "viewBinding.uploadedProofsRecyclerView");
            recyclerView.setVisibility(8);
        } else {
            T t11 = this.f;
            n86.c(t11);
            RecyclerView recyclerView2 = ((kx) t11).u;
            n86.d(recyclerView2, "viewBinding.uploadedProofsRecyclerView");
            recyclerView2.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            Map<String, ProofUploadDetails> d3 = k().e().d();
            if (d3 != null) {
                for (Map.Entry<String, ProofUploadDetails> entry : d3.entrySet()) {
                    ProofUploadDetails value = entry.getValue();
                    if (value.isFreshUpload()) {
                        arrayList.add(value);
                    }
                }
            }
            ru ruVar = new ru(c(), arrayList, new au0(this));
            T t12 = this.f;
            n86.c(t12);
            RecyclerView recyclerView3 = ((kx) t12).u;
            recyclerView3.setAdapter(ruVar);
            c();
            recyclerView3.setLayoutManager(new LinearLayoutManager(0, false));
            recyclerView3.setHasFixedSize(true);
        }
        MPass mPass = k().g;
        String passengerType = mPass.getPassengerType();
        ProductConfiguration productConfiguration = k().n;
        if (productConfiguration != null) {
            T t13 = this.f;
            n86.c(t13);
            TextView textView4 = ((kx) t13).p;
            String str3 = mPass.get_productName();
            if (str3 == null || str3.length() == 0) {
                str = productConfiguration.getProductName();
            } else {
                str = mPass.get_productName();
            }
            textView4.setText(str);
            if (n86.a(mPass.get_productType(), "superSaver")) {
                T t14 = this.f;
                n86.c(t14);
                TextView textView5 = ((kx) t14).q;
                Object[] objArr = new Object[1];
                ProductCategory productCategory = mPass.get_grouping();
                objArr[0] = productCategory == null ? null : Integer.valueOf(productCategory.get_maxPricePerRide());
                textView5.setText(getString(R.string.maxFareConfirmScreen, objArr));
                T t15 = this.f;
                n86.c(t15);
                TextView textView6 = ((kx) t15).q;
                n86.d(textView6, "viewBinding.rideDetails");
                textView6.setVisibility(productConfiguration.shouldHideSubCategorySelection() ^ true ? 0 : 8);
            } else {
                T t16 = this.f;
                n86.c(t16);
                TextView textView7 = ((kx) t16).q;
                n86.d(textView7, "viewBinding.rideDetails");
                textView7.setVisibility(8);
            }
            if (mPass.getRouteStopsInfo() != null) {
                RouteStopsInfo routeStopsInfo = mPass.getRouteStopsInfo();
                n86.d(routeStopsInfo, "lMPass.routeStopsInfo");
                n86.d(passengerType, "lCategoryId");
                MPass mPass2 = k().g;
                T t17 = this.f;
                n86.c(t17);
                LinearLayout linearLayout3 = ((kx) t17).r;
                n86.d(linearLayout3, "viewBinding.routeLayout");
                linearLayout3.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ui1.j(String.valueOf(mPass2.getNoOfDays())));
                spannableStringBuilder.append((CharSequence) ", ");
                spannableStringBuilder.append((CharSequence) xt.f3961a.c().F(passengerType));
                spannableStringBuilder.append((CharSequence) " Category");
                T t18 = this.f;
                n86.c(t18);
                ((kx) t18).o.setText(spannableStringBuilder);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(routeStopsInfo.getRouteName());
                T t19 = this.f;
                n86.c(t19);
                ((kx) t19).k.setText(routeStopsInfo.getStartStopName());
                T t20 = this.f;
                n86.c(t20);
                ((kx) t20).l.setText(routeStopsInfo.getEndStopName());
                List<String> specialFeatures = mPass2.getSpecialFeatures();
                if (specialFeatures != null && !specialFeatures.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    spannableStringBuilder2.append((CharSequence) " ");
                    ve activity2 = c();
                    if (activity2 != null) {
                        spannableStringBuilder2.append((CharSequence) ui1.J(activity2, mPass2.getSpecialFeatures()));
                        spannableStringBuilder2.append((CharSequence) " ");
                    }
                }
                T t21 = this.f;
                n86.c(t21);
                ((kx) t21).s.setText(spannableStringBuilder2);
            } else {
                T t22 = this.f;
                n86.c(t22);
                LinearLayout linearLayout4 = ((kx) t22).r;
                n86.d(linearLayout4, "viewBinding.routeLayout");
                linearLayout4.setVisibility(8);
                if (n86.a(mPass.get_productType(), "superSaver")) {
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(vn.n0(mPass.getConfigId(), mPass.get_grouping().getCategoryId(), ((long) (mPass.getNoOfDays() * 24 * 60 * 60)) * 1000).getDesc());
                    T t23 = this.f;
                    n86.c(t23);
                    ((kx) t23).o.setVisibility(0);
                    T t24 = this.f;
                    n86.c(t24);
                    ((kx) t24).o.setText(spannableStringBuilder3);
                } else {
                    SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(ui1.j(String.valueOf(mPass.getNoOfDays())));
                    spannableStringBuilder4.append((CharSequence) ", ");
                    List<String> specialFeatures2 = mPass.getSpecialFeatures();
                    if (specialFeatures2 != null && !specialFeatures2.isEmpty()) {
                        z = false;
                    }
                    if (!z && (activity = c()) != null) {
                        spannableStringBuilder4.append((CharSequence) ui1.J(activity, mPass.getSpecialFeatures()));
                        spannableStringBuilder4.append((CharSequence) " ");
                    }
                    spannableStringBuilder4.append((CharSequence) xt.f3961a.c().F(passengerType));
                    spannableStringBuilder4.append((CharSequence) " Category");
                    T t25 = this.f;
                    n86.c(t25);
                    ((kx) t25).o.setText(spannableStringBuilder4);
                }
            }
        }
        T t26 = this.f;
        n86.c(t26);
        ((kx) t26).n.setText(jh1.d(k().g.getStartingTime()));
        T t27 = this.f;
        n86.c(t27);
        ((kx) t27).h.setOnClickListener(new to0(this));
        ProductFareMapping productFareMapping = k().p;
        if (productFareMapping != null) {
            int fare = productFareMapping.getFare();
            T t28 = this.f;
            n86.c(t28);
            ((kx) t28).m.setText(n86.j(ui1.H(), Integer.valueOf(fare)));
            int discountFare = productFareMapping.getDiscountFare();
            int i2 = fare - discountFare;
            if (discountFare <= 0 || i2 <= 0) {
                T t29 = this.f;
                n86.c(t29);
                LinearLayout linearLayout5 = ((kx) t29).g;
                n86.d(linearLayout5, "viewBinding.discountLayout");
                linearLayout5.setVisibility(8);
            } else {
                T t30 = this.f;
                n86.c(t30);
                LinearLayout linearLayout6 = ((kx) t30).g;
                n86.d(linearLayout6, "viewBinding.discountLayout");
                linearLayout6.setVisibility(0);
                T t31 = this.f;
                n86.c(t31);
                ((kx) t31).f.setText(n86.j(ui1.H(), Integer.valueOf(i2)));
            }
        }
        T t32 = this.f;
        n86.c(t32);
        ((kx) t32).i.setOnClickListener(new vo0(this));
        T t33 = this.f;
        n86.c(t33);
        ((kx) t33).b.setText(n86.j(ui1.H(), Integer.valueOf((int) k().g.getFare())));
        MPass mPass3 = k().g;
        if (n86.a(k().f, "flowPaymentPostVerification") || n86.a(k().f, "flowRenewPass")) {
            T t34 = this.f;
            n86.c(t34);
            ((kx) t34).d.setText(getString(R.string.make_payment_caps));
            n();
            T t35 = this.f;
            n86.c(t35);
            ((kx) t35).d.setOnClickListener(new ro0(this));
        } else if (!mPass3.is_isVerificationRequired()) {
            T t36 = this.f;
            n86.c(t36);
            ((kx) t36).d.setText(getString(R.string.make_payment_caps));
            n();
            T t37 = this.f;
            n86.c(t37);
            ((kx) t37).d.setOnClickListener(new zo0(this, mPass3));
        } else {
            T t38 = this.f;
            n86.c(t38);
            ((kx) t38).d.setText(getString(R.string.submit_for_verification));
            zz zzVar = new zz("proof submission for verification screen open", null, 2);
            zzVar.a("source", k().e);
            ui1.l0(zzVar);
            T t39 = this.f;
            n86.c(t39);
            ((kx) t39).d.setOnClickListener(new yo0(this, mPass3));
        }
    }

    public final void j(ed1 ed1) {
        ed1.a("source", "confirmMpassPurchaseFragment");
        ed1.a(AnalyticsConstants.FLOW, k().f);
    }

    public final p81 k() {
        return (p81) this.g.getValue();
    }

    public final void l(boolean z, String str) {
        if (z) {
            k().g.setQrCode(str);
            xt.f3961a.c().S(k().g, false);
        }
        xt.f3961a.j().a();
        ve activity = c();
        if (activity != null) {
            ActivatePassScreen.i0(activity, k().g, null, true);
        }
    }

    public final void m(boolean z, String str) {
        ed1 ed1;
        if (z) {
            ed1 = hj1.l("mPass cash payment option selected", Long.MIN_VALUE, SuperPassJsonKeys.REFERENCE_ID, str);
        } else {
            ed1 = hj1.l("mPass cash payment option selected", Long.MIN_VALUE, "failureReason", str);
        }
        j(ed1);
        ui1.m0(ed1);
    }

    public final void n() {
        zz zzVar = new zz("confirm payment screen open", null, 2);
        zzVar.a("source", k().e);
        ui1.l0(zzVar);
    }

    public final void o() {
        MPass mPass = k().g;
        ed1 ed1 = new ed1("mPass confirm purchase pay btn clicked", Long.MIN_VALUE);
        ed1.a("passengerType", mPass.getPassengerType());
        ed1.a(SuperPassJsonKeys.FARE, String.valueOf(mPass.getFare()));
        ed1.a("noOfDays", String.valueOf(mPass.getNoOfDays()));
        ed1.a("startDate", jh1.c(mPass.getStartingTime()));
        j(ed1);
        ui1.m0(ed1);
        zz zzVar = new zz("make payment clicked", null, 2);
        zzVar.a("product type", mPass.get_bookingPassType());
        ui1.l0(zzVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        super.onAttach(context);
        r<Intent> registerForActivityResult = registerForActivityResult(new w(), new so0(this));
        n86.d(registerForActivityResult, "registerForActivityResul… }\n            \n        }");
        this.j = registerForActivityResult;
    }

    public final void onEvent(UserProfileEvent userProfileEvent) {
        String str;
        n86.e(userProfileEvent, "profileEvent");
        c81 c81 = this.h;
        if (c81 == null) {
            n86.l("viewModel");
            throw null;
        } else if (c81.f) {
            jz5.b().m(userProfileEvent);
            c81 c812 = this.h;
            if (c812 != null) {
                c812.d(false);
                if (userProfileEvent.getResponseType() == ad1.FAILED) {
                    String message = userProfileEvent.getMessage();
                    if (message == null || message.length() == 0) {
                        str = getString(R.string.something_bad_happened);
                    } else {
                        str = userProfileEvent.getMessage();
                    }
                    ve activity = c();
                    if (activity != null) {
                        Toast.makeText(activity, str, 0).show();
                    }
                    p(k().g, false);
                }
                if (userProfileEvent.getResponseType() == ad1.SUCCESS) {
                    c81 c813 = this.h;
                    if (c813 != null) {
                        c813.f = false;
                        if (userProfileEvent.getUserProfileEventType() != UserProfileEvent.TYPE.LOGOUT) {
                            xt.t1 t1Var = xt.f3961a;
                            t1Var.c().s();
                            k().g.setDisplayProps(k().f());
                            k().g.setStatus("UNVERIFIED");
                            k().g.setUserProfile(t1Var.L().e());
                            t1Var.c().L(k().g);
                            p(k().g, true);
                            ve activity2 = c();
                            if (activity2 != null) {
                                MPassVerificationStatusActivity.v0(activity2, k().g, "sourceMPassPurchaseActivity");
                                return;
                            }
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
        b2.k(this, b2.e, false, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public final void p(MPass mPass, boolean z) {
        ed1 ed1;
        if (z) {
            ed1 = new ed1("application submit success", Long.MIN_VALUE);
        } else {
            ed1 = new ed1("application submit failure", Long.MIN_VALUE);
        }
        ed1.a("passengerType", mPass.getPassengerType());
        ed1.a("noOfDays", String.valueOf(mPass.getNoOfDays()));
        ed1.a(SuperPassJsonKeys.PASS_FARE, String.valueOf(mPass.getFare()));
        j(ed1);
        ui1.m0(ed1);
    }

    public final void onEvent(BookingTransactionEvent bookingTransactionEvent) {
        n86.e(bookingTransactionEvent, "event");
        jz5.b().m(bookingTransactionEvent);
        c81 c81 = this.h;
        if (c81 != null) {
            c81.d(false);
            if (bookingTransactionEvent.getResponseType() == ad1.SUCCESS) {
                MPass magicPass = bookingTransactionEvent.getBookingTransaction().getMagicPass();
                p81 k2 = k();
                n86.d(magicPass, "lMPass");
                Objects.requireNonNull(k2);
                n86.e(magicPass, "<set-?>");
                k2.g = magicPass;
                if (magicPass.getReferenceId() == null) {
                    if (!magicPass.isPaymentRequired()) {
                        l(true, null);
                        return;
                    }
                    RazorPayOrderData razorPayOrderData = bookingTransactionEvent.getRazorPayOrderData();
                    String str = razorPayOrderData.get_orderId();
                    MPass mPass = k().g;
                    ed1 ed1 = new ed1("mPass order created", Long.MIN_VALUE);
                    ed1.a("passengerType", mPass.getPassengerType());
                    ed1.a(SuperPassJsonKeys.FARE, String.valueOf(mPass.getFare()));
                    ed1.a("noOfDays", String.valueOf(mPass.getNoOfDays()));
                    ed1.a("startDate", jh1.c(mPass.getStartingTime()));
                    ed1.a(SuperPassJsonKeys.ORDER_ID, str);
                    j(ed1);
                    ui1.m0(ed1);
                    Bundle bundle = new Bundle();
                    bundle.putString("currency", "INR");
                    bundle.putString(AnalyticsConstants.ORDER_ID, razorPayOrderData.get_orderId());
                    bundle.putString(AnalyticsConstants.AMOUNT, ((int) razorPayOrderData.get_amount()) + "");
                    bundle.putParcelable("magic_pass_info", magicPass);
                    bundle.putBoolean("lpEligible", bookingTransactionEvent.getBookingTransaction().isLpEligible());
                    bundle.putString("eligibilityResponseId", bookingTransactionEvent.getBookingTransaction().getLpId());
                    bundle.putString(AnalyticsConstants.MERCHANT_KEY, razorPayOrderData.getMerchantKey());
                    List<CardDetails> cardDetails = magicPass.getCardDetails();
                    Objects.requireNonNull(cardDetails, "null cannot be cast to non-null type java.util.ArrayList<out android.os.Parcelable?>");
                    bundle.putParcelableArrayList("card_details", (ArrayList) cardDetails);
                    ve activity = c();
                    if (activity != null) {
                        Intent intent = new Intent(activity, CheckoutActivity.class);
                        intent.addFlags(67108864);
                        intent.putExtra("src", "Confirm Pass Screen");
                        intent.putExtras(bundle);
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
                String errorMessage = bookingTransactionEvent.getErrorMessage();
                MPass mPass2 = k().g;
                ed1 ed12 = new ed1("mPass order creation failed", Long.MIN_VALUE);
                ed12.a("passengerType", mPass2.getPassengerType());
                ed12.a(SuperPassJsonKeys.FARE, String.valueOf(mPass2.getFare()));
                ed12.a("noOfDays", String.valueOf(mPass2.getNoOfDays()));
                ed12.a("startDate", jh1.c(mPass2.getStartingTime()));
                ed12.a("failureReason", errorMessage);
                j(ed12);
                ui1.m0(ed12);
                if (!TextUtils.isEmpty(bookingTransactionEvent.getErrorMessage())) {
                    Toast.makeText(c(), bookingTransactionEvent.getErrorMessage(), 1).show();
                } else {
                    Toast.makeText(c(), "something went wrong", 1).show();
                }
            }
        } else {
            n86.l("viewModel");
            throw null;
        }
    }

    public final void onEvent(RazorPayVerificationStatus razorPayVerificationStatus) {
        n86.e(razorPayVerificationStatus, "event");
        jz5.b().m(razorPayVerificationStatus);
        if (razorPayVerificationStatus.get_responseType() == ad1.SUCCESS) {
            l(false, razorPayVerificationStatus.getQrCode());
        } else {
            Toast.makeText(c(), "payment failed", 1).show();
        }
    }

    public final void onEvent(CashPaymentEvent cashPaymentEvent) {
        n86.e(cashPaymentEvent, "event");
        jz5.b().m(cashPaymentEvent);
        c81 c81 = this.h;
        if (c81 != null) {
            int i2 = 0;
            c81.d(false);
            if (cashPaymentEvent.getResponseType() == ad1.SUCCESS) {
                p81 k2 = k();
                MPass magicPass = cashPaymentEvent.getBookingTransaction().getMagicPass();
                n86.d(magicPass, "event.bookingTransaction.magicPass");
                Objects.requireNonNull(k2);
                n86.e(magicPass, "<set-?>");
                k2.g = magicPass;
                MPass mPass = k().g;
                mPass.setReferenceId(cashPaymentEvent.getReferenceId());
                mPass.setFare(cashPaymentEvent.getAmount());
                m(true, cashPaymentEvent.getReferenceId());
                List<BookingTransaction> e2 = xt.f3961a.c().e();
                ArrayList arrayList = e2;
                if (e2 == null) {
                    ArrayList arrayList2 = new ArrayList();
                    BookingTransaction bookingTransaction = new BookingTransaction();
                    bookingTransaction.setMagicPass(mPass);
                    arrayList2.add(bookingTransaction);
                    arrayList = arrayList2;
                }
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        MPass magicPass2 = arrayList.get(i2).getMagicPass();
                        xt.t1 t1Var = xt.f3961a;
                        if (ea6.f(t1Var.c().o(magicPass2.getPassengerType()), SuperPassPaymentConstants.PAYMENT_MODE_CASH, true)) {
                            magicPass2.setReferenceId(mPass.getReferenceId());
                            BookingTransaction bookingTransaction2 = arrayList.get(i2);
                            bookingTransaction2.setMagicPass(magicPass2);
                            arrayList.set(i2, bookingTransaction2);
                            t1Var.c().y(mPass.getCity(), mPass.getPassengerType(), bookingTransaction2, mPass.getStatus());
                        }
                        if (i3 > size) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                ve activity = c();
                if (activity != null) {
                    String string = getString(R.string.cash_center);
                    City d2 = xt.f3961a.k().d();
                    n86.c(d2);
                    d2.getName();
                    mPass.getFare();
                    mPass.getReferenceId();
                    startActivity(CashWebViewActivity.l0(activity, ut.D + "?referenceId=" + ((Object) mPass.getReferenceId()) + "&mobile_number=" + ((Object) mPass.getUserProfile().getPhone()) + "&amount=" + mPass.getFare() + "&city=" + ((Object) mPass.getCity()) + "&agency=" + ((Object) mPass.getAgency()), string, mPass, false, false, "confirmMagicPass"));
                    return;
                }
                return;
            }
            ve activity2 = c();
            if (activity2 != null) {
                m(false, cashPaymentEvent.getFailureReason());
                if (TextUtils.isEmpty(cashPaymentEvent.getFailureReason())) {
                    Toast.makeText(activity2, "something went wrong", 1).show();
                } else {
                    Toast.makeText(activity2, cashPaymentEvent.getFailureReason(), 1).show();
                }
            }
        } else {
            n86.l("viewModel");
            throw null;
        }
    }
}
