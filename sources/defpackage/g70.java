package defpackage;

import android.view.View;
import android.widget.HorizontalScrollView;
import app.zophop.products.PassSelectionActivity;

/* renamed from: g70  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class g70 implements Runnable {
    public final /* synthetic */ View f;
    public final /* synthetic */ HorizontalScrollView g;

    public /* synthetic */ g70(View view, HorizontalScrollView horizontalScrollView) {
        this.f = view;
        this.g = horizontalScrollView;
    }

    public final void run() {
        View view = this.f;
        HorizontalScrollView horizontalScrollView = this.g;
        int i = PassSelectionActivity.n;
        n86.e(view, "$lView");
        int left = view.getLeft();
        if (horizontalScrollView != null) {
            horizontalScrollView.smoothScrollTo(left, 0);
        }
    }
}
