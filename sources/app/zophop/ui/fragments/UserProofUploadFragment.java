package app.zophop.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import app.zophop.R;
import app.zophop.models.mTicketing.ProofDocumentProps;
import com.razorpay.AnalyticsConstants;
import defpackage.f91;

/* compiled from: UserProofUploadFragment.kt */
public final class UserProofUploadFragment extends ul0<tx> {
    public static final /* synthetic */ int m = 0;
    public f91 g;
    public final j56 h = h.B(this, z86.a(p81.class), new d(this), new e(this));
    public final xi i = new xi(z86.a(lx0.class), new f(this));
    public r<String> j;
    public r<Intent> k;
    public r<Intent> l;

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

    /* compiled from: UserProofUploadFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ UserProofUploadFragment f;
        public final /* synthetic */ Bundle g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(UserProofUploadFragment userProofUploadFragment, Bundle bundle) {
            super(0);
            this.f = userProofUploadFragment;
            this.g = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new f91.a(this.f, this.g);
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
        tx b2 = tx.b(getLayoutInflater());
        n86.d(b2, "inflate(layoutInflater)");
        return b2;
    }

    @Override // defpackage.ul0
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("keyProofDetails", ((lx0) this.i.getValue()).a());
        this.g = (f91) ((ai) h.B(this, z86.a(f91.class), new b(new a(this)), new c(this, bundle))).getValue();
    }

    @Override // defpackage.ul0
    public void g() {
    }

    @Override // defpackage.ul0
    public void h() {
        f91 f91 = this.g;
        if (f91 != null) {
            ProofDocumentProps proofDocumentProps = f91.d;
            T t = this.f;
            n86.c(t);
            ((tx) t).f.setText(proofDocumentProps.getProofName());
            boolean z = true;
            if (proofDocumentProps.getFormUrl().length() > 0) {
                T t2 = this.f;
                n86.c(t2);
                TextView textView = ((tx) t2).e;
                n86.d(textView, "viewBinding.proofLongDesc");
                textView.setVisibility(0);
                ve activity = c();
                String string = activity == null ? null : activity.getString(R.string.download_form);
                if (string == null) {
                    string = new String();
                }
                SpannableString spannableString = new SpannableString(n86.j(proofDocumentProps.getLongDescription(), string));
                spannableString.setSpan(new kx0(this, proofDocumentProps), spannableString.length() - string.length(), spannableString.length(), 33);
                ve activity2 = c();
                if (activity2 != null) {
                    spannableString.setSpan(new ForegroundColorSpan(q5.b(activity2, R.color.chalo_primary)), spannableString.length() - string.length(), spannableString.length(), 33);
                }
                T t3 = this.f;
                n86.c(t3);
                TextView textView2 = ((tx) t3).e;
                textView2.setText(spannableString);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                if (proofDocumentProps.getLongDescription().length() > 0) {
                    T t4 = this.f;
                    n86.c(t4);
                    TextView textView3 = ((tx) t4).e;
                    n86.d(textView3, "viewBinding.proofLongDesc");
                    textView3.setVisibility(0);
                    T t5 = this.f;
                    n86.c(t5);
                    ((tx) t5).e.setText(proofDocumentProps.getLongDescription());
                } else {
                    T t6 = this.f;
                    n86.c(t6);
                    TextView textView4 = ((tx) t6).e;
                    n86.d(textView4, "viewBinding.proofLongDesc");
                    textView4.setVisibility(8);
                }
            }
            T t7 = this.f;
            n86.c(t7);
            ((tx) t7).e.setText(proofDocumentProps.getLongDescription());
            T t8 = this.f;
            n86.c(t8);
            Group group = ((tx) t8).g;
            n86.d(group, "viewBinding.watchVideoLayoutGroup");
            group.setVisibility(proofDocumentProps.getTutorialUrl().length() > 0 ? 0 : 8);
            String tutorialUrl = proofDocumentProps.getTutorialUrl();
            T t9 = this.f;
            n86.c(t9);
            ((tx) t9).h.setOnClickListener(new ss0(this, tutorialUrl));
            String placeHolderImageUrl = proofDocumentProps.getPlaceHolderImageUrl();
            if (!(placeHolderImageUrl == null || placeHolderImageUrl.length() == 0)) {
                z = false;
            }
            if (z) {
                T t10 = this.f;
                n86.c(t10);
                ProgressBar progressBar = ((tx) t10).c;
                n86.d(progressBar, "viewBinding.placeholderImageLoader");
                progressBar.setVisibility(8);
                T t11 = this.f;
                n86.c(t11);
                ImageView imageView = ((tx) t11).d;
                n86.d(imageView, "viewBinding.placeholderImageView");
                imageView.setVisibility(8);
            } else {
                T t12 = this.f;
                n86.c(t12);
                ProgressBar progressBar2 = ((tx) t12).c;
                n86.d(progressBar2, "viewBinding.placeholderImageLoader");
                progressBar2.setVisibility(0);
                ve activity3 = c();
                if (activity3 != null) {
                    ml1<Drawable> p = gl1.g(activity3).p(placeHolderImageUrl);
                    T t13 = this.f;
                    n86.c(t13);
                    p.e(((tx) t13).d);
                    T t14 = this.f;
                    n86.c(t14);
                    ((tx) t14).d.setOnClickListener(new os0(this, placeHolderImageUrl));
                }
            }
            T t15 = this.f;
            n86.c(t15);
            ((tx) t15).b.setOnClickListener(new ns0(this));
            zz zzVar = new zz("proof upload screen open", null, 2);
            zzVar.a("source", j().e);
            ui1.l0(zzVar);
            return;
        }
        n86.l("viewModel");
        throw null;
    }

    public final void i(ed1 ed1) {
        ed1.a("source", "userProofUploadFragment");
        ed1.a(AnalyticsConstants.FLOW, j().f);
    }

    public final p81 j() {
        return (p81) this.h.getValue();
    }

    public final void k() {
        if (c() != null) {
            Intent g0 = vn.g0(this);
            String stringExtra = g0.getStringExtra("output");
            if (stringExtra != null) {
                f91 f91 = this.g;
                if (f91 != null) {
                    f91.d(stringExtra);
                } else {
                    n86.l("viewModel");
                    throw null;
                }
            }
            r<Intent> rVar = this.k;
            if (rVar != null) {
                rVar.a(g0, null);
            } else {
                n86.l("photoChooser");
                throw null;
            }
        }
    }

    public final void l(boolean z) {
        ed1 ed1 = new ed1("camera permission denied dialog displayed", Long.MIN_VALUE);
        ed1.a("isDismissed", Boolean.valueOf(z));
        i(ed1);
        ui1.m0(ed1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        super.onAttach(context);
        r<String> registerForActivityResult = registerForActivityResult(new v(), new rs0(this));
        n86.d(registerForActivityResult, "registerForActivityResul…         }\n\n            }");
        this.j = registerForActivityResult;
        r<Intent> registerForActivityResult2 = registerForActivityResult(new w(), new qs0(this));
        n86.d(registerForActivityResult2, "registerForActivityResul…)\n            }\n        }");
        this.k = registerForActivityResult2;
        r<Intent> registerForActivityResult3 = registerForActivityResult(new w(), new ps0(this));
        n86.d(registerForActivityResult3, "registerForActivityResul… }\n            \n        }");
        this.l = registerForActivityResult3;
    }
}
