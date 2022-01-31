package defpackage;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;

/* renamed from: z11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class z11 implements View.OnClickListener {
    public final /* synthetic */ SoundFragmentSuperPass f;

    public /* synthetic */ z11(SoundFragmentSuperPass soundFragmentSuperPass) {
        this.f = soundFragmentSuperPass;
    }

    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        SoundFragmentSuperPass soundFragmentSuperPass = this.f;
        SoundFragmentSuperPass.a aVar = SoundFragmentSuperPass.j;
        n86.e(soundFragmentSuperPass, "this$0");
        ve activity = soundFragmentSuperPass.c();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.b();
        }
    }
}
