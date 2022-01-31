package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment;

/* renamed from: sz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class sz0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBookingSummaryFragment f;
    public final /* synthetic */ SuperPass g;
    public final /* synthetic */ hm0 h;

    public /* synthetic */ sz0(SuperPassBookingSummaryFragment superPassBookingSummaryFragment, SuperPass superPass, hm0 hm0) {
        this.f = superPassBookingSummaryFragment;
        this.g = superPass;
        this.h = hm0;
    }

    public final void onClick(View view) {
        SuperPassBookingSummaryFragment superPassBookingSummaryFragment = this.f;
        SuperPass superPass = this.g;
        hm0 hm0 = this.h;
        int i = SuperPassBookingSummaryFragment.j;
        n86.e(superPassBookingSummaryFragment, "this$0");
        n86.e(superPass, "$lSuperPass");
        superPassBookingSummaryFragment.l(superPass.getSuperPassRepurchaseProperties().getConfigId());
        hm0.dismiss();
    }
}
