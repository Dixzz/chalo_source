package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import app.zophop.ui.fragments.cardRecharge.CardRechargeConfirmPaymentFragment;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

/* renamed from: fy0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class fy0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardRechargeConfirmPaymentFragment f1185a;

    public /* synthetic */ fy0(CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment) {
        this.f1185a = cardRechargeConfirmPaymentFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment = this.f1185a;
        Boolean bool = (Boolean) obj;
        int i = CardRechargeConfirmPaymentFragment.l;
        n86.e(cardRechargeConfirmPaymentFragment, "this$0");
        n86.d(bool, "lIsFareLayoutExpanded");
        if (bool.booleanValue()) {
            T t = cardRechargeConfirmPaymentFragment.f;
            n86.c(t);
            ImageView imageView = ((jx) t).c;
            n86.d(imageView, "viewBinding.btnExpandFareSplit");
            n86.e(imageView, "lView");
            hj1.y0(imageView, "rotation", new float[]{0.0f, 180.0f}, "ofFloat(lView,\n         …    lFromAngle, lToAngle)", 200);
            T t2 = cardRechargeConfirmPaymentFragment.f;
            n86.c(t2);
            LinearLayout linearLayout = ((jx) t2).g;
            int z = hj1.z(0, 0, linearLayout, View.MeasureSpec.makeMeasureSpec(((View) hj1.h(linearLayout, "viewBinding.fareSplitLayout", linearLayout, "lView", "null cannot be cast to non-null type android.view.View")).getWidth(), CommonUtils.BYTES_IN_A_GIGABYTE));
            linearLayout.getLayoutParams().height = 1;
            s61 k = hj1.k(linearLayout, 0, linearLayout, z);
            k.setDuration(200);
            linearLayout.startAnimation(k);
            return;
        }
        T t3 = cardRechargeConfirmPaymentFragment.f;
        n86.c(t3);
        ImageView imageView2 = ((jx) t3).c;
        n86.d(imageView2, "viewBinding.btnExpandFareSplit");
        n86.e(imageView2, "lView");
        hj1.y0(imageView2, "rotation", new float[]{180.0f, 0.0f}, "ofFloat(lView,\n         …    lFromAngle, lToAngle)", 200);
        T t4 = cardRechargeConfirmPaymentFragment.f;
        n86.c(t4);
        LinearLayout linearLayout2 = ((jx) t4).g;
        hj1.z0(linearLayout2, hj1.K(linearLayout2, "viewBinding.fareSplitLayout", linearLayout2, "lView"), 200);
    }
}
