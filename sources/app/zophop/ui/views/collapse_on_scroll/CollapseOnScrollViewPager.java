package app.zophop.ui.views.collapse_on_scroll;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ScrollView;
import androidx.viewpager.widget.ViewPager;
import app.zophop.R;
import java.util.List;

public class CollapseOnScrollViewPager extends ec1 {
    public ViewPager s;
    public ScrollView t;

    public CollapseOnScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CollapseOnScrollView);
        int resourceId = obtainStyledAttributes.getResourceId(2, -1);
        obtainStyledAttributes.recycle();
        getViewTreeObserver().addOnGlobalLayoutListener(new fc1(this, resourceId));
    }

    @Override // defpackage.ec1
    public ScrollView getScrollView() {
        StringBuilder i0 = hj1.i0("ResultFragmentTag");
        int currentItem = this.s.getCurrentItem();
        xt.f3961a.k().d();
        List<l90> resultTabItems = getResultTabItems();
        String str = "";
        if (resultTabItems != null) {
            str = resultTabItems.get(currentItem) + str;
        }
        i0.append(str);
        ScrollView scrollView = (ScrollView) findViewWithTag(i0.toString());
        this.t = scrollView;
        return scrollView;
    }
}
