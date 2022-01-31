package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superPassHistory.SuperPassTripReceiptFragment;

/* renamed from: yz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class yz0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassTripReceiptFragment f;
    public final /* synthetic */ pz g;
    public final /* synthetic */ SuperPassUserDetails h;

    public /* synthetic */ yz0(SuperPassTripReceiptFragment superPassTripReceiptFragment, pz pzVar, SuperPassUserDetails superPassUserDetails) {
        this.f = superPassTripReceiptFragment;
        this.g = pzVar;
        this.h = superPassUserDetails;
    }

    public final void onClick(View view) {
        SuperPassTripReceiptFragment superPassTripReceiptFragment = this.f;
        pz pzVar = this.g;
        SuperPassUserDetails superPassUserDetails = this.h;
        int i = SuperPassTripReceiptFragment.j;
        n86.e(superPassTripReceiptFragment, "this$0");
        n86.e(pzVar, "$this_apply");
        n86.e(superPassUserDetails, "$lSuperPassUserDetails");
        ve activity = superPassTripReceiptFragment.c();
        if (activity != null) {
            ZoomedImageViewActivity.i0(activity, pzVar.e, superPassUserDetails.getProfilePhoto(), null, true);
        }
    }
}
