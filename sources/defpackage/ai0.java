package defpackage;

import androidx.activity.result.ActivityResult;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeHistoryActivity;

/* renamed from: ai0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ai0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnlineCardRechargeHistoryActivity f165a;

    public /* synthetic */ ai0(OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity) {
        this.f165a = onlineCardRechargeHistoryActivity;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity = this.f165a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = OnlineCardRechargeHistoryActivity.o;
        n86.e(onlineCardRechargeHistoryActivity, "this$0");
        n86.e(activityResult, "result");
        if (activityResult.f != -1) {
            return;
        }
        if (xt.f3961a.L().m()) {
            onlineCardRechargeHistoryActivity.v0();
        } else {
            onlineCardRechargeHistoryActivity.onBackPressed();
        }
    }
}
