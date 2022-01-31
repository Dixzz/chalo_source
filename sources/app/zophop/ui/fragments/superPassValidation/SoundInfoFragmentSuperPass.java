package app.zophop.ui.fragments.superPassValidation;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Objects;

/* compiled from: SoundInfoFragmentSuperPass.kt */
public final class SoundInfoFragmentSuperPass extends pl0<fz> {
    public static final a i = new a(null);
    public final xi h = new xi(z86.a(e41.class), new c(this));

    /* compiled from: SoundInfoFragmentSuperPass.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* compiled from: SoundInfoFragmentSuperPass.kt */
    public static final class b extends BottomSheetBehavior.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior<FrameLayout> f316a;

        public b(BottomSheetBehavior<FrameLayout> bottomSheetBehavior) {
            this.f316a = bottomSheetBehavior;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void a(View view, float f) {
            n86.e(view, "bottomSheet");
            this.f316a.M(3);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void b(View view, int i) {
            n86.e(view, "bottomSheet");
            this.f316a.M(3);
        }
    }

    /* compiled from: FragmentNavArgsLazy.kt */
    public static final class c extends o86 implements h76<Bundle> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
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
    @Override // defpackage.pl0
    public fz d(LayoutInflater layoutInflater) {
        n86.e(layoutInflater, "lInflater");
        fz b2 = fz.b(layoutInflater);
        n86.d(b2, "inflate(lInflater)");
        return b2;
    }

    @Override // defpackage.pl0
    public void e() {
        Dialog dialog = getDialog();
        Objects.requireNonNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetBehavior<FrameLayout> e = ((gl4) dialog).e();
        e.M(3);
        setCancelable(false);
        b bVar = new b(e);
        if (!e.I.contains(bVar)) {
            e.I.add(bVar);
        }
        T t = this.f;
        n86.c(t);
        ((fz) t).b.setOnClickListener(new d21(this));
        String a2 = ((e41) this.h.getValue()).a();
        n86.d(a2, "navArgs.argSource");
        n86.e("sound info screen open", "lName");
        n86.e(a2, "lSource");
        hj1.P0("sound info screen open", Long.MIN_VALUE, "source", a2);
    }

    @Override // defpackage.pl0
    public void f() {
    }
}
