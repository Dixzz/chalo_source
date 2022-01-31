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

/* compiled from: ActiveSuperPassFragment.kt */
public final class ActiveSuperPassFragment extends rl0<dx> {
    public static final a i = new a(null);
    public final j56 g = h.B(this, z86.a(y91.class), new b(this), new c(this));
    public final xi h = new xi(z86.a(c31.class), new d(this));

    /* compiled from: ActiveSuperPassFragment.kt */
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

    public static final dx f(ActiveSuperPassFragment activeSuperPassFragment) {
        T t = activeSuperPassFragment.f;
        n86.c(t);
        return (dx) t;
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public dx e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_active_super_pass_screen, (ViewGroup) null, false);
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
                                qw qwVar = new qw(frameLayout, textView, imageView, relativeLayout, frameLayout, imageView2, imageView3);
                                i2 = R.id.dob;
                                MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.dob);
                                if (materialTextView != null) {
                                    i2 = R.id.dotted_separator;
                                    View findViewById2 = inflate.findViewById(R.id.dotted_separator);
                                    if (findViewById2 != null) {
                                        i2 = R.id.dotted_separator_container;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.dotted_separator_container);
                                        if (constraintLayout != null) {
                                            i2 = R.id.footer_bus_anim;
                                            GifImageView gifImageView = (GifImageView) inflate.findViewById(R.id.footer_bus_anim);
                                            if (gifImageView != null) {
                                                i2 = R.id.gender;
                                                MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.gender);
                                                if (materialTextView2 != null) {
                                                    i2 = R.id.iv_circle_end;
                                                    ImageView imageView4 = (ImageView) inflate.findViewById(R.id.iv_circle_end);
                                                    if (imageView4 != null) {
                                                        i2 = R.id.iv_circle_start;
                                                        ImageView imageView5 = (ImageView) inflate.findViewById(R.id.iv_circle_start);
                                                        if (imageView5 != null) {
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
                                                                                        ImageView imageView6 = (ImageView) inflate.findViewById(R.id.pass_qr_code);
                                                                                        if (imageView6 != null) {
                                                                                            i2 = R.id.pass_validity_time;
                                                                                            MaterialTextView materialTextView3 = (MaterialTextView) inflate.findViewById(R.id.pass_validity_time);
                                                                                            if (materialTextView3 != null) {
                                                                                                i2 = R.id.passenger_details_container;
                                                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.passenger_details_container);
                                                                                                if (constraintLayout2 != null) {
                                                                                                    i2 = R.id.passenger_string;
                                                                                                    MaterialTextView materialTextView4 = (MaterialTextView) inflate.findViewById(R.id.passenger_string);
                                                                                                    if (materialTextView4 != null) {
                                                                                                        i2 = R.id.profile_info;
                                                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) inflate.findViewById(R.id.profile_info);
                                                                                                        if (constraintLayout3 != null) {
                                                                                                            i2 = R.id.profile_name;
                                                                                                            MaterialTextView materialTextView5 = (MaterialTextView) inflate.findViewById(R.id.profile_name);
                                                                                                            if (materialTextView5 != null) {
                                                                                                                i2 = R.id.profile_pic;
                                                                                                                CircleImageView circleImageView = (CircleImageView) inflate.findViewById(R.id.profile_pic);
                                                                                                                if (circleImageView != null) {
                                                                                                                    i2 = R.id.profile_pic_container;
                                                                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) inflate.findViewById(R.id.profile_pic_container);
                                                                                                                    if (constraintLayout4 != null) {
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
                                                                                                                                    View findViewById7 = inflate.findViewById(R.id.trip_details_container);
                                                                                                                                    if (findViewById7 != null) {
                                                                                                                                        az b4 = az.b(findViewById7);
                                                                                                                                        i2 = R.id.visible_content;
                                                                                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) inflate.findViewById(R.id.visible_content);
                                                                                                                                        if (constraintLayout5 != null) {
                                                                                                                                            dx dxVar = new dx((ConstraintLayout) inflate, qwVar, materialTextView, findViewById2, constraintLayout, gifImageView, materialTextView2, imageView4, imageView5, nestedScrollView, findViewById3, b2, materialCardView, findViewById5, b3, progressBar, imageView6, materialTextView3, constraintLayout2, materialTextView4, constraintLayout3, materialTextView5, circleImageView, constraintLayout4, materialTextView6, materialTextView7, materialToolbar, b4, constraintLayout5);
                                                                                                                                            n86.d(dxVar, "inflate(layoutInflater)");
                                                                                                                                            return dxVar;
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
        ((dx) t).n.setNavigationOnClickListener(new y01(this));
        LiveData<SuperPass> d2 = g().d();
        fh viewLifecycleOwner = getViewLifecycleOwner();
        n86.d(viewLifecycleOwner, "viewLifecycleOwner");
        b11 b11 = new b11(this);
        n86.e(d2, "<this>");
        n86.e(viewLifecycleOwner, "lifecycleOwner");
        n86.e(b11, "observer");
        d2.f(viewLifecycleOwner, new th1(b11, d2));
        ah b2 = wg.b(this);
        v21 v21 = new v21(this);
        n86.e(b2, "<this>");
        n86.e(v21, "action");
        hd3.Y1(b2, hj1.s0(CoroutineExceptionHandler.a.f, xb6.b), null, new rh1(1000, v21, null), 2, null);
        Context requireContext = requireContext();
        n86.d(requireContext, "requireContext()");
        c31 c31 = (c31) this.h.getValue();
        SuperPassSubType superPassSubType = g().f;
        String str = g().e;
        ed1 ed1 = new ed1("super pass active screen opened", Long.MIN_VALUE);
        String a2 = c31.a();
        n86.d(a2, "args.argSource");
        if (a2.length() > 0) {
            ed1.a("source", c31.a());
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
