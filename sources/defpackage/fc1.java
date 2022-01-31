package defpackage;

import android.view.ViewTreeObserver;
import androidx.viewpager.widget.ViewPager;
import app.zophop.ui.views.collapse_on_scroll.CollapseOnScrollViewPager;
import java.util.Objects;

/* renamed from: fc1  reason: default package */
/* compiled from: CollapseOnScrollViewPager */
public class fc1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ CollapseOnScrollViewPager g;

    public fc1(CollapseOnScrollViewPager collapseOnScrollViewPager, int i) {
        this.g = collapseOnScrollViewPager;
        this.f = i;
    }

    public void onGlobalLayout() {
        this.g.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = this.f;
        if (i >= 0) {
            CollapseOnScrollViewPager collapseOnScrollViewPager = this.g;
            collapseOnScrollViewPager.s = (ViewPager) collapseOnScrollViewPager.findViewById(i);
            CollapseOnScrollViewPager collapseOnScrollViewPager2 = this.g;
            Objects.requireNonNull(collapseOnScrollViewPager2);
            collapseOnScrollViewPager2.c(-collapseOnScrollViewPager2.l, true);
        }
    }
}
