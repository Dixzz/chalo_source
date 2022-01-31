package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment;

/* renamed from: a11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class a11 implements View.OnClickListener {
    public final /* synthetic */ hm0 f;
    public final /* synthetic */ SuperPass g;
    public final /* synthetic */ hm0 h;

    public /* synthetic */ a11(hm0 hm0, SuperPass superPass, hm0 hm02) {
        this.f = hm0;
        this.g = superPass;
        this.h = hm02;
    }

    public final void onClick(View view) {
        hm0 hm0 = this.f;
        SuperPass superPass = this.g;
        hm0 hm02 = this.h;
        ActiveSuperPassFragment.a aVar = ActiveSuperPassFragment.i;
        hj1.E0(superPass, "$lSuperPass", hm02, "$this_apply", hm0);
        gi1.h(gi1.f1265a, "activation duration expired dialog view summary clicked", superPass, "Active Super Pass Fragment", 0, 8);
        Context context = hm02.getContext();
        if (context != null) {
            SuperPassBookingSummaryActivity.s0(superPass.getSuperPassProperties().getPassId(), superPass.getSuperPassProperties().getProductSubType(), "Active Super Pass Fragment", context);
        }
        ve activity = hm02.c();
        if (activity != null) {
            activity.finish();
        }
    }
}
