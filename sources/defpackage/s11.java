package defpackage;

import android.view.View;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;

/* renamed from: s11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class s11 implements View.OnClickListener {
    public final /* synthetic */ hm0 f;
    public final /* synthetic */ SoundFragmentSuperPass g;

    public /* synthetic */ s11(hm0 hm0, SoundFragmentSuperPass soundFragmentSuperPass) {
        this.f = hm0;
        this.g = soundFragmentSuperPass;
    }

    public final void onClick(View view) {
        hm0 hm0 = this.f;
        SoundFragmentSuperPass soundFragmentSuperPass = this.g;
        SoundFragmentSuperPass.a aVar = SoundFragmentSuperPass.j;
        n86.e(soundFragmentSuperPass, "this$0");
        hm0.dismiss();
        soundFragmentSuperPass.i();
    }
}
