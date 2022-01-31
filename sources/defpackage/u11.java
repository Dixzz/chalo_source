package defpackage;

import android.view.View;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;
import de.hdodenhof.circleimageview.CircleImageView;

/* renamed from: u11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class u11 implements View.OnClickListener {
    public final /* synthetic */ SoundFragmentSuperPass f;
    public final /* synthetic */ String g;
    public final /* synthetic */ ez h;

    public /* synthetic */ u11(SoundFragmentSuperPass soundFragmentSuperPass, String str, ez ezVar) {
        this.f = soundFragmentSuperPass;
        this.g = str;
        this.h = ezVar;
    }

    public final void onClick(View view) {
        SoundFragmentSuperPass soundFragmentSuperPass = this.f;
        String str = this.g;
        ez ezVar = this.h;
        SoundFragmentSuperPass.a aVar = SoundFragmentSuperPass.j;
        n86.e(soundFragmentSuperPass, "this$0");
        n86.e(str, "$lProfilePhoto");
        n86.e(ezVar, "$this_apply");
        CircleImageView circleImageView = ezVar.d;
        n86.d(circleImageView, "profilePic");
        ve activity = soundFragmentSuperPass.c();
        if (activity != null) {
            ZoomedImageViewActivity.i0(activity, circleImageView, str, null, true);
        }
    }
}
