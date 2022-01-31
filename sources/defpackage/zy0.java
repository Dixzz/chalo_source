package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import app.zophop.ui.fragments.superPassHistory.PendingSuperPassBookingSummaryFragment;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

/* renamed from: zy0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class zy0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PendingSuperPassBookingSummaryFragment f4229a;

    public /* synthetic */ zy0(PendingSuperPassBookingSummaryFragment pendingSuperPassBookingSummaryFragment) {
        this.f4229a = pendingSuperPassBookingSummaryFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        PendingSuperPassBookingSummaryFragment pendingSuperPassBookingSummaryFragment = this.f4229a;
        Boolean bool = (Boolean) obj;
        int i = PendingSuperPassBookingSummaryFragment.i;
        n86.e(pendingSuperPassBookingSummaryFragment, "this$0");
        n86.d(bool, "lIsExpanded");
        if (bool.booleanValue()) {
            T t = pendingSuperPassBookingSummaryFragment.f;
            n86.c(t);
            ImageView imageView = ((qx) t).e;
            n86.d(imageView, "viewBinding.btnExpandFareSplit");
            n86.e(imageView, "lView");
            hj1.y0(imageView, "rotation", new float[]{0.0f, 180.0f}, "ofFloat(lView,\n         …    lFromAngle, lToAngle)", 200);
            T t2 = pendingSuperPassBookingSummaryFragment.f;
            n86.c(t2);
            LinearLayout linearLayout = ((qx) t2).j;
            int z = hj1.z(0, 0, linearLayout, View.MeasureSpec.makeMeasureSpec(((View) hj1.h(linearLayout, "viewBinding.fareSplitLayout", linearLayout, "lView", "null cannot be cast to non-null type android.view.View")).getWidth(), CommonUtils.BYTES_IN_A_GIGABYTE));
            linearLayout.getLayoutParams().height = 1;
            s61 k = hj1.k(linearLayout, 0, linearLayout, z);
            k.setDuration(200);
            linearLayout.startAnimation(k);
            return;
        }
        T t3 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t3);
        ImageView imageView2 = ((qx) t3).e;
        n86.d(imageView2, "viewBinding.btnExpandFareSplit");
        n86.e(imageView2, "lView");
        hj1.y0(imageView2, "rotation", new float[]{180.0f, 0.0f}, "ofFloat(lView,\n         …    lFromAngle, lToAngle)", 200);
        T t4 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t4);
        LinearLayout linearLayout2 = ((qx) t4).j;
        hj1.z0(linearLayout2, hj1.K(linearLayout2, "viewBinding.fareSplitLayout", linearLayout2, "lView"), 200);
    }
}
