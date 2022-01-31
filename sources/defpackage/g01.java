package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment;
import defpackage.ti0;

/* renamed from: g01  reason: default package */
/* compiled from: SuperPassBookingSummaryFragment.kt */
public final class g01 implements ti0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassBookingSummaryFragment f1196a;

    public g01(SuperPassBookingSummaryFragment superPassBookingSummaryFragment) {
        this.f1196a = superPassBookingSummaryFragment;
    }

    @Override // defpackage.ti0.a
    public void a(String str, View view) {
        n86.e(str, "lProofUrl");
        n86.e(view, "lThumbView");
        ve activity = this.f1196a.c();
        if (activity != null) {
            ZoomedImageViewActivity.i0(activity, (ImageView) view, str, null, true);
        }
    }
}
