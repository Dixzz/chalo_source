package defpackage;

import android.content.DialogInterface;
import app.zophop.ui.fragments.superPassValidation.SoundInfoRationaleFragmentSuperPass;

/* renamed from: j21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class j21 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SoundInfoRationaleFragmentSuperPass f;

    public /* synthetic */ j21(SoundInfoRationaleFragmentSuperPass soundInfoRationaleFragmentSuperPass) {
        this.f = soundInfoRationaleFragmentSuperPass;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SoundInfoRationaleFragmentSuperPass soundInfoRationaleFragmentSuperPass = this.f;
        SoundInfoRationaleFragmentSuperPass.a aVar = SoundInfoRationaleFragmentSuperPass.j;
        n86.e(soundInfoRationaleFragmentSuperPass, "this$0");
        n86.e("sound permission through settings canceled", "lName");
        n86.e("sound info rationale fragment super pass", "lSource");
        ed1 ed1 = new ed1("sound permission through settings canceled", Long.MIN_VALUE);
        ed1.a("source", "sound info rationale fragment super pass");
        ui1.m0(ed1);
        dialogInterface.dismiss();
        soundInfoRationaleFragmentSuperPass.f();
    }
}
