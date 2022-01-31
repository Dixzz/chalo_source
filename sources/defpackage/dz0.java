package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superPassHistory.PendingSuperPassBookingSummaryFragment;

/* renamed from: dz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class dz0 implements View.OnClickListener {
    public final /* synthetic */ PendingSuperPassBookingSummaryFragment f;
    public final /* synthetic */ SuperPassUserDetails g;

    public /* synthetic */ dz0(PendingSuperPassBookingSummaryFragment pendingSuperPassBookingSummaryFragment, SuperPassUserDetails superPassUserDetails) {
        this.f = pendingSuperPassBookingSummaryFragment;
        this.g = superPassUserDetails;
    }

    public final void onClick(View view) {
        PendingSuperPassBookingSummaryFragment pendingSuperPassBookingSummaryFragment = this.f;
        SuperPassUserDetails superPassUserDetails = this.g;
        int i = PendingSuperPassBookingSummaryFragment.i;
        n86.e(pendingSuperPassBookingSummaryFragment, "this$0");
        n86.e(superPassUserDetails, "$this_with");
        ve activity = pendingSuperPassBookingSummaryFragment.c();
        if (activity != null) {
            T t = pendingSuperPassBookingSummaryFragment.f;
            n86.c(t);
            ZoomedImageViewActivity.i0(activity, ((qx) t).A, superPassUserDetails.getProfilePhoto(), null, true);
        }
    }
}
