package defpackage;

import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;

/* renamed from: la0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class la0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassBookingSummaryActivity f2193a;

    public /* synthetic */ la0(SuperPassBookingSummaryActivity superPassBookingSummaryActivity) {
        this.f2193a = superPassBookingSummaryActivity;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassBookingSummaryActivity superPassBookingSummaryActivity = this.f2193a;
        SuperPass superPass = (SuperPass) obj;
        int i = SuperPassBookingSummaryActivity.n;
        n86.e(superPassBookingSummaryActivity, "this$0");
        n86.d(superPass, "lSuperPass");
        if (superPass.getSuperPassProperties().getProductSubType() == SuperPassSubType.MAGIC_SUPER_PASS) {
            x supportActionBar = superPassBookingSummaryActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.z(superPass.getSuperPassUIProperties().getPassName());
                return;
            }
            return;
        }
        x supportActionBar2 = superPassBookingSummaryActivity.getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.z(((RideBasedSuperPass) superPass).getSuperPassUIProperties().getPassName());
        }
    }
}
