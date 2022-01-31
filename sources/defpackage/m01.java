package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superPassValidation.ActivateSuperPassFragment;
import de.hdodenhof.circleimageview.CircleImageView;

/* renamed from: m01  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class m01 implements View.OnClickListener {
    public final /* synthetic */ ActivateSuperPassFragment f;
    public final /* synthetic */ SuperPassUserDetails g;

    public /* synthetic */ m01(ActivateSuperPassFragment activateSuperPassFragment, SuperPassUserDetails superPassUserDetails) {
        this.f = activateSuperPassFragment;
        this.g = superPassUserDetails;
    }

    public final void onClick(View view) {
        ActivateSuperPassFragment activateSuperPassFragment = this.f;
        SuperPassUserDetails superPassUserDetails = this.g;
        ActivateSuperPassFragment.a aVar = ActivateSuperPassFragment.h;
        n86.e(activateSuperPassFragment, "this$0");
        n86.e(superPassUserDetails, "$this_apply");
        String profilePhoto = superPassUserDetails.getProfilePhoto();
        T t = activateSuperPassFragment.f;
        n86.c(t);
        CircleImageView circleImageView = ((cx) t).j;
        n86.d(circleImageView, "viewBinding.profilePic");
        ZoomedImageViewActivity.h0(activateSuperPassFragment.c(), circleImageView, profilePhoto, null);
    }
}
