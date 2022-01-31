package defpackage;

import android.view.View;
import app.zophop.ui.activities.SuperPassVerificationStatusActivity;

/* renamed from: ta0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ta0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassVerificationStatusActivity f;

    public /* synthetic */ ta0(SuperPassVerificationStatusActivity superPassVerificationStatusActivity) {
        this.f = superPassVerificationStatusActivity;
    }

    public final void onClick(View view) {
        SuperPassVerificationStatusActivity superPassVerificationStatusActivity = this.f;
        int i = SuperPassVerificationStatusActivity.m;
        n86.e(superPassVerificationStatusActivity, "this$0");
        ed1 ed1 = new ed1("mPass verification status ok clicked", Long.MIN_VALUE);
        ed1.a("source", superPassVerificationStatusActivity.t0());
        superPassVerificationStatusActivity.s0(ed1);
        ui1.m0(ed1);
        superPassVerificationStatusActivity.onBackPressed();
    }
}
