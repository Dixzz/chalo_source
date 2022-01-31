package defpackage;

import app.zophop.utilities.ui.views.sliding_tabs.HorizontalTabScrollWithViewPager;

/* renamed from: ug1  reason: default package */
/* compiled from: HorizontalTabScrollWithViewPager */
public class ug1 implements Runnable {
    public final /* synthetic */ HorizontalTabScrollWithViewPager f;

    public ug1(HorizontalTabScrollWithViewPager horizontalTabScrollWithViewPager) {
        this.f = horizontalTabScrollWithViewPager;
    }

    public void run() {
        HorizontalTabScrollWithViewPager horizontalTabScrollWithViewPager = this.f;
        if (horizontalTabScrollWithViewPager.i && vn.f(horizontalTabScrollWithViewPager, horizontalTabScrollWithViewPager.p)) {
            vn.W0(this.f.p);
            this.f.invalidate();
            this.f.requestLayout();
        } else if (this.f.p.getMeasuredWidth() == vn.b0(this.f)) {
            this.f.setFillViewport(false);
            this.f.invalidate();
        }
    }
}
