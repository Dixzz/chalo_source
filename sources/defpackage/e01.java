package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superPassHistory.PendingSuperPassBookingSummaryFragment;
import defpackage.ti0;

/* renamed from: e01  reason: default package */
/* compiled from: PendingSuperPassBookingSummaryFragment.kt */
public final class e01 implements ti0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PendingSuperPassBookingSummaryFragment f909a;

    public e01(PendingSuperPassBookingSummaryFragment pendingSuperPassBookingSummaryFragment) {
        this.f909a = pendingSuperPassBookingSummaryFragment;
    }

    @Override // defpackage.ti0.a
    public void a(String str, View view) {
        n86.e(str, "lProofUrl");
        n86.e(view, "lThumbView");
        ve activity = this.f909a.c();
        if (activity != null) {
            ZoomedImageViewActivity.i0(activity, (ImageView) view, str, null, true);
        }
    }
}
