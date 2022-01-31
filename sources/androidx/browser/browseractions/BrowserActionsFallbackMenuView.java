package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.browser.R;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {
    public final int f = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_min_padding);
    public final int g = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_max_width);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f * 2), this.g), CommonUtils.BYTES_IN_A_GIGABYTE), i2);
    }
}
