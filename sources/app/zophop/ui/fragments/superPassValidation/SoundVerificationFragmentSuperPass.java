package app.zophop.ui.fragments.superPassValidation;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.enums.TicketVerificationStatus;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

/* compiled from: SoundVerificationFragmentSuperPass.kt */
public final class SoundVerificationFragmentSuperPass extends rl0<gz> {
    public static final a i = new a(null);
    public final j56 g = h.B(this, z86.a(y91.class), new b(this), new c(this));
    public final xi h = new xi(z86.a(l41.class), new d(this));

    /* compiled from: SoundVerificationFragmentSuperPass.kt */
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

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public gz e() {
        View inflate = getLayoutInflater().inflate(R.layout.sound_verification_fragment_super_pass, (ViewGroup) null, false);
        int i2 = R.id.continue_btn;
        Button button = (Button) inflate.findViewById(R.id.continue_btn);
        if (button != null) {
            i2 = R.id.heading;
            MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.heading);
            if (materialTextView != null) {
                i2 = R.id.ticket_status_img;
                ShapeableImageView shapeableImageView = (ShapeableImageView) inflate.findViewById(R.id.ticket_status_img);
                if (shapeableImageView != null) {
                    i2 = R.id.toolbar;
                    MaterialToolbar materialToolbar = (MaterialToolbar) inflate.findViewById(R.id.toolbar);
                    if (materialToolbar != null) {
                        gz gzVar = new gz((ConstraintLayout) inflate, button, materialTextView, shapeableImageView, materialToolbar);
                        n86.d(gzVar, "inflate(layoutInflater)");
                        return gzVar;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    public final y91 f() {
        return (y91) this.g.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        TicketVerificationStatus b2 = ((l41) this.h.getValue()).b();
        n86.d(b2, "args.argVerificationStatus");
        String a2 = ((l41) this.h.getValue()).a();
        n86.d(a2, "args.argSoure");
        ed1 ed1 = new ed1("sound verification screen open", Long.MIN_VALUE);
        ed1.a("verification status", b2.name());
        ed1.a("source", a2);
        ed1.a("isSuperPass", Boolean.TRUE);
        ui1.m0(ed1);
        if (b2 == TicketVerificationStatus.SUCCESS) {
            T t = this.f;
            n86.c(t);
            ((gz) t).d.setImageResource(R.drawable.sound_success);
            T t2 = this.f;
            n86.c(t2);
            ((gz) t2).c.setText(getString(R.string.ticket_verification_success));
        } else if (b2 == TicketVerificationStatus.FAILURE) {
            T t3 = this.f;
            n86.c(t3);
            ((gz) t3).d.setImageResource(R.drawable.sound_failure);
            T t4 = this.f;
            n86.c(t4);
            ((gz) t4).c.setText(getString(R.string.ticket_verification_failed));
        }
        T t5 = this.f;
        n86.c(t5);
        ((gz) t5).e.setNavigationOnClickListener(new l21(this));
        T t6 = this.f;
        n86.c(t6);
        ((gz) t6).b.setOnClickListener(new m21(this));
        LiveData<SuperPass> d2 = f().d();
        fh viewLifecycleOwner = getViewLifecycleOwner();
        n86.d(viewLifecycleOwner, "viewLifecycleOwner");
        n21 n21 = new n21(this);
        n86.e(d2, "<this>");
        n86.e(viewLifecycleOwner, "lifecycleOwner");
        n86.e(n21, "observer");
        d2.f(viewLifecycleOwner, new th1(n21, d2));
    }
}
