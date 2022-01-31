package app.zophop.utilities.external.fadingactionbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import app.zophop.utilities.R;

public class RootLayout extends FrameLayout {
    public View f;
    public View g;
    public boolean h = false;

    public RootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f == null) {
            this.f = findViewById(R.id.fab__header_container);
        }
        if (this.g == null) {
            this.g = findViewById(R.id.fab__listview_background);
        }
        View view = this.f;
        if (view == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (!this.h) {
            super.onLayout(z, i, i2, i3, i4);
            View view2 = this.g;
            if (view2 == null || view2.getTop() == this.f.getHeight()) {
                this.h = true;
            }
        } else {
            int top = view.getTop();
            View view3 = this.g;
            int i5 = 0;
            int top2 = view3 != null ? view3.getTop() : 0;
            super.onLayout(z, i, i2, i3, i4);
            int top3 = this.f.getTop();
            if (top3 != top) {
                this.f.offsetTopAndBottom(top - top3);
            }
            View view4 = this.g;
            if (view4 != null) {
                i5 = view4.getTop();
            }
            if (i5 != top2) {
                this.g.offsetTopAndBottom(top2 - i5);
            }
        }
    }
}
