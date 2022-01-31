package com.razorpay;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* compiled from: AppSelectorFragment */
public final class D$_X_ implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ AppSelectorFragment f670a;

    public D$_X_(AppSelectorFragment appSelectorFragment) {
        this.f670a = appSelectorFragment;
    }

    public final void onGlobalLayout() {
        ArrayList<String> arrayList;
        Activity activity = this.f670a.getActivity();
        LinearLayout linearLayout = (LinearLayout) activity.findViewById(R.id.ll_curtain_container);
        int displayHeight = BaseUtils.getDisplayHeight(activity);
        View findViewById = activity.findViewById(R.id.dark_background);
        int[] iArr = new int[2];
        findViewById.getLocationInWindow(iArr);
        boolean z = true;
        int i = iArr[1];
        ArrayList<String> arrayList2 = this.f670a.preferredAppsOrder;
        boolean z2 = false;
        if (arrayList2 == null || arrayList2.size() <= 0 || (arrayList = this.f670a.finalOthersApps) == null || arrayList.size() <= 0) {
            int height = linearLayout.getHeight();
            if (height == 0) {
                z = false;
            }
            int i2 = displayHeight - i;
            int i3 = i2 / 2;
            int i4 = i2 - height;
            if (i4 > i3) {
                i3 = i4;
            }
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, i3));
            z2 = z;
        } else {
            View childAt = linearLayout.getChildAt(2);
            if (childAt instanceof LinearLayout) {
                LinearLayout linearLayout2 = (LinearLayout) childAt;
                if (linearLayout2.getChildCount() >= 2) {
                    View childAt2 = linearLayout2.getChildAt(1);
                    int[] iArr2 = new int[2];
                    linearLayout.getLocationInWindow(iArr2);
                    int i5 = iArr2[1];
                    int[] iArr3 = new int[2];
                    childAt2.getLocationInWindow(iArr3);
                    int i6 = iArr3[1];
                    boolean z3 = i6 != 0;
                    int height2 = ((displayHeight - (i6 - i5)) - i) - (childAt2.getHeight() / 2);
                    if (height2 < 0) {
                        height2 = 0;
                    }
                    findViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, height2));
                    linearLayout.setVisibility(0);
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) linearLayout.getHeight(), 0.0f);
                    translateAnimation.setDuration(500);
                    translateAnimation.setFillAfter(true);
                    linearLayout.startAnimation(translateAnimation);
                    z2 = z3;
                }
            }
        }
        if (z2) {
            this.f670a.rootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }
}
