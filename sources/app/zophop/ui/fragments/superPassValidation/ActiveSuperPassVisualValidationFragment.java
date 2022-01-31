package app.zophop.ui.fragments.superPassValidation;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import de.hdodenhof.circleimageview.CircleImageView;
import defpackage.ut;
import kotlinx.coroutines.CoroutineExceptionHandler;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: ActiveSuperPassVisualValidationFragment.kt */
public final class ActiveSuperPassVisualValidationFragment extends rl0<ex> {
    public static final a i = new a(null);
    public final j56 g = h.B(this, z86.a(y91.class), new b(this), new c(this));
    public final xi h = new xi(z86.a(q31.class), new d(this));

    /* compiled from: ActiveSuperPassVisualValidationFragment.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

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

    /* compiled from: FragmentNavArgsLazy.kt */
    public static final class d extends o86 implements h76<Bundle> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
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

    public static final ex f(ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment) {
        T t = activeSuperPassVisualValidationFragment.f;
        n86.c(t);
        return (ex) t;
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public ex e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_active_super_pass_visual_validation, (ViewGroup) null, false);
        int i2 = R.id.branding_super_pass;
        View findViewById = inflate.findViewById(R.id.branding_super_pass);
        if (findViewById != null) {
            int i3 = R.id.agency_text_id;
            TextView textView = (TextView) findViewById.findViewById(R.id.agency_text_id);
            if (textView != null) {
                i3 = R.id.bottom_layout;
                ImageView imageView = (ImageView) findViewById.findViewById(R.id.bottom_layout);
                if (imageView != null) {
                    i3 = R.id.dual_logo;
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById.findViewById(R.id.dual_logo);
                    if (relativeLayout != null) {
                        FrameLayout frameLayout = (FrameLayout) findViewById;
                        i3 = R.id.left_logo;
                        ImageView imageView2 = (ImageView) findViewById.findViewById(R.id.left_logo);
                        if (imageView2 != null) {
                            i3 = R.id.right_logo;
                            ImageView imageView3 = (ImageView) findViewById.findViewById(R.id.right_logo);
                            if (imageView3 != null) {
                                rw rwVar = new rw(frameLayout, textView, imageView, relativeLayout, frameLayout, imageView2, imageView3);
                                i2 = R.id.dob;
                                MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.dob);
                                if (materialTextView != null) {
                                    i2 = R.id.dotted_separator_container;
                                    View findViewById2 = inflate.findViewById(R.id.dotted_separator_container);
                                    if (findViewById2 != null) {
                                        i2 = R.id.footer_bus_anim;
                                        GifImageView gifImageView = (GifImageView) inflate.findViewById(R.id.footer_bus_anim);
                                        if (gifImageView != null) {
                                            i2 = R.id.gender;
                                            MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.gender);
                                            if (materialTextView2 != null) {
                                                i2 = R.id.main_layout;
                                                NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.main_layout);
                                                if (nestedScrollView != null) {
                                                    i2 = R.id.max_fare_divider;
                                                    View findViewById3 = inflate.findViewById(R.id.max_fare_divider);
                                                    if (findViewById3 != null) {
                                                        i2 = R.id.max_fare_info;
                                                        View findViewById4 = inflate.findViewById(R.id.max_fare_info);
                                                        if (findViewById4 != null) {
                                                            az b2 = az.b(findViewById4);
                                                            i2 = R.id.pass_details_container;
                                                            MaterialCardView materialCardView = (MaterialCardView) inflate.findViewById(R.id.pass_details_container);
                                                            if (materialCardView != null) {
                                                                i2 = R.id.pass_divider;
                                                                View findViewById5 = inflate.findViewById(R.id.pass_divider);
                                                                if (findViewById5 != null) {
                                                                    i2 = R.id.pass_extension_container;
                                                                    View findViewById6 = inflate.findViewById(R.id.pass_extension_container);
                                                                    if (findViewById6 != null) {
                                                                        py b3 = py.b(findViewById6);
                                                                        i2 = R.id.pass_profile_pic_progressbar;
                                                                        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.pass_profile_pic_progressbar);
                                                                        if (progressBar != null) {
                                                                            i2 = R.id.pass_qr_code;
                                                                            ImageView imageView4 = (ImageView) inflate.findViewById(R.id.pass_qr_code);
                                                                            if (imageView4 != null) {
                                                                                i2 = R.id.pass_validity_time;
                                                                                MaterialTextView materialTextView3 = (MaterialTextView) inflate.findViewById(R.id.pass_validity_time);
                                                                                if (materialTextView3 != null) {
                                                                                    i2 = R.id.pass_validity_time_divider;
                                                                                    View findViewById7 = inflate.findViewById(R.id.pass_validity_time_divider);
                                                                                    if (findViewById7 != null) {
                                                                                        i2 = R.id.passenger_details_container;
                                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.passenger_details_container);
                                                                                        if (constraintLayout != null) {
                                                                                            i2 = R.id.passenger_string;
                                                                                            MaterialTextView materialTextView4 = (MaterialTextView) inflate.findViewById(R.id.passenger_string);
                                                                                            if (materialTextView4 != null) {
                                                                                                i2 = R.id.profile_info;
                                                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.profile_info);
                                                                                                if (constraintLayout2 != null) {
                                                                                                    i2 = R.id.profile_name;
                                                                                                    MaterialTextView materialTextView5 = (MaterialTextView) inflate.findViewById(R.id.profile_name);
                                                                                                    if (materialTextView5 != null) {
                                                                                                        i2 = R.id.profile_pic;
                                                                                                        CircleImageView circleImageView = (CircleImageView) inflate.findViewById(R.id.profile_pic);
                                                                                                        if (circleImageView != null) {
                                                                                                            i2 = R.id.profile_pic_container;
                                                                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) inflate.findViewById(R.id.profile_pic_container);
                                                                                                            if (constraintLayout3 != null) {
                                                                                                                i2 = R.id.tap_qr_code;
                                                                                                                MaterialTextView materialTextView6 = (MaterialTextView) inflate.findViewById(R.id.tap_qr_code);
                                                                                                                if (materialTextView6 != null) {
                                                                                                                    i2 = R.id.time_container;
                                                                                                                    MaterialTextView materialTextView7 = (MaterialTextView) inflate.findViewById(R.id.time_container);
                                                                                                                    if (materialTextView7 != null) {
                                                                                                                        i2 = R.id.toolbar;
                                                                                                                        MaterialToolbar materialToolbar = (MaterialToolbar) inflate.findViewById(R.id.toolbar);
                                                                                                                        if (materialToolbar != null) {
                                                                                                                            i2 = R.id.trip_details_container;
                                                                                                                            View findViewById8 = inflate.findViewById(R.id.trip_details_container);
                                                                                                                            if (findViewById8 != null) {
                                                                                                                                az b4 = az.b(findViewById8);
                                                                                                                                i2 = R.id.visible_content;
                                                                                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) inflate.findViewById(R.id.visible_content);
                                                                                                                                if (constraintLayout4 != null) {
                                                                                                                                    ex exVar = new ex((ConstraintLayout) inflate, rwVar, materialTextView, findViewById2, gifImageView, materialTextView2, nestedScrollView, findViewById3, b2, materialCardView, findViewById5, b3, progressBar, imageView4, materialTextView3, findViewById7, constraintLayout, materialTextView4, constraintLayout2, materialTextView5, circleImageView, constraintLayout3, materialTextView6, materialTextView7, materialToolbar, b4, constraintLayout4);
                                                                                                                                    n86.d(exVar, "inflate(layoutInflater)");
                                                                                                                                    return exVar;
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
            }
            throw new NullPointerException("Missing required view with ID: ".concat(findViewById.getResources().getResourceName(i3)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    public final y91 g() {
        return (y91) this.g.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int i2;
        Window window;
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        ut.a aVar = ut.f3552a;
        ve activity = c();
        if (!(activity == null || (window = activity.getWindow()) == null)) {
            window.setFlags(RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        }
        T t = this.f;
        n86.c(t);
        ((ex) t).o.setNavigationOnClickListener(new n11(this));
        LiveData<SuperPass> d2 = g().d();
        fh viewLifecycleOwner = getViewLifecycleOwner();
        n86.d(viewLifecycleOwner, "viewLifecycleOwner");
        k11 k11 = new k11(this);
        n86.e(d2, "<this>");
        n86.e(viewLifecycleOwner, "lifecycleOwner");
        n86.e(k11, "observer");
        d2.f(viewLifecycleOwner, new th1(k11, d2));
        ah b2 = wg.b(this);
        j31 j31 = new j31(this);
        n86.e(b2, "<this>");
        n86.e(j31, "action");
        hd3.Y1(b2, hj1.s0(CoroutineExceptionHandler.a.f, xb6.b), null, new rh1(1000, j31, null), 2, null);
        Context requireContext = requireContext();
        n86.d(requireContext, "requireContext()");
        q31 q31 = (q31) this.h.getValue();
        SuperPassSubType superPassSubType = g().f;
        String str = g().e;
        ed1 ed1 = new ed1("super pass active visual validation screen opened", Long.MIN_VALUE);
        String a2 = q31.a();
        n86.d(a2, "args.argSource");
        if (a2.length() > 0) {
            ed1.a("source", q31.a());
        }
        n86.e(ed1, "lEvent");
        n86.e(superPassSubType, "superPassSubType");
        n86.e(str, "superPassId");
        hj1.I0(ed1, "isSuperPass", Boolean.TRUE, superPassSubType, "productSubType");
        ed1.a("passId", str);
        try {
            i2 = Settings.System.getInt(requireContext.getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            b00 b00 = b00.f358a;
            b00.a().b(e);
            i2 = -1;
        }
        hj1.u0(i2, ed1, "screen brightness", ed1);
    }
}
