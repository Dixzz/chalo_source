package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superPassHistory.SuperPassApplicationBookingSummaryFragment;
import defpackage.ti0;

/* renamed from: f01  reason: default package */
/* compiled from: SuperPassApplicationBookingSummaryFragment.kt */
public final class f01 implements ti0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassApplicationBookingSummaryFragment f1053a;

    public f01(SuperPassApplicationBookingSummaryFragment superPassApplicationBookingSummaryFragment) {
        this.f1053a = superPassApplicationBookingSummaryFragment;
    }

    @Override // defpackage.ti0.a
    public void a(String str, View view) {
        n86.e(str, "lProofUrl");
        n86.e(view, "lThumbView");
        ve activity = this.f1053a.c();
        if (activity != null) {
            ZoomedImageViewActivity.i0(activity, (ImageView) view, str, null, true);
        }
    }
}
