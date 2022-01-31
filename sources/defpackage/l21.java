package defpackage;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import app.zophop.ui.fragments.superPassValidation.SoundVerificationFragmentSuperPass;

/* renamed from: l21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class l21 implements View.OnClickListener {
    public final /* synthetic */ SoundVerificationFragmentSuperPass f;

    public /* synthetic */ l21(SoundVerificationFragmentSuperPass soundVerificationFragmentSuperPass) {
        this.f = soundVerificationFragmentSuperPass;
    }

    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        SoundVerificationFragmentSuperPass soundVerificationFragmentSuperPass = this.f;
        SoundVerificationFragmentSuperPass.a aVar = SoundVerificationFragmentSuperPass.i;
        n86.e(soundVerificationFragmentSuperPass, "this$0");
        ve activity = soundVerificationFragmentSuperPass.c();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.b();
        }
    }
}
