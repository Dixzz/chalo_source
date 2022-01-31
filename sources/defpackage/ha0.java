package defpackage;

import android.view.View;
import app.zophop.ui.activities.ReportProblemActivity;
import defpackage.xt;
import java.util.UUID;

/* renamed from: ha0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ha0 implements View.OnClickListener {
    public final /* synthetic */ lm0 f;
    public final /* synthetic */ ReportProblemActivity g;

    public /* synthetic */ ha0(lm0 lm0, ReportProblemActivity reportProblemActivity) {
        this.f = lm0;
        this.g = reportProblemActivity;
    }

    public final void onClick(View view) {
        lm0 lm0 = this.f;
        ReportProblemActivity reportProblemActivity = this.g;
        ReportProblemActivity.a aVar = ReportProblemActivity.r;
        n86.e(reportProblemActivity, "this$0");
        lm0.dismiss();
        reportProblemActivity.k0();
        reportProblemActivity.n = UUID.randomUUID().toString();
        xt.t1 t1Var = xt.f3961a;
        t1Var.c().f0(reportProblemActivity.n, t1Var.L().getUserId(), t1Var.n().a());
    }
}
