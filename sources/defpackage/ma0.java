package defpackage;

import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;

/* renamed from: ma0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ma0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassBookingSummaryActivity f2344a;

    public /* synthetic */ ma0(SuperPassBookingSummaryActivity superPassBookingSummaryActivity) {
        this.f2344a = superPassBookingSummaryActivity;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassBookingSummaryActivity superPassBookingSummaryActivity = this.f2344a;
        PendingSuperPass pendingSuperPass = (PendingSuperPass) obj;
        int i = SuperPassBookingSummaryActivity.n;
        n86.e(superPassBookingSummaryActivity, "this$0");
        n86.d(pendingSuperPass, "lPendingSuperPass");
        x supportActionBar = superPassBookingSummaryActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.z(pendingSuperPass.getPendingSuperPassUIProperties().getPassName());
        }
    }
}
