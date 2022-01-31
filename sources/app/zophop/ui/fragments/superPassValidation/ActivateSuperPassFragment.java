package app.zophop.ui.fragments.superPassValidation;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textview.MaterialTextView;
import de.hdodenhof.circleimageview.CircleImageView;
import defpackage.xt;
import java.util.HashMap;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: ActivateSuperPassFragment.kt */
public final class ActivateSuperPassFragment extends rl0<cx> {
    public static final a h = new a(null);
    public final j56 g = h.B(this, z86.a(y91.class), new c(this), new d(this));

    /* compiled from: ActivateSuperPassFragment.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    @y66(c = "app.zophop.ui.fragments.superPassValidation.ActivateSuperPassFragment$navigateToQRScreen$1", f = "ActivateSuperPassFragment.kt", l = {}, m = "invokeSuspend")
    /* compiled from: ActivateSuperPassFragment.kt */
    public static final class b extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public final /* synthetic */ ActivateSuperPassFragment f;
        public final /* synthetic */ SuperPass g;
        public final /* synthetic */ long h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ActivateSuperPassFragment activateSuperPassFragment, SuperPass superPass, long j, k66<? super b> k66) {
            super(2, k66);
            this.f = activateSuperPassFragment;
            this.g = superPass;
            this.h = j;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new b(this.f, this.g, this.h, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            b bVar = new b(this.f, this.g, this.h, k66);
            s56 s56 = s56.f3190a;
            bVar.invokeSuspend(s56);
            return s56;
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0135  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x016d  */
        @Override // defpackage.u66
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
            // Method dump skipped, instructions count: 390
            */
            throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.fragments.superPassValidation.ActivateSuperPassFragment.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class c extends o86 implements h76<gi> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
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
    public static final class d extends o86 implements h76<ci> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
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

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public cx e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_activate_super_pass, (ViewGroup) null, false);
        int i = R.id.activate_pass_bottom_sheet;
        View findViewById = inflate.findViewById(R.id.activate_pass_bottom_sheet);
        int i2 = R.id.pass_divider;
        if (findViewById != null) {
            int i3 = R.id.activate_btn;
            TextView textView = (TextView) findViewById.findViewById(R.id.activate_btn);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) findViewById;
                i3 = R.id.activation_text;
                TextView textView2 = (TextView) findViewById.findViewById(R.id.activation_text);
                if (textView2 != null) {
                    i3 = R.id.activation_title;
                    TextView textView3 = (TextView) findViewById.findViewById(R.id.activation_title);
                    if (textView3 != null) {
                        i3 = R.id.iv_activation_lock;
                        ImageView imageView = (ImageView) findViewById.findViewById(R.id.iv_activation_lock);
                        if (imageView != null) {
                            i3 = R.id.view_receipts_btn;
                            TextView textView4 = (TextView) findViewById.findViewById(R.id.view_receipts_btn);
                            if (textView4 != null) {
                                xv xvVar = new xv(linearLayout, textView, linearLayout, textView2, textView3, imageView, textView4);
                                i = R.id.content_layout;
                                ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.content_layout);
                                if (constraintLayout != null) {
                                    i = R.id.dob;
                                    MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.dob);
                                    if (materialTextView != null) {
                                        i = R.id.gender;
                                        MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.gender);
                                        if (materialTextView2 != null) {
                                            i = R.id.main_layout;
                                            ScrollView scrollView = (ScrollView) inflate.findViewById(R.id.main_layout);
                                            if (scrollView != null) {
                                                i = R.id.materialTextView;
                                                MaterialTextView materialTextView3 = (MaterialTextView) inflate.findViewById(R.id.materialTextView);
                                                if (materialTextView3 != null) {
                                                    i = R.id.max_fare_details_layout;
                                                    View findViewById2 = inflate.findViewById(R.id.max_fare_details_layout);
                                                    if (findViewById2 != null) {
                                                        az b2 = az.b(findViewById2);
                                                        i = R.id.max_fare_divider;
                                                        View findViewById3 = inflate.findViewById(R.id.max_fare_divider);
                                                        if (findViewById3 != null) {
                                                            i = R.id.max_fare_info;
                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.max_fare_info);
                                                            if (constraintLayout2 != null) {
                                                                i = R.id.max_fare_time_validity_divider;
                                                                View findViewById4 = inflate.findViewById(R.id.max_fare_time_validity_divider);
                                                                if (findViewById4 != null) {
                                                                    View findViewById5 = inflate.findViewById(R.id.pass_divider);
                                                                    if (findViewById5 != null) {
                                                                        i = R.id.pass_extension_activate_pass_screen;
                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) inflate.findViewById(R.id.pass_extension_activate_pass_screen);
                                                                        if (constraintLayout3 != null) {
                                                                            i = R.id.pass_profile_pic_progressbar;
                                                                            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.pass_profile_pic_progressbar);
                                                                            if (progressBar != null) {
                                                                                i = R.id.profile_info;
                                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) inflate.findViewById(R.id.profile_info);
                                                                                if (constraintLayout4 != null) {
                                                                                    i = R.id.profile_name;
                                                                                    MaterialTextView materialTextView4 = (MaterialTextView) inflate.findViewById(R.id.profile_name);
                                                                                    if (materialTextView4 != null) {
                                                                                        i = R.id.profile_pic;
                                                                                        CircleImageView circleImageView = (CircleImageView) inflate.findViewById(R.id.profile_pic);
                                                                                        if (circleImageView != null) {
                                                                                            i = R.id.profile_pic_container;
                                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) inflate.findViewById(R.id.profile_pic_container);
                                                                                            if (constraintLayout5 != null) {
                                                                                                i = R.id.ride_details_layout;
                                                                                                View findViewById6 = inflate.findViewById(R.id.ride_details_layout);
                                                                                                if (findViewById6 != null) {
                                                                                                    az b3 = az.b(findViewById6);
                                                                                                    i = R.id.route_container;
                                                                                                    View findViewById7 = inflate.findViewById(R.id.route_container);
                                                                                                    if (findViewById7 != null) {
                                                                                                        TextView textView5 = (TextView) findViewById7.findViewById(R.id.edit_route_pass);
                                                                                                        if (textView5 != null) {
                                                                                                            View findViewById8 = findViewById7.findViewById(R.id.pass_divider);
                                                                                                            if (findViewById8 != null) {
                                                                                                                i2 = R.id.route_details;
                                                                                                                TextView textView6 = (TextView) findViewById7.findViewById(R.id.route_details);
                                                                                                                if (textView6 != null) {
                                                                                                                    LinearLayout linearLayout2 = (LinearLayout) findViewById7;
                                                                                                                    i2 = R.id.route_layout;
                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) findViewById7.findViewById(R.id.route_layout);
                                                                                                                    if (linearLayout3 != null) {
                                                                                                                        i2 = R.id.route_number;
                                                                                                                        TextView textView7 = (TextView) findViewById7.findViewById(R.id.route_number);
                                                                                                                        if (textView7 != null) {
                                                                                                                            i2 = R.id.route_title;
                                                                                                                            TextView textView8 = (TextView) findViewById7.findViewById(R.id.route_title);
                                                                                                                            if (textView8 != null) {
                                                                                                                                bz bzVar = new bz(linearLayout2, textView5, findViewById8, textView6, linearLayout2, linearLayout3, textView7, textView8);
                                                                                                                                i = R.id.shadow;
                                                                                                                                View findViewById9 = inflate.findViewById(R.id.shadow);
                                                                                                                                if (findViewById9 != null) {
                                                                                                                                    i = R.id.super_pass_details_layout;
                                                                                                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) inflate.findViewById(R.id.super_pass_details_layout);
                                                                                                                                    if (constraintLayout6 != null) {
                                                                                                                                        i = R.id.super_pass_validity_time;
                                                                                                                                        MaterialTextView materialTextView5 = (MaterialTextView) inflate.findViewById(R.id.super_pass_validity_time);
                                                                                                                                        if (materialTextView5 != null) {
                                                                                                                                            i = R.id.toolbar;
                                                                                                                                            MaterialToolbar materialToolbar = (MaterialToolbar) inflate.findViewById(R.id.toolbar);
                                                                                                                                            if (materialToolbar != null) {
                                                                                                                                                i = R.id.trip_details;
                                                                                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) inflate.findViewById(R.id.trip_details);
                                                                                                                                                if (constraintLayout7 != null) {
                                                                                                                                                    cx cxVar = new cx((ConstraintLayout) inflate, xvVar, constraintLayout, materialTextView, materialTextView2, scrollView, materialTextView3, b2, findViewById3, constraintLayout2, findViewById4, findViewById5, constraintLayout3, progressBar, constraintLayout4, materialTextView4, circleImageView, constraintLayout5, b3, bzVar, findViewById9, constraintLayout6, materialTextView5, materialToolbar, constraintLayout7);
                                                                                                                                                    n86.d(cxVar, "inflate(layoutInflater)");
                                                                                                                                                    return cxVar;
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
                                                                                                        } else {
                                                                                                            i2 = R.id.edit_route_pass;
                                                                                                        }
                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(findViewById7.getResources().getResourceName(i2)));
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        i = R.id.pass_divider;
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
            throw new NullPointerException("Missing required view with ID: ".concat(findViewById.getResources().getResourceName(i3)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    public final y91 f() {
        return (y91) this.g.getValue();
    }

    public final void g(SuperPass superPass) {
        long Q = ui1.Q();
        superPass.saveActivationTimeStamp(Q);
        xt.t1 t1Var = xt.f3961a;
        t1Var.p().c(superPass, Q);
        ah b2 = wg.b(this);
        xb6 xb6 = xb6.f3911a;
        hd3.Y1(b2, hj1.t0(CoroutineExceptionHandler.a.f, xf6.c), null, new b(this, superPass, Q, null), 2, null);
        zz zzVar = new zz("pass activated", new HashMap());
        zzVar.a("date", jh1.c(ui1.Q()));
        zzVar.a("time", jh1.g(ui1.Q()));
        ui1.l0(zzVar);
        ed1 ed1 = new ed1("pass activated", Long.MIN_VALUE);
        if (t1Var.B().h() != null) {
            LatLng h2 = t1Var.B().h();
            ed1.a("long", hj1.U(hj1.f0(ed1, "lat", hj1.U(new StringBuilder(), h2.latitude, "")), h2.longitude, ""));
        }
        ed1.a("source", "Activate Super pass Screen");
        gi1.f1265a.d(ed1, superPass);
        ui1.m0(ed1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        T t = this.f;
        n86.c(t);
        ((cx) t).n.setNavigationOnClickListener(new n01(this));
        T t2 = this.f;
        n86.c(t2);
        LinearLayout linearLayout = ((cx) t2).l.b;
        n86.d(linearLayout, "viewBinding.routeContainer.routeDetailsContainer");
        linearLayout.setVisibility(8);
        T t3 = this.f;
        n86.c(t3);
        TextView textView = ((cx) t3).b.e;
        n86.d(textView, "viewBinding.activatePass…ttomSheet.viewReceiptsBtn");
        textView.setVisibility(0);
        LiveData<SuperPass> d2 = f().d();
        fh viewLifecycleOwner = getViewLifecycleOwner();
        n86.d(viewLifecycleOwner, "viewLifecycleOwner");
        o01 o01 = new o01(this);
        n86.e(d2, "<this>");
        n86.e(viewLifecycleOwner, "lifecycleOwner");
        n86.e(o01, "observer");
        d2.f(viewLifecycleOwner, new th1(o01, d2));
    }
}
