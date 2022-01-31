package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.ProductHistoryActivity;
import app.zophop.ui.activities.ReportProblemActivity;

/* renamed from: ea0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ea0 implements View.OnClickListener {
    public final /* synthetic */ ReportProblemActivity f;
    public final /* synthetic */ lm0 g;

    public /* synthetic */ ea0(ReportProblemActivity reportProblemActivity, lm0 lm0) {
        this.f = reportProblemActivity;
        this.g = lm0;
    }

    public final void onClick(View view) {
        ReportProblemActivity reportProblemActivity = this.f;
        lm0 lm0 = this.g;
        ReportProblemActivity.a aVar = ReportProblemActivity.r;
        n86.e(reportProblemActivity, "this$0");
        Intent intent = new Intent(reportProblemActivity, ProductHistoryActivity.class);
        intent.putExtra("source", "Report Problem Activity");
        intent.addFlags(67108864);
        reportProblemActivity.startActivity(intent);
        lm0.dismiss();
    }
}
