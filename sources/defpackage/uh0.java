package defpackage;

import androidx.activity.result.ActivityResult;
import app.zophop.ui.activities.cardRecharge.CardRechargeActivity;
import app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel;

/* renamed from: uh0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class uh0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardRechargeActivity f3504a;

    public /* synthetic */ uh0(CardRechargeActivity cardRechargeActivity) {
        this.f3504a = cardRechargeActivity;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        CardRechargeActivity cardRechargeActivity = this.f3504a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = CardRechargeActivity.o;
        n86.e(cardRechargeActivity, "this$0");
        n86.e(activityResult, "result");
        int i2 = activityResult.f;
        if (i2 == -1) {
            if (xt.f3961a.L().m()) {
                CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel = cardRechargeActivity.m;
                if (cardRechargeActivitySharedViewModel != null) {
                    cardRechargeActivitySharedViewModel.d(cardRechargeActivity);
                } else {
                    n86.l("sharedViewModel");
                    throw null;
                }
            } else {
                cardRechargeActivity.onBackPressed();
            }
        } else if (i2 == 0) {
            cardRechargeActivity.onBackPressed();
        }
    }
}
