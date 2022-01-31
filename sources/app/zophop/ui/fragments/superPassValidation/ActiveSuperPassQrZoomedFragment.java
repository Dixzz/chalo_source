package app.zophop.ui.fragments.superPassValidation;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: ActiveSuperPassQrZoomedFragment.kt */
public final class ActiveSuperPassQrZoomedFragment extends rl0<fx> {
    public static final a h = new a(null);
    public final j56 g = h.B(this, z86.a(y91.class), new b(this), new c(this));

    /* compiled from: ActiveSuperPassQrZoomedFragment.kt */
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

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public fx e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_active_super_pass_zoomed, (ViewGroup) null, false);
        int i = R.id.qr_code_zoomed;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.qr_code_zoomed);
        if (imageView != null) {
            i = R.id.toolbar;
            MaterialToolbar materialToolbar = (MaterialToolbar) inflate.findViewById(R.id.toolbar);
            if (materialToolbar != null) {
                fx fxVar = new fx((ConstraintLayout) inflate, imageView, materialToolbar);
                n86.d(fxVar, "inflate(layoutInflater)");
                return fxVar;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    public final y91 f() {
        return (y91) this.g.getValue();
    }

    public final void g(float f) {
        Window window;
        ve activity = c();
        Window window2 = null;
        WindowManager.LayoutParams attributes = (activity == null || (window = activity.getWindow()) == null) ? null : window.getAttributes();
        if (attributes != null) {
            if (!(attributes.screenBrightness == f)) {
                attributes.screenBrightness = f;
                ve activity2 = c();
                if (activity2 != null) {
                    window2 = activity2.getWindow();
                }
                if (window2 != null) {
                    window2.setAttributes(attributes);
                }
            }
        }
    }

    @Override // defpackage.rl0, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        g(-1.0f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        g(1.0f);
        LiveData<SuperPass> d = f().d();
        fh viewLifecycleOwner = getViewLifecycleOwner();
        n86.d(viewLifecycleOwner, "viewLifecycleOwner");
        g11 g11 = new g11(this, new z25(), (int) ((float) getResources().getDisplayMetrics().widthPixels));
        n86.e(d, "<this>");
        n86.e(viewLifecycleOwner, "lifecycleOwner");
        n86.e(g11, "observer");
        d.f(viewLifecycleOwner, new th1(g11, d));
        T t = this.f;
        n86.c(t);
        ((fx) t).c.setNavigationOnClickListener(new h11(this));
        gi1.i(gi1.f1265a, "super pass active qr zoomed screen opened", f().f, f().e, "active super pass qr zoomed fragment", 0, 16);
        LiveData<SuperPass> d2 = f().d();
        fh viewLifecycleOwner2 = getViewLifecycleOwner();
        n86.d(viewLifecycleOwner2, "viewLifecycleOwner");
        c11 c11 = new c11(this);
        n86.e(d2, "<this>");
        n86.e(viewLifecycleOwner2, "lifecycleOwner");
        n86.e(c11, "observer");
        d2.f(viewLifecycleOwner2, new th1(c11, d2));
    }
}
