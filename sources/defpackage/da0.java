package defpackage;

import android.app.DialogFragment;
import app.zophop.ui.activities.ReportProblemActivity;

/* renamed from: da0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class da0 implements Runnable {
    public final /* synthetic */ ReportProblemActivity f;

    public /* synthetic */ da0(ReportProblemActivity reportProblemActivity) {
        this.f = reportProblemActivity;
    }

    public final void run() {
        ReportProblemActivity reportProblemActivity = this.f;
        ReportProblemActivity.a aVar = ReportProblemActivity.r;
        n86.e(reportProblemActivity, "this$0");
        try {
            DialogFragment dialogFragment = reportProblemActivity.o;
            if (dialogFragment != null) {
                n86.c(dialogFragment);
                if (dialogFragment.isVisible()) {
                    DialogFragment dialogFragment2 = reportProblemActivity.o;
                    n86.c(dialogFragment2);
                    dialogFragment2.dismiss();
                }
            }
        } catch (Exception e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
