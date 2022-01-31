package app.zophop.ui.fragments.superpassPurchase;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import app.zophop.R;
import app.zophop.models.mTicketing.Gender;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;
import app.zophop.ui.views.ZophopFormInput;
import defpackage.da1;
import java.util.Objects;

/* compiled from: SuperPassBasicUserDetailsFragment.kt */
public final class SuperPassBasicUserDetailsFragment extends ul0<px> {
    public static final /* synthetic */ int i = 0;
    public da1 g;
    public final j56 h = h.B(this, z86.a(SuperPassPurchaseSharedViewModel.class), new d(this), new e(this));

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

    /* compiled from: SuperPassBasicUserDetailsFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ SuperPassBasicUserDetailsFragment f;
        public final /* synthetic */ Bundle g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment, Bundle bundle) {
            super(0);
            this.f = superPassBasicUserDetailsFragment;
            this.g = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new da1.a(this.f, this.g);
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
        View inflate = getLayoutInflater().inflate(R.layout.fragment_super_pass_basic_user_details, (ViewGroup) null, false);
        int i2 = R.id.bottom_sheet_next_btn;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bottom_sheet_next_btn);
        if (linearLayout != null) {
            i2 = R.id.btn_next;
            TextView textView = (TextView) inflate.findViewById(R.id.btn_next);
            if (textView != null) {
                i2 = R.id.form_dob;
                ZophopFormInput zophopFormInput = (ZophopFormInput) inflate.findViewById(R.id.form_dob);
                if (zophopFormInput != null) {
                    i2 = R.id.form_full_name;
                    ZophopFormInput zophopFormInput2 = (ZophopFormInput) inflate.findViewById(R.id.form_full_name);
                    if (zophopFormInput2 != null) {
                        i2 = R.id.form_gender;
                        ZophopFormInput zophopFormInput3 = (ZophopFormInput) inflate.findViewById(R.id.form_gender);
                        if (zophopFormInput3 != null) {
                            i2 = R.id.form_pass_start_date;
                            ZophopFormInput zophopFormInput4 = (ZophopFormInput) inflate.findViewById(R.id.form_pass_start_date);
                            if (zophopFormInput4 != null) {
                                i2 = R.id.main_layout;
                                ScrollView scrollView = (ScrollView) inflate.findViewById(R.id.main_layout);
                                if (scrollView != null) {
                                    i2 = R.id.passenger_details_notes;
                                    TextView textView2 = (TextView) inflate.findViewById(R.id.passenger_details_notes);
                                    if (textView2 != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                                        px pxVar = new px(constraintLayout, linearLayout, textView, zophopFormInput, zophopFormInput2, zophopFormInput3, zophopFormInput4, scrollView, textView2, constraintLayout);
                                        n86.d(pxVar, "inflate(layoutInflater)");
                                        return pxVar;
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
        da1 da1 = (da1) ((ai) h.B(this, z86.a(da1.class), new b(new a(this)), new c(this, new Bundle()))).getValue();
        n86.e(da1, "<set-?>");
        this.g = da1;
    }

    @Override // defpackage.ul0
    public void g() {
        j().h().f(getViewLifecycleOwner(), new e51(this));
        j().f().f(getViewLifecycleOwner(), new y41(this));
        j().g().f(getViewLifecycleOwner(), new d51(this));
        j().e().f(getViewLifecycleOwner(), new x41(this));
    }

    @Override // defpackage.ul0
    public void h() {
        T t = this.f;
        n86.c(t);
        ((px) t).d.setText(j().e);
        T t2 = this.f;
        n86.c(t2);
        ZophopFormInput zophopFormInput = ((px) t2).d;
        zophopFormInput.setEditable(true);
        EditText editText = zophopFormInput.getEditText();
        n86.d(editText, "editText");
        editText.addTextChangedListener(new b61(this, zophopFormInput));
        T t3 = this.f;
        n86.c(t3);
        ((px) t3).e.setOnClickListener(new f51(this));
        T t4 = this.f;
        n86.c(t4);
        ((px) t4).c.setOnClickListener(new z41(this));
        T t5 = this.f;
        n86.c(t5);
        ((px) t5).f.setOnClickListener(new b51(this));
        T t6 = this.f;
        n86.c(t6);
        ((px) t6).b.setAlpha(0.4f);
        T t7 = this.f;
        n86.c(t7);
        ((px) t7).b.setEnabled(false);
        T t8 = this.f;
        n86.c(t8);
        ((px) t8).b.setOnClickListener(new w41(this));
        T t9 = this.f;
        n86.c(t9);
        ((px) t9).d.setText(i().k.getFullName());
        da1 j = j();
        SuperPassUserDetails superPassUserDetails = i().k;
        n86.e(superPassUserDetails, "lSuperPassUserDetails");
        Gender gender = superPassUserDetails.getGender();
        n86.e(gender, "lGender");
        j.c.b("keyGender", gender);
        j.d();
        String dateOfBirth = superPassUserDetails.getDateOfBirth();
        n86.e(dateOfBirth, "lDob");
        j.c.b("keyDob", dateOfBirth);
        j.d();
        zz zzVar = new zz("basic user details screen open", null, 2);
        zzVar.a("source", i().e);
        ui1.l0(zzVar);
    }

    public final SuperPassPurchaseSharedViewModel i() {
        return (SuperPassPurchaseSharedViewModel) this.h.getValue();
    }

    public final da1 j() {
        da1 da1 = this.g;
        if (da1 != null) {
            return da1;
        }
        n86.l("viewModel");
        throw null;
    }

    public final void k() {
        ve activity = c();
        if (activity != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            Object systemService = activity.getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            currentFocus.clearFocus();
        }
    }
}
