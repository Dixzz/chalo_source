package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

/* renamed from: xo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class xo0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmMPassPurchaseFragment f3945a;

    public /* synthetic */ xo0(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment) {
        this.f3945a = confirmMPassPurchaseFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment = this.f3945a;
        Boolean bool = (Boolean) obj;
        int i = ConfirmMPassPurchaseFragment.k;
        n86.e(confirmMPassPurchaseFragment, "this$0");
        n86.d(bool, "lIsFareLayoutExpanded");
        if (bool.booleanValue()) {
            T t = confirmMPassPurchaseFragment.f;
            n86.c(t);
            ImageView imageView = ((kx) t).c;
            n86.d(imageView, "viewBinding.btnExpandFareSplit");
            n86.e(imageView, "lView");
            hj1.y0(imageView, "rotation", new float[]{0.0f, 180.0f}, "ofFloat(lView,\n         …    lFromAngle, lToAngle)", 200);
            T t2 = confirmMPassPurchaseFragment.f;
            n86.c(t2);
            LinearLayout linearLayout = ((kx) t2).j;
            int z = hj1.z(0, 0, linearLayout, View.MeasureSpec.makeMeasureSpec(((View) hj1.h(linearLayout, "viewBinding.fareSplitLayout", linearLayout, "lView", "null cannot be cast to non-null type android.view.View")).getWidth(), CommonUtils.BYTES_IN_A_GIGABYTE));
            linearLayout.getLayoutParams().height = 1;
            s61 k = hj1.k(linearLayout, 0, linearLayout, z);
            k.setDuration(200);
            linearLayout.startAnimation(k);
            return;
        }
        T t3 = confirmMPassPurchaseFragment.f;
        n86.c(t3);
        ImageView imageView2 = ((kx) t3).c;
        n86.d(imageView2, "viewBinding.btnExpandFareSplit");
        n86.e(imageView2, "lView");
        hj1.y0(imageView2, "rotation", new float[]{180.0f, 0.0f}, "ofFloat(lView,\n         …    lFromAngle, lToAngle)", 200);
        T t4 = confirmMPassPurchaseFragment.f;
        n86.c(t4);
        LinearLayout linearLayout2 = ((kx) t4).j;
        hj1.z0(linearLayout2, hj1.K(linearLayout2, "viewBinding.fareSplitLayout", linearLayout2, "lView"), 200);
    }
}
