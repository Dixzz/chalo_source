package defpackage;

import app.zophop.utilities.ui.views.sliding_tabs.HorizontalTabScroll;

/* renamed from: tg1  reason: default package */
/* compiled from: HorizontalTabScroll */
public class tg1 implements Runnable {
    public final /* synthetic */ HorizontalTabScroll f;

    public tg1(HorizontalTabScroll horizontalTabScroll) {
        this.f = horizontalTabScroll;
    }

    public void run() {
        HorizontalTabScroll horizontalTabScroll = this.f;
        if (horizontalTabScroll.i && vn.f(horizontalTabScroll, horizontalTabScroll.n)) {
            vn.W0(this.f.n);
            this.f.invalidate();
            this.f.requestLayout();
        } else if (this.f.n.getMeasuredWidth() == vn.b0(this.f)) {
            this.f.setFillViewport(false);
            this.f.invalidate();
        }
    }
}
