package defpackage;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.ui.activities.SuperPassValidationActivity;
import app.zophop.ui.fragments.superPassValidation.SoundInfoFragmentSuperPass;
import java.util.Objects;

/* renamed from: d21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class d21 implements View.OnClickListener {
    public final /* synthetic */ SoundInfoFragmentSuperPass f;

    public /* synthetic */ d21(SoundInfoFragmentSuperPass soundInfoFragmentSuperPass) {
        this.f = soundInfoFragmentSuperPass;
    }

    public final void onClick(View view) {
        SoundInfoFragmentSuperPass soundInfoFragmentSuperPass = this.f;
        SoundInfoFragmentSuperPass.a aVar = SoundInfoFragmentSuperPass.i;
        n86.e(soundInfoFragmentSuperPass, "this$0");
        n86.e("sound info got it clicked", "lName");
        n86.e("Sound info fragment super pass", "lSource");
        ed1 ed1 = new ed1("sound info got it clicked", Long.MIN_VALUE);
        ed1.a("source", "Sound info fragment super pass");
        ui1.m0(ed1);
        xt.f3961a.l().put("keySoundFragmentTutorialShown", "true");
        ve activity = soundInfoFragmentSuperPass.c();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type app.zophop.ui.activities.SuperPassValidationActivity");
        ((SuperPassValidationActivity) activity).q0();
        vh1 vh1 = vh1.f3649a;
        n86.f(soundInfoFragmentSuperPass, "$this$findNavController");
        NavController d = NavHostFragment.d(soundInfoFragmentSuperPass);
        n86.b(d, "NavHostFragment.findNavController(this)");
        g41 g41 = new g41(null);
        g41.f1212a.put("arg_source", "Sound info fragment super pass");
        g41.f1212a.put("arg_can_show_sound_info", Boolean.FALSE);
        n86.d(g41, "actionSoundInfoFragmentS…rgCanShowSoundInfo(false)");
        vh1.a(d, g41);
    }
}
