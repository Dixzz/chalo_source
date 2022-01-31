package app.zophop.ui.fragments.cardRecharge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import app.zophop.R;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonKeys;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRechargeOrderDetails;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.OnlineCardRechargeOrderCreationEvent;
import app.zophop.pubsub.eventbus.events.RazorPayOrderData;
import app.zophop.ui.activities.CheckoutActivity;
import app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: CardRechargeConfirmPaymentFragment.kt */
public final class CardRechargeConfirmPaymentFragment extends ul0<jx> {
    public static final /* synthetic */ int l = 0;
    public final j56 g = h.B(this, z86.a(CardRechargeActivitySharedViewModel.class), new d(this), new e(this));
    public o91 h;
    public final xi i = new xi(z86.a(uy0.class), new f(this));
    public gv0 j;
    public r<Intent> k;

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

    /* compiled from: CardRechargeConfirmPaymentFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ CardRechargeConfirmPaymentFragment f;
        public final /* synthetic */ CardRechargeConfiguration g;
        public final /* synthetic */ long h;
        public final /* synthetic */ String i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment, CardRechargeConfiguration cardRechargeConfiguration, long j, String str) {
            super(0);
            this.f = cardRechargeConfirmPaymentFragment;
            this.g = cardRechargeConfiguration;
            this.h = j;
            this.i = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new xh(this.f.requireActivity().getApplication(), this.f, h.j(new m56("keyCardRechargeConfiguration", this.g), new m56("keyRechargeAmount", Long.valueOf(this.h)), new m56("keyCardNo", this.i)));
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

    /* compiled from: FragmentNavArgsLazy.kt */
    public static final class f extends o86 implements h76<Bundle> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Bundle invoke() {
            Bundle arguments = this.f.getArguments();
            if (arguments != null) {
                return arguments;
            }
            throw new IllegalStateException(hj1.Y(hj1.i0("Fragment "), this.f, " has null arguments"));
        }
    }

    public static final void i(CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment, boolean z) {
        ed1 ed1;
        if (z) {
            ed1 = new ed1("terms accept", Long.MIN_VALUE);
        } else {
            ed1 = new ed1("terms cancel", Long.MIN_VALUE);
        }
        cardRechargeConfirmPaymentFragment.j(ed1);
        ui1.m0(ed1);
    }

    @Override // defpackage.rl0
    public qo e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_card_recharge_confirm_payment, (ViewGroup) null, false);
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
                            i2 = R.id.card_number;
                            TextView textView4 = (TextView) inflate.findViewById(R.id.card_number);
                            if (textView4 != null) {
                                i2 = R.id.component_divider_1;
                                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.component_divider_1);
                                if (linearLayout2 != null) {
                                    i2 = R.id.component_divider_3;
                                    LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.component_divider_3);
                                    if (linearLayout3 != null) {
                                        i2 = R.id.fare_details_layout;
                                        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.fare_details_layout);
                                        if (linearLayout4 != null) {
                                            i2 = R.id.fare_split_layout;
                                            LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.fare_split_layout);
                                            if (linearLayout5 != null) {
                                                i2 = R.id.fare_split_title;
                                                LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.fare_split_title);
                                                if (linearLayout6 != null) {
                                                    i2 = R.id.guideline_left;
                                                    Guideline guideline = (Guideline) inflate.findViewById(R.id.guideline_left);
                                                    if (guideline != null) {
                                                        i2 = R.id.guideline_right;
                                                        Guideline guideline2 = (Guideline) inflate.findViewById(R.id.guideline_right);
                                                        if (guideline2 != null) {
                                                            i2 = R.id.recharge_amount_text;
                                                            TextView textView5 = (TextView) inflate.findViewById(R.id.recharge_amount_text);
                                                            if (textView5 != null) {
                                                                i2 = R.id.title_text;
                                                                TextView textView6 = (TextView) inflate.findViewById(R.id.title_text);
                                                                if (textView6 != null) {
                                                                    jx jxVar = new jx((RelativeLayout) inflate, textView, linearLayout, textView2, imageView, textView3, textView4, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, guideline, guideline2, textView5, textView6);
                                                                    n86.d(jxVar, "inflate(layoutInflater)");
                                                                    return jxVar;
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
        CardRechargeConfiguration b2 = k().b();
        n86.d(b2, "args.argCardRechargeConfiguration");
        long c2 = k().c();
        String a2 = k().a();
        n86.d(a2, "args.argCardNumber");
        this.h = (o91) ((ai) h.B(this, z86.a(o91.class), new b(new a(this)), new c(this, b2, c2, a2))).getValue();
    }

    @Override // defpackage.ul0
    public void g() {
        o91 o91 = this.h;
        if (o91 != null) {
            Object value = o91.e.getValue();
            n86.d(value, "<get-isFareLayoutExpanded>(...)");
            ((LiveData) value).f(getViewLifecycleOwner(), new fy0(this));
            o91 o912 = this.h;
            if (o912 != null) {
                Object value2 = o912.i.getValue();
                n86.d(value2, "<get-shouldShowLoader>(...)");
                ((LiveData) value2).f(getViewLifecycleOwner(), new ey0(this));
                return;
            }
            n86.l("viewModel");
            throw null;
        }
        n86.l("viewModel");
        throw null;
    }

    @Override // defpackage.ul0
    public void h() {
        f71 f71 = f71.f1097a;
        o91 o91 = this.h;
        if (o91 != null) {
            String b2 = f71.b(f71, o91.g, 0, 2);
            String string = getString(R.string.card_recharge_confirmation_subtitle);
            n86.d(string, "getString(R.string.card_…ge_confirmation_subtitle)");
            Object[] objArr = new Object[1];
            wh1 wh1 = wh1.f3781a;
            o91 o912 = this.h;
            if (o912 != null) {
                objArr[0] = wh1.a(wh1, o912.h, 0, 2);
                String e0 = hj1.e0(objArr, 1, string, "java.lang.String.format(format, *args)");
                T t = this.f;
                n86.c(t);
                ((jx) t).e.setText(b2);
                T t2 = this.f;
                n86.c(t2);
                ((jx) t2).h.setText(e0);
                bx b3 = bx.b(getLayoutInflater());
                n86.d(b3, "inflate(layoutInflater)");
                b3.c.setText(getString(R.string.top_up_amount));
                TextView textView = b3.b;
                o91 o913 = this.h;
                if (o913 != null) {
                    textView.setText(wh1.a(wh1, o913.h, 0, 2));
                    T t3 = this.f;
                    n86.c(t3);
                    ((jx) t3).g.addView(b3.f485a);
                    T t4 = this.f;
                    n86.c(t4);
                    ((jx) t4).f.setOnClickListener(new cy0(this));
                    T t5 = this.f;
                    n86.c(t5);
                    TextView textView2 = ((jx) t5).b;
                    o91 o914 = this.h;
                    if (o914 != null) {
                        textView2.setText(wh1.a(wh1, o914.h, 0, 2));
                        T t6 = this.f;
                        n86.c(t6);
                        ((jx) t6).d.setText(getString(R.string.make_payment_caps));
                        zz zzVar = new zz("confirm online card recharge payment screen open", null, 2);
                        zzVar.a("source", "sourceCardRechargeConfirmPaymentScreen");
                        ui1.l0(zzVar);
                        T t7 = this.f;
                        n86.c(t7);
                        ((jx) t7).d.setOnClickListener(new by0(this));
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
        n86.l("viewModel");
        throw null;
    }

    public final void j(ed1 ed1) {
        o91 o91 = this.h;
        if (o91 != null) {
            CardRechargeConfiguration cardRechargeConfiguration = o91.f;
            ed1.a("productType", cardRechargeConfiguration.getProductType());
            ed1.a("productSubType", cardRechargeConfiguration.getProductSubType());
            ed1.a("source", "sourceCardRechargeConfirmPaymentScreen");
            o91 o912 = this.h;
            if (o912 != null) {
                ed1.a(CardRechargeJsonKeys.CARD_NO, o912.g);
                o91 o913 = this.h;
                if (o913 != null) {
                    ed1.a("rechargeAmount", Long.valueOf(o913.h));
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

    public final uy0 k() {
        return (uy0) this.i.getValue();
    }

    public final CardRechargeActivitySharedViewModel l() {
        return (CardRechargeActivitySharedViewModel) this.g.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        super.onAttach(context);
        r<Intent> registerForActivityResult = registerForActivityResult(new w(), new dy0(this));
        n86.d(registerForActivityResult, "registerForActivityResul…\n\n            }\n        }");
        this.k = registerForActivityResult;
    }

    public final void onEvent(OnlineCardRechargeOrderCreationEvent onlineCardRechargeOrderCreationEvent) {
        n86.e(onlineCardRechargeOrderCreationEvent, "lEvent");
        jz5.b().m(onlineCardRechargeOrderCreationEvent);
        o91 o91 = this.h;
        if (o91 != null) {
            o91.d(false);
            if (onlineCardRechargeOrderCreationEvent.getResponseType() == ad1.SUCCESS) {
                OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails = onlineCardRechargeOrderCreationEvent.getOnlineCardRechargeOrderDetails();
                if (onlineCardRechargeOrderDetails != null) {
                    CardRechargeActivitySharedViewModel l2 = l();
                    Objects.requireNonNull(l2);
                    n86.e(onlineCardRechargeOrderDetails, "lOnlineCardRechargeOrderDetails");
                    l2.l = onlineCardRechargeOrderDetails;
                    l2.d.b("keyOnlineCardRechargeOrderDetails", onlineCardRechargeOrderDetails);
                    ed1 l3 = hj1.l("ocr order created", Long.MIN_VALUE, SuperPassJsonKeys.ORDER_ID, onlineCardRechargeOrderDetails.getRazorPayOrderData().get_orderId());
                    j(l3);
                    ui1.m0(l3);
                    RazorPayOrderData razorPayOrderData = onlineCardRechargeOrderDetails.getRazorPayOrderData();
                    ve activity = c();
                    if (activity != null) {
                        String str = razorPayOrderData.get_orderId();
                        String str2 = razorPayOrderData.getAmountInPaisa() + "";
                        o91 o912 = this.h;
                        if (o912 != null) {
                            String str3 = o912.g;
                            CardRechargeConfiguration cardRechargeConfiguration = o912.f;
                            OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails2 = l().l;
                            String merchantKey = razorPayOrderData.getMerchantKey();
                            int i2 = CheckoutActivity.d0;
                            Bundle c2 = hj1.c("currency", "INR", AnalyticsConstants.ORDER_ID, str);
                            c2.putString(AnalyticsConstants.AMOUNT, str2);
                            c2.putBoolean("arg_isOnlineCardRechargePaymentFlow", true);
                            c2.putString("arg_onlineCardRechargeConfig", str3);
                            c2.putParcelable("arg_onlineCardRechargeOrderDetails", onlineCardRechargeOrderDetails2);
                            c2.putParcelable("arg_onlineCardRechargeConfig", cardRechargeConfiguration);
                            c2.putBoolean("lpEligible", onlineCardRechargeOrderDetails2.isLPEligible());
                            c2.putString("eligibilityResponseId", onlineCardRechargeOrderDetails2.getLPEligibilityResponseId());
                            c2.putString(AnalyticsConstants.MERCHANT_KEY, merchantKey);
                            c2.putParcelableArrayList("card_details", (ArrayList) onlineCardRechargeOrderDetails2.getCardDetailsList());
                            Intent intent = new Intent(activity, CheckoutActivity.class);
                            intent.addFlags(67108864);
                            intent.putExtra("src", "sourceCardRechargeConfirmPaymentScreen");
                            intent.putExtras(c2);
                            r<Intent> rVar = this.k;
                            if (rVar != null) {
                                rVar.a(intent, null);
                            } else {
                                n86.l("checkoutActivityResultLauncher");
                                throw null;
                            }
                        } else {
                            n86.l("viewModel");
                            throw null;
                        }
                    }
                }
            } else {
                ed1 l4 = hj1.l("ocr order creation failed", Long.MIN_VALUE, "failureReason", onlineCardRechargeOrderCreationEvent.getMessage());
                j(l4);
                ui1.m0(l4);
                if (!TextUtils.isEmpty(onlineCardRechargeOrderCreationEvent.getMessage())) {
                    Toast.makeText(c(), onlineCardRechargeOrderCreationEvent.getMessage(), 1).show();
                } else {
                    Toast.makeText(c(), "something went wrong", 1).show();
                }
            }
        } else {
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
}
