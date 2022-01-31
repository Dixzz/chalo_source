package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment;
import de.hdodenhof.circleimageview.CircleImageView;

/* renamed from: z01  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class z01 implements View.OnClickListener {
    public final /* synthetic */ ActiveSuperPassFragment f;
    public final /* synthetic */ SuperPassUserDetails g;

    public /* synthetic */ z01(ActiveSuperPassFragment activeSuperPassFragment, SuperPassUserDetails superPassUserDetails) {
        this.f = activeSuperPassFragment;
        this.g = superPassUserDetails;
    }

    public final void onClick(View view) {
        ActiveSuperPassFragment activeSuperPassFragment = this.f;
        SuperPassUserDetails superPassUserDetails = this.g;
        ActiveSuperPassFragment.a aVar = ActiveSuperPassFragment.i;
        n86.e(activeSuperPassFragment, "this$0");
        n86.e(superPassUserDetails, "$this_apply");
        String profilePhoto = superPassUserDetails.getProfilePhoto();
        T t = activeSuperPassFragment.f;
        n86.c(t);
        CircleImageView circleImageView = ((dx) t).l;
        n86.d(circleImageView, "viewBinding.profilePic");
        ZoomedImageViewActivity.h0(activeSuperPassFragment.c(), circleImageView, profilePhoto, null);
    }
}
