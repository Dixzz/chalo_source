package app.zophop.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.razorpay.AnalyticsConstants;
import defpackage.h30;
import defpackage.xt;
import java.util.Objects;

/* compiled from: LanguageSelectSplashScreen.kt */
public final class LanguageSelectSplashScreen extends rl0<jy> {
    public static final /* synthetic */ int i = 0;
    public final j56 g = h.B(this, z86.a(o81.class), new c(new b(this)), null);
    public final xi h = new xi(z86.a(av0.class), new a(this));

    /* compiled from: FragmentNavArgsLazy.kt */
    public static final class a extends o86 implements h76<Bundle> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
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

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class b extends o86 implements h76<Fragment> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
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
    public static final class c extends o86 implements h76<gi> {
        public final /* synthetic */ h76 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(h76 h76) {
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

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public jy e() {
        View inflate = getLayoutInflater().inflate(R.layout.language_change_splash, (ViewGroup) null, false);
        int i2 = R.id.confirm_language;
        View findViewById = inflate.findViewById(R.id.confirm_language);
        if (findViewById != null) {
            int i3 = R.id.confirmation_btn;
            Button button = (Button) findViewById.findViewById(R.id.confirmation_btn);
            if (button != null) {
                LinearLayout linearLayout = (LinearLayout) findViewById;
                TextView textView = (TextView) findViewById.findViewById(R.id.terms_conditions_privacy_policy);
                if (textView != null) {
                    xw xwVar = new xw(linearLayout, button, linearLayout, textView);
                    i2 = R.id.language_view;
                    RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.language_view);
                    if (recyclerView != null) {
                        i2 = R.id.language_welcome_header;
                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.language_welcome_header);
                        if (linearLayout2 != null) {
                            i2 = R.id.toolbar;
                            Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
                            if (toolbar != null) {
                                i2 = R.id.top_container;
                                ImageView imageView = (ImageView) inflate.findViewById(R.id.top_container);
                                if (imageView != null) {
                                    jy jyVar = new jy((CoordinatorLayout) inflate, xwVar, recyclerView, linearLayout2, toolbar, imageView);
                                    n86.d(jyVar, "inflate(layoutInflater)");
                                    return jyVar;
                                }
                            }
                        }
                    }
                } else {
                    i3 = R.id.terms_conditions_privacy_policy;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(findViewById.getResources().getResourceName(i3)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    public final av0 f() {
        return (av0) this.h.getValue();
    }

    public final o81 g() {
        return (o81) this.g.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        T t = this.f;
        n86.c(t);
        ((jy) t).b.b.setOnClickListener(new kr0(this));
        int i2 = 0;
        if (!f().a()) {
            T t2 = this.f;
            n86.c(t2);
            Toolbar toolbar = ((jy) t2).e;
            toolbar.setVisibility(0);
            toolbar.setNavigationOnClickListener(new lr0(this));
        }
        xt.t1 t1Var = xt.f3961a;
        t1Var.l().put("lang_info_shown", "true");
        String b2 = t1Var.z().b();
        T t3 = this.f;
        n86.c(t3);
        RecyclerView recyclerView = ((jy) t3).c;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        Context context = recyclerView.getContext();
        n86.d(context, AnalyticsConstants.CONTEXT);
        Objects.requireNonNull(t1Var.z());
        h30.a[] values = h30.a.values();
        int i3 = 0;
        while (true) {
            if (i3 >= 9) {
                break;
            }
            int i4 = i3 + 1;
            if (n86.a(values[i3].getLocale(), b2)) {
                i2 = i3;
                break;
            }
            i3 = i4;
        }
        recyclerView.setAdapter(new sj0(context, b2, i2, new mr0(this)));
        g().c = b2;
        if (f().a()) {
            SpannableString spannableString = new SpannableString(getString(R.string.terms_conditions_privacy_policy));
            spannableString.setSpan(new URLSpan("https://www.chalo.com/terms-of-use"), 32, spannableString.length(), 33);
            Context context2 = getContext();
            if (context2 != null) {
                spannableString.setSpan(new ForegroundColorSpan(q5.b(context2, R.color.chalo_primary)), 36, spannableString.length(), 33);
            }
            T t4 = this.f;
            n86.c(t4);
            TextView textView = ((jy) t4).b.d;
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            T t5 = this.f;
            n86.c(t5);
            LinearLayout linearLayout = ((jy) t5).d;
            n86.d(linearLayout, "viewBinding.languageWelcomeHeader");
            n86.e(linearLayout, "<this>");
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ui1.n((float) 90, linearLayout.getContext());
            T t6 = this.f;
            n86.c(t6);
            ((jy) t6).b.d.setVisibility(8);
        }
        T t7 = this.f;
        n86.c(t7);
        BottomSheetBehavior H = BottomSheetBehavior.H(((jy) t7).b.c);
        H.M(3);
        zu0 zu0 = new zu0(H);
        if (!H.I.contains(zu0)) {
            H.I.add(zu0);
        }
        ui1.m0(new ed1("language selection screen displayed", Long.MAX_VALUE));
        ui1.l0(new zz("language selection screen opened", null, 2));
    }
}
