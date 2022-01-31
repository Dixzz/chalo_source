package defpackage;

import android.view.View;
import app.zophop.ui.fragments.superPassValidation.SoundInfoRationaleFragmentSuperPass;

/* renamed from: g21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class g21 implements View.OnClickListener {
    public final /* synthetic */ SoundInfoRationaleFragmentSuperPass f;

    public /* synthetic */ g21(SoundInfoRationaleFragmentSuperPass soundInfoRationaleFragmentSuperPass) {
        this.f = soundInfoRationaleFragmentSuperPass;
    }

    public final void onClick(View view) {
        SoundInfoRationaleFragmentSuperPass soundInfoRationaleFragmentSuperPass = this.f;
        SoundInfoRationaleFragmentSuperPass.a aVar = SoundInfoRationaleFragmentSuperPass.j;
        n86.e(soundInfoRationaleFragmentSuperPass, "this$0");
        n86.e("sound info continue clicked", "lName");
        n86.e("sound info rationale fragment super pass", "lSource");
        ed1 ed1 = new ed1("sound info continue clicked", Long.MIN_VALUE);
        ed1.a("source", "sound info rationale fragment super pass");
        ui1.m0(ed1);
        if (ui1.T(soundInfoRationaleFragmentSuperPass.getContext(), "android.permission.RECORD_AUDIO")) {
            soundInfoRationaleFragmentSuperPass.f();
        } else {
            soundInfoRationaleFragmentSuperPass.i.a("android.permission.RECORD_AUDIO", null);
        }
    }
}
