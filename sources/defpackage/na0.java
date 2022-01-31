package defpackage;

import androidx.activity.result.ActivityResult;
import app.zophop.ui.activities.SuperPassPurchaseActivity;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;

/* renamed from: na0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class na0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassPurchaseActivity f2528a;

    public /* synthetic */ na0(SuperPassPurchaseActivity superPassPurchaseActivity) {
        this.f2528a = superPassPurchaseActivity;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        SuperPassPurchaseActivity superPassPurchaseActivity = this.f2528a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = SuperPassPurchaseActivity.n;
        Boolean bool = Boolean.FALSE;
        n86.e(superPassPurchaseActivity, "this$0");
        n86.e(activityResult, "result");
        int i2 = activityResult.f;
        if (i2 == -1) {
            if (xt.f3961a.L().m()) {
                SuperPassPurchaseSharedViewModel superPassPurchaseSharedViewModel = superPassPurchaseActivity.k;
                if (superPassPurchaseSharedViewModel != null) {
                    superPassPurchaseSharedViewModel.k();
                    ed1 ed1 = new ed1("user log attempt mPassPurchaseActivity", Long.MIN_VALUE);
                    ed1.a("isSuccessful", Boolean.TRUE);
                    ui1.m0(ed1);
                    return;
                }
                n86.l("sharedViewModel");
                throw null;
            }
            ed1 ed12 = new ed1("superPass booking flow login exception", Long.MIN_VALUE);
            ed12.a("isSuccessful", bool);
            ui1.m0(ed12);
            superPassPurchaseActivity.onSupportNavigateUp();
        } else if (i2 == 0) {
            ed1 ed13 = new ed1("user log attempt mPassPurchaseActivity", Long.MIN_VALUE);
            ed13.a("isSuccessful", bool);
            ui1.m0(ed13);
            superPassPurchaseActivity.onSupportNavigateUp();
        }
    }
}
