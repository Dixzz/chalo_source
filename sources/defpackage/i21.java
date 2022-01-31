package defpackage;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import app.zophop.ui.fragments.superPassValidation.SoundInfoRationaleFragmentSuperPass;

/* renamed from: i21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class i21 implements View.OnClickListener {
    public final /* synthetic */ SoundInfoRationaleFragmentSuperPass f;

    public /* synthetic */ i21(SoundInfoRationaleFragmentSuperPass soundInfoRationaleFragmentSuperPass) {
        this.f = soundInfoRationaleFragmentSuperPass;
    }

    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        SoundInfoRationaleFragmentSuperPass soundInfoRationaleFragmentSuperPass = this.f;
        SoundInfoRationaleFragmentSuperPass.a aVar = SoundInfoRationaleFragmentSuperPass.j;
        n86.e(soundInfoRationaleFragmentSuperPass, "this$0");
        n86.e("sound info rationale up button clicked", "lName");
        n86.e("sound info rationale fragment super pass", "lSource");
        ed1 ed1 = new ed1("sound info rationale up button clicked", Long.MIN_VALUE);
        ed1.a("source", "sound info rationale fragment super pass");
        ui1.m0(ed1);
        ve activity = soundInfoRationaleFragmentSuperPass.c();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.b();
        }
    }
}
