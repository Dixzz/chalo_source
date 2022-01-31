package defpackage;

import android.view.View;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superPassHistory.SuperPassApplicationBookingSummaryFragment;

/* renamed from: hz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class hz0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassApplicationBookingSummaryFragment f;
    public final /* synthetic */ String g;

    public /* synthetic */ hz0(SuperPassApplicationBookingSummaryFragment superPassApplicationBookingSummaryFragment, String str) {
        this.f = superPassApplicationBookingSummaryFragment;
        this.g = str;
    }

    public final void onClick(View view) {
        SuperPassApplicationBookingSummaryFragment superPassApplicationBookingSummaryFragment = this.f;
        String str = this.g;
        int i = SuperPassApplicationBookingSummaryFragment.i;
        n86.e(superPassApplicationBookingSummaryFragment, "this$0");
        n86.e(str, "$lProfilePhoto");
        ve activity = superPassApplicationBookingSummaryFragment.c();
        if (activity != null) {
            T t = superPassApplicationBookingSummaryFragment.f;
            n86.c(t);
            ZoomedImageViewActivity.i0(activity, ((qx) t).A, str, null, true);
        }
    }
}
