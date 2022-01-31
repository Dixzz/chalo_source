package app.zophop.ui.fragments.superPassValidation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.ui.activities.SuperPassValidationActivity;
import java.util.Objects;

/* compiled from: SoundInfoRationaleFragmentSuperPass.kt */
public final class SoundInfoRationaleFragmentSuperPass extends rl0<ox> {
    public static final a j = new a(null);
    public final xi g = new xi(z86.a(i41.class), new b(this));
    public final r<Intent> h;
    public final r<String> i;

    /* compiled from: SoundInfoRationaleFragmentSuperPass.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* compiled from: FragmentNavArgsLazy.kt */
    public static final class b extends o86 implements h76<Bundle> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
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

    public SoundInfoRationaleFragmentSuperPass() {
        r<Intent> registerForActivityResult = registerForActivityResult(new w(), new f21(this));
        n86.d(registerForActivityResult, "registerForActivityResul…SoundFragment()\n        }");
        this.h = registerForActivityResult;
        r<String> registerForActivityResult2 = registerForActivityResult(new v(), new h21(this));
        n86.d(registerForActivityResult2, "registerForActivityResul…)\n            }\n        }");
        this.i = registerForActivityResult2;
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public ox e() {
        ox b2 = ox.b(getLayoutInflater());
        n86.d(b2, "inflate(layoutInflater)");
        return b2;
    }

    public final void f() {
        ve activity = c();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type app.zophop.ui.activities.SuperPassValidationActivity");
        ((SuperPassValidationActivity) activity).q0();
        vh1 vh1 = vh1.f3649a;
        n86.f(this, "$this$findNavController");
        NavController d = NavHostFragment.d(this);
        n86.b(d, "NavHostFragment.findNavController(this)");
        k41 k41 = new k41(null);
        k41.f2017a.put("arg_source", "sound info rationale fragment super pass");
        k41.f2017a.put("arg_can_show_sound_info", Boolean.FALSE);
        n86.d(k41, "actionSoundInfoRationale…rgCanShowSoundInfo(false)");
        vh1.a(d, k41);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        String a2 = ((i41) this.g.getValue()).a();
        n86.d(a2, "navArgs.argSource");
        n86.e("sound info rationale screen open", "lName");
        n86.e(a2, "lSource");
        ed1 ed1 = new ed1("sound info rationale screen open", Long.MIN_VALUE);
        ed1.a("source", a2);
        ui1.m0(ed1);
        T t = this.f;
        n86.c(t);
        ((ox) t).b.setOnClickListener(new g21(this));
        ve activity = c();
        if (!(activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null)) {
            h.e(onBackPressedDispatcher, this, false, new h41(this), 2);
        }
        T t2 = this.f;
        n86.c(t2);
        ((ox) t2).c.setNavigationOnClickListener(new i21(this));
    }
}
