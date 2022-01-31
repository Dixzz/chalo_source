package app.zophop.ui.fragments.cardRecharge;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import app.zophop.pubsub.eventbus.events.CardValidityCheckEvent;
import app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel;
import app.zophop.ui.views.ZophopFormInput;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* compiled from: CardDetailsFragment.kt */
public final class CardDetailsFragment extends ul0<hx> {
    public static final /* synthetic */ int l = 0;
    public final j56 g = h.B(this, z86.a(CardRechargeActivitySharedViewModel.class), new e(this), new f(this));
    public h91 h;
    public final xi i = new xi(z86.a(ky0.class), new g(this));
    public final j56 j = hd3.a2(new d(this));
    public gv0 k;

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

    /* compiled from: CardDetailsFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ CardDetailsFragment f;
        public final /* synthetic */ CardRechargeConfiguration g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(CardDetailsFragment cardDetailsFragment, CardRechargeConfiguration cardRechargeConfiguration) {
            super(0);
            this.f = cardDetailsFragment;
            this.g = cardRechargeConfiguration;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new xh(this.f.requireActivity().getApplication(), this.f, h.j(new m56("keyCardRechargeConfiguration", this.g)));
        }
    }

    /* compiled from: CardDetailsFragment.kt */
    public static final class d extends o86 implements h76<yu> {
        public final /* synthetic */ CardDetailsFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(CardDetailsFragment cardDetailsFragment) {
            super(0);
            this.f = cardDetailsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public yu invoke() {
            Context requireContext = this.f.requireContext();
            n86.d(requireContext, "requireContext()");
            return new yu(requireContext, false, new hy0(this.f));
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

    /* compiled from: FragmentNavArgsLazy.kt */
    public static final class g extends o86 implements h76<Bundle> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment) {
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

    @Override // defpackage.rl0
    public qo e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_card_details, (ViewGroup) null, false);
        int i2 = R.id.btn_next;
        TextView textView = (TextView) inflate.findViewById(R.id.btn_next);
        if (textView != null) {
            i2 = R.id.btn_recent_payments_see_all;
            TextView textView2 = (TextView) inflate.findViewById(R.id.btn_recent_payments_see_all);
            if (textView2 != null) {
                i2 = R.id.card_no_check_error_text;
                TextView textView3 = (TextView) inflate.findViewById(R.id.card_no_check_error_text);
                if (textView3 != null) {
                    i2 = R.id.dummy_view_bottom;
                    TextView textView4 = (TextView) inflate.findViewById(R.id.dummy_view_bottom);
                    if (textView4 != null) {
                        i2 = R.id.enter_card_no;
                        ZophopFormInput zophopFormInput = (ZophopFormInput) inflate.findViewById(R.id.enter_card_no);
                        if (zophopFormInput != null) {
                            i2 = R.id.error_text;
                            TextView textView5 = (TextView) inflate.findViewById(R.id.error_text);
                            if (textView5 != null) {
                                i2 = R.id.guideline_left;
                                Guideline guideline = (Guideline) inflate.findViewById(R.id.guideline_left);
                                if (guideline != null) {
                                    i2 = R.id.guideline_right;
                                    Guideline guideline2 = (Guideline) inflate.findViewById(R.id.guideline_right);
                                    if (guideline2 != null) {
                                        i2 = R.id.re_enter_card_no;
                                        ZophopFormInput zophopFormInput2 = (ZophopFormInput) inflate.findViewById(R.id.re_enter_card_no);
                                        if (zophopFormInput2 != null) {
                                            i2 = R.id.recent_card_payments_recycler_view;
                                            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recent_card_payments_recycler_view);
                                            if (recyclerView != null) {
                                                i2 = R.id.recent_payments_header_layout;
                                                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.recent_payments_header_layout);
                                                if (linearLayout != null) {
                                                    i2 = R.id.scroll_view;
                                                    ScrollView scrollView = (ScrollView) inflate.findViewById(R.id.scroll_view);
                                                    if (scrollView != null) {
                                                        hx hxVar = new hx((ConstraintLayout) inflate, textView, textView2, textView3, textView4, zophopFormInput, textView5, guideline, guideline2, zophopFormInput2, recyclerView, linearLayout, scrollView);
                                                        n86.d(hxVar, "inflate(layoutInflater)");
                                                        return hxVar;
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
        CardRechargeConfiguration a2 = ((ky0) this.i.getValue()).a();
        n86.d(a2, "args.argCardRechargeConfiguration");
        h91 h91 = (h91) ((ai) h.B(this, z86.a(h91.class), new b(new a(this)), new c(this, a2))).getValue();
        n86.e(h91, "<set-?>");
        this.h = h91;
    }

    @Override // defpackage.ul0
    public void g() {
        j().q.f(getViewLifecycleOwner(), new tx0(this));
        Object value = j().i.getValue();
        n86.d(value, "<get-isEnteredCardNoOk>(...)");
        ((LiveData) value).f(getViewLifecycleOwner(), new sx0(this));
        Object value2 = j().j.getValue();
        n86.d(value2, "<get-isReEnteredCardNoOk>(...)");
        ((LiveData) value2).f(getViewLifecycleOwner(), new ux0(this));
        Object value3 = j().k.getValue();
        n86.d(value3, "<get-shouldShowCardNoDoesNotMatchError>(...)");
        ((LiveData) value3).f(getViewLifecycleOwner(), new vx0(this));
        Object value4 = j().p.getValue();
        n86.d(value4, "<get-genericErrorToastMessage>(...)");
        ((LiveData) value4).f(getViewLifecycleOwner(), new xx0(this));
        Object value5 = j().n.getValue();
        n86.d(value5, "<get-errorMessage>(...)");
        ((LiveData) value5).f(getViewLifecycleOwner(), new yx0(this));
        Object value6 = j().l.getValue();
        n86.d(value6, "<get-showLoader>(...)");
        ((LiveData) value6).f(getViewLifecycleOwner(), new rx0(this));
    }

    @Override // defpackage.ul0
    public void h() {
        T t = this.f;
        n86.c(t);
        EditText editText = ((hx) t).f.getEditText();
        f71 f71 = f71.f1097a;
        String str = j().g;
        n86.e(str, "lNumberString");
        if (!(str.length() == 0)) {
            StringBuilder sb = new StringBuilder();
            int length = str.length() - 1;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (i2 == 2 || i2 == 6 || i2 == 10) {
                        sb.append(' ');
                    }
                    sb.append(str.charAt(i2));
                    if (i3 > length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            str = sb.toString();
            n86.d(str, "StringBuilder().apply(builderAction).toString()");
        }
        editText.setText(str);
        T t2 = this.f;
        n86.c(t2);
        ZophopFormInput zophopFormInput = ((hx) t2).f;
        zophopFormInput.setEditable(true);
        EditText editText2 = zophopFormInput.getEditText();
        n86.d(editText2, "editText");
        n86.e(editText2, "<this>");
        editText2.setLongClickable(false);
        editText2.setTextIsSelectable(false);
        editText2.setCustomSelectionActionModeCallback(new oh1());
        zophopFormInput.setInputType(2);
        f71 f712 = f71.f1097a;
        zophopFormInput.setCustomTextChangeListener(new e71());
        EditText editText3 = zophopFormInput.getEditText();
        n86.d(editText3, "editText");
        editText3.addTextChangedListener(new iy0(this, zophopFormInput));
        T t3 = this.f;
        n86.c(t3);
        ZophopFormInput zophopFormInput2 = ((hx) t3).h;
        zophopFormInput2.setEditable(false);
        zophopFormInput2.setClickable(false);
        zophopFormInput2.setInputType(2);
        zophopFormInput2.setCustomTextChangeListener(new e71());
        EditText editText4 = zophopFormInput2.getEditText();
        n86.d(editText4, "editText");
        n86.e(editText4, "<this>");
        editText4.setLongClickable(false);
        editText4.setTextIsSelectable(false);
        editText4.setCustomSelectionActionModeCallback(new oh1());
        EditText editText5 = zophopFormInput2.getEditText();
        n86.d(editText5, "editText");
        editText5.addTextChangedListener(new jy0(this, zophopFormInput2));
        T t4 = this.f;
        n86.c(t4);
        ((hx) t4).b.setOnClickListener(new qx0(this));
        T t5 = this.f;
        n86.c(t5);
        TextView textView = ((hx) t5).g;
        n86.d(textView, "viewBinding.errorText");
        textView.setVisibility(8);
        T t6 = this.f;
        n86.c(t6);
        TextView textView2 = ((hx) t6).d;
        n86.d(textView2, "viewBinding.cardNoCheckErrorText");
        textView2.setVisibility(8);
        T t7 = this.f;
        n86.c(t7);
        ((hx) t7).i.setAdapter((yu) this.j.getValue());
        T t8 = this.f;
        n86.c(t8);
        ((hx) t8).c.setOnClickListener(new wx0(this));
    }

    public final CardRechargeActivitySharedViewModel i() {
        return (CardRechargeActivitySharedViewModel) this.g.getValue();
    }

    public final h91 j() {
        h91 h91 = this.h;
        if (h91 != null) {
            return h91;
        }
        n86.l("viewModel");
        throw null;
    }

    public final void onEvent(CardValidityCheckEvent cardValidityCheckEvent) {
        n86.e(cardValidityCheckEvent, "lCardValidityCheckEvent");
        jz5.b().m(cardValidityCheckEvent);
        if (n86.a(cardValidityCheckEvent.getRequestId(), j().m)) {
            h91 j2 = j();
            n86.e(cardValidityCheckEvent, "lCardValidityCheckEvent");
            j2.d.b("keyShouldShowLoader", Boolean.FALSE);
            String status = cardValidityCheckEvent.getStatus();
            int hashCode = status.hashCode();
            boolean z = false;
            if (hashCode != -1617199657) {
                if (hashCode != 66247144) {
                    if (hashCode == 81434588 && status.equals(CardValidityCheckEvent.VALIDITY_STATUS_VALID)) {
                        long rechargeLimit = cardValidityCheckEvent.getRechargeLimit();
                        j2.o = rechargeLimit;
                        j2.d.b("keyRechargeLimit", Long.valueOf(rechargeLimit));
                        z = true;
                    }
                } else if (status.equals(CardValidityCheckEvent.VALIDITY_CHECK_ERROR)) {
                    j2.d.b("keyGenericErrorToastMessage", cardValidityCheckEvent.getMessage());
                }
            } else if (status.equals(CardValidityCheckEvent.VALIDITY_STATUS_INVALID)) {
                String message = cardValidityCheckEvent.getMessage();
                n86.j("onCardNoReEntered2: ", j2.h);
                j2.h = "";
                j2.d.b("keyReEnteredCardNo", "");
                j2.d.b("keyErrorMessage", message);
            }
            long rechargeLimit2 = cardValidityCheckEvent.getRechargeLimit();
            ed1 ed1 = new ed1("ocr card validity checked", Long.MIN_VALUE);
            ed1.a("isSuccessful", Boolean.valueOf(z));
            ed1.a("rechargeLimit", String.valueOf(rechargeLimit2));
            ed1.a("source", "sourceCardDetailsScreen");
            ui1.m0(ed1);
            if (z) {
                i().d.b("keyRechargeLimit", Long.valueOf(j().o));
                CardRechargeActivitySharedViewModel i2 = i();
                String str = j().g;
                Objects.requireNonNull(i2);
                n86.e(str, FirebaseAnalytics.Param.VALUE);
                i2.h = str;
                i2.d.b("keyCardNumber", str);
                my0 my0 = new my0(j().f, j().o, j().g, null);
                n86.d(my0, "actionCardDetailsFragmen…        lCardNo\n        )");
                vh1 vh1 = vh1.f3649a;
                n86.f(this, "$this$findNavController");
                NavController d2 = NavHostFragment.d(this);
                n86.b(d2, "NavHostFragment.findNavController(this)");
                vh1.a(d2, my0);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        ve activity = c();
        if (activity != null) {
            Context requireContext = requireContext();
            n86.d(requireContext, "requireContext()");
            n86.e(activity, "<this>");
            n86.e(requireContext, "lContext");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(requireContext);
            }
            Object systemService = activity.getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            currentFocus.clearFocus();
        }
        super.onPause();
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
