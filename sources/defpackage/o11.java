package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;
import de.hdodenhof.circleimageview.CircleImageView;

/* renamed from: o11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class o11 implements View.OnClickListener {
    public final /* synthetic */ ActiveSuperPassVisualValidationFragment f;
    public final /* synthetic */ SuperPassUserDetails g;

    public /* synthetic */ o11(ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment, SuperPassUserDetails superPassUserDetails) {
        this.f = activeSuperPassVisualValidationFragment;
        this.g = superPassUserDetails;
    }

    public final void onClick(View view) {
        ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment = this.f;
        SuperPassUserDetails superPassUserDetails = this.g;
        ActiveSuperPassVisualValidationFragment.a aVar = ActiveSuperPassVisualValidationFragment.i;
        n86.e(activeSuperPassVisualValidationFragment, "this$0");
        n86.e(superPassUserDetails, "$this_apply");
        String profilePhoto = superPassUserDetails.getProfilePhoto();
        T t = activeSuperPassVisualValidationFragment.f;
        n86.c(t);
        CircleImageView circleImageView = ((ex) t).m;
        n86.d(circleImageView, "viewBinding.profilePic");
        ZoomedImageViewActivity.h0(activeSuperPassVisualValidationFragment.c(), circleImageView, profilePhoto, null);
    }
}
