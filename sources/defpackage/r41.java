package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

/* renamed from: r41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class r41 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment f3038a;

    public /* synthetic */ r41(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f3038a = confirmSuperPassPurchaseFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment = this.f3038a;
        Boolean bool = (Boolean) obj;
        int i = ConfirmSuperPassPurchaseFragment.k;
        n86.e(confirmSuperPassPurchaseFragment, "this$0");
        n86.d(bool, "lIsFareLayoutExpanded");
        if (bool.booleanValue()) {
            T t = confirmSuperPassPurchaseFragment.f;
            n86.c(t);
            ImageView imageView = ((lx) t).c;
            n86.d(imageView, "viewBinding.btnExpandFareSplit");
            n86.e(imageView, "lView");
            hj1.y0(imageView, "rotation", new float[]{0.0f, 180.0f}, "ofFloat(lView,\n         …    lFromAngle, lToAngle)", 200);
            T t2 = confirmSuperPassPurchaseFragment.f;
            n86.c(t2);
            LinearLayout linearLayout = ((lx) t2).h;
            int z = hj1.z(0, 0, linearLayout, View.MeasureSpec.makeMeasureSpec(((View) hj1.h(linearLayout, "viewBinding.fareSplitLayout", linearLayout, "lView", "null cannot be cast to non-null type android.view.View")).getWidth(), CommonUtils.BYTES_IN_A_GIGABYTE));
            linearLayout.getLayoutParams().height = 1;
            s61 k = hj1.k(linearLayout, 0, linearLayout, z);
            k.setDuration(200);
            linearLayout.startAnimation(k);
            return;
        }
        T t3 = confirmSuperPassPurchaseFragment.f;
        n86.c(t3);
        ImageView imageView2 = ((lx) t3).c;
        n86.d(imageView2, "viewBinding.btnExpandFareSplit");
        n86.e(imageView2, "lView");
        hj1.y0(imageView2, "rotation", new float[]{180.0f, 0.0f}, "ofFloat(lView,\n         …    lFromAngle, lToAngle)", 200);
        T t4 = confirmSuperPassPurchaseFragment.f;
        n86.c(t4);
        LinearLayout linearLayout2 = ((lx) t4).h;
        hj1.z0(linearLayout2, hj1.K(linearLayout2, "viewBinding.fareSplitLayout", linearLayout2, "lView"), 200);
    }
}
