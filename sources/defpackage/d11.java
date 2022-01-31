package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassQrZoomedFragment;

/* renamed from: d11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class d11 implements View.OnClickListener {
    public final /* synthetic */ hm0 f;
    public final /* synthetic */ SuperPass g;
    public final /* synthetic */ hm0 h;

    public /* synthetic */ d11(hm0 hm0, SuperPass superPass, hm0 hm02) {
        this.f = hm0;
        this.g = superPass;
        this.h = hm02;
    }

    public final void onClick(View view) {
        hm0 hm0 = this.f;
        SuperPass superPass = this.g;
        hm0 hm02 = this.h;
        ActiveSuperPassQrZoomedFragment.a aVar = ActiveSuperPassQrZoomedFragment.h;
        hj1.E0(superPass, "$lSuperPass", hm02, "$this_apply", hm0);
        gi1.h(gi1.f1265a, "activation duration expired dialog view summary clicked", superPass, "active super pass qr zoomed fragment", 0, 8);
        Context context = hm02.getContext();
        if (context != null) {
            SuperPassBookingSummaryActivity.s0(superPass.getSuperPassProperties().getPassId(), superPass.getSuperPassProperties().getProductSubType(), "active super pass qr zoomed fragment", context);
        }
        ve activity = hm02.c();
        if (activity != null) {
            activity.finish();
        }
    }
}
