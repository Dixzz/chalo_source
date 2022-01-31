package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment;

/* renamed from: vz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class vz0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBookingSummaryFragment f;
    public final /* synthetic */ SuperPassUserDetails g;

    public /* synthetic */ vz0(SuperPassBookingSummaryFragment superPassBookingSummaryFragment, SuperPassUserDetails superPassUserDetails) {
        this.f = superPassBookingSummaryFragment;
        this.g = superPassUserDetails;
    }

    public final void onClick(View view) {
        SuperPassBookingSummaryFragment superPassBookingSummaryFragment = this.f;
        SuperPassUserDetails superPassUserDetails = this.g;
        int i = SuperPassBookingSummaryFragment.j;
        n86.e(superPassBookingSummaryFragment, "this$0");
        n86.e(superPassUserDetails, "$this_with");
        ve activity = superPassBookingSummaryFragment.c();
        if (activity != null) {
            T t = superPassBookingSummaryFragment.f;
            n86.c(t);
            ZoomedImageViewActivity.i0(activity, ((qx) t).A, superPassUserDetails.getProfilePhoto(), null, true);
        }
    }
}
