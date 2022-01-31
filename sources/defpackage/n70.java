package defpackage;

import android.view.View;
import android.widget.HorizontalScrollView;
import app.zophop.products.CategorySelectionActivity;

/* renamed from: n70  reason: default package */
/* compiled from: CategorySelectionActivity */
public class n70 implements Runnable {
    public final /* synthetic */ View f;
    public final /* synthetic */ HorizontalScrollView g;

    public n70(CategorySelectionActivity categorySelectionActivity, View view, HorizontalScrollView horizontalScrollView) {
        this.f = view;
        this.g = horizontalScrollView;
    }

    public void run() {
        int left = this.f.getLeft();
        this.f.getRight();
        this.g.getWidth();
        this.g.smoothScrollTo(left, 0);
    }
}
