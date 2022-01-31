package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.superPassValidation.SoundVerificationFragmentSuperPass;

/* renamed from: m21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class m21 implements View.OnClickListener {
    public final /* synthetic */ SoundVerificationFragmentSuperPass f;

    public /* synthetic */ m21(SoundVerificationFragmentSuperPass soundVerificationFragmentSuperPass) {
        this.f = soundVerificationFragmentSuperPass;
    }

    public final void onClick(View view) {
        SoundVerificationFragmentSuperPass soundVerificationFragmentSuperPass = this.f;
        SoundVerificationFragmentSuperPass.a aVar = SoundVerificationFragmentSuperPass.i;
        n86.e(soundVerificationFragmentSuperPass, "this$0");
        xt.f3961a.g0().a();
        ed1 ed1 = new ed1("sound verification screen continue clicked", Long.MIN_VALUE);
        ed1.a("isSuperPass", Boolean.TRUE);
        ui1.m0(ed1);
        Intent intent = new Intent(soundVerificationFragmentSuperPass.getContext(), HomeActivity.class);
        intent.setFlags(268468224);
        soundVerificationFragmentSuperPass.startActivity(intent);
    }
}
