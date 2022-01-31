package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.ui.activities.MTicketTripReceiptActivity;
import app.zophop.ui.activities.ZoomedImageViewActivity;

/* renamed from: z90  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class z90 implements View.OnClickListener {
    public final /* synthetic */ MTicketTripReceiptActivity f;
    public final /* synthetic */ pz g;
    public final /* synthetic */ UserProfile h;

    public /* synthetic */ z90(MTicketTripReceiptActivity mTicketTripReceiptActivity, pz pzVar, UserProfile userProfile) {
        this.f = mTicketTripReceiptActivity;
        this.g = pzVar;
        this.h = userProfile;
    }

    public final void onClick(View view) {
        MTicketTripReceiptActivity mTicketTripReceiptActivity = this.f;
        pz pzVar = this.g;
        UserProfile userProfile = this.h;
        int i = MTicketTripReceiptActivity.l;
        n86.e(mTicketTripReceiptActivity, "this$0");
        n86.e(pzVar, "$this_apply");
        ZoomedImageViewActivity.i0(mTicketTripReceiptActivity, pzVar.e, userProfile.getProfilePhoto(), null, true);
    }
}
