package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;
import app.zophop.ui.activities.SuperPassVerificationStatusActivity;

/* renamed from: sa0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class sa0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassVerificationStatusActivity f;

    public /* synthetic */ sa0(SuperPassVerificationStatusActivity superPassVerificationStatusActivity) {
        this.f = superPassVerificationStatusActivity;
    }

    public final void onClick(View view) {
        SuperPassVerificationStatusActivity superPassVerificationStatusActivity = this.f;
        int i = SuperPassVerificationStatusActivity.m;
        n86.e(superPassVerificationStatusActivity, "this$0");
        ed1 ed1 = new ed1("mPass verification status view details clicked", Long.MIN_VALUE);
        ed1.a("source", superPassVerificationStatusActivity.t0());
        superPassVerificationStatusActivity.s0(ed1);
        ui1.m0(ed1);
        SuperPassApplication u0 = superPassVerificationStatusActivity.u0();
        n86.e(u0, "lSuperPassApplication");
        n86.e("sourceVerificationStatusScreen", "lSource");
        n86.e(superPassVerificationStatusActivity, "lContext");
        Intent intent = new Intent(superPassVerificationStatusActivity, SuperPassBookingSummaryActivity.class);
        intent.putExtra("arg_superPassApplication", u0);
        intent.putExtra("arg_source", "sourceVerificationStatusScreen");
        intent.putExtra("arg_startDestination", "startDestinationSuperPassApplicationScreen");
        superPassVerificationStatusActivity.startActivity(intent);
    }
}
