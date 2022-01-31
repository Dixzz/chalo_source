package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.Objects;

/* renamed from: t31  reason: default package */
/* compiled from: BottomSheetDialogFragmentSuperPass.kt */
public final class t31 extends pl0<ow> {
    public static final a j = new a(null);
    public String h;
    public final j56 i = h.B(this, z86.a(y91.class), new b(this), new c(this));

    /* renamed from: t31$a */
    /* compiled from: BottomSheetDialogFragmentSuperPass.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* renamed from: t31$b */
    /* compiled from: FragmentViewModelLazy.kt */
    public static final class b extends o86 implements h76<gi> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            return hj1.j(this.f, "requireActivity()", "requireActivity().viewModelStore");
        }
    }

    /* renamed from: t31$c */
    /* compiled from: FragmentViewModelLazy.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
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

    public t31(String str) {
        n86.e(str, "argSource");
        this.h = str;
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.pl0
    public ow d(LayoutInflater layoutInflater) {
        n86.e(layoutInflater, "lInflater");
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_super_pass, (ViewGroup) null, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i2 = R.id.dismiss_btn;
        MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.dismiss_btn);
        if (materialTextView != null) {
            i2 = R.id.dob;
            MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.dob);
            if (materialTextView2 != null) {
                i2 = R.id.gender;
                MaterialTextView materialTextView3 = (MaterialTextView) inflate.findViewById(R.id.gender);
                if (materialTextView3 != null) {
                    i2 = R.id.max_fare_details_layout;
                    View findViewById = inflate.findViewById(R.id.max_fare_details_layout);
                    if (findViewById != null) {
                        az b2 = az.b(findViewById);
                        i2 = R.id.max_fare_info;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.max_fare_info);
                        if (constraintLayout2 != null) {
                            i2 = R.id.max_fare_time_validity_divider;
                            View findViewById2 = inflate.findViewById(R.id.max_fare_time_validity_divider);
                            if (findViewById2 != null) {
                                i2 = R.id.pass_details_container;
                                MaterialCardView materialCardView = (MaterialCardView) inflate.findViewById(R.id.pass_details_container);
                                if (materialCardView != null) {
                                    i2 = R.id.pass_divider;
                                    View findViewById3 = inflate.findViewById(R.id.pass_divider);
                                    if (findViewById3 != null) {
                                        i2 = R.id.pass_profile_pic_progressbar;
                                        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.pass_profile_pic_progressbar);
                                        if (progressBar != null) {
                                            i2 = R.id.pass_validity_time;
                                            MaterialTextView materialTextView4 = (MaterialTextView) inflate.findViewById(R.id.pass_validity_time);
                                            if (materialTextView4 != null) {
                                                i2 = R.id.passenger_details_container;
                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) inflate.findViewById(R.id.passenger_details_container);
                                                if (constraintLayout3 != null) {
                                                    i2 = R.id.passenger_string;
                                                    MaterialTextView materialTextView5 = (MaterialTextView) inflate.findViewById(R.id.passenger_string);
                                                    if (materialTextView5 != null) {
                                                        i2 = R.id.productName;
                                                        MaterialTextView materialTextView6 = (MaterialTextView) inflate.findViewById(R.id.productName);
                                                        if (materialTextView6 != null) {
                                                            i2 = R.id.profile_info;
                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) inflate.findViewById(R.id.profile_info);
                                                            if (constraintLayout4 != null) {
                                                                i2 = R.id.profile_name;
                                                                MaterialTextView materialTextView7 = (MaterialTextView) inflate.findViewById(R.id.profile_name);
                                                                if (materialTextView7 != null) {
                                                                    i2 = R.id.profile_pic;
                                                                    CircleImageView circleImageView = (CircleImageView) inflate.findViewById(R.id.profile_pic);
                                                                    if (circleImageView != null) {
                                                                        i2 = R.id.profile_pic_container;
                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) inflate.findViewById(R.id.profile_pic_container);
                                                                        if (constraintLayout5 != null) {
                                                                            i2 = R.id.trip_details_container;
                                                                            View findViewById4 = inflate.findViewById(R.id.trip_details_container);
                                                                            if (findViewById4 != null) {
                                                                                az b3 = az.b(findViewById4);
                                                                                i2 = R.id.trip_details_max_fare_divider;
                                                                                View findViewById5 = inflate.findViewById(R.id.trip_details_max_fare_divider);
                                                                                if (findViewById5 != null) {
                                                                                    i2 = R.id.visible_content;
                                                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) inflate.findViewById(R.id.visible_content);
                                                                                    if (constraintLayout6 != null) {
                                                                                        ow owVar = new ow((ConstraintLayout) inflate, constraintLayout, materialTextView, materialTextView2, materialTextView3, b2, constraintLayout2, findViewById2, materialCardView, findViewById3, progressBar, materialTextView4, constraintLayout3, materialTextView5, materialTextView6, constraintLayout4, materialTextView7, circleImageView, constraintLayout5, b3, findViewById5, constraintLayout6);
                                                                                        n86.d(owVar, "inflate(lInflater)");
                                                                                        return owVar;
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

    @Override // defpackage.pl0
    public void e() {
        Dialog dialog = getDialog();
        Objects.requireNonNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((gl4) dialog).e().M(3);
        T t = this.f;
        n86.c(t);
        ((ow) t).b.setOnClickListener(new p11(this));
        String str = this.h;
        hj1.R0("bottom sheet dialog fragment super pass open", "lName", str, "lSource", "bottom sheet dialog fragment super pass open", Long.MIN_VALUE, "source", str);
    }

    @Override // defpackage.pl0
    public void f() {
        LiveData<SuperPass> d = ((y91) this.i.getValue()).d();
        fh viewLifecycleOwner = getViewLifecycleOwner();
        n86.d(viewLifecycleOwner, "viewLifecycleOwner");
        q11 q11 = new q11(this);
        n86.e(d, "<this>");
        n86.e(viewLifecycleOwner, "lifecycleOwner");
        n86.e(q11, "observer");
        d.f(viewLifecycleOwner, new th1(q11, d));
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("argSource");
            if (string == null) {
                string = "";
            }
            this.h = string;
        }
        super.onCreate(bundle);
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        n86.e(bundle, "outState");
        bundle.putString("argSource", this.h);
        super.onSaveInstanceState(bundle);
    }
}
