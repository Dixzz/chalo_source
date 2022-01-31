package defpackage;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.ui.activities.ValidationScreen;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Objects;

/* renamed from: mw0  reason: default package */
/* compiled from: SoundInfoFragment.kt */
public final class mw0 extends pl0<fz> {
    public static final a j = new a(null);
    public final r<String> h;
    public String i;

    /* renamed from: mw0$a */
    /* compiled from: SoundInfoFragment.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* renamed from: mw0$b */
    /* compiled from: SoundInfoFragment.kt */
    public static final class b extends BottomSheetBehavior.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior<FrameLayout> f2451a;

        public b(BottomSheetBehavior<FrameLayout> bottomSheetBehavior) {
            this.f2451a = bottomSheetBehavior;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void a(View view, float f) {
            n86.e(view, "bottomSheet");
            this.f2451a.M(3);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void b(View view, int i) {
            n86.e(view, "bottomSheet");
            this.f2451a.M(3);
        }
    }

    public mw0() {
        r<String> registerForActivityResult = registerForActivityResult(new v(), new cs0(this));
        n86.d(registerForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.h = registerForActivityResult;
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
        xt.f3961a.l().put("keySoundFragmentTutorialShown", "true");
        T t = this.f;
        n86.c(t);
        ((fz) t).b.setOnClickListener(new bs0(this, "android.permission.RECORD_AUDIO"));
        String str = this.i;
        if (str != null) {
            hj1.R0("sound info screen open", "lName", str, "lSource", "sound info screen open", Long.MIN_VALUE, "source", str);
        } else {
            n86.l("argSource");
            throw null;
        }
    }

    @Override // defpackage.pl0
    public void f() {
    }

    public final void g() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        int i2 = ValidationScreen.u;
        Fragment I = parentFragmentManager.I("sound_fragment");
        if (I instanceof hw0) {
            hw0 hw0 = (hw0) I;
            hw0.y = true;
            hw0.f();
        }
        dismiss();
    }
}
