package app.zophop.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

public class WrapContentViewPager extends ViewPager {
    public WrapContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            childAt.measure(View.MeasureSpec.getMode(i) != 1073741824 ? View.MeasureSpec.makeMeasureSpec(0, 0) : i, View.MeasureSpec.getMode(i2) != 1073741824 ? View.MeasureSpec.makeMeasureSpec(0, 0) : i2);
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
            if (measuredHeight > i4) {
                i4 = measuredHeight;
            }
        }
        if (mode2 != 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(i4, CommonUtils.BYTES_IN_A_GIGABYTE);
        }
        if (mode != 1073741824) {
            i = View.MeasureSpec.makeMeasureSpec(i3, CommonUtils.BYTES_IN_A_GIGABYTE);
        }
        super.onMeasure(i, i2);
    }
}
