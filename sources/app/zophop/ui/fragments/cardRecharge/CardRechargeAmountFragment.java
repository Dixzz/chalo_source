package app.zophop.ui.fragments.cardRecharge;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel;
import app.zophop.ui.views.ZophopFormInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: CardRechargeAmountFragment.kt */
public final class CardRechargeAmountFragment extends ul0<ix> {
    public static final /* synthetic */ int j = 0;
    public final j56 g = h.B(this, z86.a(CardRechargeActivitySharedViewModel.class), new d(this), new e(this));
    public m91 h;
    public final xi i = new xi(z86.a(qy0.class), new f(this));

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

    /* compiled from: CardRechargeAmountFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ CardRechargeAmountFragment f;
        public final /* synthetic */ CardRechargeConfiguration g;
        public final /* synthetic */ long h;
        public final /* synthetic */ String i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(CardRechargeAmountFragment cardRechargeAmountFragment, CardRechargeConfiguration cardRechargeConfiguration, long j, String str) {
            super(0);
            this.f = cardRechargeAmountFragment;
            this.g = cardRechargeConfiguration;
            this.h = j;
            this.i = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new xh(this.f.requireActivity().getApplication(), this.f, h.j(new m56("keyCardRechargeConfiguration", this.g), new m56("keyRechargeLimit", Long.valueOf(this.h)), new m56("keyCardNo", this.i)));
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

    @Override // defpackage.rl0
    public qo e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_card_recharge_amount, (ViewGroup) null, false);
        int i2 = R.id.btn_next;
        TextView textView = (TextView) inflate.findViewById(R.id.btn_next);
        if (textView != null) {
            i2 = R.id.card_no;
            TextView textView2 = (TextView) inflate.findViewById(R.id.card_no);
            if (textView2 != null) {
                i2 = R.id.enter_amount;
                ZophopFormInput zophopFormInput = (ZophopFormInput) inflate.findViewById(R.id.enter_amount);
                if (zophopFormInput != null) {
                    i2 = R.id.error_text;
                    TextView textView3 = (TextView) inflate.findViewById(R.id.error_text);
                    if (textView3 != null) {
                        i2 = R.id.guideline_left;
                        Guideline guideline = (Guideline) inflate.findViewById(R.id.guideline_left);
                        if (guideline != null) {
                            i2 = R.id.guideline_right;
                            Guideline guideline2 = (Guideline) inflate.findViewById(R.id.guideline_right);
                            if (guideline2 != null) {
                                i2 = R.id.scroll_view;
                                ScrollView scrollView = (ScrollView) inflate.findViewById(R.id.scroll_view);
                                if (scrollView != null) {
                                    i2 = R.id.sub_title;
                                    TextView textView4 = (TextView) inflate.findViewById(R.id.sub_title);
                                    if (textView4 != null) {
                                        i2 = R.id.suggested_amounts_recycler_view;
                                        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.suggested_amounts_recycler_view);
                                        if (recyclerView != null) {
                                            ix ixVar = new ix((ConstraintLayout) inflate, textView, textView2, zophopFormInput, textView3, guideline, guideline2, scrollView, textView4, recyclerView);
                                            n86.d(ixVar, "inflate(layoutInflater)");
                                            return ixVar;
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
        CardRechargeConfiguration b2 = i().b();
        n86.d(b2, "args.argCardRechargeConfiguration");
        long c2 = i().c();
        String a2 = i().a();
        n86.d(a2, "args.argCardNumber");
        m91 m91 = (m91) ((ai) h.B(this, z86.a(m91.class), new b(new a(this)), new c(this, b2, c2, a2))).getValue();
        n86.e(m91, "<set-?>");
        this.h = m91;
    }

    @Override // defpackage.ul0
    public void g() {
        Object value = j().j.getValue();
        n86.d(value, "<get-errorMessage>(...)");
        ((LiveData) value).f(getViewLifecycleOwner(), new zx0(this));
    }

    @Override // defpackage.ul0
    public void h() {
        T t = this.f;
        n86.c(t);
        ((ix) t).c.setText(f71.b(f71.f1097a, j().g, 0, 2));
        if (j().f.getFareInfo().getMinAmount() <= 0) {
            T t2 = this.f;
            n86.c(t2);
            TextView textView = ((ix) t2).f;
            n86.d(textView, "viewBinding.subTitle");
            textView.setVisibility(8);
        } else {
            String string = getString(R.string.enter_card_amount_sub_title);
            n86.d(string, "getString(R.string.enter_card_amount_sub_title)");
            String e0 = hj1.e0(new Object[]{wh1.a(wh1.f3781a, j().f.getFareInfo().getMultiplesAllowed(), 0, 2)}, 1, string, "java.lang.String.format(format, *args)");
            T t3 = this.f;
            n86.c(t3);
            TextView textView2 = ((ix) t3).f;
            n86.d(textView2, "viewBinding.subTitle");
            textView2.setVisibility(0);
            T t4 = this.f;
            n86.c(t4);
            ((ix) t4).f.setText(e0);
        }
        if (j().i > 0) {
            T t5 = this.f;
            n86.c(t5);
            ((ix) t5).d.setText(wh1.a(wh1.f3781a, j().i, 0, 2));
        } else {
            T t6 = this.f;
            n86.c(t6);
            ((ix) t6).d.setText("₹");
        }
        T t7 = this.f;
        n86.c(t7);
        ZophopFormInput zophopFormInput = ((ix) t7).d;
        zophopFormInput.setEditable(true);
        zophopFormInput.setInputType(2);
        EditText editText = zophopFormInput.getEditText();
        n86.d(editText, "editText");
        editText.addTextChangedListener(new py0(zophopFormInput, this));
        T t8 = this.f;
        n86.c(t8);
        TextView textView3 = ((ix) t8).e;
        n86.d(textView3, "viewBinding.errorText");
        textView3.setVisibility(8);
        long j2 = j().h;
        List<Long> suggestedAmounts = j().f.getFareInfo().getSuggestedAmounts();
        ArrayList arrayList = new ArrayList();
        for (T t9 : suggestedAmounts) {
            if (t9.longValue() < j2) {
                arrayList.add(t9);
            }
        }
        if (arrayList.isEmpty()) {
            T t10 = this.f;
            n86.c(t10);
            RecyclerView recyclerView = ((ix) t10).g;
            n86.d(recyclerView, "viewBinding.suggestedAmountsRecyclerView");
            recyclerView.setVisibility(8);
        } else {
            zu zuVar = new zu(arrayList, new oy0(this));
            T t11 = this.f;
            n86.c(t11);
            RecyclerView recyclerView2 = ((ix) t11).g;
            recyclerView2.setAdapter(zuVar);
            c();
            recyclerView2.setLayoutManager(new LinearLayoutManager(0, false));
            recyclerView2.setHasFixedSize(true);
        }
        T t12 = this.f;
        n86.c(t12);
        ((ix) t12).b.setAlpha(0.4f);
        T t13 = this.f;
        n86.c(t13);
        ((ix) t13).b.setEnabled(false);
        T t14 = this.f;
        n86.c(t14);
        ((ix) t14).b.setOnClickListener(new ay0(this));
    }

    public final qy0 i() {
        return (qy0) this.i.getValue();
    }

    public final m91 j() {
        m91 m91 = this.h;
        if (m91 != null) {
            return m91;
        }
        n86.l("viewModel");
        throw null;
    }

    public final void k(String str) {
        hj1.P0("ocr recharge amount error", Long.MIN_VALUE, "errorType", str);
    }

    public final void l(String str) {
        T t = this.f;
        n86.c(t);
        TextView textView = ((ix) t).e;
        n86.d(textView, "viewBinding.errorText");
        textView.setVisibility(0);
        T t2 = this.f;
        n86.c(t2);
        ((ix) t2).e.setText(str);
        T t3 = this.f;
        n86.c(t3);
        ((ix) t3).b.setAlpha(0.4f);
        T t4 = this.f;
        n86.c(t4);
        ((ix) t4).b.setEnabled(false);
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
}
