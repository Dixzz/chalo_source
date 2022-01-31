package defpackage;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;

/* renamed from: y11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class y11 implements View.OnClickListener {
    public final /* synthetic */ SoundFragmentSuperPass f;

    public /* synthetic */ y11(SoundFragmentSuperPass soundFragmentSuperPass) {
        this.f = soundFragmentSuperPass;
    }

    public final void onClick(View view) {
        SoundFragmentSuperPass soundFragmentSuperPass = this.f;
        SoundFragmentSuperPass.a aVar = SoundFragmentSuperPass.j;
        n86.e(soundFragmentSuperPass, "this$0");
        gi1.i(gi1.f1265a, "sound bottom sheet clicked", soundFragmentSuperPass.j().f, soundFragmentSuperPass.j().e, "sound fragment", 0, 16);
        FragmentManager parentFragmentManager = soundFragmentSuperPass.getParentFragmentManager();
        n86.d(parentFragmentManager, "parentFragmentManager");
        n86.e(parentFragmentManager, "lFragmentManager");
        n86.e("sound fragment", "lSource");
        new t31("sound fragment").show(parentFragmentManager, "tagBottomSheetDialogFragmentSuperPass");
    }
}
