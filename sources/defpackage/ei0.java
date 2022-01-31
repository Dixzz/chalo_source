package defpackage;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeSummaryActivity;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

/* renamed from: ei0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ei0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnlineCardRechargeSummaryActivity f976a;

    public /* synthetic */ ei0(OnlineCardRechargeSummaryActivity onlineCardRechargeSummaryActivity) {
        this.f976a = onlineCardRechargeSummaryActivity;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        OnlineCardRechargeSummaryActivity onlineCardRechargeSummaryActivity = this.f976a;
        Boolean bool = (Boolean) obj;
        int i = OnlineCardRechargeSummaryActivity.l;
        n86.e(onlineCardRechargeSummaryActivity, "this$0");
        n86.d(bool, "lIsFareLayoutExpanded");
        if (bool.booleanValue()) {
            ImageView imageView = ((ew) onlineCardRechargeSummaryActivity.f0()).d;
            n86.d(imageView, "viewBinding.btnExpandFareSplit");
            n86.e(imageView, "lView");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 180.0f);
            n86.d(ofFloat, "ofFloat(lView,\n         …    lFromAngle, lToAngle)");
            ofFloat.setDuration(200L);
            ofFloat.start();
            LinearLayout linearLayout = ((ew) onlineCardRechargeSummaryActivity.f0()).f;
            int z = hj1.z(0, 0, linearLayout, View.MeasureSpec.makeMeasureSpec(((View) hj1.h(linearLayout, "viewBinding.fareSplitLayout", linearLayout, "lView", "null cannot be cast to non-null type android.view.View")).getWidth(), CommonUtils.BYTES_IN_A_GIGABYTE));
            linearLayout.getLayoutParams().height = 1;
            s61 k = hj1.k(linearLayout, 0, linearLayout, z);
            k.setDuration(200);
            linearLayout.startAnimation(k);
            return;
        }
        ImageView imageView2 = ((ew) onlineCardRechargeSummaryActivity.f0()).d;
        n86.d(imageView2, "viewBinding.btnExpandFareSplit");
        n86.e(imageView2, "lView");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "rotation", 180.0f, 0.0f);
        n86.d(ofFloat2, "ofFloat(lView,\n         …    lFromAngle, lToAngle)");
        ofFloat2.setDuration(200L);
        ofFloat2.start();
        LinearLayout linearLayout2 = ((ew) onlineCardRechargeSummaryActivity.f0()).f;
        hj1.z0(linearLayout2, hj1.K(linearLayout2, "viewBinding.fareSplitLayout", linearLayout2, "lView"), 200);
    }
}
