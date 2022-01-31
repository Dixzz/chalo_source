package defpackage;

import androidx.activity.result.ActivityResult;
import app.zophop.ui.activities.MPassPurchaseActivity;

/* renamed from: w90  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class w90 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MPassPurchaseActivity f3746a;

    public /* synthetic */ w90(MPassPurchaseActivity mPassPurchaseActivity) {
        this.f3746a = mPassPurchaseActivity;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        MPassPurchaseActivity mPassPurchaseActivity = this.f3746a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = MPassPurchaseActivity.n;
        n86.e(mPassPurchaseActivity, "this$0");
        n86.e(activityResult, "result");
        int i2 = activityResult.f;
        if (i2 == -1) {
            p81 p81 = mPassPurchaseActivity.k;
            if (p81 != null) {
                p81.k();
                ed1 ed1 = new ed1("user log attempt mPassPurchaseActivity", Long.MIN_VALUE);
                ed1.a("isSuccessful", Boolean.TRUE);
                ui1.m0(ed1);
                return;
            }
            n86.l("sharedViewModel");
            throw null;
        } else if (i2 == 0) {
            ed1 ed12 = new ed1("user log attempt mPassPurchaseActivity", Long.MIN_VALUE);
            ed12.a("isSuccessful", Boolean.FALSE);
            ui1.m0(ed12);
            mPassPurchaseActivity.onSupportNavigateUp();
        }
    }
}
