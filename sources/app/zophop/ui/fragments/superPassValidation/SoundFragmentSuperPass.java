package app.zophop.ui.fragments.superPassValidation;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: SoundFragmentSuperPass.kt */
public final class SoundFragmentSuperPass extends ul0<dz> {
    public static final a j = new a(null);
    public final j56 g = h.B(this, z86.a(y91.class), new e(this), new f(this));
    public x91 h;
    public final xi i = new xi(z86.a(a41.class), new g(this));

    /* compiled from: SoundFragmentSuperPass.kt */
    public static final class a {
        public a(j86 j86) {
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

    /* compiled from: SoundFragmentSuperPass.kt */
    public static final class d extends o86 implements h76<ci> {
        public final /* synthetic */ SoundFragmentSuperPass f;
        public final /* synthetic */ boolean g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(SoundFragmentSuperPass soundFragmentSuperPass, boolean z) {
            super(0);
            this.f = soundFragmentSuperPass;
            this.g = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new xh(this.f.requireActivity().getApplication(), this.f, h.j(new m56("keyCanShowSoundInfo", Boolean.valueOf(this.g))));
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
        View inflate = getLayoutInflater().inflate(R.layout.sound_fragment_super_pass, (ViewGroup) null, false);
        int i2 = R.id.bottom_sheet;
        View findViewById = inflate.findViewById(R.id.bottom_sheet);
        if (findViewById != null) {
            int i3 = R.id.pass_profile_pic_progressbar;
            ProgressBar progressBar = (ProgressBar) findViewById.findViewById(R.id.pass_profile_pic_progressbar);
            if (progressBar != null) {
                i3 = R.id.product_name;
                MaterialTextView materialTextView = (MaterialTextView) findViewById.findViewById(R.id.product_name);
                if (materialTextView != null) {
                    i3 = R.id.profile_pic;
                    CircleImageView circleImageView = (CircleImageView) findViewById.findViewById(R.id.profile_pic);
                    if (circleImageView != null) {
                        i3 = R.id.ref_code_container;
                        View findViewById2 = findViewById.findViewById(R.id.ref_code_container);
                        if (findViewById2 != null) {
                            int i4 = R.id.ref_code;
                            MaterialTextView materialTextView2 = (MaterialTextView) findViewById2.findViewById(R.id.ref_code);
                            if (materialTextView2 != null) {
                                i4 = R.id.ref_code_hash;
                                MaterialTextView materialTextView3 = (MaterialTextView) findViewById2.findViewById(R.id.ref_code_hash);
                                if (materialTextView3 != null) {
                                    i4 = R.id.reference_code_title;
                                    MaterialTextView materialTextView4 = (MaterialTextView) findViewById2.findViewById(R.id.reference_code_title);
                                    if (materialTextView4 != null) {
                                        zy zyVar = new zy((ConstraintLayout) findViewById2, materialTextView2, materialTextView3, materialTextView4);
                                        MaterialTextView materialTextView5 = (MaterialTextView) findViewById.findViewById(R.id.view_details);
                                        if (materialTextView5 != null) {
                                            ez ezVar = new ez((MaterialCardView) findViewById, progressBar, materialTextView, circleImageView, zyVar, materialTextView5);
                                            i2 = R.id.btn_tap_here;
                                            MaterialTextView materialTextView6 = (MaterialTextView) inflate.findViewById(R.id.btn_tap_here);
                                            if (materialTextView6 != null) {
                                                i2 = R.id.heading;
                                                MaterialTextView materialTextView7 = (MaterialTextView) inflate.findViewById(R.id.heading);
                                                if (materialTextView7 != null) {
                                                    i2 = R.id.not_able_to_verify;
                                                    MaterialTextView materialTextView8 = (MaterialTextView) inflate.findViewById(R.id.not_able_to_verify);
                                                    if (materialTextView8 != null) {
                                                        i2 = R.id.ticket_status_img;
                                                        ShapeableImageView shapeableImageView = (ShapeableImageView) inflate.findViewById(R.id.ticket_status_img);
                                                        if (shapeableImageView != null) {
                                                            i2 = R.id.toolbar;
                                                            MaterialToolbar materialToolbar = (MaterialToolbar) inflate.findViewById(R.id.toolbar);
                                                            if (materialToolbar != null) {
                                                                dz dzVar = new dz((ConstraintLayout) inflate, ezVar, materialTextView6, materialTextView7, materialTextView8, shapeableImageView, materialToolbar);
                                                                n86.d(dzVar, "inflate(layoutInflater)");
                                                                return dzVar;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            i3 = R.id.view_details;
                                        }
                                    }
                                }
                            }
                            throw new NullPointerException("Missing required view with ID: ".concat(findViewById2.getResources().getResourceName(i4)));
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(findViewById.getResources().getResourceName(i3)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // defpackage.ul0
    public void f() {
        this.h = (x91) ((ai) h.B(this, z86.a(x91.class), new c(new b(this)), new d(this, ((a41) this.i.getValue()).a()))).getValue();
    }

    @Override // defpackage.ul0
    public void g() {
        LiveData<SuperPass> d2 = j().d();
        fh viewLifecycleOwner = getViewLifecycleOwner();
        n86.d(viewLifecycleOwner, "viewLifecycleOwner");
        r11 r11 = new r11(this);
        n86.e(d2, "<this>");
        n86.e(viewLifecycleOwner, "lifecycleOwner");
        n86.e(r11, "observer");
        d2.f(viewLifecycleOwner, new th1(r11, d2));
    }

    @Override // defpackage.ul0
    public void h() {
        ml1<zq1> k = gl1.g(c()).k();
        k.g(Integer.valueOf((int) R.drawable.sound_waiting));
        T t = this.f;
        n86.c(t);
        k.e(((dz) t).e);
        T t2 = this.f;
        n86.c(t2);
        ((dz) t2).d.setText(getResources().getString(R.string.not_able_to_verify_pass));
        T t3 = this.f;
        n86.c(t3);
        ((dz) t3).b.f1046a.setOnClickListener(new y11(this));
        T t4 = this.f;
        n86.c(t4);
        ((dz) t4).c.setOnClickListener(new x11(this));
        T t5 = this.f;
        n86.c(t5);
        ((dz) t5).f.setNavigationOnClickListener(new z11(this));
        gi1.i(gi1.f1265a, "sound details screen open", j().f, j().e, "sound fragment", 0, 16);
    }

    public final void i() {
        Fragment fragment;
        if (xt.f3961a.g0().b()) {
            k();
            return;
        }
        try {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            n86.e("head phones detected", "tag");
            if (parentFragmentManager == null) {
                fragment = null;
            } else {
                fragment = parentFragmentManager.I("head phones detected");
            }
            ue ueVar = (ue) fragment;
            if (ueVar != null) {
                ueVar.dismiss();
            }
        } catch (Exception e2) {
            b00 b00 = b00.f358a;
            b00.a().b(e2);
        }
        if (getView() != null) {
            LiveData<SuperPass> d2 = j().d();
            fh viewLifecycleOwner = getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            c21 c21 = new c21(this);
            n86.e(d2, "<this>");
            n86.e(viewLifecycleOwner, "lifecycleOwner");
            n86.e(c21, "observer");
            d2.f(viewLifecycleOwner, new th1(c21, d2));
        }
    }

    public final y91 j() {
        return (y91) this.g.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x008d A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008e A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b2 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b7 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b8 A[Catch:{ Exception -> 0x00c9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k() {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass.k():void");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        xt.f3961a.g0().a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ah b2 = wg.b(this);
        xb6 xb6 = xb6.f3911a;
        hd3.Y1(b2, hj1.t0(CoroutineExceptionHandler.a.f, xf6.c), null, new w31(this, null), 2, null);
    }
}
