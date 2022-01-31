package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    public long f = -1;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public final Runnable j = new m9(this);
    public final Runnable k = new o9(this);

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.j);
        removeCallbacks(this.k);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.j);
        removeCallbacks(this.k);
    }
}
